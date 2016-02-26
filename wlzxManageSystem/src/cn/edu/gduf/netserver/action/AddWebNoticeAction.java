package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.WebNoticeDao;
import cn.edu.gduf.netserver.domain.WebNotice;

public class AddWebNoticeAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//获得操作人
		HttpSession session = request.getSession(true);
		String userName = (String)session.getAttribute("userName");
		System.out.println(userName);
		//得到公告标题
		String title = request.getParameter("title");
		//得到公告内容
		String content = request.getParameter("content");
		WebNotice webNotice = new WebNotice();
		webNotice.setOperator(userName);
		webNotice.setContent(content);
		webNotice.setTitle(title);
		WebNoticeDao webNoticeDao = new WebNoticeDao();
		int result = 0;
		try {
			result = webNoticeDao.addWebNotice(webNotice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result!=0){
			System.out.println("添加成功");
		}
		return "jsp/superManagement3.jsp";
	}
}
