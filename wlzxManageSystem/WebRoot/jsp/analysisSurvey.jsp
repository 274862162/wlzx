<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 加载jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <!-- The site is designed by 网络中心.Written by Wmj-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>surveySystem3</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/surveySystem.css" />
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
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
                <li><a href="SurveySystem/SurveySystemQusnServlet?action=fillQuestionnaire"><img alt="" src="images/surveySystem/fullPaper.png"/><p>填写问卷</p></a></li>
                <li><a href="javascript:;" class="active"><img alt="" src="images/surveySystem/alyPaper.png"/><p>调查分析</p></a></li>            
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">调查系统&nbsp;&nbsp;>>&nbsp;&nbsp;调查分析&nbsp;&nbsp;>>&nbsp;&nbsp;<c:out value="${requestScope.qusnList.quesnnTitle}"></c:out>&nbsp;&nbsp;>>&nbsp;&nbsp;调查分析</div>
			<ul class="none_list_style_type paper_title">
            	<li class="f1768 float_l"><a href="javascript:;" class="f_blue0066ff"><c:out value="${requestScope.qusnList.quesnnTitle}"></c:out></a></li>
            </ul>
            <hr/>
            <div class="questionContent3 f14">
            	<div class="headInfo">
                    <span>创建时间：<c:out value="${requestScope.qusnList.quesnnTime}"></c:out></span>   
                    <span class="float_r">共收到答卷<i class="f_blue0066ff f16"><c:out value="${requestScope.qusnList.receiveData}"></c:out></i>份</span>   
                </div>
                <div class="surveyContent">
                <% int i=0; %>
                <c:forEach items="${requestScope.quesList}" var="ques">	
                    <table>
                        <p><% i++;out.print(i+"."); %><c:out value="${ques.questionTitle}"></c:out></p>
                        <tr style="color:#666;"><td>答案选项</td><td>选择人数</td><td width="500">详情</td></tr>  
                        <c:if test="${not empty ques.sectionA}">                     
	                        <tr style="color:#999;"><td><c:out value="${ques.sectionA}"></c:out></td>
	                        	<c:forEach items="${requestScope.quesFindings}" var="finding">
				       				<c:if test="${finding.quesID==ques.ID}">
				       					<td><c:out value="${finding.selectNumA}"></c:out></td>
				       					<td><c:out value="${finding.selectNameA}"></c:out></td>
				       				</c:if>
				       			</c:forEach>
				       		</tr>
			       		</c:if>
			       		<c:if test="${not empty ques.sectionB}">
	                        <tr style="color:#999;"><td><c:out value="${ques.sectionB}"></c:out></td>
	                        	<c:forEach items="${requestScope.quesFindings}" var="finding">
				       				<c:if test="${finding.quesID==ques.ID}">
				       					<td><c:out value="${finding.selectNumB}"></c:out></td>
				       					<td><c:out value="${finding.selectNameB}"></c:out></td>
				       				</c:if>
				       			</c:forEach>
				       		</tr>
			       		</c:if>
			       		<c:if test="${not empty ques.sectionC}">
	                        <tr style="color:#999;"><td><c:out value="${ques.sectionC}"></c:out></td>
	                        	<c:forEach items="${requestScope.quesFindings}" var="finding">
				       				<c:if test="${finding.quesID==ques.ID}">
				       					<td><c:out value="${finding.selectNumC}"></c:out></td>
				       					<td><c:out value="${finding.selectNameC}"></c:out></td>
				       				</c:if>
				       			</c:forEach>
				       		</tr>
			       		</c:if>
			       		<c:if test="${not empty ques.sectionD}">
	                        <tr style="color:#999;"><td><c:out value="${ques.sectionD}"></c:out></td>
	                        	<c:forEach items="${requestScope.quesFindings}" var="finding">
				       				<c:if test="${finding.quesID==ques.ID}">
				       					<td><c:out value="${finding.selectNumD}"></c:out></td>
				       					<td><c:out value="${finding.selectNameD}"></c:out></td>
				       				</c:if>
				       			</c:forEach>
				       		</tr>
			       		</c:if> 
			       		<c:if test="${not empty ques.sectionE}">
	                        <tr style="color:#999;"><td><c:out value="${ques.sectionE}"></c:out></td>
	                        	<c:forEach items="${requestScope.quesFindings}" var="finding">
				       				<c:if test="${finding.quesID==ques.ID}">
				       					<td><c:out value="${finding.selectNumE}"></c:out></td>
				       					<td><c:out value="${finding.selectNameE}"></c:out></td>
				       				</c:if>
				       			</c:forEach>
				       		</tr>
			       		</c:if> 
                    </table>
				</c:forEach>
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