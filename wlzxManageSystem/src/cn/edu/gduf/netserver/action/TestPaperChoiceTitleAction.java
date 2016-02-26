package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.IQuestionDao;
import cn.edu.gduf.netserver.dao.impl.QuestionDaoImpl;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.util.ResponseUtil;

public class TestPaperChoiceTitleAction implements Action{

	/**
	 * 设计试卷中的从题库选题
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IQuestionDao questionDao = new QuestionDaoImpl();
		String choice = request.getParameter("choice");
		// 点击从题库选题
		if ("1".equals(choice)){
			String questionType = request.getParameter("questionType");
			List<Question> questionList = questionDao.getQuestions(Integer.parseInt(questionType));
			
			JSONArray jsonArray = JSONArray.fromObject(questionList);
			try {
				ResponseUtil.write(jsonArray, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 选题后确定
		else if ("2".equals(choice)) {
			String questionId = request.getParameter("questionId");
			Question question = null;
			if (questionId != null) {
				question = questionDao.getQuestionById(Integer.parseInt(questionId));
			}
			JSONArray jsonArray = JSONArray.fromObject(question);
			try {
				ResponseUtil.write(jsonArray, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "";
	}

}
