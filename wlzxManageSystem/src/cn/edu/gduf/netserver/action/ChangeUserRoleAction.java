package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.domain.UserRole;

public class ChangeUserRoleAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int userRoleID = 0;
		if(request.getParameter("userRoleID")!=null){
			userRoleID = Integer.parseInt(request.getParameter("userRoleID"));
		}
		String roleName = request.getParameter("roleName");
		/*if(roleName!=null){
			byte[] str = roleName.getBytes("ISO-8859-1");  
			roleName =new String(str,"utf-8");  
		}*/
		UserRole userRole = new UserRole();
		userRole.setRoleName(roleName);
		userRole.setID(userRoleID);
		UserRoleDao userRoleDao = new UserRoleDao();
		try {
			int i = userRoleDao.changeUserRole(userRole);
			if(i>0){
				request.setAttribute("message", "修改成功");
			}else{
				request.setAttribute("message", "修改出错");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "修改出错");
		}	
		return "jsp/superManagement2.jsp";
	}
}
