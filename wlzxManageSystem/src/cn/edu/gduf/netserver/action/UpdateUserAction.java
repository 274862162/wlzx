package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.domain.UserRole;

public class UpdateUserAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int userID = Integer.parseInt(request.getParameter("userID"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password").trim();
		String section = request.getParameter("section");
		String role = request.getParameter("role");
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUserID(userID);
		user.setUserName(userName);
		user.setPassword(password);
		user.setSection(section);
		
		UserRoleDao userRoleDao = new UserRoleDao();
		UserRole userRole = new UserRole();
		userRole.setUserID(userID);
		userRole.setRoleName(role);
		
		try {
			if(userDao.updateUser(user) && userRoleDao.UpdateUserRoleByUserID(userRole)!=0){
				request.setAttribute("message", "修改成功");
			}else{
				request.setAttribute("message", "修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "jsp/superManagement9.jsp";
	}
}
