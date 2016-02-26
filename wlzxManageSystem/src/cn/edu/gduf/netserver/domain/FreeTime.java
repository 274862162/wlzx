package cn.edu.gduf.netserver.domain;

/**
 * 显示无课情况的类
 * 
 * 比如：FreeTime ft = new FreeTime("mon12", "无课");表示周一一二节没课
 * 
 * @author Hsg
 *
 */
public class FreeTime {

	private String name;
	private String value;
	
	public FreeTime() {
		super();
	}
	
	public FreeTime(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
