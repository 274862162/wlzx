<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by Wmj-->
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>a7-选择要查看分析的试卷</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/assessmentSystem.css" />
	<link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>

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
       		<ul class="none_list_style_type">
                <li><a href="TestPaperServlet?action=testPaperDesign"><img alt="" src="images/assessment/design.png"/><p>设计考卷</p></a></li>
                <li><a href="TestPaperServlet?action=testPaperShow"><img alt="" src="images/assessment/online.png"/><p>在线考核</p></a></li>
                <li><a href="ExamServlet?action=examShow1&flag=mark"><img alt="" src="images/assessment/chart.png"/><p>成绩统计</p></a></li>
				<li><a href="ExamServlet?action=examShow1&flag=analyze" class="active"><img alt="" src="images/assessment/aly.png"/><p>考核分析</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">考核系统&nbsp;&nbsp;>>&nbsp;&nbsp;考核分析&nbsp;&nbsp;</div>
            <ul class="none_list_style_type">
            </ul>
            <hr/>
			<div class="dutyRegister repairsManagement">
            	<table style="margin-top:150px;">
                	<tr class="head"><td>考卷</td><td>考核时间</td><td>操作</td></tr>
                    <c:forEach var="ep" items="${examinePapersList}" varStatus="status">
                    	<tr>
                    		<td>${ep.paperName}</td>
                    		<td><fmt:formatDate value="${ep.paperDate}" type="date"/></td>
                    		<td><a href="ExamServlet?action=examAnalyze&paperID=${ep.paperID}&paperName=${ep.paperName}" target="_blank">查看分析</a></td>
                    	</tr>
                    </c:forEach>
                </table>
            </div>
			<div class="changePage">
                ${upDownPage}
                ${currentTotalPage}
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
