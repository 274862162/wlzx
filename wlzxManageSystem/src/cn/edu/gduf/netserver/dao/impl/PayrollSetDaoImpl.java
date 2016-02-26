package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.gduf.netserver.dao.IPayrollSetDao;
import cn.edu.gduf.netserver.domain.PayrollSet;
import cn.edu.gduf.netserver.util.DbUtil;

public class PayrollSetDaoImpl implements IPayrollSetDao{

	public PayrollSet getPayrollSet() {
		String querySql="select id,allMoney,latePerMoney,noDutyPerMoney,isOverDueMoney,dutyPerMoney,otherAddMoney,otherThrowMoney from payrollset where id=1";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		PayrollSet payrollset=new PayrollSet();
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
			while(rs.next()){
				payrollset.setId(rs.getInt("id"));
				payrollset.setAllMoney(rs.getDouble("allMoney"));
				payrollset.setLatePerMoney(rs.getDouble("latePerMoney"));
				payrollset.setNoDutyPerMoney(rs.getDouble("noDutyPerMoney"));
				payrollset.setIsOverDueMoney(rs.getDouble("isOverDueMoney"));
				payrollset.setDutyPerMoney(rs.getDouble("dutyPerMoney"));
				payrollset.setOtherAddMoney(rs.getDouble("otherAddMoney"));
				payrollset.setOtherThrowMoney(rs.getDouble("otherThrowMoney"));
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return payrollset;
	}

	public void setPayrollSet(PayrollSet payrollSet) {
		String querySql="update payrollset set allMoney=?,latePerMoney=?,noDutyPerMoney=?,isOverDueMoney=?,dutyPerMoney=?,otherAddMoney=?,otherThrowMoney=? where id=1";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setDouble(1, payrollSet.getAllMoney());
			ps.setDouble(2, payrollSet.getLatePerMoney());
			ps.setDouble(3, payrollSet.getNoDutyPerMoney());
			ps.setDouble(4, payrollSet.getIsOverDueMoney());
			ps.setDouble(5, payrollSet.getDutyPerMoney());
			ps.setDouble(6, payrollSet.getOtherAddMoney());
			ps.setDouble(7, payrollSet.getOtherThrowMoney());
			ps.executeUpdate();		
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
	}

}
