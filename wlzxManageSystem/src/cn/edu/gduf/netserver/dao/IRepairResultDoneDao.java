package cn.edu.gduf.netserver.dao;

public class IRepairResultDoneDao {
	/**
	 * 已处理的报修单的数目
	 */
	private int done;
	/**
	 * 未处理的报修单数目
	 */
	private int noDone;
	private int gotA;
	private int gotB;
	private int gotC;
	public int getGotA() {
		return gotA;
	}
	public void setGotA(int gotA) {
		this.gotA = gotA;
	}
	public int getGotB() {
		return gotB;
	}
	public void setGotB(int gotB) {
		this.gotB = gotB;
	}
	public int getGotC() {
		return gotC;
	}
	public void setGotC(int gotC) {
		this.gotC = gotC;
	}
	public int getGotD() {
		return gotD;
	}
	public void setGotD(int gotD) {
		this.gotD = gotD;
	}
	private int gotD;
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}
	public int getNoDone() {
		return noDone;
	}
	public void setNoDone(int noDone) {
		this.noDone = noDone;
	}
}
