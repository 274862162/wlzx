package cn.edu.gduf.netserver.domain;

/**
 * 选择题库类
 * @author hsg
 *
 */
public class Choices {

	private int choicesID;  // 选择id
	private int paperID;  // 试卷id
	private int questionID;  // 问题id
   
    public int getChoicesID() {
       return choicesID;
    }
    public void setChoicesID(int newChoicesID) {
       choicesID = newChoicesID;
    }
	public int getPaperID() {
		return paperID;
	}
	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
}