package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.NoteDao;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;

public class DealingDutyRegisterAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int noteID =Integer.parseInt(request.getParameter("noteID"));
		IUserDao userDao=new UserDaoImpl();
		String dealingContent = request.getParameter("dealingContent");
		String handle="";
		try {
			handle=userDao.getNameByUserName(""+request.getSession().getAttribute("userName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String ostatus=request.getParameter("status");
		Boolean status=false;
		if(ostatus.equals("已处理")){
			status=true;
		}
		NoteDao noteDao =new NoteDao();
		Boolean isDealing = noteDao.dealing(noteID,dealingContent,handle,status);
		request.setAttribute("isDealing",isDealing);
		return "jsp/dutyRegister.jsp";
	}

}
