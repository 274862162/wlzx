package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.domain.UserRole;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class UserRoleShowAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		UserRoleDao userRoleDao = new UserRoleDao();
		String currentPage = request.getParameter("page");  // 显示的那一页(当前页)
		String displayRecord = request.getParameter("displayRecord");//每页显示多少条
		if (StringUtil.isEmpty(currentPage)) {
			currentPage = "1";  // 默认第一页
		}
		if(StringUtil.isEmpty(displayRecord)) {
			displayRecord = PropertiesUtil.getValue("pageSize");  // 默认第一页
		}
		int totalNum = userRoleDao.count();  // 记事总数
		int pageSize = Integer.parseInt(displayRecord);
		PageBean pageBean = new PageBean(Integer.parseInt(currentPage), pageSize);
		List<UserRole> userRoleList = null;
		//得到用户名
		String userName = request.getParameter("userName");
		if(userName==null||userName.equals("")){
			//totalNum = userRoleDao.count();  
			userRoleList = userRoleDao.getList(pageBean);
		}else{
			totalNum = 1;
			userRoleList = userRoleDao.getUserRoleList(userName);
		}
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;  // 总页数
		Result result = new Result();
		result.setList(userRoleList);
		result.setPage(Integer.parseInt(currentPage));
		result.setTotalPage(totalPage);
		JSONArray json = JSONArray.fromObject(result);
		return json.toString();
		/*request.setAttribute("userRoleList", userRoleList);
		request.setAttribute("upDownPage", PageUtil.getUpAndDownPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")), 0));
		request.setAttribute("currentTotalPage", PageUtil.getCurrentAndTotalPage(totalNum, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize"))));
		return "jsp/superManagement2.jsp";*/
	}

}
