package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import cn.edu.gduf.netserver.dao.ISurveySystemAlyQusnDao;
import cn.edu.gduf.netserver.domain.Findings;
import cn.edu.gduf.netserver.domain.Question;
import cn.edu.gduf.netserver.domain.QusnnList;
import cn.edu.gduf.netserver.domain.QusnnQuestion;
import cn.edu.gduf.netserver.util.DbUtil;

public class SurveySystemAlyQusnDaoImpl implements ISurveySystemAlyQusnDao{
	public QusnnList queryQusn(int qusnID) {
		QusnnList qusnnList=new QusnnList();
		String querySql="select ID,quesnnTitle,quesnnTime,qusnnStatus from questionnaire where ID=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, qusnID);
			rs=ps.executeQuery();
			while(rs.next()){
				qusnnList.setQusnnID(rs.getInt("id"));
				qusnnList.setQuesnnTitle(rs.getString("quesnnTitle"));
				qusnnList.setQuesnnTime(rs.getString("quesnnTime"));
				qusnnList.setQusnnStatus(rs.getString("qusnnStatus"));
				qusnnList.setReceiveData(collectData(qusnnList.getQusnnID()));
				//System.out.println("查询成功");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}
			DbUtil.close(rs, ps, conn);
			return qusnnList;
	}
	public int collectData(int qusnnID) {
		int num=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="select count(*) as num from investigate where questionnaireID=?;";
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, qusnnID);
			rs=ps.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close(rs, ps, conn);
		return num;
	}
	public ArrayList<Findings> queryQuesFindings(int qusnID) {
		//取得问卷的问题<id,quesTitle>结果集
		HashMap<Integer, String> quesMess=queryQues(qusnID);
		ArrayList<Findings> quessFindings=new ArrayList<Findings>();
		Iterator<Entry<Integer, String>> iter=quesMess.entrySet().iterator();
		for(int i=0;i<quesMess.size();i++){//问题记录数
			Entry<Integer,String> entry=iter.next();
			Findings finding=new Findings();
			//设置问题ID
			finding.setQuesID(entry.getKey());
			//设置问题标题
			finding.setQuesTitle(entry.getValue());
			//设置问题选择的结果
			finding.setSelectNumA(getSelectNum('A', entry.getKey()));
			System.out.println("A选项选择人数"+finding.getSelectNumA());
			finding.setSelectNameA(getSelectName('A', entry.getKey()));
			finding.setSelectNumB(getSelectNum('B', entry.getKey()));
			finding.setSelectNameB(getSelectName('B', entry.getKey()));
			finding.setSelectNumC(getSelectNum('C', entry.getKey()));
			finding.setSelectNameC(getSelectName('C', entry.getKey()));
			finding.setSelectNumD(getSelectNum('D', entry.getKey()));
			finding.setSelectNameD(getSelectName('D', entry.getKey()));
			finding.setSelectNumE(getSelectNum('E', entry.getKey()));
			finding.setSelectNameE(getSelectName('E', entry.getKey()));
			quessFindings.add(finding);
		}
		return quessFindings;
	}
	public HashMap<Integer, String> queryQues(int qusnID) {
		HashMap<Integer, String> quesMess=new HashMap<Integer, String>(); 
		String querySql="select id,questionTitle from qusnn_question where qusnID=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, qusnID);
			rs=ps.executeQuery();
			while(rs.next()){
				quesMess.put(rs.getInt("id"), rs.getString("questionTitle"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close(rs, ps, conn);
		
		return quesMess;
	}
	/**返回选择问题选项的人数
	 * @param section 选项字符串
	 * @param quesID 问题ID
	 * @return
	 */
	public int getSelectNum(char section,int quesID){
		int num=0;
		String result="";
		String querySql="select userSelect from user_selc_section where questionID=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, quesID);
			rs=ps.executeQuery();
			while(rs.next()){
				result=result+rs.getString("userSelect"); //将选择的选项连接起来
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close(rs, ps, conn);
		for(int i=0;i<result.length();i++){
			if(result.charAt(i)==section){
				num++;
			}
		}
		return num;
	}
	/**返回选择问题选项的人名
	 * @param section 选项字符串
	 * @param quesID 问题ID
	 * @return
	 */
	public String getSelectName(char section,int quesID){
		String result="";
		String querySql="select userID,userSelect from user_selc_section where questionID=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, quesID);
			rs=ps.executeQuery();
			while(rs.next()){
				String userSelect=rs.getString("userSelect");
				for(int i=0;i<userSelect.length();i++){
					if(userSelect.charAt(i)==section){
						result=result+" "+idToName(rs.getInt("userID"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close(rs, ps, conn);
		return result;
	}
	public String idToName(int userID) {
		String userName=null;
		String querySql="select userName from user where Id=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, userID);
			rs=ps.executeQuery();
			while(rs.next()){
				userName=rs.getString("userName");
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
			return userName;
	}
}
