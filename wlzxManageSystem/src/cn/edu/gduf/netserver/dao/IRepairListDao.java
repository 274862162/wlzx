package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.RepairAlyResult;
import cn.edu.gduf.netserver.domain.RepairAnalyze;
import cn.edu.gduf.netserver.domain.RepairList;

/**
 * 报修单数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IRepairListDao {

	/**
	 * 保存报修单
	 * @param repairList
	 * @return
	 * @throws SQLException 
	 */
	public void addRepairList(RepairList repairList) throws SQLException;
	
	/**
	 * 更新报修单
	 * @param repairList
	 * @return
	 */
	public int updateRepairList(RepairList repairList);
	
	/**
	 * 根据id更新报修单
	 * @param id
	 * @return
	 */
	public int updateRepairListById(int id);
	
	/**
	 * 根据id删除报修单
	 * @param id
	 * @return
	 */
	public int deleteRepairListById(int id);
	
	/**
	 * 获得所有报修单
	 * @return
	 */
	public List<RepairList> getAllRepairLists();
	
	/**
	 * 根据报修单条件得到报修单集
	 * @param repairList
	 * @return
	 */
	public List<RepairList> getRepairLists(RepairList repairList);
	
	/**
	 * 根据分页条件得到报修单集
	 * @param pageBean
	 * @return
	 */
	public ArrayList<RepairList> getRepairLists(PageBean pageBean);
	
	/**
	 * 根据报修单条件和分页条件得到报修单集
	 * @param repairList
	 * @param pageBean
	 * @return
	 */
	public List<RepairList> getRepairLists(RepairList repairList, PageBean pageBean);
	
	/**
	 * 根据报修单Id获得报修单
	 * @param id
	 * @return
	 */
	public RepairList getRepairListById(int id);
	
	/**
	 * 获得报修单总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据报修单条件获得各个学生报修单总数
	 * @param repairList
	 * @return
	 */
	public int count(RepairList repairList);

	/**
	 * 根据ID更新报修单评论
	 * @param id 报修单ID
	 */
	public void updateEvaluationByID(String id,String level);
	/**
	 * 通过网管ID得到自己的报修单
	 * @param id 网管ID
	 * @return 报修单实体类集
	 */
	public ArrayList<RepairList> getRepairListByID(int id,PageBean pageBean);
	/**
	 * 根据网管ID获得各个网管报修单总数
	 * @param repairList
	 * @return
	 */
	public int countUser(int userID);
	/**
	 * 获得报修单总数
	 * @param repairList
	 * @return
	 */
	public int countAllRepairLists();
	/**
	 * 得到所有网管用户名连接字符串，以，分割
	 * @return
	 */
	public String getAlluserName();
	/**
	 * 根据年、月、网管姓名分析报修数据
	 * @param year
	 * @param month
	 * @param name
	 * @return
	 */
	public ArrayList<RepairAlyResult> alyReapair(String year,String month,String name);
	/**
	 * 根据年月日查出单个结果
	 * @param year
	 * @param month
	 * @param name
	 * @return
	 */
	public RepairAlyResult aResult(String year,String month,String name);
	/**
	 * 根据年、月分析报修数据
	 * @param year
	 * @param month
	 * @return
	 */
	public ArrayList<RepairAlyResult> alyReapairByYM(String year,String month);
	/**
	 * 根据年、网管姓名分析报修数据
	 * @param year
	 * @param month
	 * @return
	 */
	public ArrayList<RepairAlyResult> alyReapairByYN(String year,String name);
	/**
	 * 根据年分析报修数据
	 * @param year
	 * @return 统计数据
	 */
	public IRepairResultDoneDao alyReapairByY(String year);
	
	/**
	 * 根据楼栋分析报修数据
	 * @param startTime,endTime 统计时间段
	 * @return 统计数据
	 */
	public ArrayList<RepairAnalyze> alyReapairByBuilding(Date startTime,Date endTime);
	}





