package cn.edu.gduf.netserver.domain;

/**
 * @author Wmj
 *存储用户的选择问题结果
 */
public class UserSelcSection {
	/**
	 * 问题ID
	 */
	private int questionID;
	/**
	 * 用户ID
	 */
	private int userID;
	/**
	 * 用户选择的选项
	 */
	private String userSelect;
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserSelect() {
		return userSelect;
	}
	public void setUserSelect(String userSelect) {
		this.userSelect = userSelect;
	}
	
}
