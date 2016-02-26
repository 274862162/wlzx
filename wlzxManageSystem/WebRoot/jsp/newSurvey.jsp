<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;
%>
<base href= "<%=basePath%>">
<html>
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>createPaper</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/paper.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		// 删除按钮
		$('#single-delete-button').click(function(){
			$(this).parent().remove();
			var singles = $('#single-answer-null > div').length;  // 获得剩余题型数量
			for(var i = 0; i < singles; i++){
				$('#single-answer-null > div').eq(i).find('span').html(i+1+'.');  // 设置编号
			}
		});

		$('#multiple-delete-button').click(function(){
			$(this).parent().remove();
			var multiples = $('#multiple-answer-null > div').length;
			for(var i = 0; i < multiples; i++){
				$('#multiple-answer-null > div').eq(i).find('span').html(i+1+'.');
			}
		});


		// 按题型增加题目
		$('#single').click(function(){
			var oId = $('#single-answer-null > div').length + 1;
			$('#single-answer').clone(true).attr('id','single-answer'+oId).appendTo('#single-answer-null').show().find('span').html(oId+'.');
		});
		$('#multiple').click(function(){
			var oId = $('#multiple-answer-null > div').length + 1;
			$('#multiple-answer').clone(true).attr('id','multiple-answer'+oId).appendTo('#multiple-answer-null').show().find('span').html(oId+'.');
		});

	});	
	</script>
</head>

<body>
<!--整体包围-->
<div class="wrapper">
	<div class="leftSide">
		<p>常用题型</p>
		<ul>
			<li id="single"><a href="javascript:;">单选题</a></li>
			<li id="multiple"><a href="javascript:;">多选题</a></li>
		</ul>
	</div>
	<div class="createPaperContent">
		<form name="createPaperContent" action="SurveySystem/SurveySystemQusnServlet?action=addQuestionnaire" method="post">
			<!-- 右上角2个按钮 -->
			<div class="choose-button">
				<!-- <input type="button" id="preview" value="预览试卷" onclick='window.open(&apos;surveySystem4.jsp&apos;)'/>-->
				<input type="submit" name="create" value="预览试卷"/>				
				<input type="submit" name="create" value="创建"/>
				<input type="submit" name="create" value="取消"/>
			</div>
			<!-- 试卷名 -->
			<p class="paperName">试卷标题</p>
			<input type="text" name="paperTitle" class="paperName-text"/>
			<!-- 单选题 -->
			<div class="single-option" id="single-answer">
				<a href="javascript:;" id="single-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" name="single-text-title" class="question-title" placeholder="单选题"/><br/>
				<div class="answer">
					<input type="radio" name="first" value="first"/>
					<input type="text" name="single-first" placeholder="选项"/><br/>
					<input type="radio" name="first" value="second"/>
					<input type="text" name="single-second" placeholder="选项"/><br/>
					<input type="radio" name="first" value="third"/>
					<input type="text" name="single-third" placeholder="选项"/><br/>
					<input type="radio" name="first" value="forth"/>
					<input type="text" name="single-forth" placeholder="选项"/><br/>
					<input type="radio" name="first" value="fiveth"/>
					<input type="text" name="single-fiveth" placeholder="选项"/><br/>
				</div>
			</div>
			<div id="single-answer-null"></div>

			<!-- 多选题 -->
			<div class="multiple-option" id="multiple-answer">
				<a href="javascript:;" id="multiple-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" name="multiple-text-title" class="question-title" placeholder="多选题"/><br/>
				<div class="answer">
					<input type="checkbox" name="first" value="first"/>
					<input type="text" name="multiple-first" placeholder="选项"/><br/>
					<input type="checkbox" name="first" value="second"/>
					<input type="text" name="multiple-second" placeholder="选项"/><br/>
					<input type="checkbox" name="first" value="third"/>
					<input type="text" name="multiple-third" placeholder="选项"/><br/>
					<input type="checkbox" name="first" value="forth"/>
					<input type="text" name="multiple-forth" placeholder="选项"/><br/>
					<input type="checkbox" name="first" value="fiveth"/>
					<input type="text" name="multiple-fiveth" placeholder="选项"/><br/>
				</div>
			</div>
			<div id="multiple-answer-null"></div>
			<!-- 隐藏域获取客户端时间 -->
			<input id="time" type="hidden" name="client-time" value="2015-01-01"/>
		</form>
	</div>
</div>
<!--整体包围结束-->

</body>
<!-- 获取客户端时间 -->
<script type="text/javascript">	
   		var date = new Date();
   		var year = date.getFullYear();
   		var month = date.getMonth()+1;
   		var day = date.getDate();
   		var h=date.getHours();
   		var m=date.getMinutes();
		var s=date.getSeconds();
		var time=year+"-"+month+"-"+day+"-"+h+":"+m+":"+s;    	
    	var timeElement=document.getElementById("time");	
		timeElement.setAttribute("value",time);	
</script>
</html>