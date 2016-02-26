package cn.edu.gduf.netserver.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ISurveySystemSaveUserActionDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemDisplayQusnDaoImpl;
import cn.edu.gduf.netserver.dao.impl.SurveySystemSaveUserActionDaoImpl;
import cn.edu.gduf.netserver.domain.Questionnaire;
import cn.edu.gduf.netserver.domain.QusnnQuestion;

/**查询数据库显示问卷内容
 * @author Wmj
 *
 */
public class DisplayQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String status=request.getParameter("status");
		if(status.equals("fill")){
			int qusnID=Integer.parseInt(request.getParameter("id"));
			SurveySystemDisplayQusnDaoImpl surveySysImpl=new SurveySystemDisplayQusnDaoImpl();
			Questionnaire qusn=surveySysImpl.queryQusn(qusnID);
			ArrayList<QusnnQuestion> quess=surveySysImpl.queryQues(qusnID);
			request.getSession().setAttribute("qusn", qusn);
			request.getSession().setAttribute("quess", quess);
			return "../jsp/displaySurvey.jsp";
		}
		else if(status.equals("提交")){
			//从Session获得用户ID
			int userID=(Integer)request.getSession().getAttribute("id");
			//获取用户填写时间
			String clientTime=request.getParameter("client-time");
			//获取问卷ID
			Questionnaire qusn=(Questionnaire) request.getSession().getAttribute("qusn");
			//获取问题集
			ArrayList<QusnnQuestion> quess=(ArrayList<QusnnQuestion>) request.getSession().getAttribute("quess");
			//获得问题数量
			int quesLength=quess.size();
			//results保存用户选择问题的结果
			HashMap<Integer, String> results=new HashMap<Integer, String>();
			for(int i=0;i<quesLength;i++){
				if(quess.get(i).getQuestionType().equals("SINGLE")){ //如果是单选题
					String[] result=request.getParameterValues("result"+i);
					if(result!=null){ //选择问题选项必须不为空
						results.put(quess.get(i).getID(), result[0]);
					}
					else{   //如果为空则跳转到问卷内容显示页面
						return "../SurveySystem/SurveySystemQusnServlet?action=displayQuestionnaire&id="+qusn.getID()+"&status=fill";
					}
				}
				if(quess.get(i).getQuestionType().equals("MULTIPLE")){ //如果是单选题
					String[] result=request.getParameterValues("result"+i);
					if(result!=null){//选择问题选项必须不为空
						String formatResult="";
						for(int j=0;j<result.length;j++){
							formatResult=formatResult+result[j];
						}
						results.put(quess.get(i).getID(), formatResult);
					}
					else{
						return "../SurveySystem/SurveySystemQusnServlet?action=displayQuestionnaire&id="+qusn.getID()+"&status=fill";
					}
				}
			}
			/*
			for(int i=0;i<results.size();i++){
				String key=results.get(quess.get(i).getID());
				System.out.println("选取的结果为："+key);
			}
			*/
			ISurveySystemSaveUserActionDao surveySysImpl=new SurveySystemSaveUserActionDaoImpl();
			surveySysImpl.saveUserSelect(userID, results);
			surveySysImpl.saveUserTime(qusn.getID(), userID, clientTime);
			return "../SurveySystem/SurveySystemQusnServlet?action=fillQuestionnaire";		
		}
		else if(status.equals("取消")){
			
			return "../SurveySystem/SurveySystemQusnServlet?action=fillQuestionnaire";
		}
		return "../SurveySystem/SurveySystemQusnServlet?action=fillQuestionnaire";
	}

}
