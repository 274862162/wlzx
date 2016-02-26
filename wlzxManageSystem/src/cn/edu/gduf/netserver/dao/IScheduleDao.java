package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Free;
import cn.edu.gduf.netserver.domain.FreeTable;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.UserFreeTable;

/**
 * 无课表数据访问接口
 * @author hsg
 * 2015/02/22
 */
public interface IScheduleDao {

	/**
	 * 保存无课时间段记录
	 * @param free
	 * @return
	 * @throws SQLException 
	 */
	public int addFree(Free free) throws SQLException;
	
	/**
	 * 保存用户与无课表间的关联
	 * @param userFreeTable
	 * @return
	 * @throws SQLException 
	 */
	public int addUserFreeTable(UserFreeTable userFreeTable) throws SQLException;
	
	/**
	 * 根据分页条件得到各个学期无课表
	 * @param FreeTable
	 * @return
	 */
	public List<FreeTable> getFreeTables(PageBean pageBean);
	
	/**
	 * 获得无课表总数
	 * @return
	 */
	public int count();
	
	/**
	 * 获得UserFreeTable表的最大id值
	 * @return
	 * @throws SQLException 
	 */
	public int getMaxUserFreeTableId() throws SQLException;
	
	/**
	 * 获得UserFreeTableId
	 * @return
	 * @throws SQLException 
	 */
	public int getUserFreeTableId(int userID, int freeTableID) throws SQLException;
	
	/**
	 * 获得UserFreeTableId
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getUserFreeTableId(int freeTableID) throws SQLException;
	
	/**
	 * 根据UserFreeTableId获得具体无课时间段
	 * @param userFreeTableId
	 * @return
	 */
	public List<Free> getFrees(int userFreeTableId);
	
	/**
	 * 根据id获得FreeTable
	 * @param id
	 * @return
	 */
	public FreeTable getFreeTableById(int id);
	
	/**
	 * 根据id得到用户UserFreeTable
	 * @param userFreeTableId
	 * @return
	 */
	public UserFreeTable getUserFreeTableById(int id);
	
	/**
	 * 获得所有UserFreeTable
	 * @return
	 */
	public List<UserFreeTable> getUserFreeTables();
	
}
