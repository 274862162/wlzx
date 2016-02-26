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
    <title>vedioClassify</title>
	<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
    %>   
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
	<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/downloadVedioClassify.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/vedioClassify.css" />
	
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
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">视频分类</a></li>
            <form class="subnav_form float_r" action="" method="post">
                <input class="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
            </form>
        </ul>
    </div>

	<!--中部视频区-->
    <div class="content margin0_auto text_align_c">
    	<div class="download_vedio">
        	<div><!--分类检索区-->
            	<div class="download_vedio_classifysearch f1768">
                	分类检索
                </div>
            	<ul id="list">
                    <li class="download_vedio_classify none_list_style_type" id="item1">
                        <a>校园网视频</a><hr/>  
                    </li>
                    <li class="download_vedio_classify none_list_style_type" id="item2">
                        <a>学习视频</a><hr/>  
                    </li>
                    <li class="download_vedio_classify none_list_style_type" id="item3">
                        <a>会议视频</a><hr/>   
                    </li>
                    <li class="download_vedio_classify none_list_style_type" id="item4">
                        <a>值班视频</a>      
                    </li>
                </ul>
            </div>
        	
        	<div>
            	<!--校园网视频区-->
                <div class="download_vedio_area" id="area1">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">校园网视频&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>入网流程</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>宽带故障</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>锐捷故障</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>校园网概况</a></li>
                            </ul>
                            <br/>
                            
                            <span class="f12 float_l text_indent_2em">按版本 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>手机版</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>电影版</a>&nbsp;&nbsp;</li>
                            </ul>
                        </div>
                        <div class="vedio_area_item">
                            <ul class="none_list_style_type">
                                <li class="float_l">
                                	<a href="videoMessage.html"><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a href="videoMessage.html">招新视频</a></p>
                                </li>      
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li> 
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li> 
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li> 
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li>  
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li>      
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li> 
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li> 
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li> 
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>招新视频</a></p>
                                </li>        
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
                
                <!--学习视频区-->
                <div class="download_vedio_area" id="area2">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">学习视频&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>A学习视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>B学习视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>C学习视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>D学习视频</a></li>
                            </ul>   
                            <br/>
                            
                            <span class="f12 float_l text_indent_2em">按版本 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>手机版</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>电影版</a>&nbsp;&nbsp;</li>
                            </ul>                    
                        </div>
                        <div class="vedio_area_item">
                            <ul class="none_list_style_type">
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>学习视频</a></p>
                                </li> 
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
                
                <!--会议视频区-->
                <div class="download_vedio_area" id="area3">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">会议视频&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>A会议视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>B会议视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>C会议视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>D会议视频</a></li>
                            </ul>
                            <br/>
                            
                            <span class="f12 float_l text_indent_2em">按版本 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>手机版</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>电影版</a>&nbsp;&nbsp;</li>
                            </ul>
                        </div>
                        <div class="vedio_area_item">
                            <ul class="none_list_style_type">
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>会议视频</a></p>
                                </li> 
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
                
                <!--值班视频区-->
                <div class="download_vedio_area" id="area4">
               		<div class="download_vedio_area_msg">
                    	<div>
                            <span class="f17 float_l f_blue0066ff">值班视频&nbsp;&nbsp;|</span>
                            <span class="f12 float_r">共123条结果</span>
                        </div>              	
                    </div>
                    
                    <div>
                    	<div class="download_vedio_area_classify">
                        	<span class="f12 float_l text_indent_2em">按类别 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>A值班视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>B值班视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>C值班视频</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>D值班视频</a></li>
                            </ul>
                            <br/>
                            
                            <span class="f12 float_l text_indent_2em">按版本 : &nbsp;&nbsp;</span>
                            <ul class="none_list_style_type float_l">
                            	<li class="display_i f12"><a>全部</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>手机版</a>&nbsp;&nbsp;|</li>
                                <li class="display_i f12"><a>电影版</a>&nbsp;&nbsp;</li>
                            </ul>
                        </div>
                        <div class="vedio_area_item">
                            <ul class="none_list_style_type">
                                <li class="float_l">
                                	<a><img src="images/webimg/vedioClassify/vedio_user.jpg" /></a>
                                	<p><a>值班视频</a></p>
                                </li> 
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
<!-- 整体包围结束 -->

</body>
</html>