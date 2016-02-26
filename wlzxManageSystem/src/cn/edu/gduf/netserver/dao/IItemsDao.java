package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Items;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * 物品数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IItemsDao {

	/**
	 * 保存物品
	 * @param Items
	 * @return
	 * @throws SQLException 
	 */
	public int addItems(Items items) throws SQLException;
	
	/**
	 * 更新物品
	 * @param items
	 * @return
	 */
	public int updateItems(Items items);

	/**
	 * 根据id更新物品
	 * @param id
	 * @return
	 */
	public int updateItemsById(int id);
	
	/**
	 * 根据id删除物品
	 * @param id
	 * @return
	 */
	public int deleteItemsById(int id);
	
	/**
	 * 获得所有物品
	 * @return
	 */
	public List<Items> getAllItemss();
	
	/**
	 * 根据物品条件得到物品集
	 * @param items
	 * @return
	 */
	public List<Items> getItemss(Items items);
	
	/**
	 * 根据分页条件得到物品集
	 * @param pageBean
	 * @return
	 */
	public List<Items> getItemss(PageBean pageBean);
	
	/**
	 * 根据物品条件和分页条件得到物品集
	 * @param items
	 * @param pageBean
	 * @return
	 */
	public List<Items> getItemss(Items items, PageBean pageBean);
	
	/**
	 * 根据物品Id获得物品
	 * @param id
	 * @return
	 */
	public Items getItemsById(int id);
	
	/**
	 * 获得物品总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据物品条件获得物品总数
	 * @param items
	 * @return
	 */
	public int count(Items items);
}
