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
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>网络中心学生技术团队_基本信息</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/basicInfo.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/validationEngine.jquery.css" />
	<script type="text/javascript" src="js/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery.validationEngine.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){  
	        $("#mes_form").validationEngine('attach');
	    });
		$(function(){
			var message = '<%=request.getAttribute("message")%>';
			if(message!=null && message!="" && message!="null"){
				alert(message);
			}	
		});
	</script>
</head>


<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	<head:header></head:header>
    <nav:nav></nav:nav>

	<!--中部内容区begin-->
	<div class="content margin0_auto f14">
		<p class="mes_title">基本信息</p>
		<form class="" method="post" action="UserServlet?action=basicInfo" id="mes_form">
			<label style="margin-left: 31px;">学号<em>*</em>：</label><input class="inputText validate[required] text-input" type="text" name="sno" id="sno_text"/>
			<label style="margin-left: 30px;">姓名<em>*</em>：</label><input class="inputText validate[required] text-input" type="text" name="name" id="name_text"/><br>
			<label style="margin-left: 36px;">性别：</label>
			<input type="radio" name="sex" value="男" checked/><label class="sex">男</label>
			<input type="radio" name="sex" value="女"/><label>女</label>
			<label class="age">年龄：</label>
			<select name="age">
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
			</select>
			<br/>
			<label style="margin-left: 31px;">住址<em>*</em>：</label><input class="inputText validate[required] text-input" type="text" name="address" id="address_text"/>
			<!-- 
			<label>负责区域<em>*</em>：</label><input type="text" name="respArea" class="inputText validate[required] text-input" id="respArea_text"/>
			<p class="tips" style="margin-left:386px">提示：填写楼栋请注意格式，南苑直接填写例如如“3栋”，北苑直接填写例如“18栋A”</p>
			 -->
			<label style="margin-left: 31px;">专业<em>*</em>：</label><input type="text" name="major" class="inputText validate[required] text-input" id="major_text"/>
			<br/>
			<label style="margin-left: 31px;">长号<em>*</em>：</label><input maxlength="11" type="text" name="tel" class="inputText validate[required]" id="phone_text"/>
			<br/>
			<label style="margin-left: 37px;">短号：</label><input type="text" name="shortTel" class="inputText validate[custom[required]] text-input" id="shortTel_text"/>
			<br/>
			<!-- 
			<label>所属部门<em>*</em>：</label>
			<select type="text" name="section" class="inputText validate[custom[section_ruleName]] text-input" id="section_text">
				<option value="技术部" selected="selected">技术部</option>
				<option value="资源部">资源部</option>
				<option value="综合部">综合部</option>
			</select>
			 -->
			<div class="button next"><input type="submit" value="下一步"/></div>
		</form>
	</div>
	<!--中部内容区end-->
	<!-- 脚部 -->
	<foot:footer></foot:footer>
</div>
<!--整体包围结束-->
</body>
</html>