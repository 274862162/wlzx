package cn.edu.gduf.netserver.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

/**
 * 数据库连接类
 * @author hsg
 *
 */
public class DbUtil {
	
	private DbUtil(){};
	
	static{
		try {
			Class.forName(PropertiesUtil.getValue("jdbcName"));  // 注册驱动		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到数据库链接
	 * @return
	 */
	public static Connection getCon(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(PropertiesUtil.getValue("dbUrl"), PropertiesUtil.getValue("dbUserName"), PropertiesUtil.getValue("dbPassword"));
		} catch (SQLException e) {
			throw new RuntimeException("数据库连接出错");
		}
		return conn;
	}
	
	/**
	 * 关闭ResultSet、PreparedStatement、Connection
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}