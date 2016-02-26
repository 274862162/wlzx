package cn.edu.gduf.netserver.domain;

import java.util.Date;

/**
 * 图片
 * @author tmn
 *
 */

public class Images {
   private int imagesID;	//	图片ID
   private String filePath;	//图片存储路径
   private String fileName;	//图片的名字
   private String operator;	//操作人
   private String createTime;	//发布时间
   private String reserved1;
   private String reserved2;
   

   public int getImagesID() {
      return imagesID;
   }
   

   public void setImagesID(int newImagesID) {
      imagesID = newImagesID;
   }
   
   public String getFileName() {
      return fileName;
   }
   

   public void setFileName(String newFileName) {
      fileName = newFileName;
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


	public String getFilePath() {
		return filePath;
	}
	
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	   
}