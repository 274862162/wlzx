/**
 * 设计问卷和调查问卷增加题目
 * @authors hsg&tmn
 * @date    2015-02-07 08:26:28
 */

$(document).ready(function() {
	// 删除按钮
	$('#blank-filling-delete-button').click(function(){
		$(this).parent().remove();
		var singles = $('#blank-filling-answer-null > div').length;  // 获得剩余单选题数量
		for(var i = 0; i < singles; i++){
			$('#blank-filling-answer-null > div').eq(i).find('span').html(i+1+'.');  // 设置编号
		}
	});
	$('#single-delete-button').click(function(){
		$(this).parent().remove();
		var singles = $('#single-answer-null > div').length;
		for(var i = 0; i < singles; i++){
			$('#single-answer-null > div').eq(i).find('span').html(i+1+'.');
		}
	});
	$('#multiple-delete-button').click(function(){
		$(this).parent().remove();
		var multiples = $('#multiple-answer-null > div').length;
		for(var i = 0; i < multiples; i++){
			$('#multiple-answer-null > div').eq(i).find('span').html(i+1+'.');
		}
	});
	$('#judge-delete-button').click(function(){
		$(this).parent().remove();
		var judges = $('#judge-answer-null > div').length;
		for(var i = 0; i < judges; i++){
			$('#judge-answer-null > div').eq(i).find('span').html(i+1+'.');
		}
	});
	$('#short-delete-button').click(function(){
		$(this).parent().remove();
		var shorts = $('#short-answer-null > div').length;
		for(var i = 0; i < shorts; i++){
			$('#short-answer-null > div').eq(i).find('span').html(i+1+'.');
		}
	});

	// 按题型增加题目
	$('#blank').click(function(){
		var oId = $('#blank-filling-answer-null > div').length + 1;
		$('#blank-filling-answer').clone(true).attr('id','blank-filling-answer'+oId).appendTo('#blank-filling-answer-null').show().find('span').html(oId+'.');
	});
	$('#single').click(function(){
		var oId = $('#single-answer-null > div').length + 1;
		$('#single-answer').clone(true).attr('id','single-answer'+oId).appendTo('#single-answer-null').show().find('span').html(oId+'.');
		// 给每道单选题的选项添加name值
		$('#single-answer'+oId).find('input[type="radio"]').each(function(){
			$(this).attr('name','single-answer'+oId);
		});
	});
	$('#multiple').click(function(){
		var oId = $('#multiple-answer-null > div').length + 1;
		$('#multiple-answer').clone(true).attr('id','multiple-answer'+oId).appendTo('#multiple-answer-null').show().find('span').html(oId+'.');
		// 给每道多选题的选项添加name值
		$('#multiple-answer'+oId).find('input[type="checkbox"]').each(function(){
			$(this).attr('name','multiple-answer'+oId);
		});	
	});
	$('#judge').click(function(){
		var oId = $('#judge-answer-null > div').length + 1;
		$('#judge-answer').clone(true).attr('id','judge-answer'+oId).appendTo('#judge-answer-null').show().find('span').html(oId+'.');
		// 给每道多选题的选项添加name值
		$('#judge-answer'+oId).find('input[type="radio"]').each(function(){
			$(this).attr('name','judge-answer'+oId);
		});
	});
	$('#shortAnswer').click(function(){
		var oId = $('#short-answer-null > div').length + 1;
		$('#short-answer').clone(true).attr('id','short-answer'+oId).appendTo('#short-answer-null').show().find('span').html(oId+'.');
	});
	
	$('#preview').click(function(){
		$('#paperForm').attr('action', 'TestPaperServlet?action=testPaperPreview').attr('target','_blank').submit();
	});
	
	$('#create').click(function(){
		/*
			// 检查题目答案是否填写好
			if (!checkTitle()) {
				return;
			}
		*/
		$('select[name="short-answer-point"]').removeAttr("disabled");  // 将不能编辑的分值下拉框设置为可编辑，否则后台接收不到数据
		$('#paperForm').attr('action', 'TestPaperServlet?action=testPaperCreate').attr('target','_self').submit();
	});
	
	// 单选题从题库选题
	$('#recommendedPlan-Button-0').click(function(e){
		choiceTitle(e, 0);
	});
	// 多选题从题库选题
	$('#recommendedPlan-Button-1').click(function(e){
		choiceTitle(e, 1);
	});
	// 填空题从题库选题
	$('#recommendedPlan-Button-2').click(function(e){
		choiceTitle(e, 2);
	});
	// 判断题从题库选题
	$('#recommendedPlan-Button-3').click(function(e){
		choiceTitle(e, 3);
	});
	// 简答题从题库选题
	$('#recommendedPlan-Button-4').click(function(e){
		choiceTitle(e, 4);
	});
	// 提交选题
	$('#submitButton').click(function(){
		submitChoice();
	});
});

/**
 * 验证创建试卷时各题是否填写
 * TODO
 */
var checkTitle = function(){
	var text = $(':text');
	alert(text.length);
	for(var i = 0; i < text.length; i++){
		if (text[i].val().trim().length == 0) {
			alert("请将问题与答案填写完整再创建！");
			return false;
		}
	}
	return true;
};

/**
 * 从题库选题，根据问题类型从题库选出同类型的题
 * e:事件源
 * qType:题目类型
 */
var choiceTitle = function(e, qType){
	$('#titleBank span').remove();  // 消除模态框中的题
	questionType = qType;
	oTitle = $(e.target).parent().parent().children('input');  // 题目标题  TODO 全局变量，待完善
	isExist = $(e.target).next();  // 是否是新添加题标志，0表示新加的，1表示题库已有的
	//oAnswer = $(e.target).prev().val();
	if (questionType == 0) {
		singleAnswerA = $(e.target).parent().children('input').eq(1);
		singleAnswerB = $(e.target).parent().children('input').eq(3);
		singleAnswerC = $(e.target).parent().children('input').eq(5);
		singleAnswerD = $(e.target).parent().children('input').eq(7);
	}else if (questionType == 1) {
		moreAnswerA = $(e.target).parent().children('input').eq(1);
		moreAnswerB = $(e.target).parent().children('input').eq(3);
		moreAnswerC = $(e.target).parent().children('input').eq(5);
		moreAnswerD = $(e.target).parent().children('input').eq(7);
		moreAnswerE = $(e.target).parent().children('input').eq(9);
	}else if (questionType == 2) {
		blankFillAnswer = $(e.target).prev();
	}else if (questionType == 3) {
		judgeAnswer = $(e.target).parent();
	}else if (questionType == 4) {
		shortAnswer = $(e.target).parent().children('textarea');
	}
	
	$.post("TestPaperServlet?action=testPaperChoiceTitle&choice=1",{questionType:questionType},
		 function(result){
			 var result = eval("("+result+")");
			 $.each(result, function(i, item){
				 // 点击“从题库选题”时，将题目加到模态框中
				 $('#submitButton').before($('<span><input type="radio" name="title" value='+item.questionID+'></input>'+item.questionTitle+'</span>'));
			 });
		 }		
	 );
	
	// 显示模态框
	setTimeout(function(){
		$('#recommendedPlan').css('display', 'block');
		$('#modal-canvas').css('display', 'block');
	}, 100);
};

/**
 * 确定从题库选的题
 */
var submitChoice = function(){
	var questionId = $('input[name="title"]:checked').val();
	if (questionId != null) {
		$.post("TestPaperServlet?action=testPaperChoiceTitle&choice=2",{questionId:questionId},
			 function(result){
				 var result = eval("("+result+")");
				 $.each(result, function(i, item){
					 oTitle.val(item.questionTitle);  // 显示选中的题目标题
					 oTitle.attr('readonly', 'readonly');  // 题目设置为不可编辑
					 // 选中单选题
					 if (questionType == 0) {
						singleAnswerA.val(item.sectionA.substring(2));
						singleAnswerB.val(item.sectionB.substring(2));
						singleAnswerC.val(item.sectionC.substring(2));
						singleAnswerD.val(item.sectionD.substring(2));
						singleAnswerA.attr('readonly', 'readonly');  // 答案设置为不可编辑，下同
						singleAnswerB.attr('readonly', 'readonly');
						singleAnswerC.attr('readonly', 'readonly');
						singleAnswerD.attr('readonly', 'readonly');
						isExist.val(1);
						// 选中答案
						for(var i = 0; i < 4; i++){
							singleAnswerA.parent().children('input[type=radio]:eq('+i+')').attr('disabled', 'disabled');  // 选项设置为不可编辑
							if (singleAnswerA.parent().children('input[type=radio]:eq('+i+')').val() == item.answer) {
								singleAnswerA.parent().children('input[type=radio]:eq('+i+')').prop('checked','checked');
							}
						}
						// TODO 解除引用
						moreAnswerA = null;
						moreAnswerB = null;
						moreAnswerC = null;
						moreAnswerD = null;
						moreAnswerE = null;
						blankFillAnswer = null;
						judgeAnswer = null;
						shortAnswer = null;
					 }
					 // 选中多选题
					 else if (questionType == 1) {
						 moreAnswerA.val(item.sectionA.substring(2));
						 moreAnswerB.val(item.sectionB.substring(2));
						 moreAnswerC.val(item.sectionC.substring(2));
						 moreAnswerD.val(item.sectionD.substring(2));
						 moreAnswerE.val(item.sectionE.substring(2));
						 moreAnswerA.attr('readonly', 'readonly');  // 答案设置为不可编辑，下同
						 moreAnswerB.attr('readonly', 'readonly'); 
						 moreAnswerC.attr('readonly', 'readonly'); 
						 moreAnswerD.attr('readonly', 'readonly'); 
						 moreAnswerE.attr('readonly', 'readonly'); 
						 isExist.val(1);
						 // 消除之前选中的
						 moreAnswerA.parent().children('input[type=checkbox]').removeAttr("checked");  // 取消全选 
						 // 选中答案
						 var mAnswer = item.answer.split(',');
						 for(var i = 0; i < mAnswer.length; i++){
							 for(var j = 0; j < 5; j++){
								 moreAnswerA.parent().children('input[type=checkbox]:eq('+j+')').attr('disabled', 'disabled');  // 选项设置为不可编辑
								 if (moreAnswerA.parent().children('input[type=checkbox]:eq('+j+')').val() == mAnswer[i]) {
									 moreAnswerA.parent().children('input[type=checkbox]:eq('+j+')').prop("checked", true);
								 }
							 }
						 }
						 // TODO 解除引用
						 singleAnswerA = null;
						 singleAnswerB = null;
						 singleAnswerC = null;
						 singleAnswerD = null;
						 blankFillAnswer = null;
						 judgeAnswer = null;
						 shortAnswer = null;
					 }
					 // 选中填空题
					 else if (questionType == 2) {
						 blankFillAnswer.val(item.answer);
						 blankFillAnswer.attr('readonly', 'readonly');  // 答案设置为不可编辑
						 isExist.val(1);
						 // TODO 解除引用
						 singleAnswerA = null;
						 singleAnswerB = null;
						 singleAnswerC = null;
						 singleAnswerD = null;
						 moreAnswerA = null;
						 moreAnswerB = null;
						 moreAnswerC = null;
						 moreAnswerD = null;
						 moreAnswerE = null;
						 judgeAnswer = null;
						 shortAnswer = null;
					 }
					 // 判断题
					 else if (questionType == 3) {
						 // 选中答案
						 for(var i = 0; i < 2; i++){
							 judgeAnswer.children('input[type=radio]:eq('+i+')').attr('disabled', 'disabled');  // 答案设置为不可编辑
							 isExist.val(1);
							 if (judgeAnswer.children('input[type=radio]:eq('+i+')').val() == item.answer) {
								 judgeAnswer.children('input[type=radio]:eq('+i+')').prop('checked','checked');
							 }
						 }
						 // TODO 解除引用
						 singleAnswerA = null;
						 singleAnswerB = null;
						 singleAnswerC = null;
						 singleAnswerD = null;
						 moreAnswerA = null;
						 moreAnswerB = null;
						 moreAnswerC = null;
						 moreAnswerD = null;
						 moreAnswerE = null;
						 shortAnswer = null;
						 blankFillAnswer = null;
					 }
					 
					 // 选中简答题
					 else if (questionType == 4) {
						 shortAnswer.val(item.answer);
						 shortAnswer.attr('readonly', 'readonly');  // 答案设置为不可编辑
						 shortAnswer.parent().parent().children('select').attr('disabled', 'disabled');  // 答案分值为不可编辑
						 isExist.val(1);
						 // 选中分值
						 var point = shortAnswer.parent().parent().children('select').children();
						 for(var i = 0; i < point.length; i++){
							 //point.eq(i).attr('disabled', 'false');  // 答案分值为不可编辑
							 if (point.eq(i).val() == item.point) {
								 point.eq(i).prop('selected','selected');
							 }
						 }
						 
						 // TODO 解除引用
						 singleAnswerA = null;
						 singleAnswerB = null;
						 singleAnswerC = null;
						 singleAnswerD = null;
						 moreAnswerA = null;
						 moreAnswerB = null;
						 moreAnswerC = null;
						 moreAnswerD = null;
						 moreAnswerE = null;
						 blankFillAnswer = null;
						 judgeAnswer = null;
					 }
				 });
			 }	
		);
	}
	
	$('#recommendedPlan').css('display', 'none');
	$('#modal-canvas').css('display', 'none');
};
