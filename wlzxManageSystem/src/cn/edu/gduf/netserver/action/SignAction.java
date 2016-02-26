package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
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

public class SignAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println("sessionID:"+(Integer)request.getSession().getAttribute("id"));
		HttpSession session = request.getSession(true);
		Date signTime = (Date)session.getAttribute("time");
		String ip = request.getLocalAddr();
		boolean isLate = true;
		SignDao signDao = new SignDao();
		User user = new User();
		user.setUserName((String)session.getAttribute("userName"));
		Sign sign = new Sign();
		sign.setUserID((Integer)session.getAttribute("id"));
		sign.setSignTime(signTime);
		String time = null;
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
		System.out.println(dutyTime);
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String str = sdf.format(signTime);
		    str = str.substring(0,10);
		    String dateString = str+dutyTime;
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
		if(ip!="127.0.0.1"){
			return "签到不成功，不在指定地方签到";
		}else {
			sign.setIsLate(isLate);
			if(signDao.addRecord(sign)){
				System.out.println("添加成功");
			}
			return "签到成功";
		}	
	}

}
