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
    <meta name="description" content="记事列表">
    <title>网络中心学生技术团队_成员列表</title>
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
    <link rel="stylesheet" type="text/css" href="css/dutyLog-modal.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyLog.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
    <script type="text/javascript" src="js/b_utils.js"></script>
    <script type="text/javascript" src="js/dutyLog-modal.js"></script>
	<script type="text/javascript" src="js/check-modal.js"></script>
	
	<script type="text/javascript">
		var option="allUser";
		var page = 1;
		var displayRecord = 5;
		var totalPage = 1;
		$(function(){
			getDutyRegister();
			$("#allUser").click(function(){
				option="allUser";
				page=1;
				getDutyRegister();
			});
			$("#tech_dep").click(function(){
				option="tech_dep";
				page=1;
				getDutyRegister();
			});
			$("#reso_dep").click(function(){
				option="reso_dep";
				page=1;
				getDutyRegister();
			});
			$("#gene_dep").click(function(){
				option="gene_dep";
				page=1;
				getDutyRegister();
			});
			$("#up").click(function(){
				if(page>1){
				page = page-1;
				getDutyRegister();
				}
			});
			$("#down").click(function(){
				if(page+1<=totalPage){
				page = page + 1;
				getDutyRegister();
				}
			});
			$("#firstPage").click(function(){
				page = 1;
				getDutyRegister();
			});
			$("#endPage").click(function(){
				page = totalPage;
				getDutyRegister();
			});
			$("#displayRecord").change(function(){
				displayRecord = $("#displayRecord").val();
				getDutyRegister();
			});
		});
  		function getDutyRegister(){
  			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=userManage&option="+option+"",  
		 	   data : param,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"json", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
		 		    alert("请求失败"); 
		 	   },
		 	   success :function(result){  //请求成功时调用。 
		 	   		$("#tb_dutyRegister").children($("<tr>")).remove();
		 	   		$("#tb_dutyRegister").append('<tr class="head"><td>用户名</td><td>学号</td><td>姓名</td><td>专业</td><td>住址</td><td>联系方式</td><td>部门</td><td>负责楼栋</td><td>操作</td></tr>');
		 	   		$.each(result,function(){
					    $.each(this.list,function(){
					    	$("#tb_dutyRegister").append('\
			 			   	<tr><td>'+this.userName+'</td>\
			 			   	<td>'+this.sno+'</td>\
			 			   	<td>'+this.name+'</td>\
			 			   	<td>'+this.major+'</td>\
			 			   	<td>'+this.dormitory+'</td>\
			 			   	<td>'+this.longTelephone+'  '+this.shortTelephone+'</td>\
			 			   	<td>'+this.section+'</td>\
			 			   	<td>'+this.repArea+'</td>\
                            <td><a href="javascript:checkDutyRegister('+this.userID+');" id="checkButton"><img src="images/dutyRegister/check.png" title="查看" alt="查看"/></a></td>');
			 			   	});
			 			//page = this.page;
			 			totalPage = this.totalPage;
			 			$("#page").val(page);
			 			$("#totalPage").html(totalPage);
			 		});			 			 
		 		 }
	 		});
  		}
		//显示处理模态框的内容
		function dealingDutyRegister(noteID){
			var param = {};
			param["noteID"] = noteID;
			$.ajax({
			   url  : "ShowDutyRegisterServlet",  
			   data : param,
			   type : "post",                  
			   cache: false,               
			   dataType:"json",          
			   error : function(x, er) {
				    //请求失败时调用	
				    alert("失败");	 
			   },
			   success :function(result){  //请求成功时调用。
					$("#dutyLogContent").html(result.content);
					$("#recorder").html(result.recorder);
					$("#noteID").val(result.noteID);
					$("#modal-canvas").show();
					$("#recommendedPlan").show();
			   }
			});
		};
			//显示查看模态框的内容
		function checkDutyRegister(userID){
			var param = {};
			param["noteID"] = noteID;
			$.ajax({
			   url  : "ShowDutyRegisterServlet",  
			   data : param,
			   type : "post",                  
			   cache: false,               
			   dataType:"json",          
			   error : function(x, er) {
				    //请求失败时调用	
				    alert("失败");	 
			   },
			   success :function(result){  //请求成功时调用。
			   		var note = result;
					$("#dutyLogContent_check").html(note.content);
					$("#recorder_check").html(note.recorder);
					if(note.status){
						$("#status").html("已处理");
					}else{
						$("#status").html("未处理");
					}
					$("#dealingContent").html(note.dealingContent);
					$("#handler").html(note.handler);
					$("#check-modal-canvas").show();
					$("#checkModal").show();
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
        <!--左部菜单begin-->
        <div class="menu" style="height:100%;float:left">
            <ul class="none_list_style_type" style="height:100%;">
                <li><a href="jsp/search.jsp"><img alt="" src="images/basicInfo/ico06.png"/><p>快速搜索</p></a></li>
                <li><a href="CommonServlet_forward?action=personInfo&option=check"><img alt="" src="images/userManage/icon02.png"/><p>个人信息</p></a></li>
                <li><a href="jsp/userManage.jsp" class="active"><img alt="" src="images/userManage/icon03.png"/><p>成员信息</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14"><a href="javascript:;">成员管理</a>&nbsp;&nbsp;>>&nbsp;&nbsp;成员信息</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a id="allUser" href="javascript:;" class="f_blue0066ff">全部</a></li>
            	<li class="f14 float_l"><a id="tech_dep" href="javascript:;">技术部</a></li>
            	<li class="f14 float_l"><a id="reso_dep" href="javascript:;">资源部</a></li>
            	<li class="f14 float_l"><a id="gene_dep" href="javascript:;">综合部</a></li>
            </ul>
            <hr/>
            <div id="allUser">
	            <div class="button"><input type="button" value="+新增用户" onClick="" /></div>
	            <div class="dutyRegister">
	                <div class="pn">
	                <a href="javascript:;" id="firstPage"><img src="images/dutyRegister/first.png" alt="第一页" title="第一页"/></a>
	                <a href="javascript:;" id="up"><img src="images/dutyRegister/previous.png" alt="上一页" title="上一页"/></a>&nbsp;&nbsp;&nbsp;
	                <a href="javascript:;" id="down"><img src="images/dutyRegister/next.png" alt="下一页" title="下一页"/></a>
	                <a href="javascript:;" id="endPage"><img src="images/dutyRegister/last.png" alt="最后一页" title="最后一页"/></a>
	                <span>
	                    当前为第<input type="text" placeholder="1" id="page"/>/<font id="totalPage"></font>页&nbsp;&nbsp;每页
	                    <select name="perNum" id="displayRecord">
	                        <option value="5">5</option>
	                        <option value="10">10</option>
	                        <option value="20">20</option>
	                        <option value="50">50</option>
	                    </select>
	                    条
	                </span>
	                </div>
					
	            	<table id="tb_dutyRegister">
	                 </table>
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
    
     <!-- 处理报修单modal begin -->
    <div id="recommendedPlan">
        <div class="recommendedPlan-title">处理记事<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="dutyHandle" method="post" action="CommonServlet_redirect?action=dealingDutyRegister">
            	<input type="hidden" name="noteID" id="noteID" value="">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table class="dutyLog" style="width:auto;">
                    <tr class="head"><td colspan="4">事件记录</td></tr>
                    <tr class="tableContent">
                        <td colspan="4" class="dutyLogContent" id="dutyLogContent">
                            
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 200px;height:47px;">记录人</td>
                        <td class="recordPeople" id="recorder"></td>
                        <td style="width:200px;">处理状态</td>
                        <td style="width:200px;">
                            <select name="status">
                                <option>已处理</option>
                                <option>未处理</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="145" height="42">处理说明</td>
                        <td colspan="3" width="585" height="42" class="dutyLogContent remarks">
                            <textarea name="dealingContent" style="background-color: inherit;"></textarea>
                        </td>
                    </tr>
                </table>
                    <div class="button handleButton">
                        <input type="submit" value="确定" id="submitButton"/>
                        <input type="reset" value="重置"/>
                        <a href="jsp/dutyRegister.jsp"><input type="button" value="返回"/></a>
                    </div>
                </div>
                </form>
        </div>
    </div>
    <!-- 处理报修单 end -->
    <!-- 背景遮挡 -->
    <div class="modal-canvas" id="modal-canvas"></div>

    <!-- 查看报修单modal begin -->
    <div id="checkModal">
        <div class="recommendedPlan-title">查看记事<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="check-close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="dutyHandle" method="post" action="">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table class="dutyLog">
                    <tr class="head"><td colspan="6">事件记录</td></tr>
                    <tr class="tableContent">
                        <td colspan="6" class="dutyLogContent" id="dutyLogContent_check"></td>
                    </tr>
                    <tr>
                        <td>记录人</td>
                        <td class="recordPeople" id="recorder_check"></td>
                        <td>处理人</td>
                        <td class="recordPeople" id="handler"></td>
                        <td>处理状态</td>
                        <td id="status">
                        </td>
                    </tr>
                    <tr>
                        <td>处理说明</td>
                        <td colspan="5"class="dutyLogContent remarks" id="dealingContent"></td>
                    </tr>
                </table>
                    <div class="button handleButton">
                        <a href="jsp/dutyRegister.jsp"><input type="button" id="backButton" value="关闭"/></a>
                    </div>
                </div>
                
                </form>
        </div>
    </div>
    <!-- 查看报修单 end -->
    <!-- 背景遮挡 -->
    <div class="modal-canvas" id="check-modal-canvas"></div>
</div>
<!--中部包围结束-->

</body>
</html>