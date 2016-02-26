package cn.edu.gduf.netserver.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.gduf.netserver.dao.NoteDao;
import cn.edu.gduf.netserver.domain.Note;

public class ShowDutyRegisterServlet extends HttpServlet {

	/**
	 * 处理值班记事
	 */
	public ShowDutyRegisterServlet() {
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
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/xml;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int noteID = Integer.parseInt(request.getParameter("noteID"));
		System.out.println("showID："+noteID);
		String event = request.getParameter("event");
		NoteDao noteDao =new NoteDao();
		Note note = noteDao.check(noteID);
		JSONObject map = JSONObject.fromObject(note);
		System.out.println(map.toString());
		response.getWriter().print(map);
	}

}
