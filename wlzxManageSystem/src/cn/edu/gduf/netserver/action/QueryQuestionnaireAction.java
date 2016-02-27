package cn.edu.gduf.netserver.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ISurveySystemQueryQusnDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemQueryQusnDaoImpl;
import cn.edu.gduf.netserver.domain.QusnnList;

public class QueryQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//得到问卷列表
		ISurveySystemQueryQusnDao queryImpl=new SurveySystemQueryQusnDaoImpl();
		//需从session获取用户ID
		int userID=0;
		if(request.getSession().getAttribute("id")!=null){
			userID=(Integer)request.getSession().getAttribute("id");
		}
		if(userID!=0){
			//往session保存当前页
			request.getSession().setAttribute("currentPage", 1);
			//往session中存放结果集条数
			request.getSession().setAttribute("allPage", queryImpl.allPage(userID));
			
			ArrayList<QusnnList> qusnnLists=queryImpl.queryQusnn(userID,1);
			//把数据从servlet传到视图页面
			request.setAttribute("qusnnLists", qusnnLists);
			return "../jsp/surveySystemIndex.jsp";
		}else{
			return "../jsp/login.jsp";
		}
	}

}
