package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.action.Action;
import cn.edu.gduf.netserver.dao.NoticeDao;
import cn.edu.gduf.netserver.domain.Notice;

public class CommonServlet_redirect extends HttpServlet {

	/**
	 * 请求处理-重定向
	 */
	public CommonServlet_redirect() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/xml;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String path = this.getServletContext().getRealPath("/");
		String action=request.getParameter("action");
		Action act=null;
		String forward=null;
		Properties prop=new Properties();
		prop.load(this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/edu/gduf/netserver/controller/action.properties"));
		String realaction=prop.getProperty(action);
		try {
			act=(Action)Class.forName(realaction).newInstance();
			forward=act.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(forward != null) {
			System.out.println(path);
			response.sendRedirect("/wlzxManageSystem/"+forward);
		}
	}
}
