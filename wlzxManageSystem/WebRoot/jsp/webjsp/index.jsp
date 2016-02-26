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
    <title>index</title>
    <%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
	%>   
	<base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
	<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/index.css" />

	<script type="text/javascript" src="js/webjs/index.js"></script>
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
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="solveProblem.html">网络故障</a><span class="f12">|</span></li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="media/videoPlayer.html">上网视频</a><span class="f12">|</span></li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="announcement.html">团队介绍</a></li>
		<form class="subnav_form float_r" action="" method="post">
		<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>
	<!--子导航结束-->
	
	<!--中部照片墙及右边栏-->
	<div class="banner w980 margin0_auto">
		<div class="float_l">          
            <div class="picture_roll">
                <div class="list" style="left: -630px">
                    <img src="images/webimg/index/banner/8.jpg"/>
                    <img src="images/webimg/index/banner/1.jpg"/>
                    <img src="images/webimg/index/banner/2.jpg"/>
                    <img src="images/webimg/index/banner/3.jpg"/>
                    <img src="images/webimg/index/banner/4.jpg"/>
                    <img src="images/webimg/index/banner/5.jpg"/>
                    <img src="images/webimg/index/banner/6.jpg"/>
                    <img src="images/webimg/index/banner/7.jpg"/>
                    <img src="images/webimg/index/banner/8.jpg"/>
                    <img src="images/webimg/index/banner/1.jpg"/>
                </div>
                <div class="buttons">
                    <span index="1" class="on"></span>
                    <span index="2"></span>
                    <span index="3"></span>
                    <span index="4"></span>
                    <span index="5"></span>
                    <span index="6"></span>
                    <span index="7"></span>
                    <span index="8"></span>
                </div>
            </div>
        </div>
		<div class="sidebar margin0_auto f14 overflow_h">
		<div class="department_dynamic"><span class="f17 f_white f_sp2">部门动态</span><a class="float_r f17 f_white" href="announcement.html">MORE+</a></div>
		<ul class="none_list_style_type">
		<li><img src="images/webimg/index/banner/icon.png"><a class="font_songti" href="announcement.html">今天不断网，呵呵。<span class="float_r font_songti">2014/1/1</span></a></li>
		<li><img src="images/webimg/index/banner/icon.png"><a class="font_songti" href="announcement.html">陈碧莹今天捡了100元，呵呵。<span class="float_r font_songti">2014/2/3</span></a></li>
		<li><img src="images/webimg/index/banner/icon.png"><a class="font_songti" href="announcement.html">我要去吃饭了，呵呵。<span class="float_r font_songti">2014/3/12</span></a></li>
		<li><img src="images/webimg/index/banner/icon.png"><a class="font_songti" href="announcement.html">想要不断网吗，呵呵。<span class="float_r font_songti">2014/4/25</span></a></li>
		<li><img src="images/webimg/index/banner/icon.png"><a class="font_songti" href="announcement.html">陆磊发微博了，呵呵。<span class="float_r font_songti">2014/6/12</span></a></li>
		</ul>
		<div class="team_introduce"><span class="team_introduce_text f_grey4b4b4b f17" href="#">团队介绍</span>|<img class="float_r team_introduce_icon" src="images/webimg/index/banner/team_introduce_icon.png"></div>
		<p class="text_indent_2em"><a class="f14 font_songti" href="announcement.html">网络中心学生技术团队是一个学习型组织，在日常中主要工作是帮助学生解决网络故障...</a></p>
		</div>
	</div>
	<!--中部照片墙及右边栏结束-->
	
	<!--中下方栏目-->
	<div class="columns w980 margin0_auto f14">
		<div class="three_columns_w326 float_l">
		<div class="columns_top"><p class="f_grey4b4b4b"><span class="title_border"><img class="title_border" src="images/webimg/index/column/title_button.jpg"/>网络服务</span><a class="float_r" href="netService.html">MORE+</a></p></div>
		<div class="columns_center float_r display_i columns_br"><img class="float_l" src="images/webimg/index/column/internetServicePic.png"><p><a class="font_songti" href="netService.html">维护校园网络稳定是校园网络中心的职责，同学们网络出...</a></p></div>
		<div class="columns_bottom columns_br">
		<ul>
		<li class="f12"><a class="font_songti" href="textEdit.html">网络报修流程<span class="float_r font_songti">2014/3/2</span></a></li>
		<li class="f12"><a class="font_songti" href="textEdit.html">网络常见故障及解决方法<span class="float_r font_songti">2014/3/9</span></a></li>
		</ul>
		</div>
		</div>
		
		<div class="three_columns_w326 float_r">
		<div class="columns_top"><p class="f_grey4b4b4b"><span class="title_border"><img class="title_border" src="images/webimg/index/column/title_button.jpg"/>学习天地</span><a class="float_r" href="studyArea.html">MORE+</a></p></div>
		<div class="columns_center float_r display_i"><img class="float_l" src="images/webimg/index/column/study.jpg"><p><a class="font_songti" href="studyArea.html">维护校园网络稳定是校园网络中心的职责，同学们网络出...</a></p></div>
		<div class="columns_bottom">
		<ul>
		<li class="f12"><a class="font_songti" href="textEdit.html">网络报修流程<span class="float_r font_songti">2014/3/2</span></a></li>
		<li class="f12"><a class="font_songti" href="textEdit.html">网络常见故障及解决方法<span class="float_r font_songti">2014/3/9</span></a></li>
		</ul>
		</div>
		</div>
		
		<div class="three_columns_w326 float_l">
		<div class="columns_top"><p class="f_grey4b4b4b"><span class="title_border"><img class="title_border" src="images/webimg/index/column/title_button.jpg"/>常见问题解答</span><a class="float_r" href="solveProblem.html">MORE+</a></p></div>
		<div class="columns_center float_r display_i columns_br"><img class="float_l" src="images/webimg/index/column/answerQuestion.jpg"><p><a class="font_songti" href="solveProblem.html">维护校园网络稳定是校园网络中心的职责，同学们网络出...</a></p></div>
		<div class="columns_bottom columns_br">
		<ul>
		<li class="f12"><a class=" font_songti"href="textEdit.html">网络报修流程<span class="float_r font_songti">2014/3/2</span></a></li>
		<li class="f12"><a class=" font_songti"href="textEdit.html">网络常见故障及解决方法<span class="float_r font_songti">2014/3/9</span></a></li>
		</ul>
		</div>
		</div>
	</div>
	<!--中下方栏目结束-->
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--中部包围结束-->

</body>
</html>