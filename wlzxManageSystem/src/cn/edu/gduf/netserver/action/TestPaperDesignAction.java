package cn.edu.gduf.netserver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPaperDesignAction implements Action{

	/**
	 * 进入设计试卷页面
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "testPaperDesign";
	}

}
