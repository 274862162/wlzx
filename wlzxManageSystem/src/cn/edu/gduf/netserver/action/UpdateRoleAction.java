package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.dao.WebNoticeDao;
import cn.edu.gduf.netserver.domain.Role;
import cn.edu.gduf.netserver.domain.WebNotice;

public class UpdateRoleAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int roleID = 0;
		if(request.getParameter("roleID")!=null){
			roleID = Integer.parseInt(request.getParameter("roleID"));//获得角色ID
		}
		String roleName = request.getParameter("roleName1");//获得角色名
		if(roleName!=null){
			byte[] str;
			try {
				str = roleName.getBytes("ISO-8859-1");
				roleName =new String(str,"utf-8"); 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
			 
		}
		System.out.println("role="+roleName);
		String roleDescription = request.getParameter("roleDescription1");//获得角色描述
		if(roleDescription!=null){
			byte[] str;
			try {
				str = roleDescription.getBytes("ISO-8859-1");
				roleDescription =new String(str,"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
		}
		String[] auth = request.getParameterValues("auth");//得到选择的权限
		System.out.println("auth="+auth);
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
		role.setRoleID(roleID);
		role.setRoleName(roleName);
		role.setRoleDescription(roleDescription);
		role.setAuthID(authID);
		RoleDao roleDao = new RoleDao();
		int i = roleDao.updateRole(role);
		if(i>0){
			request.setAttribute("message","更新成功");
		}else{
			request.setAttribute("message","更新出错");
		}
		return "jsp/superManagement1.jsp";
	}
}
