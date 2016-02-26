package cn.edu.gduf.netserver.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.DownloadSection;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class DownloadSectionDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public int addDownloadSection(DownloadSection downloadSection) throws SQLException {
		int i = 0;	//影响的条数
		sql= new StringBuffer("INSERT INTO download_section(fileName,filePath,operator,createTime) VALUES(?,?,?,?)");
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, downloadSection.getFileName());
			pstmt.setString(2, downloadSection.getFilePath());
			pstmt.setString(3, downloadSection.getOperator());
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

	public int updateDownloadSection(DownloadSection downloadSection) {
		int i = 0;	//影响的条数
		sql= new StringBuffer("UPDATE download_section SET fileName=?,filePath=? WHERE Id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, downloadSection.getFileName());
			pstmt.setString(2, downloadSection.getFilePath());
			pstmt.setInt(3, downloadSection.getDownloadSectionFileID());
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
	public int deleteDownloadSectionById(int id) {
		int result = 0;//影响的条数
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement("DELETE FROM download_section WHERE id=?");
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
	public List<DownloadSection> getDownloadSection(PageBean pageBean) {
		sql=new StringBuffer("SELECT id,fileName,operator,createTime FROM download_section ORDER BY id DESC");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<DownloadSection> downloadSectionList = new ArrayList<DownloadSection>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DownloadSection downloadSection = new DownloadSection();
				downloadSection.setDownloadSectionFileID(rs.getInt("Id"));
				downloadSection.setFileName(rs.getString("fileName"));
				downloadSection.setOperator(rs.getString("operator"));
				downloadSection.setCreateTime(rs.getString("createTime"));
				downloadSectionList.add(downloadSection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return downloadSectionList;
	}

	//通过ID获得下载专区对象
	public DownloadSection getDownloadSectionById(int id) {
		sql= new StringBuffer("SELECT fileName,filePath FROM download_section WHERE id=?");
		DownloadSection downloadSection = new DownloadSection();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				downloadSection.setFileName(rs.getString("fileName"));
				downloadSection.setFilePath(rs.getString("filePath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return downloadSection;
	}
	
	//统计记录数
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM download_section");
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
