package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.VideoDao;
import cn.edu.gduf.netserver.domain.Video;

public class GetVideo extends HttpServlet {

	/**
	 * 得到学习文件
	 */
	public GetVideo() {
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
		int fileID = 0;
		if(request.getParameter("fileID")!=null){
			fileID = Integer.parseInt(request.getParameter("fileID"));
		}
		VideoDao videoDao =new VideoDao();
		Video video = null;
		video = videoDao.getVideoById(fileID);//查询用户当前的角色
		System.out.println(video);
		JSONObject jsonObject = JSONObject.fromObject(video);
		System.out.println(jsonObject.toString());
		response.getWriter().print(jsonObject);
	}

}
