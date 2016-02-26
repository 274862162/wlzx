package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Note;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;
public class DutyRegisterListDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	public int count(){
		int num=0;
		sql= new StringBuffer("SELECT count(*) as count FROM Note");
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
	public List<Note> getDutyRegisters(PageBean pageBean){
		sql= new StringBuffer("SELECT Id,fillTime,content,recorder,status FROM Note ORDER BY Id  desc");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Note> noteList = new ArrayList<Note>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Note note = new Note();
				note.setNoteID(rs.getInt("Id"));
				note.setFillTime(rs.getString("fillTime"));
				note.setContent(rs.getString("content"));
				note.setRecorder(rs.getString("recorder"));
				note.setStatus(rs.getBoolean("status"));
				noteList.add(note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return noteList;
	}
}
