<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The site is designed by 网络中心.Written by tmn-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>searchResult</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/searchResult.css" />

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
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">搜索结果</a></li>
		<form class="subnav_form float_r" action="" method="post">
		<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>
	<!--子导航结束-->
	
	<!--中部内容区-->
	<div class="content w980 margin0_auto f14">
	<p class="all_result_text f_blue0066ff">全部搜索结果</p>
	<!--标题栏开始-->
	<div class="title">
	<table>
	<tr>
		<td class="wType">文档格式</td>
		<td class="wName">名称</td>
		<td class="wdownload">下载量</td>
		<td class="wTime">上传时间</td>
	</tr>
	</table>
	</div>
	<!--标题栏结束-->

	<!--搜索结果区-->
	<div class="show">
	<table>
	<tr>
		<td class="wType"><img src="images/webimg/searchResult/document-type-icon.jpg"></td>
		<td class="wName"><a href="#">网络用户统计表</a></td>
		<td class="wdownload">33</td>
		<td class="wTime">2014/12/23</td>
	</tr>
	</table>
	</div>
	<!--搜索结果区结束-->
		
	<!--底部页码切换-->
	<div class="change_page">
	<ul>
		<li class="display_i"><a class="display_i_b text_align_c" href="#">上一页</a></li>
		<li class="display_i"><a class="display_i_b text_align_c link_bgcolor" href="#">1</a></li>
		<li class="display_i"><a class="display_i_b text_align_c" href="#">2</a></li>
		<li class="display_i"><a class="display_i_b text_align_c" href="#">3</a></li>
		<li class="display_i"><a class="display_i_b text_align_c" href="#">4</a></li>
		<li class="display_i"><a class="display_i_b text_align_c" href="#">5</a></li>
		<li class="display_i"><a class="display_i_b text_align_c" href="#">下一页</a></li>
	</ul>
	</div>
	<!--底部页码切换结束-->
	
	</div>
	<!--中部内容区结束-->

	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--整体包围结束-->

</body>
</html>