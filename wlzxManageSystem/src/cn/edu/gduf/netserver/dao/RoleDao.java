package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Role;
import cn.edu.gduf.netserver.util.DbUtil;

public class RoleDao implements IRoleDao{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	//添加记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM role");
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
	//得到Role列表
	public List<Role> getList(PageBean pageBean){
		sql=new StringBuffer("SELECT id,authID,roleName,roleDescription FROM role");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Role> roleList = new ArrayList<Role>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleID(rs.getInt("Id"));
				role.setAuthID(rs.getString("authID"));
				role.setRoleName(rs.getString("roleName"));
				role.setRoleDescription(rs.getString("roleDescription"));
				roleList.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return roleList;
	}
	//添加role
	public int addRole(Role role) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO role(roleName,authID,roleDescription) VALUES(?,?,?)");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, role.getRoleName());
			pstmt.setString(2, role.getAuthID());
			pstmt.setString(3, role.getRoleDescription());
			i = pstmt.executeUpdate();
			System.out.println(i);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}
	//更新role
	public int updateRole(Role role) {
		sql= new StringBuffer("UPDATE role set roleName=?,roleDescription=?,authID=? WHERE Id=?");
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, role.getRoleName());
			pstmt.setString(2, role.getRoleDescription());
			pstmt.setString(3, role.getAuthID());
			pstmt.setInt(4, role.getRoleID());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	public int updateRoleById(int id) {
		return 0;
	}
	//删除role
	public int deleteRoleById(int id) {
		sql= new StringBuffer("UPDATE user_role set roleID=1 WHERE roleID=?");
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("DELETE FROM role WHERE id=?");
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	//得到所有的角色
	public List<Role> getAllRoles() {
		sql= new StringBuffer("SELECT roleName FROM role");
		List<Role> roleList = new ArrayList<Role>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleName(rs.getString("roleName"));
				roleList.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return roleList;
	}
	public List<Role> getRoles(Role role) {
		return null;
	}
	public List<Role> getRoles(PageBean pageBean) {
		return null;
	}
	public List<Role> getRoles(Role role, PageBean pageBean) {
		return null;
	}
	//通过ID获得角色信息
	public Role getRoleById(int id) {
		sql= new StringBuffer("SELECT roleName,roleDescription,authID FROM role WHERE id=?");
		Role role = new Role();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				role.setRoleName(rs.getString("roleName"));
				role.setRoleDescription(rs.getString("roleDescription"));
				role.setAuthID(rs.getString("authID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return role;
	}
	
	public int count(Role role) {
		return 0;
	}
}
