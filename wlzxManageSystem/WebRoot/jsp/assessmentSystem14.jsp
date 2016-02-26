<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <title>a14-设计试卷</title>

	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/paper.css" />
	<link rel="stylesheet" type="text/css" href="css/modal.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/modal.js"></script>
	<script type="text/javascript" src="js/question.js"></script>
</head>

<body>
<!--整体包围-->
<div class="wrapper">
	<div class="leftSide">
		<p>常用题型</p>
		<ul>
			<li id="blank"><a href="javascript:;">填空题</a></li>
			<li id="single"><a href="javascript:;">单选题</a></li>
			<li id="multiple"><a href="javascript:;">多选题</a></li>
			<li id="judge"><a href="javascript:;">判断题</a></li>
			<li id="shortAnswer"><a href="javascript:;">简答题</a></li>
		</ul>
	</div>
	<div class="createPaperContent">
		<form id="paperForm" name="createPaperContent" method="post" target="nofresh">
			<!-- 右上角2个按钮 -->
			<div class="choose-button">
				<input id="preview" type="button" name="preview" value="预览试卷"/>
				<input id="create" type="button" name="create" value="创建"/>
			</div>
			<!-- 试卷名 -->
			<p class="paperName">试卷标题</p>
			<input type="text" name="paperTitle" class="paperName-text"/>
			<!-- 填空题 -->
			<div class="blank-filling" id="blank-filling-answer">
				<a href="javascript:;" id="blank-filling-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" name="blank-filling-title" class="question-title" placeholder="填空题（2分）"/><br/>
				<div class="answer">
					<input type="text" name="blank-filling-answer" class="question-title" placeholder="答案" class="display_i_b"/>
					<input type="button" name="choose-button" value="从题库选题" class="choose-question" id="recommendedPlan-Button-2"/>
					<input type="hidden" name="isExist" value="0"> 
				</div>
			</div>
			<div id="blank-filling-answer-null"></div>

			<!-- 单选题 -->
			<div class="single-option" id="single-answer">
				<a href="javascript:;" id="single-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" name="single-title" class="question-title" placeholder="单选题（2分）"/><br/>
				<div class="answer">
					<input type="radio" value="A"/>
					<input type="text" name="single-sectionA" placeholder="选项（选中即是答案）"/><br/>
					<input type="radio" value="B"/>
					<input type="text" name="single-sectionB" placeholder="选项（选中即是答案）"/><br/>
					<input type="radio" value="C"/>
					<input type="text" name="single-sectionC" placeholder="选项（选中即是答案）"/><br/>
					<input type="radio" value="D"/>
					<input type="text" name="single-sectionD" placeholder="选项（选中即是答案）"/><br/>
					<input type="button" name="choose-button" value="从题库选题" class="choose-question" id="recommendedPlan-Button-0"/>
					<input type="hidden" name="isExist" value="0"> 
				</div>
			</div>
			<div id="single-answer-null"></div>

			<!-- 多选题 -->
			<div class="multiple-option" id="multiple-answer">
				<a href="javascript:;" id="multiple-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" name="multiple-title" class="question-title" placeholder="多选题（3分）"/><br/>
				<div class="answer">
					<input type="checkbox" value="A"/>
					<input type="text" name="multiple-sectionA" placeholder="选项（选中即是答案）"/><br/>
					<input type="checkbox" value="B"/>
					<input type="text" name="multiple-sectionB" placeholder="选项（选中即是答案）"/><br/>
					<input type="checkbox" value="C"/>
					<input type="text" name="multiple-sectionC" placeholder="选项（选中即是答案）"/><br/>
					<input type="checkbox" value="D"/>
					<input type="text" name="multiple-sectionD" placeholder="选项（选中即是答案）"/><br/>
					<input type="checkbox" value="E"/>
					<input type="text" name="multiple-sectionE" placeholder="选项（可选，选中即是答案）"/><br/>
					<input type="button" name="choose-button" value="从题库选题"  class="choose-question" id="recommendedPlan-Button-1"/>
					<input type="hidden" name="isExist" value="0"> 
				</div>
			</div>
			<div id="multiple-answer-null"></div>

			<!-- 判断题 -->
			<div class="judge-option" id="judge-answer">
				<a href="javascript:;" id="judge-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" name="judge-title" class="question-title" placeholder="判断题（2分）"/><br/>
				<div class="answer">
					<input type="radio" value="T"/>T&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="F"/>F<br/>
					<input type="button" name="choose-button" value="从题库选题"  class="choose-question" id="recommendedPlan-Button-3"/>
					<input type="hidden" name="isExist" value="0"> 
				</div>
			</div>
			<div id="judge-answer-null"></div>

			<!-- 简答题 -->
			<div class="short-answer" id="short-answer">
				<a href="javascript:;" id="short-delete-button"><img src="images/surveySystem/delete.png" alt="delete" title="delete" class="deleteAnswer"/></a>
				<span></span>
				<input type="text" style="width: 330px;" name="short-answer-title" class="question-title" placeholder="简答题（右侧选择分值）"/>
				<select name="short-answer-point" class="f_blue0066ff">
					<option value="5">5分</option>
					<option value="10">10分</option>
					<option value="15">15分</option>
				</select><br/>
				<div class="answer">
					<textarea name="short-answer-answer" placeholder="答案"></textarea>
					<input type="button" name="choose-button" value="从题库选题"  class="choose-question" id="recommendedPlan-Button-4"/>
					<input type="hidden" name="isExist" value="0"> 
				</div>
			</div>
			<div id="short-answer-null"></div>

			<!-- 推荐方案弹框begin -->
			<div id="recommendedPlan">
				<div class="recommendedPlan-title">题库<img src="images/surveySystem/delete.png" title="close" alt="close" class="close" id="close-button" /></div>
				<div class="f14 recommendedPlan" id="titleBank">
					<div class="button" id="submitButton"><input type="button" value="确定"/></div>
				</div>
			</div>
			<!-- 推荐方案弹框end -->

			<!-- 弹框时出现的遮罩锁屏画布begin -->
			<div class="modal-canvas" id="modal-canvas"></div>
			<!-- 弹框时出现的遮罩锁屏画布end -->

			<!-- 设置隐藏的iframe，提交表单不刷新页面begin -->
			<iframe name="nofresh"></iframe>
			<!-- 设置隐藏的iframe，提交表单不刷新页面end -->
		</form>

	</div>
</div>
<!--整体包围结束-->

</body>
</html>