package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
		String userName = (String)session.getAttribute("userName");
		UserDao userDao = new UserDao();
		User user = new User();
		String option = request.getParameter("option");//判断处理类型
		if(option.equals("check")){//如果是查看
			user = userDao.getPersonInfo(userName);
			request.setAttribute("user",user);
			return "jsp/personInfo.jsp";
		}else if(option.equals("update")){//如果是更新	
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
					// TODO Auto-generated catch block
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
			System.out.println("dormitory"+dormitory);
			String longPhone = request.getParameter("longPhone");
			String shortPhone = request.getParameter("shortPhone");
			user.setUserName(userName);
			user.setSno(sno);
			user.setName(name);
			user.setDormitory(dormitory);
			user.setAge(age);
			user.setMajor(major);
			user.setLongTelephone(longPhone);
			user.setShortTelephone(shortPhone);
			userDao.updateBasicInfoToUser(user);//更新个人信息
			return "jsp/dutyRegister.jsp";
		}else{
			return "jsp/dutyRegister.jsp";
		}
	}
}
