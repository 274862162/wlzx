package cn.edu.gduf.netserver.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.gduf.netserver.dao.MaterialDao;

public class UploadServlet extends HttpServlet {

	/**
	 * 上传文件
	 */
	public UploadServlet() {
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
		/*response.setContentType("text/html;charset=utf-8");*/
		String section = "";//保存当前所在的部门位置
		int type = 5;//默认是"其他"类型
		PrintWriter out = response.getWriter();
		MaterialDao materialDao = new MaterialDao();
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File(this.getServletContext().getRealPath("files/upDownload/temp")));
		// 解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解析，得到List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);
			String fileName = fi.getName();//获取上传的文件名称
			//判断文件是否已经存在（文件同名）
			if(!materialDao.isExisting(fileName)){
				//得到用户所在资料库的部门名字
				if(list.get(2).isFormField()){
					if(list.get(2).getFieldName().equals("section")){
						section = list.get(2).getString("utf-8");
					}
				}
				
				//使用正则表达式判断文件类型
				int index = fileName.lastIndexOf(".");
				String fileType = "others";//默认是"其他"类型
				if(index != -1) {
					fileType = fileName.substring(index+1);//得到后缀名
				}
			
				//文档文件
				String regEx = "^txt|doc(x)?|xls(x)?|pdf|wps|ppt(x)?$";
				Pattern pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
				Matcher mat = pat.matcher(fileType);  
				boolean rs = mat.find();  
				if(rs){
					fileType = "word";
					type = 1;
				}
				//图片文件
				regEx = "^jp(e)?g|gif?|png?|bmp$";
				pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
				mat = pat.matcher(fileType);  
				rs = mat.find();  
				if(rs){
					fileType = "photos";
					type = 2;
				}
				//音乐文件
				regEx = "^mp3|wav|wma$";
				pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
				mat = pat.matcher(fileType);  
				rs = mat.find();  
				if(rs){
					fileType = "music";
					type = 4;
				}
				String root = this.getServletContext().getRealPath("files/upDownload/"+fileType+"/");
				//创建文件
				File destFile = new File(root, fileName);
				//写数据
				fi.write(destFile);
				
				//写到数据库
				boolean isUpload = materialDao.upload(fileName, "files/upDownload/"+fileType+"/", section, type);
				if(isUpload == true){
					out.write("<script type='text/javascript'> alert('文件上传成功') </script>");
				}
				
				//重新编码
				byte[] str = section.getBytes("utf-8");  
				section =new String(str,"ISO-8859-1");
			}
			String url = "jsp/uploadDownload.jsp?section="+section;
			response.sendRedirect(url); 
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
