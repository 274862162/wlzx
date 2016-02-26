<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by Wmj-->
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>a9-考核分析</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/assessmentSystem.css" />
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>

</head>


<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	<head:header></head:header>
	<nav:nav></nav:nav>
	
	<!--中部内容区begin-->
	<div class="content">
    	<!--左部菜单begin-->
        <div class="menu">
            <ul class="none_list_style_type">
                <li><a href="TestPaperServlet?action=testPaperDesign">设计考卷</a></li>
                <li><a href="TestPaperServlet?action=testPaperShow">在线考核</a></li>
                <li><a href="ExamServlet?action=examShow1&flag=mark">成绩统计</a></li>
				<li><a href="ExamServlet?action=examShow1&flag=analyze" class="active">考核分析</a></li>
            </ul>
        </div>
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">考核系统&nbsp;&nbsp;>>&nbsp;&nbsp;考核分析</div>
			<ul class="none_list_style_type">
                <li class="f14 float_l">试卷：${paperName}</li><br/>
                <li class="f14 float_l">平均分：${avgScore}分&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li class="f14 float_l">最高分：${maxScore}分&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li class="f14 float_l">及格人数：${passExamCount}/${examCount}&nbsp;&nbsp;&nbsp;&nbsp;</li>
            </ul>
            <hr/>
			<div class="assessmentContent assessmentContent2">
                <div>
				    <p class="f_blue0066ff">分数统计分析：</p>
				    <img src="${graphURLbar}" width="598" height="297"/>
                </div>
                <div>
				    <p class="f_blue0066ff">统计分析：</p>
				    <span>由结果可知，考生对值班相关的信息不太了解。应加强该方面的学习。</span>
                </div>
            </div>

        </div>	
    	<!--个人信息end--
    
    	<!-- 右侧公告 -->
		<notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->

	<!-- 脚部 -->
	<foot:footer></foot:footer>
</div>
<!--中部包围结束-->

</body>
</html>