<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="testSession.jsp"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The site is designed by 网络中心.Written by tmn-->
<META http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>checkRepair1查看报修</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/onlineRepair.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/modal.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/webjs/modal.js"></script>
</head>

<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	<!--头部-->
	<webHead:webHead></webHead:webHead>
	<!--头部结束-->
	
	<!--导航-->
	<webNav:webNav></webNav:webNav>
	<!--导航结束-->

	<!--子导航-->
	<div class="subnav margin0_auto">
	<ul class="none_list_style_type display_i">
		<li class="display_i"><span class="none_text_decoration f1768 display_i_b font_huawencaiyun f_blue003399" href="#">网络中心</span></li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="jsp/webjsp/index.jsp">首页</a>&rsaquo;&rsaquo;</li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="jsp/webjsp/onlineRepair1.jsp">网上报修</a></li>
		<form class="subnav_form float_r" action="" method="post">
			<a href="onlineRepairSystem/OnlineRepairServlet?action=exit" class="f12">退出登录</a>
			<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>
	<!--子导航结束-->
	
	<!-- 中部内容begin -->
	<div class="checkRepair">
		<!-- 登录者begin -->
		<div class="loginPerson">
			<img src="images/webimg/repair/person.jpg" title="loginPerson" alt="loginPerson" />
			<p><c:out value="${sessionScope.student.name}" /></p>
			<p><c:out value="${sessionScope.student.sno}" /></p>
		</div>
		<!-- 登录者end -->
		
		<!-- 三个报修项目图片begin -->
		<div class="repairColumn">
			<a href="javascript:;"><img src="images/webimg/repair/view02.png" title="Check Repair" alt="Check Repair" /></a>
			<a href="jsp/webjsp/onlineRepair2.jsp"><img src="images/webimg/repair/repair.png" title="Want To Repair" alt="Want To Repair" /></a>
			<a href="jsp/webjsp/onlineRepair3.jsp"><img src="images/webimg/repair/change.png" title="Change Password" alt="Change Password" /></a>
		</div>
		<!-- 三个报修项目图片end -->
		
		<!-- 查看报修情况表格begin -->
		<div class="viewRepair">
			<table>
				<tr class="head"><td width="240">报修历史</td><td width="110">报修时间</td><td width="110">预约时间</td><td width="80">报修状态</td><td width="110">处理时间</td><td width="300">处理说明</td><td width="50">评分</td><td width="50">操作</td></tr>
				<c:forEach items="${sessionScope.repairLists}" var="repairList">
					<tr><td><c:out value="${repairList.description}" /></td>
					<td style="color:#999;"><c:out value="${repairList.repairTime}" /></td>
					<td style="color:#999;"><c:out value="${repairList.appointmentTime}" /></td>
					<c:if test="${repairList.status=='0'}">
						<td>未处理</td>
					</c:if> 
					<c:if test="${repairList.status=='1'}">
						<td style="color:#99BE4D;">已处理</td>
					</c:if> 					
					<td><c:out value="${repairList.dealingTime}" /></td>
					<td><c:out value="${repairList.dealingText}" /></td>
					<td>
						<c:choose>
							<c:when test="${repairList.status=='0'}">
								评分
							</c:when>
							<c:when test="${not empty repairList.evaluation && repairList.status=='1'}">
								<c:out value="${repairList.evaluation}"></c:out>
							</c:when>
							<c:otherwise>
								<a href="javascript:getID(${repairList.repairListID});" id="recommendedPlan-Button">评分</a>
							</c:otherwise>
						</c:choose>
					</td>
					<td><a href="onlineRepairSystem/OnlineRepairServlet?action=displayRepairList&id=${repairList.repairListID}&userOption=view&place=font">详细</a></td>
					</tr>
				</c:forEach>				
			</table>
			<div class="changePage">
			<c:choose>
				<c:when test="${sessionScope.currentPage==1}">
				<span class="float_l">上一页</span>
				</c:when>
				<c:otherwise>
				<span class="float_l"><a href="onlineRepairSystem/OnlineRepairServlet?action=repairListPaperShow&currentPage=${sessionScope.currentPage-1}">上一页</a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.currentPage==sessionScope.allPage}">
				<span class="float_l">/下一页</span>
				</c:when>
				<c:otherwise>
				<span class="float_l">/<a href="onlineRepairSystem/OnlineRepairServlet?action=repairListPaperShow&currentPage=${sessionScope.currentPage+1}">下一页</a></span>
				</c:otherwise>
			</c:choose>
				<span class="float_r">第<c:out value="${sessionScope.currentPage}" />页，共<c:out value="${sessionScope.allPage}" />页</span>
			</div>
		</div>
		<!-- 查看报修情况表格end -->
	</div>
	<!-- 中部内容end -->
	
	<!-- 评分弹框begin -->
	<div id="recommendedPlan">
		<div class="recommendedPlan-title">评分<img src="images/webimg/repair/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
		<div class="f14 recommendedPlan">
			<form name="score" method="post" action="onlineRepairSystem/OnlineRepairServlet?action=repairEvaluation">
			<input id="frameID" type="hidden" name="frameID" value=""/>
				<div class="grade">
					<input type="radio" value="A" name="grade" />A
					<input type="radio" value="B" name="grade" />B
					<input type="radio" value="C" name="grade" />C
					<input type="radio" value="D" name="grade" />D
				</div>
				<div class="sureButton">
					<input type="submit" value="是" id="submitButton"/>
					<input type="button" value="否" id="cancelClose-button" />
				</div>
			</form>
		</div>
	</div>
	<!-- 评分弹框end -->

	<!-- 弹框时出现的遮罩锁屏画布begin -->
	<div class="modal-canvas" id="modal-canvas"></div>
	<!-- 弹框时出现的遮罩锁屏画布end -->
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--中部包围结束-->

</body>
<script type="text/javascript">
function getID(id){//将报修单ID传递到模态框,以便将ID传递到后台
	var frameIDObj=$("#frameID");
	frameIDObj.val(id);	
	}
</script>
</html>