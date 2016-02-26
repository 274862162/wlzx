package cn.edu.gduf.netserver.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.gduf.netserver.dao.MaterialDao;
/**
 * 与servlet重复了！！！
 * @author Administrator
 *
 */
public class UploadAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String section = request.getParameter("section");
		System.out.println("section2="+section);
		int type = Integer.parseInt(request.getParameter("type"));
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File(request.getSession().getServletContext().getRealPath("files/upDownload/temp")));
		// 解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解析，得到List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(0);
			//得到文件保存的路径
			String fileName = fi.getName();//获取上传的文件名称
			//判断文件类型
			int index = fileName.lastIndexOf(".");
			String fileType = "others";
			if(index != -1) {
				fileType = fileName.substring(index+1);
			}
			//音乐文件
			String regEx = "^mp3|wav|wma$";
			Pattern pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
			Matcher mat = pat.matcher(fileType);  
			boolean rs = mat.find();  
			if(rs){
				fileType = "music";
			}
			//文档文件
			regEx = "^txt|doc(x)?|xls(x)?|pdf|wps|ppt(x)?$";
			pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
			mat = pat.matcher(fileType);  
			rs = mat.find();  
			if(rs){
				fileType = "word";
			}
			//视频文件
			regEx = "^mp4|wmv|xls(x)?|pdf|wps|ppt(x)?$";
			pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
			mat = pat.matcher(fileType);  
			rs = mat.find();  
			if(rs){
				fileType = "vedio";
			}
			//图片文件
			regEx = "^jp(e)?g|gif?|png?|bmp$";
			pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
			mat = pat.matcher(fileType);  
			rs = mat.find();  
			if(rs){
				fileType = "photos";
			}
			System.out.println("fileType="+fileType);
			String root = request.getSession().getServletContext().getRealPath("files/upDownload/"+fileType+"/");
			System.out.println("root="+root);
			//创建文件
			File destFile = new File(root, fileName);
			//写数据
			fi.write(destFile);
			
			MaterialDao uploadDao = new MaterialDao();
			boolean isUpload = uploadDao.upload(fileName,root,section,type );
			System.out.println("section2="+section);
			if(isUpload){
				out.write("<script type='text/javascript'> alter('上传失败，请重试！'); </script>");
			}	
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.write("<script type='text/javascript'> alter('上传失败，请重试！'); </script>");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("<script type='text/javascript'> alter('上传失败，请重试！'); </script>");
		}
		System.out.println("section="+section+",type="+type);
		return "UpDownloadServlet?action=showUpDownload&section="+section+"&type="+type;
	}

}
