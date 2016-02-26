<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="testSession.jsp"%>
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
<title>onlineRepair2我要报修</title>
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
<script type="text/javascript" src="js/modal.js"></script>
<script type="text/javascript" src="js/webjs/laydate/laydate.js"></script>
<script type="text/javascript">
	//获取客户端系统时间
	var date = new Date();
   	var year = date.getFullYear();
   	var month = date.getMonth()+1;
   	var day = date.getDate();
   	var h=date.getHours();
   	var m=date.getMinutes();
	var s=date.getSeconds();
	var time=year+"-"+month+"-"+day+"-"+h+":"+m+":"+s;    	
   // var timeElement=document.getElementById("time");	
	//timeElement.setAttribute("value",time);	
	function judgeNull(){//判空
		var snoObj=$("#sno").val();
		var stuNameObj=$("#stuName").val();
		var telephoneObj=$("#telephone").val();
		var appointmentTimeObj=$("#appointmentTime").val();
		var appointmentTextObj=$("#appointmentText").val();
		var faultTypeObj=$("#faultType").find("option:selected").text();
		var stuAreaObj=$("#stuArea").find("option:selected").text();
		var stuRoomObj=$("#stuRoom").val();
		var descriptionObj=$("#description").val();
		
		var clientCode=document.getElementsByName("clientCode");  //返回数组
		//取到对象数组后，循环检测它是不是被选中
		var clientCodeObj='';
		for(var i=0; i<clientCode.length; i++){
		  if(clientCode[i].checked){
		  	clientCodeObj+=clientCode[i].value+',';
		  }
		}
		var errorCode=document.getElementsByName("errorCode");  //返回数组
		//取到对象数组后，循环检测它是不是被选中
		var errorCodeObj='';
		for(var i=0; i<errorCode.length; i++){
		  if(errorCode[i].checked){
		  	errorCodeObj+=errorCode[i].value+',';
		  }
		}
		if(snoObj.length!==9){
			alert("学号输入不正确！");
		}else if(stuNameObj.length==0){
			alert("姓名不能为空！");		
		}else if(telephoneObj.length==0){
			alert("联系电话不能为空！");		
		}else if(appointmentTimeObj.length==0){
			alert("预约时间不能为空！");		
		}else if(faultTypeObj=="请选择"){
			alert("故障类型不能为空！");		
		}else if(stuAreaObj=="请选择"){
			alert("住址不能为空！");		
		}else if(stuRoomObj.length==0){
			alert("房间号不能为空！");		
		}else if(descriptionObj.length==0){
			alert("问题描述不能为空！");		
		}else{
			form_submit(snoObj,stuNameObj,telephoneObj,appointmentTimeObj,appointmentTextObj,
			faultTypeObj,clientCodeObj,errorCodeObj,stuAreaObj,stuRoomObj,descriptionObj);
		}
	}
	function form_submit(sno,stuName,telephone,appointmentTime,appointmentText,faultType,clientCodeObj,errorCodeObj,stuArea,stuRoom,description){//表单提交
		var url="onlineRepairSystem/OnlineRepairServlet?action=saveRepairList&sno="+encodeURI(sno+"&stuName="+stuName+"&telephone="+telephone
		+"&appointmentTime="+appointmentTime+"&appointmentText="+appointmentText+"&faultType="+faultType+"&clientCodeObj="+clientCodeObj
		+"&errorCodeObj="+errorCodeObj+"&stuArea="+stuArea+"&stuRoom="+stuRoom+"&description="+description
		+"&repairTime="+time);
		$.get(url,null,callback);
		function callback(data){
			alert(data);
			window.location.reload(); 		
		}	
	}
	function recommendSolution(){ //推荐方案链接点击事件
		//alert("hah");
		var faultTypeObj=$("#faultType").find("option:selected").text();
		var clientCode=document.getElementsByName("clientCode");  //返回数组
		//取到对象数组后，循环检测它是不是被选中
		var clientCodeObj='';
		for(var i=0; i<clientCode.length; i++){
		  if(clientCode[i].checked){
		  	clientCodeObj+=clientCode[i].value+',';
		  }
		}
		var errorCode=document.getElementsByName("errorCode");  //返回数组
		//取到对象数组后，循环检测它是不是被选中
		var errorCodeObj='';
		for(var i=0; i<errorCode.length; i++){
		  if(errorCode[i].checked){
		  	errorCodeObj+=errorCode[i].value+',';
		  }
		}
		var url="onlineRepairSystem/OnlineRepairServlet?action=recommendRepairSolution&faultType="+encodeURI(faultTypeObj+"&clientCodeObj="+clientCodeObj
		+"&errorCodeObj="+errorCodeObj);
		$.get(url,null,callback);
		function callback(data){
			//alert(data);
			var obj=eval(data);
			for(var i=0;i<obj.length;i++){//遍历JSon数组输出到表格中
				var row=$("#content").clone();
				row.find("#codeDescript").text(obj[i].codeDescript);
				row.find("#solution").text(obj[i].solution);
				row.appendTo("#solutionTable");				
			}
			$("#solutionTable").find("#content").remove();//移除模板列
		}
	}
	function validateNumber(e, pnumber){//控制文本框只能输入数字
		if (!/^\d+$/.test(pnumber)){		
		e.value = /^\d+/.exec(e.value);}		
		return false;
	}
	function appointTextLimit() 
	{ 
		var curLength=$("#appointmentText").val().length; 
		if(curLength>15) 
		{ 
			var num=$("#appointmentText").val().substr(0,15); 
			$("#appointmentText").val(num); 
			alert("超过字数限制，多出的字将被截断！" ); 
		}
	} 
	function nameLimit() 
	{ 
		var curLength=$("#stuName").val().length; 
		if(curLength>5) 
		{ 
			var num=$("#stuName").val().substr(0,5); 
			$("#stuName").val(num); 
			alert("超过字数限制，多出的字将被截断！" ); 
		}
	}
	function telLimit() 
	{ 
		var curLength=$("#telephone").val().length; 
		if(curLength>20) 
		{ 
			var num=$("#telephone").val().substr(0,20); 
			$("#telephone").val(num); 
			alert("超过字数限制，多出的字将被截断！" ); 
		}
	}
	function stuRoomLimit() 
	{ 
		var curLength=$("#stuRoom").val().length; 
		if(curLength>5) 
		{ 
			var num=$("#stuRoom").val().substr(0,5); 
			$("#stuRoom").val(num); 
			alert("超过字数限制，多出的字将被截断！" ); 
		}
	}  
	function descriptionLimit() 
	{ 
		var curLength=$("#description").val().length; 
		if(curLength>200) 
		{ 
			var num=$("#description").val().substr(0,200); 
			$("#description").val(num); 
			alert("超过字数限制，多出的字将被截断！" ); 
		}
	}
	
</script>
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
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="jsp/webjsp/index.jsp">首页</a>&rsaquo;&rsaquo;</li>
		<li class="display_i"><a class="none_text_decoration f12 display_i_b" href="jsp/webjsp/onlineRepair2.jsp">网上报修</a></li>
		<form class="subnav_form float_r" action="" method="post">
			<a href="onlineRepairSystem/OnlineRepairServlet?action=exit" class="f12">退出登录</a>
			<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>
	<!--子导航结束-->
	
	<!-- 中上部内容begin -->
	<div class="checkRepair">
		<!-- 登录者begin -->
		<div class="loginPerson">
			<img src="images/webimg/repair/person.jpg" title="loginPerson" alt="loginPerson" />
			<p><c:out value="${sessionScope.student.name}" /></p>
			<p><c:out value="${sessionScope.student.sno}" /></p>
		</div>
		<!-- 登录者end -->
		
		<!-- 三个报修项目图片begin -->
		<div class="repairColumn">
			<a href="onlineRepairSystem/OnlineRepairServlet?action=repairListPaperShow&option=showFirstPage"><img src="images/webimg/repair/view.png" title="Check Repair" alt="Check Repair" /></a>
			<a href="javascript:;"><img src="images/webimg/repair/repair02.png" title="Want To Repair" alt="Want To Repair" /></a>
			<a href="jsp/webjsp/onlineRepair3.jsp"><img src="images/webimg/repair/change.png" title="Change Password" alt="Change Password" /></a>
		</div>
		<!-- 三个报修项目图片end -->
	</div>
	<!-- 中上部内容end -->


	<!--报修表格begin-->
	<form id="repairMessage" method="post" action="">
	<!-- 隐藏域获取客户端时间 -->
	<input id="time" type="hidden" name="client-time" value="2015-01-01"/>
	<div class="message">
	<table class="w980 margin0_auto f14">
		<tr><td colspan="4" class="repairMessage">报修信息</td></tr>
		<tr><td class="leftTd"><span class="mandatory">*</span>学号：</td><td><input id="sno" name="stuSno" type="text" value="${sessionScope.student.sno}" disabled="true" class="leftTdText" style="ime-mode:disabled" onkeyup="return validateNumber(this,value)" /></td><td colspan="2" class="rightTd"><span class="mandatory">*</span>姓名：<input id="stuName" name="name" type="text" class="rightTdText nameText" onblur="nameLimit()"/></td></tr>
		<tr><td class="leftTd"><span class="mandatory">*</span>联系电话：</td><td><input id="telephone" type="text" class="leftTdText" style="ime-mode:disabled" onkeyup="return validateNumber(this,value)" onblur="telLimit()"/></td><td colspan="2"class="rightTd"><span class="mandatory">*</span>预约时间：<input id="appointmentTime" placeholder="请输入日期" class="laydate-icon" onclick="laydate()"><span class="remarks">备注：<input type="text" id="appointmentText" onblur="appointTextLimit()" /></span></td></tr>
		<tr>
		<td class="leftTd"><span class="mandatory">*</span>故障类型：</td>
		<td>
			<select name="faultType" id="faultType" class="faultType">
				<option value="choose">请选择</option>
				<option value="rj">锐捷认证失败</option>
				<option value="kuandai">宽带连接错误</option>
			</select>
		</td>
		<td class="address"><span class="mandatory">*</span>住址：
			<select name="address" id="stuArea" class="faultType">
				<option value="choose">请选择</option>
				<option value="1">1栋</option>
				<option value="2">2栋</option>
				<option value="3">3栋</option>
				<option value="4">4栋</option>
				<option value="5">5栋</option>
				<option value="6">6栋</option>
				<option value="7">7栋</option>
				<option value="8">8栋</option>
				<option value="9">9栋</option>
				<option value="10">10栋</option>
				<option value="11">11栋</option>
				<option value="12">12栋</option>
				<option value="13">13栋</option>
				<option value="14">14栋</option>
				<option value="15">15栋</option>
				<option value="16A">16栋</option>
				<option value="16B">16栋</option>
				<option value="17A">17栋A</option>
				<option value="17B">17栋B</option>
				<option value="18A">18栋A</option>
				<option value="18B">18栋B</option>
				<option value="19A">19栋A</option>
				<option value="19B">19栋B</option>
				<option value="20A">20栋A</option>
				<option value="20B">20栋B</option>
				<option value="21A">21栋A</option>
				<option value="21B">21栋B</option>
				<option value="22A">22栋A</option>
				<option value="22B">22栋B</option>
				<option value="23A">23栋A</option>
				<option value="23B">23栋B</option>
				<option value="24A">24栋A</option>
				<option value="24B">24栋B</option>
				<option value="25A">25栋A</option>
				<option value="25B">25栋B</option>
				<option value="zhuanjia">专家楼</option>
				<option value="jinhai">金海楼</option>
			</select>
			
		</td>
		<td class="address">
			<span class="mandatory">*</span>房间号：
			<input type="text" id="stuRoom" class="roomaddress" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;" onblur="stuRoomLimit()"/></td>
		</tr>
		
		<tr>
		<td rowspan="2" class="leftTd">锐捷客户端提示:</td>
		
		<td><input class="checkboxMessage" type="checkbox" name="clientCode" value="server">无法连接认证服务器</td>
		<td><input class="checkboxMessage" type="checkbox" name="clientCode" value="ip">静态IP地址绑定错误</td>
		<td><input class="checkboxMessage" type="checkbox" name="clientCode" value="nouserORpasswordmistake">用户不存在或密码错误</td>
		
		</tr>
		<tr>
		<td><input class="checkboxMessage" type="checkbox" name="clientCode" value="timeout">不在认证时间段内</td>
		<td><input class="checkboxMessage" type="checkbox" name="clientCode" value="overuser">已达到同时在线用户数量上限</td>
		<td><input class="checkboxMessage" type="checkbox" name="clientCode" value="withoutNetworkCard">网卡未连接</td>	
		</tr>
				
		<tr>
		<td rowspan="2" class="leftTd">宽带错误代码:</td>
		
		<td><input class="checkboxMessage" type="checkbox" name="errorCode" value="629/691">629/691</td>	
		<td><input class="checkboxMessage" type="checkbox" name="errorCode" value="651">651</td>	
		<td><input class="checkboxMessage" type="checkbox" name="errorCode" value="734">734</td>	
		</tr>
		<tr>
		<td><input class="checkboxMessage" type="checkbox" name="errorCode" value="720">720</td>	
		<td><input class="checkboxMessage" type="checkbox" name="errorCode" value="711">711</td>	
		<td><input class="checkboxMessage" type="checkbox" name="errorCode" value="619">619</td>	
		</tr>
		
		<tr>
		<td class="leftTd"><span class="mandatory">*</span>问题描述：</td>
		<td colspan="3"><textarea id="description" class="text_indent_2em" cols="134" rows="15" name="problemDescribe" onblur="descriptionLimit()"></textarea></td>
		</tr>
	</table>
	</div>
	<!--报修表格end-->
	
	<!--"报修""重置"按钮-->
	<div class="button f14">
	<a href="javaScript:recommendSolution();"><span class="display_i_b repairReset" id="recommendedPlan-Button">推荐方案</span></a>
	<a href="javascript:judgeNull();"><span class="display_i_b repairReset">报修</span></a>
	<a href="jsp/webjsp/onlineRepair2.jsp"><span class="display_i_b repairReset">重置</span></a>
	</div>
	<!--"报修""重置"按钮结束-->
	<!-- 推荐方案弹框begin -->
	<div id="recommendedPlan">
		<div class="recommendedPlan-title f18">推荐方案<img src="images/webimg/repair/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
		<div class="f14 recommendedPlan">
			<form name="recommendedPlan" method="post" action="">
				<table id="solutionTable">
					<tr><td width="150">错误信息</td><td width="200">解决方法</td></tr>
						<tr id="content">
						<td id="codeDescript">模板列</td>
						<td id="solution">模板列</td>
						</tr>
				</table>
				<input type="button" value="是" id="submitButton" style="display:none;"/>
				<input type="button" value="否" id="cancelClose-button" />
			</form>
		</div>
	</div>
	<!-- 推荐方案弹框end -->

	<!-- 弹框时出现的遮罩锁屏画布begin -->
	<div class="modal-canvas" id="modal-canvas"></div>
	<!-- 弹框时出现的遮罩锁屏画布end -->
	</form>
	<!-- 中间表格结束 -->
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->
	
</div>
<!--中部包围结束-->

</body>
</html>