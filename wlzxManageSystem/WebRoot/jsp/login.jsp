<%@ page contentType="text/html" pageEncoding="utf-8"%> 
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
    <title>login</title>
	<%   
		String path = request.getContextPath();   
		String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
	%> 
	<base href= "<%=basePath%>">   
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/validationEngine.jquery.css" />
	<script type="text/javascript" src="js/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery.validationEngine.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){  
	        $("#login_form").validationEngine('attach');  
	    });
		window.onload = function(){
			var message = '<%=request.getAttribute("message")%>';
			if(message!=null && message!="" && message!="null"){
				alert(message);
			}	
		};
	</script>
</head>


<body>
<!--整体包围-->
<div class="wrapper margin0_auto">

	<!--中部内容区begin-->
	<div class="content margin0_auto f14">
		<img src="images/login/hw.png"/>
		<form method="post" action="CommonServlet_redirect?action=login" id="login_form">
			<input class="user inputText validate[required,minSize[4]] text-input" type="text" name="userName" id="user_text"/>
			<br/>
			<input class="password inputText validate[required] text-input" type="password" name="password" id="psw_text"/>
			<div class="login"><input type="submit" value="登录"/></div>
		</form>
	</div>
	<!--中部内容区end-->

</div>
<!--中部包围结束-->

</body>
</html>