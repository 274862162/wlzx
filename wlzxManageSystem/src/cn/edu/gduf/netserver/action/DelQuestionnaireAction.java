package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.impl.SurveySystemDelQusnDaoImpl;

/**
 * @author Ginger
 *
 */
public class DelQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int qusnID=Integer.parseInt(request.getParameter("id"));
		//System.out.println("问卷主键是"+qusnID);
		SurveySystemDelQusnDaoImpl surveyImpl=new SurveySystemDelQusnDaoImpl();
		surveyImpl.delInves(qusnID);
		//System.out.println("delInves");
		
		surveyImpl.delUserSlecSection(qusnID);
		//System.out.println("delUserSlecSection");
		
		surveyImpl.delCreQusn(qusnID);
		//System.out.println("delCreQusn");
		
		surveyImpl.delQusnQuestion(qusnID);
		//System.out.println("delQusnQuestion");
		
		surveyImpl.delQusn(qusnID);
		//System.out.println("delQusn");
		return "../SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire";
	}

}
