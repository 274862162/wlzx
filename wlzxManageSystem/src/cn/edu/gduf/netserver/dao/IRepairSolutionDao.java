package cn.edu.gduf.netserver.dao;

import java.util.ArrayList;

import cn.edu.gduf.netserver.domain.RepairSolution;

public interface IRepairSolutionDao {
	/**
	 * 增加故障问题的解决方法
	 * @param repairSolution
	 */
	public void addRepairSolution(RepairSolution repairSolution);
	/**
	 * 根据错误代码匹配相应的方法
	 * @param codeName 错误代码，如629/691
	 * @return 返回符合条件的方法类
	 */
	public ArrayList<RepairSolution> selectRepairSolution(String codeName);
}
