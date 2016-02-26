package cn.edu.gduf.netserver.domain;
/**
 * 物品信息
 * @author cjy
 *
 */
public class Hold_items {
	int itemID;//物品ID
	int userID;//用户ID
	int number;//数量
	String reserved1;
	String reserved2;
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
