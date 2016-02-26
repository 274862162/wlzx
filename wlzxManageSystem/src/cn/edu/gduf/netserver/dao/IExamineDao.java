package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.Examine;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.TestPaper;

/**
 * 考核数据访问接口
 * @author hsg
 * 2015/01/22
 */
public interface IExamineDao {

	/**
	 * 保存考核记录
	 * @param examine
	 * @return
	 * @throws SQLException 
	 */
	public int addExamine(Examine examine) throws SQLException;
	
	/**
	 * 更新考核记录
	 * @param examine
	 * @return
	 * @throws SQLException 
	 */
	public int updateExamine(Examine examine) throws SQLException;
	
	/**
	 * 根据id更新考核记录
	 * @param id
	 * @return
	 */
	public int updateExamineById(int id);
	
	/**
	 * 根据id删除考核记录
	 * @param id
	 * @return
	 */
	public int deleteExamineById(int id);
	
	/**
	 * 获得所有考核记录
	 * @return
	 */
	public List<Examine> getAllExamines();
	
	/**
	 * 根据考核记录条件和试卷id得到考核记录集
	 * @param examine
	 * @return
	 */
	public List<Examine> getExamines(Examine examine);
	
	/**
	 * 根据分页条件和试卷id得到考核记录集
	 * @param pageBean
	 * @param id
	 * @return
	 */
	public List<Examine> getExamines(PageBean pageBean, int id);
	
	/**
	 * 根据考核记录条件和分页条件得到考核记录集
	 * @param examine
	 * @param pageBean
	 * @return
	 */
	public List<Examine> getExamines(Examine examine, PageBean pageBean);
	
	/**
	 * 根据考核记录Id获得考核记录
	 * @param id
	 * @return
	 */
	public Examine getExamineById(int id);
	
	/**
	 * 根据试卷id获得考核学生记录总数
	 * @return
	 */
	public int userCount(int paperId);
	
	/**
	 * 获得考核试卷记录总数
	 * @return
	 */
	public int paperCount();
	
	/**
	 * 根据考核记录条件获得考核记录总数
	 * @param examine
	 * @return
	 */
	public int count(Examine examine);
	
	/**
	 * 根据分页条件得到考核试卷集
	 * @param pageBean
	 * @return
	 */
	public List<TestPaper> getExaminePapers(PageBean pageBean);
	
	/**
	 * 获得当前保存的考核记录的Id
	 * @return
	 * @throws SQLException 
	 */
	public int getMaxExamineId() throws SQLException;
	
	/**
	 * 保存考核的客观题分数
	 * @return
	 * @throws SQLException 
	 */
	public int savePartScore(int id, int score1, int score2, int score3) throws SQLException;

	/**
	 * 根据用户ID和试卷ID判断是否已进行过考核
	 * @param userId
	 * @param paperId
	 * @return
	 */
	public int isExamined(int userId, int paperId);
	
	/**
	 * 根据试卷ID获得该试卷考核的平均分
	 * @param paperId
	 * @return
	 */
	public float examScoreAVG(int paperId);
	
	/**
	 * 根据试卷ID获得该试卷考核的最高分
	 * @param paperId
	 * @return
	 */
	public int examScoreMAX(int paperId);
	
	
	/**
	 * 获得某一试卷指定分数区间的人数
	 * @return
	 */
	public int scoreUserCount(int paperId, int sScore, int bScore);
}
