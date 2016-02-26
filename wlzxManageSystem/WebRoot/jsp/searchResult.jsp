<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by hsg-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>searchResult</title>
	<%   
		String path = request.getContextPath();   
		String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
	%>   
	<base href= "<%=basePath%>">  
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	<% 
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间
		session.setAttribute("time", currentTime);
	%>
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
            <ul class="none_list_style_type" style="height:100%;">
                <li><a href="jsp/search.jsp" class="active"><img alt="" src="images/basicInfo/ico06.png"/><p>快速搜索</p></a></li>
                <li><a href="CommonServlet_forward?action=personInfo&option=check"><img alt="" src="images/userManage/icon02.png"/><p>个人信息</p></a></li>
                <li><a href="jsp/userManage.jsp"><img alt="" src="images/userManage/icon03.png"/><p>成员信息</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--搜索区begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14"><a href="search">首页</a>&nbsp;&nbsp;>>&nbsp;&nbsp;快速搜索</div>
            <form action="SearchServlet?action=search" method="post">
	            <div class="search_content">
	            	<input name="searchContent" type="text"/><input type="submit" class="f14" value="搜索" />
	            </div>
	            <div class="search_type">
	                <label><input type="radio" name="searchType" value="repArea" checked/>负责区域</label>
	                <label><input type="radio" name="searchType" value="dormitory" />住址</label>
	                <label><input type="radio" name="searchType" value="telNum" />电话号码</label>
	            </div>
            </form>
            <div class="dutyRegister repairsManagement">
            <span class="f14" style="font-size:16px;line-height: 50px;">搜索结果共<em style="color:#fbb217;font-size: 18px;"><c:out value="${fn:length(requestScope.searchUsers)}"/></em>条</span>
                <table id="tb_dutyRegister">
                    <tr class="head"><td>姓名</td><td>学号</td><td>住址 </td><td>负责楼栋</td><td>部门 </td><td>电话</td></tr>
                    <c:forEach items="${requestScope.searchUsers}" var="searchUser">
                	<tr>
                		<td><c:out value="${searchUser.name}" /></td>
                		<td><c:out value="${searchUser.sno }"/></td>
				       <td><c:out value="${searchUser.dormitory }"/></td>
				       <td><c:out value="${searchUser.repArea }"></c:out></td>
				       <td><c:out value="${searchUser.section }"/></td>
				       <td><c:out value="${searchUser.longTelephone }(${searchUser.shortTelephone })"/></td>
				     </tr>
			   		</c:forEach>
            	</table>
            </div>
        </div>
        <% session.removeAttribute("searchUsers"); %><!--删除JavaBean对象-->
    	<!--搜索区end-->

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