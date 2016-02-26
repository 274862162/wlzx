package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.domain.Log;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class SystemLogListDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	public void addLog(Log log){
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		sql=new StringBuffer("insert into log(type,content,operator,operationTime) values(?,?,?,?);");
		try{
			conn=DbUtil.getCon();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1,Integer.parseInt(log.getType()));
			pstmt.setString(2, log.getContent());
			pstmt.setString(3, log.getOperator());
			pstmt.setTimestamp(4,new java.sql.Timestamp(fillTime.getTime()));
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM log");
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
		}
		return num;
	}
	
	public int count(String type,String operator,Date date1,Date date2,String content){
		int num=0;
		sql=new StringBuffer("SELECT count(*) as count FROM log a,log_name b where a.type=b.type");
		if(type!=null){
			sql.append(" and b.name='"+type+"'");
		}
		if(operator!=null){
			sql.append(" and a.operator='"+operator+"'");
		}
		if(date1!=null){
			sql.append(" and a.operationTime>='"+date1+"'");
		}
		if(date2!=null){
			sql.append(" and a.operationTime<='"+date2+"'");
		}
		if(content!=null){
			sql.append(" and a.content='"+content+"'");
		}
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
		}
		return num;
	}
	
	public List<Log> getList(PageBean pageBean,String type,String operator,Date date1,Date date2,String content){
		sql=new StringBuffer("SELECT a.id, b.name,a.content,a.operator,a.operationTime FROM log a,log_name b where a.type=b.type");
		if(type!=null){
			sql.append(" and b.name='"+type+"'");
		}
		if(operator!=null){
			sql.append(" and a.operator='"+operator+"'");
		}
		if(date1!=null){
			sql.append(" and a.operationTime>='"+date1+"'");
		}
		if(date2!=null){
			sql.append(" and a.operationTime<='"+date2+"'");
		}
		if(content!=null){
			sql.append(" and a.content like '%"+content+"%'");
		}
		sql.append(" ORDER BY a.id desc");
		System.out.println(sql);
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Log> logList = new ArrayList<Log>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Log log = new Log();
				log.setID(rs.getInt("Id"));
				log.setType(rs.getString("name"));
				log.setContent(rs.getString("content"));
				log.setOperator(rs.getString("operator"));
				log.setOperatorTime(rs.getString("operationTime"));
				logList.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return logList;
	}
}
