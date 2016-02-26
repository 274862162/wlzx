package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.domain.Role;

public class AddRoleAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//得到角色名称
		String roleName = request.getParameter("roleName");
		/*if(roleName!=null){
			byte[] str = roleName.getBytes("ISO-8859-1");  
			roleName =new String(str,"utf-8");  
		}*/
		//得到角色描述
		String roleDescription = request.getParameter("roleDescription");
		/*if(roleDescription!=null){
			byte[] str = roleDescription.getBytes("ISO-8859-1");  
			roleDescription =new String(str,"utf-8");  
		}*/
		//得到选择的权限
		String[] auth = request.getParameterValues("auth");
		String authID = "";//存到数据库的内容
		if(auth!=null){
			for(int i=0;i<auth.length;i++){
				if(authID == ""){
					authID = auth[i];
				}else{
					authID = authID+","+auth[i];//用逗号隔开，整合权限到一个字段存储
				}
			}
		}
		Role role = new Role();
		role.setRoleName(roleName);
		role.setAuthID(authID);
		role.setRoleDescription(roleDescription);
		RoleDao roleDao = new RoleDao();
		try {
			int i = roleDao.addRole(role);
			if(i>0){
				request.setAttribute("message","插入成功");
			}else{
				request.setAttribute("message","插入出错");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message","插入出错");
		}
		return "jsp/superManagement1.jsp";
	}
}
