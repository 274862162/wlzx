package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.dao.WebNoticeDao;
import cn.edu.gduf.netserver.domain.Role;
import cn.edu.gduf.netserver.domain.WebNotice;

public class UpdateWebNoticeAction implements Action {

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
		//得到公告标题
		String title = request.getParameter("title");
		//得到公告内容
		String content = request.getParameter("content");
		WebNotice webNotice = new WebNotice();
		webNotice.setNoticeID(webNoticeID);
		webNotice.setContent(content);
		webNotice.setTitle(title);
		WebNoticeDao webNoticeDao = new WebNoticeDao();
		int result = 0;
		result = webNoticeDao.updateWebNotice(webNotice);
		if(result!=0){
			System.out.println("添加成功");
		}
		return "jsp/superManagement3.jsp";
	}
}
