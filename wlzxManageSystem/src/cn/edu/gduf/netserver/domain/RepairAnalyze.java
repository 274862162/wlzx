package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 报修单
 * @author cjy
 *
 */
public class RepairAnalyze {

	/**
	 * 报修时间
	 */
	private String repairTime;
	 
	/**
	 * 报修单状态
	 */
	private int status;
	/**
	 * 报修学生楼栋
	 */
	private String stuBuilding;
	
	/**
	 * 处理网管ID
	 */
	private int dutyPersonID;
	
	/**
	 * 统计数量
	 */
	private int count;
	
	public String getStuBuilding() {
		return stuBuilding;
	}


	public void setStuBuilding(String stuBuilding) {
		this.stuBuilding = stuBuilding;
	}



	public int getDutyPersonID() {
		return dutyPersonID;
	}


	public void setDutyPersonID(int dutyPersonID) {
		this.dutyPersonID = dutyPersonID;
	}


   public String getRepairTime() {
      return repairTime;
   }
   

   public void setRepairTime(String newRepairTime) {
      repairTime = newRepairTime;
   }
   
   public int getCount() {
	   return count;
   }


   public void setCount(int count) {
	   this.count = count;
   }


   public int getStatus() {
      return status;
   }
   
   public void setStatus(int newStatus) {
      status = newStatus;
   }
  

}