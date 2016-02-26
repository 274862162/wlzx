package cn.edu.gduf.netserver.dao;

/**
 * 删除问卷的所有数据的数据库操作
 * @author Wmj
 *
 */
public interface ISurveySystemDelQusnDao {
	/**
	 * 删除questionnaire数据表
	 * @param qusnID 问卷ID
	 */
	public void delQusn(int qusnID);
	/**
	 * 删除qusnn_question数据表
	 * @param qusnID 问卷ID
	 */
	public void delQusnQuestion(int qusnID);
	/**
	 * 删除create_questionnaire数据表
	 * @param qusnID
	 */
	public void delCreQusn(int qusnID);
	/**
	 * 删除user_selc_section数据表
	 * @param qusnID
	 */
	public void delUserSlecSection(int qusnID);
	/**
	 * 删除investigate数据表
	 * @param qusnID
	 */
	public void delInves(int qusnID);
}
