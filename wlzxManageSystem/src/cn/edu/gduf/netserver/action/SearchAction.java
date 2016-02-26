package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.SearchDao;
import cn.edu.gduf.netserver.domain.User;

public class SearchAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String otype = request.getParameter("searchType");
		String oparam = request.getParameter("searchContent");
		String type=null,param=null;
		try {
			type=new String(otype.getBytes("iso8859-1"),"UTF-8");
			param=new String(oparam.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SearchDao searchDao = new SearchDao();
		ArrayList<User> searchUsers=new ArrayList<User>();
		if(type!=null&&param!=null){
			searchUsers = searchDao.search(type,param);
		}
		request.setAttribute("searchUsers", searchUsers);		
		return "jsp/searchResult.jsp";
	}

}
