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
<title>announcement</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/announcement.css" />

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
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">部门动态</a></li>
		<form class="subnav_form float_r" action="" method="post">
		<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>
	<!--子导航结束-->
	
	<div class="container background_img"><!--背景图片、中部整体包围的容器-->
		
		<!--中部内容区-->
		<div class="content margin0_auto overflow_h f17 text_indent_2em">
		
		<p class="title f_blue003399 text_align_c">本周六晚上不断网</p><!--标题-->
		<!--文章内容-->
		<p class="context_text font_songti">“她一定觉得”实际上是作者觉得，这是作者对小女孩身世的感慨之词。“湿了水的牛皮罩衣很重”，母亲的去世使生活的重担压在了女孩的肩上，重的不仅仅是罩衣。在这平淡的生活中，父亲对生活的无奈和对母亲的思念使得他的话越来越少。</p>
		<p class="context_text font_songti">他们是故乡打鱼人中的底层人物，他们没有“三桅大船”打鱼的豪迈壮观，也没有放鱼鹰的那样闲适，他们既不挑打鱼的时间也不挑打到的是什么鱼，打鱼是他们的生活来源。“女人很少打鱼”，但打鱼夫妻中女人却跟着男人一起打鱼，女人死后女孩又来打鱼，可见他们的生活之艰辛。</p>
		<p class="context_text font_songti">发散性题目，只要言之成理即可。（“打鱼的”是故乡人中的多数，是故乡中最为真实的一类，这类人的描写为故乡提供了生活的背景。“金大力”是故乡中有一定生活来源的人，金大力做瓦匠头儿只是为了给故乡人做点儿什么，而他被故乡人认同正反映了故乡人的道德标准。“钓鱼的医生”是作者塑造的理想的故乡人形象。</p>
		<!--文章内容结束-->
		
		<!--右下角署名-->
		<div class="signature">
		<p class="font_songti">供稿：无名氏</p>
		<p class="font_songti">阅读：33</p>
		<p class="font_songti">更新时间：2012/09/09</p>
		</div>
		<!--右下角署名结束-->
		
		</div>
		<!--中部内容区结束-->
		
		<!--翻页-->
		<div class="front_next">
		<ul class="none_list_style_type">
		<li class="display_i_b"><a class="front display_i_b text_align_c f_white f12" href="#">&lt;上一篇</a></li>
		<li class="display_i_b"><a class="next display_i_b text_align_c f_white f12" href="#">下一篇&gt;</a></li>
		</ul>
		</div>
		<!--翻页结束-->
	</div>
	<!--背景图片、中部整体包围的容器结束-->

	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--整体包围结束-->

</body>
</html>