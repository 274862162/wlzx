package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.edu.gduf.netserver.domain.Switch;
import cn.edu.gduf.netserver.util.DbUtil;

public class SearchSwitchDao {
	public Switch searchSwitch(int building,int buildingNo ){
		Switch s = new Switch();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pre = null;	
		try{
			conn= DbUtil.getCon();
			pre = conn.prepareStatement("select photo,switchRegister from switch where building=? and buildingNo=?");
			pre.setInt(1,building);
			pre.setInt(2,buildingNo);
			rs=pre.executeQuery();
			if(rs.next()){
				s.setPhoto(rs.getString("photo"));
				s.setSwitchRegister(rs.getString("switchRegister"));
				System.out.print("search查找成功。");
			}
			rs.close();
			pre.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
}
