package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.edu.gduf.netserver.dao.ImagesDao;
import cn.edu.gduf.netserver.domain.Images;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.util.PageUtil;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class ImagesShowAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ImagesDao imagesDao = new ImagesDao();
		String currentPage = request.getParameter("page");  // 显示的那一页(当前页)
		String displayRecord = request.getParameter("displayRecord");
		if (StringUtil.isEmpty(currentPage)) {
			currentPage = "1";  // 默认第一页
		}
		if(StringUtil.isEmpty(displayRecord)) {
			displayRecord = PropertiesUtil.getValue("pageSize");  // 默认第一页
		}
		int totalNum = imagesDao.count();  // 总数
		int pageSize = Integer.parseInt(displayRecord);
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;  // 总页数
		PageBean pageBean = new PageBean(Integer.parseInt(currentPage), pageSize);
		List<Images> imagesList = imagesDao.getImages(pageBean);
		Result result = new Result();
		result.setList(imagesList);
		result.setPage(Integer.parseInt(currentPage));
		result.setTotalPage(totalPage);
		JSONArray json = JSONArray.fromObject(result);
		return json.toString();
	}
}
