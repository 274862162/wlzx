<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The site is designed by 网络中心-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>studyArea</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/studyArea.css" />
</head>

<body>
<div class="wrapper margin0_auto"><!--整体包围-->
	<!--头部-->
	<webHead:webHead></webHead:webHead>
	<!--头部结束-->
	
	<!--导航-->
	<webNav:webNav></webNav:webNav>
	<!--导航结束-->

	<div class="margin0_auto"><!--子导航-->
	<ul class="none_list_style_type">
		<form class="subnav_form float_r" action="" method="post">
		<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>

	<div class='index_image'>
		<!--图片-->
	</div>
	<div class="inner">
		<div style="padding-top:50px">
			<p class="image_text">最新图文</p>
			<div class="frame">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<ul>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
				</ul>
			</div>
		</div>
		<div>
			<p class="image_text">学习资料</p>
			<div class="frame"style="padding-bottom:60px;">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<ul>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
				</ul>
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<ul>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
				</ul>
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<img src="images/webimg/studyArea/studyArea-Recovered.gif">
				<ul>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
					<li class="display_i"><a class="none_text_decoration display_i_b" href="#">如何保护QQ密码不被...</a></li>
				</ul>
				<div style="margin-top:20px;margin:auto;width:500px;margin-bottom:40px">
				<ul class="text_align_c margin0_auto">
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">上一页</a></li>
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">1</a></li>
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">2</a></li>
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">3</a></li>
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">4</a></li>
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">5</a></li>
				<li class="page_change"style="margin-left:8px;margin-right:0px;"><a class="none_text_decoration f17 display_i_b" href="#">下一页</a></li>
				</ul>
				</div>
			</div>
		</div>
	</div>
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!-- 整体包围结束 -->
</body>
</html>