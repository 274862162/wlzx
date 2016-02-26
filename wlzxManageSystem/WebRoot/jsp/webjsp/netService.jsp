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
<title>netService</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/netService.css" />

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
        <ul class="none_list_style_type">
            <li class="display_i"><span class="none_text_decoration f1768 display_i_b font_huawencaiyun f_blue003399" href="#">网络中心</span></li>
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="index.html">首页</a>&rsaquo;&rsaquo;</li>
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">网络服务</a></li>
            <form class="subnav_form float_r" action="" method="post">
            <input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
            </form>
        </ul>
	</div>
	<!--子导航结束-->
	
	<!--中部图片展示-->
	<div class="banner margin0_auto overflow_h">
		<div class="introduction">
		<p class="netserviceBig">网络服务</p>
		<p class="f14 text_indent_2em netserviceSmall">学生技术团队旨在维护校园网络安定，网络服务提供各种有关校园网的使用信息，包括校园网使用手册、宿舍上网须知等文档。
		同学们阅览后对校园网会有更深入的了解。</p>
		</div>
	</div>
	<!--中部图片展示结束-->
	
	<!--中下部文字链接区域-->
	<div class="w980 margin0_auto f14 linkText">
		<ul>
			<li><a href="javascript:;">校园网服务手册校园网服务手册校园网服务手册校园网服务手册</a><span>2014/01/01</span></li>
			<li><a href="javascript:;">校园网服务手册校园网服务手册校园网服务手册校园网服务手册</a><span>2014/01/01</span></li>
			<li><a href="javascript:;">校园网服务手册校园网服务手册校园网服务手册校园网服务手册</a><span>2014/01/01</span></li>
			<li><a href="javascript:;">校园网服务手册校园网服务手册校园网服务手册校园网服务手册</a><span>2014/01/01</span></li>
			<li><a href="javascript:;">校园网服务手册校园网服务手册校园网服务手册校园网服务手册</a><span>2014/01/01</span></li>
			<li><a href="javascript:;">校园网服务手册校园网服务手册校园网服务手册校园网服务手册</a><span>2014/01/01</span></li>
		</ul>
	</div>
	<!--中下部文字链接区域结束-->
	
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--中部包围结束-->

</body>
</html>