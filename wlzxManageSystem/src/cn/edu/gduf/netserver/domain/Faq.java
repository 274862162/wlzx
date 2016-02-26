package cn.edu.gduf.netserver.domain;

/**
 * 考核类
 * @author hsg
 *
 */
public class Faq {

   private int faqID;  // faqID
   private java.lang.String problem;  // 问题
   private java.lang.String method;  // 处理方法
   
   public int getFaqID() {
      return faqID;
   }
   public void setFaqID(int newFaqID) {
      faqID = newFaqID;
   }

   public java.lang.String getProblem() {
      return problem;
   }
   public void setProblem(java.lang.String newProblem) {
      problem = newProblem;
   }

   public java.lang.String getMethod() {
      return method;
   }
   public void setMethod(java.lang.String newMethod) {
      method = newMethod;
   }
}