<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- The site is designed by 网络中心.Written by tmn-->
<META http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>onlineRepair</title>
<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/onlineRepair.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/modal.css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/webjs/modal.js"></script>

</head>

<body>
<!--整体包围-->
<div class="wrapper margin0_auto">
	
	<!--头部-->
    <webHead:webHead></webHead:webHead>
    <!--头部结束-->
    
	<!--导航-->
    <webNav:webNav></webNav:webNav>
    <!--导航结束-->

    
	<!--子导航-->
	<div class="subnav margin0_auto">
	<ul class="none_list_style_type display_i">
		<li class="display_i"><span class="none_text_decoration f1768 display_i_b font_huawencaiyun f_blue003399" href="#">网络中心</span></li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="index.html">首页</a>&rsaquo;&rsaquo;</li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="#">网上报修</a></li>
		<form class="subnav_form float_r" action="" method="post">
		<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>
	<!--子导航结束-->
	
	<!--中间表格-->
	<form name="repairMessage" method="post" action="">
	<div class="message">
	<table class="w980 margin0_auto f14">
		<tr><td colspan="4" class="repairMessage">报修信息</td></tr>
		<tr><td class="leftTd"><span class="mandatory">*</span>学号：</td><td><input type="text" class="leftTdText"/></td><td colspan="2" class="rightTd"><span class="mandatory">*</span>姓名：<input type="text" class="rightTdText nameText"/></td></tr>
		<tr><td class="leftTd"><span class="mandatory">*</span>住址：</td><td><input type="text" class="leftTdText"/></td><td colspan="2"class="rightTd"><span class="mandatory">*</span>预约时间：<input type="text" class="rightTdText"/></td></tr>
		
		<tr>
		<td class="leftTd"><span class="mandatory">*</span>联系电话：</td><td><input type="text" class="leftTdText"/></td>
		<td colspan="2" class="rightTd"><span class="mandatory">*</span>故障类型：
		<select name="faultType" class="faultType">
		<option value="choose">请选择</option>
		<option value="rj">锐捷认证失败</option>
		<option value="kuandai">宽带连不上</option>
		</select>
		</td>
		</tr>
		
		<tr>
		<td rowspan="2" class="leftTd">锐捷客户端提示:</td>
		
		<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="server">无法连接认证服务器</td>
		<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="ip">静态IP地址绑定错误</td>
		<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="nouserORpasswordmistake">用户不存在或密码错误</td>
		
		</tr>
		<tr>
		<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="timeout">不在认证时间段内</td>
		<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="overuser">已达到同时在线用户数量上限</td>
		<td><input class="checkboxMessage" type="checkbox" name="rjTips" value="withoutNetworkCard">网卡未连接</td>	
		</tr>
				
		<tr>
		<td rowspan="2" class="leftTd">宽带错误代码:</td>
		
		<td><input class="checkboxMessage" type="checkbox" name="code" value="629/691">629/691</td>	
		<td><input class="checkboxMessage" type="checkbox" name="code" value="651">651</td>	
		<td><input class="checkboxMessage" type="checkbox" name="code" value="734">734</td>	
		</tr>
		<tr>
		<td><input class="checkboxMessage" type="checkbox" name="code" value="720">720</td>	
		<td><input class="checkboxMessage" type="checkbox" name="code" value="711">711</td>	
		<td><input class="checkboxMessage" type="checkbox" name="code" value="619">619</td>	
		</tr>
		
		<tr>
		<td class="leftTd"><span class="mandatory">*</span>问题描述：</td>
		<td colspan="3"><textarea class="text_indent_2em" cols="134" rows="15" name="problemDescribe"></textarea></td>
		</tr>
	</table>
	</div>
	<!--中间表格结束-->
	
	<!--"返回"按钮-->
	<div class="button f14">
	<a href="jsp/webjsp/onlineRepair1.jsp"><span class="display_i_b repairReset">返回</span></a>
	</div>
	<!--"返回"按钮结束-->
	</form>
	<!-- 中间表格结束 -->
	
	
	<!--脚部-->
    <webFoot:webFooter></webFoot:webFooter>
    <!--脚部结束-->
	
</div>
<!--中部包围结束-->

</body>
</html>