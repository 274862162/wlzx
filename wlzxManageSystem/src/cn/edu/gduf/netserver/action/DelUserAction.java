package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;

public class DelUserAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int userID = 0;
		if(request.getParameter("userID")!=null){
			userID = Integer.parseInt(request.getParameter("userID"));//获得用户ID
		}
		UserDao userDao =new UserDao();
		UserRoleDao userRoleDao = new UserRoleDao();
		String message = "";
		try {
			if(userRoleDao.delByUserId(userID) && userDao.delUserById(userID)){
				message = "删除成功";			
			}else{
				message = "删除不成功，请重试";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

}
