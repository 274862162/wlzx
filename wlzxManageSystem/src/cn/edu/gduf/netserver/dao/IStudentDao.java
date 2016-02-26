package cn.edu.gduf.netserver.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Student;

/**
 * 学生数据访问接口
 * @author hsg
 * 2015/01/23
 */
public interface IStudentDao {

	/**
	 * 保存学生
	 * @param student
	 * @return
	 * @throws SQLException 
	 */
	public int addStudent(Student student) throws SQLException;
	
	/**
	 * 更新学生
	 * @param student
	 * @return
	 */
	public int updateStudent(Student student);
	
	/**
	 * 根据id更新学生
	 * @param id
	 * @return
	 */
	public int updateStudentById(int id);
	
	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	public int deleteStudentById(int id);
	
	/**
	 * 获得所有学生
	 * @return
	 */
	public List<Student> getAllStudents();
	
	/**
	 * 根据学生条件得到学生集
	 * @param student
	 * @return
	 */
	public List<Student> getStudents(Student student);
	
	/**
	 * 根据分页条件得到学生集
	 * @param pageBean
	 * @return
	 */
	public List<Student> getStudents(PageBean pageBean);
	
	/**
	 * 根据学生条件和分页条件得到学生集
	 * @param student
	 * @param pageBean
	 * @return
	 */
	public List<Student> getStudents(Student student, PageBean pageBean);
	
	/**
	 * 根据学生Id获得学生
	 * @param id
	 * @return
	 */
	public Student getStudentById(int id);
	
	/**
	 * 获得学生总数
	 * @return
	 */
	public int count();
	
	/**
	 * 根据学生条件获得学生总数
	 * @param student
	 * @return
	 */
	public int count(Student student);
	/**
	 * 根据学号获取学生信息 writte by Wmj
	 * @param sno 学号
	 * @return 学生
	 */
	public Student getStudentBySno(String sno);
	/**
	 * 根据学号获取学生密码writte by Wmj
	 * @param sno 学生学号
	 * @return 学生密码
	 */
	public String getPasswordBysno(String sno);
	/**
	 * 根据学号更改密码writte by Wmj
	 * @param sno 学号
	 * @param password 密码
	 */
	public void updatePassword(String sno,String password);
}
