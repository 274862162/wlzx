package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.impl.ScheduleDaoImpl;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;
import cn.edu.gduf.netserver.domain.FreeTable;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class ScheduleQueryAction implements Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IScheduleDao scheduleDao = new ScheduleDaoImpl();
		IUserDao userDao = new UserDaoImpl();
		String userName = null;
		/*
		if (StringUtil.isNotEmpty((String) request.getSession().getAttribute("name"))) {
			userName = 
		}*/
		if (StringUtil.isNotEmpty(request.getParameter("name"))) {
			userName = StringUtil.changeToUTF8(request.getParameter("name"));  // name:要查询无课表的学生名称
		}else if (StringUtil.isEmpty(request.getParameter("name"))) {
			userName = (String) request.getSession().getAttribute("name");
		}
		System.out.println(userName);
		String page = request.getParameter("page");  // 显示的那一页(当前页)
		if (StringUtil.isEmpty(page)) {
			page = "1";  // 默认第一页
		}
		int totalNum = scheduleDao.count();  // 无课表总数
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<FreeTable> freeTablesList = scheduleDao.getFreeTables(pageBean);
		int userId = 0;
		try {
			userId = userDao.getIdByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("userId", userId);
		request.getSession().setAttribute("name", userName);
		request.setAttribute("freeTablesList", freeTablesList);
		request.setAttribute("currentTotalPage", PageUtil.getCurrentAndTotalPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize"))));
		request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 5));
		return "scheduleQuery";
	}

}
