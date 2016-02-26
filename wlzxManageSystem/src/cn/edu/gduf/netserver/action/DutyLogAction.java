package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.NoteDao;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;
//登记值班记事的处理
public class DutyLogAction implements Action {
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String ocontent = request.getParameter("content");
		IUserDao userDao=new UserDaoImpl();
		String orecorder="";
		try {
			orecorder = userDao.getNameByUserName(""+request.getSession().getAttribute("userName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String ostatusTemp = request.getParameter("status");
		boolean status = false;
		if(ostatusTemp.equals("已处理")){
			status = true;
		}
		NoteDao noteDao =new NoteDao();
		boolean isInsert = noteDao.insert(ocontent,orecorder,status);
		request.setAttribute("isInsert",isInsert);
		return "jsp/dutyRegister.jsp";
	}

}
