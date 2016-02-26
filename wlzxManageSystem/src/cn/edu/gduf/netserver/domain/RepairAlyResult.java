package cn.edu.gduf.netserver.domain;

public class RepairAlyResult {
	/**
	 * 统计时间
	 */
	private String time;
	/**
	 * 总报修单
	 */
	private int allRepairListNum;
	/**
	 * 过期报修单数目
	 */
	private int overDueNum;
	/**
	 * 本人处理数目
	 */
	private int dealByMyself;
	/**
	 * 未处理数目
	 */
	private int noDeal;
	/**
	 * 评分统计
	 */
	private String evaluAly;
	/**
	 * 网管
	 */
	private String dutyPerson;
	public int getNoDeal() {
		return noDeal;
	}
	public void setNoDeal(int noDeal) {
		this.noDeal = noDeal;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAllRepairListNum() {
		return allRepairListNum;
	}
	public void setAllRepairListNum(int allRepairListNum) {
		this.allRepairListNum = allRepairListNum;
	}
	public int getOverDueNum() {
		return overDueNum;
	}
	public void setOverDueNum(int overDueNum) {
		this.overDueNum = overDueNum;
	}
	public int getDealByMyself() {
		return dealByMyself;
	}
	public void setDealByMyself(int dealByMyself) {
		this.dealByMyself = dealByMyself;
	}
	public String getEvaluAly() {
		return evaluAly;
	}
	public void setEvaluAly(String evaluAly) {
		this.evaluAly = evaluAly;
	}
	public String getDutyPerson() {
		return dutyPerson;
	}
	public void setDutyPerson(String dutyPerson) {
		this.dutyPerson = dutyPerson;
	}
}
