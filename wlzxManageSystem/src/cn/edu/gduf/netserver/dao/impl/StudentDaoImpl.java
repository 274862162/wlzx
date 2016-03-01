package cn.edu.gduf.netserver.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gduf.netserver.dao.IStudentDao;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Student;
import cn.edu.gduf.netserver.domain.UserRole;
import cn.edu.gduf.netserver.util.DbUtil;

public class StudentDaoImpl implements IStudentDao{

	public int addStudent(Student student) throws SQLException {
		int i = 0;	//影响的条数
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=null;
		StringBuffer sql= new StringBuffer("INSERT INTO student(name,sno,password) values(?,?,?)");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getSno());
			pstmt.setString(3, student.getPassword());
			i = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
		return i;
	}

	public int updateStudent(Student student) {
		String sql="update student set name=?,password=? where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DbUtil.getCon();
		int result=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getPassword());
			ps.setInt(3, student.getStudentID());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateStudentById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteStudentById(int id) {
		String sql="delete from student where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DbUtil.getCon();
		int result=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
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
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sql=new StringBuffer("SELECT id,sno,name FROM student order by id");
		if (pageBean != null) {
			sql.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<Student> studentList = new ArrayList<Student>();
		try {
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentID(rs.getInt("id"));
				student.setSno(rs.getString("sno"));
				student.setName(rs.getString("name"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return studentList;
	}

	public List<Student> getStudents(Student student, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentById(int id) {
		String querySql="select id,sno,name,password from student where id=?";		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student student=new Student();
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(querySql);
			ps.setInt(1, id);
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
		return student;
	}

	public int count() {
		int num=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sql= new StringBuffer("SELECT count(*) as count FROM student");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()){
				num=rs.getInt("count");
			}
			System.out.println(num);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs, pstmt, conn);
		}
		return num;
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
	
	public List<Student> getStudent(Student student) {
		StringBuffer sql=new StringBuffer("select id,sno,name from student where id is not null");		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Student> studentList = new ArrayList<Student>();
		if(!student.getName().equals("")){
			sql.append(" and name='"+student.getName()+"'");
		}
		if(!student.getSno().equals("")){
			sql.append(" and sno='"+student.getSno()+"'");
		}
		try{
			conn=DbUtil.getCon();
			ps=conn.prepareStatement(sql.toString());
			rs=ps.executeQuery();
			while(rs.next()){
				Student result = new Student();
				result.setStudentID(rs.getInt("id"));
				result.setSno(rs.getString("sno"));
				result.setName(rs.getString("name"));
				//result.setPassword(rs.getString("password"));
				studentList.add(result);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbUtil.close(rs, ps, conn);
			}
		return studentList;
	}


}
