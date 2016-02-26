<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
    <title>13-批改中/查看</title>

	<link rel="stylesheet" type="text/css" href="css/assessmentSystem.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>

<body>
<!--整体包围begin-->
<div>
    <!-- 考核试卷begin -->
    <div class="testPaperContent">
        <!-- 考试时间及剩余时间begin -->
        <div class="testTime f14">
            <p>单选题得分：${examine.singleScore}</p>
            <p>多选题得分：${examine.moreScore}</p>
            <p>判断题得分：${examine.judgeScore}</p>
            <p>填空题得分：${examine.blankFillScore}</p>
            <p>简答题得分：${examine.shortAnswerScore}</p>
        </div>
        <!-- 考试时间及剩余时间end -->

		<p class="testPaperContentTitle">姓名：${user.name}&nbsp;&nbsp;&nbsp;&nbsp;部门：${user.section}</p>
        <p class="testPaperContentTitle f17">${testPaper.paperName}</p>
        <form id="paperForm" action="ExamServlet?action=examScore&examineID=${examine.examineID}" method="post" class="margin0_auto f14">
		<input type="hidden" name="examineID" value="${examine.examineID }"/>
		<input type="hidden" name="page" value="${page}"/>
        <!-- 填空题begin -->
        <div class="blankFilling">
            <ul>
                <li class="title">一、填空题（每题${blankFillQuestionMarks[0].question.point}分，共${blankFillScore}分）</li>
                <c:forEach var="qm" items="${blankFillQuestionMarks}" varStatus="status">
					<li>
						${status.count}.&nbsp;${qm.question.questionTitle }
						<input type="text" value="${qm.answer}" readonly="readonly"/>&nbsp;&nbsp;得分：
						<select name="id-b-${qm.questionMarkID}" class="f_blue0066ff">
							<c:forEach begin="0" end="${qm.question.point}" var="v">
								<c:choose>
									<c:when test="${v eq qm.mark}">
										<option value="${v}" selected="selected">${v}分</option>
									</c:when>
									<c:otherwise>
										<option value="${v}">${v}分</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</li>
				</c:forEach>
            </ul>
        </div>
        <!-- 填空题end -->

        <!-- 简答题begin -->
        <div class="shortAnswerQuestion">
            <ul>
                <li class="title">五、简答题（共${shortAnswerScore}分）</li>
                <c:forEach var="qm" items="${shortAnswerQuestionMarks}" varStatus="status">
					<li>
				    	${status.count}.&nbsp;${qm.question.questionTitle }(${qm.question.point}分)&nbsp;&nbsp;得分：
				    	<select name="id-sa-${qm.questionMarkID}" class="f_blue0066ff">
							<c:forEach begin="0" end="${qm.question.point}" var="v">
								<c:choose>
									<c:when test="${v eq qm.mark}">
										<option value="${v}" selected="selected">${v}分</option>
									</c:when>
									<c:otherwise>
										<option value="${v}">${v}分</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
				    	<br/>
						<textarea rows="6" cols="100" readonly="readonly">${qm.answer}</textarea>
					</li>
				</c:forEach>
            </ul>           
        </div>
        <!-- 简答题end -->
        <div class="button"><input type="submit" value="提交批改"/></div>
        </form>
    </div>
    <!-- 考核试卷end -->
</div>
<!--整体包围end-->

</body>
</html>