package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.domain.Role;

public class GetOneRole extends HttpServlet {

	/**
	 * 获得角色的信息
	 */
	public GetOneRole() {
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
		int  roleID = 0;
		if(request.getParameter("roleID")!=null){
			roleID = Integer.parseInt(request.getParameter("roleID"));
		}
		System.out.println(roleID);
		RoleDao roleDao =new RoleDao();
		Role role = roleDao.getRoleById(roleID);
		System.out.println(role);
		JSONObject map = JSONObject.fromObject(role);
		System.out.println(map.toString());
		response.getWriter().print(map);
	}
}
