<%@page import="cn.edu.gduf.netserver.domain.QusnnList"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by Wmj-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>surveySystem1</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/surveySystem.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
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
                <li><a href="javascript:;" class="active"><img alt="" src="images/surveySystem/designPaper.png"/><p>设计问卷</p></a></li>
                <li><a href="SurveySystem/SurveySystemQusnServlet?action=fillQuestionnaire"><img alt="" src="images/surveySystem/fullPaper.png"/><p>填写问卷</p></a></li>
                <li><a href="javascript:;"><img alt="" src="images/surveySystem/alyPaper.png"/><p>调查分析</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">调查系统&nbsp;&nbsp;>>&nbsp;&nbsp;设计调查问卷</div>
            <hr/>
            <!-- 表格内容begin -->
            <div class="surveyDesign">
            <div class="button newPaper"><input type="button" value="+新建问卷" onClick="window.location.href=&apos;jsp/newSurvey.jsp&apos;" /></div>
            <div class="questionContent">
            <table>
                	<tr class="head"><td>问卷标题</td><td>创建时间</td><td>状态</td><td>收到数据</td><td>操作</td></tr>
                	
                	<c:forEach items="${requestScope.qusnnLists}" var="qusnnList">
                		<tr>
                			<td><c:out value="${qusnnList.quesnnTitle}" /></td>
                			<td><c:out value="${qusnnList.quesnnTime}" /></td>
                			<td>
                			<!-- 根据后台qusnnStatus数据确定下拉列表选中状态 -->
                			<form name="${qusnnList.qusnnID}" action="SurveySystem/SurveySystemQusnServlet?action=updateQusnStatus&qusnID=${qusnnList.qusnnID}" method="post">                				
                        		<select name="status">                        		
                        		<c:if test="${qusnnList.qusnnStatus=='UNPUBLISHED'}"> 
                        		    <option value="UNPUBLISHED" selected="selected">未发布</option>
		                            <option value="COLLECTING">收集中</option>
		                            <option value="FINISHED">已结束</option>           
								</c:if>
								<c:if test="${qusnnList.qusnnStatus=='COLLECTING'}"> 
                        		    <option value="UNPUBLISHED">未发布</option>
		                            <option value="COLLECTING" selected="selected">收集中</option>
		                            <option value="FINISHED">已结束</option>   
								</c:if>
								<c:if test="${qusnnList.qusnnStatus=='FINISHED'}">
		                            <option value="FINISHED" selected="selected" disabled="disabled">已结束</option>            
								</c:if>
                        		</select>
                        	</form>
                    		</td>
                    		<td><c:out value="${qusnnList.receiveData}" /></td>
                    		<c:choose>
                    			<c:when test="${qusnnList.qusnnStatus=='FINISHED'}">
                    				<td><a href="SurveySystem/SurveySystemQusnServlet?action=alyQuestionnaire&id=${qusnnList.qusnnID}">结果分析</a>
                    			</c:when>
                    			<c:otherwise>
                    				<td>结果分析
                    			</c:otherwise>
                    		</c:choose>
                    		<a href="SurveySystem/SurveySystemQusnServlet?action=delQuestionnaire&id=${qusnnList.qusnnID}">删除</a></td></tr>
                    		</tr>
                	</c:forEach>
                </table>                
                    <div class="changePage">
                    <c:choose>
                    	<c:when test="${sessionScope.currentPage==1}">
                    	上一页&frasl;
                    	</c:when>
                    	<c:otherwise>
                    	 <a href="SurveySystem/SurveySystemQusnServlet?action=surveyPage&currentPage=${sessionScope.currentPage-1}">上一页</a>&frasl;
                    	</c:otherwise>
                    </c:choose>
                    <c:choose>
                    	<c:when test="${sessionScope.currentPage==sessionScope.allPage}">
                    	下一页
                    	</c:when>
                    	<c:otherwise>
                    	 <a href="SurveySystem/SurveySystemQusnServlet?action=surveyPage&currentPage=${sessionScope.currentPage+1}">下一页</a>
                    	</c:otherwise>
                    </c:choose>
                    <span>第<c:out value="${sessionScope.currentPage}" />页，共<c:out value="${sessionScope.allPage}" />页</span>
                </div>
            </div>
            <!-- 表格内容end -->
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
<script type="text/javascript">
	var statusChange=document.getElementsByName("status");
	for(var i=0;i<statusChange.length;i++){
		var formElement;
		statusChange[i].onchange=function(){
		//formElement=statusChange[i].parentNode;
		//alert(formElement.getAttribute("name"));
		this.parentNode.submit();
		}
	}
</script>
</html>