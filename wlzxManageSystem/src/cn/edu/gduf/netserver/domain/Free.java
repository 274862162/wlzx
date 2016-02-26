package cn.edu.gduf.netserver.domain;

/**
 * 具体无课时间段
 * @author Administrator
 *
 */
public class Free {

	private int freeID;
	private String onetwo;  // 第一二节的无课情况，0表示有课，1表示单周无课，2表示双周无课，3表示都无课
	private String threefour;
	private String five;
	private String sixseven;
	private String eight;
	private String nineten;
	private int userFreeTableID;
	private int weekID;  // 关联星期几
	
	public Free() {
		super();
	}
	
	public Free(String onetwo, String threefour, String five, String sixseven,
			String eight, String nineten, int userFreeTableID, int weekID) {
		super();
		this.onetwo = onetwo;
		this.threefour = threefour;
		this.five = five;
		this.sixseven = sixseven;
		this.eight = eight;
		this.nineten = nineten;
		this.userFreeTableID = userFreeTableID;
		this.weekID = weekID;
	}

	public int getFreeID() {
		return freeID;
	}
	public void setFreeID(int freeID) {
		this.freeID = freeID;
	}
	public String getOnetwo() {
		return onetwo;
	}
	public void setOnetwo(String onetwo) {
		this.onetwo = onetwo;
	}
	public String getThreefour() {
		return threefour;
	}
	public void setThreefour(String threefour) {
		this.threefour = threefour;
	}
	public String getFive() {
		return five;
	}
	public void setFive(String five) {
		this.five = five;
	}
	public String getSixseven() {
		return sixseven;
	}
	public void setSixseven(String sixseven) {
		this.sixseven = sixseven;
	}
	public String getEight() {
		return eight;
	}
	public void setEight(String eight) {
		this.eight = eight;
	}
	public String getNineten() {
		return nineten;
	}
	public void setNineten(String nineten) {
		this.nineten = nineten;
	}
	public int getUserFreeTableID() {
		return userFreeTableID;
	}
	public void setUserFreeTableID(int userFreeTableID) {
		this.userFreeTableID = userFreeTableID;
	}
	public int getWeekID() {
		return weekID;
	}
	public void setWeekID(int weekID) {
		this.weekID = weekID;
	}
	
	
}
