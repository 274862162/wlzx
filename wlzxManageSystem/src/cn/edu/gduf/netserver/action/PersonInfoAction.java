package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.User;

public class PersonInfoAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		int userID = (Integer)session.getAttribute("id");
		UserDao userDao = new UserDao();
		User user = new User();
		String option = request.getParameter("option");//判断处理类型
		//如果是查看
		if(option.equals("check")){
			user = userDao.getPersonInfo(userID);
			request.setAttribute("user",user);
			//return "jsp/personInfo.jsp";
			
		}else if(option.equals("update")){	//如果是更新	
			int age = 0;
			if(request.getParameter("age")!=null){
				age = Integer.parseInt(request.getParameter("age"));
			}
			//得到姓名，乱码处理
			String name = request.getParameter("name");
			if(name!=null){
				try {
					byte[] str = name.getBytes("ISO-8859-1");  
					name =new String(str,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}  
			}
			String major = request.getParameter("major");
			if(major!=null){
				try {
					byte[] str = major.getBytes("ISO-8859-1");  
					major =new String(str,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}  
			}
			String sno = request.getParameter("sno");
			if(sno!=null){
				try {
					byte[] str = sno.getBytes("ISO-8859-1");  
					sno =new String(str,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}  
			}
			String dormitory = request.getParameter("dormitory");
			if(dormitory!=null){
				try {
					byte[] str = dormitory.getBytes("ISO-8859-1");  
					dormitory =new String(str,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}  
			}
			String longPhone = request.getParameter("longPhone");
			String shortPhone = request.getParameter("shortPhone");
			user.setUserID(userID);
			user.setSno(sno);
			user.setName(name);
			user.setDormitory(dormitory);
			user.setAge(age);
			user.setMajor(major);
			user.setLongTelephone(longPhone);
			user.setShortTelephone(shortPhone);
			if(userDao.updateUser(user)){
				request.setAttribute("message", "修改成功");
			}else{
				request.setAttribute("message", "修改失败");
			}
			//取更新之后的信息
			user = userDao.getPersonInfo(userID);
			request.setAttribute("user",user);
		}else{
			//return "jsp/dutyRegister.jsp";
		}
		return "jsp/personInfo.jsp";
	}
}
