package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.SystemLogListDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.domain.Log;

public class DisplayRepairListAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String userOption=request.getParameter("userOption");
		String place=request.getParameter("place");
		int id=Integer.parseInt(request.getParameter("id"));
		request.getSession().setAttribute("displayID", id);
		if(userOption.equals("deal")){//处理报修单
			return "../jsp/repairsManagement2.jsp";
		}else if(userOption.equals("view")){
			if(place.equals("back")){//后台显示报修单
				return "../jsp/viewRepairList.jsp";
			}else{//前台显示报修单
				return "../jsp/webjsp/viewRepairList.jsp";
			}
		}else{//删除报修单
			IRepairListDao delOption=new RepairListDaoImpl();
			delOption.deleteRepairListById(id);
			//登陆成功写入日志
			SystemLogListDao logDao=new SystemLogListDao();
			Log suclog=new Log();
			suclog.setType("1");
			suclog.setContent("用户:"+request.getSession().getAttribute("userName")+"删除一条报修单。");
			suclog.setOperator(""+request.getSession().getAttribute("userName"));
			logDao.addLog(suclog);
			return "../onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage";
		}
	}
	
}
