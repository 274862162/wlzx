package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.dao.IPayrollSetDao;
import cn.edu.gduf.netserver.dao.impl.PayrollSetDaoImpl;
import cn.edu.gduf.netserver.domain.PayrollSet;

public class PayRollSetShowAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String option=request.getParameter("option");
		if(option.equals("view")){
			PayrollSet payrollSet=new PayrollSet();
			IPayrollSetDao payDao=new PayrollSetDaoImpl();
			payrollSet=payDao.getPayrollSet();
			request.getSession().setAttribute("payrollSet", payrollSet);
			return "../jsp/queryWage1.1.jsp";
		}else if(option.equals("modify")){
			return "../jsp/queryWage1.jsp";
		}else if(option.equals("update")){
			PayrollSet payrollset=new PayrollSet();
			IPayrollSetDao payDao=new PayrollSetDaoImpl();
			payrollset.setAllMoney(Double.parseDouble(request.getParameter("allMoney"))); 
			payrollset.setLatePerMoney(Double.parseDouble(request.getParameter("latePerMoney"))); 
			payrollset.setNoDutyPerMoney(Double.parseDouble(request.getParameter("noDutyPerMoney"))); 
			payrollset.setIsOverDueMoney(Double.parseDouble(request.getParameter("isOverDueMoney"))); 
			payrollset.setOtherThrowMoney(Double.parseDouble(request.getParameter("otherThrowMoney"))); 
			payrollset.setOtherAddMoney(Double.parseDouble(request.getParameter("otherAddMoney"))); 
			payDao.setPayrollSet(payrollset);
			return "PayRollServlet?action=payRollSetShowAction&option=view";
		}
		return null;
	}

}
