package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.domain.Area;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.DbUtil;

public class AreaDao{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	//添加记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM area");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()){
				num=rs.getInt("count");
			}
			System.out.println(num);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
	}
	//得到Area列表
	public List<Area> getList(PageBean pageBean){
		sql=new StringBuffer("SELECT a.id,a.userID,a.areaName,b.userName FROM area a,user b where a.userID=b.Id");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Area> roleList = new ArrayList<Area>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Area area = new Area();
				area.setAreaID(rs.getInt(1));
				area.setUserID(rs.getInt(2));
				area.setAreaName(rs.getString(3));
				area.setUserName(rs.getString(4));
				roleList.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return roleList;
	}
	//添加Area
	public int addArea(Area area) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO area(areaName,userID) VALUES(?,?)");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, area.getAreaName());
			pstmt.setInt(2, area.getUserID());
			i = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}
	//更新Area
	public int updateArea(Area area) {
		sql= new StringBuffer("UPDATE area set areaName=?,userID=? WHERE id=?");
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, area.getAreaName());
			pstmt.setInt(2, area.getUserID());
			pstmt.setInt(3, area.getAreaID());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	//删除Area 
	public int deleteAreaById(int id) {
		int result = 0;//影响的条数
		try {
			pstmt = conn.prepareStatement("DELETE FROM area WHERE id=?");
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	//通过ID获得角色信息
	public Area getAreaById(int id) {
		sql= new StringBuffer("SELECT areaName,userID FROM area WHERE id=?");
		Area area = new Area();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				area.setAreaName(rs.getString("areaName"));
				area.setUserID(rs.getInt("userID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return area;
	}
	
	//通过区域名查询ID
	public int getAreaID(String areaName){
		int id=0;
		sql= new StringBuffer("SELECT id FROM area WHERE areaName=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,areaName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				id=rs.getInt("id");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return id;
	}
	
	//获得区域ID的方法
	public int getAreaID(Area area){
		String areaName = area.getAreaName();
		int ID = 0;
		conn = null;
		pstmt = null;
		ResultSet rs = null;
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement("select id from area where areaName=?");
			pstmt.setString(1,areaName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				ID = rs.getInt(1);
			}
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ID;
	}	
}
