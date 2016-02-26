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
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
	%>
	<base href= "<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>scheduleQuery-无课表查询</title>
    
  	<link rel="stylesheet" type="text/css" href="css/base.css" />
  	<link rel="stylesheet" type="text/css" href="css/common.css" />
  	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
  	<link rel="stylesheet" type="text/css" href="css/scheduleInfo.css" />
  	<link rel="stylesheet" type="text/css" href="css/scheduleQuery2-modal.css" />
  	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
  	<script type="text/javascript" src="js/b_utils.js"></script>
  	<script type="text/javascript" src="js/scheduleQuery2-notimetable-modal.js"></script>
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
                <li><a href="ScheduleServlet?action=scheduleList"><img alt="" src="images/scheduleInfo/icon2.png"/><p>我的无课表</p></a></li>
                <li><a href="jsp/scheduleQuery.jsp" class="active"><img alt="" src="images/scheduleInfo/icon1.png"/><p>无课表查询</p></a></li>
                <li><a href="ScheduleServlet?action=scheduleList&flag=1"><img alt="" src="images/scheduleInfo/icon3.png"/><p>无课表操作</p></a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--无课表begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">无课表管理系统&nbsp;&nbsp;>>&nbsp;&nbsp;无课表查询</div>
            <hr/>
            <form name="queryCondition-form" method="post" action="ScheduleServlet?action=scheduleQuery">
             <ul class="none_list_style_type queryCondition">
                  <li class="float_l">姓名<input style="height:34px;margin-left:10px;" type="text" name="name" value="${name}" placeholder="输入要查询无课表的名字" /></li>
                  <li class="float_l"><div class="button"><input type="submit" value="查询"/></div></li>
              </ul>
            <div class="dutyRegister repairsManagement" style="margin-top:100px;">
                <table>
                    <tr class="head"><td>学期</td><td>操作</td></tr>
                    <c:forEach var="ft" items="${freeTablesList}" varStatus="status">
                    	<tr>
                    		<td>${ft.freeTableName}</td>
                    		<td>
                    			<a href="javascript:void(0);" onclick="scheduleShow(${userId}, ${ft.freeTableID});" id="recommendedPlan-Button">查看</a>                   		
                    		</td>
                    	</tr>
                    </c:forEach>
                </table>
                <div class="table_footer">
                    <ul>
                        <li>${upDownPage}</li>
                        <li class="float_r">${currentTotalPage}</li>
                    </ul>
                </div>
            </div>
          </form>
        </div>	
    	<!--无课表end--> 

    	<!-- 右侧公告 -->
    <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->

	<!-- 导出无课表弹框begin -->
    <div id="recommendedPlan">
        <div class="recommendedPlan-title">导出无课表<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
        <div class="f14 recommendedPlan">
            <form name="scheduleQueryNoClass" method="post" action="">
                <table class="table_style table-style-modal">
                <tr id="freeTitle" class="f_weight_b">
                    <td colspan="6">无课表</td>
                </tr>
                <tr>
                    <td>课时</td>
                    <td>星期一</td>
                    <td>星期二</td>
                    <td>星期三</td>
                    <td>星期四</td>
                    <td>星期五</td> 
                </tr>
                <tr id="free12">
                    <td>1&2</td>
                </tr>
                <tr id="free34">
                    <td>3&4</td>
                </tr>
                <tr id="free5">
                    <td>5</td>
                </tr>
                <tr id="free67">
                    <td>6&7</td>
                </tr>
                <tr id="free8">
                    <td>8</td>
                </tr>
                <tr id="free910">
                    <td>9&10</td>
                </tr>
                </table>
                <!-- 
                <div class="button button_s"><input type="submit" value="确定导出"/></div>
                 -->
            </form>
        </div>
    </div>   
    <!-- 导出无课表弹框end -->
    
    <!-- 无课表弹框时出现的遮罩锁屏画布begin -->
    <div class="modal-canvas" id="modal-canvas"></div>
    <!-- 无课表弹框时出现的遮罩锁屏画布end -->

	<!-- 脚部 -->
  <foot:footer></foot:footer>
</div>
<!--中部包围结束-->

</body>
</html>