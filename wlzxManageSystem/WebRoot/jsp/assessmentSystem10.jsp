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
    <title>a10-正在考核</title>

	<link rel="stylesheet" type="text/css" href="css/assessmentSystem.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<script type="text/javascript" src="js/assessmentSystem.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>

<body>
<!--整体包围begin-->
<div>
    <!-- 考核试卷begin -->
    <div class="testPaperContent">
        <!-- 考试时间及剩余时间begin -->
        <div class="testTime f14">
            <p>考核时间：60分钟</p>
            <p>剩余时间：<font id="remainTime"></font></p>
        </div>
        <!-- 考试时间及剩余时间end -->
	
		<p class="testPaperContentTitle">姓名：${currentUser.name}&nbsp;&nbsp;&nbsp;&nbsp;部门：${currentUser.section}</p>
        <p class="testPaperContentTitle f17">${testPaper.paperName}</p>
        <form id="paperForm" action="ExamServlet?action=examSubmit" method="post" class="margin0_auto f14">
        <input type="hidden" name="userID" value="${currentUser.userID}"/>
		<input type="hidden" name="testPaperID" value="${testPaper.paperID}"/>
        <!-- 填空题begin -->
        <div class="blankFilling">
            <ul>
                <li class="title">一、填空题（每题${blankFillQuestions[0].point}分，共${blankFillScore}分）</li>
                <c:forEach var="q" items="${blankFillQuestions}" varStatus="status">
					<li>
						${status.count}.&nbsp;${q.questionTitle }
						<input type="text" name="id-b-${q.questionID }" placeholder="填写答案" /> 
					</li>
				</c:forEach>
            </ul>
        </div>
        <!-- 填空题end -->

        <!-- 单选题begin -->
        <div class="choiceQuestion">
            <ul>
                <li class="title">二、单选题（每题${singleQuestions[0].point}分，共${singleScore}分）</li>
                <c:forEach var="q" items="${singleQuestions}" varStatus="status">
					<li>${status.count}.&nbsp;${q.questionTitle }</li>
					<li>
						<input type="radio" name="id-s-${q.questionID }" value="A"/>
						${q.sectionA }
					</li>
					<li>
						<input type="radio" name="id-s-${q.questionID }" value="B"/>
						${q.sectionB }
					</li>
					<li>
						<input type="radio" name="id-s-${q.questionID }" value="C"/>
						${q.sectionC }
					</li>
					<li>
						<input type="radio" name="id-s-${q.questionID }" value="D"/>
						${q.sectionD }
					</li>
				</c:forEach>		
            </ul>     
        </div>
        <!-- 单选题end -->
        
        <!-- 多选题begin -->
        <div class="choiceQuestion">
            <ul>
                <li class="title">三、多选题（每题${moreQuestions[0].point}分，共${moreScore}分，多选漏选均不得分）</li>
                <c:forEach var="q" items="${moreQuestions}" varStatus="status">
					<li>${status.count}.&nbsp;${q.questionTitle }</li>
					<li>
						<input type="checkbox" name="id-m-${q.questionID }" value="A"/>
						${q.sectionA }
					</li>
					<li>
						<input type="checkbox" name="id-m-${q.questionID }" value="B"/>
						${q.sectionB }
					</li>
					<li>
						<input type="checkbox" name="id-m-${q.questionID }" value="C"/>
						${q.sectionC }
					</li>
					<li>
						<input type="checkbox" name="id-m-${q.questionID }" value="D"/>
						${q.sectionD }
					</li>
					<c:if test="${not empty q.sectionE}">
						<li>
							<input type="checkbox" name="id-m-${q.questionID }" value="E"/>
							${q.sectionE }
						</li>
					</c:if>
				</c:forEach>    
            </ul>           
        </div>
        <!-- 多选题end -->

		<!-- 判断题begin -->
        <div class="judgeQuestion">
            <ul>
                <li class="title">四、判断题（每题${judgeQuestions[0].point}分，共${judgeScore}分）</li> 
                <c:forEach var="q" items="${judgeQuestions}" varStatus="status">
					<li>
						${status.count}.&nbsp;${q.questionTitle }
						<input type="radio" name="id-j-${q.questionID }" value="T"/>T
						<input type="radio" name="id-j-${q.questionID }" value="F"/>F
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
                <li class="title">五、简答题（共${shortAnswerScore}分）</li>
                <c:forEach var="q" items="${shortAnswerQuestions}" varStatus="status">
					<li>
				    	${status.count}.&nbsp;${q.questionTitle }(${q.point}分)<br/>
						<textarea rows="6" cols="100" name="id-sa-${q.questionID }" placeholder="填写答案"></textarea>
					</li>
				</c:forEach>
            </ul>
        </div>
        <!-- 简答题end -->

        <div class="button"><input type="submit" value="交卷" onclick="submitPaper();"/></div>
        </form>
    </div>
    <!-- 考核试卷end -->
</div>
<!--整体包围end-->

</body>
</html>