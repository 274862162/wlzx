<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <title>下载专区管理</title>
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
    <link rel="stylesheet" type="text/css" href="css/modal.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
    <script type="text/javascript" src="js/b_utils.js"></script>
	<script type="text/javascript" src="js/modal2.js"></script>
	<script type="text/javascript" src="js/superModalAdd2.js"></script>
	
	<script type="text/javascript">
		var page = 1;
		var displayRecord = 5;
		var totalPage = 1;
		$(function(){
			getDownloadSection();
			$("#up").click(function(){
				upPage();
			});
			$("#down").click(function(){
				downPage();
			});
		});
		function upPage(){
			if(page>1){
				page = page-1;
				getDownloadSection();
			}
		}
		function downPage(){
			if(page+1<=totalPage){
				page = page + 1;
				getDownloadSection();
			}
			
		}
		//显示模态框的内容(修改的时候)
		function show(fID){
			$("#downloadSectionFileID").val(fID);
			var param = {};
			param.downloadSectionFileID = fID;
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=getDownloadSection",  
		 	   data : param,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"json", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
		 			alert("请求失败"); 
		 	   },
			   success :function(result){  //请求成功时调用。 
		 		   	$("#textfield").val(result.filePath+"\\"+result.fileName);
		 	   }
	 		});
	 	};
		//删除公告
		function del(fID){
			var param = {};
			param.downloadSectionFileID = fID;
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=delDownloadSection",  
		 	   data : param,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"text", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		alert(result);
					window.location.href="jsp/superManagement4.jsp";		 			 
	 		   }
 			});
		};
		//取下载专区列表
		function getDownloadSection(){
			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			$.ajax({
	 		   url  : "CommonServlet_ajax?action=downloadSectionShow",  
	 		   data : param,
	 		   type : "post",                  
	 		   cache: false,
	 		   dataType:"json", 
	 		   error : function(x, er){
	 			    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		$("#tb_downloadSection").children($("<tr>")).remove();
	 		   		$("#tb_downloadSection").append('<tr class="head"><td>上传时间</td><td>文件标题</td><td>操作人</td><td>操作</td></tr>');
	 		   		$.each(result,function(){
		 			    $.each(this.list,function(){
		 			    	$("#tb_downloadSection").append('\
		 			    		<tr><td>'+this.createTime+'</td>\
		 			    		<td>'+this.fileName+'</td>\
		 			    		<td>'+this.operator+'</td>\
		 			    		<td><a href="javascript:del('+this.downloadSectionFileID+');">删除</a>&frasl;<a href="javascript:show('+this.downloadSectionFileID+');" id="modifyButton">修改</a></td></tr>');
		 			    });
		 			    $('#modifyButton,#recommendedPlan-Button').click(function(){
					 		document.getElementById('recommendedPlan').style.display='block';
					 		document.getElementById('modal-canvas').style.display='block';
					 	});//重新绑定事件
		 			    page = this.page;
		 			    totalPage = this.totalPage;
		 			    $("#pageCount").html("第"+page+"页，共"+totalPage+"页");
		 			 });			 			 
	 		   }
 			});
		};
		/* //显示模态框的内容(修改的时候)
			function show(fID){
		    	var downloadSectionFileID =document.getElementById("downloadSectionFileID");
		    	downloadSectionFileID.value = fID;
				var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("POST","GetDownloadSection",true);
				xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xmlHttp.send("downloadSectionFileID="+fID);
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState==4 && xmlHttp.status==200){
						var text = xmlHttp.responseText;
						var downloadSection = eval("(" + text + ")");
						var fileName = document.getElementById("textfield");
						fileName.value = downloadSection.filePath+"\\"+downloadSection.fileName;
					}
				};
			}; */
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
                <li><a href="jsp/superManagement3.jsp" class="active"><img alt="" src="images/superManagement/3.png"/><p>前台管理</p></a></li>
                <li><a href="jsp/superManagement9.jsp"><img alt="" src="images/superManagement/4.png"/><p>后台管理</p></a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;前台管理</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="jsp/superManagement3.jsp">公告管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement4.jsp" class="f_blue0066ff">下载专区管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement5.jsp">滑动窗口管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement6.jsp">学习天地管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement7.jsp">网络服务管理</a></li>
                <li class="f14 float_l"><a href="jsp/superManagement8.jsp">视频管理</a></li>
            </ul>   
            <hr/>
            <div class="queryWage superManagement4 superManagement5">
            	<table id="tb_downloadSection">
                    <tr class="head"><td>发布时间</td><td>公告标题</td><td>操作人</td><td>操作</td></tr>
                    <%-- <c:forEach var="dsl" items="${downloadSectionList}" varStatus="status">
                    <tr><td><fmt:formatDate value="${dsl.createTime}" type="date"/></td><td>${dsl.fileName }</td><td>${dsl.operator }</td><td><a href="SuperManagementServlet?action=delDownloadSection&downloadSectionFileID=${dsl.downloadSectionFileID }">删除</a>&frasl;<a href="javascript:show(${dsl.downloadSectionFileID });" id="modifyButton">修改</a></td></tr>
                	</c:forEach> --%>
                </table>
                <div class="changePage">
                    <a href="javascript:;" id="up">上一页</a>&frasl;
                    <a href="javascript:;" id="down">下一页</a>
                    <span id="pageCount">第1页，共4页</span>
                </div>
                <div class="button addDownloadFile" id="recommendedPlan-Button2"><input type="button" value="添加下载文件"></div>
            </div>
        </div>	
    	<!--个人信息end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!-- 脚部 -->
    <foot:footer></foot:footer>

    <!--修改 modal begin -->
    <div id="recommendedPlan">
        <div class="recommendedPlan-title">修改下载文件<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement6Form" method="post" action="CommonServlet_redirect?action=updateDownloadSection" enctype="multipart/form-data">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table>
                    <tr><td>文件名</td><td><input type='text' name='textfield' id='textfield' class='txt' /></td></tr>
                    <tr><td>文件</td><td>
                        <input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" /> </td></tr>
                    </table>
                    <input type="hidden" name="downloadSectionFileID" id="downloadSectionFileID"/>
                    <div class="button" id="submitButton"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!--修改 modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->
    
    <!--增加  modal begin -->
    <div id="recommendedPlan2">
        <div class="recommendedPlan-title">添加下载文件<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button2" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement6Form" method="post" action="CommonServlet_redirect?action=addDownloadSection" enctype="multipart/form-data">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table>
                    <tr><td>文件名</td><td><input type='text' name='textfield' id='textfield2' class='txt' /></td></tr>
                    <tr><td>文件</td><td>
                        <input type="file" name="fileField" class="file" id="fileField2" size="28" onchange="document.getElementById('textfield2').value=this.value" /> </td></tr>
                    </table>
                    <div class="button" id="submitButton2"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!--增加 modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->
</div>
<!--中部包围结束-->	
</body>
</html>