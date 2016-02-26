package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.SearchSwitchDao;
import cn.edu.gduf.netserver.domain.Switch;

public class SearchSwitchAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String building = request.getParameter("building");
		String buildingNo = request.getParameter("buildingNo");
		System.out.println(building+","+buildingNo);
		SearchSwitchDao searchSwitchDao = new SearchSwitchDao();
		Switch searchSwitch = searchSwitchDao.searchSwitch(Integer.parseInt(building),Integer.parseInt(buildingNo));
		session.setAttribute("photo", searchSwitch.getPhoto());
		session.setAttribute("switchRegister", searchSwitch.getSwitchRegister());
		return "jsp/searchSwitchResult.jsp";
	}

}
