<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
%>
<base href= "<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>个人报修单</title>
    
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
</head>
<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	<head:header></head:header>
    <nav:nav></nav:nav>
	<!--中部内容区begin-->
	<div class="content">
    	<!--左部菜单begin-->
        <div class="menu">
            <ul class="none_list_style_type">
                <li><a class="repair_ico active" href="javascript:;"><img alt="" src="images/onlineRepair/repair_ico.png"/><p>网络报修</p></a></li>
                <li><a class="anly_ico" href="onlineRepairSystem/OnlineRepairServlet?action=alyRepairList&option=initName"><img alt="" src="images/onlineRepair/anly_ico.png"/><p>报修统计</p></a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--工资系统begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">报修系统&nbsp;&nbsp;>>&nbsp;&nbsp;网络报修</div>
            <ul class="none_list_style_type">
                <li class="f14 float_l"><a href="javascript:;" class="f_blue0066ff">个人报修单</a></li>
                <li class="f14 float_l"><a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage&option=showAllRepairLists">全部报修单</a></li>
            </ul>   
            <hr/>
            <div class="dutyRegister repairsManagement">
                <div class="pn">
                <a href="javascript:;"><img src="images/dutyRegister/output.png" alt="导出" title="导出"/></a>
                <a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage&userCurrentPage=1"><img src="images/dutyRegister/first.png" alt="第一页" title="第一页"/></a>
                <c:choose>
                  <c:when test="${sessionScope.userCurrentPage==1}">
                  	<img src="images/dutyRegister/previous.png" alt="上一页" title="上一页"/>&nbsp;&nbsp;&nbsp;
                  </c:when>
                  <c:otherwise>
                  	<a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage&userCurrentPage=${sessionScope.userCurrentPage-1}"><img src="images/dutyRegister/previous.png" alt="上一页" title="上一页"/></a>&nbsp;&nbsp;&nbsp;
                  </c:otherwise>               
                </c:choose>
                <c:choose>
                  <c:when test="${sessionScope.userCurrentPage==sessionScope.userAllpage}">
                  	<img src="images/dutyRegister/next.png" alt="下一页" title="下一页"/>
                  </c:when>
                  <c:otherwise>
                  	<a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage&userCurrentPage=${sessionScope.userCurrentPage+1}"><img src="images/dutyRegister/next.png" alt="下一页" title="下一页"/></a>
                  </c:otherwise>               
                </c:choose>      
                <a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage&userCurrentPage=${sessionScope.userAllpage}"><img src="images/dutyRegister/last.png" alt="最后一页" title="最后一页"/></a>

                    	当前为第<input type="text" id="userCurrentPage" value="${sessionScope.userCurrentPage}" placeholder="1"/>/<c:out value="${sessionScope.userAllpage}" />页&nbsp;&nbsp;每页 
                <div class="right_form">
                <form action="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage" method="post">
                    <select name="userPageSize">
                    	<c:if test="${sessionScope.userPageSize==5}">
                    		<option value="5" selected="selected">5</option>
                       		<option value="20">20</option>
                        	<option value="50">50</option>
                        	<option value="100">100</option>
                    	</c:if>
                       	<c:if test="${sessionScope.userPageSize==20}">
                    		<option value="5">5</option>
                       		<option value="20" selected="selected">20</option>
                        	<option value="50">50</option>
                        	<option value="100">100</option>
                    	</c:if>
                    	<c:if test="${sessionScope.userPageSize==50}">
                    		<option value="5">5</option>
                       		<option value="20">20</option>
                        	<option value="50" selected="selected">50</option>
                        	<option value="100">100</option>
                    	</c:if>
                    	<c:if test="${sessionScope.userPageSize==100}">
                    		<option value="5">5</option>
                       		<option value="20">20</option>
                        	<option value="50">50</option>
                        	<option value="100" selected="selected">100</option>
                    	</c:if>
                    </select>
                  </form>条
				</div>
                </div>
                
				<table>
                    <tr class="head"><td>报修时间</td><td>距到期</td><td>故障描述</td><td>住址</td><td>姓名</td><td>处理状态</td><td>操作</td></tr>
                    <c:forEach items="${sessionScope.userRepairLists}" var="userRrepairList">
	                    <tr>
	                    	<td><c:out value="${userRrepairList.repairTime}" /></td>
	                    	<td>
	                    		<c:if test="${userRrepairList.isOverdue=='0'}">
	                    			3天
	                    		</c:if>
	                    		<c:if test="${userRrepairList.isOverdue=='1'}">
	                    			2天
	                    		</c:if>
	                    		<c:if test="${userRrepairList.isOverdue=='2'}">
	                    			1天
	                    		</c:if>
	                    		<c:if test="${userRrepairList.isOverdue=='3'}">
	                    			0天
	                    		</c:if>
	                    		<c:if test="${userRrepairList.isOverdue>'3'}">
	                    			已过期
	                    		</c:if>	                    	
	                    	</td>
	                    	<td><c:out value="${userRrepairList.description}" /></td>
	                    	<td><c:out value="${userRrepairList.stuBuilding}" /><c:out value="${userRrepairList.stuRoom}" /></td>
	                    	<td><c:out value="${userRrepairList.stuName}" /></td>
	                    	<c:if test="${userRrepairList.status=='0'}">
								<td>未处理</td>
								<td>
									<a href="onlineRepairSystem/OnlineRepairServlet?action=displayRepairList&id=${userRrepairList.repairListID}&userOption=deal"><img src="images/dutyRegister/handle.png" title="处理" alt="处理"/></a>
									<a href="onlineRepairSystem/OnlineRepairServlet?action=displayRepairList&id=${userRrepairList.repairListID}&userOption=del"><img src="images/dutyRegister/del.png" title="删除" alt="删除"/></a>
								</td>
							</c:if> 
							<c:if test="${userRrepairList.status=='1'}">
								<td>已处理</td>
								<td>
									<a href="onlineRepairSystem/OnlineRepairServlet?action=displayRepairList&id=${userRrepairList.repairListID}&userOption=view&place=back"><img src="images/dutyRegister/check.png" title="查看" alt="查看"/></a>
									<a href="onlineRepairSystem/OnlineRepairServlet?action=displayRepairList&id=${userRrepairList.repairListID}&userOption=del"><img src="images/dutyRegister/del.png" title="删除" alt="删除"/></a>
								</td>
							</c:if> 
		                </tr>
                    </c:forEach>
                </table>
            </div>
        </div>	
    	<!--工资系统end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!-- 脚部 -->
    <foot:footer></foot:footer>
</div>
<!--中部包围结束-->

</body>
<script type="text/javascript">
	var statusChange=document.getElementsByName("userPageSize");
	statusChange[0].onchange=function(){
	this.parentNode.submit();
	}
</script>
</html>