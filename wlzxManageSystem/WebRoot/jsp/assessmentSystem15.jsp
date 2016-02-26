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
    <title>a15-预览试卷</title>

	<link rel="stylesheet" type="text/css" href="css/assessmentSystem.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>

<body>
<!--整体包围begin-->
<div>
    <!-- 考核试卷begin -->
    <div class="testPaperContent">
        <p class="testPaperContentTitle f17">${paperName}</p>
        <hr />
        <form class="margin0_auto f14">
        <!-- 填空题begin -->
        <div class="blankFilling">
            <ul>
                <li class="title">一、填空题</li>
                <c:forEach var="q" items="${blankFillQuestions}" varStatus="status">
					<li>
						${status.count}.&nbsp;${q.questionTitle }
						<input type="text"/>
					</li>
				</c:forEach>
            </ul>
        </div>
        <!-- 填空题end -->

        <!-- 单选题begin -->
        <div class="choiceQuestion">
            <ul>
                <li class="title">二、单选题</li>
                <c:forEach var="q" items="${singleQuestions}" varStatus="status">
					<li>${status.count}.&nbsp;${q.questionTitle }</li>
					<li>
						<input type="radio"/>${q.sectionA }
					</li>
					<li>
						<input type="radio"/>${q.sectionB }
					</li>
					<li>
						<input type="radio"/>${q.sectionC }
					</li>
					<li>
						<input type="radio"/>${q.sectionD }
					</li>
				</c:forEach>		
            </ul>     
        </div>
        <!-- 单选题end -->
        
        <!-- 多选题begin -->
        <div class="choiceQuestion">
            <ul>
                <li class="title">三、多选题</li>
                <c:forEach var="q" items="${moreQuestions}" varStatus="status">
					<li>${status.count}.&nbsp;${q.questionTitle }</li>
					<li>
						<input type="checkbox"/>${q.sectionA }
					</li>
					<li>
						<input type="checkbox"/>${q.sectionB }
					</li>
					<li>
						<input type="checkbox"/>${q.sectionC }
					</li>
					<li>
						<input type="checkbox"/>${q.sectionD }
					</li>
					<c:if test="${not empty q.sectionE}">
						<li>
							<input type="checkbox"/>${q.sectionE }
						</li>
					</c:if>
				</c:forEach>    
            </ul>           
        </div>
        <!-- 多选题end -->

		<!-- 判断题begin -->
        <div class="judgeQuestion">
            <ul>
                <li class="title">四、判断题</li> 
                <c:forEach var="q" items="${judgeQuestions}" varStatus="status">
					<li>
						${status.count}.&nbsp;${q.questionTitle }
						<input type="radio"/>T
						<input type="radio"/>F
					</li>
				</c:forEach>    
            </ul>           
        </div>
        <!-- 判断题end -->
        
        <!-- 简答题begin -->
        <div class="shortAnswerQuestion">
            <ul>
            	<c:forEach var="q" items="${shortAnswerQuestions}" varStatus="status">
					
				</c:forEach>
                <li class="title">五、简答题</li>
                <c:forEach var="q" items="${shortAnswerQuestions}" varStatus="status">
					<li>
				    	${status.count}.&nbsp;${q.questionTitle }<br/>
						<textarea rows="6" cols="100"></textarea>
					</li>
				</c:forEach>
            </ul>           
        </div>
        <!-- 简答题end -->
        </form>
    </div>
    <!-- 考核试卷end -->
</div>
<!--整体包围end-->

</body>
</html>