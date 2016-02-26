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
    <title>departmentIntro</title>
    <%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
    %>   
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
	<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
    <link rel="stylesheet" type="text/css" href="css/webcss/departmentIntro.css" />

    <script type="text/javascript" src="js/webjs/departmentIntro.js"></script>
    <script type="text/javascript" src="js/webjs/utils.js"></script>
</head>

<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
    <!--头部-->
    <webHead:webHead></webHead:webHead>
	
    <!--导航-->
	<webNav:webNav></webNav:webNav>
	<!--导航结束-->
	
    <!--子导航-->
	<div class="subnav margin0_auto">
        <ul class="none_list_style_type">
            <li class="display_i"><span class="none_text_decoration f1768 display_i_b font_huawencaiyun f_blue003399" href="#">网络中心</span></li>
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="index.html">首页</a>&rsaquo;&rsaquo;</li>
            <li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">部门简介</a></li>
            <form class="subnav_form float_r" action="" method="post">
            <input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
            </form>
        </ul>
	</div>
	
    <!--中部部门简介-->
	<div class="content margin0_auto text_align_c">
		<div class="department"> 
        	<div>
            	<img src="images/webimg/departmentIntro/departmentIntro.png" />
                <a href="javascript:;" id="begin" class="begin f1768 none_text_decoration">我们开始吧</a>
            </div>
            <!--技术部-->
            <div>
            	<!--虚线-->
           		<div class="line"></div>
				<img id="icon_technology" class="department_icon" src="images/webimg/departmentIntro/technology.png" />
                
                <div class="department_guide">
                	<div class="department_guide_msg">
                    	<span id="tg0" class="toggle display_i_b"></span>
                        <p class="f1768 display_i_b">我们有什么</p>
                    </div>
                    <div id="msg0" class="department_msg">
                    	<div>
                        	<h2>技术部技术部技术部</h2><br/>
                            <p>
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                            </p>
                        </div>                 	
                    </div>
                </div>   
                
                <div class="department_guide">
                	<div class="department_guide_msg">
                    	<span id="tg1" class="toggle display_i_b"></span>
                        <p class="f1768 display_i_b">我们做些什么</p>
                    </div>
                    <div id="msg1" class="department_msg">
                    	<div>
                            <h2>技术部技术部技术部</h2><br/>
                            <p>
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                                技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部技术部
                            </p>
                        </div>
                    </div>
                </div> 
                <a href="javascript:;" id="next1" class="next f1768 none_text_decoration">Next&nbsp;&nbsp;>></a>
            </div>
            
            <!--资源部-->
            <div>
            	<!--虚线-->
           		<div class="line"></div>
				<img id="icon_resource" class="department_icon" src="images/webimg/departmentIntro/resource.png" />
                
                <div class="department_guide">
                	<div class="department_guide_msg">
                    	<span id="tg2" class="toggle display_i_b"></span>
                        <p class="f1768 display_i_b">我们有什么</p>
                    </div>
                    <div id="msg2" class="department_msg">
                        <div>
                            <h2>资源部资源部资源部</h2><br/>
                        	<p>
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                       		</p>
                        </div>                 	    
                    </div>
                </div>   
                
                <div class="department_guide">
                	<div class="department_guide_msg">
                    	<span id="tg3" class="toggle display_i_b"></span>
                        <p class="f1768 display_i_b">我们做些什么</p>
                    </div>
                    <div id="msg3" class="department_msg">
                    	<div>
                            <h2>资源部资源部资源部</h2><br/>
                        	<p>
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                                资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部资源部
                        	</p>
                        </div>                  	    
                    </div>
                </div> 
                <a href="javascript:;" id="next2" class="next f1768 none_text_decoration">Next&nbsp;&nbsp;>></a>
            </div>
            
            <!--综合部-->
            <div>
            	<!--虚线-->
           		<div class="line"></div>
				<img id="icon_comprehensive" class="department_icon" src="images/webimg/departmentIntro/comprehensive.png" />
                
                <div class="department_guide">
                	<div class="department_guide_msg">
                    	<span id="tg4" class="toggle display_i_b"></span>
                        <p class="f1768 display_i_b">我们有什么</p>
                    </div>
                    <div id="msg4" class="department_msg">
                        <div>
                            <h2>综合部综合部综合部</h2><br/>
                        	<p>
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                       		</p>
                        </div>                 	    
                    </div>
                </div>   
                
                <div class="department_guide">
                	<div class="department_guide_msg">
                    	<span id="tg5" class="toggle display_i_b"></span>
                        <p class="f1768 display_i_b">我们做些什么</p>
                    </div>
                    <div id="msg5" class="department_msg">
                    	<div>
                            <h2>综合部综合部综合部</h2><br/>
                        	<p>
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                                综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部综合部
                        	</p>
                        </div>                 	    
                    </div>
                </div> 
				<a href="javascript:;" id="top" class="top f1768 none_text_decoration">Top</a>
            </div>
        </div>
	</div>

	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
</div>
</body>
</html>