package cn.edu.gduf.netserver.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ISurveySystemQueryQusnDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemQueryQusnDaoImpl;
import cn.edu.gduf.netserver.domain.QusnnList;

/**
 * 收集中的问卷分页查询类
 * @author Ginger
 *
 */
public class FillQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//从session中获取用户ID
		int userID=(Integer) request.getSession().getAttribute("id");
		//得到问卷列表
		ISurveySystemQueryQusnDao queryImpl=new SurveySystemQueryQusnDaoImpl();
		//往session保存当前页
		request.getSession().setAttribute("currentPage", 1);
		//往session中存放结果集条数
		request.getSession().setAttribute("allPage", queryImpl.allCollectQusnPage());		
		ArrayList<QusnnList> qusnnLists=queryImpl.queryCollectQusnn(1,userID);
		//把数据从servlet传到视图页面
		request.setAttribute("qusnnLists", qusnnLists);
		//控制台输出数据
		for(int i=0;i<qusnnLists.size();i++){
			System.out.println(qusnnLists.get(i).getQusnnID()+" "+qusnnLists.get(i).getQuesnnTitle()
					+" "+qusnnLists.get(i).getQusnnStatus()+" "+qusnnLists.get(i).getQuesnnTime()
					+" "+qusnnLists.get(i).getReceiveData());
		}
		//返回转发页面
		return "../jsp/fillSurveyList.jsp";
	}

}
