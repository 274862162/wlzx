package cn.edu.gduf.netserver.dao;

import java.util.HashMap;

/**
 * 数据库操作，存储用户行为（选择选项，提交时间）
 * @author Ginger
 *
 */
public interface ISurveySystemSaveUserActionDao {
	/**
	 * 存储user_selc_quesnn数据表
	 * @param userID 用户ID	
	 * @param results 问题选择的结果集
	 */
	public void saveUserSelect(int userID,HashMap<Integer, String> results);
	/**
	 * 存储investigate数据表
	 * @param qusnID 问卷ID
	 * @param userID 用户ID
	 * @param clientTime 用户填写问卷的时间
	 */
	public void saveUserTime(int qusnID,int userID,String clientTime);
}
