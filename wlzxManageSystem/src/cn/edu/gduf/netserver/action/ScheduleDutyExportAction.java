package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.edu.gduf.netserver.util.ExcelUtil;
import cn.edu.gduf.netserver.util.ResponseUtil;
import cn.edu.gduf.netserver.util.StringUtil;

public class ScheduleDutyExportAction implements Action{

	/**
	 * 导出全体无课表
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Workbook wb = new HSSFWorkbook(); // 定义一个新的工作簿
		Sheet sheet = wb.createSheet("值班表");  // 创建第一个Sheet页
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(2, 7000);
		sheet.setColumnWidth(3, 7000);
		sheet.setColumnWidth(4, 7000);
		sheet.setColumnWidth(5, 7000);
		CellStyle cellStyle1 = ExcelUtil.newCellStyle(wb, (short)25, "宋体", 1, 1);
		CellStyle cellStyle2 = ExcelUtil.newCellStyle(wb, (short)16, "宋体", 1, 1);
		CellStyle cellStyle3 = ExcelUtil.newCellStyle(wb, (short)11, "宋体", 0, 2);
		
		String[] title = {"2014--2015学年度第二学期校园网络中心值班表"};
		String headers[] = {"课时","星期一","星期二","星期三","星期四","星期五"};  
		String time12[] = {"8:30——9:30"};
		String time345[] = {"9:35——11:30"};
		String time678[] = {"14:30——17:00"};
		
		String sMon12 = request.getParameter("mon12");
		String sTues12 = request.getParameter("tues12");
		String sWed12 = request.getParameter("wed12");
		String sThurs12 = request.getParameter("thurs12");
		String sFri12 = request.getParameter("fri12");
		String sMon345 = request.getParameter("mon345");
		String sTues345 = request.getParameter("tues345");
		String sWed345 = request.getParameter("wed345");
		String sThurs345 = request.getParameter("thurs345");
		String sFri345 = request.getParameter("fri345");
		String sMon6789 = request.getParameter("mon6789");
		String sTues6789 = request.getParameter("tues6789");
		String sWed6789 = request.getParameter("wed6789");
		String sThurs6789 = request.getParameter("thurs6789");
		String sFri6789 = request.getParameter("fri6789");
		
		sMon12 = StringUtil.changeToUTF8(sMon12);
		sTues12 = StringUtil.changeToUTF8(sTues12);
		sWed12 = StringUtil.changeToUTF8(sWed12);
		sThurs12 = StringUtil.changeToUTF8(sThurs12);
		sFri12 = StringUtil.changeToUTF8(sFri12);
		sMon345 = StringUtil.changeToUTF8(sMon345);
		sTues345 = StringUtil.changeToUTF8(sTues345);
		sWed345 = StringUtil.changeToUTF8(sWed345);
		sThurs345 = StringUtil.changeToUTF8(sThurs345);
		sFri345 = StringUtil.changeToUTF8(sFri345);
		sMon6789 = StringUtil.changeToUTF8(sMon6789);
		sTues6789 = StringUtil.changeToUTF8(sTues6789);
		sWed6789 = StringUtil.changeToUTF8(sWed6789);
		sThurs6789 = StringUtil.changeToUTF8(sThurs6789);
		sFri6789 = StringUtil.changeToUTF8(sFri6789);
		
		String free12[] = {sMon12, sTues12, sWed12, sThurs12, sFri12};
		String free345[] = {sMon345, sTues345, sWed345, sThurs345, sFri345};
		String free6789[] = {sMon6789, sTues6789, sWed6789, sThurs6789, sFri6789};
		
		try {
			ExcelUtil.newCell(sheet, 0, 0, (short)1000, title, cellStyle1, 0, 0, 0, 5);
			ExcelUtil.newCell(sheet, 1, 0, (short)580, headers, cellStyle2, 0, 0, 0, 0);
			ExcelUtil.newCell(sheet, 2, 0, (short)1800, time12, cellStyle2, 0, 0, 0, 0);
			ExcelUtil.newCell(sheet, 3, 0, (short)1800, time345, cellStyle2, 0, 0, 0, 0);
			ExcelUtil.newCell(sheet, 4, 0, (short)1800, time678, cellStyle2, 0, 0, 0, 0);
			ExcelUtil.newCell(sheet, 2, 1, (short)1800, free12, cellStyle3, 0, 0, 0, 0);
			ExcelUtil.newCell(sheet, 3, 1, (short)1800, free345, cellStyle3, 0, 0, 0, 0);
			ExcelUtil.newCell(sheet, 4, 1, (short)1800, free6789, cellStyle3, 0, 0, 0, 0);
			ResponseUtil.export(response, wb, "2014--2015学年度第二学期校园网络中心值班表.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
