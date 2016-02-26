package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.edu.gduf.netserver.dao.ISurveySystemSaveQusnDao;
import cn.edu.gduf.netserver.domain.CreateQuestionnaire;
import cn.edu.gduf.netserver.domain.QusnnQuestion;
import cn.edu.gduf.netserver.domain.Questionnaire;
import cn.edu.gduf.netserver.util.DbUtil;

/**
 * @author Wmj
 *主要描述问卷调查子系统对数据库的操作
 */
public class SurveySystemSaveQusnDaoImpl implements ISurveySystemSaveQusnDao{	
	public int saveQusnnMessage(Questionnaire qusn){
		//存储问卷主键
		int qusnKey=0;
		String quesnnSQL="insert into questionnaire(userID,quesnnTitle,quesnnTime,qusnnStatus)" +
				"values(?,?,?,?)";		
		Connection conn=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			conn=DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {			
			ps=conn.prepareStatement(quesnnSQL);
			ps.setInt(1, qusn.getUserID());
			ps.setString(2,qusn.getQuesnnTitle());
			ps.setString(3, qusn.getQuesnnTime());
			ps.setString(4, qusn.getQusnnStatus());
			ps.executeUpdate();
			//获得插入问卷表主键
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				qusnKey=rs.getInt(1);
				System.out.println("问卷主键"+qusnKey);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("write fail！！");
		}
		try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}
		return qusnKey;		
	}
	public ArrayList<Integer> saveQuestion(ArrayList<QusnnQuestion> ques,int qusnID) {
		//保存问题主键
		ArrayList<Integer> quesKey=new ArrayList<Integer>();
		String questionSQL="insert into qusnn_question(questionTitle," +
				"sectionA,sectionB,sectionC,sectionD,sectionE," +
				"other,questionType,qusnID) values(?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			conn=DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			for(int i=0;i<ques.size();i++){
				ps=conn.prepareStatement(questionSQL);
				ps.setString(1, ques.get(i).getQuestionTitle());
				ps.setString(2, ques.get(i).getSectionA());
				ps.setString(3, ques.get(i).getSectionB());
				ps.setString(4, ques.get(i).getSectionC());
				ps.setString(5, ques.get(i).getSectionD());
				ps.setString(6, ques.get(i).getSectionE());
				ps.setString(7, ques.get(i).getOther());
				ps.setString(8, ques.get(i).getQuestionType());
				ps.setInt(9, qusnID);
				ps.executeUpdate();
				//获得插入问题表的主键
				rs = ps.getGeneratedKeys();
				if(rs.next()){
					quesKey.add(rs.getInt(1));
					System.out.println("问题主键"+rs.getInt(1));
				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				DbUtil.close(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("connect close fail！！");
			}
		return quesKey;
	}
	public void saveCreateQusn(int qusnKey,ArrayList<Integer> quesKey) {
		//CreateQuestionnaire createQusnn=new CreateQuestionnaire();
		String creaQusnnSQL="insert into create_questionnaire(questionID,questionnaireID)" +
				"values(?,?)";
		Connection conn=null;
		PreparedStatement ps=null;	
		try {
			conn=DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		//存储create_questionnaiare表
		try {
			ps=conn.prepareStatement(creaQusnnSQL);
			for(int i=0;i<quesKey.size();i++){				
				ps.setInt(1,quesKey.get(i));
				ps.setInt(2,qusnKey);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
