package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 公告
 * @author cjy
 *
 */


public class Notice {
  
   private int noticeID;   //公告ID
   
   private String operator; //操作者
   
   private String department; //部门
   
   private String content; //内容
   
   private Date createTime;   //发布时间
   
   
   public int getNoticeID() {
      return noticeID;
   }
   
   
   public void setNoticeID(int newNoticeID) {
      noticeID = newNoticeID;
   }
   
   
   public String getOperator() {
	   return operator;
   }
	
	
	public void setOperator(String operator) {
		this.operator = operator;
	}


	public String getDepartment() {
      return department;
	}
   
   
   public void setDepartment(String newDepartment) {
      department = newDepartment;
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

}