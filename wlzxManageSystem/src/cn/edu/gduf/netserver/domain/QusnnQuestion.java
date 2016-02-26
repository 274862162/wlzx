package cn.edu.gduf.netserver.domain;

public class QusnnQuestion {
	/**
	 * 问题ID
	 * 自动增长
	 */
	private int ID;
	/**
	 * 所属问卷的ID
	 */
	private int qusnID;
	public int getQusnID() {
		return qusnID;
	}
	public void setQusnID(int qusnID) {
		this.qusnID = qusnID;
	}
	/**
	 * 题目
	 */
	private String questionTitle;
	/**
	 * 选项A
	 */
	private String sectionA;
	/**
	 * 选项B
	 */
	private String sectionB;
	/**
	 * 选项C
	 */
	private String sectionC;
	/**
	 * 选项D
	 */
	private String sectionD;
	/**
	 * 选项E
	 */
	private String sectionE;
	/**
	 * 其他
	 */
	private String other;
	/**
	 * 题目类型
	 * 单选或多选“Multiple”or“SINGLE”
	 */
	private String questionType;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}
