package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.VideoDao;
import cn.edu.gduf.netserver.dao.WebNoticeDao;

public class DelWebNoticeAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int webNoticeID = 0;
		if(request.getParameter("webNoticeID")!=null){
			webNoticeID = Integer.parseInt(request.getParameter("webNoticeID"));//获得角色ID
		}
		WebNoticeDao webNoticeDao =new WebNoticeDao();
		int result = webNoticeDao.deleteWebNoticeById(webNoticeID);
		String message = "";
		if(result==0){
			message = "删除不成功，请重试";
		}else{
			message = "删除成功";
		}
		return message;
	}

}
