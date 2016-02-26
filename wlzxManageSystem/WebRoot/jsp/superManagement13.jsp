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
    <title>发布后台公告</title>
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
	<script type="text/javascript">
    function createXMLHttpRequest(){
			try{
				return new XMLHttpRequest();
			}catch(e){
				try{
					return ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					try{
						return ActiveXObject("Microsoft.XMLHTTP");
					}catch(e){
						alert("不支持ajax");
						throw(e);
					}
				}
			}
		}
		function sign(){
			//值班签到
			var deal = document.getElementById("check");
			deal.onclick = function(){
				var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("POST","SignServlet",true);
				xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xmlHttp.send(null);
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState==4 && xmlHttp.status==200){
						var text = xmlHttp.responseText;
						alert(text);
					}
				};
			};			
		}
		function addNotice(){
			var param = {};
			param["content"] = $("#notice").val();
			param["department"] = $("#department").val();
			$.ajax({
			   url  : "Circularize",  
			   data : param,
			   type : "post",                  
			   cache: false,               
			   dataType:"text",          
			   error : function(x, er) {
				    //请求失败时调用	
				    alert("失败");	 
			   },
			   success :function(result){  //请求成功时调用。
					alert(result);
			   }
			});
		}
		window.onload = function(){
			//加载公告
			infoShowHide('notice_department', 'notice_content', 200);
			sign();
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
                <li><a href="jsp/superManagement3.jsp" class="active"><img alt="" src="images/superManagement/3.png"/><p>前台管理</p></a></li>
                <li><a href="jsp/superManagement9.jsp"><img alt="" src="images/superManagement/4.png"/><p>后台管理</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;后台管理</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="javascript:;">网管账号管理</a></li>
                <li class="f14 float_l"><a href="javascript:;">报修系统管理</a></li>
                <li class="f14 float_l"><a href="javascript:;" class="f_blue0066ff">公告管理</a></li>
            </ul>   
            <hr/>
            <div class="queryWage superManagement4  backAnnounce">
            <form method="post" action=" ">
            	<table>
                    <tr class="head"><td colspan="2">发布公告</td></tr>
                    <tr>
                        <td>部门</td>
                        <td>
                            <select name="department" id="department">
                                <option name="null">请选择</option>
                                <option name="jsb">技术部</option>
                                <option name="zyb">资源部</option>
                                <option name="zhb">综合部</option>
                            </select>
                        </td>
                    </tr>
                    <tr><td colspan="2"><textarea name="content" id="notice"></textarea></td></tr>
                </table>
                <div class="superManagement16">
                    <input type="button" value="发布" onclick="javascript:addNotice();"/>
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
</div>
<!--中部包围结束-->

</body>
</html>