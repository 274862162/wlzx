package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.User;

public class BasicInfoAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		String web = "jsp/basicInfo.jsp";
		User user = new User();
		UserDao userDao = new UserDao();
		//获得填写的个人信息
		String sno = request.getParameter("sno");
		String name=request.getParameter("name");  
		byte[] str;
		try {
			str = name.getBytes("ISO-8859-1");
			name =new String(str,"utf-8");  
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String osex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String oaddress = request.getParameter("address");
		String tel = request.getParameter("tel");
		String shortTel = request.getParameter("shortTel");
		String omajor=request.getParameter("major");
		//String interest = request.getParameter("interest");
		//转码
		String sex="";
		String address="";
		String major="";
		try {
			sex=new String(osex.getBytes("iso8859-1"),"UTF-8");
			address=new String(oaddress.getBytes("iso8859-1"),"UTF-8");
			major=new String(omajor.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(sno!=null&name!=null&address!=null&tel!=null&major!=null&shortTel!=null){	
			//设置实体类内容
			user.setUserName(userName);
			user.setSno(sno);
			user.setName(name);
			user.setSex(sex);
			user.setAge(age);
			user.setDormitory(address);
			user.setLongTelephone(tel);
			user.setShortTelephone(shortTel);
			user.setMajor(major);
			//调用Userdao的更新信息方法
			boolean isUpdate=userDao.updateUser(user);
			if(isUpdate){
				web = "jsp/finishInfo.jsp";//如果填写成功，跳到下一页
			}else{
				request.setAttribute("message", "填写不正确");
			}
		}
		return web;
	}
}
