package cn.edu.gduf.netserver.util;

/**
 * 分页工具类
 * @author hsg
 * 2015/01/22
 */
public class PageUtil {

	/**
	 * 上一页下一页
	 * @param totalNum
	 * @param currentPage
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public static String getUpAndDownPage(int totalNum, int currentPage, int pageSize, int type){
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;  // 总页数
		StringBuffer pageCode = new StringBuffer();
		String up = null;
		String down = null;
		if (type == 0) {  // 显示试卷的上下页
			up = "TestPaperServlet?action=testPaperShow&page="+(currentPage-1)+"";
			down = "TestPaperServlet?action=testPaperShow&page="+(currentPage+1)+"";
		}else if (type == 1) {  // 显示考核记录的上下页
			up = "ExamServlet?action=examShow&page="+(currentPage-1)+"";
			down = "ExamServlet?action=examShow&page="+(currentPage+1)+"";
		}
		if(currentPage == 1){
			pageCode.append("<a href='#'>上一页</a>");
		}else{
			pageCode.append("<a href='"+up+"'>上一页</a>");			
		}
		pageCode.append("&frasl;");
		if(currentPage == totalPage){
			pageCode.append("<a href='#'>下一页</a>");
		}else{
			pageCode.append("<a href='"+down+"'>下一页</a>");			
		}
		return pageCode.toString();
	}
	
	/**
	 * 当前页和总页数
	 * @param totalNum
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public static String getCurrentAndTotalPage(int totalNum, int currentPage, int pageSize){
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;  // 总页数
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<span>第"+currentPage+"页");
		pageCode.append("&nbsp;,&nbsp;");
		pageCode.append("共"+totalPage+"页</span>");
		return pageCode.toString();
	}
}
