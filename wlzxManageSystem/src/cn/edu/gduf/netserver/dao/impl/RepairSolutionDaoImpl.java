package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.gduf.netserver.dao.IRepairSolutionDao;
import cn.edu.gduf.netserver.domain.RepairSolution;
import cn.edu.gduf.netserver.util.DbUtil;

public class RepairSolutionDaoImpl implements IRepairSolutionDao {

	public void addRepairSolution(RepairSolution repairSolution) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<RepairSolution> selectRepairSolution(String codeName) {
		ArrayList<RepairSolution> repairSolutions=new ArrayList<RepairSolution>();
		String repairListSQL="select * from repair_solution WHERE codeName LIKE '%"+codeName+"%';";		
		Connection conn=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			conn=DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {			
			ps=conn.prepareStatement(repairListSQL);
//			ps.setString(1, codeName);
			rs=ps.executeQuery();
			while(rs.next()){
				RepairSolution repairSolution=new RepairSolution();
				repairSolution.setCodeName(rs.getString("codeName"));
				repairSolution.setCodeDescript(rs.getString("codeDescript"));
				repairSolution.setSolution(rs.getString("solution"));
				repairSolutions.add(repairSolution);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}
		return repairSolutions;
	}

}
