package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.action.Action;
import cn.edu.gduf.netserver.dao.impl.SurveySystemSaveQusnDaoImpl;
import cn.edu.gduf.netserver.domain.QusnnQuestion;
import cn.edu.gduf.netserver.domain.Questionnaire;
import cn.edu.gduf.netserver.util.DateUtil;

/**问卷调查系统Servlet
 * @author Wmj
 *
 */
public class SurveySystemQusnServlet extends HttpServlet {

	public SurveySystemQusnServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		System.out.println("--Servlet doPost begin--");
		
		String action = req.getParameter("action");
		Action act = null;
		String result = null;
	    Properties prop = new Properties();
	    prop.load(this.getServletContext().getResourceAsStream("/WEB-INF/classes/cn/edu/gduf/netserver/controller/action.properties"));
	    //取得action在配置文件对应的值
	    String realaction = prop.getProperty(action);
	    try {
	    	//反射类
			act=(Action)Class.forName(realaction).newInstance();
			result=act.execute(req, res);
			//请求分发
			RequestDispatcher dispatcher=req.getRequestDispatcher(result);
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}
	public void init() throws ServletException {
	}

}
