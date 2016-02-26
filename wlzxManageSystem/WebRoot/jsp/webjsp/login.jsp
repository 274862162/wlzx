<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The site is designed by 网络中心.Written by tmn-->
<META http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>login</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/login.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	var userFlag=false;
	var passFlag=false;
	function checkUser(){  //判断用户名输入是否为空，如果为空给出错误提示
		var userElement=document.getElementById("user");	//获得user输入标签
		var userNullTip=document.getElementById("userNullTip");  //获得提示标签
		if(userElement.value.length==0){
			userNullTip.innerHTML="<font color='red'>用户名不能为空！</font>";//设<label>标签红色提示内容				
		}
		else{
			userFlag=true;
		}
	}
	function focusUser(){
		var userNullTip=document.getElementById("userNullTip");
		userNullTip.innerHTML="";   //隐藏红色提示文字
		userFlag=false;
	}
	function checkPassword(){	
		var passElement=document.getElementById("password");
		var passNullTip=document.getElementById("passwordNullTip");
		if(passElement.value.length==0){
			passNullTip.innerHTML="<font color='red'>密码不能为空！</font>";//设置红色提示内容				
		}
		else{
			passFlag=true;
		}
	}
	function focusPassword(){
		var passNullTip=document.getElementById("passwordNullTip");
		passNullTip.innerHTML="";
		passFlag=false;
	}
	//JQuery无刷新提交表单登录信息
	function verify(){
		var user=$("#user").val();
		var password=$("#password").val();		
		$.get("onlineRepairSystem/OnlineRepairServlet?action=judgeStudent&user="
		+user+"&password="+password,null,callback);
		function callback(data){
			if (data == "用户名或密码错误！") {
				alert(data);
        	}
        	else {
        		window.location.href = "jsp/webjsp/onlineRepair1.jsp";
        	}
		}	
	}
	function submitFlag(){
		if(userFlag==true&&passFlag==true){ //如果用户名和密码输入都不为空，则允许提交
			verify();
		}
		else{
			if(userFlag==false){
				var userNullTip=document.getElementById("userNullTip");
				userNullTip.innerHTML="<font color='red'>用户名不能为空！</font>";//设置红色提示内容
			}
			if(passFlag==false){
				var passNullTip=document.getElementById("passwordNullTip");
				passNullTip.innerHTML="<font color='red'>密码不能为空！</font>";//设置红色提示内容
			}
		}
	}
	//添加enter监听事件
	document.onkeydown=butOnClick; 
	function butOnClick(e) {
		// 兼容FF和IE和Opera    
        var theEvent = e || window.event;    
        var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
        if (code == 13) {
        	checkUser();
        	checkPassword();
			submitFlag();
        }
	}
</script>
</head>

<body>
<!--整体包围-->
<div class="wrapper margin0_auto">

	<!--头部-->
	<webHead:webHead></webHead:webHead>
	<!--头部结束-->
	
	<!--导航-->
	<webNav:webNav></webNav:webNav>
	<!--导航结束-->
	
	<!--子导航-->
	<div class="subnav margin0_auto">
	<ul class="none_list_style_type display_i">
		<li class="display_i"><span class="none_text_decoration f1768 display_i_b font_huawencaiyun f_blue003399" href="#">网络中心</span></li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="index.html">首页</a>&rsaquo;&rsaquo;</li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">登录</a></li>
		<li class="display_i">
			<form class="subnav_form float_r" action="" method="post">
			<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
			</form>
		</li>
	</ul>
	</div>
	<!--子导航结束-->
	
	<!--中部内容区-->
	<div class="content margin0_auto">
		<div class="login margin0_auto">
			<div class="picture float_l"><img class="overflow_h" src="images/webimg/login/login-picture.png"></div>
			<div class="form float_l f12">
			<p class="f1768 f_blue0066ff">普通登录</p>
			<form id="login_mes" method="post">
				<input id="user" class="input_text input_text_username" type="text" name="user" onBlur="checkUser()" onfocus="focusUser()" onkeyup="this.value=this.value.replace(/[, ]/g,'')"/>
				<label id="userNullTip"></label>
				<br/>
				<input id="password" class="input_text input_text_password" type="password" name="password" onBlur="checkPassword()" onfocus="focusPassword()" onkeyup="this.value=this.value.replace(/[, ]/g,'')"/>
				<label id="passwordNullTip"></label>
				<br/>
				<!-- <input class="auto_login" type="checkbox" name="auto_login"/>下次自动登录-->
				<!-- <p>还没有账号,<a class="f_blue0066ff" href="#">立即注册</a></p>	-->
				<div class="login_enter f_white text_align_c f14">
				<input type="button" value="登录" name="login" onclick="submitFlag();"/>
				</div>
			</form>
			</div>
		</div>
	</div>
	<!--中部内容区结束-->
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--整体包围结束-->

</body>
</html>