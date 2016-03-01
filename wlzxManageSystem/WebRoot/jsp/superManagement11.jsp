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
    <title>报修系统管理_用户管理</title>
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
    <script type="text/javascript" src="js/modal.js"></script>
    <script type="text/javascript" src="js/superModalAdd.js"></script>
    <script type="text/javascript">
		var page = 1;
		var displayRecord = 5;
		var totalPage = 1;
		$(function(){
			var message = '<%=request.getAttribute("message")%>';
			if(message!=null && message!="" && message!="null"){
				alert(message);
			}
			getStudent();
			$("#up").click(function(){
				upPage();
			});
			$("#down").click(function(){
				downPage();
			});
			$("#query").click(function(){
				/* page = $("#page").val();
				displayRecord = $("#displayRecord").val();
				totalPage = 1; */
				getStudent();
			});
		});
		function upPage(){
			if(page>1){
				page = page-1;
				getStudent();
			}
		}
		function downPage(){
			if(page+1<=totalPage){
				page = page + 1;
				getStudent();
			}
			
		}
		//显示模态框的内容(修改的时候)
		function show(sID){
			$("#studentID").val(sID);
			var param = {};
			param.studentID = sID;
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=getStudent",  
		 	   data : param,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"json", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
		 			alert("请求失败"); 
		 	   },
			   success :function(result){  //请求成功时调用。
			   		$("#name").val(result.name);
			   		$("#sno").html(result.sno);
			   		$("#password").val(result.password);
			   		$("#repassword").val(result.password);
		 	   }
	 		});
	 	};
		//删除
		function del(sID){
			var param = {};
			param.studentID = sID;
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=delStudent",  
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
					window.location.href="jsp/superManagement11.jsp";		 			 
	 		   }
 			});
		};
		//取学生用户列表
		function getStudent(){
			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			param.name = $("#searchName").val();
			param.sno = $("#searchSno").val();
			$.ajax({
	 		   url  : "CommonServlet_ajax?action=studentShow",  
	 		   data : param,
	 		   type : "post",                  
	 		   cache: false,
	 		   dataType:"json", 
	 		   error : function(x, er){
	 			    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		$("#tb_student").children($("<tr>")).remove();
	 		   		$("#tb_student").append('<tr class="head"><td>用户名</td><td>用户姓名</td><td>操作</td></tr>');
	 		   		$.each(result,function(){
		 			    $.each(this.list,function(){
		 			    	$("#tb_student").append('\
		 			    		<tr><td>'+this.sno+'</td>\
		 			    		<td>'+this.name+'</td>\
		 			    		<td><a href="javascript:del('+this.studentID+');">删除</a>&frasl;<a href="javascript:show('+this.studentID+');" id="modifyButton">修改</a></td></tr>');
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
		//用户联动
		function showUser(){
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=userList",  
		 	   data : null,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"json", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		$("#userID").children($("<option>")).remove();
	 		   		$("#userID1").children($("<option>")).remove();
	 		   		$.each(result,function(){
		 			    $("#userID").append('<option value='+this.userID+'>'+this.userName+'</option>');
		 			    $("#userID1").append('<option value='+this.userID+'>'+this.userName+'</option>');
		 			});
		 			getArea();
	 		   }
 			});
		};
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
                    <a href="jsp/superManagement11.jsp" class="f_blue0066ff">用户管理 &nbsp;</a>
                    <a href="jsp/superManagement12.jsp">统计分析</a>
                </span>
            </ul>   
            <hr/>
            <div class="queryWage superManagement4">
                <form name="userManage" method="post" action="">
                    <!-- 搜索栏begin -->
                    <div class="searchBar" style="margin-top:20px">
                        <span>用户名<input type="text" name="sno" id="searchSno" /></span>
                        <span>用户姓名<input type="text" name="name" id="searchName"/></span>
                        <span><input type="button" value="搜索" class="searchButton" id="query" /></span>
                    </div>
                    <!-- 搜索栏end -->
                    <table id="tb_student">
                    	<tr class="head"><td>用户名</td><td>用户姓名</td><td>操作</td></tr>
	                    <!-- <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;" id="modifyButton">修改</a></td></tr>
	                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
	                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
	                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
	                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr> -->
                    </table>
                    <div class="changePage">
                    <a href="javascript:;" id="up">上一页</a>&frasl;
                    <a href="javascript:;" id="down">下一页</a>
                    <span id="pageCount">第1页，共1页</span>
                </div>
                    <div class="superManagement16">
                        <input type="button" value="添加账户"  id="recommendedPlan-Button2"/>
                        <input type="button" value="表格导入"/>
                    </div>
                </form>
            	
            </div>
        </div>	
    	<!--个人信息end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!-- 脚部 -->
    <foot:footer></foot:footer>

    <!--修改  modal begin -->
    <div id="recommendedPlan">
        <div class="recommendedPlan-title">账户信息<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement9Form" method="post" action="CommonServlet_forward?action=updateStudent">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table>
                    <tr><td>用户名</td><td id="sno"></td></tr>
                    <tr><td>用户姓名</td><td><input id="name" type="text" name="name" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit"/></td></tr>
                    <tr><td width="500" style="width: 200px !important;">密码</td><td><input type="password" name="password" id="password"  style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit" /></td></tr>
                    <tr><td width="500">确认密码</td><td><input type="password" name="repassword" id="repassword" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit"/></td></tr>
                    </table>
                    <input type="hidden" name="studentID" id="studentID">
                    <div class="button" id="submitButton"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!-- 修改 modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->
    
    <!--添加  modal begin -->
    <div id="recommendedPlan2">
        <div class="recommendedPlan-title">账户信息<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button2" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement9Form" method="post" action="CommonServlet_forward?action=addStudent">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table>
                    <tr><td>用户名</td><td><input type="text" name="sno" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit"/></td></tr>
                    <tr><td>用户姓名</td><td><input type="text" name="name" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit"/></td></tr>
                    <tr><td width="500" style="width: 200px !important;">密码</td><td><input type="password" name="password" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit" /></td></tr>
                    <tr><td width="500">确认密码</td><td><input type="password" name="repassword" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit"/></td></tr>
                    </table>
                    <div class="button" id="submitButton2"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!-- 添加  modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->

</div>
<!--中部包围结束-->

</body>
</html>