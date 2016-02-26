package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.gduf.netserver.dao.ISurveySystemUpdateQusnDao;
import cn.edu.gduf.netserver.util.DbUtil;

public class SurveySystemUpdateQusnDaoImpl implements ISurveySystemUpdateQusnDao{

	public void updateStatus(int qusnID, String status) {
		String querySql="update questionnaire set qusnnStatus=? where id=?;";		
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setString(1, status);
			ps.setInt(2, qusnID);
			ps.executeUpdate();		
			}catch(Exception e){
				e.printStackTrace();
			}
		if(ps != null){
			try {
				ps.close();
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
