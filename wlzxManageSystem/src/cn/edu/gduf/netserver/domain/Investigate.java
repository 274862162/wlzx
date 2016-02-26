package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 问卷调查类
 * @author Wmj
 *
 */
public class Investigate {

	private int questionnaireID;  // 问卷ID
	private int userID;  // 用户ID
	private Date inquirerTime;  // 填写问卷时间

   public int getQuestionnaireID() {
      return questionnaireID;
   }
   public void setQuestionnaireID(int newQuestionnaireID) {
      questionnaireID = newQuestionnaireID;
   }
   public int getUserID() {
      return userID;
   }
   public void setUserID(int newUserID) {
      userID = newUserID;
   }
   public Date getInquirerTime() {
      return inquirerTime;
   }
   public void setInquirerTime(Date newInquirerTime) {
      inquirerTime = newInquirerTime;
   }

}