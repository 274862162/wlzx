package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.impl.ExamineDaoImpl;
import cn.edu.gduf.netserver.domain.Examine;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class ExamShowAction implements Action{

	/**
	 * 显示考核记录
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IExamineDao examineDao = new ExamineDaoImpl();
		String page = request.getParameter("page");  // 显示的那一页(当前页)
		if (StringUtil.isEmpty(page)) {
			page = "1";  // 默认第一页
		}
		int totalNum = examineDao.count();  // 考核记录总数
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		List<Examine> examinesList = examineDao.getExamines(pageBean);
		request.setAttribute("examinesList", examinesList);
		request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 1));
		request.setAttribute("currentTotalPage", PageUtil.getCurrentAndTotalPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize"))));
		return "examShow";
	}
}