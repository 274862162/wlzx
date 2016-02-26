package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.gduf.netserver.dao.ImagesDao;
import cn.edu.gduf.netserver.dao.WebNoticeDao;
import cn.edu.gduf.netserver.dao.WebServiceDao;
import cn.edu.gduf.netserver.domain.Images;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.domain.WebNotice;
import cn.edu.gduf.netserver.domain.WebService;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class GetWebServiceAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int fileID = 0;
		if(request.getParameter("fileID")!=null){
			fileID = Integer.parseInt(request.getParameter("fileID"));
		}
		WebServiceDao webServiceDao =new WebServiceDao();
		WebService webService = null;
		webService = webServiceDao.getWebServiceById(fileID);//查询当前文件信息
		JSONObject json = JSONObject.fromObject(webService);
		return json.toString();
	}
}
