package cn.edu.gduf.netserver.domain;

import java.util.*;
/**
 * 下载类
 * @author Wmj
 *
 */
public class Download {

	private int materialID;  // 资料文件的ID名称
	private int studentID;  // 学生ID
	private Date downloadTime;  // 下载时间

    public int getMaterialID() {
       return materialID;
    }
    public void setMaterialID(int newMaterialID) {
       materialID = newMaterialID;
    }
    public int getStudentID() {
       return studentID;
    }
    public void setStudentID(int newStudentID) {
       studentID = newStudentID;
    }
    public Date getDownloadTime() {
       return downloadTime;
    }
    public void setDownloadTime(Date newDownloadTime) {
       downloadTime = newDownloadTime;
    }

}