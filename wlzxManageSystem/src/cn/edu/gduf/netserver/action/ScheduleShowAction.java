package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.dao.impl.ScheduleDaoImpl;
import cn.edu.gduf.netserver.domain.Free;
import cn.edu.gduf.netserver.util.ResponseUtil;

public class ScheduleShowAction implements Action{

	/**
	 * 显示具体某个无课表
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IScheduleDao scheduleDao = new ScheduleDaoImpl();
		String userID = request.getParameter("userID");
		String freeTableID = request.getParameter("freeTableID");
		int userFreeTableID = 0;
		try {
			userFreeTableID = scheduleDao.getUserFreeTableId(Integer.parseInt(userID), Integer.parseInt(freeTableID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Free> freeList = scheduleDao.getFrees(userFreeTableID);
		
		JSONArray jsonArray = JSONArray.fromObject(freeList);
		try {
			ResponseUtil.write(jsonArray, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
