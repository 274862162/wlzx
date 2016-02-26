package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.gduf.netserver.dao.DownloadSectionDao;
import cn.edu.gduf.netserver.dao.ImagesDao;
import cn.edu.gduf.netserver.dao.WebNoticeDao;
import cn.edu.gduf.netserver.domain.DownloadSection;
import cn.edu.gduf.netserver.domain.Images;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.domain.WebNotice;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class GetDownloadSectionAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int downloadSectionFileID = 0;
		if(request.getParameter("downloadSectionFileID")!=null){
			downloadSectionFileID = Integer.parseInt(request.getParameter("downloadSectionFileID"));
		}
		DownloadSectionDao downloadSectionDao =new DownloadSectionDao();
		DownloadSection downloadSection = null;
		downloadSection = downloadSectionDao.getDownloadSectionById(downloadSectionFileID);//查询当前下载专区文件
		JSONObject json = JSONObject.fromObject(downloadSection);
		return json.toString();
	}
}
