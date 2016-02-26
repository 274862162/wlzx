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
    <title>superManagement20</title>
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
</head>


<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	<head:header></head:header>
    <nav:nav></nav:nav>
	
	<!--中部内容区begin-->
	<div class="content">
    	<!--左部菜单begin-->
        <div class="menu">
            <ul class="none_list_style_type">
                <li><a href="SuperManagementServlet?action=roleShow">角色管理</a></li>
                <li><a href="SuperManagementServlet?action=userRoleShow">设置用户角色</a></li>
                <li><a href="SuperManagementServlet?action=webNoticeShow">前台管理</a></li>
                <li><a href="SuperManagementServlet?action=userShow" class="active">后台管理</a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--个人信息begin-->
        <div class="personInfo superManagement20">
			<div class="personInfo_nav f14">超级管理&nbsp;&nbsp;>>&nbsp;&nbsp;后台管理</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="javascript:;">网管账号管理</a></li>
                <li class="f14 float_l"><a href="javascript:;" class="f_blue0066ff">报修系统管理</a></li>
                <li class="f14 float_l"><a href="javascript:;">公告管理</a></li>
                <br/>
                <span class="f14">
                    <a href="javascript:;">楼栋管理 &nbsp;</a>
                    <a href="javascript:;" class="f_blue0066ff">用户管理 &nbsp;</a>
                    <a href="javascript:;">统计分析</a>
                </span>
            </ul>   
            <hr/>
            <div class="queryWage superManagement4">
                <form name="userManage" method="post" action="">
                    <!-- 搜索栏begin -->
                    <div class="searchBar">
                        <span>用户名<input type="text" name="userNo" /></span>
                        <span>用户姓名<input type="text" name="userName" /></span>
                        <span><input type="submit" value="搜索" class="searchButton" /></span>
                    </div>
                    <!-- 搜索栏end -->
                    <table>
                    <tr class="head"><td>用户名</td><td>用户姓名</td><td>密码</td><td>操作</td></tr>
                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;" id="modifyButton">修改</a></td></tr>
                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
                    <tr><td>121542227</td><td>谭毛女</td><td>******</td><td><a href="javascript:;">删除</a>&frasl;<a href="javascript:;">修改</a></td></tr>
                    </table>
                    <div class="changePage">
                        <a href="#">上一页</a>&frasl;
                        <a href="#">下一页</a>
                        <span>第1页，共4页</span>
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
            <form name="superManagement9Form" method="post" action="">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table>
                    <tr><td>用户名</td><td>121542227</td></tr>
                    <tr><td>用户姓名</td><td>谭毛女</td></tr>
                    <tr><td width="500" style="width: 200px !important;">密码</td><td><input type="password" name="password" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit" /></td></tr>
                    <tr><td width="500">确认密码</td><td><input type="password" name="repassword" style="border: none;width: 400px;height: 46px;text-align:center;background-color: inherit"/></td></tr>
                    </table>
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
            <form name="superManagement9Form" method="post" action="">
                <div class="queryWage superManagement4 superManagement7 superManagement8Modal">
                    <table>
                    <tr><td>用户名</td><td>121542227</td></tr>
                    <tr><td>用户姓名</td><td>谭毛女</td></tr>
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