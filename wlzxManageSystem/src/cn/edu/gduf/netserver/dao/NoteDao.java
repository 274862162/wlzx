package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import cn.edu.gduf.netserver.domain.Note;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

public class NoteDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	//查看值班记事的内容
	public Note check(int noteID){
		Note note = new Note();
		note.setNoteID(noteID);
		sql= new StringBuffer("SELECT content,recorder,fillTime,status,handler,dealingContent FROM Note WHERE Id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,noteID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				note.setContent(rs.getString("content"));
				note.setRecorder(rs.getString("recorder"));
				note.setFillTime(rs.getString("fillTime"));
				note.setStatus(rs.getBoolean("status"));
				note.setHandler(rs.getString("handler"));
				note.setDealingContent(rs.getString("dealingContent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return note;
	}
	//处理值班记事，增加处理说明
	public Boolean dealing(int noteID,String dealingContent,String handle,boolean status){
		boolean isDealing = false;
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		System.out.println(fillTime);
		sql= new StringBuffer("update Note SET dealingContent=?, handler=?, dealingTime=?, status=? WHERE Id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,dealingContent);
			pstmt.setString(2,handle);
			pstmt.setTimestamp(3,new java.sql.Timestamp(fillTime.getTime()));
			pstmt.setBoolean(4, status);
			pstmt.setInt(5,noteID);
			int line = pstmt.executeUpdate();
			if(line!=0){
				isDealing = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return isDealing;
	}
	
	//登记值班记事
	public Boolean insert(String content,String recorder,boolean status){
		boolean isInsert = false;
		java.util.Date fillTime=new java.util.Date();//获得当前时间
		System.out.println(fillTime);
		sql= new StringBuffer("INSERT INTO note(fillTime,content,status,recorder) VALUES(?,?,?,?)");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setTimestamp(1,new java.sql.Timestamp(fillTime.getTime()));
			pstmt.setString(2,content);
			pstmt.setBoolean(3,status);
			pstmt.setString(4,recorder);
			if(pstmt.executeUpdate()!=0){
				isInsert = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return isInsert;
	}
}
