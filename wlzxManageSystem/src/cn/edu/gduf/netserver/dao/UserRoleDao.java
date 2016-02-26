package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.UserRole;
import cn.edu.gduf.netserver.util.DbUtil;

public class UserRoleDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	//统计记录数量
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM user_role");
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
	
	//分页显示
	public List<UserRole> getList(PageBean pageBean){
		sql=new StringBuffer("SELECT a.Id,b.userName,c.roleName FROM user_role a,user b,role c WHERE a.userID=b.Id and a.roleID=c.Id");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<UserRole> roleList = new ArrayList<UserRole>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserRole userRole = new UserRole();
				userRole.setID(rs.getInt("Id"));
				userRole.setUserName(rs.getString("userName"));
				userRole.setRoleName(rs.getString("roleName"));
				roleList.add(userRole);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return roleList;
	}
	
	//修改用户的角色
	public int changeUserRole(UserRole userRole) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE user_role SET roleID=(SELECT Id FROM role WHERE roleName=?) WHERE Id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userRole.getRoleName());
			pstmt.setInt(2, userRole.getID());
			i = pstmt.executeUpdate();
			System.out.println(i);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}
	
	//查询用户的角色
	public String getUserRole(int userRoleID) throws SQLException {
		String roleName = "";	//影响的条数
		sql= new StringBuffer("SELECT roleName FROM role WHERE Id=(SELECT roleID FROM user_role WHERE Id=? )");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userRoleID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				roleName = rs.getString("roleName");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return roleName;
	}
	//查询用户角色信息，并返回List
	public List<UserRole> getUserRoleList(String userName){
		sql=new StringBuffer("SELECT a.Id,c.roleName FROM user_role a,user b,role c WHERE a.userID=b.Id and a.roleID=c.Id and b.userName=?");
		List<UserRole> roleList = new ArrayList<UserRole>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserRole userRole = new UserRole();
				userRole.setID(rs.getInt("Id"));
				userRole.setUserName(userName);
				userRole.setRoleName(rs.getString("roleName"));
				roleList.add(userRole);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return roleList;
	}
}
