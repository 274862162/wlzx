package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.domain.RepairAnalyze;

public class RepairAnalyzeAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*String type = request.getParameter("type");
		if(type == "" || type == null){
				type=null;
		}*/
		//得到开始时间
		String date1 = request.getParameter("startTime");
		if(date1 == "" || date1 == null){
			date1 = null;
		}
		Date startTime = null;
		if(date1!=null){
			startTime = Date.valueOf(date1);
		}
		//得到结束时间
		String date2 =request.getParameter("endTime");
		if(date2 == "" || date2 == null){
			date2 = null;
		} 
		Date endTime = null;
		if(date2!=null){
			endTime = Date.valueOf(date2);
		}
		IRepairListDao repairImpl=new RepairListDaoImpl();
		List<RepairAnalyze> repairList = repairImpl.alyReapairByBuilding(startTime,endTime);
		JSONArray json = JSONArray.fromObject(repairList);
		return json.toString();
	}

}
