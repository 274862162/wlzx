<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>网络中心学生技术团队_查看记事_处理</title>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
	%>
	<base href= "<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/dutyLog.css" />
</head>


<body>
    	<!--个人信息begin-->
        <div class="personInfo">
            <div class="dutyLog">
                <form name="dutyHandle" method="post" action="DutyRegisterServlet?action=dealingDutyRegister&noteID=${note.noteID }">
            	<table>
                    <tr class="head"><td colspan="4">事件记录</td></tr>
                    <tr class="tableContent"><td colspan="4">${note.content}</td></tr>
                    <tr>
                        <td>记录人</td>
                        <td>${note.recorder}</td>
                        <td>处理状态</td>
                        <td>
                            <select name="handle">
                            	<option class="handled">未处理</option>
                                <option class="handled">已处理</option>
                                <option class="noHandle">不处理</option>
                            </select>
                        </td>
                    </tr>
                    <tr><td>记录时间</td><td colspan="3"><fmt:formatDate value="${note.fillTime}" type="date"/></td></tr>
                    <tr><td>处理说明</td><td colspan="3"><input type="text" name="dealingContent"></td></tr>
                </table>
                <div class="button handleButton">
                    <input type="submit" value="确定"/>
                    <input type="reset" value="重置"/>
                    <a href="jsp/dutyRegister.jsp"><input type="button" value="返回"/></a>
                </div>
                </form>
            </div>
        </div>
    	<!--个人信息end-->
</body>
</html>