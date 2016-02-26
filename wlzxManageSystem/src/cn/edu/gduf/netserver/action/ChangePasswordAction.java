package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.UserDao;

public class ChangePasswordAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession(true);
		String userName = (String)session.getAttribute("userName");
		String password = request.getParameter("password").trim();
		String newPassword = request.getParameter("newPassword").trim();
		String passwordAgain = request.getParameter("passwordAgain").trim();
		UserDao userDao = new UserDao();
		if(!passwordAgain.equals(newPassword)){
			session.setAttribute("message", "新密码输入不一致");
		}else{
			session.setAttribute("message", userDao.changePassword(userName,password,newPassword));
		}
		return "jsp/changePassword.jsp";
	}

}
