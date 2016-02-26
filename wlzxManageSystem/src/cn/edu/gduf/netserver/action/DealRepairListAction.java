package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.domain.RepairList;

public class DealRepairListAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int dutyPersonID=(Integer) request.getSession().getAttribute("id");
		int id=Integer.parseInt(""+request.getSession().getAttribute("displayID"));
		String oldDealingText=request.getParameter("problemDescribe");
		String dealingText="";
		try {
			dealingText = new String(oldDealingText.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String dealingTime=request.getParameter("dealingTime");
		RepairList repairList=new RepairList();
		repairList.setDutyPersonID(dutyPersonID);
		repairList.setDealingText(dealingText);
		repairList.setRepairListID(id);
		repairList.setDealingTime(dealingTime);
		IRepairListDao repairListImpl=new RepairListDaoImpl();
		repairListImpl.updateRepairList(repairList);
		System.out.println("处理说明："+dealingText);
		return "处理报修单成功！";
	}

}
