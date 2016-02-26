package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.action.Action;


/**
 * 处理与试卷相关的Servlet
 * @author hsg
 * 2015/01/22
 */
public class TestPaperServlet extends HttpServlet {

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
			if (result == "testPaperShow") {  // 显示试卷
				request.getRequestDispatcher("jsp/assessmentSystem2.jsp").forward(request, response);
			}else if (result == "testPaperDesign") {  // 进入设计试卷页面
				request.getRequestDispatcher("jsp/assessmentSystem14.jsp").forward(request, response);
			}else if (result == "testPaperCreate") {  // 生成试卷
				System.out.println("生成试卷成功");
				request.getRequestDispatcher("TestPaperServlet?action=testPaperShow").forward(request, response);
			}else if (result == "testPaperPreview") {
				System.out.println("预览试卷成功");
				request.getRequestDispatcher("jsp/assessmentSystem15.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
