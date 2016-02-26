package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.Learning;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class LearningDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public int addLearning(Learning learning) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO learning(fileName,filePath,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, learning.getFileName());
			pstmt.setString(2, learning.getFilePath());
			pstmt.setString(3, learning.getOperator());
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
	public int updateLearning(Learning learning) {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE learning SET fileName=? WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, learning.getFileName());
			pstmt.setInt(2, learning.getFileID());
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
	public int deleteLearningById(int id) {
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("DELETE FROM learning WHERE id=?");
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
	public List<Learning> getLearning(PageBean pageBean) {
		sql=new StringBuffer("SELECT id,fileName,operator,createTime FROM learning ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Learning> learningList = new ArrayList<Learning>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Learning learning = new Learning();
				learning.setFileID(rs.getInt("id"));
				learning.setFileName(rs.getString("fileName"));
				learning.setOperator(rs.getString("operator"));
				learning.setCreateTime(rs.getString("createTime"));
				learningList.add(learning);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return learningList;
	}

	//通过ID获得学习天地文件信息
	public Learning getLearningById(int id) {
		sql= new StringBuffer("SELECT createTime,fileName,filePath,operator FROM learning WHERE id=?");
		Learning learning = new Learning();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				learning.setCreateTime(rs.getString("createTime"));
				learning.setFileName(rs.getString("fileName"));
				learning.setFilePath(rs.getString("filePath"));
				learning.setOperator(rs.getString("operator"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return learning;
	}
	
	//统计记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM learning");
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
