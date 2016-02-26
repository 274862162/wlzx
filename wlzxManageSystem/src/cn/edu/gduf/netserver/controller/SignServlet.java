package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.SignDao;
import cn.edu.gduf.netserver.dao.SystemLogListDao;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.Log;
import cn.edu.gduf.netserver.domain.Sign;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.PropertiesUtil;

public class SignServlet extends HttpServlet {

	/**
	 * 签到,存在一个问题，重复签到
	 */
	public SignServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		Date signTime = new java.util.Date();//获得当前时间
		String ip = request.getLocalAddr();
		boolean isLate = true;
		SignDao signDao = new SignDao();
		User user = new User();
		user.setUserName(username);
		Sign sign = new Sign();
		sign.setUserID((Integer)session.getAttribute("id"));
		sign.setSignTime(signTime);
		String time = null;
		String message = "";
		int dutyType = signDao.getDutyTime(user);
		if(dutyType==1){
			time="时间段1";
		}
		if(dutyType==2){
			time="时间段2";
		}
		if(dutyType==3){
			time="时间段3";
		}
		String dutyTime = PropertiesUtil.getValue(time);
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String str = sdf.format(signTime);
		    str = str.substring(0,10);
		    String dateString = str+" "+dutyTime;
		    Date date = sdf.parse(dateString); 
		    int compare = signTime.compareTo(date);
		    if(compare<=0){
		    	isLate = false;
		    }
		}  
		catch (ParseException e)  
		{  
		    System.out.println(e.getMessage());  
		}
		if(!ip.equals("127.0.0.1")){
			message = "签到不成功，不在指定地方签到";
		}else {
			sign.setIsLate(isLate);
			if(signDao.addRecord(sign)){
				System.out.println("添加成功");
			}
			//写入日志
			SystemLogListDao logDao=new SystemLogListDao();
			Log suclog=new Log();
			InetAddress address=null;
			String clientIp="";
			try {
				address = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			if(address!=null){
				clientIp=address.getHostAddress();
			}
			suclog.setType("2");
			suclog.setContent("用户:"+session.getAttribute("userName")+"值班签到，IP:"+ip);
			suclog.setOperator(""+session.getAttribute("userName"));
			logDao.addLog(suclog);
			message= "签到成功";
		}	
		response.getWriter().print(message);
	}

}
