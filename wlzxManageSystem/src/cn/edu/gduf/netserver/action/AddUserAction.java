package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.domain.UserRole;

public class AddUserAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String userName = request.getParameter("userName");
		String password = request.getParameter("password").trim();
		String repassword = request.getParameter("repassword").trim();
		String section = request.getParameter("section");
		String role = request.getParameter("role");
		if(!password.equals(repassword)){
			request.setAttribute("message", "新密码输入不一致");
		}else{
			UserDao userDao = new UserDao();
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setSection(section);
			if(userDao.getUserID(user)!=0){
				request.setAttribute("message", "该用户已存在");
			}else if(userDao.insert(user)){
				request.setAttribute("message", "添加用户成功");
				UserRoleDao userRoleDao = new UserRoleDao();
				RoleDao roleDao = new RoleDao();
				UserRole userRole = new UserRole();
				userRole.setUserID(userDao.getUserID(user));
				userRole.setRoleID(roleDao.getRoleID(role));
				try {
					userRoleDao.insertUserRole(userRole);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("message", "添加用户失败");
			}
			
		}
		return "jsp/superManagement9.jsp";
	}
}
