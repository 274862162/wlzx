package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.Material;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class UpDownloadListDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	public int count(String section,int type){
		int num=0;
		if(type==0){
			sql= new StringBuffer("SELECT count(*) as count FROM material WHERE section=?");
		}else{
			sql= new StringBuffer("SELECT count(*) as count FROM material WHERE section=? and type=?");
		}
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, section);
			if(type!=0){
				pstmt.setInt(2, type);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				num=rs.getInt("count");
			}
			System.out.println(section+":"+num);
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
	public List<Material> getUpDownload(PageBean pageBean,String section,int type){
		if(type==0){
			sql= new StringBuffer("SELECT Id,fileName,uploadTime,type FROM material WHERE section=? ORDER BY Id  desc");
		}else{
			sql= new StringBuffer("SELECT Id,fileName,uploadTime,type FROM material WHERE section=? and type=? ORDER BY Id  desc");
		}
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Material> upDownLoadList = new ArrayList<Material>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, section);
			if(type!=0){
				pstmt.setInt(2, type);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Material file = new Material();
				file.setMaterialID(rs.getInt("Id"));
				file.setUploadTime(rs.getString("uploadTime"));
				file.setFileName(rs.getString("fileName"));
				file.setType(rs.getInt("type"));
				file.setSection(section);
				upDownLoadList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return upDownLoadList;
	}
}
