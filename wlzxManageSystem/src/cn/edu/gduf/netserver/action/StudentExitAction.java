package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wmj
 * 网上报修系统类
 * 学生退出的登录操作
 */
public class StudentExitAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("student");
		return "../jsp/webjsp/login.jsp";
	}

}
