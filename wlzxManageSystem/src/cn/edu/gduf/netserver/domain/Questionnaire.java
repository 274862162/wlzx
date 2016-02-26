package cn.edu.gduf.netserver.domain;

import java.sql.Date;

/**
 * 问卷类
 * @author Wmj
 *
 */
public class Questionnaire {
	/**
	 * 问卷编号
	 * 自动增长
	 */
	private int ID;	
	/**
	 * 问卷标题
	 */
	private String quesnnTitle;
	/**
	 * 创建问卷时间
	 */
	private String quesnnTime;
	/**
	 * 问卷作者ID
	 */
	private int userID;
	/**
	 * 问卷状态（UNPUBLISHED 未发布 ，COLLECTING 收集中，FINISHED 已结束 ）
	 */
	private String qusnnStatus;
	public String getQusnnStatus() {
		return qusnnStatus;
	}
	public void setQusnnStatus(String qusnnStatus) {
		this.qusnnStatus = qusnnStatus;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getQuesnnTitle() {
		return quesnnTitle;
	}
	public void setQuesnnTitle(String quesnnTitle) {
		this.quesnnTitle = quesnnTitle;
	}
	public String getQuesnnTime() {
		return quesnnTime;
	}
	public void setQuesnnTime(String quesnnTime) {
		this.quesnnTime = quesnnTime;
	}

	

}