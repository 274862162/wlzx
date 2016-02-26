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
    <title>超级管理</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <link rel="stylesheet" type="text/css" href="css/modal.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
    <script type="text/javascript" src="js/b_utils.js"></script>
	<script type="text/javascript" src="js/modal2.js"></script>
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
			getRoles();
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
				getRoles();
			}
		}
		function downPage(){
			if(page+1<=totalPage){
				page = page + 1;
				getRoles();
			}
			
		}
			//显示角色名和描述在模态框中
			function show(rID){
		    	var roleID =document.getElementById("roleID");
		    	roleID.value = rID;
		    	var param = {};
		    	param.roleID = rID;
		    	$.ajax({
		 		   url  : "GetOneRole",  
		 		   data : param,
		 		   type : "post",                  
		 		   cache: false,
		 		   dataType:"json", 
		 		   error : function(x, er){
		 			    //请求失败时调用	
		 			    alert("请求失败"); 
		 		   },
		 		   success :function(result){  //请求成功时调用。 
		 		   		$("#roleName1").val(result.roleName);
						$("#roleDescription1").val(result.roleDescription);
						var authID = result.authID;
						var auth = authID.split(",");
						for(var i=1;i<12;i++){
							if($("#"+i.toString())!=null){
								$("#"+i.toString()).attr("checked", false);
							}	
						}
						for(var i=0; i<auth.length;i++){
							$("#"+auth[i].toString()).attr("checked", true);
						}
		 		   }
		 		 });
				/* var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("POST","GetOneRole",true);
				xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xmlHttp.send("roleID="+rID);
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState==4 && xmlHttp.status==200){
						var text = xmlHttp.responseText;
						var role = eval("(" + text + ")");
						document.getElementById("roleName1").value = role.roleName;
						document.getElementById("roleDescription1").value = role.roleDescription;
						var authID = role.authID;
						var auth = authID.split(",");
						for(var i=1;i<12;i++){
							if(document.getElementById(i.toString())!=null){
								document.getElementById(i.toString()).checked = false;
							}	
						}
						for(var i=0; i<auth.length;i++){
							$("#"+auth[i].toString()).checked = true;
						}
					}
				}; */
			};
			//删除角色
			function del(rID){
				var param ={};
				param.roleID = rID;
				$.ajax({
		 		   url  : "DelRole",  
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
		 		   }
		 		 });
			};
		//取角色列表
		function getRoles(){
			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			$.ajax({
	 		   url  : "CommonServlet_ajax?action=roleShow",  
	 		   data : param,
	 		   type : "post",                  
	 		   cache: false,
	 		   dataType:"json", 
	 		   error : function(x, er){
	 			    //请求失败时调用	
	 			    alert("请求失败"); 
	 		   },
	 		   success :function(result){  //请求成功时调用。 
	 		   		$("#tb_roles").children($("<tr>")).remove();
	 		   		$("#tb_roles").append('<tr class="head"><td>角色名</td><td>描述</td><td>操作</td></tr>');
	 		   		$.each(result,function(){
		 			    $.each(this.list,function(){
		 			    	$("#tb_roles").append('\
		 			    		<tr><td>'+this.roleName+'</td>\
		 			    		<td>'+this.roleDescription+'</td>\
		 			    		<td><a href="javascript:del('+this.roleID+');">删除</a>&frasl;<a href="javascript:show('+this.roleID+');" id="modifyButton">修改</a></td></tr>');
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
	</script>
	<style type="text/css">
        .recommendedPlan span{display: inline-block;margin-right: 70px;}
    </style>
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
            	<li><a href="jsp/superManagement1.jsp" class="active"><img alt="" src="images/superManagement/1.png"/><p>角色管理</p></a></li>
                <li><a href="jsp/superManagement2.jsp"><img alt="" src="images/superManagement/2.png"/><p>设置角色</p></a></li>
                <li><a href="jsp/superManagement3.jsp"><img alt="" src="images/superManagement/3.png"/><p>前台管理</p></a></li>
                <li><a href="jsp/superManagement9.jsp"><img alt="" src="images/superManagement/4.png"/><p>后台管理</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;角色管理</div>  
            <hr/>
            <div class="button" style="margin-left:0;margin-top:50px;"><input type="button"  id="recommendedPlan-Button2" value="+新增角色" /></div>
            <!--中间表单信息begin-->
            <div class="dutyRegister repairsManagement">
                <table id="tb_roles">
                    <tr class="head"><td>角色名</td><td>描述</td><td>操作</td></tr>
                    <%-- <c:forEach var="rl" items="${roleList}" varStatus="status">
                    <tr><td>${rl.roleName }</td><td>${rl.roleDescription }</td><td><a href="javascript:del(${rl.roleID });">删除</a>&frasl;<a href="javascript:show(${rl.roleID });" id="modifyButton">修改</a></td></tr>
                	</c:forEach> --%>
                </table>
                <div class="changePage">
                    <a href="javascript:;" id="up">上一页</a>&frasl;
                    <a href="javascript:;" id="down">下一页</a>
                    <span id="pageCount">第1页，共页</span>
                </div>
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

    <!--修改 modal begin -->
    <div id="recommendedPlan">
        <div class="recommendedPlan-title">修改角色<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement6Form" method="post" action="SuperManagementServlet?action=updateRole">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <div class="search" style="margin-bottom: 20px;">
                    <input type="hidden" id="roleID" name="roleID"/><!-- 隐藏的ID -->
                        角色名：<input type="text" id="roleName1" name="roleName1"/>
                    </div>
                    <div style="margin-bottom: 20px;">
                        描&nbsp;&nbsp;&nbsp;述：<input type="text" id="roleDescription1" name="roleDescription1"/>
                    </div>
                    <div class="tickBox">
                        <span><input type="checkbox" id="6" name="auth" value="6"/>前台管理</span>
                        <span><input type="checkbox" id="9" name="auth" value="9"/>报修系统管理</span>
                        <span style="margin-left: -28px;"><input type="checkbox" id="10" name="auth" value="10"/>后台公告管理</span>
                    </div>
                    <div class="tickBox">
                        <span><input type="checkbox" id="11" name="auth" value="11"/>上传资料</span>
                        <span><input type="checkbox" id="3" name="auth" value="3"/>工资管理</span>
                        <span><input type="checkbox" id="8" name="auth" value="8"/>用户账号管理</span>
                    </div>
                    <div class="tickBox">
                        <span><input type="checkbox" id="4" name="auth" value="4"/>考核管理</span>
                        <span><input type="checkbox" id="5" name="auth" value="5"/>调查管理</span>
                        <span><input type="checkbox" id="7" name="auth" value="7"/>无课表管理</span>
                    </div>
                    <div class="button" id="submitButton"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!-- 修改 modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->
    
    <!--新增 modal begin -->
    <div id="recommendedPlan2">
        <div class="recommendedPlan-title">新增角色<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button2" /></div>
        <div class="f14 recommendedPlan">
            <form name="superManagement6Form" method="post" action="CommonServlet_forward?action=addRole">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <div class="search" style="margin-bottom: 20px;">
                    <input type="hidden" id="roleID" name="roleID"/><!-- 隐藏的ID -->
                        角色名：<input type="text" name="roleName"/>
                    </div>
                    <div style="margin-bottom: 20px;">
                        描&nbsp;&nbsp;&nbsp;述：<input type="text" name="roleDescription"/>
                    </div>
                    <div class="tickBox">
                        <span><input type="checkbox" name="auth" value="6"/>前台管理</span>
                        <span><input type="checkbox" name="auth" value="9"/>报修系统管理</span>
                        <span style="margin-left: -28px;"><input type="checkbox" name="auth" value="10"/>后台公告管理</span>
                    </div>
                    <div class="tickBox">
                        <span><input type="checkbox" name="auth" value="11"/>上传资料</span>
                        <span><input type="checkbox" name="auth" value="3"/>工资管理</span>
                        <span><input type="checkbox" name="auth" value="8"/>用户账号管理</span>
                    </div>
                    <div class="tickBox">
                        <span><input type="checkbox" name="auth" value="4"/>考核管理</span>
                        <span><input type="checkbox" name="auth" value="5"/>调查管理</span>
                        <span><input type="checkbox" name="auth" value="7"/>无课表管理</span>
                    </div>
                    <div class="button" id="submitButton2"><input type="submit" value="确定"></div>
                </div>
            </form>
        </div>
    </div>
    <!-- 新增 modal end -->
    <!-- 弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 弹框时出现的遮罩锁屏画布end -->
    
</div>
<!--中部包围结束-->


</body>
</html>