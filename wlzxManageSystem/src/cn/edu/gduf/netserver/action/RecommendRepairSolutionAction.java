package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.edu.gduf.netserver.dao.IRepairSolutionDao;
import cn.edu.gduf.netserver.dao.impl.RepairSolutionDaoImpl;
import cn.edu.gduf.netserver.domain.RepairSolution;
import cn.edu.gduf.netserver.util.ResponseUtil;


public class RecommendRepairSolutionAction implements Action {
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
//		var url="onlineRepairSystem/OnlineRepairServlet?action=recommendRepairSolution&faultType="+encodeURI(+faultTypeObj+"&clientCodeObj="+clientCodeObj
//				+"&errorCodeObj="+errorCodeObj);
		String oldFaultType=request.getParameter("faultType");
		String clientCodeObj=request.getParameter("clientCodeObj");
		String errorCodeObj=request.getParameter("errorCodeObj");
		String faultType="";
		String clientCode="";
		String errorCode="";
		try {
			faultType=new String(oldFaultType.getBytes("iso8859-1"),"UTF-8");
			clientCode=new String(clientCodeObj.getBytes("iso8859-1"),"UTF-8");
			errorCode=new String(errorCodeObj.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IRepairSolutionDao solutionImpl=new RepairSolutionDaoImpl();
		ArrayList<RepairSolution> repairSolutions=new ArrayList<RepairSolution>();
		String[] codes=(clientCode+errorCode).split(",");
		for(int i=0;i<codes.length;i++){
			ArrayList<RepairSolution> repairSolution=solutionImpl.selectRepairSolution(codes[i]);
			for(int k=0;k<repairSolution.size();k++){
				repairSolutions.add(repairSolution.get(k));
			}
		}
		//将ArrayList对象转换为Json数组对象
		JSONArray jsonArray=JSONArray.fromObject(repairSolutions);
		//输出到页面
		try {
			ResponseUtil.write(jsonArray, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("客户端提示："+clientCode+"宽带错误："+errorCode);
//		for(int i=0;i<repairSolutions.size();i++){
//			System.out.println("错误信息："+repairSolutions.get(i).getCodeName()+"信息描述："+repairSolutions.get(i).getCodeDescript()+"  解决方法："+repairSolutions.get(i).getSolution());
//		}
		return "";
	}

}
