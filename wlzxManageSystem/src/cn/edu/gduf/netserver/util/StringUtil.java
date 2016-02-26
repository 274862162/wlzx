package cn.edu.gduf.netserver.util;

import java.io.UnsupportedEncodingException;

/**
 * 判断是否为空的工具类
 * @author hsg
 * 2015/01/22
 */
public class StringUtil {

	/**
	 * 字串符为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if ("".equals(str) || str == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字串符不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (!"".equals(str) && str != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 将ISO-8859-1转为utf-8
	 * @param str
	 * @return
	 */
	public static String changeToUTF8(String str){
		String newStr = null;
		try {
			newStr = new String(str.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newStr;
	}
}
