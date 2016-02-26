package cn.edu.gduf.netserver.domain;

import java.util.Date;

/**
 * 记录哪个用户填写了哪张无课表的类
 * @author Hsg
 *
 */
public class UserFreeTable {

	private int userFreeTableID;
	private Date date;
	private int freeTableID;
	private int userID;
	
	public UserFreeTable() {
		super();
	}
	
	public UserFreeTable(Date date, int freeTableID, int userID) {
		super();
		this.date = date;
		this.freeTableID = freeTableID;
		this.userID = userID;
	}
	
	public int getUserFreeTableID() {
		return userFreeTableID;
	}
	public void setUserFreeTableID(int userFreeTableID) {
		this.userFreeTableID = userFreeTableID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFreeTableID() {
		return freeTableID;
	}
	public void setFreeTableID(int freeTableID) {
		this.freeTableID = freeTableID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
