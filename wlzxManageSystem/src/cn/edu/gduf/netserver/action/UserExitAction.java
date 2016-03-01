package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cjy
 * 用户退出登录的操作
 */
public class UserExitAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("id");
		request.getSession().removeAttribute("userName");
		return "jsp/login.jsp";
	}

}
