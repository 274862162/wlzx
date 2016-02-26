package cn.edu.gduf.netserver.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.ISurveySystemSaveQusnDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemSaveQusnDaoImpl;
import cn.edu.gduf.netserver.domain.QusnnQuestion;
import cn.edu.gduf.netserver.domain.Questionnaire;

/**获取请求信息并转发
 * @author Wmj
 *
 */
public class CreateQusesionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		ISurveySystemSaveQusnDao surveySysImpl=new SurveySystemSaveQusnDaoImpl();
		String postStatus=request.getParameter("create");
		System.out.println(postStatus);
		//预览后的提交
		if(postStatus.equals("取消")){
			return "../SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire";
		}
		if(postStatus.equals("提交")){
			//从session获取数据
			Questionnaire qusn=(Questionnaire) request.getSession().getAttribute("qusn");
			ArrayList<QusnnQuestion> quess=(ArrayList<QusnnQuestion>) request.getSession().getAttribute("quess");
			//保存问卷
			int qusnKey=surveySysImpl.saveQusnnMessage(qusn);
			//保存问题
			ArrayList<Integer> quesKey=surveySysImpl.saveQuestion(quess,qusnKey);
			//保存两表主键
			surveySysImpl.saveCreateQusn(qusnKey, quesKey);
		}
		//创建问卷时预览问卷
		if(postStatus.equals("预览试卷")){
			System.out.println("--Servlet doPost new Impl--");
			Questionnaire qusn=new Questionnaire();
			ArrayList<QusnnQuestion> quess=new ArrayList<QusnnQuestion>();
			//获取问卷标题
			qusn.setQuesnnTitle(request.getParameter("paperTitle"));
			//从session获取登陆账户
			qusn.setUserID((Integer) request.getSession().getAttribute("id"));
			//获取时间
			qusn.setQuesnnTime(request.getParameter("client-time"));
			//设置状态默认为UNPUBLISHED
			qusn.setQusnnStatus("UNPUBLISHED");
			//获得单选题
			String[] sQuesTitle=request.getParameterValues("single-text-title");
			String[] sSectionA=request.getParameterValues("single-first");
			String[] sSectionB=request.getParameterValues("single-second");
			String[] sSectionC=request.getParameterValues("single-third");
			String[] sSectionD=request.getParameterValues("single-forth");
			String[] sSectionE=request.getParameterValues("single-fiveth");
			//获得多选题
			String[] mQuesTitle=request.getParameterValues("multiple-text-title");
			String[] mSectionA=request.getParameterValues("multiple-first");
			String[] mSectionB=request.getParameterValues("multiple-second");
			String[] mSectionC=request.getParameterValues("multiple-third");
			String[] mSectionD=request.getParameterValues("multiple-forth");
			String[] mSectionE=request.getParameterValues("multiple-fiveth");
			//保留“其他”选项，先不做
			//String[] sectionOther=request.getParameterValues("single-other");
			//获取单选题问题
			for(int i=1;i<sQuesTitle.length;i++){
				QusnnQuestion ques=new QusnnQuestion();
				ques.setQuestionTitle(sQuesTitle[i]);
				ques.setSectionA(sSectionA[i]);
				ques.setSectionB(sSectionB[i]);
				ques.setSectionC(sSectionC[i]);
				ques.setSectionD(sSectionD[i]);
				ques.setSectionE(sSectionE[i]);	
				ques.setQuestionType("SINGLE");
				quess.add(ques);
			}
			for(int i=1;i<mQuesTitle.length;i++){
				QusnnQuestion ques=new QusnnQuestion();
				ques.setQuestionTitle(mQuesTitle[i]);
				ques.setSectionA(mSectionA[i]);
				ques.setSectionB(mSectionB[i]);
				ques.setSectionC(mSectionC[i]);
				ques.setSectionD(mSectionD[i]);
				ques.setSectionE(mSectionE[i]);	
				ques.setQuestionType("MULTIPLE");
				quess.add(ques);
			}
			//先往session存储数据
			request.getSession().setAttribute("qusn", qusn);
			request.getSession().setAttribute("quess", quess);
			return "../jsp/previewSurvey.jsp";
		}
		//直接创建问卷
		if(postStatus.equals("创建")){
			System.out.println("--Servlet doPost new Impl--");
			Questionnaire qusn=new Questionnaire();
			ArrayList<QusnnQuestion> quess=new ArrayList<QusnnQuestion>();
			//获取问卷标题
			qusn.setQuesnnTitle(request.getParameter("paperTitle"));
			//从session获取登陆账户
			qusn.setUserID((Integer) request.getSession().getAttribute("id"));
			//获取时间
			qusn.setQuesnnTime(request.getParameter("client-time"));
			//设置状态默认为UNPUBLISHED
			qusn.setQusnnStatus("UNPUBLISHED");
			//获得单选题
			String[] sQuesTitle=request.getParameterValues("single-text-title");
			String[] sSectionA=request.getParameterValues("single-first");
			String[] sSectionB=request.getParameterValues("single-second");
			String[] sSectionC=request.getParameterValues("single-third");
			String[] sSectionD=request.getParameterValues("single-forth");
			String[] sSectionE=request.getParameterValues("single-fiveth");
			//获得多选题
			String[] mQuesTitle=request.getParameterValues("multiple-text-title");
			String[] mSectionA=request.getParameterValues("multiple-first");
			String[] mSectionB=request.getParameterValues("multiple-second");
			String[] mSectionC=request.getParameterValues("multiple-third");
			String[] mSectionD=request.getParameterValues("multiple-forth");
			String[] mSectionE=request.getParameterValues("multiple-fiveth");
			//保留“其他”选项，先不做
			//String[] sectionOther=request.getParameterValues("single-other");
			//获得单选题问题
			for(int i=1;i<sQuesTitle.length;i++){
				QusnnQuestion ques=new QusnnQuestion();
				ques.setQuestionTitle(sQuesTitle[i]);
				ques.setSectionA(sSectionA[i]);
				ques.setSectionB(sSectionB[i]);
				ques.setSectionC(sSectionC[i]);
				ques.setSectionD(sSectionD[i]);
				ques.setSectionE(sSectionE[i]);	
				ques.setQuestionType("SINGLE");
				quess.add(ques);
			}
			for(int i=1;i<mQuesTitle.length;i++){
				QusnnQuestion ques=new QusnnQuestion();
				ques.setQuestionTitle(mQuesTitle[i]);
				ques.setSectionA(mSectionA[i]);
				ques.setSectionB(mSectionB[i]);
				ques.setSectionC(mSectionC[i]);
				ques.setSectionD(mSectionD[i]);
				ques.setSectionE(mSectionE[i]);	
				ques.setQuestionType("MULTIPLE");
				quess.add(ques);
			}
			System.out.println("--保存前--");
			//保存问卷
			int qusnKey=surveySysImpl.saveQusnnMessage(qusn);
			//保存问题
			ArrayList<Integer> quesKey=surveySysImpl.saveQuestion(quess,qusnKey);
			//保存两表主键
			surveySysImpl.saveCreateQusn(qusnKey, quesKey);
			System.out.println("--保存后--");
			return "../SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire";
		}
		return "../SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire";
	}
}
