package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 报修单
 * @author tmn
 *
 */

public class RepairList {
 /**
 * 报修单ID
 */
private int repairListID;
   /**
 * 报修时间
 */
private String repairTime;
   /**
 * 预约时间
 */
private String appointmentTime;
   /**
 * 联系电话
 */
private String telephone;
   /**
 * 故障类型
 */
private String faultType;
   /**
 * 客户端提示
 */
private String clientCode;
   /**
 * 错误代码
 */
private String errorCode;
   /**
 * 问题描述
 */
private String description;
   /**
 * 报修单状态
 */
private int status;
   /**
 * 处理时间
 */
private String dealingTime;
   /**
 * 评价
 */
private String evaluation;
   /**
 * 评价时间
 */
private String evaluateTime;
/**
 * 报修学生学号
 */
private String stuSno;
/**
 * 报修学生姓名
 */
private String stuName;
/**
 * 报修学生楼栋
 */
private String stuBuilding;
/**
 * 报修学生房间号
 */
private String stuRoom;
public String getStuBuilding() {
	return stuBuilding;
}


public void setStuBuilding(String stuBuilding) {
	this.stuBuilding = stuBuilding;
}


public String getStuRoom() {
	return stuRoom;
}


public void setStuRoom(String stuRoom) {
	this.stuRoom = stuRoom;
}


/**
 * 处理网管ID
 */
private int dutyPersonID;
/**
 * 预约备注
 */
private String appointmentText;
/**
 * 网管处理说明
 */
private String dealingText;
/**
 * 存储报修单的报修天数
 */
private int isOverdue;
public int getIsOverdue() {
	return isOverdue;
}


public void setIsOverdue(int isOverdue) {
	this.isOverdue = isOverdue;
}


public String getDealingText() {
	return dealingText;
}


public void setDealingText(String dealingText) {
	this.dealingText = dealingText;
}


public String getAppointmentText() {
	return appointmentText;
}


public void setAppointmentText(String appointmentText) {
	this.appointmentText = appointmentText;
}


public String getStuSno() {
	return stuSno;
}


public void setStuSno(String stuSno) {
	this.stuSno = stuSno;
}


public String getStuName() {
	return stuName;
}


public void setStuName(String stuName) {
	this.stuName = stuName;
}


public int getDutyPersonID() {
	return dutyPersonID;
}


public void setDutyPersonID(int dutyPersonID) {
	this.dutyPersonID = dutyPersonID;
}
   public int getRepairListID() {
      return repairListID;
   }
   

   public void setRepairListID(int newRepairListID) {
      repairListID = newRepairListID;
   }
   

   public String getRepairTime() {
      return repairTime;
   }
   

   public void setRepairTime(String newRepairTime) {
      repairTime = newRepairTime;
   }
   

   public String getAppointmentTime() {
      return appointmentTime;
   }
   

   public void setAppointmentTime(String newAppointmentTime) {
      appointmentTime = newAppointmentTime;
   }
   

   public String getTelephone() {
      return telephone;
   }
   

   public void setTelephone(String newTelephone) {
      telephone = newTelephone;
   }
   

   public String getFaultType() {
      return faultType;
   }
   

   public void setFaultType(String newFaultType) {
      faultType = newFaultType;
   }
   

   public String getClientCode() {
      return clientCode;
   }
   

   public void setClientCode(String newClientCode) {
      clientCode = newClientCode;
   }
   

   public String getErrorCode() {
      return errorCode;
   }
   

   public void setErrorCode(String newErrorCode) {
      errorCode = newErrorCode;
   }
   

   public String getDescription() {
      return description;
   }
   

   public void setDescription(String newDescription) {
      description = newDescription;
   }
   

   public int getStatus() {
      return status;
   }
   

   public void setStatus(int newStatus) {
      status = newStatus;
   }
   

   public String getDealingTime() {
      return dealingTime;
   }
   

   public void setDealingTime(String newDealingTime) {
      dealingTime = newDealingTime;
   }
   

   public String getEvaluation() {
      return evaluation;
   }
   

   public void setEvaluation(String newEvaluation) {
      evaluation = newEvaluation;
   }
   

   public String getEvaluateTime() {
      return evaluateTime;
   }
   

   public void setEvaluateTime(String newEvaluateTime) {
      evaluateTime = newEvaluateTime;
   }

}