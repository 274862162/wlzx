package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import cn.edu.gduf.netserver.dao.IQuestionMarkDao;
import cn.edu.gduf.netserver.domain.QuestionMark;
import cn.edu.gduf.netserver.util.DbUtil;

/**
 * 问题评分数据访问实现类
 * @author hsg
 * 2015/01/22
 */
public class QuestionMarkDaoImpl implements IQuestionMarkDao{

	/**
	 * 添加保存学生答案和问题评分
	 * @param questionMark
	 * @return
	 * @throws SQLException
	 */
	public int addQuestionMark(QuestionMark questionMark) throws SQLException{
		Connection conn = DbUtil.getCon();
		String sql = "INSERT INTO question_mark VALUES (NULL,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, questionMark.getExamineID());
		pstmt.setInt(2, questionMark.getQuestionID());
		pstmt.setString(3, questionMark.getAnswer());
		pstmt.setInt(4, questionMark.getMark());
		return pstmt.executeUpdate();
	}

	/**
	 * 根据考核id获得学生问题及评分
	 */
	public Set<QuestionMark> getQuestionMarksByExamineId(int examineId) {
		return null;
	}

	/**
	 * 根据id更新评分
	 */
	public int updateQuestionMarkById(int questionMarkId, int mark) throws SQLException {
		Connection conn = DbUtil.getCon();
		String sql = "UPDATE question_mark SET mark=? WHERE Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mark);
		pstmt.setInt(2, questionMarkId);
		return pstmt.executeUpdate();
	}
}
