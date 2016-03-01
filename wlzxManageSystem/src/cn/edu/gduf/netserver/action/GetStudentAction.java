package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;
import cn.edu.gduf.netserver.domain.Student;

public class GetStudentAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int studentID = 0;
		if(request.getParameter("studentID")!=null){
			studentID = Integer.parseInt(request.getParameter("studentID"));
		}
		StudentDaoImpl studentDao =new StudentDaoImpl();
		Student student = new Student();
		student = studentDao.getStudentById(studentID);//查询用户区域信息
		JSONObject json = JSONObject.fromObject(student);
		return json.toString();
	}
}
