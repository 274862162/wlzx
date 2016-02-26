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
    <title>download</title>
    <%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
    %>   
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
	<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/downloadVedioClassify.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/download.css" />
    <script type="text/javascript" src="js/webjs/downloadVedioClassify.js"></script>
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
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">下载专区</a></li>
            <form class="subnav_form float_r" action="" method="post">
                <input class="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
            </form>
        </ul>
    </div>

	<!--中部下载区-->
    <div class="content margin0_auto text_align_c">
    	<div class="download_vedio">
        	<div><!--分类检索区-->
            	<div class="download_vedio_classifysearch f1768">
                	分类检索
                </div>
            	<ul id="list">
                    <li class="download_vedio_classify none_list_style_type" id="item1">
                        <a>软件下载</a><hr/>
                    </li>
                    <li class="download_vedio_classify none_list_style_type" id="item2">
                        <a>视频下载</a><hr/>  
                    </li>
                    <li class="download_vedio_classify none_list_style_type" id="item3">
                        <a>文档下载</a><hr/>   
                    </li>
                    <li class="download_vedio_classify none_list_style_type" id="item4">
                        <a>其他</a>      
                    </li>
                </ul>
            </div>
        	
        	<div>
            	<!--软件下载区-->
                <div class="download_vedio_area" id="area1">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">软件下载&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>锐捷软件</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>系统软件</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>驱动程序</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>应用软件</a></li>
                            </ul>
                        </div>
                        <div class="download_area_item">
                            <ul class="none_list_style_type">
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">RG for Windows 4.40</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">RG for Windows 4.85</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">RG for Linux</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">RG for MAC</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">FXPTP客户端</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="download_vedio_area_page">
                            <a class="display_i_b none_text_decoration text_align_c" href="#">上一页</a>
                            <a class="display_i_b none_text_decoration text_align_c page_current"  href="#">1</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">2</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">3</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">4</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">5</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">下一页</a>
                    </div>
                </div>
                
                <!--视频下载区-->
                <div class="download_vedio_area" id="area2">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">视频下载&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>A视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>B视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>C视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>D视频</a></li>
                            </ul>
                        </div>
                        <div class="download_area_item">
                            <ul class="none_list_style_type">
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">视频1</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">视频2</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">视频3</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">视频4</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">视频5</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="download_vedio_area_page">
                            <a class="display_i_b none_text_decoration text_align_c" href="#">上一页</a>
                            <a class="display_i_b none_text_decoration text_align_c page_current"  href="#">1</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">2</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">3</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">4</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">5</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">下一页</a>
                    </div>
                </div>
                
                <!--文档下载区-->
                <div class="download_vedio_area" id="area3">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">文档下载&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>A文档</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>B文档</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>C文档</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>D文档</a></li>
                            </ul>
                        </div>
                        <div class="download_area_item">
                            <ul class="none_list_style_type">
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">文档1</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">文档2</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">文档3</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">文档4</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">文档5</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="download_vedio_area_page">
                            <a class="display_i_b none_text_decoration text_align_c" href="#">上一页</a>
                            <a class="display_i_b none_text_decoration text_align_c page_current"  href="#">1</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">2</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">3</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">4</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">5</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">下一页</a>
                    </div>
                </div>
                
                <!--其他-->
                <div class="download_vedio_area" id="area4">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">其他&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>A</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>B</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>C</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>D</a></li>
                            </ul>
                        </div>
                        <div class="download_area_item">
                            <ul class="none_list_style_type">
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">1</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">2</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">3</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">4</a></li>
                                <li class="f14"><img class="float_l" src="images/webimg/download/download_area_item.jpg" /><a class="float_l">5</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="download_vedio_area_page">
                            <a class="display_i_b none_text_decoration text_align_c" href="#">上一页</a>
                            <a class="display_i_b none_text_decoration text_align_c page_current"  href="#">1</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">2</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">3</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">4</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">5</a>
                            <a class="display_i_b none_text_decoration text_align_c" href="#">下一页</a>
                    </div>
                </div>
                
            </div>
        	
        </div> 
    </div>

	<!--脚部-->
    <webFoot:webFooter></webFoot:webFooter>
    <!--脚部结束-->
    
</div>


</body>
</html>