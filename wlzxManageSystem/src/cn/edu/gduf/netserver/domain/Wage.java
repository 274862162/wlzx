package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 工资单
 * @author tmn
 *
 */
public class Wage {
   private int payrollID;
   private String month;
   private double money;
   private Date createTime;
   private String reserved1;
   private String reserved2;
   
   public int getPayrollID() {
      return payrollID;
   }
   
   
   public void setPayrollID(int newPayrollID) {
      payrollID = newPayrollID;
   }
   
   
   public String getMonth() {
      return month;
   }
   
   
   public void setMonth(String newMonth) {
      month = newMonth;
   }
   
  
   public double getMoney() {
      return money;
   }
   
   
   public void setMoney(double newMoney) {
      money = newMoney;
   }
   
   
   public Date getCreateTime() {
      return createTime;
   }
   
   
   public void setCreateTime(Date newCreateTime) {
      createTime = newCreateTime;
   }
   
   
   public String getReserved1() {
      return reserved1;
   }
   
   
   public void setReserved1(String newReserved1) {
      reserved1 = newReserved1;
   }
   
  
   public String getReserved2() {
      return reserved2;
   }
   
   
   public void setReserved2(String newReserved2) {
      reserved2 = newReserved2;
   }

}