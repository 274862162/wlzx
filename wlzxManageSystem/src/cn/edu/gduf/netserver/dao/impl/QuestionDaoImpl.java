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

import com.sun.org.apache.regexp.internal.recompile;

import cn.edu.gduf.netserver.dao.IQuestionDao;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.util.DateUtil;
import cn.edu.gduf.netserver.util.DbUtil;

/**
 * 问题数据访问实现类
 * @author hsg
 * 2015/01/22
 */
public class QuestionDaoImpl implements IQuestionDao{

	/**
	 * 根据问题ID获得问题
	 * @param userID
	 * @return
	 */
	public Question getQuestionById(int questionId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM question_bank WHERE id = ?";
		Question question = new Question();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				question.setQuestionID(rs.getInt("Id"));
				question.setJoinTime(DateUtil.formatString(rs.getString("joinTime"), "yyyy-MM-dd"));
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return question;
	}
	
	/**
	 * 根据问题类型获得问题分值（仅限单选、多选、判断）
	 * @param questionType
	 * @return
	 * @throws SQLException
	 */
	public int getPointByQuestionType(int questionType) throws SQLException{
		Connection conn = DbUtil.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT POINT FROM question_bank WHERE questionType = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, questionType);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("point");
		}else {
			return 0;
		}
	}

	/**
	 * 添加问题到题库
	 * @throws SQLException 
	 */
	public int addQuestion(Question question) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO question_bank(Id, joinTime, questionType, questionTitle, sectionA, sectionB, sectionC, sectionD, sectionE, answer, analysis, POINT) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		pstmt.setInt(2, question.getQuestionType());
		pstmt.setString(3, question.getQuestionTitle());
		pstmt.setString(4, question.getSectionA());
		pstmt.setString(5, question.getSectionB());
		pstmt.setString(6, question.getSectionC());
		pstmt.setString(7, question.getSectionD());
		pstmt.setString(8, question.getSectionE());
		pstmt.setString(9, question.getAnswer());
		pstmt.setString(10, question.getAnalysis());
		pstmt.setInt(11, question.getPoint());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 批量添加问题到题库
	 * @throws SQLException 
	 */
	public int addQuestion(List<Question> questions) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO question_bank(Id, joinTime, questionType, questionTitle, sectionA, sectionB, sectionC, sectionD, sectionE, answer, analysis, POINT) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		Iterator<Question> it = questions.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			if ("0".equals(q.getExist())) {
				pstmt.setString(1, DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
				pstmt.setInt(2, q.getQuestionType());
				pstmt.setString(3, q.getQuestionTitle());
				pstmt.setString(4, q.getSectionA());
				pstmt.setString(5, q.getSectionB());
				pstmt.setString(6, q.getSectionC());
				pstmt.setString(7, q.getSectionD());
				pstmt.setString(8, q.getSectionE());
				pstmt.setString(9, q.getAnswer());
				pstmt.setString(10, q.getAnalysis());
				pstmt.setInt(11, q.getPoint());
				pstmt.executeUpdate();
			}
		}
		if (!it.hasNext()) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 根据问题类型获得问题集
	 */
	public List<Question> getQuestions(int questionType) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, questionTitle, sectionA, sectionB, sectionC, sectionD, sectionE, answer, analysis, point  FROM question_bank WHERE questionType=?";
		List<Question> questionList = new ArrayList<Question>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionType);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionID(rs.getInt("Id"));
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setSectionA(rs.getString("sectionA"));
				question.setSectionA(rs.getString("sectionB"));
				question.setSectionA(rs.getString("sectionC"));
				question.setSectionA(rs.getString("sectionD"));
				question.setSectionA(rs.getString("sectionE"));
				question.setAnswer(rs.getString("answer"));
				question.setAnalysis(rs.getString("analysis"));
				question.setPoint(rs.getInt("point"));
				questionList.add(question);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return questionList;
	}
	
	/**
	 * 根据问题题目获得id
	 */
	public int getIdByQuestionTitle(String title) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id FROM question_bank WHERE questionTitle = ?;";
		int id = 0;
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
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

	public int deleteQuestionById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getQuestions(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getQuestions(PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getQuestions(Question question, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateQuestionById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
