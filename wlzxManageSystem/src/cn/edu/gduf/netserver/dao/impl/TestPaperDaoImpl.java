package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.edu.gduf.netserver.dao.IQuestionDao;
import cn.edu.gduf.netserver.dao.ITestPaperDao;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.TestPaper;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;
import cn.edu.gduf.netserver.domain.PageBean;

/**
 * 试卷数据访问实现类
 * @author hsg
 * 2015/01/22
 */
public class TestPaperDaoImpl implements ITestPaperDao{

	/**
	 * 根据试卷ID获得试卷
	 * @param testPaperId
	 * @return
	 */
	public TestPaper getTestPaperById(int testPaperId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from test_paper where Id = ?";
		TestPaper testPaper = new TestPaper();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, testPaperId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				testPaper.setPaperID(rs.getInt("Id"));
				testPaper.setPaperDate(DateUtil.formatString(rs.getString("paperDate"), "yyyy-MM-dd"));
				testPaper.setPaperName(rs.getString("paperName"));
				testPaper.setQuestions(this.getQuestionsByPaperId(testPaperId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return testPaper;
	}
	
	/**
	 * 根据试卷ID获得相应所有题目
	 * @param testPaperId
	 * @return
	 */
	public List<Question> getQuestionsByPaperId(int testPaperId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT qb.Id, questionType, questionTitle, sectionA, sectionB, sectionC, sectionD, sectionE, answer, analysis, point FROM test_paper tp, choices c, question_bank qb WHERE tp.Id = c.paperID AND c.questionID = qb.Id AND tp.Id = ?";
		List<Question> questionList = new ArrayList<Question>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, testPaperId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionID(rs.getInt("Id"));
				question.setQuestionType(rs.getInt("questionType"));
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setSectionA(rs.getString("sectionA"));
				question.setSectionB(rs.getString("sectionB"));
				question.setSectionC(rs.getString("sectionC"));
				question.setSectionD(rs.getString("sectionD"));
				question.setSectionE(rs.getString("sectionE"));
				question.setAnswer(rs.getString("answer"));
				question.setAnalysis(rs.getString("analysis"));
				question.setPoint(rs.getInt("point"));
				questionList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return questionList;
	}

	/**
	 * 根据分页条件获得试卷集
	 */
	public List<TestPaper> getTestPapers(PageBean pageBean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("SELECT Id, paperDate, paperName FROM test_paper ORDER BY test_paper.Id desc");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<TestPaper> testPapersList = new ArrayList<TestPaper>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestPaper testPaper = new TestPaper();
				testPaper.setPaperID(rs.getInt("Id"));
				testPaper.setPaperDate(DateUtil.formatString(rs.getString("paperDate"), "yyyy-MM-dd") );
				testPaper.setPaperName(rs.getString("paperName"));
				testPapersList.add(testPaper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return testPapersList;
	}

	/**
	 * 获得试卷总数
	 */
	public int count() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) AS total FROM test_paper";
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
	 * 根据试卷名添加试卷
	 * @throws SQLException 
	 */
	public int addTestPaper(String paperName) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO test_paper(Id, paperDate, paperName) VALUES(NULL, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		pstmt.setString(2, paperName);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 根据试卷添加试卷与问题的关联
	 */
	public int addChoice(TestPaper testPaper) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO choices VALUES (NULL, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		Iterator<Question> it = (testPaper.getQuestions()).iterator();
		IQuestionDao questionDao = new QuestionDaoImpl();
		while (it.hasNext()) {
			Question question = it.next();
			pstmt.setInt(1, this.getIdByTestPaperName(testPaper.getPaperName()));
			pstmt.setInt(2, questionDao.getIdByQuestionTitle(question.getQuestionTitle()));
			pstmt.executeUpdate();	
		}
		return 1;
	}
	
	/**
	 * 根据试卷名获得试卷id
	 */
	public int getIdByTestPaperName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id FROM test_paper WHERE paperName = ?;";
		int id = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return id;
	}
	
	public int addTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteTestPaperById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<TestPaper> getTestPapers(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获得所有试卷
	 * @return
	 */
	public List<TestPaper> getAllTestPapers(){
		return null;
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Id, paperDate, paperName FROM test_paper ORDER BY test_paper.Id desc";
		List<TestPaper> testPapersList = new ArrayList<TestPaper>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestPaper testPaper = new TestPaper();
				testPaper.setPaperID(rs.getInt("Id"));
				testPaper.setPaperDate(DateUtil.formatString(rs.getString("paperDate"), "yyyy-MM-dd") );
				testPaper.setPaperName(rs.getString("paperName"));
				testPapersList.add(testPaper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return testPapersList;
		*/
	}

	public List<TestPaper> getTestPapers(TestPaper testPaper, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTestPaperById(int id) {
		// TODO Auto-generated method stub
		return 0;
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
}
