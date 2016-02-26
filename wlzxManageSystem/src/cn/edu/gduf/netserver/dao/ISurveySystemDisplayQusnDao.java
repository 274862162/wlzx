package cn.edu.gduf.netserver.dao;

import java.util.ArrayList;

import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.Questionnaire;
import cn.edu.gduf.netserver.domain.QusnnQuestion;

/**
 * 显示问卷内容接口
 * @author Ginger
 *
 */
public interface ISurveySystemDisplayQusnDao {
	/**
	 * 查询问卷内容
	 * @param ID 问卷ID
	 * @return 问卷类
	 */
	public Questionnaire queryQusn(int ID);
	
	/**
	 * 根据问卷ID查询问题集
	 * @param ID 问卷ID
	 * @return 问题集
	 */
	public ArrayList<QusnnQuestion> queryQues(int ID);
	
}
