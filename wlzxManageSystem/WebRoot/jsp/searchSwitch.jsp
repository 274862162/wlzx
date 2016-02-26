<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>网络中心学生技术团队_交换机查询</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
    %>
    <base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
	<link rel="stylesheet" type="text/css" href="css/searchSwitchResult.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	
	<script>
		function search(){
			var param = {};
			param["building"] = $("#building").val();
			param["buildingNo"] = $("#buildingNo").val();
			$.ajax({
			   url  : "GetSwitch",  
			   data : param,
			   type : "post",                  
			   cache: false,               
			   dataType:"json",          
			   error : function(x, er) {
				    //请求失败时调用	
				    alert("查询失败");	 
			   },
			   success :function(result){  //请求成功时调用。
					var file = "files/switchRegister/"+result.switchRegister;
					var photo = "files/switchPhoto/"+result.photo;
					if(result!=null || result!=""){
						$("#switchRegister").attr("src",file);
						$("#switchPhoto").attr("src",photo);
						$(".search_result").show();
					}else{
						alert("没有该楼层的交换机信息。");
					}
					
			   }
			});
		}
	</script>
</head>


<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	<head:header></head:header>
    <nav:nav></nav:nav>

	<!--中部内容区begin-->
	<div class="content">
    	<!--左部菜单begin-->
        <div class="menu" style="height:100%;float:left">
            <ul class="none_list_style_type" style="height:100%;">
                <li><a href="jsp/dutyRegister.jsp"><img alt="" src="images/basicInfo/ico01.png"/><p>值班记事</p></a></li>
                <li><a href="jsp/searchSwitch.jsp" class="active"><img alt="" src="images/basicInfo/ico02.png"/><p>交换机信息</p></a></li>
                <li><a href="jsp/uploadDownload.jsp"><img alt="" src="images/basicInfo/ico03.png"/><p>资料共享</p></a></li>
                
                <li><a href="jsp/indexSystemLogManagement.jsp"><img alt="" src="images/basicInfo/ico05.png"/><p>日志管理</p></a></li>
                
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--搜索区begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">首页&nbsp;&nbsp;>>&nbsp;&nbsp;交换机信息&nbsp;&nbsp;>>&nbsp;&nbsp;搜索</div>
            <form name="searchSwitchResult" method="post" action="SearchServlet?action=searchSwitch">
                <div class="search_content f14">
                    楼栋
                    <select name="building" id="building">
                        <option value="1">1栋</option>
                        <option value="2">2栋</option>
                        <option value="8">8栋</option>
                        <option value="9">南苑9栋</option>
                    </select>
                    楼层
                    <select name="buildingNo" id="buildingNo">
                    	<option value="1">1楼</option>
                    	<option value="2">2楼</option>
                        <option value="3">3楼</option>
                        <option value="4">4楼</option>
                        <option value="5">5楼</option>
                        <option value="6">6楼</option>
                    </select>
                    <input type="button" class="f14 search-button" value="搜索" onclick="javascript:search();"/>
                </div>
                <div class="search_result" style="display:none;width:100%;">
                    <span class="f14">搜索结果</span>
                    <div>
                        <div class="search_switch float_l">
                            <img width="530px" height="900px" src="" id="switchRegister" alt="searchSwitchResult" title="searchSwitchResult"/>
                        </div>
                        <img style="margin-top: 10px" width="300px" height="450px" src="" id="switchPhoto"/>
                    </div>
                </div>
            </form>                     
        </div>
    	<!--搜索区end-->

    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!--脚部begin-->
    <div class="footer margin0_auto switchFooter"></div>
    <!--脚部end-->
</div>
<!--中部包围结束-->

</body>
</html>