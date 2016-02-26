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

import cn.edu.gduf.netserver.dao.DownloadSectionDao;
import cn.edu.gduf.netserver.domain.DownloadSection;

public class UpdateDownloadSectionAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//文件ID
		int downloadSectionFileID = 0;
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024,new File(request.getSession().getServletContext().getRealPath("files/downloadSection/temp")));
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
			String filePath = request.getSession().getServletContext().getRealPath("files/downloadSection/");
			System.out.println("filePath="+filePath);
			//创建文件
			File destFile = new File(filePath, fileName);
			//写数据
			fi.write(destFile);
			
			//得到文件ID
			if(list.get(2).isFormField()){
				if(list.get(2).getFieldName().equals("downloadSectionFileID")){
					String temp = list.get(2).getString("utf-8");
					if(!(temp==null||temp.equals(""))){
						downloadSectionFileID= Integer.parseInt(temp);
						System.out.println("啦啦啦,我是="+downloadSectionFileID);
					}
				}
			}
			DownloadSectionDao downloadSectionDao = new DownloadSectionDao();
			DownloadSection downloadSection = new DownloadSection();
			downloadSection.setDownloadSectionFileID(downloadSectionFileID);
			downloadSection.setFileName(fileName);
			downloadSection.setFilePath(filePath);
			int isUpload = downloadSectionDao.updateDownloadSection(downloadSection);
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
		return "jsp/superManagement4.jsp";
	}

}
