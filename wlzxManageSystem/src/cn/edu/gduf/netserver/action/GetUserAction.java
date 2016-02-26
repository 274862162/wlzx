package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.gduf.netserver.dao.ImagesDao;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.dao.VideoDao;
import cn.edu.gduf.netserver.domain.Images;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.domain.Video;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class GetUserAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int userID = 0;
		if(request.getParameter("userID")!=null){
			userID = Integer.parseInt(request.getParameter("userID"));
		}
		UserDao userDao =new UserDao();
		User user = new User();
		try {
			user = userDao.getUserById(userID);//查询用户当前的角色
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONObject json = JSONObject.fromObject(user);
		return json.toString();
	}
}
