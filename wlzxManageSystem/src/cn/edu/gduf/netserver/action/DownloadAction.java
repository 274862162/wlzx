package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.gduf.netserver.dao.DownloadDao;

public class DownloadAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int fileID = Integer.parseInt(request.getParameter("fileID"));
		DownloadDao downloadDao = new DownloadDao();
		String path = request.getSession().getServletContext().getRealPath("/")+downloadDao.getPath(fileID);
		System.out.println(path);
		String fileName = downloadDao.getFileName(fileID);
		String message = downloadDao.download(response,fileName,path);
		request.setAttribute("message", message);
		return "jsp/uploadDownload2.jsp";
	}
}
