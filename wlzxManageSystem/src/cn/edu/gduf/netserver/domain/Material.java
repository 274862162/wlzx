package cn.edu.gduf.netserver.domain;

import java.util.Date;

/**
 * 资料类
 * @author Wmj
 *
 */
public class Material {

	private int materialID;  // 资料ID
	private String fileName;  // 资料文件名
    private String path;  // 文件路径
    private String uploadTime; //上传时间
    private String section; //部门
    private int type; //文件类型
    public java.util.Collection<Download> download;
   
   public int getMaterialID() {
      return materialID;
   }
   
   public void setMaterialID(int newMaterialID) {
      materialID = newMaterialID;
   }
   
   public String getFileName() {
      return fileName;
   }
   public void setFileName(String newFileName) {
      fileName = newFileName;
   }
   public String getPath() {
      return path;
   }
   public void setPath(String newPath) {
      path = newPath;
   }
   public java.util.Collection<Download> getDownload() {
      if (download == null)
         download = new java.util.HashSet<Download>();
      return download;
   }
   public java.util.Iterator getIteratorDownload() {
      if (download == null)
         download = new java.util.HashSet<Download>();
      return download.iterator();
   }
   public void setDownload(java.util.Collection<Download> newDownload) {
      removeAllDownload();
      for (java.util.Iterator iter = newDownload.iterator(); iter.hasNext();)
         addDownload((Download)iter.next());
   }
   public void addDownload(Download newDownload) {
      if (newDownload == null)
         return;
      if (this.download == null)
         this.download = new java.util.HashSet<Download>();
      if (!this.download.contains(newDownload))
         this.download.add(newDownload);
   }
   public void removeDownload(Download oldDownload) {
      if (oldDownload == null)
         return;
      if (this.download != null)
         if (this.download.contains(oldDownload))
            this.download.remove(oldDownload);
   }
   public void removeAllDownload() {
      if (download != null)
         download.clear();
   }

	public String getUploadTime() {
		return uploadTime;
	}
	
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
   
}