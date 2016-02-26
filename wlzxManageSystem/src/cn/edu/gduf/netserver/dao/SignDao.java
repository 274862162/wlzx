package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.gduf.netserver.domain.Sign;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.DbUtil;

public class SignDao {
	public int getDutyTime(User user){
		String name = user.getUserName();
		int dutyTime = 1;
		Connection conn = null;
		java.sql.ResultSet rs = null;
		PreparedStatement pre = null;
		try{
			conn= DbUtil.getCon();
			pre = conn.prepareStatement("select dutyTime from user where userName=?");
			pre.setString(1,name);
			rs=pre.executeQuery();
			if(rs.next()){
				dutyTime = rs.getInt("dutyTime");
			}
			rs.close();
			pre.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dutyTime;
	}
	public boolean addRecord(Sign sign){
		boolean b = false;
		Connection conn = null;
		PreparedStatement pre = null;
		try{
			conn= DbUtil.getCon();
			pre = conn.prepareStatement("insert into sign(userId,signTime,isLate) values(?,?,?)");
			pre.setInt(1,sign.getUserID());
			pre.setTimestamp(2,new java.sql.Timestamp(sign.getSignTime().getTime()));
			pre.setBoolean(3,sign.getIsLate());
			if(pre.executeUpdate()>0){
				b = true;
			}
			pre.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
}
