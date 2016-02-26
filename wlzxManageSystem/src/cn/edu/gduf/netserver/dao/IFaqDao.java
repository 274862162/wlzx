package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Faq;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * Faq(常见问题解答)数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IFaqDao {

	/**
	 * 添加Faq
	 * @param faq
	 * @return
	 * @throws SQLException 
	 */
	public int addFaq(Faq faq) throws SQLException;
	
	/**
	 * 更新Faq
	 * @param faq
	 * @return
	 */
	public int updateFaq(Faq faq);
	
	/**
	 * 根据id更新Faq
	 * @param id
	 * @return
	 */
	public int updateFaqById(int id);
	
	/**
	 * 根据id删除Faq
	 * @param id
	 * @return
	 */
	public int deleteFaqById(int id);
	
	/**
	 * 获得所有Faq
	 * @return
	 */
	public List<Faq> getAllFaqs();
	
	/**
	 * 根据Faq条件得到Faq集
	 * @param faq
	 * @return
	 */
	public List<Faq> getFaqs(Faq faq);
	
	/**
	 * 根据分页条件得到Faq集
	 * @param pageBean
	 * @return
	 */
	public List<Faq> getFaqs(PageBean pageBean);
	
	/**
	 * 根据Faq条件和分页条件得到Faq集
	 * @param faq
	 * @param pageBean
	 * @return
	 */
	public List<Faq> getFaqs(Faq faq, PageBean pageBean);
	
	/**
	 * 根据考核Id获得Faq
	 * @param id
	 * @return
	 */
	public Faq getFaqById(int id);
	
	/**
	 * 获得Faq总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据Faq条件获得Faq总数
	 * @param faq
	 * @return
	 */
	public int count(Faq faq);
}
