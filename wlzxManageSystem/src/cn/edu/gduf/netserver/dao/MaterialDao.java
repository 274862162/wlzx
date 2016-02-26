package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.gduf.netserver.util.DbUtil;

public class MaterialDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	//插入数据
	public boolean upload(String fileName,String path,String section,int type){
		boolean isUpload = false;
		java.util.Date uploadTime=new java.util.Date();//获得当前时间
		sql= new StringBuffer("INSERT INTO material(fileName,path,uploadTime,section,type) VALUES(?,?,?,?,?)");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,fileName);
			pstmt.setString(2,path);
			pstmt.setTimestamp(3,new java.sql.Timestamp(uploadTime.getTime()));
			pstmt.setString(4,section);
			pstmt.setInt(5,type);
			int line = pstmt.executeUpdate();
			if(line!=0){
				isUpload = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return isUpload;
	}
	//查询文件名（包含路径）
	public String getFileName(int fileID){
		String fileName = "";
		String path = "";
		sql= new StringBuffer("SELECT fileName,path FROM material WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,fileID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				path = rs.getString("path");
				fileName = path+rs.getString("fileName");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return fileName;
	}
	
	public boolean isExisting(String fileName){
		boolean isExisting = false;
		sql= new StringBuffer("SELECT id FROM material WHERE fileName=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,fileName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				isExisting = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return isExisting;
	}
}
