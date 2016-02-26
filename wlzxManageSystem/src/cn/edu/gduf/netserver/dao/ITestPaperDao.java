package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * 试卷数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface ITestPaperDao {

	/**
	 * 添加试卷
	 * @param testPaper
	 * @return
	 */
	public int addTestPaper(TestPaper testPaper);
	
	/**
	 * 根据试卷名添加试卷
	 * @param paperName
	 * @return
	 * @throws SQLException 
	 */
	public int addTestPaper(String paperName) throws SQLException;
	
	/**
	 * 更新试卷
	 * @param testPaper
	 * @return
	 */
	public int updateTestPaper(TestPaper testPaper);
	
	/**
	 * 根据id更新试卷
	 * @param id
	 * @return
	 */
	public int updateTestPaperById(int id);
	
	/**
	 * 根据id删除试卷
	 * @param id
	 * @return
	 */
	public int deleteTestPaperById(int id);
	
	/**
	 * 获取所有试卷
	 * @return
	 */
	public List<TestPaper> getAllTestPapers();
	
	/**
	 * 根据试卷条件得到试卷集
	 * @param TestPaper
	 * @return
	 */
	public List<TestPaper> getTestPapers(TestPaper testPaper);
	
	/**
	 * 根据分页条件得到试卷集
	 * @param TestPaper
	 * @return
	 */
	public List<TestPaper> getTestPapers(PageBean pageBean);
	
	/**
	 * 根据试卷条件和分页条件得到试卷集
	 * @param testPaper
	 * @param pageBean
	 * @return
	 */
	public List<TestPaper> getTestPapers(TestPaper testPaper, PageBean pageBean);
	
	/**
	 * 根据id得到试卷 
	 * @param id
	 * @return
	 */
	public TestPaper getTestPaperById(int id);
	
	/**
	 * 获得试卷总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据试卷条件得到试卷总数
	 * @param testPaper
	 * @return
	 */
	public int count(TestPaper testPaper);
	
	/**
	 * 根据试卷添加试卷与问题间的关联 
	 * @param testPaper
	 * @return
	 * @throws SQLException
	 */
	public int addChoice(TestPaper testPaper) throws SQLException;
	
	/**
	 * 根据试卷名称获得id 
	 * @param name
	 * @return
	 */
	public int getIdByTestPaperName(String name);
	
	/**
	 * 根据用户ID和试卷ID判断是否已进行过考核
	 * @param userId
	 * @param paperId
	 * @return
	 */
	public int isExamined(int userId, int paperId);
}
