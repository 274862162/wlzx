package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.action.Action;

/**
 * 处理和考核相关的Servlet
 * @author hsg
 * 2015/01/22
 */
public class ExamServlet extends HttpServlet {

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
	    	if (result == "examed") {  // 已参与过考核
	    		//System.out.println("已参与过考核");
			}else if (result == "exam") {  // 进行考核
				request.getRequestDispatcher("jsp/assessmentSystem10.jsp").forward(request, response);
			} else if (result == "examShow1") {  // 显示考核记录
				request.getRequestDispatcher("jsp/assessmentSystem6.jsp").forward(request, response);
			} else if (result == "examShow2") {  // 显示考核记录
				request.getRequestDispatcher("jsp/assessmentSystem5.jsp").forward(request, response);
			} else if (result == "examMark") {  // 批改试卷或查看试卷
				request.getRequestDispatcher("jsp/assessmentSystem13.jsp").forward(request, response);
			} else if (result == "examScore") {  // 提交批改，得出总分
				request.getRequestDispatcher("/ExamServlet?action=examShow2").forward(request, response);
			} else if (result == "examAnalyze1") {  // 提交批改，得出总分
				request.getRequestDispatcher("jsp/assessmentSystem7.jsp").forward(request, response);
			} else if (result == "examAnalyze") {  // 提交批改，得出总分
				request.getRequestDispatcher("jsp/assessmentSystem9.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
