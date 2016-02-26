<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The site is designed by 网络中心 written by Wmj-->
<META http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>videoPlayer</title>
<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/videoPlayer.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/videoPlayerVideoMessage.css" />
</head>
<body>
<div class="wrapper margin0_auto"><!--整体包围-->
	<!--头部-->
    <webHead:webHead></webHead:webHead>
    <!--头部结束-->
    
	<!--导航-->
    <webNav:webNav></webNav:webNav>
    <!--导航结束-->
	
	<div class="subnav margin0_auto"><!--子导航-->
	<ul class="none_list_style_type">
		<li class="display_i"><span class="none_text_decoration f1768 display_i_b font_huawencaiyun f_blue003399" href="#">网络中心</span></li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="jsp/webjsp/index.jsp">首页</a>&rsaquo;&rsaquo;</li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">视频专区</a></li>
		<form class="subnav_form float_r" action="" method="post">
		<label class="f12"><a href="js/webjsp/login.jsp">登录</a></label><input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}""/>
		</form>
	</ul>
	
	</div>
	
	<div class="player margin0_auto">
		<center><!--视频播放区-->
			<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="981.5" height="413.5" align="middle" >
				<param name="allowScriptAccess" value="sameDomain" />
				<param name="movie" value="media/player.swf" />
				<param name="quality" value="high" />
				<param name="bgcolor" value="#000000" />
				<param name="allowFullScreen" value="true"/>
				<embed src="media/player.swf" bgcolor="#ffffff" width="981.5" height="413.5" align="middle" allowScriptAccess="sameDomain" allowfullScreen="true" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
				</embed>
			</object>	
		</center>
		
	</div>
	<div class="w980 margin0_auto margin_20"><!--招新视频列表区-->
			<div class="float_l video_title_bkg"><!--招新视频标题-->
				<span class="f17 f_white recruit_video_title f_sp2">招新视频</span>
				<span class="f14 recruit_video_more"><a class="f_white" href="js/webjsp/vedioClassify.html">MORE+</a></span>
			</div>
	</div>
	<div class="w980 recruit_video_list margin0_auto">
		<table class="recruit_video_tablelist" border="0" align="center"cellspacing="20">
			 <tr>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
			 </tr>
			<tr class="f14">
				<td width="230" height="10" align="center">招新视频</td>
				<td width="230" height="10" align="center">2014招新视频</td>
				<td width="230" height="10" align="center">2015招新视频</td>
				<td width="230" height="10" align="center">2016招新视频</td>
				<td width="230" height="10" align="center">2017招新视频</td>
			</tr>
		</table>
	</div>
	<div class="w980 margin0_auto"><!--校园网视频列表-->
			<div class="float_l video_title_bkg">
				<span class="f17 f_white recruit_video_title f_sp2">校园网视频</span>
				<span class="f14 net_video_more"><a class="f_white" href="js/webjsp/vedioClassify.jsp">MORE+</a></span>
			</div>
	</div>
	<div class="w980 recruit_video_list margin0_auto">
		<table class="recruit_video_tablelist" border="0" align="center"cellspacing="20">
			 <tr>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
			 </tr>
			<tr class="f14">
				<td width="230" height="10" align="center">招新视频</td>
				<td width="230" height="10" align="center">2014招新视频</td>
				<td width="230" height="10" align="center">2015招新视频</td>
				<td width="230" height="10" align="center">2016招新视频</td>
				<td width="230" height="10" align="center">2017招新视频</td>
			</tr>
		</table>
	</div>
	
	<div class="w980 margin0_auto"><!--学习视频列表-->
			<div class="float_l video_title_bkg">
				<span class="f17 f_white recruit_video_title f_sp2">学习视频</span>
				<span class="f14 recruit_video_more"><a class="f_white" href="js/webjsp/vedioClassify.jsp">MORE+</a></span>
			</div>
	</div>
	<div class="w980 recruit_video_list margin0_auto">
		<table class="recruit_video_tablelist" border="0" align="center"cellspacing="20">
			 <tr>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
				<td class="table_tr1_style"><img class="overflow_h" src="images/webimg/videoPlayer/tempVideo01.png"></img></td>
			 </tr>
			<tr class="f14">
				<td width="230" height="10" align="center">招新视频</td>
				<td width="230" height="10" align="center">2014招新视频</td>
				<td width="230" height="10" align="center">2015招新视频</td>
				<td width="230" height="10" align="center">2016招新视频</td>
				<td width="230" height="10" align="center">2017招新视频</td>
			</tr>
		</table>
	</div>
	
	<!--脚部-->
    <webFoot:webFooter></webFoot:webFooter>
    <!--脚部结束-->
</div>


</body>
</html>