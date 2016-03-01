package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.RoleDao;
import cn.edu.gduf.netserver.dao.UserRoleDao;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;
import cn.edu.gduf.netserver.domain.Student;
import cn.edu.gduf.netserver.domain.UserRole;

public class AddStudentAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String password = request.getParameter("password").trim();
		String repassword = request.getParameter("repassword").trim();
		String sno = request.getParameter("sno");
		if(!password.equals(repassword)){
			request.setAttribute("message", "新密码输入不一致");
		}else{
			StudentDaoImpl studentDao = new StudentDaoImpl();
			Student student = new Student();
			student.setName(name);
			student.setPassword(password);
			student.setSno(sno);
			if(studentDao.getStudentBySno(sno).getSno()!=null){
				request.setAttribute("message", "该用户名已存在");
			} else
				try {
					if(studentDao.addStudent(student)>0){
						request.setAttribute("message", "添加用户成功");
					}else{
						request.setAttribute("message", "添加用户失败");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		return "jsp/superManagement11.jsp";
	}
}
