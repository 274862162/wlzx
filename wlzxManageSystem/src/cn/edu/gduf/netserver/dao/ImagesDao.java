package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.Images;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class ImagesDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public int addImages(Images images) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO images(fileName,filePath,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, images.getFileName());
			pstmt.setString(2, images.getFilePath());
			pstmt.setString(3, images.getOperator());
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

	public int updateImages(Images images) {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE images SET fileName=?,filePath=? WHERE Id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, images.getFileName());
			pstmt.setString(2, images.getFilePath());
			pstmt.setInt(3, images.getImagesID());
			i = pstmt.executeUpdate();
			System.out.println(i);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return i;
	}
	//删除前台公告
	public int deleteImagesById(int id) {
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("DELETE FROM images WHERE id=?");
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

	//得到下载专区列表
	public List<Images> getImages(PageBean pageBean) {
		sql=new StringBuffer("SELECT id,fileName,operator,createTime FROM images ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Images> imagesList = new ArrayList<Images>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Images images = new Images();
				images.setImagesID(rs.getInt("Id"));
				images.setFileName(rs.getString("fileName"));
				images.setOperator(rs.getString("operator"));
				images.setCreateTime(rs.getString("createTime"));
				imagesList.add(images);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return imagesList;
	}

	//通过ID获得下载专区对象
	public Images getImagesById(int id) {
		sql= new StringBuffer("SELECT fileName,filePath FROM images WHERE id=?");
		Images images = new Images();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				images.setFileName(rs.getString("fileName"));
				images.setFilePath(rs.getString("filePath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return images;
	}
	
	//统计记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM images");
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
