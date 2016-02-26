package cn.edu.gduf.netserver.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.domain.Role;

public class GetRole extends HttpServlet {

	/**
	 * 获取角色
	 */
	public GetRole() {
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
		int userRoleID = 0;
		if(request.getParameter("userRoleID")!=null){
			userRoleID = Integer.parseInt(request.getParameter("userRoleID"));
		}
		UserRoleDao userRoleDao =new UserRoleDao();
		String userRole = "";
		try {
			userRole = userRoleDao.getUserRole(userRoleID);//查询用户当前的角色
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Role role = new Role();
		role.setRoleName(userRole);
		RoleDao roleDao = new RoleDao();
		List<Role> roleList = roleDao.getAllRoles();
		System.out.println(roleList);
		roleList.add(role);
		//利用json串给js传一个list
		JSONArray jsonArray = JSONArray.fromObject(roleList);
		System.out.println(jsonArray.toString());
		response.getWriter().print(jsonArray);
	}
}