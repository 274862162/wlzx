package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Question;

/**
 * 问题数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IQuestionDao {

	/**
	 * 向题库添加问题
	 * @param question
	 * @return
	 * @throws SQLException 
	 */
	public int addQuestion(Question question) throws SQLException;
	
	/**
	 * 向题库批量添加问题
	 * @param questions
	 * @return
	 * @throws SQLException
	 */
	public int addQuestion(List<Question> questions) throws SQLException;
	
	/**
	 * 更新问题
	 * @param question
	 * @return
	 */
	public int updateQuestion(Question question);
	
	/**
	 * 根据id更新问题
	 * @param id
	 * @return
	 */
	public int updateQuestionById(int id);
	
	/**
	 * 根据id删除问题
	 * @param id
	 * @return
	 */
	public int deleteQuestionById(int id);
	
	/**
	 * 获取所有问题
	 * @return
	 */
	public List<Question> getAllQuestions();
	
	/**
	 * 根据问题条件得到问题集
	 * @param Question
	 * @return
	 */
	public List<Question> getQuestions(Question question);
	
	/**
	 * 根据分页条件得到问题集
	 * @param pageBean
	 * @return
	 */
	public List<Question> getQuestions(PageBean pageBean);
	
	/**
	 * 根据问题条件和分页条件得到问题集
	 * @param question
	 * @param pageBean
	 * @return
	 */
	public List<Question> getQuestions(Question question, PageBean pageBean);
	
	/**
	 * 根据问题类型得到问题集
	 * @param questionType
	 * @return
	 */
	public List<Question> getQuestions(int questionType);
	
	/**
	 * 根据id得到问题
	 * @param id
	 * @return
	 */
	public Question getQuestionById(int id);
	
	/**
	 * 根据问题类型获得问题分值（仅限单选、多选、判断）
	 * @param type
	 * @return
	 * @throws SQLException 
	 */
	public int getPointByQuestionType(int type) throws SQLException;
	
	/**
	 * 获得问题总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据问题条件得到问题总数
	 * @param testPaper
	 * @return
	 */
	public int count(Question question);
	
	/**
	 * 根据问题题目得到id
	 * @param title
	 * @return
	 */
	public int getIdByQuestionTitle(String title);
}
