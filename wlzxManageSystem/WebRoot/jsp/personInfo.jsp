<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by hsg-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="个人信息">
    <title>网络中心学生技术团队_个人信息</title>
	<%   
		String path = request.getContextPath();   
		String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
	%>   
	<base href= "<%=basePath%>">  
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	<script type="text/javascript" src="js/personInfo.js"></script>
	<script type="text/javascript" src="js/navTag.js"></script>
	<script>
		
	/* function createXMLHttpRequest(){
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
                <li><a href="jsp/search.jsp"><img alt="" src="images/basicInfo/ico06.png"/><p>快速搜索</p></a></li>
                <li><a href="CommonServlet_forward?action=personInfo&option=check" class="active"><img alt="" src="images/userManage/icon02.png"/><p>个人信息</p></a></li>
                <li><a href="jsp/userManage.jsp"><img alt="" src="images/userManage/icon03.png"/><p>成员信息</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14"><a href="javascript:;">成员管理</a>&nbsp;&nbsp;>>&nbsp;&nbsp;个人信息</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="UserServlet?action=personInfo&option=update&option=check" class="f_blue0066ff">基本信息</a></li>
                <li class="f14 float_l"><a href="jsp/changePassword.jsp">修改密码</a></li>
                <!-- <li class="f14 float_l"><a href="UserServlet?action=objectInfo">物品登记信息</a></li> -->
            </ul>
            <hr/>
            <div class="personInfo_base">
                <form name="personInfo_pwd" method="post" action="UserServlet?action=personInfo&option=update">
            	<div class="f14">
                	<p style="margin-left: -14px;">用户名：${user.userName }<b id="errorUserNo" style="display:none;color:red;">*请输入正确的用户名</b></p><br/>
                	<p>性别：${user.sex }</p><br/>
                	<p>姓名：<input type="text" name="name" value=${user.name }></p><br/>
                	<p>学号：<input type="text" name="sno" value=${user.sno }></p><br/>
                    <p>住址：<input type="text" name="dormitory" value=${user.dormitory }></p><br/>
                    <p>年龄：<input type="text" name="age" value=${user.age }></p><br/>
                    <p>专业：<input type="text" name="major" value=${user.major }></p><br/>
                    <p>长号：<input type="text" name="longPhone" id="longPhone" value=${user.longTelephone }><b id="errorLongPhone" style="display:none;color:red;">*请输入11位数字</b></p><br/>
                    <p>短号：<input type="text" name="shortPhone" id="shortPhone" value=${user.shortTelephone }><b id="errorShortPhone" style="display:none;color:red;">*请输入4-6位数字</b></p><br/>
                    <p>部门：${user.section }</p><br/>
                    <p style="margin-left: -29px;">负责楼栋：${user.repArea }</p><br/>
                </div>
                <div class="personInfo_button button">
                    <input type="submit" value="修改" />
                    <a href="jsp/search.jsp"><input type="button" value="返回" /></a>
                </div>
                </form>
            </div>
        </div>
    	<!--个人信息end-->

    	<!--公告栏begin-->
        <notice:notice></notice:notice>
        <!--公告栏end-->
    </div>
	<!--中部内容区end-->


	<!--脚部begin-->
	<foot:footer></foot:footer>
	<!--脚部end-->
</div>
<!--中部包围结束-->

</body>
</html>