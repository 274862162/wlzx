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
    <title>wageManagement2</title>

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
			<div class="personInfo_nav f14">首页&nbsp;&nbsp;>>&nbsp;&nbsp;工资系统&nbsp;&nbsp;>>&nbsp;&nbsp;生成工资单</div>
            <hr/>
            <div class="queryWage superManagement4 superManagement7 wage">
            	<form name="wageManagement-person" method="post" action="">
                	<table>
                        <tr class="head"><td>姓名</td><td>工资总计</td><td>值班迟到</td><td>值班旷班</td><td>保修单逾期</td></tr>
                        <tr><td>陈靖妍</td><td><input type="text" name="11" value="100"></td><td><input type="text" name="12" value="0"></td><td><input type="text" name="13" value="0"></td><td><input type="text" name="14" value="0"></td></tr>
                        <tr><td>吴明姜</td><td><input type="text" name="21" value="100"></td><td><input type="text" name="22" value="100"></td><td><input type="text" name="23" value="100"></td><td><input type="text" name="24" value="100"></td></tr>
                        <tr><td>谭毛女</td><td><input type="text" name="31" value="100"></td><td><input type="text" name="32" value="100"></td><td><input type="text" name="33" value="100"></td><td><input type="text" name="34" value="100"></td></tr>
                        <tr><td>何泗棍</td><td><input type="text" name="41" value="100"></td><td><input type="text" name="42" value="100"></td><td><input type="text" name="43" value="100"></td><td><input type="text" name="44" value="100"></td></tr>
                        <tr><td>吴明姜</td><td><input type="text" name="51" value="100"></td><td><input type="text" name="52" value="100"></td><td><input type="text" name="53" value="100"></td><td><input type="text" name="54" value="100"></td></tr>
                	</table>
                    <div class="changePage">
                        <a href="#">上一页</a>&frasl;
                        <a href="#">下一页</a>
                        <span>第1页，共4页</span>
                    </div>
                    <div class="button sureGenerate"><input type="submit" value="确定生成"/></div>
                    <div class="button"><input type="button" value="取消生成"/></div>
                </form>
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
</html>