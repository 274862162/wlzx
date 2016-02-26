package cn.edu.gduf.netserver.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转换类
 * @author hsg
 *
 */
public class DateUtil {

	public static DateFormat dateFormat = null;
	
	/**
	 * 按指定格式将日期转为字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date != null){
			result = sdf.format(date);
		}
		return result;
	}
	
	/**
	 * 按指定格式将字符串转为日期
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date formatString(String str,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	/**
	 * 格式化输出日期
	 * @param date 日期
	 * @param format 格式
	 * @return
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	/**
	 * 返回字符型日期时间
	 * @param date
	 * @return yyyy/MM/dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}
	
	/*// 测试
	public static void main(String[] args) {
		System.out.print(getDateTime(new Date()));
	}
	*/
}
