package cn.edu.gduf.netserver.dao;

import java.util.ArrayList;

import cn.edu.gduf.netserver.domain.QusnnList;

/**问卷调查系统数据库查询操作
 * @author Wmj
 *
 */
public interface ISurveySystemQueryQusnDao {
	/**根据用户ID查询用户自身设计的问卷,不分页
	 * @param userID 用户ID
	 * @return 问卷集合
	 */
	public ArrayList<QusnnList> queryQusnn(int userID);
	/**分页查询所有收集中的问卷供用户填写
	 * @return 问卷集合
	 */
	public ArrayList<QusnnList> queryCollectQusnn(int currentPage,int userID);
	/**
	 * 根据问卷ID和用户ID查询用户是否填写了该问卷
	 * @param qusnID 问卷ID
	 * @param userID 用户ID
	 * @return 是否已填写
	 */
	public boolean queryFillStatus(int qusnID,int userID);
	/**根据问卷ID查询被填写次数
	 * @param qusnnID 问卷ID
	 * @return 填写次数
	 */
	public int collectData(int qusnnID);
	/**
	 * 分页显示
	 * @param userID 用户ID
	 * @param currentPage 当前显示页数
	 * @return 查询结果集
	 */
	public ArrayList<QusnnList> queryQusnn(int userID,int currentPage);
	/**
	 * 根据用户ID查询结果集条数
	 * @param userID 用户ID
	 * @return 结果集条数除以显示条数返回总页数
	 */
	public int allPage(int userID);
	/**
	 * @return 返回查询正在收集的问卷的总页数
	 */
	public int allCollectQusnPage();
	/**
	 * 根据用户ID返回用户名
	 * @param userID 用户ID
	 * @return 用户名
	 */
	public String idToName(int userID);
}
