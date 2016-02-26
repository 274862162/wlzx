package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.action.Action;

public class ScheduleServlet extends HttpServlet {

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
	    	if (result == "scheduleFill") {  // 填写无课表
	    		request.getRequestDispatcher("ScheduleServlet?action=scheduleList").forward(request, response);
			} else if (result == "scheduleFillGo"){  // 到填写无课表的页面
				request.getRequestDispatcher("jsp/scheduleFill.jsp").forward(request, response);
			} else if (result == "scheduleList"){  // 显示各个学期无课表
				request.getRequestDispatcher("jsp/scheduleInfo.jsp").forward(request, response);
			} else if (result == "scheduleList1"){  // 显示各个学期无课表
				request.getRequestDispatcher("jsp/scheduleQuery2.jsp").forward(request, response);
			} else if (result == "scheduleQuery"){  // 查询个人无课表
				request.getRequestDispatcher("jsp/scheduleQuery.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}