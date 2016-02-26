<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
%>
<base href= "<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>报修统计</title>
    
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/repairsManagement.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	<script type="text/javascript" src="js/Chart.js"></script>
	<script type="text/javascript" src="js/chart_data.js"></script>
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
                <li><a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage"><img alt="" src="images/onlineRepair/repair_ico.png"/><p>网络报修</p></a></li>
                <li><a href="javascript:;" class="active"><img alt="" src="images/onlineRepair/anly_ico.png"/><p>报修统计</p></a></li>
            </ul>
        </div>	
    	<!--左部菜单end-->
    
    	<!--工资系统begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">报修系统&nbsp;&nbsp;>>&nbsp;&nbsp;报修统计</div>
            <hr/>
            <div class="dutyRegister repairs repairsManagement5">
                    <div class="search02">
                        年:
                        <select class="item" id="year">
                        <option value="default" selected="selected">请选择</option>
                        </select>
                        月:
                        <select class="item" id="month">                        
                            <option value="default" selected="selected">请选择</option>
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                        姓名:
                        <select class="item" id=name>
                        	<option value="default" selected="selected">请选择</option>
	                        <c:set var="nameList" value="${fn:split(sessionScope.alluserName, ',')}"></c:set>
	                        <c:forEach var="name" items="${nameList}">
	                        	<option value="${name}"><c:out value="${name}"></c:out></option>
	                        </c:forEach>
                        </select>
                        <div class="button" style="width:160px;"><input id="alyBtn" type="button" value="统计分析"></div>
                    </div>
                    <p class="aly_intro">1.选择“年+月+姓名”，查询指定网管某年月记录；<br/>2.选择“年+姓名”，查询指定网管一年的所有月份记录；<br/>
                        3.选择“年+月”，查询所有网管在该年该月记录；<br/>4.选择“年”，统计指定年报修情况。
                    </p>
            	<table> 
            		<tbody id="alyMessage">           		
                    <tr class="head"><td>时间</td><td>总报修单</td><td>本人处理</td><td>过期</td><td>未处理</td><td>评分统计</td><td>网管</td></tr>
                    <tr id="content">
                    <td id="time"></td>
                    <td id="allRepairListNum"></td>
                    <td id="dealByMyself"></td>
                    <td id="overDueNum"></td>
                    <td id="noDeal" style="color:#ff0000;"></td>
                    <td id="evaluAly"></td>
                    <td id="dutyPerson"></td>
                    </tr>
                    </tbody>
                </table>
                <dl class="chart_wrap">
                	<dd>
                		<p class="chart_title">报修单处理情况统计</p>
	                	<div id="canvas-holder" class="chart_area01">
							<canvas id="chart-area01" width="300" height="300"/>
						</div>
						<ul class="tag_ul">
							<li style="background-color:#f47f38;">已处理</li>
							<li style="background-color:#1bb9ef;">未处理</li>
						</ul>
						<div style="clear:both;"><br/></div>
					</dd>
					<dd>
                		<p class="chart_title">评分统计</p>
	                	<div id="canvas-holder" class="chart_area01">
							<canvas id="chart-area02" width="300" height="300"/>
						</div>
						<ul class="tag_ul">
							<li style="background-color:#a8b3c5;">A</li>
							<li style="background-color:#fdb45c;">B</li>
							<li style="background-color:#46bfbd;">C</li>
							<li style="background-color:#f7464a;">D</li>
						</ul>
						<div style="clear:both;"><br/></div>
					</dd>
				</dl>
            </div>
        </div>	
    	<!--工资系统end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->

	<!-- 脚部 -->
    <foot:footer></foot:footer>
</div>
<!--中部包围结束-->

</body>
<script language="javascript" type="text/javascript"> 
		//设置年份的选择 
		var myDate= new Date(); 
		var startYear=myDate.getFullYear()-4;//起始年份 
		var endYear=myDate.getFullYear();//结束年份 
		var obj=document.getElementById('year'); 
		for (var i=startYear;i<=endYear;i++) 
		{ 
			obj.options.add(new Option(i,i)); 
		}
		var alyMessageObj=$("#alyMessage");
		var chartObj=$(".chart_wrap");
		chartObj.hide();
		alyMessageObj.hide();
		var alyBtn=$("#alyBtn");
		alyBtn.click(function(){
			var year=$("#year").find("option:selected").text();
			var month=$("#month").find("option:selected").text();
			var name=$("#name").find("option:selected").text();
			if(name=="请选择"){
				name="";
			}
			if(month=="请选择"){
				month="";
			}
			if(year=="请选择"){
				alert("年份不能为空！");
			}
			if(year!="请选择"&&month==""&&name==""){
				var url="onlineRepairSystem/OnlineRepairServlet?action=alyRepairList&year="+encodeURI(year+"&month="+month
				+"&name="+name);
				$.get(url,null,callback02);//注意两个ajax请求不能回调函数不能同名
				function callback02(data){
					var alydata=JSON.parse(data);
					dealData[0].value=alydata.done;
					dealData[1].value=alydata.noDone;
					evlaData[0].value=alydata.gotA;
					evlaData[1].value=alydata.gotB;
					evlaData[2].value=alydata.gotC;
					evlaData[3].value=alydata.gotD;
					//生成图表
					var dealChart = document.getElementById("chart-area01").getContext("2d");
					window.myPie = new Chart(dealChart).Pie(dealData);
					var dealChart = document.getElementById("chart-area02").getContext("2d");
					window.myPie = new Chart(dealChart).Pie(evlaData);
				}
				alyMessageObj.hide();
				chartObj.show();
			}
			if((year!="请选择"&&month!=""&&name=="")||(year!="请选择"&&month==""&&name!="")||(year!="请选择"&&month!=""&&name!="")){
				//1.清空表格除了首行、第二行以外的所有内容
				for(var i=2;i<$("#alyMessage").children("tr").length;){
					$("#alyMessage tr:eq("+i+")").remove(); 
				}
				var url="onlineRepairSystem/OnlineRepairServlet?action=alyRepairList&year="+encodeURI(year+"&month="+month
				+"&name="+name);
				$.get(url,null,callback);
				function callback(data){
					var alyobj=eval(data);
					for(var i=0;i<alyobj.length;i++){//遍历JSon数组输出到表格中
						//3.复制数据行，输入数据
						var row=$("#content").clone();
						row.find("#time").text(alyobj[i].time);
						row.find("#allRepairListNum").text(alyobj[i].allRepairListNum);
						row.find("#dealByMyself").text(alyobj[i].dealByMyself);
						row.find("#overDueNum").text(alyobj[i].overDueNum);
						row.find("#noDeal").text(alyobj[i].noDeal);
						row.find("#evaluAly").text(alyobj[i].evaluAly);
						row.find("#dutyPerson").text(alyobj[i].dutyPerson);						
						row.appendTo("#alyMessage");
								
					}
					$("#alyMessage tr:eq(1)").remove();//移除第一行模板列		
				}
				chartObj.hide();
				alyMessageObj.show();
			}
		});
</script> 
</html>