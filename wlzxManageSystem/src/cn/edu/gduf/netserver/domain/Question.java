package cn.edu.gduf.netserver.domain;

import java.util.Date;

/**
 * 题库类
 * @author hsg
 *
 */
public class Question {

    private int questionID;  // 问题ID
    private Date joinTime;  // 该题加入的时间
    private int questionType;  // 问题类型
    private String questionTitle;  // 问题题目
    private String sectionA;  // 选项A
    private String sectionB;  // 选项B
    private String sectionC;  // 选项C
    private String sectionD;  // 选项D
    private String sectionE;  // 选项E
    private String answer;  // 答案
    private String analysis;  // 答案解释
    private int point;  // 问题分值
    
    private String exist;  // 题库中是否存在该题的标志，0表示不存在，1表示已存在
    
	public Question() {
		super();
	}
	
	public Question(String questionTitle) {
		super();
		this.questionTitle = questionTitle;
	}

	public Question(String questionTitle, String sectionA, String sectionB,
			String sectionC, String sectionD, String sectionE) {
		super();
		this.questionTitle = questionTitle;
		this.sectionA = sectionA;
		this.sectionB = sectionB;
		this.sectionC = sectionC;
		this.sectionD = sectionD;
		this.sectionE = sectionE;
	}

	public Question(int questionType, String questionTitle, String answer,
			String analysis, int point) {
		super();
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.answer = answer;
		this.analysis = analysis;
		this.point = point;
	}
	
	public Question(int questionType, String questionTitle, String sectionA,
			String sectionB, String sectionC, String sectionD, String sectionE,
			String answer, String analysis, int point) {
		super();
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.sectionA = sectionA;
		this.sectionB = sectionB;
		this.sectionC = sectionC;
		this.sectionD = sectionD;
		this.sectionE = sectionE;
		this.answer = answer;
		this.analysis = analysis;
		this.point = point;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public int getQuestionType() {
		return questionType;
	}
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getSectionA() {
		return sectionA;
	}
	public void setSectionA(String sectionA) {
		this.sectionA = sectionA;
	}
	public String getSectionB() {
		return sectionB;
	}
	public void setSectionB(String sectionB) {
		this.sectionB = sectionB;
	}
	public String getSectionC() {
		return sectionC;
	}
	public void setSectionC(String sectionC) {
		this.sectionC = sectionC;
	}
	public String getSectionD() {
		return sectionD;
	}
	public void setSectionD(String sectionD) {
		this.sectionD = sectionD;
	}
	public String getSectionE() {
		return sectionE;
	}
	public void setSectionE(String sectionE) {
		this.sectionE = sectionE;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getExist() {
		return exist;
	}
	public void setExist(String exist) {
		this.exist = exist;
	}
}