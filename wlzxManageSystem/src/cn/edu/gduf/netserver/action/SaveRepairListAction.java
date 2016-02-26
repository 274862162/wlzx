package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IRepairListDao;
import cn.edu.gduf.netserver.dao.impl.RepairListDaoImpl;
import cn.edu.gduf.netserver.domain.RepairList;

public class SaveRepairListAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
//		前台传递参数：
//		sno="+sno+"&stuName="+stuName+"&telephone="+telephone
//				+"&appointmentTime="+appointmentTime+"&faultType="+faultType+"&stuArea="+stuArea+"&stuRoom="+stuRoom+"&description="+description
//				+"&repairTime="+time
		try{
		String oldSno=request.getParameter("sno");
		String sno=new String(oldSno.getBytes("iso8859-1"),"UTF-8");
		
		String oldStuName=request.getParameter("stuName");
		String stuName=new String(oldStuName.getBytes("iso8859-1"),"UTF-8");
		
		String oldTelephone=request.getParameter("telephone");
		String telephone=new String(oldTelephone.getBytes("iso8859-1"),"UTF-8");
		
		String oldAppointmentTime=request.getParameter("appointmentTime");
		String appointmentTime=new String(oldAppointmentTime.getBytes("iso8859-1"),"UTF-8");
		
		String oldAppointmentText=request.getParameter("appointmentText");
		String appointmentText=new String(oldAppointmentText.getBytes("iso8859-1"),"UTF-8");
		
		String oldFaultType=request.getParameter("faultType");
		String faultType=new String(oldFaultType.getBytes("iso8859-1"),"UTF-8");
		
		String clientCodeObj=request.getParameter("clientCodeObj");
		String clientCode=new String(clientCodeObj.getBytes("iso8859-1"),"UTF-8");
		
		String errorCodeObj=request.getParameter("errorCodeObj");
		String errorCode=new String(errorCodeObj.getBytes("iso8859-1"),"UTF-8");
		
		String oldStuArea=request.getParameter("stuArea");
		String stuArea=new String(oldStuArea.getBytes("iso8859-1"),"UTF-8");
		
		String oldStuRoom=request.getParameter("stuRoom");
		String stuRoom=new String(oldStuRoom.getBytes("iso8859-1"),"UTF-8");
		
		String oldDescription=request.getParameter("description");
		String description=new String(oldDescription.getBytes("iso8859-1"),"UTF-8");
		
		String oldRepairTime=request.getParameter("repairTime");	
		String repairTime=new String(oldRepairTime.getBytes("iso8859-1"),"UTF-8");
		RepairList repairList=new RepairList();
		repairList.setRepairTime(repairTime);
		repairList.setAppointmentTime(appointmentTime);
		repairList.setTelephone(telephone);
		repairList.setFaultType(faultType);
		repairList.setClientCode(clientCode);
		repairList.setErrorCode(errorCode);
		repairList.setDescription(description);
		repairList.setStatus(0);//0表示报修单未处理
		repairList.setStuSno(sno);
		repairList.setStuName(stuName);
		repairList.setStuBuilding(stuArea);
		repairList.setStuRoom(stuRoom);
		repairList.setDutyPersonID(-1);
		repairList.setAppointmentText(appointmentText);
		IRepairListDao repairImpl=new RepairListDaoImpl();
//		保存报修单信息
		repairImpl.addRepairList(repairList);		
//		System.out.println("学号："+sno+"\n" +
//				" 姓名： "+stuName+"\n" +
//				" 电话： "+telephone+"\n"+
//				" 预约时间： "+appointmentTime+"\n"+
//				"预约备注："+appointmentText+
//				" 错误类型： "+faultType+"\n"+
//				"锐捷客户端错误"+clientCode+
//				"宽带错误代码"+errorCode+
//				" 楼栋： "+stuArea+"\n"+
//				" 房间： "+stuRoom+"\n"+
//				" 描述： "+description+"\n"+
//				" 报修时间： "+repairTime+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "报修成功，我们会尽快为你处理。";
	}

}
