package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Switch;

/**
 * 交换机数据访问接口
 * @author hsg
 * 2015/01/23
 */
public interface ISwitchDao {

	/**
	 * 保存交换机
	 * @param s
	 * @return
	 * @throws SQLException 
	 */
	public int addSwitch(Switch s) throws SQLException;
	
	/**
	 * 更新交换机
	 * @param s
	 * @return
	 */
	public int updateSwitch(Switch s);
	
	/**
	 * 根据id更新交换机
	 * @param id
	 * @return
	 */
	public int updateSwitchById(int id);
	
	/**
	 * 根据id删除交换机
	 * @param id
	 * @return
	 */
	public int deleteSwitchById(int id);
	
	/**
	 * 获得所有交换机
	 * @return
	 */
	public List<Switch> getAllSwitchs();
	
	/**
	 * 根据交换机条件得到交换机集
	 * @param s
	 * @return
	 */
	public List<Switch> getSwitchs(Switch s);
	
	/**
	 * 根据分页条件得到交换机集
	 * @param pageBean
	 * @return
	 */
	public List<Switch> getSwitchs(PageBean pageBean);
	
	/**
	 * 根据交换机条件和分页条件得到交换机集
	 * @param s
	 * @param pageBean
	 * @return
	 */
	public List<Switch> getSwitchs(Switch s, PageBean pageBean);
	
	/**
	 * 根据交换机Id获得交换机
	 * @param id
	 * @return
	 */
	public Switch getSwitchById(int id);
	
	/**
	 * 获得交换机总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据交换机条件获得交换机总数
	 * @param s
	 * @return
	 */
	public int count(Switch s);
}
