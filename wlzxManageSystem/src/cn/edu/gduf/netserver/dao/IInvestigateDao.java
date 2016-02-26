package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Investigate;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * 调查问卷数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IInvestigateDao {

	/**
	 * 保存调查问卷
	 * @param investigate
	 * @return
	 * @throws SQLException 
	 */
	public int addInvestigate(Investigate investigate) throws SQLException;
	
	/**
	 * 更新调查问卷
	 * @param investigate
	 * @return
	 */
	public int updateInvestigate(Investigate investigate);
	
	/**
	 * 根据id更新调查问卷
	 * @param id
	 * @return
	 */
	public int updateInvestigateById(int id);
	
	/**
	 * 根据id删除调查问卷
	 * @param id
	 * @return
	 */
	public int deleteInvestigateById(int id);
	
	/**
	 * 获得所有调查问卷
	 * @return
	 */
	public List<Investigate> getAllInvestigates();
	
	/**
	 * 根据调查问卷条件得到调查问卷集
	 * @param investigate
	 * @return
	 */
	public List<Investigate> getInvestigates(Investigate investigate);
	
	/**
	 * 根据分页条件得到调查问卷集
	 * @param pageBean
	 * @return
	 */
	public List<Investigate> getInvestigates(PageBean pageBean);
	
	/**
	 * 根据调查问卷条件和分页条件得到调查问卷集
	 * @param investigate
	 * @param pageBean
	 * @return
	 */
	public List<Investigate> getInvestigates(Investigate investigate, PageBean pageBean);
	
	/**
	 * 根据调查问卷Id获得调查问卷
	 * @param id
	 * @return
	 */
	public Investigate getInvestigateById(int id);
	
	/**
	 * 获得调查问卷总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据调查问卷条件获得调查问卷总数
	 * @param investigate
	 * @return
	 */
	public int count(Investigate investigate);
}
