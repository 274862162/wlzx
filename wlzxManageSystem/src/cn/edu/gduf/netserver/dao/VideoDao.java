package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Video;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class VideoDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public int addVideo(Video video) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO video(fileName,filePath,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, video.getFileName());
			pstmt.setString(2, video.getFilePath());
			pstmt.setString(3, video.getOperator());
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
	public int updateVideo(Video video) {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE video SET fileName=? WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, video.getFileName());
			pstmt.setInt(2, video.getFileID());
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
	public int deleteVideoById(int id) {
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("DELETE FROM video WHERE id=?");
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
	public List<Video> getVideo(PageBean pageBean) {
		sql=new StringBuffer("SELECT id,fileName,operator,createTime FROM video ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Video> videoList = new ArrayList<Video>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Video video = new Video();
				video.setFileID(rs.getInt("id"));
				video.setFileName(rs.getString("fileName"));
				video.setOperator(rs.getString("operator"));
				video.setCreateTime(rs.getString("createTime"));
				videoList.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return videoList;
	}

	//通过ID获得学习天地文件信息
	public Video getVideoById(int id) {
		sql= new StringBuffer("SELECT createTime,fileName,filePath,operator FROM video WHERE id=?");
		Video video = new Video();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				video.setCreateTime(rs.getString("createTime"));
				video.setFileName(rs.getString("fileName"));
				video.setFilePath(rs.getString("filePath"));
				video.setOperator(rs.getString("operator"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return video;
	}
	
	//统计记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM video");
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
