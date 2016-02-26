package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.WebService;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class WebServiceDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public int addWebService(WebService webService) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO web_service(fileName,filePath,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, webService.getFileName());
			pstmt.setString(2, webService.getFilePath());
			pstmt.setString(3, webService.getOperator());
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
	//更新学习天地文件
	public int updateWebService(WebService webService) {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE web_service SET fileName=? WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, webService.getFileName());
			pstmt.setInt(2, webService.getFileID());
			i = pstmt.executeUpdate();
			System.out.println(i);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}

	//删除学习天地文件
	public int deleteWebServiceById(int id) {
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("DELETE FROM web_service WHERE id=?");
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			System.out.println("result="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	//得到学习天地文件列表
	public List<WebService> getWebService(PageBean pageBean) {
		sql=new StringBuffer("SELECT id,fileName,operator,createTime FROM web_service ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<WebService> webServiceList = new ArrayList<WebService>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WebService webService = new WebService();
				webService.setFileID(rs.getInt("id"));
				webService.setFileName(rs.getString("fileName"));
				webService.setOperator(rs.getString("operator"));
				webService.setCreateTime(rs.getString("createTime"));
				webServiceList.add(webService);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return webServiceList;
	}

	//通过ID获得学习天地文件信息
	public WebService getWebServiceById(int id) {
		sql= new StringBuffer("SELECT createTime,fileName,filePath,operator FROM web_service WHERE id=?");
		WebService webService = new WebService();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				webService.setCreateTime(rs.getString("createTime"));
				webService.setFileName(rs.getString("fileName"));
				webService.setFilePath(rs.getString("filePath"));
				webService.setOperator(rs.getString("operator"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return webService;
	}
	
	//统计记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM web_service");
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
}
