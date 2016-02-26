package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.dao.IStudentDao;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Student;
import cn.edu.gduf.netserver.util.DbUtil;

public class StudentDaoImpl implements IStudentDao{

	public int addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateStudentById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteStudentById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getStudents(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getStudents(PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getStudents(Student student, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int count(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unused")
	public Student getStudentBySno(String sno) {
		String querySql="select id,sno,name,password from student where sno=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student student=new Student();
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()){
				student.setStudentID(rs.getInt("id"));
				student.setSno(rs.getString("sno"));
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		if(student==null){
			return null;
		}
		else{
			return student;
		}
	}

	public String getPasswordBysno(String sno) {
		String sql="select password from student where sno=?";
		String password=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()){
				password=rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	public void updatePassword(String sno, String password) {
		String sql="update student set password=? where sno=?";
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DbUtil.getCon();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, sno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
