package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.domain.Free;
import cn.edu.gduf.netserver.domain.FreeTable;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.UserFreeTable;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class ScheduleDaoImpl implements IScheduleDao{

	/**
	 * 保存无课时间段记录
	 */
	public int addFree(Free free) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO free(onetwo, threefour, five, sixseven, eight, nineten, userFreeTableID, weekID) VALUES (?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, free.getOnetwo());
		pstmt.setString(2, free.getThreefour());
		pstmt.setString(3, free.getFive());
		pstmt.setString(4, free.getSixseven());
		pstmt.setString(5, free.getEight());
		pstmt.setString(6, free.getNineten());
		pstmt.setInt(7, free.getUserFreeTableID());
		pstmt.setInt(8, free.getWeekID());
		return pstmt.executeUpdate();
	}

	/**
	 * 根据分页条件得到各个学期无课表
	 */
	public List<FreeTable> getFreeTables(PageBean pageBean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("SELECT * FROM freetable ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<FreeTable> freeTablesList = new ArrayList<FreeTable>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FreeTable freeTable = new FreeTable();
				freeTable.setFreeTableID(rs.getInt("Id"));
				freeTable.setFreeTableName(rs.getString("freeTableName"));
				freeTablesList.add(freeTable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return freeTablesList;
	}

	/**
	 * 获得无课表总数
	 */
	public int count() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS total FROM freetable";
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

	/**
	 * 获得UserFreeTable表的最大id值
	 * @throws SQLException 
	 */
	public int getMaxUserFreeTableId() throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "SELECT MAX(Id) Id FROM user_freetable";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("Id");
		}else {
			return 0;
		}
	}

	/**
	 * 保存用户与无课表间的关联
	 */
	public int addUserFreeTable(UserFreeTable userFreeTable) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO user_freetable VALUES (null, ?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, DateUtil.formatDate(userFreeTable.getDate(), "yyyy-MM-dd"));
		pstmt.setInt(2, userFreeTable.getFreeTableID());
		pstmt.setInt(3, userFreeTable.getUserID());
		return pstmt.executeUpdate();
	}

	/**
	 * 获得userFreeTableId
	 */
	public int getUserFreeTableId(int userID, int freeTableID) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "SELECT id FROM user_freetable WHERE userID=? AND freeTableID=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userID);
		pstmt.setInt(2, freeTableID);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("Id");
		}else {
			return 0;
		}
	}
	
	/**
	 * 获得userFreeTableId集合
	 */
	public List<Integer> getUserFreeTableId(int freeTableID) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Id FROM user_freetable WHERE freeTableID=?;";
		List<Integer> userFreeTableIdList = new ArrayList<Integer>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, freeTableID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userFreeTableIdList.add(rs.getInt("Id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userFreeTableIdList;
	}

	/**
	 * 根据UserFreeTableId获得具体无课时间段
	 */
	public List<Free> getFrees(int userFreeTableId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT onetwo, threefour, five, sixseven, eight, nineten, userFreeTableID, weekID FROM free WHERE userFreeTableID=?;";
		List<Free> freeList = new ArrayList<Free>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userFreeTableId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Free free = new Free();
				free.setOnetwo(rs.getString("onetwo"));
				free.setThreefour(rs.getString("threefour"));
				free.setFive(rs.getString("five"));
				free.setSixseven(rs.getString("sixseven"));
				free.setEight(rs.getString("eight"));
				free.setNineten(rs.getString("nineten"));
				free.setUserFreeTableID(rs.getInt("userFreeTableID"));
				free.setWeekID(rs.getInt("weekID"));
				freeList.add(free);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}		
		return freeList; 
	}

	/**
	 * 根据id获得FreeTable
	 */
	public FreeTable getFreeTableById(int freeTableId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM freetable WHERE id = ?";
		FreeTable freeTable = new FreeTable();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, freeTableId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				freeTable.setFreeTableID(rs.getInt("id"));
				freeTable.setFreeTableName(rs.getString("freeTableName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return freeTable;
	}

	/**
	 * 根据id得到用户UserFreeTable
	 */
	public UserFreeTable getUserFreeTableById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user_freetable WHERE id = ?";
		UserFreeTable userFreeTable = new UserFreeTable();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userFreeTable.setUserFreeTableID(rs.getInt("Id"));
				/*
				try {
					userFreeTable.setDate(DateUtil.formatString(rs.getString("date"), "yyyy-MM-dd"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
				userFreeTable.setFreeTableID(rs.getInt("freeTableID"));
				userFreeTable.setUserID(rs.getInt("userID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userFreeTable;
	}

	public List<UserFreeTable> getUserFreeTables() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER_FREETABLE;";
		List<UserFreeTable> userFreeTableList = new ArrayList<UserFreeTable>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserFreeTable userFreeTable = new UserFreeTable();
				userFreeTable.setUserID(rs.getInt("Id"));
				userFreeTable.setDate(DateUtil.formatString(rs.getString("date"), "yyyy-MM-dd"));
				userFreeTable.setUserFreeTableID(rs.getInt("freeTableID"));
				userFreeTable.setUserID(rs.getInt("userID"));
				userFreeTableList.add(userFreeTable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return userFreeTableList;
	}
}
