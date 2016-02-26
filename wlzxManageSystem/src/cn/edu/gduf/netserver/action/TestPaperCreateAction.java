package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IQuestionDao;
import cn.edu.gduf.netserver.dao.ITestPaperDao;
import cn.edu.gduf.netserver.dao.impl.QuestionDaoImpl;
import cn.edu.gduf.netserver.dao.impl.TestPaperDaoImpl;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.TestPaper;

public class TestPaperCreateAction implements Action{

	/**
	 * 生成试卷
	 */
	@SuppressWarnings("null")
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IQuestionDao questionDao = new QuestionDaoImpl();
		ITestPaperDao testPaperDao = new TestPaperDaoImpl();
		List<Question> questions = new ArrayList<Question>();  // 要加进题库的所有题目
		Question question;  // 要加进题库的题目
		String qTitle = null;  // 问题题目
		String qAnwser = null;  // 问题答案
		String qAnalysis = null;  // 问题解析
		String qSectionA = null;  // 选择题的选项A
		String qSectionB = null;  // 选择题的选项B
		String qSectionC = null;  // 选择题的选项C
		String qSectionD = null;  // 选择题的选项D
		String qSectionE = null;  // 选择题的选项E
		String qPoint = null;  // 问题分值
		String paperName = request.getParameter("paperTitle");  // 试卷标题
		try {
			paperName = new String(paperName.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String[] bfTitles = request.getParameterValues("blank-filling-title");  // 填空题题目
		String[] bfAnwsers = request.getParameterValues("blank-filling-answer");  // 填空题答案
		//String[] bfAnalysis = request.getParameterValues("blank-filling-analysis");  // 填空题解析
		
		String[] sTitles = request.getParameterValues("single-title");  // 单选题题目
		String[] sSectionA = request.getParameterValues("single-sectionA");  // 单选题选项A
		String[] sSectionB = request.getParameterValues("single-sectionB");  // 单选题选项B
		String[] sSectionC = request.getParameterValues("single-sectionC");  // 单选题选项C
		String[] sSectionD = request.getParameterValues("single-sectionD");  // 单选题选项D
		//String[] sAnalysis = request.getParameterValues("single-analysis");  // 单选题解析
		
		String[] mTitles = request.getParameterValues("multiple-title");  // 多选题题目
		String[] mAnwsers = null;  // 多选题答案
		String[] mSectionA = request.getParameterValues("multiple-sectionA");  // 多选题选项A
		String[] mSectionB = request.getParameterValues("multiple-sectionB");  // 多选题选项B
		String[] mSectionC = request.getParameterValues("multiple-sectionC");  // 多选题选项C
		String[] mSectionD = request.getParameterValues("multiple-sectionD");  // 多选题选项D
		String[] mSectionE = request.getParameterValues("multiple-sectionE");  // 多选题选项E
		//String[] mAnalysis = request.getParameterValues("multiple-analysis");  // 多选题解析
		
		String[] jTitles = request.getParameterValues("judge-title");  // 判断题目
		//String[] jAnalysis = request.getParameterValues("judge-analysis");  // 判断题解析
		
		String[] saTitles = request.getParameterValues("short-answer-title");  // 简答题题目
		String[] saAnwsers = request.getParameterValues("short-answer-answer");  // 简答题答案
		String[] point = request.getParameterValues("short-answer-point");  // 简答题分值
		String[] isExist = request.getParameterValues("isExist");  // 题库是否存在该题的标志
		
		int i;
		// 将填空题添加到问题集，因为有一个出题的模板是不用提交数据的，所以i从1开始
		for (i = 1; i < bfTitles.length; i++) {
			try {
				qTitle = new String(bfTitles[i].getBytes("ISO-8859-1"), "utf-8");
				qAnwser = new String(bfAnwsers[i].getBytes("ISO-8859-1"), "utf-8");
				//qAnalysis = new String(bfAnalysis[i].getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("填空题目："+qTitle+", 答案："+qAnwser);
			question = new Question(2, qTitle, qAnwser, qAnalysis, 2);
			question.setExist(isExist[i]);
			questions.add(question);
			qAnwser = null;
		}

		// 将单选题添加到问题集
		for (i = 1; i < sTitles.length; i++) {
			try {
				qTitle = new String(sTitles[i].getBytes("ISO-8859-1"), "utf-8");
				qAnwser = request.getParameter("single-answer"+i);
				// 当前台的radio设置为disabled时，传到后台的数据是null，但因为这是题库里已有的题，所以也不需要其答案
				if (qAnwser != null) {
					qSectionA = "A."+new String(sSectionA[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionB = "B."+new String(sSectionB[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionC = "C."+new String(sSectionC[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionD = "D."+new String(sSectionD[i].getBytes("ISO-8859-1"), "utf-8");
					//qAnalysis = new String(sAnalysis[i].getBytes("ISO-8859-1"), "utf-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("单选题目："+qTitle+", 答案："+qAnwser);
			question = new Question(0, qTitle, qSectionA, qSectionB, qSectionC, qSectionD, qSectionE, qAnwser, qAnalysis, 2);
			question.setExist(isExist[i+bfTitles.length]);
			questions.add(question);
			qAnwser = null;
		}
		
		// 将多选题添加到问题集
		for (i = 1; i < mTitles.length; i++) {
			try {
				qTitle = new String(mTitles[i].getBytes("ISO-8859-1"), "utf-8");
				mAnwsers = request.getParameterValues("multiple-answer"+i);
				// 同上面的单选题
				if (mAnwsers != null) {
					for (int j = 0; j < mAnwsers.length; j++) {
						qAnwser += mAnwsers[j]+",";  // 拼接多选题答案
					}
					qAnwser = qAnwser.substring(4, qAnwser.length()-1);  // 从4开始是要去掉前面的null
					qSectionA = "A."+new String(mSectionA[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionB = "B."+new String(mSectionB[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionC = "C."+new String(mSectionC[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionD = "D."+new String(mSectionD[i].getBytes("ISO-8859-1"), "utf-8");
					qSectionE = "E."+new String(mSectionE[i].getBytes("ISO-8859-1"), "utf-8");
					//qAnalysis = new String(mAnalysis[i].getBytes("ISO-8859-1"), "utf-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("多选题目："+qTitle+", 答案："+qAnwser);
			question = new Question(1, qTitle, qSectionA, qSectionB, qSectionC, qSectionD, qSectionE, qAnwser, qAnalysis, 3);
			question.setExist(isExist[i + bfTitles.length + sTitles.length]);
			questions.add(question);
			qAnwser = null;
		}
		
		// 将判断题添加到问题集
		for (i = 1; i < jTitles.length; i++) {
			try {
				qTitle = new String(jTitles[i].getBytes("ISO-8859-1"), "utf-8");
				qAnwser = request.getParameter("judge-answer"+i);
				//qAnalysis = new String(jAnalysis[i].getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("判断题目："+qTitle+", 答案："+qAnwser);
			question = new Question(3, qTitle, qAnwser, qAnalysis, 2);
			question.setExist(isExist[i + bfTitles.length + sTitles.length + mTitles.length]);
			questions.add(question);
			qAnwser = null;
		}
		
		// 将简答题添加到问题集
		for (i = 1; i < saTitles.length; i++) {
			try {
				qTitle = new String(saTitles[i].getBytes("ISO-8859-1"), "utf-8");
				qAnwser = new String(saAnwsers[i].getBytes("ISO-8859-1"), "utf-8");
				qPoint = point[i];
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("简答题目："+qTitle+", 答案："+qAnwser);
			question = new Question(4, qTitle, qAnwser, qAnalysis, Integer.parseInt(qPoint));  // 简答题分值由出卷人决定
			question.setExist(isExist[i + bfTitles.length + sTitles.length + mTitles.length + jTitles.length]);
			questions.add(question);
			qAnwser = null;
		}
		
		try {
			questionDao.addQuestion(questions);  // 新增题目加进题库表
			System.out.println("所有新增的题目已存进题库");
			testPaperDao.addTestPaper(paperName);  // 新增试卷加进试卷表
			System.out.println("试卷已加入数据库");
			TestPaper testPaper = new TestPaper(paperName, questions);
			testPaperDao.addChoice(testPaper);
			System.out.println("试卷与问题的关联已加入数据库");  // 存试卷与题目的关联
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "testPaperCreate";
	}

}
