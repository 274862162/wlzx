package cn.edu.gduf.netserver.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.IStudentDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.dao.impl.StudentDaoImpl;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.RepairList;
import cn.edu.gduf.netserver.domain.Student;

/**
 * @author Wmj
 *网上报修系统类
 *检查学生登录输入操作
 */
public class JudgeStudentAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String stuName=request.getParameter("user");
		String stuPass=request.getParameter("password");			
		IStudentDao studentImpl=new StudentDaoImpl();
		Student student=studentImpl.getStudentBySno(stuName);
		if(student==null || stuName==null || stuPass==null){
			return "用户名或密码错误！";
		}
		else if(!stuPass.equals(student.getPassword())){
			return "用户名或密码错误！";
		}
		else{
			//如果登录信息输入正确就保存用户信息
			request.getSession().setAttribute("student", student);
			//获取学生历史报修单信息--20150507新增
			PageBean pagebean=new PageBean(1, 5);//1为第一页，5为每页显示5条记录
			IRepairListDao repairListImpl=new RepairListDaoImpl();
			//让session保存当前页
			request.getSession().setAttribute("currentPage", pagebean.getPage());
			//往session中存放当前学生历史报修的总页数
			RepairList repairList=new RepairList();
			repairList.setStuSno(stuName);
			int totalNum=repairListImpl.count(repairList);
			//如果totalNum%pagebean.getPageSize()==0，则allPage=totalNum%pagebean.getPageSize()，否则等于totalNum%pagebean.getPageSize()+1
			int allPage=totalNum%pagebean.getPageSize()==0?totalNum/pagebean.getPageSize():totalNum/pagebean.getPageSize()+1;
	//			System.out.println("总页数："+allPage);
			request.getSession().setAttribute("allPage", allPage);			
				//强制将父类转为子类
			ArrayList<RepairList> repairLists=(ArrayList<RepairList>) repairListImpl.getRepairLists(repairList,pagebean);
//			for(int i=0;i<repairLists.size();i++){
//				System.out.println("姓名："+repairLists.get(i).getStuName());
//			}
			//把数据从servlet传到视图页面
			request.getSession().setAttribute("repairLists", repairLists);				
			return "../jsp/webjsp/onlineRepair1.jsp";
		}
	}
}

