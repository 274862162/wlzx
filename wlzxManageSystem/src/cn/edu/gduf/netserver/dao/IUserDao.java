package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.domain.User;

/**
 * 用户数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IUserDao {
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 根据id更新用户
	 * @param id
	 * @return
	 */
	public int updateUserById(int id);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * 根据用户条件得到用户集
	 * @param user
	 * @return
	 */
	public List<User> getUsers(User user);
	
	/**
	 * 根据分页条件得到用户集
	 * @param pageBean
	 * @return
	 */
	public List<User> getUsers(PageBean pageBean);
	
	/**
	 * 根据用户条件和分页条件得到用户集
	 * @param user
	 * @param pageBean
	 * @return
	 */
	public List<User> getUsers(User user, PageBean pageBean);
	
	/**
	 * 根据id得到用户 
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	public int getIdByName(String name) throws SQLException;
	/**
	 * 获得用户总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据用户条件得到用户总数
	 * @param testPaper
	 * @return
	 */
	public int count(TestPaper testPaper);
	/**
	 * 根据用户名获取用户姓名--wmj20160206新增
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public String getNameByUserName(String userName) throws SQLException;
	/**
	 * 根据部门显示成员
	 * @param pageBean 分页
	 * @param option 部门
	 * @return
	 */
	public List<User> getUserList(PageBean pageBean,String option);
	/**统计部门记录人数
	 * @param section
	 * @return
	 */
	public int count(String section);
}