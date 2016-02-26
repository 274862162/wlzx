package cn.edu.gduf.netserver.domain;

public class PayrollSet {
	private int id;
	private double allMoney;
	private double latePerMoney;
	private double noDutyPerMoney;
	private double isOverDueMoney;
	private double dutyPerMoney;
	private double otherAddMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private double otherThrowMoney;
	public double getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(double allMoney) {
		this.allMoney = allMoney;
	}
	public double getLatePerMoney() {
		return latePerMoney;
	}
	public void setLatePerMoney(double latePerMoney) {
		this.latePerMoney = latePerMoney;
	}
	public double getNoDutyPerMoney() {
		return noDutyPerMoney;
	}
	public void setNoDutyPerMoney(double noDutyPerMoney) {
		this.noDutyPerMoney = noDutyPerMoney;
	}
	public double getIsOverDueMoney() {
		return isOverDueMoney;
	}
	public void setIsOverDueMoney(double isOverDueMoney) {
		this.isOverDueMoney = isOverDueMoney;
	}
	public double getDutyPerMoney() {
		return dutyPerMoney;
	}
	public void setDutyPerMoney(double dutyPerMoney) {
		this.dutyPerMoney = dutyPerMoney;
	}
	public double getOtherAddMoney() {
		return otherAddMoney;
	}
	public void setOtherAddMoney(double otherAddMoney) {
		this.otherAddMoney = otherAddMoney;
	}
	public double getOtherThrowMoney() {
		return otherThrowMoney;
	}
	public void setOtherThrowMoney(double otherThrowMoney) {
		this.otherThrowMoney = otherThrowMoney;
	}
	
}
