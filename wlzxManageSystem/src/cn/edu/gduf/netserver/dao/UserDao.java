package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.DbUtil;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	//验证用户登录的方法
	public boolean check(User user){
		String name = user.getUserName();
		String password = user.getPassword();
		conn = null;
		rs = null;
		pstmt = null;
		boolean b = false;
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement("select userName from user where userName=? and password=?");
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				b=true;
				System.out.print("查找成功。");
			}
			else{
				b=false;
				System.out.print("查找失败。");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//判断用户是否第一次登录的方法
	public boolean isFirstTime(User user){
		String name = user.getUserName();
		conn = null;
		rs = null;
		pstmt = null;
		boolean b = true;
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("select sno from user where userName=?");
			pstmt.setString(1,name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("sno").equals("")){
					System.out.println("sno="+rs.getString("sno"));
					System.out.print("查找成功。");
				}else{
					b=false;
				}
			}
			else{
				b=false;
				System.out.print("查找失败。");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
	//添加用户
	public boolean insert(User user){
		conn = null;
		pstmt = null;
		boolean b = true;
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement("INSERT INTO user(userName,password,section) VALUES(?,?,?)");
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getSection());
			if(pstmt.executeUpdate()==0){
				b=false;
			}
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			b=false;
		}
		return b;
	}
	
	//更新用户信息的方法
	public boolean updateUser(User user){
		conn = null;
		pstmt = null;
		boolean b = true;
		sql=new StringBuffer("update user set ");
		if(user.getUserName()!=null){
			sql.append("userName='"+user.getUserName()+"'");
		}
		if(user.getPassword()!=null){
			sql.append(",password='"+user.getPassword()+"'");
		}
		if(user.getSection()!=null){
			sql.append(",section='"+user.getSection()+"'");
		}
		if(user.getAge()!=0){
			sql.append(",age="+user.getAge());
		}
		if(user.getDormitory()!=null){
			sql.append(",dormitory='"+user.getDormitory()+"'");
		}
		if(user.getName()!=null){
			sql.append(",name='"+user.getName()+"'");
		}
		if(user.getMajor()!=null){
			sql.append(",major='"+user.getMajor()+"'");
		}
		if(user.getLongTelephone()!=null){
			sql.append(",longTelephone='"+user.getLongTelephone()+"'");
		}
		if(user.getSex()!=null){
			sql.append(",sex='"+user.getSex()+"'");
		}
		if(user.getShortTelephone()!=null){
			sql.append(",shortTelephone='"+user.getShortTelephone()+"'");
		}
		if(user.getSno()!=null){
			sql.append(",sno='"+user.getSno()+"'");
		}
		sql.append(" where Id="+user.getUserID());
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			if(pstmt.executeUpdate()==0){
				b=false;
			}
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			/*System.out.print("更新失败。");*/
			b=false;
		}
		return b;
	}
/*	//更新用户信息的方法
		public boolean updateBasicInfoToUser(User user){
			conn = null;
			pstmt = null;
			boolean b = true;
			try{
				conn= DbUtil.getCon();
				pstmt = conn.prepareStatement("update user set age=?,dormitory=?,longTelephone=?,shortTelephone=?,interests=?,major=?,name=?,sno=? where userName=?");
				pstmt.setInt(1,user.getAge());
				pstmt.setString(2,user.getDormitory());
				pstmt.setString(3,user.getLongTelephone());
				pstmt.setString(4,user.getShortTelephone());
				pstmt.setString(5,user.getInterests());
				pstmt.setString(6,user.getMajor());
				pstmt.setString(7,user.getName());
				pstmt.setString(8, user.getSno());
				pstmt.setString(9,user.getUserName());
				
				pstmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
				b=false;
			}
			return b;
		}*/
	//修改密码的方法
	public String changePassword(String userName,String password,String newPassword){
		conn = null;
		rs = null;
		pstmt = null;
		String message = null;
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement("select name from user where userName=? and password=?");
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(!rs.next()){
				message = "密码错误";
			}else{
				pstmt = conn.prepareStatement("update user set password=? where userName=?");
				pstmt.setString(1,newPassword);
				pstmt.setString(2,userName);
				pstmt.executeUpdate();
				System.out.println("修改成功");
				pstmt.close();
				conn.close();
				message = "修改成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("更新失败。");
			message = "修改失败";
		}
		return message;
	}
	//获得用户ID的方法
	public int getUserID(User user){
		String userName = user.getUserName();
		int ID = 0;
		conn = null;
		pstmt = null;
		ResultSet rs = null;
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement("select ID from user where userName=?");
			pstmt.setString(1,userName);
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
	//查询个人信息
	public User getPersonInfo(int userID){
		User user = new User();
		conn = null;
		rs = null;
		pstmt = null;
		try{
			conn= DbUtil.getCon();
			pstmt = conn.prepareStatement("select a.userName,a.name,a.sno,a.age,a.dormitory,a.sex,b.areaName,a.section,a.major,a.longTelephone,a.shortTelephone,a.interests from user a,area b where a.Id=b.userID and a.Id=?");
			pstmt.setInt(1,userID);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user.setUserName(rs.getString(1));
				user.setSno(rs.getString(2));
				user.setName(rs.getString(3));
				user.setDormitory(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setSex(rs.getString(6));
				user.setRepArea(rs.getString(7));
				user.setSection(rs.getString(8));
				user.setMajor(rs.getString(9));
				user.setLongTelephone(rs.getString(10));
				user.setShortTelephone(rs.getString(11));
				user.setInterests(rs.getString(12));
			}
			/*pstmt = conn.prepareStatement("select areaName from area where userID="+userID);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user.setRepArea(rs.getString("areaName"));
			}*/
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("查询失败。");
		}
		return user;
	}
	//统计记录数量
		public int count(){
			int num=0;
			sql= new StringBuffer("SELECT count(*) as count FROM user");
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
	
	//分页显示所有用户信息
	public List<User> getUser(PageBean pageBean){
		sql=new StringBuffer("SELECT a.Id,a.userName,a.section,c.roleName FROM user a,user_role b,role c WHERE b.userID=a.Id and b.roleID=c.Id ORDER BY Id");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<User> userList = new ArrayList<User>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setSection(rs.getString(3));
				user.setRole(rs.getString(4));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userList;
	}
	//通过ID获得User信息
	public User getUserById(int userID) throws SQLException {
		sql= new StringBuffer("SELECT a.userName,a.section,a.password,c.roleName FROM user a,user_role b,role c WHERE b.userID=a.Id and b.roleID=c.Id and a.Id=?");
		User user = new User();
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setUserID(userID);
				user.setUserName(rs.getString(1));
				user.setSection(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return user;
	}
	
	//根据ID删除用户
	public boolean delUserById(int userID) throws SQLException {
		boolean b = true;
		sql= new StringBuffer("DELETE FROM user WHERE Id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userID);
			if(pstmt.executeUpdate()==0){
				b=false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			b=false;
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return b;
	}
	
	//取所有用户ID
	public List<User> getAllUser(){
		List<User> userList = new ArrayList<User>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("select id,userName from user");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				userList.add(user);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			DbUtil.close(rs, pstmt, conn);
		}
		return userList;
	}
}

