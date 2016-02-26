package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.DbUtil;

public class SearchDao {
	
	public ArrayList<User> search(String type,String parame){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pre = null;	
		ArrayList<User> searchUsers=new ArrayList<User>();
		try{
			conn= DbUtil.getCon();
			if(type.equals("dormitory")){
				pre = conn.prepareStatement("select sno,name,dormitory,repArea,section,longTelephone,shortTelephone from user where dormitory LIKE '%"+parame+"%'");
			}else if(type.equals("repArea")){
				pre = conn.prepareStatement("select sno,name,dormitory,repArea,section,longTelephone,shortTelephone from user where repArea LIKE '%"+parame+"%'");
			}else{
				if(parame.length()==11){
					pre = conn.prepareStatement("select sno,name,dormitory,repArea,section,longTelephone,shortTelephone from user where longTelephone like '%"+parame+"%'");
				}else{
					pre = conn.prepareStatement("select sno,name,dormitory,repArea,section,longTelephone,shortTelephone from user where shortTelephone like '%"+parame+"%'");
				}
			}
			rs=pre.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setDormitory(rs.getString("dormitory"));
				user.setRepArea(rs.getString("repArea"));
				user.setSection(rs.getString("section"));
				user.setLongTelephone(rs.getString("longTelephone"));
				user.setShortTelephone(rs.getString("shortTelephone"));
				searchUsers.add(user);
				System.out.print("search查找成功。");
			}
			rs.close();
			pre.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchUsers;
	} 
}
