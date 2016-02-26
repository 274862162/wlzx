package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cn.edu.gduf.netserver.dao.ISurveySystemSaveUserActionDao;
import cn.edu.gduf.netserver.util.DbUtil;

public class SurveySystemSaveUserActionDaoImpl implements ISurveySystemSaveUserActionDao{

	public void saveUserSelect(int userID, HashMap<Integer, String> results) {
		String quesnnSQL="insert into user_selc_section(userID,questionID,userSelect)" +
				"values(?,?,?)";		
		Connection conn=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			conn=DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {
			Iterator<Entry<Integer, String>> iter=results.entrySet().iterator();
			while(iter.hasNext()){
				Entry<Integer,String> entry=iter.next();
				ps=conn.prepareStatement(quesnnSQL);
				ps.setInt(1, userID);
				ps.setInt(2,entry.getKey());
				ps.setString(3, entry.getValue());
				ps.executeUpdate();
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("write fail！！");
		}
		try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}		
	}

	public void saveUserTime(int qusnID, int userID, String clientTime) {
		String quesnnSQL="insert into investigate(questionnaireID,userID,inquireTime)" +
				"values(?,?,?)";		
		Connection conn=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			conn=DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {
				ps=conn.prepareStatement(quesnnSQL);
				ps.setInt(1, qusnID);
				ps.setInt(2,userID);
				ps.setString(3, clientTime);
				ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("write fail！！");
		}
		try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}	
		
	}

}
