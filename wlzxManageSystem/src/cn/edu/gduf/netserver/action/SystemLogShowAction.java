package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.SystemLogListDao;
import cn.edu.gduf.netserver.domain.Log;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class SystemLogShowAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SystemLogListDao systemLogListDao = new SystemLogListDao();
		//得到数据，进行乱码处理
		String type = request.getParameter("logType");
		if(type == "" || type == null){
			type=null;
		}
		String operator = request.getParameter("operator");
		if(operator == "" || operator == null){
			operator = null;
		}
		//得到开始时间
		String date1 = request.getParameter("startTime");
		if(date1 == "" || date1 == null){
			date1 = null;
		}
		Date startTime = null;
		if(date1!=null){
			startTime = Date.valueOf(date1);
		}
		//得到结束时间
		String date2 =request.getParameter("endTime");
		if(date2 == "" || date2 == null){
			date2 = null;
		} 
		Date endTime = null;
		if(date2!=null){
			endTime = Date.valueOf(date2);
		}
		String content = request.getParameter("logContent");	//得到日志内容
		if(content == "" || content == null){
			content = null;
		}
		String currentPage = request.getParameter("page");  // 显示的那一页(当前页)
		String displayRecord = request.getParameter("displayRecord");//每页显示多少条
		if (StringUtil.isEmpty(currentPage)) {
			currentPage = "1";  // 默认第一页
		}
		if(StringUtil.isEmpty(displayRecord)) {
			displayRecord = PropertiesUtil.getValue("pageSize");  // 默认第一页
		}
		int totalNum = systemLogListDao.count(type,operator,startTime,endTime,content);  // 文件总数
		int pageSize = Integer.parseInt(displayRecord);
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;  // 总页数
		PageBean pageBean = new PageBean(Integer.parseInt(currentPage), pageSize);
		List<Log> systemLogList = systemLogListDao.getList(pageBean,type,operator,startTime,endTime,content);
		Result result = new Result();
		result.setList(systemLogList);
		result.setPage(Integer.parseInt(currentPage));
		result.setTotalPage(totalPage);
		JSONArray json = JSONArray.fromObject(result);
		return json.toString();
	}
}
