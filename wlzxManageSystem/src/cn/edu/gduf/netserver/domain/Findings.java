package cn.edu.gduf.netserver.domain;

/**
 * 调查问卷选择问题的结果类
 * @author Wmj
 *
 */
public class Findings {
	private int quesID;  // 问题
	private String quesTitle;//问题题目
	public String getQuesTitle() {
		return quesTitle;
	}
	public void setQuesTitle(String quesTitle) {
		this.quesTitle = quesTitle;
	}
	private int selectNumA;  // 选项A选择人数
	private String selectNameA;  // 选择选项A人姓名
	
	private int selectNumB;  // 选项B选择人数
	private String selectNameB;  // 选择选项B人姓名

	private int selectNumC;  // 选项C选择人数
	private String selectNameC;  // 选择选项C人姓名

	private int selectNumD;  // 选项D选择人数
	private String selectNameD;  // 选择选项D人姓名

	private int selectNumE;  // 选项E选择人数
	private String selectNameE;  // 选择选项E人姓名
	public int getQuesID() {
		return quesID;
	}
	public void setQuesID(int quesID) {
		this.quesID = quesID;
	}
	public int getSelectNumA() {
		return selectNumA;
	}
	public void setSelectNumA(int selectNumA) {
		this.selectNumA = selectNumA;
	}
	public String getSelectNameA() {
		return selectNameA;
	}
	public void setSelectNameA(String selectNameA) {
		this.selectNameA = selectNameA;
	}
	public int getSelectNumB() {
		return selectNumB;
	}
	public void setSelectNumB(int selectNumB) {
		this.selectNumB = selectNumB;
	}
	public String getSelectNameB() {
		return selectNameB;
	}
	public void setSelectNameB(String selectNameB) {
		this.selectNameB = selectNameB;
	}
	public int getSelectNumC() {
		return selectNumC;
	}
	public void setSelectNumC(int selectNumC) {
		this.selectNumC = selectNumC;
	}
	public String getSelectNameC() {
		return selectNameC;
	}
	public void setSelectNameC(String selectNameC) {
		this.selectNameC = selectNameC;
	}
	public int getSelectNumD() {
		return selectNumD;
	}
	public void setSelectNumD(int selectNumD) {
		this.selectNumD = selectNumD;
	}
	public String getSelectNameD() {
		return selectNameD;
	}
	public void setSelectNameD(String selectNameD) {
		this.selectNameD = selectNameD;
	}
	public int getSelectNumE() {
		return selectNumE;
	}
	public void setSelectNumE(int selectNumE) {
		this.selectNumE = selectNumE;
	}
	public String getSelectNameE() {
		return selectNameE;
	}
	public void setSelectNameE(String selectNameE) {
		this.selectNameE = selectNameE;
	}




}