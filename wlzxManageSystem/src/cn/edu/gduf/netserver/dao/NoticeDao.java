package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Notice;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DbUtil;

public class NoticeDao implements INoticeDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;

	public int addNotice(Notice notice) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO notice(content,department,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, notice.getContent());
			pstmt.setString(2, notice.getDepartment());
			pstmt.setString(3, notice.getOperator());
			pstmt.setTimestamp(4,new java.sql.Timestamp(fillTime.getTime()));			
			i = pstmt.executeUpdate();
			System.out.println(i);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}

	public int updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateNoticeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteNoticeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Notice> getAllNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Notice> getNotices(Notice notice) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Notice> getNotices(PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Notice> getNotices(Notice notice, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice getNoticeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Notice getNotice(String department) {
		Notice notice = new Notice();
		ResultSet rs = null;
		sql= new StringBuffer("SELECT * FROM notice WHERE department=? order by createTime desc limit 0,1 ");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, department);
			rs = pstmt.executeQuery();
			if(rs.next()){
				notice.setContent(rs.getString("content"));
				notice.setDepartment(rs.getString("department"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return notice;
	}
	
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
