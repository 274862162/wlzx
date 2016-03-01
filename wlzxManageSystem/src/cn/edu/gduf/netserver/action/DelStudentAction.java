package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;

public class DelStudentAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int studentID = 0;
		if(request.getParameter("studentID")!=null){
			studentID = Integer.parseInt(request.getParameter("studentID"));//获得用户ID
		}
		StudentDaoImpl studentDao =new StudentDaoImpl();
		String message = "";
		if(studentDao.deleteStudentById(studentID)>0){
			message = "删除成功";			
		}else{
			message = "删除不成功，请重试";
		}
		return message;
	}

}
