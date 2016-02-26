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
<title>checkRepair3修改密码</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/onlineRepair.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function verify(){
		var originalPassword=$("#originalPassword").val();
		var newPassword=$("#newPassword").val();
		var sureNewPassword=$("#sureNewPassword").val();
		$.get("onlineRepairSystem/OnlineRepairServlet?action=changePasswordFront&originalPassword="
		+originalPassword+"&newPassword="+newPassword+"&sureNewPassword="+sureNewPassword,null,callback);
		function callback(data){
			alert(data);		
		}	
	}
</script>
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
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="jsp/webjsp/onlineRepair3.jsp">网上报修</a></li>
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
			<a href="onlineRepairSystem/OnlineRepairServlet?action=repairListPaperShow&option=showFirstPage"><img src="images/webimg/repair/view.png" title="Check Repair" alt="Check Repair" /></a>
			<a href="jsp/webjsp/onlineRepair2.jsp"><img src="images/webimg/repair/repair.png" title="Want To Repair" alt="Want To Repair" /></a>
			<a href="javascript:;"><img src="images/webimg/repair/change02.png" title="Change Password" alt="Change Password" /></a>
		</div>
		<!-- 三个报修项目图片end -->
		
		<!-- 更改密码文本框begin -->
		<div class="changePassword margin0_auto">
			<p>原密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="originalPassword"/></p>
			<p>新密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="newPassword"/></p>
			<p>确认新密码：<input type="password" id="sureNewPassword"/></p>
			<!--"确定"按钮-->
			<input class="f14 update_pass_btn" type="button" value="确定" onclick="verify()"/>
		</div>
		<!-- 更改密码文本框end -->
	</div>
	<!-- 中部内容end -->

	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--中部包围结束-->

</body>
</html>