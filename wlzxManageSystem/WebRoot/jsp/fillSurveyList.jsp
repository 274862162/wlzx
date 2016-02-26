<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
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
    <title>surveySystem2</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/surveySystem.css" />
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
                <li><a href="SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire"><img alt="" src="images/surveySystem/designPaper.png"/><p>设计问卷</p></a></li>
                <li><a href="javascript:;" class="active"><img alt="" src="images/surveySystem/fullPaper.png"/><p>填写问卷</p></a></li>
                <li><a href="javascript:;"><img alt="" src="images/surveySystem/alyPaper.png"/><p>调查分析</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">调查系统&nbsp;&nbsp;>>&nbsp;&nbsp;填写调查问卷</div>
            <hr/>
            <div class="questionContent fillContent">
            	<table>
                	<tr class="head"><td>问卷列表</td><td width="150">发布时间</td><td width="80">创建人</td><td width="180">操作</td></tr>
                	<c:forEach items="${requestScope.qusnnLists}" var="qusnnList">
                		 <tr>
                		 	<td><c:out value="${qusnnList.quesnnTitle}" /></td>
                		 	<td><c:out value="${qusnnList.quesnnTime}" /></td>
                		 	<td width="80"><c:out value="${qusnnList.userID}" /></td>
                		 	<c:if test="${qusnnList.fillStatus=='false'}">
                		 		<td><a href="SurveySystem/SurveySystemQusnServlet?action=displayQuestionnaire&id=${qusnnList.qusnnID}&status=fill">填写</a></td>
                		 	</c:if>
                		 	<c:if test="${qusnnList.fillStatus=='true'}">
                		 		<td>已填写</td>
                		 	</c:if>
                		 	</tr>                	
                	</c:forEach>
                </table>
                <div class="changePage">
                    <c:choose>
                    	<c:when test="${sessionScope.currentPage==1}">
                    	上一页&frasl;
                    	</c:when>
                    	<c:otherwise>
                    	 <a href="SurveySystem/SurveySystemQusnServlet?action=collectSurveyPage&currentPage=${sessionScope.currentPage-1}">上一页</a>&frasl;
                    	</c:otherwise>
                    </c:choose>
                    <c:choose>
                    	<c:when test="${sessionScope.currentPage==sessionScope.allPage}">
                    	下一页
                    	</c:when>
                    	<c:otherwise>
                    	 <a href="SurveySystem/SurveySystemQusnServlet?action=collectSurveyPage&currentPage=${sessionScope.currentPage+1}">下一页</a>
                    	</c:otherwise>
                    </c:choose>
                    <span>第<c:out value="${sessionScope.currentPage}" />页，共<c:out value="${sessionScope.allPage}" />页</span>
                </div>
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