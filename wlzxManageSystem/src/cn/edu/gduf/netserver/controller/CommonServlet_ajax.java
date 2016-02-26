package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.action.Action;
import cn.edu.gduf.netserver.domain.Result;

public class CommonServlet_ajax extends HttpServlet {

	/**
	 * 请求处理-ajax请求方式
	 */
	public CommonServlet_ajax() {
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
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String action=request.getParameter("action");
		Action act=null;
		String result=null;
		Properties prop=new Properties();
		prop.load(this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/edu/gduf/netserver/controller/action.properties"));
		String realaction=prop.getProperty(action);
		try {
			act=(Action)Class.forName(realaction).newInstance();
			result=act.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result != null) {
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(result);
		}
	}
}
