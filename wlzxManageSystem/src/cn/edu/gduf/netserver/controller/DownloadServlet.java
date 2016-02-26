package cn.edu.gduf.netserver.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Encoder;
import cn.edu.gduf.netserver.dao.MaterialDao;

public class DownloadServlet extends HttpServlet {

	public DownloadServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MaterialDao materialDao = new MaterialDao();
		int fileID = Integer.parseInt(request.getParameter("fileID"));
		String fileName = this.getServletContext().getRealPath(materialDao.getFileName(fileID));
		//得到下载框显示的文件名
		int index = fileName.lastIndexOf("\\");
		String frameName = "";
		if(index != -1) {
			frameName = filenameEncoding(fileName.substring(index+1), request);//截取文件名，并转换格式
		}
		String contentType = this.getServletContext()
				.getMimeType(fileName);//通过文件名称获取MIME类型
		String contentDisposition = "attachment;filename=" + frameName;
		// 一个流
		FileInputStream input = new FileInputStream(fileName);
		//设置头
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		// 获取绑定了响应端的流
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(input, output);//把输入流中的数据写入到输出流中。
		input.close();
	}
	
	// 用来对下载的文件名称进行编码的！
	public static String filenameEncoding(String filename, HttpServletRequest request) throws IOException {
		String agent = request.getHeader("User-Agent"); //获取浏览器
		if (agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8"))
					+ "?=";
		} else if(agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}

}
