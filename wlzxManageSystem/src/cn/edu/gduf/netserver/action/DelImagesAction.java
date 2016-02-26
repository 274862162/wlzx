package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ImagesDao;

public class DelImagesAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int imagesID = 0;
		if(request.getParameter("imagesID")!=null){
			imagesID = Integer.parseInt(request.getParameter("imagesID"));//获得角色ID
		}
		System.out.println("imagesID="+imagesID);
		ImagesDao imagesDao =new ImagesDao();
		int result = imagesDao.deleteImagesById(imagesID);
		String message = "";
		if(result==0){
			message = "删除不成功，请重试";
		}else{
			message = "删除成功";
		}
		return message;
	}

}
