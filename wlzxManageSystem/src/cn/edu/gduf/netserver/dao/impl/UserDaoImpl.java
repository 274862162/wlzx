package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;
import cn.edu.gduf.netserver.util.MD5Util;

/**
 * 用户数据访问实现类
 * @author hsg
 * 2015/01/22
 */
public class UserDaoImpl implements IUserDao{

	/**
	 * 登录验证
	 * @param user
	 * @return
	 */
	public User login(User user){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where userName=? and password=?";
		User resultUser = new User();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, MD5Util.EncoderPwdByMd5(user.getPassword()));
			rs = pstmt.executeQuery();
			if(rs.next()){
				resultUser.setUserID(rs.getInt("Id"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setSno(rs.getString("sno"));
				resultUser.setName(rs.getString("name"));
				resultUser.setSex(rs.getString("sex"));
				resultUser.setBirth(DateUtil.formatString(rs.getString("birth"), "yyyy-MM-dd"));
				resultUser.setMajor(rs.getString("major"));
				resultUser.setDormitory(rs.getString("dormitory"));
				resultUser.setLongTelephone(rs.getString("longTelephone"));
				resultUser.setShortTelephone(rs.getString("shortTelephone"));
				resultUser.setSection(rs.getString("section"));
				resultUser.setRepArea(rs.getString("repArea"));				
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return resultUser;
	}
	
	/**
	 * 根据用户ID获得用户
	 * @param userID
	 * @return
	 */
	public User getUserById(int userId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER WHERE Id = ?";
		User user = new User();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getInt("Id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setBirth(DateUtil.formatString(rs.getString("birth"), "yyyy-MM-dd"));
				user.setMajor(rs.getString("major"));
				user.setDormitory(rs.getString("dormitory"));
				user.setLongTelephone(rs.getString("longTelephone"));
				user.setShortTelephone(rs.getString("shortTelephone"));
				user.setSection(rs.getString("section"));
				user.setRepArea(rs.getString("repArea"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return user;
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<User> getUsers(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER WHERE section = ?";
		List<User> userList = new ArrayList<User>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getSection());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("Id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setBirth(DateUtil.formatString(rs.getString("birth"), "yyyy-MM-dd"));
				user.setMajor(rs.getString("major"));
				user.setDormitory(rs.getString("dormitory"));
				user.setLongTelephone(rs.getString("longTelephone"));
				user.setShortTelephone(rs.getString("shortTelephone"));
				user.setSection(rs.getString("section"));
				user.setRepArea(rs.getString("repArea"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userList;
	}

	public List<User> getAllUsers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER";
		List<User> userList = new ArrayList<User>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt("Id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setBirth(DateUtil.formatString(rs.getString("birth"), "yyyy-MM-dd"));
				user.setMajor(rs.getString("major"));
				user.setDormitory(rs.getString("dormitory"));
				user.setLongTelephone(rs.getString("longTelephone"));
				user.setShortTelephone(rs.getString("shortTelephone"));
				user.setSection(rs.getString("section"));
				user.setRepArea(rs.getString("repArea"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userList;
	}

	public List<User> getUsers(PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsers(User user, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS total FROM USER";
		int num = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
	}

	public int updateUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getIdByName(String name) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "SELECT ID FROM USER WHERE NAME=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("Id");
		}else {
			return 0;
		}
	}
	public String getNameByUserName(String userName) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "SELECT name FROM USER WHERE userName=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getString("name");
		}else {
			return "暂时获取不到信息！";
		}
	}
	public int count(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<User> getUserList(PageBean pageBean,String section){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql;
		if(section.equals("tech_dep")){
			sql= new StringBuffer("SELECT * FROM user where section='技术部' ORDER  BY Id desc");
		}else if(section.equals("reso_dep")){
			sql= new StringBuffer("SELECT * FROM user where section='资源部' ORDER  BY Id desc");
		}else if(section.equals("gene_dep")){
			sql= new StringBuffer("SELECT * FROM user where section='综合部' ORDER  BY Id desc");
		}else{
			sql= new StringBuffer("SELECT * FROM user ORDER  BY Id desc");
		}
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
				user.setUserID(rs.getInt("Id"));
				user.setUserName(rs.getString("userName"));
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setMajor(rs.getString("major"));
				user.setDormitory(rs.getString("dormitory"));
				user.setLongTelephone(rs.getString("longTelephone"));
				user.setShortTelephone(rs.getString("shortTelephone"));
				user.setSection(rs.getString("section"));
				user.setRepArea(rs.getString("repArea"));
				user.setDutyTime(rs.getString("dutyTime"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userList;
	}
	public int count(String section) {
		int num=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="";
		if(section.equals("tech_dep")){
			query="select count(*) as num from user where section='技术部';";
		}else if(section.equals("reso_dep")){
			query="select count(*) as num from user where section='资源部';";
		}else if(section.equals("gene_dep")){
			query="select count(*) as num from user where section='综合部';";
		}else{
			query="select count(*) as num from user;";
		}
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
