package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Material;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * 资料数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IMaterialDao {

	/**
	 * 保存资料
	 * @param material
	 * @return
	 * @throws SQLException 
	 */
	public int addMaterial(Material material) throws SQLException;
	
	/**
	 * 更新资料
	 * @param material
	 * @return
	 */
	public int updateMaterial(Material material);
	
	/**
	 * 根据id更新资料
	 * @param id
	 * @return
	 */
	public int updateMaterialById(int id);
	
	/**
	 * 根据id删除资料
	 * @param id
	 * @return
	 */
	public int deleteMaterialById(int id);
	
	/**
	 * 获得所有资料
	 * @return
	 */
	public List<Material> getAllMaterials();
	
	/**
	 * 根据资料条件得到资料集
	 * @param material
	 * @return
	 */
	public List<Material> getMaterials(Material material);
	
	/**
	 * 根据分页条件得到资料集
	 * @param pageBean
	 * @return
	 */
	public List<Material> getMaterials(PageBean pageBean);
	
	/**
	 * 根据资料条件和分页条件得到资料集
	 * @param material
	 * @param pageBean
	 * @return
	 */
	public List<Material> getMaterials(Material material, PageBean pageBean);
	
	/**
	 * 根据资料Id获得资料
	 * @param id
	 * @return
	 */
	public Material getMaterialById(int id);
	
	/**
	 * 获得资料总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据资料条件获得资料总数
	 * @param material
	 * @return
	 */
	public int count(Material material);
}
