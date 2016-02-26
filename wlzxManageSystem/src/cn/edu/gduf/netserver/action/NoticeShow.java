package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.NoticeDao;
import cn.edu.gduf.netserver.domain.Notice;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class NoticeShow implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		NoticeDao noticeDao = new NoticeDao();
		String page = request.getParameter("page");  // 显示的那一页(当前页)
		if (StringUtil.isEmpty(page)) {
			page = "1";  // 默认第一页
		}
		System.out.println("page="+Integer.parseInt(page));
		int totalNum = noticeDao.count();  // 文件总数
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<Notice> imagesList = noticeDao.getNotices(pageBean);
		System.out.println(imagesList);
		request.setAttribute("imagesList", imagesList);
		request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 0));
		request.setAttribute("currentTotalPage", PageUtil.getCurrentAndTotalPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize"))));
		return "jsp/superManagement5.jsp";
	}
}
