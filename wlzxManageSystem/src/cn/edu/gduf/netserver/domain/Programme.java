package cn.edu.gduf.netserver.domain;

/**
 * 活动方案
 * @author tmn
 *
 */

public class Programme {
   private int programmeID;
   private int programmeType;
   private String programme;
   private String reserved1;
   private String reserved2;
   

   public int getProgrammeID() {
      return programmeID;
   }
   

   public void setProgrammeID(int newProgrammeID) {
      programmeID = newProgrammeID;
   }
   

   public int getProgrammeType() {
      return programmeType;
   }
   

   public void setProgrammeType(int newProgrammeType) {
      programmeType = newProgrammeType;
   }
   

   public String getProgramme() {
      return programme;
   }
   

   public void setProgramme(String newProgramme) {
      programme = newProgramme;
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