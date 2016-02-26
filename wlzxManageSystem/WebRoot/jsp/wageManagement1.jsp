<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>wageManagement1</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/queryWage.css" />
    <link rel="stylesheet" type="text/css" href="css/wageManagement.css" />
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
                <li><a href="javascript:;" class="active">工资管理</a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--工资系统begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">首页&nbsp;&nbsp;>>&nbsp;&nbsp;工资系统</div>
            <hr/>
            <!--学期工资管理begin-->
            <div class="queryWage wage">
            	<form name="wageManagement_term" method="post" action="">
                    <div class="search">
                        学期
                        <select name="limitKind">
                            <option value="1314_1">2013-2014学年第一学期</option>
                            <option value="1314_2">2013-2014学年第二学期</option>
                            <option value="1415_1">2014-2015学年第一学期</option>
                            <option value="1415_2">2014-2015学年第二学期</option>
                        </select>
                        <div class="button"><input type="button" value="查询"></div>
                    </div>
                    <div>
                    	<table>
                            <tr><td>时间</td><td>操作</td></tr>
                            <tr><td>2013年9月</td><td><a href="javascript:;">查看工资单</a></td></tr>
                            <tr><td>2013年10月</td><td><a href="javascript:;">查看工资单</a></td></tr>
                            <tr><td>2013年11月</td><td><a href="javascript:;">查看工资单</a></td></tr>
                            <tr><td>2013年12月</td><td><a href="javascript:;">查看工资单</a></td></tr>
                        </table>
                    </div>
                    <div class="changePage">
                        <a href="#">上一页</a>&frasl;
                        <a href="#">下一页</a>
                        <span>第1页，共4页</span>
                    </div>
                    <br/>
                    <div class="button generate-month-wage"><input type="submit" value="生成本月工资单"/></div>
                </form>
            </div>
            <!--学期工资管理end-->
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
</html>