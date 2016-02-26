package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.IQuestionDao;
import cn.edu.gduf.netserver.dao.IQuestionMarkDao;
import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.impl.ExamineDaoImpl;
import cn.edu.gduf.netserver.dao.impl.QuestionDaoImpl;
import cn.edu.gduf.netserver.dao.impl.QuestionMarkDaoImpl;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;
import cn.edu.gduf.netserver.domain.Examine;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.QuestionMark;
import cn.edu.gduf.netserver.domain.User;

public class ExamSubmitAction implements Action{

	/**
	 * 提交考核（选择题、判断题得分系统自动计算）
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IUserDao userDao = new UserDaoImpl();
		IExamineDao examineDao = new ExamineDaoImpl();
		IQuestionMarkDao questionMarkDao = new QuestionMarkDaoImpl();
		String userID = request.getParameter("userID");
		String testPaperID = request.getParameter("testPaperID");

		Map<String, String[]> keyMap = request.getParameterMap();
		Iterator<Entry<String,String[]>> it = keyMap.entrySet().iterator();
		int singleScore = 0;  // 单选题得分
		int moreScore = 0;  // 多选题得分
		int judgeScore = 0;  // 判断题得分
		
		try {
			// 添加一条考核记录
			Examine examine = new Examine(Integer.parseInt(userID), Integer.parseInt(testPaperID), new Date());
			int saveNum = examineDao.addExamine(examine);
			if (saveNum > 0) {  // 提交考核成功	
				User user = userDao.getUserById(Integer.parseInt(userID));
				examine.setUser(user);
				
				// 保存答案， 计算客观题得分
				while(it.hasNext()){
					Entry<String,String[]> entry = it.next();
					String keyStr = entry.getKey();  // 提交的数据的name（例：id-s-${q.questionID}）
					String values[] = entry.getValue();  // 数据的值，多选题的话就多个值
					String key = "";  // 问题的ID
					String value = "";  // 用户的答案
					if(keyStr.equals("userID")||keyStr.equals("testPaperID")||keyStr.equals("action")){
						continue;  // 过滤掉
					}
					if(keyStr.split("-")[1].equals("s")){  // 单选题
						key = keyStr.split("-")[2];  // 得到问题ID
						value = values[0];  // 单选题答案
						singleScore += this.calScore(Integer.parseInt(key), value, "0");
					}else if(keyStr.split("-")[1].equals("m")){  // 多选题
						key = keyStr.split("-")[2];  // 得到问题ID
						for(String s:values){
							value += s+",";  // 数据库中多选题的答案是以“,”隔开的
						}
						value = value.substring(0, value.length()-1);
						moreScore += this.calScore(Integer.parseInt(key), value, "1");
					}else if(keyStr.split("-")[1].equals("j")){  // 判断题
						key = keyStr.split("-")[2];  // 得到问题ID
						value = values[0];  // 判断题答案
						judgeScore += this.calScore(Integer.parseInt(key), value, "3");
					}else if(keyStr.split("-")[1].equals("b")||keyStr.split("-")[1].equals("sa")){  // 填空题和简答题
						key = keyStr.split("-")[2];  // 得到问题ID
						value = values[0];  // 学生答案 
						value = new String(value.getBytes("ISO-8859-1"),"utf-8");
					}
					QuestionMark questionMark = new QuestionMark(examineDao.getMaxExamineId(), Integer.parseInt(key), value);
					questionMarkDao.addQuestionMark(questionMark);
				}
				
				// 保存客观题得分（选择、判断）
				examineDao.savePartScore(examineDao.getMaxExamineId(), singleScore, moreScore, judgeScore);
				request.setAttribute("examine", examine);
				System.out.print("成功提交考核");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "examSubmit";
	}

	/**
	 * 根据questionID判断用户答案是否正确，并返回分值
	 * @param questionID
	 * @param userAnswer
	 * @param type
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	private int calScore(int questionID, String userAnswer, String type) throws SQLException, ParseException{
		IQuestionDao questionDao = new QuestionDaoImpl();
		Question question = questionDao.getQuestionById(questionID);
		if(userAnswer.equals(question.getAnswer())){
			if("0".equals(type)){
				return questionDao.getPointByQuestionType(0);  // 单选题一题的分值
			}else if ("1".equals(type)) {
				return questionDao.getPointByQuestionType(1);  // 多选题一题的分值
			}else{
				return questionDao.getPointByQuestionType(3);  // 判断题一题的分值
			}
		}else{
			return 0;
		}
	}
}
