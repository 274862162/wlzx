package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.gduf.netserver.dao.HoldingDao;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.Hold_items;
import cn.edu.gduf.netserver.domain.User;

public class ArtRegInfoAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		User user = new User();
		UserDao userDao = new UserDao();
		//获得填写的持有物品信息
		int lineTester = Integer.parseInt(request.getParameter("lineTester"));
		int line = Integer.parseInt(request.getParameter("line"));
		int remoteControl = Integer.parseInt(request.getParameter("remoteControl"));
		int switchKey = Integer.parseInt(request.getParameter("switchKey"));
		int meetingRoomKey = Integer.parseInt(request.getParameter("meetingRoomKey"));
		//设置实体类内容
		user.setUserName(userName);
		Hold_items holding = new Hold_items();
	    holding.setUserID(userDao.getUserID(user));
	    int[] items ={lineTester,line,remoteControl,switchKey,meetingRoomKey};
	    HoldingDao holdingDao = new HoldingDao();
		//调用HoldingDao的更新信息方法
		boolean isUpdate=holdingDao.updateArtRegInfo(holding,items);
		if(isUpdate){
			System.out.print("填写成功");
			return "jsp/search.jsp";//如果填写成功，跳到下一页
		}else{
			System.out.print("填写失败");
			return "jsp/artRegInfo.jsp";//如果修改数据库不成功，返回到本页面
		}
	}

}
