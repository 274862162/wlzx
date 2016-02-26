package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.impl.ExamineDaoImpl;
import cn.edu.gduf.netserver.domain.Examine;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class ExamShowAction2 implements Action{

	/**
	 * 显示考核的学生记录
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IExamineDao examineDao = new ExamineDaoImpl();
		String paperID = request.getParameter("paperID");
		String paperName = request.getParameter("paperName");
		String page = request.getParameter("page");  // 显示的那一页(当前页)
		if (StringUtil.isEmpty(page)) {
			page = "1";  // 默认第一页
		}
		
		HttpSession session = request.getSession();
		if (paperID != null) {
			session.setAttribute("paperID", paperID);
		} else {
			paperID = (String) session.getAttribute("paperID");
		}
		if (paperName != null) {
			try {
				paperName = new String(paperName.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			session.setAttribute("paperName", paperName);
		} else {
			paperName = (String) session.getAttribute("paperName");
		}
		if (page != null) {
			session.setAttribute("page", page);
		} else {
			page = (String) session.getAttribute("page");
		}
		int totalNum = examineDao.userCount(Integer.parseInt(paperID));  // 考核学生记录总数
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<Examine> examinesList = examineDao.getExamines(pageBean, Integer.parseInt(paperID));
		request.setAttribute("examinesList", examinesList);
		request.setAttribute("paperName", paperName);
		request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 1));
		request.setAttribute("currentTotalPage", PageUtil.getCurrentAndTotalPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize"))));
		return "examShow2";
	}
}