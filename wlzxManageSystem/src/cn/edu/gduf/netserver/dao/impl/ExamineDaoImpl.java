package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.dao.IExamineDao;
import cn.edu.gduf.netserver.dao.IQuestionDao;
import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.domain.Examine;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.QuestionMark;
import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

/**
 * 考核数据访问实现类
 * @author hsg
 * 2015/01/22
 */
public class ExamineDaoImpl implements IExamineDao{

	/**
	 * 保存考核记录
	 * @param examine
	 * @throws SQLException 
	 */
	public int addExamine(Examine examine) throws SQLException{
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO examine(Id, userID, paperID, testTime, score, singleScore, moreScore, judgeScore, blankFillScore, shortAnswerScore) VALUES (NULL,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, examine.getUserID());
		pstmt.setInt(2, examine.getPeperID());
		pstmt.setString(3, DateUtil.formatDate(examine.getTestTime(), "yyyy-MM-dd"));
		pstmt.setInt(4, examine.getScore());
		pstmt.setInt(5, examine.getSingleScore());
		pstmt.setInt(6, examine.getMoreScore());
		pstmt.setInt(7, examine.getBlankFillScore());
		pstmt.setInt(8, examine.getJudgeScore());
		pstmt.setInt(9, examine.getShortAnswerScore());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 根据考核ID获得考核记录
	 * @param examineID
	 * @return
	 * @throws SQLException
	 */
	public Examine getExamineById(int examineId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM examine WHERE id = ?";
		Examine examine = new Examine();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, examineId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				examine.setExamineID(rs.getInt("Id"));
				examine.setUserID(rs.getInt("userID"));
				examine.setPeperID(rs.getInt("paperID"));
				examine.setScore(rs.getInt("score"));
				examine.setSingleScore(rs.getInt("singleScore"));
				examine.setMoreScore(rs.getInt("moreScore"));
				examine.setJudgeScore(rs.getInt("judgeScore"));
				examine.setBlankFillScore(rs.getInt("blankFillScore"));
				examine.setShortAnswerScore(rs.getInt("shortAnswerScore"));
				examine.setQuestionMarks(getQuestionMarksByExamineId(examineId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return examine;
	}
	
	/**
	 * 根据考核ID获得主观题及学生的答案
	 * @param examineId
	 * @return
	 */
	public List<QuestionMark> getQuestionMarksByExamineId(int examineId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT qm.Id, qm.examineID, qm.questionID, qm.answer, qm.mark FROM question_mark qm, question_bank qb WHERE qm.questionID=qb.Id AND qb.questionType IN (2, 4) AND qm.examineID = ?";
		IQuestionDao questionDao = new QuestionDaoImpl();
		List<QuestionMark> questionMarkList = new ArrayList<QuestionMark>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, examineId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QuestionMark questionMark = new QuestionMark();
				questionMark.setQuestionMarkID(rs.getInt("Id"));
				questionMark.setExamineID(rs.getInt("examineID"));
				questionMark.setAnswer(rs.getString("answer"));
				questionMark.setQuestion(questionDao.getQuestionById(rs.getInt("questionID")));
				questionMark.setMark(rs.getInt("mark"));
				questionMarkList.add(questionMark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}		
		return questionMarkList; 
	}
	
	/**
	 * 获得当前保存的考核记录的ID
	 * @return
	 * @throws SQLException
	 */
	public int getMaxExamineId() throws SQLException{
		Connection conn = DbUtil.getCon();
		String sql = "SELECT MAX(Id) Id FROM examine";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("Id");
		}else {
			return 0;
		}
	}
	
	/**
	 * 保存考核的客观题分数
	 * @param examineID
	 * @param singleScore
	 * @param moreScore
	 * @param judgeScore
	 * @return
	 * @throws SQLException
	 */
	public int savePartScore(int examineID, int singleScore, int moreScore, int judgeScore) throws SQLException{
		Connection conn = DbUtil.getCon();
		String sql = "UPDATE examine SET singleScore = ?, moreScore = ?, judgeScore = ? WHERE Id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, singleScore);
		pstmt.setInt(2, moreScore);
		pstmt.setInt(3, judgeScore);
		pstmt.setInt(4, examineID);
		return pstmt.executeUpdate();
	}

	/**
	 * 根据分页条件获得考核试卷集
	 */
	public List<TestPaper> getExaminePapers(PageBean pageBean){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("SELECT DISTINCT tp.paperName, tp.Id, e.testTime FROM examine e, test_paper tp WHERE e.paperID = tp.Id ORDER BY e.testTime desc");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<TestPaper> examinePapersList = new ArrayList<TestPaper>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestPaper testPaper = new TestPaper();
				testPaper.setPaperID(rs.getInt("Id"));
				testPaper.setPaperName(rs.getString("paperName"));
				testPaper.setPaperDate(DateUtil.formatString(rs.getString("testTime"), "yyyy-MM-dd") );
				examinePapersList.add(testPaper);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return examinePapersList;
	}
		
	
	/**
	 * 根据分页条件获得学生考核集
	 */
	public List<Examine> getExamines(PageBean pageBean, int testPaperId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("SELECT * FROM examine WHERE examine.paperID=? ORDER BY id desc");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Examine> examinesList = new ArrayList<Examine>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, testPaperId);
			rs = pstmt.executeQuery();
			IUserDao userDao = new UserDaoImpl();
			while (rs.next()) {
				Examine examine = new Examine();
				examine.setExamineID(rs.getInt("Id"));
				examine.setUserID(rs.getInt("userID"));
				examine.setPeperID(rs.getInt("paperID"));
				examine.setTestTime(DateUtil.formatString(rs.getString("testTime"), "yyyy-MM-dd"));
				examine.setScore(rs.getInt("score"));
				examine.setSingleScore(rs.getInt("singleScore"));
				examine.setMoreScore(rs.getInt("moreScore"));
				examine.setJudgeScore(rs.getInt("judgeScore"));
				examine.setBlankFillScore(rs.getInt("blankFillScore"));
				examine.setShortAnswerScore(rs.getInt("shortAnswerScore"));
				examine.setUser(userDao.getUserById(rs.getInt("userID")));
				examinesList.add(examine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return examinesList;
	}
	
	/**
	 * 获得考核试卷总数
	 */
	public int paperCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(DISTINCT paperID) AS total FROM examine";
		int num = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
	}
	 
	
	/**
	 * 获得考核学生记录总数
	 */
	public int userCount(int paperID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS total FROM examine WHERE paperID=?";
		int num = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paperID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
	}
	
	public int updateExamine(Examine examine) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "UPDATE examine SET blankFillScore=?, shortAnswerScore=?, score=singleScore+moreScore+judgeScore+?+? WHERE id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, examine.getBlankFillScore());
		pstmt.setInt(2, examine.getShortAnswerScore());
		pstmt.setInt(3, examine.getBlankFillScore());
		pstmt.setInt(4, examine.getShortAnswerScore());
		pstmt.setInt(5, examine.getExamineID());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 根据试卷ID获得该试卷考核的平均分
	 */
	public float examScoreAVG(int paperID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT AVG(score) AS avgScore FROM examine WHERE paperID = ?";
		float avgScore = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paperID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				avgScore = (float) (Math.round(rs.getFloat("avgScore")*10)/10.0);  // 保留小数点后一位
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return avgScore;	
	}

	/**
	 * 根据试卷ID获得该试卷考核的最高分
	 */
	public int examScoreMAX(int paperID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(score) AS maxScore FROM examine WHERE paperID = ?";
		int maxScore = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paperID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxScore = rs.getInt("maxScore");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return maxScore;
	}

	/**
	 * 获得某一试卷指定分数区间的人数 
	 */
	public int scoreUserCount(int paperID, int sScore, int bScore) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS total FROM examine WHERE paperID = ? AND score >= ? AND score <= ?";
		int total = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paperID);
			pstmt.setInt(2, sScore);
			pstmt.setInt(3, bScore);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return total;
	}
	
	/**
	 * 根据用户ID和试卷ID判断是否已进行过考核，返回0表示还未参加考核，返回1表示已参加过考核
	 */
	public int isExamined(int userId, int paperId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS num FROM examine WHERE userID = ? AND paperID = ?";
		int num = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, paperId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
	}
	
	public int deleteExamineById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Examine> getExamines(Examine examine) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Examine> getAllExamines(){
		// TODO Auto-generated method stub
		return null;
	}

	public List<Examine> getExamines(Examine examine, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count(Examine examine) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateExamineById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
