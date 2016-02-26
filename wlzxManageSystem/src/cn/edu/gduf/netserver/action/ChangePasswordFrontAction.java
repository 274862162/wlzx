package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IStudentDao;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;
import cn.edu.gduf.netserver.domain.Student;

/**
 * @author Wmj
 *网上报修系统类
 *学生修改密码
 */
public class ChangePasswordFrontAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//获取客户端输入的信息
		String originalPassword=request.getParameter("originalPassword");
		String newPassword=request.getParameter("newPassword");
		String sureNewPassword=request.getParameter("sureNewPassword");
		//获取学生学号
		Student student=(Student)request.getSession().getAttribute("student");
		String sno=student.getSno();
		IStudentDao stuImpl=new StudentDaoImpl();
		//获取服务器端客户密码
		String servPassword=stuImpl.getPasswordBysno(sno);
//		System.out.println("输入原密码="+originalPassword+"服务器密码="+servPassword);
		if(!originalPassword.equals(servPassword)){
			return "原密码输入不正确！";
		}else if(newPassword.indexOf(" ")!=-1 || servPassword.indexOf(" ")!=-1){
			return "密码不能包含空格！";
		}
		else if(!newPassword.equals(sureNewPassword)){
			return "新密码前后不一致！";
		}else if(newPassword.length()<6){
			return "新密码必须大于6位！";
		}else{
			stuImpl.updatePassword(sno, sureNewPassword);
			return "修改密码成功！";
		}		
	}

}
