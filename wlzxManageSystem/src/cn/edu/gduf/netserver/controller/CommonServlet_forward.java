package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.action.Action;

public class CommonServlet_forward extends HttpServlet {

	/**
	 * 请求处理-转发
	 */
	public CommonServlet_forward() {
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
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
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
			RequestDispatcher rd=request.getRequestDispatcher("/"+forward);
			rd.forward(request, response);
		}
	}
}
