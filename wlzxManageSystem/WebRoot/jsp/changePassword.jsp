<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="修改用户密码">
    <title>修改密码</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var message = '<%=request.getAttribute("message")%>';
			if(message!=null && message!="" && message!="null"){
				alert(message);
			}	
		});
	</script>

</head>

<body style="height:100%;">
<!--整体包围-->
<div class="wrapper margin0_auto" style="height:100%;">
	<head:header></head:header>
    <nav:nav></nav:nav>

	<!--中部内容区begin-->
	<div class="content" style="height:100%;">
    	<!--左部菜单begin-->
        <div class="menu" style="height:100%;float:left">
            <ul class="none_list_style_type" style="height:100%;">
                <li><a href="jsp/search.jsp"><img alt="" src="images/basicInfo/ico06.png"/><p>快速搜索</p></a></li>
                <li><a href="CommonServlet_forward?action=personInfo&option=check" class="active"><img alt="" src="images/userManage/icon02.png"/><p>个人信息</p></a></li>
                <li><a href="jsp/userManage.jsp"><img alt="" src="images/userManage/icon03.png"/><p>成员信息</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14"><a href="javascript:;">首页</a>&nbsp;&nbsp;>>&nbsp;&nbsp;个人信息</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="CommonServlet_forward?action=personInfo&option=check">基本信息</a></li>
                <li class="f14 float_l"><a href="javascript:;" class="f_blue0066ff">修改密码</a></li>
                <!-- <li class="f14 float_l"><a href="jsp/objectInfo.jsp">物品登记信息</a></li> -->
            </ul>
            <hr/>
            <div class="personInfo_pwd">
                <form name="change" method="post" action="UserServlet?action=changePassword">
            	<ul class="none_list_style_type">
                	<li><label class="f14">原密码 : &nbsp;&nbsp;&nbsp;&nbsp;</label><input type="password" name="password"/></li>
                    <li><label class="f14">新密码 : &nbsp;&nbsp;&nbsp;&nbsp;</label><input type="password" name="newPassword"/></li>
                    <li><label class="f14">再次输入 : &nbsp;</label><input type="password" name="passwordAgain"/></li>
                </ul>
                <div class="personInfo_button_pwd button">
                    <input type="submit" value="修改" />
                    <input type="button" value="返回" onClick="javascript:history.go(-1);" />
                </div>
                </form>
            </div>
        </div>
    	<!--个人信息end-->

    	<!--公告栏begin-->
        <notice:notice></notice:notice>
        <!--公告栏end-->
    </div>
	<!--中部内容区end-->


	<!--脚部begin-->
	<foot:footer></foot:footer>
	<!--脚部end-->
</div>
<!--中部包围结束-->

</body>
</html>