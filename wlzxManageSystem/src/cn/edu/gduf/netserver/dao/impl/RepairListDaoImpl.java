package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.IRepairResultDoneDao;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.RepairAlyResult;
import cn.edu.gduf.netserver.domain.RepairList;
import cn.edu.gduf.netserver.util.DbUtil;

public class RepairListDaoImpl implements IRepairListDao {

	public void addRepairList(RepairList repairList) throws SQLException {
		String repairListSQL="insert into repair_list(repairTime,appointmentTime,telephone,faultType,clientCode,errorCode," +
				"description,repairStatus,stuSno,stuName,stuBuilding,stuRoom,appointmentText) values(?,?," +
				"?,?,?,?,?,?,?,?,?,?,?)";		
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
			ps.setString(1, repairList.getRepairTime());
			ps.setString(2,repairList.getAppointmentTime());
			ps.setString(3, repairList.getTelephone());
			ps.setString(4, repairList.getFaultType());
			ps.setString(5, repairList.getClientCode());
			ps.setString(6, repairList.getErrorCode());
			ps.setString(7, repairList.getDescription());
			ps.setInt(8, repairList.getStatus());
			ps.setString(9, repairList.getStuSno());
			ps.setString(10, repairList.getStuName());
			ps.setString(11, repairList.getStuBuilding());
			ps.setString(12, repairList.getStuRoom());
			ps.setString(13, repairList.getAppointmentText());
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("write fail！！");
		}
		try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}
	}

	public int updateRepairList(RepairList repairList) {
		String repairListSQL="update repair_list set dealingTime=?,repairStatus=1,dutyPersonID=?,dealingText=? where Id=?";		
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
			ps.setString(1, repairList.getDealingTime());
			ps.setInt(2,repairList.getDutyPersonID());
			ps.setString(3, repairList.getDealingText());
			ps.setInt(4, repairList.getRepairListID());
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}
		return 0;
	}

	public int updateRepairListById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteRepairListById(int id) {
		String sql="delete from repair_list where id=?";
		int result=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
		}finally{
			DbUtil.close(rs, ps, conn);
		}
		return result;
	}

	public List<RepairList> getAllRepairLists() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RepairList> getRepairLists(RepairList repairList) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepairList> getRepairLists(PageBean pageBean) {
		ArrayList<RepairList> repairLists = new ArrayList<RepairList>();
		int before=(pageBean.getPage()-1)*pageBean.getPageSize();//计算当前页第一条记录的前面记录条数
		String querySql="select id,repairTime,appointmentTime,telephone,faultType" +
				",clientCode,errorCode,description,repairStatus,dealingTime,evaluation" +
				",evaluateTime,stuSno,stuName,stuBuilding,stuRoom,dutyPersonID,appointmentText,dealingText,isOverdue" +
				" from repair_list WHERE ID <= " +
						"(select id from repair_list order by ID desc limit "+before+",1) order by id desc limit "+pageBean.getPageSize()+";";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
//			System.out.println("当前页面"+before);
			while(rs.next()){
				RepairList list=new RepairList();
				list.setRepairListID(rs.getInt("id"));
				list.setRepairTime(rs.getString("repairTime"));
				list.setAppointmentTime(rs.getString("appointmentTime"));
				list.setTelephone(rs.getString("telephone"));
				list.setFaultType(rs.getString("faultType"));
				list.setClientCode(rs.getString("clientCode"));
				list.setErrorCode(rs.getString("errorCode"));
				list.setDescription(rs.getString("description").trim());
				list.setRepairTime(rs.getString("repairTime"));
				list.setStatus(rs.getInt("repairStatus"));
				list.setDealingTime(rs.getString("dealingTime"));				
				list.setDealingText(rs.getString("dealingText").trim());
				list.setEvaluateTime(rs.getString("evaluateTime"));
				list.setEvaluation(rs.getString("evaluation"));
				list.setStuSno(rs.getString("stuSno"));
				list.setStuName(rs.getString("stuName"));
				list.setStuBuilding(rs.getString("stuBuilding"));
				list.setStuRoom(rs.getString("stuRoom"));
				list.setDutyPersonID(rs.getInt("dutyPersonID"));
				list.setAppointmentText(rs.getString("appointmentText"));
				list.setIsOverdue(rs.getInt("isOverdue"));
				repairLists.add(list);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return repairLists;	
	}

	public List<RepairList> getRepairLists(RepairList repairList,
			PageBean pageBean) {
		List<RepairList> repairLists = new ArrayList<RepairList>();
		int before=(pageBean.getPage()-1)*pageBean.getPageSize();//计算当前页第一条记录的前面记录条数
		String querySql="select id,repairTime,appointmentTime,telephone,faultType" +
				",clientCode,errorCode,description,repairStatus,dealingTime,evaluation" +
				",evaluateTime,stuSno,stuName,stuBuilding,stuRoom,dutyPersonID,appointmentText,dealingText,isOverdue" +
				" from repair_list WHERE stuSno="+repairList.getStuSno()+" AND ID <= (select ID from repair_list where stuSno="+repairList.getStuSno()+" order by ID desc limit "+before+",1) order by id desc limit "+pageBean.getPageSize()+";";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
//			System.out.println("当前页面"+before);
			while(rs.next()){
				RepairList list=new RepairList();
				list.setRepairListID(rs.getInt("id"));
				list.setRepairTime(rs.getString("repairTime"));
				list.setAppointmentTime(rs.getString("appointmentTime"));
				list.setTelephone(rs.getString("telephone"));
				list.setFaultType(rs.getString("faultType"));
				list.setClientCode(rs.getString("clientCode"));
				list.setErrorCode(rs.getString("errorCode"));
				list.setDescription(rs.getString("description").trim());
				list.setRepairTime(rs.getString("repairTime"));
				list.setStatus(rs.getInt("repairStatus"));
				list.setDealingTime(rs.getString("dealingTime"));				
				list.setDealingText(rs.getString("dealingText").trim());
				list.setEvaluateTime(rs.getString("evaluateTime"));
				list.setEvaluation(rs.getString("evaluation"));
				list.setStuSno(rs.getString("stuSno"));
				list.setStuName(rs.getString("stuName"));
				list.setStuBuilding(rs.getString("stuBuilding"));
				list.setStuRoom(rs.getString("stuRoom"));
				list.setDutyPersonID(rs.getInt("dutyPersonID"));
				list.setAppointmentText(rs.getString("appointmentText"));
				list.setIsOverdue(rs.getInt("isOverdue"));
				repairLists.add(list);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return repairLists;
	}

	public RepairList getRepairListById(int id) {
		//此方法并不完善
		RepairList repairList=new RepairList();
		String querySql="select * from repair_list where id=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				//repairTime,appointmentTime,telephone,faultType,clientCode,errorCode," +
				//"description,repairStatus,stuSno,stuName,stuArea,appointmentText
				repairList.setRepairListID(rs.getInt("id"));
				repairList.setRepairTime(rs.getString("repairTime"));
				repairList.setAppointmentTime(rs.getString("appointmentTime"));
				repairList.setTelephone(rs.getString("telephone"));
				repairList.setFaultType(rs.getString("faultType"));
				repairList.setClientCode(rs.getString("clientCode"));
				repairList.setErrorCode(rs.getString("errorCode"));
				
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return repairList;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(RepairList repairList) {
		int totalNum=0;
		String querySql="select count(*) as num from repair_list where stuSno=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setString(1, repairList.getStuSno());
			rs=ps.executeQuery();
			while(rs.next()){
				totalNum=rs.getInt("num");
//				System.out.println("结果集条数："+totalNum);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return totalNum;
	}
	public void updateEvaluationByID(String id,String level){
		String querySql="update repair_list set evaluation=? where Id=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setString(1, level);
			ps.setString(2, id);
			ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
	}

	public ArrayList<RepairList> getRepairListByID(int id,PageBean pageBean) {
		ArrayList<RepairList> repairLists = new ArrayList<RepairList>();
		int before=(pageBean.getPage()-1)*pageBean.getPageSize();//计算当前页第一条记录的前面记录条数
		String querySql="select id,repairTime,appointmentTime,telephone,faultType" +
				",clientCode,errorCode,description,repairStatus,dealingTime,evaluation" +
				",evaluateTime,stuSno,stuName,stuBuilding,stuRoom,dutyPersonID,appointmentText,dealingText,isOverdue" +
				" from repair_list WHERE stuBuilding=(select repArea from user where id="+id+") AND ID <= " +
						"(select id from repair_list where stuBuilding=(select repArea from user where id="+id+") order by ID desc limit "+before+",1) order by id desc limit "+pageBean.getPageSize()+";";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
//			System.out.println("当前页面"+before);
			while(rs.next()){
				RepairList list=new RepairList();
				list.setRepairListID(rs.getInt("id"));
				list.setRepairTime(rs.getString("repairTime"));
				list.setAppointmentTime(rs.getString("appointmentTime"));
				list.setTelephone(rs.getString("telephone"));
				list.setFaultType(rs.getString("faultType"));
				list.setClientCode(rs.getString("clientCode"));
				list.setErrorCode(rs.getString("errorCode"));
				list.setDescription(rs.getString("description").trim());
				list.setRepairTime(rs.getString("repairTime"));
				list.setStatus(rs.getInt("repairStatus"));
				list.setDealingTime(rs.getString("dealingTime"));				
				list.setDealingText(rs.getString("dealingText").trim());
				list.setEvaluateTime(rs.getString("evaluateTime"));
				list.setEvaluation(rs.getString("evaluation"));
				list.setStuSno(rs.getString("stuSno"));
				list.setStuName(rs.getString("stuName"));
				list.setStuBuilding(rs.getString("stuBuilding"));
				list.setStuRoom(rs.getString("stuRoom"));
				list.setDutyPersonID(rs.getInt("dutyPersonID"));
				list.setAppointmentText(rs.getString("appointmentText"));
				list.setIsOverdue(rs.getInt("isOverdue"));
				repairLists.add(list);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return repairLists;		
	}

	public int countUser(int userID) {
		int totalNum=0;
		String querySql="select count(*) as num from repair_list where stuBuilding=(select repArea from user where id=?);";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			rs=ps.executeQuery();
			while(rs.next()){
				totalNum=rs.getInt("num");
//				System.out.println("结果集条数："+totalNum);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return totalNum;
	}

	public int countAllRepairLists() {
		int totalNum=0;
		String querySql="select count(*) as num from repair_list;";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			rs=ps.executeQuery();
			while(rs.next()){
				totalNum=rs.getInt("num");
//				System.out.println("结果集条数："+totalNum);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return totalNum;
	}

	public String getAlluserName() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String userName="";
		String sql="select userName from user;";
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				userName=userName+","+rs.getString("userName");
			}
		}catch(Exception e){
			
		}finally{
			DbUtil.close(rs, ps, conn);
		}
		return userName;
	}
	public ArrayList<RepairAlyResult> alyReapair(String year,String month,String name){
		String time=year+"-"+month;
		ArrayList<RepairAlyResult> repairAlyReaults=new ArrayList<RepairAlyResult>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select (select COUNT(*) from repair_list where repairTime LIKE '%"+time+"%' AND stuBuilding=(select repArea from user where userName='"+name+"')) as num," +
				"(select count(isOverdue) from repair_list where isOverdue>3 AND stuBuilding=(select repArea from user where userName='"+name+"') AND repairTime LIKE '%"+time+"%') as overdue," +
				"(select count(dutyPersonID) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%') as personal," +
				"(select count(repairStatus) from repair_list where repairStatus='0' AND stuBuilding=(select repArea from user where userName='"+name+"') AND repairTime LIKE '%"+time+"%') as noDeal,   "+
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='A') as excellent," +
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='B') as good," +
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='C') as medium," +
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='D') as poor;";
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				RepairAlyResult repairAlyReault=new RepairAlyResult();
				repairAlyReault.setTime(year+"-"+month);
				repairAlyReault.setAllRepairListNum(Integer.parseInt(rs.getString("num")));
				repairAlyReault.setOverDueNum(Integer.parseInt(rs.getString("overdue")));
				repairAlyReault.setDealByMyself(Integer.parseInt(rs.getString("personal")));
				repairAlyReault.setNoDeal(Integer.parseInt(rs.getString("noDeal")));
				repairAlyReault.setDutyPerson(name);
				//处理评价
				float excellent,good,medium,poor;
				if(repairAlyReault.getAllRepairListNum()!=0){
					excellent=Float.parseFloat(rs.getString("excellent"))/repairAlyReault.getAllRepairListNum();
					good=Float.parseFloat(rs.getString("good"))/repairAlyReault.getAllRepairListNum();
					medium=Float.parseFloat(rs.getString("medium"))/repairAlyReault.getAllRepairListNum();				
					poor=Float.parseFloat(rs.getString("poor"))/repairAlyReault.getAllRepairListNum();
				}else{
					excellent=good=medium=poor=0;
				}
				DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
				String evaluAly="A"+decimalFormat.format(excellent)+"%\n"+"B"+decimalFormat.format(good)+"%\n"+"C"+decimalFormat.format(medium)+"%\n"+"D"+decimalFormat.format(poor)+"%\n";
				repairAlyReault.setEvaluAly(evaluAly);
				repairAlyReaults.add(repairAlyReault);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, ps, conn);
		}
		return repairAlyReaults;
	}
	public RepairAlyResult aResult(String year,String month,String name){
		String time=year+"-"+month;
		RepairAlyResult repairAlyReault=new RepairAlyResult();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select (select COUNT(*) from repair_list where repairTime LIKE '%"+time+"%' AND stuBuilding=(select repArea from user where userName='"+name+"')) as num," +
				"(select count(isOverdue) from repair_list where isOverdue>3 AND stuBuilding=(select repArea from user where userName='"+name+"') AND repairTime LIKE '%"+time+"%') as overdue," +
				"(select count(dutyPersonID) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%') as personal," +
				"(select count(repairStatus) from repair_list where repairStatus='0' AND stuBuilding=(select repArea from user where userName='"+name+"') AND repairTime LIKE '%"+time+"%') as noDeal,   "+
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='A') as excellent," +
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='B') as good," +
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='C') as medium," +
				"(select count(evaluation) from repair_list where dutyPersonID=(select id from user where userName='"+name+"') AND stuBuilding=(select repArea from user where id=dutyPersonID) AND repairTime LIKE '%"+time+"%' AND evaluation='D') as poor;";
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){				
				repairAlyReault.setTime(year+"-"+month);
				repairAlyReault.setAllRepairListNum(Integer.parseInt(rs.getString("num")));
				repairAlyReault.setOverDueNum(Integer.parseInt(rs.getString("overdue")));
				repairAlyReault.setDealByMyself(Integer.parseInt(rs.getString("personal")));
				repairAlyReault.setNoDeal(Integer.parseInt(rs.getString("noDeal")));
				repairAlyReault.setDutyPerson(name);
				//处理评价
				float excellent,good,medium,poor;
				if(repairAlyReault.getAllRepairListNum()!=0){
					excellent=Float.parseFloat(rs.getString("excellent"))/repairAlyReault.getAllRepairListNum();
					good=Float.parseFloat(rs.getString("good"))/repairAlyReault.getAllRepairListNum();
					medium=Float.parseFloat(rs.getString("medium"))/repairAlyReault.getAllRepairListNum();				
					poor=Float.parseFloat(rs.getString("poor"))/repairAlyReault.getAllRepairListNum();
				}else{
					excellent=good=medium=poor=0;
				}
				DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
				String evaluAly="A"+decimalFormat.format(excellent)+"%\n"+"B"+decimalFormat.format(good)+"%\n"+"C"+decimalFormat.format(medium)+"%\n"+"D"+decimalFormat.format(poor)+"%\n";
				repairAlyReault.setEvaluAly(evaluAly);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, ps, conn);
		}
		return repairAlyReault;
	}
	public ArrayList<RepairAlyResult> alyReapairByYM(String year, String month) {
		//1.查询网管用户名
		//2.分别查询每个网管记录，调用alyReapair(String year,String month,String name)函数；
		//3.回传值
		String username=getAlluserName();
		ArrayList<RepairAlyResult> repairAlyReaults=new ArrayList<RepairAlyResult>();		
		String user[]=username.split(",");
		for(int i=1;i<user.length;i++){//去除数组第一个空数据
			repairAlyReaults.add(aResult(year, month, user[i]));
		}
		return repairAlyReaults;
	}

	public ArrayList<RepairAlyResult> alyReapairByYN(String year, String name) {
		//1.创建12月份
		//2.分别查询每个网管记录，调用alyReapair(String year,String month,String name)函数；
		//3.回传值
		String[] months={"01","02","03","04","05","06","07","08","09","10","11","12"};
		ArrayList<RepairAlyResult> repairAlyReaults=new ArrayList<RepairAlyResult>();		
		for(int i=0;i<months.length;i++){
			repairAlyReaults.add(aResult(year, months[i], name));
		}
		return repairAlyReaults;
	}

	public IRepairResultDoneDao alyReapairByY(String year) {
		IRepairResultDoneDao alydata=new IRepairResultDoneDao();
		//已处理和未处理报修单统计
		String sql01="select(select count(*) from repair_list where repairStatus='1' AND repairTime LIKE '%"+year+"%')as isdeal,(select count(*) from repair_list where repairStatus='0' AND repairTime LIKE '%"+year+"%') as nodeal," +
				"(select count(*) from repair_list where evaluation='A' AND repairTime LIKE '%"+year+"%')as getA,(select count(*) from repair_list where evaluation='B' AND repairTime LIKE '%"+year+"%')as getB," +
				"(select count(*) from repair_list where evaluation='C' AND repairTime LIKE '%"+year+"%')as getC,(select count(*) from repair_list where evaluation='D' AND repairTime LIKE '%"+year+"%')as getD;";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(sql01);
			rs=ps.executeQuery();
			while(rs.next()){
				alydata.setDone(Integer.parseInt(rs.getString("isdeal")));
				alydata.setNoDone(Integer.parseInt(rs.getString("nodeal")));
				alydata.setGotA(Integer.parseInt(rs.getString("getA")));
				alydata.setGotB(Integer.parseInt(rs.getString("getB")));
				alydata.setGotC(Integer.parseInt(rs.getString("getC")));
				alydata.setGotD(Integer.parseInt(rs.getString("getD")));
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return alydata;
	} 
}
