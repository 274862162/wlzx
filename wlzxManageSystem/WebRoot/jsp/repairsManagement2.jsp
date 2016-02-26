<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>处理报修单</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/onlineRepair.css" />
    <link rel="stylesheet" type="text/css" href="css/repairsManagement.css" />
    <link rel="stylesheet" type="text/css" href="css/modal.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        //限制处理文字字数
	    function descriptionLimit() 
		{ 
			var curLength=$("#problemDescribe").val().length; 
			if(curLength>195) 
			{ 
				var num=$("#problemDescribe").val().substr(0,195); 
				$("#problemDescribe").val(num); 
				alert("超过字数限制，多出的字将被截断！" ); 
			}
		}
    </script>
</head>

<body>
	<!--中间表格-->
	<div class="message">	
	<table class="w980 margin0_auto f14">
		<c:forEach items="${sessionScope.userRepairLists}" var="userRrepairList">
			<c:if test="${userRrepairList.repairListID==sessionScope.displayID}">
				<tr><td colspan="4" class="repairMessage">报修信息</td></tr>
				<tr><td class="leftTd"><span class="mandatory">*</span>学号：</td><td><input type="text" class="leftTdText" value="${userRrepairList.stuSno}" disabled/></td><td colspan="2" class="rightTd"><span class="mandatory">*</span>姓名：<input type="text" class="rightTdText nameText" value="${userRrepairList.stuName}" disabled/></td></tr>
				<tr>
					<td class="leftTd"><span class="mandatory">*</span>住址：</td>
					<td><input type="text" class="leftTdText" value="${userRrepairList.stuBuilding}${userRrepairList.stuRoom}" disabled/></td>
					<td colspan="2"class="rightTd"><span class="mandatory">*</span>预约时间：<input type="text" class="rightTdText" value="${userRrepairList.appointmentTime}" disabled/>
					<span class="remarks">预约备注：<input class="rightTdText" type="text" id="appointmentText" value="${userRrepairList.appointmentText}" disabled/></span></td>
				</tr>
				
				<tr>
				<td class="leftTd"><span class="mandatory">*</span>联系电话：</td><td><input type="text" class="leftTdText" value="${userRrepairList.telephone}" disabled/></td>
				<td colspan="2" class="rightTd"><span class="mandatory">*</span>故障类型：
				<input type="text" class="leftTdText" value="${userRrepairList.faultType}" disabled/>
				</td>
				</tr>
				
				<tr>
				<td rowspan="2" class="leftTd">锐捷客户端提示:</td>
				<!-- fn:contains(userRrepairList.clientCode, server) -->
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.clientCode,'server')}">
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="server" checked="checked" disabled="disabled">无法连接认证服务器</td>
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" checked="false" value="server" />无法连接认证服务器</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.clientCode,'ip')}">
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="ip" checked="checked" disabled="disabled">静态IP地址绑定错误</td>
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="ip" disabled="disabled" />静态IP地址绑定错误</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.clientCode,'nouserORpasswordmistake')}">
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="nouserORpasswordmistake" checked="checked" disabled="disabled" />用户不存在或密码错误</td>
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="nouserORpasswordmistake" disabled="disabled" />用户不存在或密码错误</td>
					</c:otherwise>
				</c:choose>				
				</tr>
				<tr>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.clientCode,'timeout')}">
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="timeout" checked="checked" disabled="disabled"/>不在认证时间段内</td>
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="timeout" disabled="disabled"/>不在认证时间段内</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.clientCode,'overuser')}">
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="overuser" checked="checked" disabled="disabled"/>已达到同时在线用户数量上限</td>
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="overuser" disabled="disabled"/>已达到同时在线用户数量上限</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.clientCode,'overuser')}">
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="withoutNetworkCard" checked="checked" disabled="disabled"/>网卡未连接</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="withoutNetworkCard" disabled="disabled"/>网卡未连接</td>	
					</c:otherwise>
				</c:choose>
				
				</tr>
				<tr>
				<td rowspan="2" class="leftTd">宽带错误代码:</td>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.errorCode,'629/691')}">
						<td><input class="checkboxMessage" type="checkbox" name="code" checked="checked" disabled="disabled"/>629/691</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="code" disabled="disabled"/>629/691</td>	
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.errorCode,'651')}">
						<td><input class="checkboxMessage" type="checkbox" name="code" checked="checked" disabled="disabled"/>651</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="code" disabled="disabled"/>651</td>	
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.errorCode,'734')}">
						<td><input class="checkboxMessage" type="checkbox" name="code" checked="checked" disabled="disabled"/>734</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="code" disabled="disabled"/>734</td>	
					</c:otherwise>
				</c:choose>
				</tr>
				<tr>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.errorCode,'720')}">
						<td><input class="checkboxMessage" type="checkbox" name="code" checked="checked" disabled="disabled"/>720</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="code" disabled="disabled"/>720</td>	
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.errorCode,'711')}">
						<td><input class="checkboxMessage" type="checkbox" name="code" checked="checked" disabled="disabled"/>711</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="code" disabled="disabled"/>711</td>	
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${fn:contains(userRrepairList.errorCode,'619')}">
						<td><input class="checkboxMessage" type="checkbox" name="code" checked="checked" disabled="disabled"/>619</td>	
					</c:when>
					<c:otherwise>
						<td><input class="checkboxMessage" type="checkbox" name="code" disabled="disabled"/>619</td>	
					</c:otherwise>
				</c:choose>
				<!-- <td><input class="checkboxMessage" type="checkbox" name="code" value="619">619</td>	 -->
				</tr>
				
				<tr>
				<td class="leftTd"><span class="mandatory">*</span>问题描述：</td>
				<td colspan="3">
				<textarea class="text_indent_2em" cols="134" rows="15" name="problemDescribe">
					<c:out value="${userRrepairList.description}"></c:out>
				</textarea>
				</td>
				</tr>
				
				<tr>
				<td class="leftTd"><span class="mandatory">*</span>处理说明：</td>
				<td colspan="3">
					<textarea class="text_indent_2em" cols="134" rows="15" name="problemDescribe" id="problemDescribe" onblur="descriptionLimit()">
					</textarea>
				</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	</div>
	<!--中间表格结束-->
	
	<!--按钮开始-->
    <div class="repairs processing button">
    	<input type="button" value="处理" id="deal"/>
    	<input class="cancle_btn" type="button" value="取消" id="cancel"/>
	</div>
	<!--按钮结束-->
</body>
    <script type="text/javascript"> 
	    //获取客户端系统时间
		var date = new Date();
	   	var year = date.getFullYear();
	   	var month = date.getMonth()+1;
	   	var day = date.getDate();
	   	var h=date.getHours();
	   	var m=date.getMinutes();
		var s=date.getSeconds();
		var time=year+"-"+month+"-"+day+"-"+h+":"+m+":"+s; 
    	$("#cancel").click(function(){
    		 location.href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage";
    	});
    	$("#deal").click(function(){
    		//$("#dealingText").submit();
    		//获取数据
    		var problemDescribe=$("#problemDescribe").val();
    		var url="onlineRepairSystem/OnlineRepairServlet?action=dealRepairList&problemDescribe="+encodeURI(problemDescribe+"&dealingTime="+time);
    		$.get(url,null,callback);
    		function callback(data){
    			alert(data);
    			location.href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage";
    		}
    	});
    </script>
</html>