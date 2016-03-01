package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 楼栋区域类
 * @author cjy
 *
 */


public class Area {
   
   private int areaID;  //区域ID
   
   private int userID;   //用户ID
   
   private String areaName;  //区域名称
   
   private String userName;
   
 
   public int getAreaID() {
      return areaID;
   }
   

   public void setAreaID(int newAreaID) {
      areaID = newAreaID;
   }
   
   
   public String getAreaName() {
      return areaName;
   }
   
 
   public void setAreaName(String newAreaName) {
      areaName = newAreaName;
   }
   
   
   public int getUserID() {
      return userID;
   }
   
  
   public void setUserID(int newUserID) {
      userID = newUserID;
   }


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}