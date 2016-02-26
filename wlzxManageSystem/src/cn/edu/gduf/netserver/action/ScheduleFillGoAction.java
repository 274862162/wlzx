package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleFillGoAction implements Action{

	/**
	 * 到填写无课表的页面
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String freeTableID = request.getParameter("freeTableID");
		String freeTableName = request.getParameter("freeTableName");
		try {
			freeTableName = new String(freeTableName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request.setAttribute("freeTableName", freeTableName);
		request.setAttribute("freeTableID", freeTableID);
		return "scheduleFillGo";
	}
}
