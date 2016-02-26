package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.DownloadSectionDao;

public class DelDownloadSectionAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int downloadSectionFileID = 0;
		if(request.getParameter("downloadSectionFileID")!=null){
			downloadSectionFileID = Integer.parseInt(request.getParameter("downloadSectionFileID"));//获得角色ID
		}
		System.out.println("downloadSectionFileID="+downloadSectionFileID);
		DownloadSectionDao downloadSectionDao =new DownloadSectionDao();
		int result = downloadSectionDao.deleteDownloadSectionById(downloadSectionFileID);
		String message = "";
		if(result==0){
			message = "删除不成功，请重试";
		}else{
			message = "删除成功";
		}
		return message;
	}

}
