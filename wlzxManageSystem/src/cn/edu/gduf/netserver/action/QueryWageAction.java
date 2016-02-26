package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.gduf.netserver.dao.WageDao;


public class QueryWageAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		WageDao wageDao = new WageDao();
		//List wageInfo = wageDao.getWageInfo(userName);
		//request.setAttribute("wage", wage);
		return "jsp/queryWage1.jsp";
	}

}
