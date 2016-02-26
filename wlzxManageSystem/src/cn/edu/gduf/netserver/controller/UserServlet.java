package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.action.Action;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");
		Action act = null;
		String result = null;
	    Properties prop = new Properties();
	    prop.load(this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/edu/gduf/netserver/controller/action.properties"));
	    String realaction = prop.getProperty(action);
	    
	    try {
	    	act = (Action) Class.forName(realaction).newInstance();
	    	result = act.execute(request, response);
			if (result == "login") {
				request.getRequestDispatcher("TestPaperServlet?action=testPaperShow").forward(request, response);
			} else if (result == "loginError") {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else if(result=="jsp/finishInfo.jsp"||result=="jsp/search.jsp"||result=="jsp/personInfo.jsp"||result=="jsp/changePassword.jsp"){
				RequestDispatcher dispatcher=request.getRequestDispatcher(result);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}