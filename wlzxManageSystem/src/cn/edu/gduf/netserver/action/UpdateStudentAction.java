package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.AreaDao;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;
import cn.edu.gduf.netserver.domain.Student;

public class UpdateStudentAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int studentID = 0;
		if(request.getParameter("studentID")!=null){
			studentID = Integer.parseInt(request.getParameter("studentID"));//获得区域ID
		}
		String name = request.getParameter("name");//获得学生姓名
		String sno = request.getParameter("sno");//获得学生学号
		String password = request.getParameter("password").trim();
		String repassword = request.getParameter("repassword").trim();
		if(!password.equals(repassword)){
			request.setAttribute("message", "新密码输入不一致");
		}else{
			Student student = new Student();
			student.setName(name);
			student.setSno(sno);
			student.setPassword(password);
			student.setStudentID(studentID);
			StudentDaoImpl studentDao = new StudentDaoImpl();
			int i = studentDao.updateStudent(student);
			if(i>0){
				request.setAttribute("message","更新成功");
			}else{
				request.setAttribute("message","更新出错");
			}
		}
		
		return "jsp/superManagement11.jsp";
	}
}
