package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.SystemLogListDao;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.Log;
import cn.edu.gduf.netserver.domain.User;

public class LoginAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userName = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password").trim();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		//登陆成功写入日志
		SystemLogListDao logDao=new SystemLogListDao();
		Log suclog=new Log();
		InetAddress address=null;
		String ip="";
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if(address!=null){
			ip=address.getHostAddress();
		}
		//登录验证
		boolean isUser = userDao.check(user);
		//判断是否是第一次登录
		boolean isFirstTime = userDao.isFirstTime(user);
		if(isUser){
			System.out.print("验证成功");
			session.setAttribute("userName", userName);
			session.setAttribute("id", userDao.getUserID(user));
			suclog.setType("2");
			suclog.setContent("用户:"+session.getAttribute("userName")+"登录成功！IP:"+ip);
			suclog.setOperator(""+session.getAttribute("userName"));
			logDao.addLog(suclog);
			if(isFirstTime){
				return "jsp/firstTime.jsp";//第一次登录
			}else{
				return "jsp/dutyRegister.jsp";//不是第一次登录
			}
		}else{
			request.setAttribute("message", "用户名或密码出错。");
			return "jsp/login.jsp";//验证不成功，返回到本页面
		}
	}

}
