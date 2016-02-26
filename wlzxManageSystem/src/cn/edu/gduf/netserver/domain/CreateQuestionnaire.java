package cn.edu.gduf.netserver.domain;

/**问卷调查类
 * @author Wmj
 *表示问题与问卷的联系
 */
public class CreateQuestionnaire {
	/**
	 * 问题ID
	 */
	private int questionID;
	/**
	 * 问卷ID
	 */
	private int questionnaireID;
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public int getQuestionnaireID() {
		return questionnaireID;
	}
	public void setQuestionnaireID(int questionnaireID) {
		this.questionnaireID = questionnaireID;
	}
	
}
