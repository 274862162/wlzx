package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 前台公告
 * @author tmn
 *
 */

public class WebNotice {
   private int noticeID;//ID
   private String content;//公告内容
   private String title;//公告标题
   private String operator;//操作人
   private String createTime;//创建时间
   private String reserved1;
   private String reserved2;
   

   public int getNoticeID() {
      return noticeID;
   }
   

   public void setNoticeID(int newNoticeID) {
	   noticeID = newNoticeID;
   }
   

   public String getContent() {
      return content;
   }
   

   public void setContent(String newContent) {
      content = newContent;
   }
   

   public String getCreateTime() {
      return createTime;
   }
   

   public void setCreateTime(String newCreateTime) {
      createTime = newCreateTime;
   }
   
   
   public String getTitle() {
	   return title;
   }


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getOperator() {
		return operator;
	}
	
	
	public void setOperator(String operator) {
		this.operator = operator;
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