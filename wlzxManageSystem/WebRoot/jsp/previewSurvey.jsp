<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 加载jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
%>
<base href= "<%=basePath%>">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by Wmj-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>surveySystem2-未填写</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    	<link rel="stylesheet" type="text/css" href="css/surveySystem.css" />
</head>
<body>
<!--整体包围begin-->
<div class="wrapper margin0_auto">
    <!-- 调查问卷begin -->
    <div class="survey">
    <p class="surveyTitle f17"><c:out value="${sessionScope.qusn.quesnnTitle}" /></p>
        <form name="surveyContent" method="post" action="SurveySystem/SurveySystemQusnServlet?action=addQuestionnaire" class="margin0_auto f14">
       	<% int i=0; %>
        <c:forEach items="${sessionScope.quess}" var="ques">
        <c:if test="${ques.questionType=='SINGLE'}">
        <p class="itemNum"><% i++;out.print(i); %></p>
	        <ul>
	            <li class="title"><c:out value="${ques.questionTitle}" /></li>
	            <li><input type="radio" name="第一题" value=""/>A.<c:out value="${ques.sectionA}" /></li>
	            <li><input type="radio" name="第一题" value=""/>B.<c:out value="${ques.sectionB}" /></li>
	            <li><input type="radio" name="第一题" value=""/>C.<c:out value="${ques.sectionC}" /></li>
	            <li><input type="radio" name="第一题" value=""/>D.<c:out value="${ques.sectionD}" /></li>
	            <li><input type="radio" name="第一题" value=""/>E.<c:out value="${ques.sectionE}" /></li>
	        </ul>
        </c:if>
        <c:choose>
        	<c:when test="${ques.questionType=='MULTIPLE'}">
        	<p class="itemNum"><% i++;out.print(i); %></p>
        	<ul>
	            <li class="title"><c:out value="${ques.questionTitle}" /></li>
	            <li><input type="checkbox" name="第一题" value=""/>A.<c:out value="${ques.sectionA}" /></li>
	            <li><input type="checkbox" name="第一题" value=""/>B.<c:out value="${ques.sectionB}" /></li>
	            <li><input type="checkbox" name="第一题" value=""/>C.<c:out value="${ques.sectionC}" /></li>
	            <li><input type="checkbox" name="第一题" value=""/>D.<c:out value="${ques.sectionD}" /></li>
	            <li><input type="checkbox" name="第一题" value=""/>E.<c:out value="${ques.sectionE}" /></li>
	        </ul>        	
        	</c:when>
        </c:choose>
		</c:forEach>
        <div class="button submitButton">
        	<input type="submit" name="create" value="提交"/>
        	<input type="submit" name="create" value="取消"/>
        </div>
        </form>
    </div>
    <!-- 调查问卷end -->
</div>
<!--整体包围end-->

</body>
</html>