package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import cn.edu.gduf.netserver.dao.ISurveySystemAlyQusnDao;
import cn.edu.gduf.netserver.dao.ISurveySystemDisplayQusnDao;
import cn.edu.gduf.netserver.dao.impl.SurveySystemAlyQusnDaoImpl;
import cn.edu.gduf.netserver.dao.impl.SurveySystemDisplayQusnDaoImpl;
import cn.edu.gduf.netserver.domain.Findings;
import cn.edu.gduf.netserver.domain.QusnnList;
import cn.edu.gduf.netserver.domain.QusnnQuestion;

public class AlyQuestionnaireAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		int qusnID=Integer.parseInt(request.getParameter("id"));
		//System.out.println("问卷ID"+qusnID);
		ISurveySystemAlyQusnDao surveyImpl=new SurveySystemAlyQusnDaoImpl();
		//查询问卷信息
		QusnnList qusnList=surveyImpl.queryQusn(qusnID);
		//查询问题选择结果
		ArrayList<Findings> quesFindings=surveyImpl.queryQuesFindings(qusnID);
		//根据问卷ID查询问题集
		ISurveySystemDisplayQusnDao queryQuesImpl=new SurveySystemDisplayQusnDaoImpl();
		ArrayList<QusnnQuestion> quesList=queryQuesImpl.queryQues(qusnID);		

		/*检验填写结果
		for(int i=0;i<quesFindings.size();i++){
			System.out.println("题目ID"+quesFindings.get(i).getQuesID());
			System.out.println("题目"+quesFindings.get(i).getQuesTitle());
			System.out.println("选项A人数"+quesFindings.get(i).getSelectNumA());
			System.out.println("选项A人名"+quesFindings.get(i).getSelectNameA());
		}
		*/
		request.setAttribute("quesList", quesList);
		request.setAttribute("qusnList", qusnList);
		request.setAttribute("quesFindings", quesFindings);
		/*
		//15/03/15增加JfreeChar图表
		int countOf10T9 = 5;  // 90-100分人数
		int countOf9T8 = 4;  // 80-89分人数
		int countOf8T7 = 6;  // 70-79分人数
		int countOf7T6 = 7;  // 60-69分人数
		int countOf6T5 = 5;  // 50-59分人数
		int countOf5T4 = 3;  // 40-49分人数
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(countOf10T9, "人数", "100-90");
		dataset.addValue(countOf9T8, "人数", "89-80");
		dataset.addValue(countOf8T7, "人数", "79-70");
		dataset.addValue(countOf7T6, "人数", "69-60");
		dataset.addValue(countOf6T5, "人数", "59-50");
		dataset.addValue(countOf5T4, "人数", "49-40");
		// 工厂生产图表,"分数区间"：目录轴的显示标签   ； "人数"：数值轴的显示标签
		JFreeChart chart = ChartFactory.createBarChart("考核成绩分布图", "分数区间", "人数", dataset, PlotOrientation.VERTICAL, true, true, true);
		//BarRenderer brd = (BarRenderer) chart.getCategoryPlot().getRenderer();
		//brd.setSeriesPaint(0, Color.decode("#00E000"));
		
		// 保存为png格式
		String fileName = null;
		try {
			fileName = ServletUtilities.saveChartAsPNG(chart, 598, 297, null, request.getSession() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		String graphURLbar = request.getContextPath() + "/DisplayChart?filename=" + fileName;  
		request.setAttribute("graphURLbar", graphURLbar);
		*/		
		return "../jsp/analysisSurvey.jsp";
	}

}
