package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.gduf.netserver.dao.ISurveySystemQueryQusnDao;
import cn.edu.gduf.netserver.domain.QusnnList;
import cn.edu.gduf.netserver.util.DbUtil;

public class SurveySystemQueryQusnDaoImpl implements ISurveySystemQueryQusnDao{
	
	int PAGESIZE=5;//分页条数
	//可删除下面方法
	public ArrayList<QusnnList> queryQusnn(int userID){
		ArrayList<QusnnList> qusnnLists=new ArrayList<QusnnList>();
		String querySql="select ID,quesnnTitle,quesnnTime,qusnnStatus from questionnaire where userID=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			rs=ps.executeQuery();
			while(rs.next()){
				QusnnList qusnnList=new QusnnList();
				qusnnList.setQusnnID(rs.getInt("id"));
				qusnnList.setQuesnnTitle(rs.getString("quesnnTitle"));
				qusnnList.setQuesnnTime(rs.getString("quesnnTime"));
				qusnnList.setQusnnStatus(rs.getString("qusnnStatus"));
				qusnnList.setReceiveData(collectData(qusnnList.getQusnnID()));
				qusnnLists.add(qusnnList);
				//System.out.println("查询成功");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
			return qusnnLists;
	}

	public int collectData(int qusnnID) {
		int num=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="select count(*) as num from investigate where questionnaireID=?;";
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, qusnnID);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public ArrayList<QusnnList> queryQusnn(int userID, int currentPage) {
		ArrayList<QusnnList> qusnnLists=new ArrayList<QusnnList>();
		int before=(currentPage-1)*PAGESIZE;//计算当前页第一条记录的前面记录条数
		String querySql="select ID,quesnnTitle,quesnnTime,qusnnStatus from questionnaire where userID=? AND ID <= (select ID from questionnaire where userID=? order by ID desc limit "+ before +",1) order by ID desc limit "+PAGESIZE+"";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			ps.setInt(2, userID);
			rs=ps.executeQuery();
			while(rs.next()){
				QusnnList qusnnList=new QusnnList();
				qusnnList.setQusnnID(rs.getInt("id"));
				qusnnList.setQuesnnTitle(rs.getString("quesnnTitle"));
				qusnnList.setQuesnnTime(rs.getString("quesnnTime"));
				qusnnList.setQusnnStatus(rs.getString("qusnnStatus"));
				qusnnList.setReceiveData(collectData(qusnnList.getQusnnID()));
				qusnnLists.add(qusnnList);
				//System.out.println("查询成功");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
			return qusnnLists;
	}

	public int allPage(int userID) {
		int allPage=0;
		String querySql="select count(*) as num from questionnaire where userID=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			rs=ps.executeQuery();
			while(rs.next()){
				int totalNum=rs.getInt("num");
				System.out.println("结果集条数："+totalNum);
				//如果totalNum%PAGESIZE==0，则allPage=totalNum%PAGESIZE。，否则等于totalNum%PAGESIZE+1
				allPage=totalNum%PAGESIZE==0?totalNum/PAGESIZE:totalNum/PAGESIZE+1;
				System.out.println("总页数："+allPage);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return allPage;
	}
	public ArrayList<QusnnList> queryCollectQusnn(int currentPage,int userID) {
		int before=(currentPage-1)*PAGESIZE;//计算当前页第一条记录的前面记录条数
		ArrayList<QusnnList> qusnnLists=new ArrayList<QusnnList>();
		String querySql="select ID,quesnnTitle,quesnnTime,userID from questionnaire where qusnnStatus='COLLECTING' AND ID <= (select ID from questionnaire where qusnnStatus='COLLECTING' order by ID desc limit "+ before +",1) order by ID desc limit "+PAGESIZE+"";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
			while(rs.next()){
				QusnnList qusnnList=new QusnnList();
				qusnnList.setQusnnID(rs.getInt("id"));
				qusnnList.setQuesnnTitle(rs.getString("quesnnTitle"));
				qusnnList.setQuesnnTime(rs.getString("quesnnTime"));
				//将ID转为Name存储
				qusnnList.setUserID(idToName(rs.getInt("userID")));
				qusnnList.setFillStatus(""+queryFillStatus(qusnnList.getQusnnID(), userID));
				//qusnnList.setQusnnStatus(rs.getString("qusnnStatus"));
				qusnnLists.add(qusnnList);
				//System.out.println("查询成功");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return qusnnLists;
	}
	
	public boolean queryFillStatus(int qusnID,int userID) {
		int num=0;
		boolean fillStatus=false;
		String querySql="select count(*) as num from investigate where userID=? AND questionnaireID=?;";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			ps.setInt(2, qusnID);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
			if(num!=0){
				fillStatus=true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
			return fillStatus;
	}
	public String idToName(int userID) {
		String userName=null;
		String querySql="select userName from user where Id=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			rs=ps.executeQuery();
			while(rs.next()){
				userName=rs.getString("userName");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
			return userName;
	}

	public int allCollectQusnPage() {
		int allPage=0;
		String querySql="select count(*) as num from questionnaire where qusnnStatus='COLLECTING'";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
			while(rs.next()){
				int totalNum=rs.getInt("num");
				System.out.println("收集中的问卷结果集条数："+totalNum);
				//如果totalNum%PAGESIZE==0，则allPage=totalNum%PAGESIZE。，否则等于totalNum%PAGESIZE+1
				allPage=totalNum%PAGESIZE==0?totalNum/PAGESIZE:totalNum/PAGESIZE+1;
				System.out.println("总页数："+allPage);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return allPage;
	}
}
