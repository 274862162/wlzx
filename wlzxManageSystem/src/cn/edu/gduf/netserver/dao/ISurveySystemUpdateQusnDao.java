package cn.edu.gduf.netserver.dao;

public interface ISurveySystemUpdateQusnDao {
	/**更改问卷发布状态
	 * @param qusnID 问卷ID
	 * @param status 问卷发布状态
	 */
	public void updateStatus(int qusnID,String status);
	
}
