package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Notice;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * 公告数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface INoticeDao {

	/**
	 * 保存公告
	 * @param notice
	 * @return
	 * @throws SQLException 
	 */
	public int addNotice(Notice notice) throws SQLException;
	
	/**
	 * 更新公告
	 * @param notice
	 * @return
	 */
	public int updateNotice(Notice notice);
	
	/**
	 * 根据id公告
	 * @param id
	 * @return
	 */
	public int updateNoticeById(int id);
	
	/**
	 * 根据id删除公告
	 * @param id
	 * @return
	 */
	public int deleteNoticeById(int id);
	
	/**
	 * 获得所有公告
	 * @return
	 */
	public List<Notice> getAllNotices();
	
	/**
	 * 根据公告条件得到公告集
	 * @param notice
	 * @return
	 */
	public List<Notice> getNotices(Notice notice);
	
	/**
	 * 根据分页条件得到公告集
	 * @param pageBean
	 * @return
	 */
	public List<Notice> getNotices(PageBean pageBean);
	
	/**
	 * 根据公告条件和分页条件得到公告集
	 * @param notice
	 * @param pageBean
	 * @return
	 */
	public List<Notice> getNotices(Notice notice, PageBean pageBean);
	
	/**
	 * 根据公告Id获得公告
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(int id);
	
	/**
	 * 获得公告总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据公告条件获得公告总数
	 * @param notice
	 * @return
	 */
	public int count(Notice notice);
}
