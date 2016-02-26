<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
	%>
	<base href= "<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>scheduleFill-填写无课表</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>

</head>


<body style="height:100%;">
<!--整体包围-->
<div class="wrapper margin0_auto" style="height:100%;">
	<head:header></head:header>
    <nav:nav></nav:nav>
	
	<!--中部内容区begin-->
	<div class="content" style="height:100%;">
    	<!--左部菜单begin-->
        <div class="menu" style="height:100%;float:left;">
            <ul class="none_list_style_type">
                <li><a href="ScheduleServlet?action=scheduleList" class="active"><img alt="" src="images/scheduleInfo/icon2.png"/><p>我的无课表</p></a></li>
                <li><a href="jsp/scheduleQuery.jsp"><img alt="" src="images/scheduleInfo/icon1.png"/><p>无课表查询</p></a></li>
                <li><a href="ScheduleServlet?action=scheduleList&flag=1"><img alt="" src="images/scheduleInfo/icon3.png"/><p>无课表操作</p></a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--无课表begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">无课表管理系统&nbsp;&nbsp;>>&nbsp;&nbsp;我的无课表</div>
            <hr/>
            <form class="dutyRegister repairsManagement" style="margin-top:100px;" name="scheduleFill-form" method="post" action="ScheduleServlet?action=scheduleFill&freeTableID=${freeTableID}">
                <table>
                    <tr class="head">
                        <td colspan="6">${freeTableName}无课表</td>
                    </tr>
                    <tr>
                        <td>课时</td>
                        <td>星期一</td>
                        <td>星期二</td>
                        <td>星期三</td>
                        <td>星期四</td>
                        <td>星期五</td> 
                    </tr>
                    <tr>
                        <td>1&2</td>
                        <td><input type="radio" name="mon12" value="1"/>单&nbsp;<input type="radio" name="mon12" value="2"/>双&nbsp;<input type="radio" name="mon12" value="3"/>单双</td>
                        <td><input type="radio" name="tues12" value="1"/>单&nbsp;<input type="radio" name="tues12" value="2"/>双&nbsp;<input type="radio" name="tues12" value="3"/>单双</td>
                        <td><input type="radio" name="wed12" value="1"/>单&nbsp;<input type="radio" name="wed12" value="2"/>双&nbsp;<input type="radio" name="wed12" value="3"/>单双</td>
                        <td><input type="radio" name="thurs12" value="1"/>单&nbsp;<input type="radio" name="thurs12" value="2"/>双&nbsp;<input type="radio" name="thurs12" value="3"/>单双</td>
                        <td><input type="radio" name="fri12" value="1"/>单&nbsp;<input type="radio" name="fri12" value="2"/>双&nbsp;<input type="radio" name="fri12" value="3"/>单双</td>
                    </tr>
                    <tr>
                        <td>3&4</td>
                        <td><input type="radio" name="mon34" value="1"/>单&nbsp;<input type="radio" name="mon34" value="2"/>双&nbsp;<input type="radio" name="mon34" value="3"/>单双</td>
                        <td><input type="radio" name="tues34" value="1"/>单&nbsp;<input type="radio" name="tues34" value="2"/>双&nbsp;<input type="radio" name="tues34" value="3"/>单双</td>
                        <td><input type="radio" name="wed34" value="1"/>单&nbsp;<input type="radio" name="wed34" value="2"/>双&nbsp;<input type="radio" name="wed34" value="3"/>单双</td>
                        <td><input type="radio" name="thurs34" value="1"/>单&nbsp;<input type="radio" name="thurs34" value="2"/>双&nbsp;<input type="radio" name="thurs34" value="3"/>单双</td>
                        <td><input type="radio" name="fri34" value="1"/>单&nbsp;<input type="radio" name="fri34" value="2"/>双&nbsp;<input type="radio" name="fri34" value="3"/>单双</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td><input type="radio" name="mon5" value="1"/>单&nbsp;<input type="radio" name="mon5" value="2"/>双&nbsp;<input type="radio" name="mon5" value="3"/>单双</td>
                        <td><input type="radio" name="tues5" value="1"/>单&nbsp;<input type="radio" name="tues5" value="2"/>双&nbsp;<input type="radio" name="tues5" value="3"/>单双</td>
                        <td><input type="radio" name="wed5" value="1"/>单&nbsp;<input type="radio" name="wed5" value="2"/>双&nbsp;<input type="radio" name="wed5" value="3"/>单双</td>
                        <td><input type="radio" name="thurs5" value="1"/>单&nbsp;<input type="radio" name="thurs5" value="2"/>双&nbsp;<input type="radio" name="thurs5" value="3"/>单双</td>
                        <td><input type="radio" name="fri5" value="1"/>单&nbsp;<input type="radio" name="fri5" value="2"/>双&nbsp;<input type="radio" name="fri5" value="3"/>单双</td>
                    </tr>
                    <tr>
                        <td>6&7</td>
                        <td><input type="radio" name="mon67" value="1"/>单&nbsp;<input type="radio" name="mon67" value="2"/>双&nbsp;<input type="radio" name="mon67" value="3"/>单双</td>
                        <td><input type="radio" name="tues67" value="1"/>单&nbsp;<input type="radio" name="tues67" value="2"/>双&nbsp;<input type="radio" name="tues67" value="3"/>单双</td>
                        <td><input type="radio" name="wed67" value="1"/>单&nbsp;<input type="radio" name="wed67" value="2"/>双&nbsp;<input type="radio" name="wed67" value="3"/>单双</td>
                        <td><input type="radio" name="thurs67" value="1"/>单&nbsp;<input type="radio" name="thurs67" value="2"/>双&nbsp;<input type="radio" name="thurs67" value="3"/>单双</td>
                        <td><input type="radio" name="fri67" value="1"/>单&nbsp;<input type="radio" name="fri67" value="2"/>双&nbsp;<input type="radio" name="fri67" value="3"/>单双</td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td><input type="radio" name="mon8" value="1"/>单&nbsp;<input type="radio" name="mon8" value="2"/>双&nbsp;<input type="radio" name="mon8" value="3"/>单双</td>
                        <td><input type="radio" name="tues8" value="1"/>单&nbsp;<input type="radio" name="tues8" value="2"/>双&nbsp;<input type="radio" name="tues8" value="3"/>单双</td>
                        <td><input type="radio" name="wed8" value="1"/>单&nbsp;<input type="radio" name="wed8" value="2"/>双&nbsp;<input type="radio" name="wed8" value="3"/>单双</td>
                        <td><input type="radio" name="thurs8" value="1"/>单&nbsp;<input type="radio" name="thurs8" value="2"/>双&nbsp;<input type="radio" name="thurs8" value="3"/>单双</td>
                        <td><input type="radio" name="fri8" value="1"/>单&nbsp;<input type="radio" name="fri8" value="2"/>双&nbsp;<input type="radio" name="fri8" value="3"/>单双</td>
                    </tr>
                    <tr>
                        <td>9&10</td>
                        <td><input type="radio" name="mon910" value="1"/>单&nbsp;<input type="radio" name="mon910" value="2"/>双&nbsp;<input type="radio" name="mon910" value="3"/>单双</td>
                        <td><input type="radio" name="tues910" value="1"/>单&nbsp;<input type="radio" name="tues910" value="2"/>双&nbsp;<input type="radio" name="tues910" value="3"/>单双</td>
                        <td><input type="radio" name="wed910" value="1"/>单&nbsp;<input type="radio" name="wed910" value="2"/>双&nbsp;<input type="radio" name="wed910" value="3"/>单双</td>
                        <td><input type="radio" name="thurs910" value="1"/>单&nbsp;<input type="radio" name="thurs910" value="2"/>双&nbsp;<input type="radio" name="thurs910" value="3"/>单双</td>
                        <td><input type="radio" name="fri910" value="1"/>单&nbsp;<input type="radio" name="fri910" value="2"/>双&nbsp;<input type="radio" name="fri910" value="3"/>单双</td>
                    </tr>
                </table>
                <div class="button">
                	<input type="submit" value="确定"/>
                	<input type="reset" value="重置"/>
                </div> 
            </form>
        </div>	
    	<!--无课表end--> 

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