<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <title>a5-选择考生进行批改</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/assessmentSystem.css" />
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
                <li><a href="TestPaperServlet?action=testPaperDesign">设计考卷</a></li>
                <li><a href="TestPaperServlet?action=testPaperShow">在线考核</a></li>
                <li><a href="ExamServlet?action=examShow1&flag=mark" class="active">成绩统计</a></li>
				<li><a href="ExamServlet?action=examShow1&flag=analyze">考核分析</a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">考核系统&nbsp;&nbsp;>>&nbsp;&nbsp;成绩统计&nbsp;&nbsp;>>&nbsp;&nbsp;批改</div>
            <ul class="none_list_style_type">
                <li class="f14 float_l">试卷：<span class="f_blue0066ff">${paperName}</span></li>
            </ul>
            <hr/>
			<div class="assessmentContent assessmentContent2">
            	<table>
                	<tr><th>考生</th><th width="220">操作</th></tr>
                    <c:forEach var="e" items="${examinesList}" varStatus="status">
                    	<tr>
                    		<td>${e.user.name}</td>
                    		<td>
                    			<!--显示分数-->
                    			<c:choose>
									<c:when test="${e.shortAnswerScore!=0}">
                    					${e.score}分&nbsp;&nbsp;&nbsp;
                    					<a href="ExamServlet?action=examMark&examineID=${e.examineID}">查看</a>					
									</c:when>
									<c:otherwise>
										<a href="ExamServlet?action=examMark&examineID=${e.examineID}">进行批改</a>
									</c:otherwise>
								</c:choose>
                    		</td>
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
