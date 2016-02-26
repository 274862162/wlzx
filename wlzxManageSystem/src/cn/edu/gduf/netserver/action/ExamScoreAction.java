package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.IQuestionMarkDao;
import cn.edu.gduf.netserver.dao.impl.ExamineDaoImpl;
import cn.edu.gduf.netserver.dao.impl.QuestionMarkDaoImpl;
import cn.edu.gduf.netserver.domain.Examine;

public class ExamScoreAction implements Action{

	/**
	 * 提交批改，得出总分
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IExamineDao examineDao = new ExamineDaoImpl();
		IQuestionMarkDao questionMarkDao = new QuestionMarkDaoImpl();
		String examineID = request.getParameter("examineID");
		
		Map<String, String[]> keyMap = request.getParameterMap();
		Iterator<Entry<String,String[]>> it = keyMap.entrySet().iterator();
		int blankFillScore = 0;  // 填空题得分
		int shortAnswerScore = 0;  // 简答题得分
		
		try {
			// 保存答案， 计算客观题得分
			while(it.hasNext()){
				Entry<String,String[]> entry = it.next();
				String keyStr = entry.getKey();  // 提交的数据的name（例：id-b-${qm.questionMarkID}）
				String values[] = entry.getValue();  // 评分的值
				String key = "";  // questionMarkID
				if(keyStr.equals("examineID")||keyStr.equals("action")||keyStr.equals("page")){
					continue;  // 过滤掉
				}
				key = keyStr.split("-")[2];  // questionMarkID
				questionMarkDao.updateQuestionMarkById(Integer.parseInt(key), Integer.parseInt(values[0]));  // 更新该题得分
				if(keyStr.split("-")[1].equals("b")){ // 填空题
					blankFillScore += Integer.parseInt(values[0]);
				}else if(keyStr.split("-")[1].equals("sa")){  // 简答题
					shortAnswerScore += Integer.parseInt(values[0]);
				}
			}	
			Examine oldExamine = examineDao.getExamineById(Integer.parseInt(examineID));
			// 更新一条考核记录
			Examine examine = new Examine(Integer.parseInt(examineID), oldExamine.getSingleScore(), oldExamine.getMoreScore(), oldExamine.getJudgeScore(), blankFillScore, shortAnswerScore);
			examineDao.updateExamine(examine);
			System.out.println("分数成功记入数据库");
			examine = examineDao.getExamineById(Integer.parseInt(examineID));
			System.out.println("总分是："+examine.getScore());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "examScore";
	}
}
