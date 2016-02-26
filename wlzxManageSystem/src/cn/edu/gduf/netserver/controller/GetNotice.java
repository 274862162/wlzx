package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.NoticeDao;
import cn.edu.gduf.netserver.domain.Notice;

public class GetNotice extends HttpServlet {

	/**
	 * 获取角色
	 */
	public GetNotice() {
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
			response.setContentType("text/json;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String department = request.getParameter("department");
		NoticeDao noticeDao =new NoticeDao();
		Notice notice = new Notice();
		try {
			notice = noticeDao.getNotice(department);//查询用户当前的角色
		} catch (Exception e) {
			e.printStackTrace();
		}
		//利用json串给js传一个User对象
		JSONObject jsonObject = JSONObject.fromObject(notice);
		response.getWriter().print(jsonObject);
	}

}
