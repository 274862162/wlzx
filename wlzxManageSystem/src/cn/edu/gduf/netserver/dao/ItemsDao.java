package cn.edu.gduf.netserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Items;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.DbUtil;

public class ItemsDao implements IItemsDao {

	public int addItems(Items items) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateItems(Items items) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateItemsById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteItemsById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Items> getAllItemss() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Items> getItemss(Items items) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Items> getItemss(PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Items> getItemss(Items items, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Items getItemsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(Items items) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getItemID(Items item){
		String name=item.getItemName();
		int ID = 0;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pre = null;
		try{
			conn= DbUtil.getCon();
			pre = conn.prepareStatement("select itemID from items where itemName=?");
			pre.setString(1,name);
			rs=pre.executeQuery();
			if(rs.next()){
				ID=rs.getInt("itemID");
				System.out.print("查找成功。");
			}
			else{
				System.out.print("查找失败。");
			}
			rs.close();
			pre.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ID;
	}

}
