package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;

public class RepairEvaluationAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String id=request.getParameter("frameID");
		String[] levels=request.getParameterValues("grade");
		String level="";
		for(int i=0;i<levels.length;i++){
			level=level+levels[i];
		}
		IRepairListDao repairImpl=new RepairListDaoImpl();
		repairImpl.updateEvaluationByID(id, level);		
		return "../jsp/webjsp/onlineRepair1.jsp";
	}

}
