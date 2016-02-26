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
    <title>填写问卷</title>

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
    	<% int i=0; %>
        <form name="surveyContent" method="post" action="SurveySystem/SurveySystemQusnServlet?action=displayQuestionnaire" class="margin0_auto f14">
        <c:forEach items="${sessionScope.quess}" var="ques">
	        <c:if test="${ques.questionType=='SINGLE'}">
	        <p class="itemNum"><% i++;out.print(i); %></p>
		        <ul>	        	
		            <li class="title"><c:out value="${ques.questionTitle}" /></li>
			        <li><input type="radio" name="sinResult" value="A"/>A.<c:out value="${ques.sectionA}" /></li>
			        <li><input type="radio" name="sinResult" value="B"/>B.<c:out value="${ques.sectionB}" /></li>
			        <li><input type="radio" name="sinResult" value="C"/>C.<c:out value="${ques.sectionC}" /></li>
			        <li><input type="radio" name="sinResult" value="D"/>D.<c:out value="${ques.sectionD}" /></li>
			        <li><input type="radio" name="sinResult" value="E"/>E.<c:out value="${ques.sectionE}" /></li>
		        </ul>
	        </c:if>
	        <c:choose>
	        	<c:when test="${ques.questionType=='MULTIPLE'}">
	        	<p class="itemNum"><% i++;out.print(i); %></p>
	        	<ul>
		            <li class="title"><c:out value="${ques.questionTitle}" /></li>
		            <li><input type="checkbox" name="mulResult" value="A"/>A.<c:out value="${ques.sectionA}" /></li>
		            <li><input type="checkbox" name="mulResult" value="B"/>B.<c:out value="${ques.sectionB}" /></li>
		            <li><input type="checkbox" name="mulResult" value="C"/>C.<c:out value="${ques.sectionC}" /></li>
		            <li><input type="checkbox" name="mulResult" value="D"/>D.<c:out value="${ques.sectionD}" /></li>
		            <li><input type="checkbox" name="mulResult" value="E"/>E.<c:out value="${ques.sectionE}" /></li>
		        </ul>        	
	        	</c:when>
	        </c:choose>
		</c:forEach>
		<!-- 隐藏域获取客户端时间 -->
		<input id="time" type="hidden" name="client-time" value="2015-01-01"/>
        <div class="button submitButton">
        	<input type="submit" name="status" value="提交"/>
        	<input type="submit" name="status" value="取消"/>
        </div>
        </form>
    </div>
    <!-- 调查问卷end -->
</div>
<!--整体包围end-->

</body>
<script type="text/javascript">
	//获取客户端提交时间
   	var date = new Date();
   	var year = date.getFullYear();
   	var month = date.getMonth()+1;
   	var day = date.getDate();
   	var h=date.getHours();
   	var m=date.getMinutes();
	var s=date.getSeconds();
	var time=year+"-"+month+"-"+day+"-"+h+":"+m+":"+s;    	
    var timeElement=document.getElementById("time");	
		timeElement.setAttribute("value",time);	
	//使单选题name属性改变
	var sinUlElements=document.getElementsByTagName("ul");
	for(var i=0;i<sinUlElements.length;i++){
		var sinLiElements=sinUlElements[i].getElementsByTagName("li");
		for(var j=1;j<6;j++){
			var sinInpElements=sinLiElements[j].getElementsByTagName("input");
			sinInpElements[0].setAttribute("name","result"+i);
		}
	}
</script>
</html>