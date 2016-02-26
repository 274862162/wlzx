package cn.edu.gduf.netserver.action;

import java.io.File;
import java.io.IOException;
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

import cn.edu.gduf.netserver.dao.VideoDao;
import cn.edu.gduf.netserver.domain.Video;

public class UpdateVideoAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("更新视频文件！");
		//文件ID
		int fileID = 0;
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024,new File(request.getSession().getServletContext().getRealPath("files/video/temp")));
		// 解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解析，得到List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);
			//得到文件保存的路径
			String fileName = fi.getName();//获取上传的文件名称
			//判断文件类型
			int index = fileName.lastIndexOf(".");
			String fileType = "";
			if(index != -1) {
				fileType = fileName.substring(index+1);
			}
			String regEx = "^js|jsp|html$";
			Pattern pat = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);  
			Matcher mat = pat.matcher(fileType);  
			boolean rs = mat.find();  
			if(rs){
				request.setAttribute("uploadMessage", "不允许上传该类文件");
			}
			String filePath = request.getSession().getServletContext().getRealPath("files/video/");
			System.out.println("filePath="+filePath);
			//创建文件
			File destFile = new File(filePath, fileName);
			//写数据
			fi.write(destFile);
			
			//得到文件ID
			if(list.get(2).isFormField()){
				if(list.get(2).getFieldName().equals("fileID")){
					String temp = list.get(2).getString("utf-8");
					if(!(temp==null||temp.equals(""))){
						fileID= Integer.parseInt(temp);
					}
				}
			}
			VideoDao videoDao = new VideoDao();
			Video video = new Video();
			video.setFileID(fileID);
			video.setFileName(fileName);
			video.setFilePath(filePath);
			int isUpload = videoDao.updateVideo(video);
			if(isUpload==0){
				request.setAttribute("uploadMessage", "上传失败，请重试！");
			}	
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("uploadMessage", "上传失败，请重试！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("uploadMessage", "上传失败，请重试！");
		}
		return "jsp/superManagement8.jsp";
	}

}
