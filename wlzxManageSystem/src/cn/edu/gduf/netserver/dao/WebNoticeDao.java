package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.WebNotice;
import cn.edu.gduf.netserver.util.DbUtil;

public class WebNoticeDao implements IWebNoticeDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public int addWebNotice(WebNotice webNotice) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO web_notice(content,title,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, webNotice.getContent());
			pstmt.setString(2, webNotice.getTitle());
			pstmt.setString(3, webNotice.getOperator());
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
	//更新前台公告
	public int updateWebNotice(WebNotice webNotice) {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE web_notice SET title=?,content=? WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, webNotice.getTitle());
			pstmt.setString(2, webNotice.getContent());
			pstmt.setInt(3, webNotice.getNoticeID());		
			i = pstmt.executeUpdate();
			System.out.println(i);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}

	public int updateWebNoticeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	//删除前台公告
	public int deleteWebNoticeById(int id) {
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("DELETE FROM web_notice WHERE id=?");
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<WebNotice> getAllWebNotice() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebNotice> getWebNotice(WebNotice webNotice) {
		// TODO Auto-generated method stub
		return null;
	}
	//得到公告列表
	public List<WebNotice> getWebNotice(PageBean pageBean) {
		sql=new StringBuffer("SELECT id,title,content,operator,createTime FROM web_notice ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<WebNotice> webNoticeList = new ArrayList<WebNotice>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WebNotice webNotice = new WebNotice();
				webNotice.setNoticeID(rs.getInt("Id"));
				webNotice.setContent(rs.getString("content"));
				webNotice.setTitle(rs.getString("title"));
				webNotice.setOperator(rs.getString("operator"));
				webNotice.setCreateTime(rs.getString("createTime"));
				webNoticeList.add(webNotice);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return webNoticeList;
	}

	public List<WebNotice> getWebNotice(WebNotice webNotice, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}
	//通过ID获得前台公告对象
	public WebNotice getWebNoticeById(int id) {
		sql= new StringBuffer("SELECT title,content FROM web_notice WHERE id=?");
		WebNotice webNotice = new WebNotice();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				webNotice.setTitle(rs.getString("title"));
				webNotice.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return webNotice;
	}
	
	//统计记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM web_notice");
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
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
	}
	
	public int count(WebNotice webNotice) {
		return 0;
	}

}
