package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.WebNotice;

public interface IWebNoticeDao {
	/**
	 * 保存网络服务
	 * @param webService
	 * @return
	 * @throws SQLException 
	 */
	public int addWebNotice(WebNotice webNotice) throws SQLException;
	
	/**
	 * 更新网络服务
	 * @param webService
	 * @return
	 */
	public int updateWebNotice(WebNotice webNotice);
	
	/**
	 * 根据id更新网络服务
	 * @param id
	 * @return
	 */
	public int updateWebNoticeById(int id);
	
	/**
	 * 根据id删除网络服务
	 * @param id
	 * @return
	 */
	public int deleteWebNoticeById(int id);
	
	/**
	 * 获得所有网络服务
	 * @return
	 */
	public List<WebNotice> getAllWebNotice();
	
	/**
	 * 根据网络服务条件得到网络服务集
	 * @param webService
	 * @return
	 */
	public List<WebNotice> getWebNotice(WebNotice webNotice);
	
	/**
	 * 根据分页条件得到网络服务集
	 * @param pageBean
	 * @return
	 */
	public List<WebNotice> getWebNotice(PageBean pageBean);
	
	/**
	 * 根据网络服务条件和分页条件得到网络服务集
	 * @param webService
	 * @param pageBean
	 * @return
	 */
	public List<WebNotice> getWebNotice(WebNotice webNotice, PageBean pageBean);
	
	/**
	 * 根据网络服务Id获得网络服务
	 * @param id
	 * @return
	 */
	public WebNotice getWebNoticeById(int id);
	
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
	public int count(WebNotice webNotice);
}
