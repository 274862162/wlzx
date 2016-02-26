<%@ page contentType="text/html" pageEncoding="utf-8"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>dutyLog查看记事-已处理</title>
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
                <form name="dutyHandle" method="post" action="jsp/dutyRegister.jsp">
            	<table>
                    <tr class="head"><td colspan="4">事件记录</td></tr>
                    <tr class="tableContent"><td colspan="4">${note.content }</td></tr>
                    <tr>
                        <td>记录人</td>
                        <td>${note.recorder }</td>
                        <td>处理状态</td>
                        <td>${note.status }</td>
                    </tr>
                    <tr><td>记录时间</td><td><fmt:formatDate value="${note.fillTime}" type="date"/></td><td>处理人</td><td>${note.handler }</td></tr>
                    <tr><td>处理说明</td><td colspan="3">${note.dealingContent }</td></tr>
                </table>
                <div class="button handledButton">
                    <a href="jsp/dutyRegister.jsp"><input type="button" value="返回"/></a>
                </div>
                </form>
            </div>
        </div>
    	<!--个人信息end-->
</body>
</html>