package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Programme;

/**
 * 活动方案数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IProgrammeDao {

	/**
	 * 保存活动方案
	 * @param programme
	 * @return
	 * @throws SQLException 
	 */
	public int addProgramme(Programme programme) throws SQLException;
	
	/**
	 * 更新活动方案
	 * @param programme
	 * @return
	 */
	public int updateProgramme(Programme programme);
	
	/**
	 * 根据id更新活动方案
	 * @param id
	 * @return
	 */
	public int updateProgrammeById(int id);
	
	/**
	 * 根据id删除活动方案
	 * @param id
	 * @return
	 */
	public int deleteProgrammeById(int id);
	
	/**
	 * 获得所有活动方案
	 * @return
	 */
	public List<Programme> getAllProgrammes();
	
	/**
	 * 根据活动方案条件得到活动方案集
	 * @param programme
	 * @return
	 */
	public List<Programme> getProgrammes(Programme programme);
	
	/**
	 * 根据分页条件得到活动方案集
	 * @param pageBean
	 * @return
	 */
	public List<Programme> getProgrammes(PageBean pageBean);
	
	/**
	 * 根据活动方案条件和分页条件得到活动方案集
	 * @param programme
	 * @param pageBean
	 * @return
	 */
	public List<Programme> getProgrammes(Programme programme, PageBean pageBean);
	
	/**
	 * 根据活动方案Id获得活动方案
	 * @param id
	 * @return
	 */
	public Programme getProgrammeById(int id);
	
	/**
	 * 获得活动方案总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据活动方案条件获得活动方案总数
	 * @param programme
	 * @return
	 */
	public int count(Programme programme);
}
