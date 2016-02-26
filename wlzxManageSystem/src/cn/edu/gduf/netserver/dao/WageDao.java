package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.gduf.netserver.domain.Wage;
import cn.edu.gduf.netserver.util.DbUtil;

public class WageDao {
	public List getWageInfo(String userName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql;
		List wageInfo = new ArrayList();
		Date date = new Date();
		
		try{
			sql= new StringBuffer("SELECT month,money FROM wage WHERE userName=?");
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				wageInfo.add(1,rs.getDate("month"));
				wageInfo.add(2,rs.getInt("money"));
			}
			sql= new StringBuffer("SELECT month,money FROM wage WHERE userName=?");
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return wageInfo;
	}
}
