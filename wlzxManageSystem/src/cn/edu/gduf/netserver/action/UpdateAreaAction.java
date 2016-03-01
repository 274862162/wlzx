package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.AreaDao;
import cn.edu.gduf.netserver.domain.Area;

public class UpdateAreaAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int areaID = 0;
		if(request.getParameter("areaID")!=null){
			areaID = Integer.parseInt(request.getParameter("areaID"));//获得区域ID
		}
		int userID = 0;
		if(request.getParameter("userID")!=null){
			userID = Integer.parseInt(request.getParameter("userID"));//获得区域ID
		}
		String areaName = request.getParameter("areaName");//获得区域名
		if(areaName!=null){
			byte[] str;
			try {
				str = areaName.getBytes("ISO-8859-1");
				areaName =new String(str,"utf-8"); 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}  
			 
		}
		Area area = new Area();
		area.setAreaName(areaName);
		area.setUserID(userID);
		area.setAreaID(areaID);
		AreaDao areaDao = new AreaDao();
		int i = areaDao.updateArea(area);
		if(i>0){
			request.setAttribute("message","更新成功");
		}else{
			request.setAttribute("message","更新出错");
		}
		return "jsp/superManagement10.jsp";
	}
}
