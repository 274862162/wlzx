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
		int userID=(Integer)request.getSession().getAttribute("id");
		//往session保存当前页
		request.getSession().setAttribute("currentPage", 1);
		//往session中存放结果集条数
		request.getSession().setAttribute("allPage", queryImpl.allPage(userID));
		
		ArrayList<QusnnList> qusnnLists=queryImpl.queryQusnn(userID,1);
		//把数据从servlet传到视图页面
		request.setAttribute("qusnnLists", qusnnLists);
		//控制台输出数据
		/*
		for(int i=0;i<qusnnLists.size();i++){
			System.out.println(qusnnLists.get(i).getQusnnID()+" "+qusnnLists.get(i).getQuesnnTitle()
					+" "+qusnnLists.get(i).getQusnnStatus()+" "+qusnnLists.get(i).getQuesnnTime()
					+" "+qusnnLists.get(i).getReceiveData());
		}
		*/
		//返回转发页面
		return "../jsp/surveySystemIndex.jsp";
	}

}
