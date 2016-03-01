package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.Result;
import cn.edu.gduf.netserver.domain.Student;
import cn.edu.gduf.netserver.util.PropertiesUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class StudentShowAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StudentDaoImpl studentDao = new StudentDaoImpl();
		String currentPage = request.getParameter("page");  // 显示的那一页(当前页)
		String displayRecord = request.getParameter("displayRecord");//每页显示多少条
		if (StringUtil.isEmpty(currentPage)) {
			currentPage = "1";  // 默认第一页
		}
		if(StringUtil.isEmpty(displayRecord)) {
			displayRecord = PropertiesUtil.getValue("pageSize");  // 默认第一页
		}
		int totalNum = studentDao.count();  // 记事总数
		int pageSize = Integer.parseInt(displayRecord);
		PageBean pageBean = new PageBean(Integer.parseInt(currentPage), pageSize);
		List<Student> studentList = null;
		//得到学生用户名
		String name = request.getParameter("name");
		String sno = request.getParameter("sno");
		Student student = new Student();
		student.setName(name);
		student.setSno(sno);
		if(name.equals("") && sno.equals("")){
			studentList = studentDao.getStudents(pageBean);
		}else{
			totalNum = 1;
			studentList = studentDao.getStudent(student);
		}
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;  // 总页数
		Result result = new Result();
		result.setList(studentList);
		result.setPage(Integer.parseInt(currentPage));
		result.setTotalPage(totalPage);
		JSONArray json = JSONArray.fromObject(result);
		return json.toString();
	}

}
