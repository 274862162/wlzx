package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ITestPaperDao;
import cn.edu.gduf.netserver.dao.impl.TestPaperDaoImpl;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.TestPaper;

public class ExamAction implements Action{

	/**
	 * 进行考核
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ITestPaperDao testPaperDao = new TestPaperDaoImpl();
		String testPaperID = request.getParameter("testPaperID");
		/*
		User user = (User) request.getSession().getAttribute("currentUser");
		int isExamined = examineDao.isExamined(user.getUserID(), Integer.parseInt(testPaperID));
		if (isExamined > 0) {
			request.setAttribute("examMsg", "你已参与过本次考核");
			return "examed";
		}
		*/
		
		TestPaper s_testPaper = testPaperDao.getTestPaperById(Integer.parseInt(testPaperID));
		
		int singleScore = 0;
		int moreScore = 0;
		int judgeScore = 0;
		int blankFillScore = 0;
		int shortAnswerScore = 0;
		List<Question> singleQuestions = new ArrayList<Question>();
		List<Question> moreQuestions = new ArrayList<Question>();
		List<Question> judgeQuestions = new ArrayList<Question>();
		List<Question> blankFillQuestions = new ArrayList<Question>();
		List<Question> shortAnswerQuestions = new ArrayList<Question>();
		List<Question> questions = s_testPaper.getQuestions();
		Iterator<Question> it = questions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			if (q.getQuestionType() == 0) {  // 单选题
				singleQuestions.add(q);
			}else if(q.getQuestionType() == 1){  // 多选
				moreQuestions.add(q);
			}else if(q.getQuestionType() == 2){  // 填空
				blankFillQuestions.add(q);
			}else if(q.getQuestionType() == 3){  // 判断
				judgeQuestions.add(q);
			}else if(q.getQuestionType() == 4){  // 简答
				shortAnswerQuestions.add(q);
			}
		}
		
		it = singleQuestions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			singleScore += q.getPoint();
		}
		it = moreQuestions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			moreScore += q.getPoint();
		}
		it = blankFillQuestions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			blankFillScore += q.getPoint();
		}
		it = judgeQuestions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			judgeScore += q.getPoint();
		}
		it = shortAnswerQuestions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			shortAnswerScore += q.getPoint();
		}
		request.setAttribute("singleScore", singleScore);
		request.setAttribute("moreScore", moreScore);
		request.setAttribute("blankFillScore", blankFillScore);
		request.setAttribute("judgeScore", judgeScore);
		request.setAttribute("shortAnswerScore", shortAnswerScore);
		request.setAttribute("singleQuestions", singleQuestions);
		request.setAttribute("moreQuestions", moreQuestions);
		request.setAttribute("blankFillQuestions", blankFillQuestions);
		request.setAttribute("judgeQuestions", judgeQuestions);
		request.setAttribute("shortAnswerQuestions", shortAnswerQuestions);
		request.setAttribute("testPaper", s_testPaper);
		return "exam";
	}
}
