<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>网络中心学生技术团队_用户管理</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/superManagement.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <link rel="stylesheet" type="text/css" href="css/modal.css" />
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	<!--<script type="text/javascript" src="js/navTag.js"></script>  -->
	<script type="text/javascript" src="js/modal.js"></script>
	
    <style type="text/css">
        .dutyRegister table tr td{width: 268px;}
        .recommendedPlan span{display: inline-block;margin-right: 70px;}
    </style>
    <script type="text/javascript">
    	var page = 1;
		var displayRecord = 5;
		var totalPage = 1;
		$(function(){
			var message = '<%=request.getAttribute("message")%>';
			if(message!=null && message!="" && message!="null"){
				alert(message);
			}	
			getUserRoles();
			$("#up").click(function(){
				upPage();
			});
			$("#down").click(function(){
				downPage();
			});
			$("#firstPage").click(function(){
				page = 1;
				getUserRoles();
			});
			$("#endPage").click(function(){
				page = totalPage;
				getUserRoles();
			});
			$("#displayRecord").change(function(){
				displayRecord = $("#displayRecord").val();
				getUserRoles();
			});
			$("#query").click(function(){
				page = $("#page").val();
				displayRecord = $("#displayRecord").val();
				totalPage = 1;
				getUserRoles();
			});
		});
		function upPage(){
			if(page>1){
				page = page-1;
				getUserRoles();
			}
		}
		function downPage(){
			if(page+1<=totalPage){
				page = page + 1;
				getUserRoles();
			}
			
		}
		//取用户列表
		function getUserRoles(){
			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			param.userName = $("#userName").val();
			$.ajax({
	 		   url  : "CommonServlet_ajax?action=userRoleShow",  
	 		   data : param,
	 		   type : "post",                  
	 		   cache: false,
	 		   dataType:"json", 
	 		   error : function(x, er){
	 			    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		$("#tb_userRoles").children($("<tr>")).remove();
	 		   		$("#tb_userRoles").append('<tr class="head"><td>角色名</td><td>描述</td><td>操作</td></tr>');
	 		   		$.each(result,function(){
		 			    $.each(this.list,function(){
		 			    	$("#tb_userRoles").append('\
		 			    		<tr><td>'+this.userName+'</td>\
		 			    		<td>'+this.roleName+'</td>\
		 			    		<td><a href="javascript:show('+this.ID+');" id="modifyButton">修改</a></td></tr>');
		 			    });
		 			    $('#modifyButton,#recommendedPlan-Button').click(function(){
					 		document.getElementById('recommendedPlan').style.display='block';
					 		document.getElementById('modal-canvas').style.display='block';
					 	});//重新绑定事件
		 			    $("#page").val(this.page);
		 			    $("#totalPage").html(this.totalPage);
		 			    page = this.page;
		 			    totalPage = this.totalPage;
		 			 });			 			 
	 		   }
 			});
		};
		//显示模态框的内容
			function show(urID){
		    	$("#userRoleID").val(urID);
		    	var param = {};
		    	param.userRoleID = urID;
		    	$.ajax({
		 		   url  : "GetRole",  
		 		   data : param,
		 		   type : "post",                  
		 		   cache: false,
		 		   dataType:"json", 
		 		   error : function(x, er){
		 			    //请求失败时调用	
		 			    alert("请求失败"); 
		 		   },
	 		  	   success :function(result){  //请求成功时调用。 
						var sp = "";
						for(var i=0;i<result.length-1;i++){
							sp = sp+ "<span><input type='radio' name='roleName' value='"+result[i].roleName+"' ";
							if(result[i].roleName == result[result.length-1].roleName){
								sp = sp+"checked";
							}
							sp = sp +"/>"+result[i].roleName+"</span>";
						}		
						$("#role").html(sp);	
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
                <li><a href="jsp/superManagement2.jsp" class="active"><img alt="" src="images/superManagement/2.png"/><p>设置角色</p></a></li>
                <li><a href="jsp/superManagement3.jsp"><img alt="" src="images/superManagement/3.png"/><p>前台管理</p></a></li>
                <li><a href="jsp/superManagement9.jsp"><img alt="" src="images/superManagement/4.png"/><p>后台管理</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;设置用户角色</div>
            <ul class="none_list_style_type">
                <li class="f14 float_l"><a href="javascript:;" class="f_blue0066ff">用户权限管理</a></li>
            </ul>   
            <hr/>
            <!--中间表单信息begin-->
            <div class="superManagement superManagement2 dutyRegister">
                <form name="superManagement2Role" method="post" action="SuperManagementServlet?action=userRoleShow">
                <div class="search" style="margin-top:30px">
              		  用户名：<input type="text" name="userName" id="userName"/>
              		      <input type="button" value="搜索" id="query"/>
                </div>
                    <div class="pn" style="margin-left: -320px;margin-top: -20px;">
                        <a href="javascript:;"><img src="images/dutyRegister/output.png" alt="导出" title="导出"/></a>
                        <a href="javascript:;" id="firstPage"><img src="images/dutyRegister/first.png" alt="第一页" title="第一页"/></a>
                        <a href="javascript:;" id="up"><img src="images/dutyRegister/previous.png" alt="上一页" title="上一页"/></a>&nbsp;&nbsp;&nbsp;
                        <a href="javascript:;" id="down"><img src="images/dutyRegister/next.png" alt="下一页" title="下一页"/></a>
                        <a href="javascript:;" id="endPage"><img src="images/dutyRegister/last.png" alt="最后一页" title="最后一页"/></a>
                        <span>
                            当前为第<input type="text" value="1" id="page"/>/<font id="totalPage"></font>页&nbsp;&nbsp;每页
                            <select name="perNum" id="displayRecord">
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select>
                            条
                        </span>
                    </div>

                    <table style="margin-left:-250px;" id="tb_userRoles">
                    <tr class="head"><td>用户名</td><td>角色</td><td>操作</td></tr> 
                    <%-- <c:forEach var="url" items="${userRoleList }" varStatus="status">
                    <tr><td>${url.userName }</td><td>${url.roleName }</td><td><a href="javascript:show(${url.ID });" id="modifyButton">修改</a></td></tr>
                	</c:forEach> --%>
                </table>
                </form>
            </div>
            <!--中间表单信息end-->
        </div>	
    	<!--个人信息end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!-- 脚部 -->
    <foot:footer></foot:footer>
    
    <!-- modal begin -->
    <div id="recommendedPlan">
        <div class="recommendedPlan-title">角色管理<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement6Form" method="post" action="CommonServlet_forward?action=changeUserRole">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal" style="margin-top: 50px;">
                  	<input type="hidden" id="userRoleID" name="userRoleID"/>
                    <div id="role" class="tickBox"></div>
                    <div class="superManagement1Button button" id="submitButton"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!-- modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->
    
</div>
<!--中部包围结束-->

</body>
</html>