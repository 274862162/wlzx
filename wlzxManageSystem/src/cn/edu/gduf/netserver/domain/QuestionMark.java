package cn.edu.gduf.netserver.domain;

/**
 * 问题评分类
 * @author hsg
 *
 */
public class QuestionMark {

	private int questionMarkID;
	private int examineID;  // 哪个考核
	private int questionID;  // 哪个问题
	private String answer;
	private int mark;  // 得分

	Question question = new Question();  // questionID对应的问题（没映射到数据库）
	
	public QuestionMark() {
		super();
	}
	
	public QuestionMark(int examineID, int questionID, String answer) {
		super();
		this.examineID = examineID;
		this.questionID = questionID;
		this.answer = answer;
	}
	
	public QuestionMark(int examineID, int questionID, String answer, int mark) {
		super();
		this.examineID = examineID;
		this.questionID = questionID;
		this.answer = answer;
		this.mark = mark;
	}

	public int getQuestionMarkID() {
		return questionMarkID;
	}
	public void setQuestionMarkID(int questionMarkID) {
		this.questionMarkID = questionMarkID;
	}
	public int getExamineID() {
		return examineID;
	}
	public void setExamineID(int examineID) {
		this.examineID = examineID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
