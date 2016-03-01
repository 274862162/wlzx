package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.UserDao;
import cn.edu.gduf.netserver.domain.User;

public class UserListAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getAllUser();
		JSONArray json = JSONArray.fromObject(userList);
		return json.toString();
	}
}
