package cn.edu.gduf.netserver.util;

import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;


/**
 * 向页面输出内容的类
 * @author hsg
 *
 */
public class ResponseUtil {

	public static void write(Object o,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 输出为excel
	 * @param response 
	 * @param wb Excel中的工作簿
	 * @param fileName 输出的文件名称
	 * @throws Exception
	 */
	public static void export(HttpServletResponse response, Workbook wb, String fileName)throws Exception{
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
		response.setContentType("application/ynd.ms-excel;charset=UTF-8");  // 内容为excel
		OutputStream out=response.getOutputStream();
		wb.write(out);
		out.flush();
		out.close();
	}

}
