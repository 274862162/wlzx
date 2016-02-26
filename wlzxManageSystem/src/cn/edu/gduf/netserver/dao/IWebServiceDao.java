package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.WebService;

/**
 * 网络服务数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IWebServiceDao {

	/**
	 * 保存网络服务
	 * @param webService
	 * @return
	 * @throws SQLException 
	 */
	public int addWebService(WebService webService) throws SQLException;
	
	/**
	 * 更新网络服务
	 * @param webService
	 * @return
	 */
	public int updateWebService(WebService webService);
	
	/**
	 * 根据id更新网络服务
	 * @param id
	 * @return
	 */
	public int updateWebServiceById(int id);
	
	/**
	 * 根据id删除网络服务
	 * @param id
	 * @return
	 */
	public int deleteWebServiceById(int id);
	
	/**
	 * 获得所有网络服务
	 * @return
	 */
	public List<WebService> getAllWebServices();
	
	/**
	 * 根据网络服务条件得到网络服务集
	 * @param webService
	 * @return
	 */
	public List<WebService> getWebServices(WebService webService);
	
	/**
	 * 根据分页条件得到网络服务集
	 * @param pageBean
	 * @return
	 */
	public List<WebService> getWebServices(PageBean pageBean);
	
	/**
	 * 根据网络服务条件和分页条件得到网络服务集
	 * @param webService
	 * @param pageBean
	 * @return
	 */
	public List<WebService> getWebServices(WebService webService, PageBean pageBean);
	
	/**
	 * 根据网络服务Id获得网络服务
	 * @param id
	 * @return
	 */
	public WebService getWebServiceById(int id);
	
	/**
	 * 获得网络服务总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据网络服务条件获得网络服务总数
	 * @param WebService
	 * @return
	 */
	public int count(WebService webService);
}
