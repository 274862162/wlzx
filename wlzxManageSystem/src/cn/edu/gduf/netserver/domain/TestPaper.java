package cn.edu.gduf.netserver.domain;

import java.util.*;

/**
 * 试卷类
 * @author hsg
 *
 */
public class TestPaper {

   private int paperID;  // 试卷id
   private Date paperDate;  // 出卷时间
   private String paperName;  // 试卷名称
   
   private List<Question> questions = new ArrayList<Question>();  // 该试卷包含的题目（没映射到试卷表）

   public TestPaper() {}
   
   public TestPaper(String paperName, List<Question> questions) {
	   super();
	   this.paperName = paperName;
	   this.questions = questions;
   }
   
   public int getPaperID() {
      return paperID;
   }
   public void setPaperID(int newPaperID) {
	  paperID = newPaperID;
   }
   
   public Date getPaperDate() {
      return paperDate;
   }
   public void setPaperDate(java.util.Date newPaperDate) {
      paperDate = newPaperDate;
   }
   
   public String getPaperName() {
      return paperName;
   }
   public void setPaperName(java.lang.String newPaperName) {
	   paperName = newPaperName;
   }
   
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}