package cn.edu.gduf.netserver.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ISurveySystemQueryQusnDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemQueryQusnDaoImpl;
import cn.edu.gduf.netserver.domain.QusnnList;

/**
 * 【设计调查问卷】 分页显示类
 * @author Wmj
 */
public class PageQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//得到问卷列表
		ISurveySystemQueryQusnDao queryImpl=new SurveySystemQueryQusnDaoImpl();
		//需从session获取用户ID
		int userID=(Integer)request.getSession().getAttribute("id");
		//得到当前页
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		//往session保存当前页
		request.getSession().setAttribute("currentPage", currentPage);
		
		ArrayList<QusnnList> qusnnLists=queryImpl.queryQusnn(userID,currentPage);
		//把数据从servlet传到视图页面
		request.setAttribute("qusnnLists", qusnnLists);
		//返回转发页面
		return "../jsp/surveySystemIndex.jsp";
	}

}
