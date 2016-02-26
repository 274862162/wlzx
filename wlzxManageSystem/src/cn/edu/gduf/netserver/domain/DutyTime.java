package cn.edu.gduf.netserver.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 值班时间类
 * @author Hsg
 *
 */
public class DutyTime {

	private String time;  // 值班段
	private List<User> freeUsers = new ArrayList<User>();  // 该时间段无课的人
	private List<User> dutyUsers = new ArrayList<User>();  // 该时间段值班的人员
	
	public DutyTime(){}
	
	public DutyTime(String time) {
		super();
		this.time = time;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<User> getFreeUsers() {
		return freeUsers;
	}
	public void setFreeUsers(List<User> freeUsers) {
		this.freeUsers = freeUsers;
	}

	public List<User> getDutyUsers() {
		return dutyUsers;
	}

	public void setDutyUsers(List<User> dutyUsers) {
		this.dutyUsers = dutyUsers;
	}
}
