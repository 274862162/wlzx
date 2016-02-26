package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.gduf.netserver.dao.ISurveySystemDisplayQusnDao;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.Questionnaire;
import cn.edu.gduf.netserver.domain.QusnnQuestion;
import cn.edu.gduf.netserver.util.DbUtil;

public class SurveySystemDisplayQusnDaoImpl implements ISurveySystemDisplayQusnDao{

	public Questionnaire queryQusn(int ID) {
		Questionnaire qusnn=new Questionnaire();
		String querySql="select ID,quesnnTitle from questionnaire where id=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, ID);
			rs=ps.executeQuery();
			while(rs.next()){
				qusnn.setID(rs.getInt("id"));
				qusnn.setQuesnnTitle(rs.getString("quesnnTitle"));
				//System.out.println("查询成功");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
			return qusnn;
	}

	public ArrayList<QusnnQuestion> queryQues(int ID) {
		ArrayList<QusnnQuestion> quess=new ArrayList<QusnnQuestion>();
		String querySql="select ID,questionTitle,sectionA,sectionB,sectionC,sectionD,sectionE,other,questionType from qusnn_question where ID in(select questionID FROM create_questionnaire where questionnaireID=?)";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, ID);
			rs=ps.executeQuery();
			while(rs.next()){
				QusnnQuestion ques=new QusnnQuestion();
				ques.setID(rs.getInt("ID"));
				ques.setQuestionTitle(rs.getString("questionTitle"));
				ques.setSectionA(rs.getString("sectionA"));
				ques.setSectionB(rs.getString("sectionB"));
				ques.setSectionC(rs.getString("sectionC"));
				ques.setSectionD(rs.getString("sectionD"));
				ques.setSectionE(rs.getString("sectionE"));
				ques.setOther(rs.getString("other"));
				ques.setQuestionType(rs.getString("questionType"));
				quess.add(ques);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quess;
	}

}
