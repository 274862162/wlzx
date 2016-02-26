package cn.edu.gduf.netserver.dao;

import java.util.ArrayList;

import cn.edu.gduf.netserver.domain.QusnnQuestion;
import cn.edu.gduf.netserver.domain.Questionnaire;
/**
 * 问卷调查保存到数据库操作类接口
 * @author Wmj
 *
 */
public interface ISurveySystemSaveQusnDao {
	/**
	 * 保存问卷类
	 * @param qusn
	 * 问卷类
	 * @return
	 * 返回问卷主键
	 */
	public int saveQusnnMessage(Questionnaire qusn);
	/**
	 * 保存问卷问题
	 * @param ques 问题数组类 
	 * @param quesID 所属问卷ID
	 * @return
	 * 返回问题主键数组
	 */
	public ArrayList<Integer> saveQuestion(ArrayList<QusnnQuestion> ques,int qusnID);
	/**
	 * 保存create_questionnaire表
	 * @param qusnKey
	 * 问卷主键
	 * @param quesKey
	 * 问题主键数组
	 */
	public void saveCreateQusn(int qusnKey,ArrayList<Integer> quesKey);
	
}
