package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 权限类
 * @author cjy
 *
 */


public class Auth {
   
   private int authID;  //权限ID
   
   private String authName;   //权限名
   
   private String authDescription;  //权限描述
   
 
   public int getAuthID() {
      return authID;
   }
   

   public void setAuthID(int newAuthID) {
      authID = newAuthID;
   }
   
   
   public String getAuthName() {
      return authName;
   }
   
 
   public void setAuthName(String newAuthName) {
      authName = newAuthName;
   }
   
   
   public String getAuthDescription() {
      return authDescription;
   }
   
  
   public void setAuthDescription(String newAuthDescription) {
      authDescription = newAuthDescription;
   }

}