package cn.edu.gduf.netserver.domain;

import java.util.*;
/**
 * 值班签到
 * @author cjy
 *
 */


public class Sign {
 
   private int signID;  //ID
   
   private int userID;
 
   private Date signTime;  //签到时间
   
   private boolean isLate; //是否迟到
   
   
   public int getSignID() {
      return signID;
   }
   

   public void setSignID(int newSignID) {
      signID = newSignID;
   }
   
 
   public int getUserID() {
	   return userID;
   }


   public void setUserID(int userID) {
	   this.userID = userID;
   }


   public Date getSignTime() {
      return signTime;
   }
   
   
   public void setSignTime(Date newSignTime) {
      signTime = newSignTime;
   }
   
   
   public boolean getIsLate() {
      return isLate;
   }
   

   public void setIsLate(boolean newIsLate) {
      isLate = newIsLate;
   }

}