package cn.edu.gduf.netserver.domain;

import java.util.Date;

/**
 * 下载专区
 * @author tmn
 *
 */

public class DownloadSection {
   private int downloadSectionFileID;
   private String filePath;
   private String fileName;
   private String operator;
   private String createTime;
   private String reserved1;
   private String reserved2;
   

   public int getDownloadSectionFileID() {
      return downloadSectionFileID;
   }
   

   public void setDownloadSectionFileID(int newDownloadSectionFileID) {
      downloadSectionFileID = newDownloadSectionFileID;
   }
   

   public String getFilePath() {
      return filePath;
   }
   

   public void setFilePath(String newFilePath) {
      filePath = newFilePath;
   }
   

   public String getFileName() {
      return fileName;
   }
   

   public void setFileName(String newFileName) {
      fileName = newFileName;
   }
   

   public String getOperator() {
	   return operator;
   }
	
	
   public void setOperator(String operator) {
	   this.operator = operator;
   }
	
	
	public String getCreateTime() {
		return createTime;
	}
	
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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