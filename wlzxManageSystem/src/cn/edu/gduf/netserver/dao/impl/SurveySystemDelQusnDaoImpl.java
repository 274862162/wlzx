package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.gduf.netserver.dao.ISurveySystemDelQusnDao;
import cn.edu.gduf.netserver.util.DbUtil;

public class SurveySystemDelQusnDaoImpl implements ISurveySystemDelQusnDao{

	public void delQusn(int qusnID) {
		String delQusn="delete from questionnaire where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(delQusn);
			ps.setInt(1, qusnID);
			ps.executeUpdate();
			/*
			ps=conn.prepareStatement(delUserSelc);
			ps.setInt(1, qusnID);
			ps.executeUpdate();
			ps=conn.prepareStatement(delCreQusn);
			ps.setInt(1, qusnID);
			ps.executeUpdate();
			ps=conn.prepareStatement(delQusnQues);
			ps.setInt(1, qusnID);
			ps.executeUpdate();
			ps=conn.prepareStatement(delQusn);
			ps.setInt(1, qusnID);
			ps.executeUpdate();
			*/
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
	public void delQusnQuestion(int qusnID) {
		String delQusnQues="delete from qusnn_question where qusnID=?";
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(delQusnQues);
			ps.setInt(1, qusnID);
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

	public void delCreQusn(int qusnID) {
		String delCreQusn="delete from create_questionnaire where questionnaireID=?";
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(delCreQusn);
			ps.setInt(1, qusnID);
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

	public void delUserSlecSection(int qusnID) {
		String delUserSelc="delete from user_selc_section where questionID in" +
				"(select questionID from create_questionnaire where questionnaireID=?)";
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(delUserSelc);
			ps.setInt(1, qusnID);
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

	public void delInves(int qusnID) {		//删除investigate数据表记录
		String delInves="delete from investigate where questionnaireID=?";
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(delInves);
			ps.setInt(1, qusnID);
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
