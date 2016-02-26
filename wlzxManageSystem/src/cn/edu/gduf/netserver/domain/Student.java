package cn.edu.gduf.netserver.domain;

/**
 * 学生信息表
 * @author tmn
 *
 */

public class Student {
 /**
 * 学生ID
 */
private int studentID;
/**
 * 学号
 */
private String sno;
/**
 * 学生姓名
 */
private String name;
/**
 * 密码
 */
private String password;
   private String reserved1;
   

   public int getStudentID() {
      return studentID;
   }
   

   public void setStudentID(int newStudentID) {
      studentID = newStudentID;
   }
   

   public String getSno() {
      return sno;
   }
   

   public void setSno(String newSno) {
      sno = newSno;
   }
   

   public String getName() {
      return name;
   }
   

   public void setName(String newName) {
      name = newName;
   }
   

   public String getPassword() {
      return password;
   }
   

   public void setPassword(String newPassword) {
      password = newPassword;
   }
   

   public String getReserved1() {
      return reserved1;
   }
   

   public void setReserved1(String newReserved1) {
      reserved1 = newReserved1;
   }

}