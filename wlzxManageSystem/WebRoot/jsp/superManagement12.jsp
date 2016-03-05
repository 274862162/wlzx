<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>报修系统管理_统计分析</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/queryWage.css" />
    <link rel="stylesheet" type="text/css" href="css/superManagement4.css" />
   	<link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <link rel="stylesheet" type="text/css" href="css/analyze.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	<script type="text/javascript" src="js/Chart.js"></script>
	<script type="text/javascript" src="js/chart_data.js"></script>
	<script type="text/javascript">
	$(function(){
		
		$("#analyze").click(function(){
			getData();
		});
		//取图表数据
		function getData(){
			var param = {};
			param.startTime = $("#startTime").val();
			param.endTime = $("#endTime").val();
			$.ajax({
	 		   url  : "CommonServlet_ajax?action=repairAnalyze",  
	 		   data : param,
	 		   type : "post",                  
	 		   cache: false,
	 		   dataType:"json", 
	 		   error : function(x, er){
	 			    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		var labels = new Array();
	 		   		var datasets = new Array();
	 		   		$.each(result,function(){
	 		   			labels.push(this.stuBuilding);
	 		   			datasets.push(this.count);
	 		   		});
	 		   		var data = {
						labels : labels ,
						datasets : [
						{
							fillColor : "rgba(151,187,205,0.5)",
							strokeColor : "rgba(151,187,205,1)",
							data : datasets
						}]
					};
					var ctx = document.getElementById("myChart").getContext("2d");
					var myNewChart=new Chart(ctx).Bar(data);		 
	 		   }
 			});
		};
	});
	</script>
</head>


<body style="height:100%;">
<!--整体包围-->
<div class="wrapper margin0_auto" style="height:100%;">
	<head:header></head:header>
    <nav:nav></nav:nav>
	
	<!--中部内容区begin-->
	<div class="content" style="height:100%;">
    	<!--左部菜单begin-->
        <div class="menu" style="height:100%;float:left">
            <ul class="none_list_style_type" style="height:100%;">
            	<li><a href="jsp/superManagement1.jsp"><img alt="" src="images/superManagement/1.png"/><p>角色管理</p></a></li>
                <li><a href="jsp/superManagement2.jsp"><img alt="" src="images/superManagement/2.png"/><p>设置角色</p></a></li>
                <li><a href="jsp/superManagement3.jsp"><img alt="" src="images/superManagement/3.png"/><p>前台管理</p></a></li>
                <li><a href="jsp/superManagement9.jsp"  class="active"><img alt="" src="images/superManagement/4.png"/><p>后台管理</p></a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo superManagement20">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;后台管理</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="jsp/superManagement9.jsp">网管账号管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement10.jsp" class="f_blue0066ff">报修系统管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement13.jsp">公告管理</a></li>
                <br/>
                <span class="f14">
                    <a href="jsp/superManagement10.jsp">楼栋管理 &nbsp;</a>
                    <a href="jsp/superManagement11.jsp">学生管理 &nbsp;</a>
                    <a href="jsp/superManagement12.jsp" class="f_blue0066ff">统计分析</a>
                </span>
            </ul>   
            <hr/>
             <div class="dutyRegister">
               <form>
                    <!-- 搜索栏begin -->
                    <div class="searchBar">
                        <span>时间:<input type="date" name="startTime" id="startTime" placeholder="年/月/日"/><input type="date" name="endTime" id="endTime" placeholder="年/月/日"/></span>
                        <span><input type="button" value="分析" id="analyze"></span>
                    </div>
                    <!-- 搜索栏end -->
               </form>
               <div style="margin-top:30px">
               		<canvas id="myChart" width="400" height="400"></canvas>
               </div>
            </div>
        </div>	
    	<!--个人信息end-->
    
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