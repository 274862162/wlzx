package cn.edu.gduf.netserver.domain;

/**
 * @author Wmj
 *
 */
public class QusnnList {
	/**
	 * 问卷ID
	 */
	private int qusnnID;
	public int getQusnnID() {
		return qusnnID;
	}
	public void setQusnnID(int qusnnID) {
		this.qusnnID = qusnnID;
	}
	/**
	 * 问卷标题
	 */
	private String quesnnTitle;
	/**
	 * 创建问卷时间
	 */
	private String quesnnTime;
	/**
	 * 问卷状态（UNPUBLISHED 未发布 ，COLLECTING 收集中，FINISHED 已结束 ）
	 */
	private String qusnnStatus;
	/**
	 * 收到问卷的份数
	 */
	private int receiveData;
	/**
	 * 问卷作者
	 */
	private String userID;
	/**
	 * 填写状态
	 */
	private String fillStatus;
	public String getFillStatus() {
		return fillStatus;
	}
	public void setFillStatus(String fillStatus) {
		this.fillStatus = fillStatus;
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
	public String getQusnnStatus() {
		return qusnnStatus;
	}
	public void setQusnnStatus(String qusnnStatus) {
		this.qusnnStatus = qusnnStatus;
	}
	public int getReceiveData() {
		return receiveData;
	}
	public void setReceiveData(int receiveData) {
		this.receiveData = receiveData;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
