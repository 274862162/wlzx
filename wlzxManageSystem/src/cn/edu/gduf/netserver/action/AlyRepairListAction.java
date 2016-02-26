package cn.edu.gduf.netserver.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.IRepairResultDoneDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.domain.RepairAlyResult;
import cn.edu.gduf.netserver.util.ResponseUtil;

public class AlyRepairListAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String option=request.getParameter("option");
		if(option!=null){//初始化页面姓名下拉框
			IRepairListDao repairListImpl=new RepairListDaoImpl();
			String userName=repairListImpl.getAlluserName();
			request.getSession().setAttribute("alluserName", userName);
			return "../jsp/repairsManagement4.jsp";
		}
		else{//特定条件查询
			String year="",month="",name="";
			String oldYear=request.getParameter("year");
			String oldMonth=request.getParameter("month");
			String oldName=request.getParameter("name");
			try{
				year=new String(oldYear.getBytes("iso8859-1"),"UTF-8");
				month=new String(oldMonth.getBytes("iso8859-1"),"UTF-8");
				name=new String(oldName.getBytes("iso8859-1"),"UTF-8");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			IRepairListDao repairListImpl=new RepairListDaoImpl();
			ArrayList<RepairAlyResult> repairAlyReaults=new ArrayList<RepairAlyResult>();
			if(month.equals("")&&name.equals("")){ //如果只输入年份，其他为空，则输出统计图表，没有导出功能；
				IRepairResultDoneDao alydata=repairListImpl.alyReapairByY(year);
				//将ArrayList对象转换为Json数组对象
				JSONObject jsonObject=JSONObject.fromObject(alydata);
				//输出到页面
				try {
					ResponseUtil.write(jsonObject, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(alydata.getDone()+alydata.getNoDone());
				return "进来了";
			}
			if(month.equals("")&&!name.equals("")){//输入年+姓名，查询该网管本年每个月的记录；
				repairAlyReaults=repairListImpl.alyReapairByYN(year, name);
				//将ArrayList对象转换为Json数组对象
				JSONArray jsonArray=JSONArray.fromObject(repairAlyReaults);
				//输出到页面
				try {
					ResponseUtil.write(jsonArray, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!month.equals("")&&name.equals("")){ //输入年+月，则查询所有网管在该年该月记录；
				repairAlyReaults=repairListImpl.alyReapairByYM(year, month);
				//将ArrayList对象转换为Json数组对象
				JSONArray jsonArray=JSONArray.fromObject(repairAlyReaults);
				//输出到页面
				try {
					ResponseUtil.write(jsonArray, response);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			if(!month.equals("")&&!name.equals("")){ // 当所有数据都输入，则查询单个网管某个月记录
				repairAlyReaults=repairListImpl.alyReapair(year, month, name);
				//将ArrayList对象转换为Json数组对象
				JSONArray jsonArray=JSONArray.fromObject(repairAlyReaults);
				//输出到页面
				try {
					ResponseUtil.write(jsonArray, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
			return "";
		}
	}

}
