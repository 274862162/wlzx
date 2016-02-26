<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by hsg-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>displayPicture</title>
    <%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
    %>   
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
	<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/displayPicture.css" />
	
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/webjs/displayPicture.js"></script>
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
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">图片展示</a></li>
            <form class="subnav_form float_r" action="" method="post">
                <input class="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
            </form>
        </ul>
    </div>

	<!--中部图片展示区-->
    <div class="content margin0_auto text_align_c">
        <div class="imgContainer margin0_auto">
            <!--大图-->
            <div class="detailImg" >
                <a id="detailImg_pre" class="detailImg_btn"></a>
                <div id="detailImg_box" class="margin0_auto overflow_h"></div>
                <a id="detailImg_next" class="detailImg_btn"></a>
            </div>
            <!--小图-->
            <div class="smallImg">
                <a id="smallImg_pre" class="smallImg_btn"></a>
                <div id="smallImg_box" class="margin0_auto overflow_h">
                    <ul id="smallImg_ul" class="none_list_style_type"></ul>
                </div>
                <a id="smallImg_next" class="smallImg_btn"></a>
            </div>
        </div>      
    </div>

	<!--脚部-->
    <webFoot:webFooter></webFoot:webFooter>
    <!--脚部结束-->
    
</div>


</body>
</html>