package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.gduf.netserver.domain.Hold_items;
import cn.edu.gduf.netserver.util.DbUtil;

public class HoldingDao {
	static int ID=0;
	public boolean updateArtRegInfo(Hold_items holding,int[] items){
		boolean b = true;
		Connection conn = null;
		PreparedStatement pre = null;
		try{
			conn= DbUtil.getCon();
			for(int i=0,j=1;i<items.length;i++,j++){
				pre = conn.prepareStatement("insert into hold_items values(?,?,?,?)");
				pre.setInt(1,++ID);
				pre.setInt(2,j);
				pre.setInt(3,holding.getUserID());
				pre.setInt(4,items[i]);
				if(pre.executeUpdate()<=0){
					b = false;
				}
			}
			pre.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
}
