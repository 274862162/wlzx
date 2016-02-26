package cn.edu.gduf.netserver.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 考核类
 * @author hsg
 *
 */
public class Examine {

   private int examineID;  // 考核ID
   private int userID;  // 学生ID
   private int peperID;  // 试卷ID
   private java.util.Date testTime;  // 考核时间
   private int score;  // 成绩
   private int singleScore;  // 选择题得分
   private int moreScore;  // 选择题得分
   private int judgeScore;  // 判断题得分
   private int blankFillScore;  // 填空题得分
   private int shortAnswerScore;  // 简答题得分
   
   private User user;  // 考核用户（没映射到考核表）
   private Set<QuestionMark> questionMarks = new HashSet<QuestionMark>();  // 该考核相关的题和评分（没映射到试卷表）
   
   public Examine(){}  

   public Examine(int userID, int peperID, Date testTime) {
	   super();
	   this.userID = userID;
	   this.peperID = peperID;
	   this.testTime = testTime;
   }
   
   public Examine(int userID, int peperID, Date testTime, int singleScore, int moreScore, int judgeScore) {
	   super();
	   this.userID = userID;
	   this.peperID = peperID;
	   this.testTime = testTime;
	   this.singleScore = singleScore;
	   this.moreScore = moreScore;
	   this.judgeScore = judgeScore;
   }
   
   public Examine(int examineID, int singleScore, int moreScore, int judgeScore, int blankFillScore, int shortAnswerScore) {
	   super();
	   this.examineID = examineID;
	   this.singleScore = singleScore;
	   this.moreScore = moreScore;
	   this.judgeScore = judgeScore;
	   this.blankFillScore = blankFillScore;
	   this.shortAnswerScore = shortAnswerScore;
   }

   public int getExamineID() {
	  return examineID;
   }
	
   public void setExamineID(int examineID) {
	  this.examineID = examineID;
   }

   public int getUserID() {
      return userID;
   }
   public void setUserID(int newUserID) {
	   userID = newUserID;
   }
  
   public int getPeperID() {
      return peperID;
   }
   public void setPeperID(int newPeperID) {
      peperID = newPeperID;
   }
   
   public java.util.Date getTestTime() {
      return testTime;
   }
   public void setTestTime(java.util.Date newTestTime) {
      testTime = newTestTime;
   }
   
   public int getScore() {
      return score;
   }
   public void setScore(int newScore) {
      score = newScore;
   }

	public int getBlankFillScore() {
		return blankFillScore;
	}
	
	public void setBlankFillScore(int blankFillScore) {
		this.blankFillScore = blankFillScore;
	}
	
	public int getSingleScore() {
		return singleScore;
	}

	public void setSingleScore(int singleScore) {
		this.singleScore = singleScore;
	}

	public int getMoreScore() {
		return moreScore;
	}

	public void setMoreScore(int moreScore) {
		this.moreScore = moreScore;
	}

	public int getJudgeScore() {
		return judgeScore;
	}
	
	public void setJudgeScore(int judgeScore) {
		this.judgeScore = judgeScore;
	}
	
	public int getShortAnswerScore() {
		return shortAnswerScore;
	}
	
	public void setShortAnswerScore(int shortAnswerScore) {
		this.shortAnswerScore = shortAnswerScore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<QuestionMark> getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(Set<QuestionMark> questionMarks) {
		this.questionMarks = questionMarks;
	}
   
   
}