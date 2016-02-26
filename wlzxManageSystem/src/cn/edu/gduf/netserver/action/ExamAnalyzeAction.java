package cn.edu.gduf.netserver.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.impl.ExamineDaoImpl;

public class ExamAnalyzeAction implements Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IExamineDao examineDao = new ExamineDaoImpl();
		String paperID = request.getParameter("paperID");
		String paperName = request.getParameter("paperName");
		try {
			paperName = new String(paperName.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		float avgScore = examineDao.examScoreAVG(Integer.parseInt(paperID));  // 平均分
		int maxScore = examineDao.examScoreMAX(Integer.parseInt(paperID));  // 最高分
		int examCount = examineDao.userCount(Integer.parseInt(paperID));  // 考核学生人数
		int passExamCount = examineDao.scoreUserCount(Integer.parseInt(paperID), 60, 100);  // 考核及格人数
		int countOf10T9 = examineDao.scoreUserCount(Integer.parseInt(paperID), 90, 100);  // 90-100分人数
		int countOf9T8 = examineDao.scoreUserCount(Integer.parseInt(paperID), 80, 89);  // 80-89分人数
		int countOf8T7 = examineDao.scoreUserCount(Integer.parseInt(paperID), 70, 79);  // 70-79分人数
		int countOf7T6 = examineDao.scoreUserCount(Integer.parseInt(paperID), 60, 69);  // 60-69分人数
		int countOf6T5 = examineDao.scoreUserCount(Integer.parseInt(paperID), 50, 59);  // 50-59分人数
		int countOf5T4 = examineDao.scoreUserCount(Integer.parseInt(paperID), 40, 49);  // 40-49分人数
		
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
		request.setAttribute("paperName", paperName);
		request.setAttribute("avgScore", avgScore);
		request.setAttribute("maxScore", maxScore);
		request.setAttribute("examCount", examCount);
		request.setAttribute("passExamCount", passExamCount);
		
		return "examAnalyze";
	}
}
