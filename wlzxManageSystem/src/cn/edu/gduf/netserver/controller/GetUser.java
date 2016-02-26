package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.User;

public class GetUser extends HttpServlet {

	/**
	 * 获取角色
	 */
	public GetUser() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/xml;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int userID = 0;
		if(request.getParameter("userID")!=null){
			userID = Integer.parseInt(request.getParameter("userID"));
		}
		UserDao userDao =new UserDao();
		User user = new User();
		try {
			user = userDao.getUserById(userID);//查询用户当前的角色
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//利用json串给js传一个User对象
		JSONObject jsonObject = JSONObject.fromObject(user);
		response.getWriter().print(jsonObject);
	}

}
