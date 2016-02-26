package cn.edu.gduf.netserver.domain;

/**
 * 考核类
 * @author hsg
 *
 */
public class Timetable {

	private int timetableID;  // 无课表ID
	private java.lang.String term;  // 学期
	private java.util.Date fillTime;  // 填写时间
	private int day;  // 星期几
	private int timeQuantum;  // 时间段

   public int getTimetableID() {
      return timetableID;
   }
   public void setTimetableID(int newTimetableID) {
      timetableID = newTimetableID;
   }
   
   public java.lang.String getTerm() {
      return term;
   }
   public void setTerm(java.lang.String newTerm) {
      term = newTerm;
   }
   
   public java.util.Date getFillTime() {
      return fillTime;
   }
   public void setFillTime(java.util.Date newFillTime) {
      fillTime = newFillTime;
   }
   
   public int getDay() {
      return day;
   }
   public void setDay(int newDay) {
      day = newDay;
   }
   
   public int getTimeQuantum() {
      return timeQuantum;
   }
   public void setTimeQuantum(int newTimeQuantum) {
      timeQuantum = newTimeQuantum;
   }
}