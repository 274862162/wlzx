package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.NoticeDao;
import cn.edu.gduf.netserver.domain.Notice;

public class AddNoticeAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession(true);
		String userName = (String)session.getAttribute("userName");
		String department = request.getParameter("department");
		String content = request.getParameter("content");
		NoticeDao noticeDao =new NoticeDao();
		Notice notice = new Notice();
		notice.setOperator(userName);
		notice.setDepartment(department);
		notice.setContent(content);
		int result = 0;
		String message="";
		try{
			result = noticeDao.addNotice(notice);
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		if(result == 0){
			message="发布失败，请重试";
		}else if(result == 1){
			message="发布成功";
		}
		return message;
	}
}
