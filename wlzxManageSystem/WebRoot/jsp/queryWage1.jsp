<%@ page contentType="text/html" pageEncoding="utf-8"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>工资设置</title>
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
	<link rel="stylesheet" type="text/css" href="css/validationEngine.jquery.css" />
	<script type="text/javascript" src="js/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery.validationEngine.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){  
	        $("#wage_form").validationEngine('attach');
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
                <li><a href="jsp/queryWage1.1.jsp"><img alt="" src="images/basicInfo/ico01.png"/><p>工资设置</p></a></li>
                <li><a href="jsp/searchSwitch.jsp"><img alt="" src="images/basicInfo/ico02.png"/><p>个人工资</p></a></li>
                <li><a href="jsp/uploadDownload.jsp"><img alt="" src="images/basicInfo/ico03.png"/><p>工资统计</p></a></li>
            </ul>
        </div>
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">首页&nbsp;&nbsp;>>&nbsp;&nbsp;工资设置</div>
            <hr/>
            <div class="personInfo_base">
                <form id="wage_form" name="personInfo_pwd" method="post" action="PayRollSystem/PayRollServlet?action=payRollSetShowAction&option=update">
            	<div class="f14">
                	<p>总<span style="margin-left:21px;"></span>工<span style="margin-left:21px;"></span>资：<input value="${payrollSet.allMoney }" type="text" name="allMoney" class="validate[required] text-input" id="temp01"> 元</p><br/>
                    <p>值班迟到扣除：<input value="${payrollSet.latePerMoney}" type="text" name="latePerMoney" class="validate[required] text-input" id="temp02"> 元/次</p><br/>
                    <p>旷班扣除金额：<input value="${payrollSet.noDutyPerMoney}" type="text" name="noDutyPerMoney" class="validate[required] text-input" id="temp03"> 元/次</p><br/>
                    <p>报修逾期扣除：<input value="${payrollSet.isOverDueMoney}" type="text" name="isOverDueMoney" class="validate[required] text-input" id="temp04"> 元/单</p><br/>
                    <p>其他扣除金额：<input value="${payrollSet.otherThrowMoney}" type="text" name="otherThrowMoney" class="validate[required] text-input" id="temp05"> 元</p><br/><br/>
                    <p>其他增加金额：<input value="${payrollSet.otherAddMoney}" type="text" name="otherAddMoney" class="validate[required] text-input" id="temp06"> 元</p><br/>
                </div>
                <div class="personInfo_button button">
                    <input type="submit" value="保存" />
                    <a href="jsp/queryWage1.1.jsp"><input type="button" value="返回" /></a>
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