package cn.edu.gduf.netserver.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取Properties配置文件的工具类
 * @author hsg
 *
 */
public class PropertiesUtil {

	/**
	 * 读取wlzxManageSystem.properties文件，通过key得到value
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		Properties prop = new Properties();
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/wlzxManageSystem.properties");
		try {
			prop.load(in);  // 从输入流中读取属性列表
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String)prop.get(key);
	}
}
