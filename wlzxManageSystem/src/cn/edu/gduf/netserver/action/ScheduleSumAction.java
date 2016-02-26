package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.impl.ScheduleDaoImpl;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;
import cn.edu.gduf.netserver.domain.Free;
import cn.edu.gduf.netserver.domain.FreeTime;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.ResponseUtil;

public class ScheduleSumAction implements Action{

	/**
	 * 显示总无课表
	 * TODO 待完善，循环次数多同时使用了反射导致加载速度慢
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IUserDao userDao = new UserDaoImpl();
		IScheduleDao scheduleDao = new ScheduleDaoImpl();
		FreeTime mon12 = new FreeTime("mon12", "");  // 周一一二节
		FreeTime mon345 = new FreeTime("mon345", "");
		FreeTime mon6789 = new FreeTime("mon6789", "");
		FreeTime tues12 = new FreeTime("tues12", "");
		FreeTime tues345 = new FreeTime("tues345", "");
		FreeTime tues6789 = new FreeTime("tues6789", "");
		FreeTime wed12 = new FreeTime("wed12", "");
		FreeTime wed345 = new FreeTime("wed345", "");
		FreeTime wed6789 = new FreeTime("wed6789", "");
		FreeTime thurs12 = new FreeTime("thurs12", "");
		FreeTime thurs345 = new FreeTime("thurs345", "");
		FreeTime thurs6789 = new FreeTime("thurs6789", "");
		FreeTime fri12 = new FreeTime("fri12", "");
		FreeTime fri345 = new FreeTime("fri345", "");
		FreeTime fri6789 = new FreeTime("fri6789", "");
		User user;
		String freeTableID = request.getParameter("freeTableID");  // 无课表id
		List<Integer> userFreeTableIDs = null;
		try {
			userFreeTableIDs = scheduleDao.getUserFreeTableId(Integer.parseInt(freeTableID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<Integer> it = userFreeTableIDs.iterator();
		while (it.hasNext()) {
			Integer id = it.next();
			user = userDao.getUserById(scheduleDao.getUserFreeTableById(id).getUserID());  // 根据用户与无课表的关联id得到用户
			List<Free> frees = scheduleDao.getFrees(id);
			Iterator<Free> freesIt = frees.iterator();
			while (freesIt.hasNext()) {
				Free free = freesIt.next();
				// 星期一
				if (free.getWeekID()==1) {
					freeShow(free, mon12, user, "getOnetwo", null, null);  // 第一二节
					freeShow(free, mon345, user, "getThreefour", "getFive", null);  // 第三四五节
					freeShow(free, mon6789, user, "getSixseven", "getEight", "getNineten");  // 第六七八九十节
				}
				// 星期二
				else if (free.getWeekID()==2) {
					freeShow(free, tues12, user, "getOnetwo", null, null);  // 第一二节
					freeShow(free, tues345, user, "getThreefour", "getFive", null);  // 第三四五节
					freeShow(free, tues6789, user, "getSixseven", "getEight", "getNineten");  // 第六七八九十节
				}
				// 星期三
				else if (free.getWeekID()==3) {
					freeShow(free, wed12, user, "getOnetwo", null, null);  // 第一二节
					freeShow(free, wed345, user, "getThreefour", "getFive", null);  // 第三四五节
					freeShow(free, wed6789, user, "getSixseven", "getEight", "getNineten");  // 第六七八九十节
				}
				// 星期四
				else if (free.getWeekID()==4) {
					freeShow(free, thurs12, user, "getOnetwo", null, null);  // 第一二节
					freeShow(free, thurs345, user, "getThreefour", "getFive", null);  // 第三四五节
					freeShow(free, thurs6789, user, "getSixseven", "getEight", "getNineten");  // 第六七八九十节
				}
				// 星期五
				else if (free.getWeekID()==5) {
					freeShow(free, fri12, user, "getOnetwo", null, null);  // 第一二节
					freeShow(free, fri345, user, "getThreefour", "getFive", null);  // 第三四五节
					freeShow(free, fri6789, user, "getSixseven", "getEight", "getNineten");  // 第六七八九十节
				}
			}
		}
		
		List<FreeTime> freeTimeList = new ArrayList<FreeTime>();
		freeTimeList.add(mon12);
		freeTimeList.add(mon345);
		freeTimeList.add(mon6789);
		freeTimeList.add(tues12);
		freeTimeList.add(tues345);
		freeTimeList.add(tues6789);
		freeTimeList.add(wed12);
		freeTimeList.add(wed345);
		freeTimeList.add(wed6789);
		freeTimeList.add(thurs12);
		freeTimeList.add(thurs345);
		freeTimeList.add(thurs6789);
		freeTimeList.add(fri12);
		freeTimeList.add(fri345);
		freeTimeList.add(fri6789);
		
		JSONArray jsonArray = JSONArray.fromObject(freeTimeList);
		try {
			ResponseUtil.write(jsonArray, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 
	 * @param free 星期几的无课情况
	 * @param freeTime 哪个无课的时间段
	 * @param user 用户
	 * @param method1 具体哪个时间段
	 * @param method2 具体哪个时间段
	 * @param method3 具体哪个时间段
	 */
	private void freeShow(Free free, FreeTime freeTime, User user, String method1, String method2, String method3){
		Method m1 = null;
		Method m2 = null;
		Method m3 = null;
		try {
			m1 = Free.class.getMethod(method1, null);
			if (method2 != null) {
				m2 = Free.class.getMethod(method2, null);
			}
			if (method3 != null) {
				m3 = Free.class.getMethod(method3, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (method2 == null && method3 == null) {
				// 第一二节
				if ("1".equals(m1.invoke(free, null))) { 
					freeTime.setValue(freeTime.getValue() + (user.getName()+"(单)&nbsp;"));  // 第一二节单周无课
				}else if ("2".equals(m1.invoke(free, null))) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"(双)&nbsp;"));  // 第一二节双周无课
				}else if ("3".equals(m1.invoke(free, null))) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"&nbsp;"));  // 第一二节无课
				}
			}else if (method2 != null && method3 == null) {
				// 第三四五节
				if (("1".equals(m1.invoke(free, null))&&"1".equals(m2.invoke(free, null)))||("1".equals(m1.invoke(free, null))&&"3".equals(m2.invoke(free, null)))) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"(单)&nbsp;"));  // 第三四五节单周无课
				}else if (("2".equals(m1.invoke(free, null))&&"2".equals(m2.invoke(free, null)))||("2".equals(m1.invoke(free, null))&&"3".equals(m2.invoke(free, null)))) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"(双)&nbsp;"));  // 第三四五节双周无课
				}else if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"&nbsp;"));  // 第三四五节无课
				}
			}else if (method2 != null && method3 != null) {
				// 第六七八九十节
				if (("1".equals(m1.invoke(free, null))&&"1".equals(m2.invoke(free, null))&&"1".equals(m3.invoke(free, null)))||("1".equals(m1.invoke(free, null))&&"1".equals(m2.invoke(free, null))&&"3".equals(m3.invoke(free, null)))) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"(单)&nbsp;"));  // 第六七八九十节单周无课
				}else if (("2".equals(m1.invoke(free, null))&&"2".equals(m2.invoke(free, null))&&"2".equals(m3.invoke(free, null)))||("2".equals(m1.invoke(free, null))&&"2".equals(m2.invoke(free, null))&&"3".equals(m3.invoke(free, null)))) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"(双)&nbsp;"));  // 第六七八九十节双周无课
				}else if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
					freeTime.setValue(freeTime.getValue() + (user.getName()+"&nbsp;"));  // 第六七八九十节无课
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}