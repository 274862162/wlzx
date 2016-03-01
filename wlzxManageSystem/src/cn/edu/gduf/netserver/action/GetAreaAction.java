package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.AreaDao;
import cn.edu.gduf.netserver.domain.Area;

public class GetAreaAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int areaID = 0;
		if(request.getParameter("areaID")!=null){
			areaID = Integer.parseInt(request.getParameter("areaID"));
		}
		AreaDao areaDao =new AreaDao();
		Area area = new Area();
		area = areaDao.getAreaById(areaID);//查询用户区域信息
		JSONObject json = JSONObject.fromObject(area);
		return json.toString();
	}
}
