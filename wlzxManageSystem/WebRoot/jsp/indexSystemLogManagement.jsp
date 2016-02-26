<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>

<!DOCTYPE HTML>
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="日志管理">
    <title>网络中心学生技术团队_日志管理</title>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
	%>
	<base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	
	<script type="text/javascript">
  		var page = 1;
		var displayRecord = 5;
		var totalPage = 1;
		$(function(){
			getLog();
			$("#up").click(function(){
				upPage();
			});
			$("#down").click(function(){
				downPage();
			});
			$("#firstPage").click(function(){
				page = 1;
				getLog();
			});
			$("#endPage").click(function(){
				page = totalPage;
				getLog();
			});
			$("#displayRecord").change(function(){
				displayRecord = $("#displayRecord").val();
				getLog();
			});
			$("#query").click(function(){
				getLog();
				page = $("#page").val();
				displayRecord = $("#displayRecord").val();
				totalPage = 1;
			});
		});
		function upPage(){
			if(page>1){
				page = page-1;
				getLog();
			}
		}
		function downPage(){
			if(page+1<=totalPage){
				page = page + 1;
				getLog();
			}
		}
  		function getLog(){
  			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			param.logType = $("#logType").val();
			param.operator = $("#operator").val();
			param.startTime = $("#startTime").val();
			param.endTime = $("#endTime").val();
			param.logContent = $("#logContent").val();
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=systemLogShow",  
		 	   data : param,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"json", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
		 		    alert("请求失败"); 
		 	   },
		 	   success :function(result){  //请求成功时调用。 
		 		   	$("#tb_log").children($("<tr>")).remove();
		 	   		$("#tb_log").append('<tr class="head"><td>日志类型</td><td class="event">日志内容</td><td class="event">记录时间</td><td>操作者</td></tr>');
		 	   		$.each(result,function(){
					    $.each(this.list,function(){
			 			   	$("#tb_log").append('\
			 			   		<tr><td>'+this.type+'</td>\
			 			   		<td>'+this.content+'</td>\
			 			   		<td>'+this.operatorTime+'</td>\
			 			   		<td>'+this.operator+'</td>');
			 		    });
			 			//page = this.page;
			 			totalPage = this.totalPage;
			 			$("#page").val(page);
			 			$("#totalPage").html(totalPage);
			 		});			 			 
		 		 }
	 		});
  		}
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
                <li><a href="jsp/dutyRegister.jsp"><img alt="" src="images/basicInfo/ico01.png"/><p>值班记事</p></a></li>
                <li><a href="jsp/searchSwitch.jsp"><img alt="" src="images/basicInfo/ico02.png"/><p>交换机信息</p></a></li>
                <li><a href="jsp/uploadDownload.jsp"><img alt="" src="images/basicInfo/ico03.png"/><p>资料共享</p></a></li>
                
                <li><a href="jsp/indexSystemLogManagement.jsp" class="active"><img alt="" src="images/basicInfo/ico05.png"/><p>日志管理</p></a></li>
                
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--日志信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14"><a href="javascript:;">首页</a>&nbsp;&nbsp;>>&nbsp;&nbsp;日志管理</div>
            <hr/>
            <div class="dutyRegister logManagement">
                <form name="dutyQueryCondition" method="post" action="SystemLogServlet?action=systemLogShow">
                    <!-- 查询条件begin -->
                    <div class="dutyQueryCondition f14">
                    	<i>日志类型:</i>
                        <select name="logType" class="logTypeSelect" id="logType">
                        	<option value="">请选择</option>
                            <option value="报修系统用户日志">报修系统用户日志</option>
                            <option value="网管日志">网管日志</option>
                            <option value="权限管理日志">权限管理日志</option>
                            <option value="网页修改日志">网页修改日志</option>
                            <option value="超级管理员日志">超级管理员日志</option>
                        </select>
                        <i>操作者:</i><input type="text" name="operator" id="operator"/>
						<i>记录时间(开始):</i><input type="date" name="startTime" id="startTime" placeholder="年/月/日"/>
						<i>记录时间(结束):</i><input type="date" name="endTime" id="endTime" placeholder="年/月/日"/>
                       <i>日志内容:</i><input type="text" name="logContent" id="logContent"/>
                       <input type="button" value="查询" class="queryButton" id="query"/>
                    </div>
                    <!-- 查询条件end -->
                <div class="pn">
                <a href="javascript:;"><img src="images/dutyRegister/output.png" alt="导出" title="导出"/></a>
                <a href="javascript:;" id="firstPage"><img src="images/dutyRegister/first.png" alt="第一页" title="第一页"/></a>
                <a href="javascript:;" id="up"><img src="images/dutyRegister/previous.png" alt="上一页" title="上一页"/></a>&nbsp;&nbsp;&nbsp;
                <a href="javascript:;" id="down"><img src="images/dutyRegister/next.png" alt="下一页" title="下一页"/></a>
                <a href="javascript:;" id="endPage"><img src="images/dutyRegister/last.png" alt="最后一页" title="最后一页"/></a>
                <span>
                    当前为第<input type="text" placeholder="1" id="page"/>/<font id="totalPage">2</font>页&nbsp;&nbsp;每页
                    <select name="perNum" id="displayRecord">
                        <option value="5">5</option>
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="50">50</option>
                    </select>
                    条
                </span>
                </div>

            	<table id="tb_log">
                    <tr class="head"><td>日志类型</td><td class="event">日志内容</td><td class="event">记录时间</td><td>操作者</td></tr> 
                    <%-- <c:forEach var="sll" items="${systemLogList}" varStatus="status">
                   		 <tr><td>${sll.type}</td><td>${sll.content}</td><td><fmt:formatDate value="${sll.operatorTime}" type="date"/></td><td>${sll.operator}</td></tr> 
                   	</c:forEach> --%>
                </table>
                </form>
            </div>
        </div>
    	<!--日志信息end-->

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