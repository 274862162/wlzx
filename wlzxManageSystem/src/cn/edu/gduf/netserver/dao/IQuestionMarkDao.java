package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.edu.gduf.netserver.domain.QuestionMark;

/**
 * 问题评分数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IQuestionMarkDao {

	/**
	 * 添加用户学生答案和问题评分
	 * @param questionMark
	 * @return
	 * @throws SQLException 
	 */
	public int addQuestionMark(QuestionMark questionMark) throws SQLException;
	
	/**
	 * 根据考核id获得学生问题及评分
	 * @param id
	 * @return
	 */
	public Set<QuestionMark> getQuestionMarksByExamineId(int id);
	
	/**
	 * 根据id更新考核问题的评分
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int updateQuestionMarkById(int id, int mark) throws SQLException;
}
