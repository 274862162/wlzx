package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ISurveySystemUpdateQusnDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemUpdateQusnDaoImpl;

public class UpdateQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int qusnID=Integer.parseInt(request.getParameter("qusnID"));
		String status=request.getParameter("status");
		ISurveySystemUpdateQusnDao surveyImpl=new SurveySystemUpdateQusnDaoImpl();
		surveyImpl.updateStatus(qusnID, status);
		//System.out.println("状态是"+status+",问卷主键是："+qusnID);
		return "../SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire";
	}

}
