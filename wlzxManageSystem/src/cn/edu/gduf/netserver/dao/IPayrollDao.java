package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Wage;

/**
 * 工资单数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IPayrollDao {

	/**
	 * 保存工资单
	 * @param payroll
	 * @return
	 * @throws SQLException 
	 */
	public int addPayroll(Wage payroll) throws SQLException;
	
	/**
	 * 更新工资单
	 * @param payroll
	 * @return
	 */
	public int updatePayroll(Wage payroll);
	
	/**
	 * 根据id工资单
	 * @param id
	 * @return
	 */
	public int updatePayrollById(int id);
	
	/**
	 * 根据id删除工资单
	 * @param id
	 * @return
	 */
	public int deletePayrollById(int id);
	
	/**
	 * 获得所有工资单
	 * @return
	 */
	public List<Wage> getAllPayrolls();
	
	/**
	 * 根据工资单条件得到工资单集
	 * @param payroll
	 * @return
	 */
	public List<Wage> getPayrolls(Wage payroll);
	
	/**
	 * 根据分页条件得到工资单集
	 * @param pageBean
	 * @return
	 */
	public List<Wage> getPayrolls(PageBean pageBean);
	
	/**
	 * 根据工资单条件和分页条件得到工资单集
	 * @param payroll
	 * @param pageBean
	 * @return
	 */
	public List<Wage> getPayrolls(Wage payroll, PageBean pageBean);
	
	/**
	 * 根据工资单Id获得工资单
	 * @param id
	 * @return
	 */
	public Wage getPayrollById(int id);
	
	/**
	 * 获得工资单总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据工资单条件获得工资单总数
	 * @param payroll
	 * @return
	 */
	public int count(Wage payroll);
}
