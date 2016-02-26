package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.SearchSwitchDao;
import cn.edu.gduf.netserver.domain.Switch;

public class GetSwitch extends HttpServlet {

	/**
	 * ajax取交换机信息
	 */
	public GetSwitch() {
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
		String building = request.getParameter("building");
		String buildingNo = request.getParameter("buildingNo");
		SearchSwitchDao searchSwitchDao = new SearchSwitchDao();
		Switch searchSwitch = searchSwitchDao.searchSwitch(Integer.parseInt(building),Integer.parseInt(buildingNo));
		//利用json串给js传一个User对象
		JSONObject jsonObject = JSONObject.fromObject(searchSwitch);
		response.getWriter().print(jsonObject);
	}

}
