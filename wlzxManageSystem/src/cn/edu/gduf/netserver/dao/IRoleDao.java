package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Role;

/**
 * 角色数据访问接口
 * @author hsg
 * 2015/01/23
 */
public interface IRoleDao {

	/**
	 * 保存角色
	 * @param role
	 * @return
	 * @throws SQLException 
	 */
	public int addRole(Role role) throws SQLException;
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public int updateRole(Role role);
	
	/**
	 * 根据id更新角色
	 * @param id
	 * @return
	 */
	public int updateRoleById(int id);
	
	/**
	 * 根据id删除角色
	 * @param id
	 * @return
	 */
	public int deleteRoleById(int id);
	
	/**
	 * 获得所有角色
	 * @return
	 */
	public List<Role> getAllRoles();
	
	/**
	 * 根据角色条件得到角色集
	 * @param role
	 * @return
	 */
	public List<Role> getRoles(Role role);
	
	/**
	 * 根据分页条件得到角色集
	 * @param pageBean
	 * @return
	 */
	public List<Role> getRoles(PageBean pageBean);
	
	/**
	 * 根据角色条件和分页条件得到角色集
	 * @param role
	 * @param pageBean
	 * @return
	 */
	public List<Role> getRoles(Role role, PageBean pageBean);
	
	/**
	 * 根据角色Id获得角色
	 * @param id
	 * @return
	 */
	public Role getRoleById(int id);
	
	/**
	 * 获得角色总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据角色条件获得角色总数
	 * @param role
	 * @return
	 */
	public int count(Role role);
}
