package cn.edu.gduf.netserver.domain;

import java.util.List;
/**
 * 
 * @author cjy
 * 这是一个result对象，异步请求时返回
 *
 */
public class Result {
	private int page;//目前处于第几页
	private int totalPage;//一个有几页
	private List list;//列表
	private String message;//其他信息
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
