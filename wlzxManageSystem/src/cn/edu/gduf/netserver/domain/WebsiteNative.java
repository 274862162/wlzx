package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 前台公告
 * @author tmn
 *
 */

public class WebsiteNative {
   private int nativeID;
   private String content;
   private Date createTime;
   private String reserved1;
   private String reserved2;
   

   public int getNativeID() {
      return nativeID;
   }
   

   public void setNativeID(int newNativeID) {
      nativeID = newNativeID;
   }
   

   public String getContent() {
      return content;
   }
   

   public void setContent(String newContent) {
      content = newContent;
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