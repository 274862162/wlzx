package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.dao.impl.ScheduleDaoImpl;
import cn.edu.gduf.netserver.domain.FreeTable;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.UserFreeTable;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class ScheduleListAction implements Action{

	/**
	 * 显示各个学期的无课表
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IScheduleDao scheduleDao = new ScheduleDaoImpl();
		String flag = request.getParameter("flag"); 
		String page = request.getParameter("page");  // 显示的那一页(当前页)
		if (StringUtil.isEmpty(page)) {
			page = "1";  // 默认第一页
		}
		int totalNum = scheduleDao.count();  // 无课表总数
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<FreeTable> freeTablesList = scheduleDao.getFreeTables(pageBean);
		request.setAttribute("freeTablesList", freeTablesList);
		//List<UserFreeTable> userFreeTableList = scheduleDao.getUserFreeTables();
		//request.setAttribute("userFreeTableList", userFreeTableList);
		request.setAttribute("currentTotalPage", PageUtil.getCurrentAndTotalPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize"))));
		if ("1".equals(flag)) {
			request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 4));
			return "scheduleList1";
		}else {
			request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 3));
			return "scheduleList";
		}
	}

}
