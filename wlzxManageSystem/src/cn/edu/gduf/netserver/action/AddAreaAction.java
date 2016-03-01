package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.AreaDao;
import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.domain.Area;
import cn.edu.gduf.netserver.domain.UserRole;

public class AddAreaAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String areaName = request.getParameter("areaName");
		int userID = 0;
		if(request.getParameter("userID")!=null){
			userID = Integer.parseInt(request.getParameter("userID"));
		}
		AreaDao areaDao = new AreaDao();
		Area area = new Area();
		area.setAreaName(areaName);
		area.setUserID(userID);
		if(areaDao.getAreaID(area)!=0){
			request.setAttribute("message", "该区域已存在");
		} else
			try {
				if(areaDao.addArea(area)>0){
					request.setAttribute("message", "添加区域成功");
				}else{
					request.setAttribute("message", "添加区域失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return "jsp/superManagement10.jsp";
	}
}
