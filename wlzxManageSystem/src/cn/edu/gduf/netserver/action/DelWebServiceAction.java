package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.WebServiceDao;

public class DelWebServiceAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int webServiceID = 0;
		if(request.getParameter("fileID")!=null){
			webServiceID = Integer.parseInt(request.getParameter("fileID"));//获得角色ID
		}
		WebServiceDao webServiceDao =new WebServiceDao();
		int result = webServiceDao.deleteWebServiceById(webServiceID);
		String message = "";
		if(result==0){
			message = "删除不成功，请重试";
		}else{
			message = "删除成功";
		}
		return message;
	}

}
