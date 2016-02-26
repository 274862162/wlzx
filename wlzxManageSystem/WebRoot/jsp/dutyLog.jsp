<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta name="description" content="值班记事">
    <title>值班记事</title>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
	%>
	<base href= "<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/dutyLog.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	
  	<script type="text/javascript">
  		
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
                <li><a href="jsp/dutyRegister.jsp" class="active"><img alt="" src="images/basicInfo/ico01.png"/><p>值班记事</p></a></li>
                <li><a href="jsp/searchSwitch.jsp"><img alt="" src="images/basicInfo/ico02.png"/><p>交换机信息</p></a></li>
                <li><a href="jsp/uploadDownload.jsp"><img alt="" src="images/basicInfo/ico03.png"/><p>资料共享</p></a></li>
                <li><a href="jsp/indexSystemLogManagement.jsp"><img alt="" src="images/basicInfo/ico05.png"/><p>日志管理</p></a></li>
                
            </ul>
        </div>
    	<!--左部菜单end-->

    	<!--个人信息begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14"><a href="javascript:;">首页</a>&nbsp;&nbsp;>>&nbsp;&nbsp;值班记事</div>
            <ul class="none_list_style_type">
            	<li class="f14 float_l"><a href="jsp/dutyRegister.jsp">查看记事</a></li>
                <li class="f14 float_l"><a href="javascript:;" class="f_blue0066ff">值班登记</a></li>
            </ul>
            <hr/>
            <div class="dutyLog">
                <form name="dutyLogForm" method="post" action="CommonServlet_redirect?action=dutyLog">
                    <table>
                    <tr class="head"><td colspan="4">事件记录</td></tr>
                    <tr class="tableContent">
                        <td colspan="4" class="dutyLogContent">
                            <textarea name="content"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>处理状态</td>
                        <td>
                            <select name="status">
                            	<option class="handled">未处理</option>
                                <option class="handled">已处理</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <div class="button dutyLogButton">
                    <input type="submit" value="提交" name="submitButton"/>
                    <input type="reset" value="重置" name="resetButton"/>
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