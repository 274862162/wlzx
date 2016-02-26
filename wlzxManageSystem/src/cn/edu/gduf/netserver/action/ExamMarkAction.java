package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.ITestPaperDao;
import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.impl.ExamineDaoImpl;
import cn.edu.gduf.netserver.dao.impl.TestPaperDaoImpl;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;
import cn.edu.gduf.netserver.domain.Examine;
import cn.edu.gduf.netserver.domain.QuestionMark;
import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.domain.User;

public class ExamMarkAction implements Action{

	/**
	 * 考核评分（主观题：填空、简答）
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IExamineDao examineDao = new ExamineDaoImpl();
		IUserDao userDao = new UserDaoImpl();
		ITestPaperDao testPaperDao = new TestPaperDaoImpl();
		String examineID = request.getParameter("examineID");
		Examine s_examine = examineDao.getExamineById(Integer.parseInt(examineID));
		User user = userDao.getUserById(s_examine.getUserID());
		TestPaper testPaper = testPaperDao.getTestPaperById(s_examine.getPeperID());
		
		List<QuestionMark> questionMarks = (List<QuestionMark>) s_examine.getQuestionMarks();
		//List<Question> blankFillQuestions = new ArrayList<Question>();
		//List<Question> shortAnswerQuestions = new ArrayList<Question>();
		
		List<QuestionMark> blankFillQuestionMarks = new ArrayList<QuestionMark>();
		List<QuestionMark> shortAnswerQuestionMarks = new ArrayList<QuestionMark>();
		int blankFillScore = 0;
		int shortAnswerScore = 0;
		
		Iterator<QuestionMark> it = questionMarks.iterator();
		while (it.hasNext()) {
			QuestionMark qm = it.next();
			if (qm.getQuestion().getQuestionType() == 2) {  // 填空
				blankFillScore += qm.getQuestion().getPoint();
				blankFillQuestionMarks.add(qm);
			}else if (qm.getQuestion().getQuestionType() == 4){  // 简答
				shortAnswerScore += qm.getQuestion().getPoint();
				shortAnswerQuestionMarks.add(qm);
			}
		}
		request.setAttribute("examine", s_examine);
		request.setAttribute("testPaper", testPaper);
		request.setAttribute("blankFillQuestionMarks", blankFillQuestionMarks);
		request.setAttribute("shortAnswerQuestionMarks", shortAnswerQuestionMarks);
		request.setAttribute("blankFillScore", blankFillScore);
		request.setAttribute("shortAnswerScore", shortAnswerScore);
		request.setAttribute("user", user);
		return "examMark";
	}
}
