<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>superManagement23</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/queryWage.css" />
    <link rel="stylesheet" type="text/css" href="css/superManagement4.css" />
    <link rel="stylesheet" type="text/css" href="css/analyze.css" />
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
                <li><a href="SuperManagementServlet?action=roleShow">角色管理</a></li>
                <li><a href="SuperManagementServlet?action=userRoleShow">设置用户角色</a></li>
                <li><a href="SuperManagementServlet?action=webNoticeShow">前台管理</a></li>
                <li><a href="SuperManagementServlet?action=userShow" class="active">后台管理</a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo superManagement20">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;后台管理</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="jsp/superManagement9.jsp">网管账号管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement10.jsp" class="f_blue0066ff">报修系统管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement13.jsp">公告管理</a></li>
                <br/>
                <span class="f14">
                    <a href="jsp/superManagement10.jsp">楼栋管理 &nbsp;</a>
                    <a href="jsp/superManagement11.jsp">用户管理 &nbsp;</a>
                    <a href="jsp/superManagement12.jsp" class="f_blue0066ff">统计分析</a>
                </span>
            </ul>   
            <hr/>
             <div class="superManagement4 analyze">
               <form>
                    <span>楼栋:<input type="text" name="buildingNumber"/></span>
                    <span>时间:<input type="text" name="startTime"/>--<input type="text" name="endTime"></span>
                    <span>报修内容:<input type="text" name="content"/></span>
                    <span>维修人员:<input type="text" name="responsePerson"/></span>
                    <div class="button"><input type="button" value="分析"></div>
                    <img src="images/superManagement/superManegement23.png" alt="analyze" title="analyze"/>
               </form>
            </div>
        </div>	
    	<!--个人信息end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!-- 脚部 -->
    <foot:footer></foot:footer>
</div>
<!--中部包围结束-->

</body>
</html>