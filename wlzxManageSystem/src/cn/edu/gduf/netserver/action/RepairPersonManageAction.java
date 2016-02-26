package cn.edu.gduf.netserver.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.domain.PageBean;
import cn.edu.gduf.netserver.domain.RepairList;

/**
 * 个人报修单管理类
 * @author Wmj
 *
 */
public class RepairPersonManageAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//需从session获取用户ID
		int userID=0;
		userID=(Integer) request.getSession().getAttribute("id");
		if(userID==0){
			return "../jsp/login.jsp";
		}
		String option=request.getParameter("option");//控制是否查看个人保修单还是全部报修单
		PageBean pagebean=new PageBean(1, 5);//默认1为第一页，5为每页显示5条记录
		//往session中保存页面大小的数据
		if(request.getSession().getAttribute("userPageSize")==null){
			request.getSession().setAttribute("userPageSize", pagebean.getPageSize());
		}
		String userPageSize=request.getParameter("userPageSize");
		if(userPageSize!=null){
			pagebean.setPageSize(Integer.parseInt(userPageSize));
			request.getSession().setAttribute("userPageSize", pagebean.getPageSize());
		}else{
			pagebean.setPageSize(Integer.parseInt(""+request.getSession().getAttribute("userPageSize")));
		}
		if(request.getParameter("userCurrentPage")!=null){
			pagebean.setPage(Integer.parseInt(request.getParameter("userCurrentPage")));
			request.getSession().setAttribute("userCurrentPage", pagebean.getPage());
		}else{
			//让session保存当前页
			request.getSession().setAttribute("userCurrentPage", pagebean.getPage());
		}
		if(option==null){
			IRepairListDao repairImpl=new RepairListDaoImpl();
			int totalNum=repairImpl.countUser(userID);
			//如果totalNum%pagebean.getPageSize()==0，则allPage=totalNum%pagebean.getPageSize()，否则等于totalNum%pagebean.getPageSize()+1
			int allPage=totalNum%pagebean.getPageSize()==0?totalNum/pagebean.getPageSize():totalNum/pagebean.getPageSize()+1;
			request.getSession().setAttribute("userAllpage", allPage);
			ArrayList<RepairList> repairLists=repairImpl.getRepairListByID(userID,pagebean);
			//把数据从servlet传到视图页面
			request.getSession().setAttribute("userRepairLists", repairLists);	
			return "../jsp/repairsManagement1.jsp";
		}
		else{
			IRepairListDao repairImpl=new RepairListDaoImpl();
			int totalNum=repairImpl.countAllRepairLists();
			//如果totalNum%pagebean.getPageSize()==0，则allPage=totalNum%pagebean.getPageSize()，否则等于totalNum%pagebean.getPageSize()+1
			int allPage=totalNum%pagebean.getPageSize()==0?totalNum/pagebean.getPageSize():totalNum/pagebean.getPageSize()+1;
			request.getSession().setAttribute("userAllpage", allPage);
			ArrayList<RepairList> repairLists=repairImpl.getRepairLists(pagebean);
			//把数据从servlet传到视图页面
			request.getSession().setAttribute("userRepairLists", repairLists);	
			return "../jsp/showAllRepairList.jsp";
		}
	}

}
