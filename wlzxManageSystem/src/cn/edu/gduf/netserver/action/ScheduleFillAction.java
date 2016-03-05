package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.dao.impl.ScheduleDaoImpl;
import cn.edu.gduf.netserver.domain.Free;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.domain.UserFreeTable;

public class ScheduleFillAction implements Action{

	/**
	 * 填写无课表
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IScheduleDao scheduleFillDao = new ScheduleDaoImpl();	
		String freeTableID = request.getParameter("freeTableID");
		int userID = (Integer) request.getSession().getAttribute("id");
		
		//System.out.println(((User)request.getSession().getAttribute("currentUser")).getUserID());  // 0
		//System.out.println(freeTableID);
		
		UserFreeTable userFreeTable = new UserFreeTable(new Date(), Integer.parseInt(freeTableID), userID);
		try {
			scheduleFillDao.addUserFreeTable(userFreeTable);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		int maxNum = 0;
		try {
			maxNum = scheduleFillDao.getMaxUserFreeTableId();  // UserFreeTable的最大值
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  
		
		String mon12 = request.getParameter("mon12");  // 星期一第一二节
		String mon34 = request.getParameter("mon34");  // 星期一第三四节
		String mon5 = request.getParameter("mon5");  // 星期一第五节
		String mon67 = request.getParameter("mon67");  // 星期一第六七节
		String mon8 = request.getParameter("mon8");  // 星期一第八节
		String mon910 = request.getParameter("mon910");  // 星期一第九十节
		
		String tues12 = request.getParameter("tues12");  // 星期二第一二节
		String tues34 = request.getParameter("tues34");  // 星期二第三四节
		String tues5 = request.getParameter("tues5");  // 星期二第五节
		String tues67 = request.getParameter("tues67");  // 星期二第六七节
		String tues8 = request.getParameter("tues8");  // 星期二第八节
		String tues910 = request.getParameter("tues910");  // 星期二第九十节
		
		String wed12 = request.getParameter("wed12");  // 星期三第一二节
		String wed34 = request.getParameter("wed34");  // 星期三第三四节
		String wed5 = request.getParameter("wed5");  // 星期三第五节
		String wed67 = request.getParameter("wed67");  // 星期三第六七节
		String wed8 = request.getParameter("wed8");  // 星期三第八节
		String wed910 = request.getParameter("wed910");  // 星期三第九十节
		
		String thurs12 = request.getParameter("thurs12");  // 星期四第一二节
		String thurs34 = request.getParameter("thurs34");  // 星期四第三四节
		String thurs5 = request.getParameter("thurs5");  // 星期四第五节
		String thurs67 = request.getParameter("thurs67");  // 星期四第六七节
		String thurs8 = request.getParameter("thurs8");  // 星期四第八节
		String thurs910 = request.getParameter("thurs910");  // 星期四第九十节
		
		String fri12 = request.getParameter("fri12");  // 星期五第一二节
		String fri34 = request.getParameter("fri34");  // 星期五第三四节
		String fri5 = request.getParameter("fri5");  // 星期五第五节
		String fri67 = request.getParameter("fri67");  // 星期五第六七节
		String fri8 = request.getParameter("fri8");  // 星期五第八节
		String fri910 = request.getParameter("fri910");  // 星期五第九十节
		
		Free monFree = new Free(mon12, mon34, mon5, mon67, mon8, mon910, maxNum, 1);
		Free tuesFree = new Free(tues12, tues34, tues5, tues67, tues8, tues910, maxNum, 2);
		Free wedFree = new Free(wed12, wed34, wed5, wed67, wed8, wed910, maxNum, 3);
		Free thursFree = new Free(thurs12, thurs34, thurs5, thurs67, thurs8, thurs910, maxNum, 4);
		Free friFree = new Free(fri12, fri34, fri5, fri67, fri8, fri910, maxNum, 5);
		
		try {
			scheduleFillDao.addFree(monFree);
			scheduleFillDao.addFree(tuesFree);
			scheduleFillDao.addFree(wedFree);
			scheduleFillDao.addFree(thursFree);
			scheduleFillDao.addFree(friFree);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "scheduleFill";
	}

}
