package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.util.StringUtil;

public class TestPaperPreviewAction implements Action{

	/**
	 * 预览试卷
	 */
	@SuppressWarnings("null")
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Question question = null;
		List<Question> blankFillQuestions = new ArrayList<Question>();  // 所有填空题
		List<Question> singleQuestions = new ArrayList<Question>();  // 所有单选题
		List<Question> moreQuestions = new ArrayList<Question>();  // 所有多选题
		List<Question> judgeQuestions = new ArrayList<Question>();  // 所有判断题
		List<Question> shortAnswerQuestions = new ArrayList<Question>();  // 所有简答题
		
		String paperName = request.getParameter("paperTitle");  // 试卷标题
		try {
			paperName = new String(paperName.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String[] bfTitles = request.getParameterValues("blank-filling-title");  // 填空题题目
		
		String[] sTitles = request.getParameterValues("single-title");  // 单选题题目
		String[] sSectionA = request.getParameterValues("single-sectionA");  // 单选题选项A
		String[] sSectionB = request.getParameterValues("single-sectionB");  // 单选题选项B
		String[] sSectionC = request.getParameterValues("single-sectionC");  // 单选题选项C
		String[] sSectionD = request.getParameterValues("single-sectionD");  // 单选题选项D
		
		String[] mTitles = request.getParameterValues("multiple-title");  // 多选题题目
		String[] mSectionA = request.getParameterValues("multiple-sectionA");  // 多选题选项A
		String[] mSectionB = request.getParameterValues("multiple-sectionB");  // 多选题选项B
		String[] mSectionC = request.getParameterValues("multiple-sectionC");  // 多选题选项C
		String[] mSectionD = request.getParameterValues("multiple-sectionD");  // 多选题选项D
		String[] mSectionE = request.getParameterValues("multiple-sectionE");  // 多选题选项E
		
		String[] jTitles = request.getParameterValues("judge-title");  // 判断题目
		
		String[] saTitles = request.getParameterValues("short-answer-title");  // 简答题题目
		
		int i;
		// 将填空题添加到问题集
		for (i = 1; i < bfTitles.length; i++) {
			try {
				bfTitles[i] = new String(bfTitles[i].getBytes("ISO-8859-1"), "utf-8");
				question = new Question(bfTitles[i]);
				blankFillQuestions.add(question);
				System.out.println("预览试卷:填空题已加加进问题集");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 将单选题添加到问题集
		for (i = 1; i < sTitles.length; i++) {
			try {
				sTitles[i] = new String(sTitles[i].getBytes("ISO-8859-1"), "utf-8");
				sSectionA[i] = "A."+new String(sSectionA[i].getBytes("ISO-8859-1"), "utf-8");
				sSectionB[i] = "B."+new String(sSectionB[i].getBytes("ISO-8859-1"), "utf-8");
				sSectionC[i] = "C."+new String(sSectionC[i].getBytes("ISO-8859-1"), "utf-8");
				sSectionD[i] = "D."+new String(sSectionD[i].getBytes("ISO-8859-1"), "utf-8");
				question = new Question(sTitles[i], sSectionA[i], sSectionB[i], sSectionC[i], sSectionD[i], null);
				singleQuestions.add(question);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 将多选题添加到问题集
		for (i = 1; i < mTitles.length; i++) {
			try {
				mTitles[i] = new String(mTitles[i].getBytes("ISO-8859-1"), "utf-8");
				mSectionA[i] = "A."+new String(mSectionA[i].getBytes("ISO-8859-1"), "utf-8");
				mSectionB[i] = "B."+new String(mSectionB[i].getBytes("ISO-8859-1"), "utf-8");
				mSectionC[i] = "C."+new String(mSectionC[i].getBytes("ISO-8859-1"), "utf-8");
				mSectionD[i] = "D."+new String(mSectionD[i].getBytes("ISO-8859-1"), "utf-8");
				if (StringUtil.isNotEmpty(mSectionE[i])) {
					mSectionE[i] = "E."+new String(mSectionE[i].getBytes("ISO-8859-1"), "utf-8");
				}
				question = new Question(mTitles[i], mSectionA[i], mSectionB[i], mSectionC[i], mSectionD[i], mSectionE[i]);
				moreQuestions.add(question);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 将判断题添加到问题集
		for (i = 1; i < jTitles.length; i++) {
			try {
				jTitles[i] = new String(jTitles[i].getBytes("ISO-8859-1"), "utf-8");
				question = new Question(jTitles[i]);
				judgeQuestions.add(question);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// 将简答题添加到问题集
		for (i = 1; i < saTitles.length; i++) {
			try {
				saTitles[i] = new String(saTitles[i].getBytes("ISO-8859-1"), "utf-8");
				question = new Question(saTitles[i]);
				shortAnswerQuestions.add(question);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("paperName", paperName);
		request.setAttribute("blankFillQuestions", blankFillQuestions);
		request.setAttribute("singleQuestions", singleQuestions);
		request.setAttribute("moreQuestions", moreQuestions);
		request.setAttribute("judgeQuestions", judgeQuestions);
		request.setAttribute("shortAnswerQuestions", shortAnswerQuestions);
		
		return "testPaperPreview";
	}
}