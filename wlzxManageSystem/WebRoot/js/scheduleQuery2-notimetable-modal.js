/**
 * 弹出模态框+遮罩+拖拽
 * @authors tmn
 * @date    2015-02-06 16:29:26
 */
 $(document).ready(function(){
 	//锁屏效果
	//使锁屏画布布满整个浏览器窗口
	var modalCanvas=document.getElementById('modal-canvas');
 	modalCanvas.style.width=document.body.scrollWidth+'px';
 	modalCanvas.style.height=window.screen.height+'px';
 	
 	var modalButton=document.getElementById('recommendedPlan-Button');	//触发显示、隐藏模态框的按钮
 	var modal=document.getElementById('recommendedPlan');	//模态框实体
 	var close=document.getElementById('close-button');	//模态框右上角的关闭按钮

 	//显示模态框，遮罩生效
 	modalButton.onclick=function(){
 		modal.style.display='block';
 		modalCanvas.style.display='block';
 	};
 	//点击模态框的右上角关闭弹框,遮罩失效
 	close.onclick=function(){
 		modal.style.display='none';
 		modalCanvas.style.display='none';
 	};

 	// 使模态框居中
 	var top=(document.body.scrollHeight-443)/2;
	var left=(document.body.scrollWidth-962)/2;
	document.getElementById('recommendedPlan').style.top=top+'px';
	document.getElementById('recommendedPlan').style.left=left+'px';
 	
 	// 当浏览器窗口大小改变时仍然居中显示
 	window.onresize=function(){
	 	var top=(document.body.scrollHeight-443)/2;
	 	var left=(document.documentElement.clientWidth-962)/2;
	 	document.getElementById('recommendedPlan').style.top=top+'px';
	 	document.getElementById('recommendedPlan').style.left=left+'px';

	 	//修复Firefox当浏览器分辨率变大时遮罩画布右边出现白边
	 	modalCanvas.style.width=document.body.scrollWidth+'px';
 		modalCanvas.style.height=window.screen.height+'px';
 	};



 	//拖拽功能(主要是触发三个事件：onmousedown\onmousemove\onmouseup)
	var drag = document.getElementById('recommendedPlan');

	//点击某物体时，用drag对象即可，move和up是全局区域，也就是整个文档通用，应该使用document对象而不是drag对象(否则，采用drag对象时物体只能往右方或下方移动)
	drag.onmousedown = function(e) {
		var e = e || window.event; //兼容ie浏览器
		var diffX = e.clientX - drag.offsetLeft; //鼠标点击物体那一刻相对于物体左侧边框的距离=点击时的位置相对于浏览器最左边的距离-物体左边框相对于浏览器最左边的距离
		var diffY = e.clientY - drag.offsetTop;

			/*低版本ie bug:物体被拖出浏览器可是窗口外部时，还会出现滚动条，
			解决方法是采用ie浏览器独有的2个方法setCapture()\releaseCapture(),这两个方法，
			可以让鼠标滑动到浏览器外部也可以捕获到事件，而我们的bug就是当鼠标移出浏览器的时候，
			限制超过的功能就失效了。用这个方法，即可解决这个问题。注：这两个方法用于onmousedown和onmouseup中*/
			if(typeof drag.setCapture!='undefined'){
				drag.setCapture();
			}

		document.onmousemove = function(e) {
			var e = e || window.event; //兼容ie浏览器
			var left=e.clientX-diffX;
			var top=e.clientY-diffY;

			//控制拖拽物体的范围只能在浏览器视窗内，不允许出现滚动条
			if(left<0){
				left=0;
			}else if(left >window.innerWidth-drag.offsetWidth){
				left = window.innerWidth-drag.offsetWidth;
			}
			if(top<0){
				top=0;
			}else if(top >window.innerHeight-drag.offsetHeight){
				top = window.innerHeight-drag.offsetHeight;
			}

			//移动时重新得到物体的距离，解决拖动时出现晃动的现象
			drag.style.left = left+ 'px';
			drag.style.top = top + 'px';
		};
		document.onmouseup = function(e) { //当鼠标弹起来的时候不再移动
			this.onmousemove = null;
			this.onmouseup = null; //预防鼠标弹起来后还会循环（即预防鼠标放上去的时候还会移动）

			//修复低版本ie bug
			if(typeof drag.releaseCapture!='undefined'){
				drag.releaseCapture();
			}
		};
	};
 });
 
 /**
  * 查看个人无课表
  */
 var scheduleShow = function(userID, freeTableID){
	 if ($("#free12").children().length > 1) {
		 $("#free12 td").remove();
		 $("<td>1&2</td>").appendTo($("#free12"));
		 $("#free34 td").remove();
		 $("<td>3&4</td>").appendTo($("#free34"));
		 $("#free5 td").remove();
		 $("<td>5</td>").appendTo($("#free5"));
		 $("#free67 td").remove();
		 $("<td>6&7</td>").appendTo($("#free67"));
		 $("#free8 td").remove();
		 $("<td>8</td>").appendTo($("#free8"));
		 $("#free910 td").remove();
		 $("<td>9&10</td>").appendTo($("#free910"));
	 }

	 $.post("ScheduleServlet?action=scheduleShow",{userID:userID, freeTableID:freeTableID},
		 function(result){
			 var result = eval("("+result+")");
			 $.each(result, function(i, item){
				 // 第一二节
				 if(item.onetwo == "1"){
					 $("<td>单周无课</td>").appendTo($("#free12"));
				 }else if(item.onetwo == "2"){
					 $("<td>双周无课</td>").appendTo($("#free12"));
				 }else if(item.onetwo == "3"){
					 $("<td>无课</td>").appendTo($("#free12"));
				 }else {
					 $("<td></td>").appendTo($("#free12"));
				 }
				 // 第三四节
				 if(item.threefour == "1"){
					 $("<td>单周无课</td>").appendTo($("#free34"));
				 }else if(item.threefour == "2"){
					 $("<td>双周无课</td>").appendTo($("#free34"));
				 }else if(item.threefour == "3"){
					 $("<td>无课</td>").appendTo($("#free34"));
				 }else {
					 $("<td></td>").appendTo($("#free34"));
				 }
				 // 第五节
				 if(item.five == "1"){
					 $("<td>单周无课</td>").appendTo($("#free5"));
				 }else if(item.five == "2"){
					 $("<td>双周无课</td>").appendTo($("#free5"));
				 }else if(item.five == "3"){
					 $("<td>无课</td>").appendTo($("#free5"));
				 }else {
					 $("<td></td>").appendTo($("#free5"));
				 }
				 // 第六七节
				 if(item.sixseven == "1"){
					 $("<td>单周无课</td>").appendTo($("#free67"));
				 }else if(item.sixseven == "2"){
					 $("<td>双周无课</td>").appendTo($("#free67"));
				 }else if(item.sixseven == "3"){
					 $("<td>无课</td>").appendTo($("#free67"));
				 }else {
					 $("<td></td>").appendTo($("#free67"));
				 }
				 // 第八节
				 if(item.eight == "1"){
					 $("<td>单周无课</td>").appendTo($("#free8"));
				 }else if(item.eight == "2"){
					 $("<td>双周无课</td>").appendTo($("#free8"));
				 }else if(item.eight == "3"){
					 $("<td>无课</td>").appendTo($("#free8"));
				 }else {
					 $("<td></td>").appendTo($("#free8"));
				 }
				 // 第九十节
				 if(item.nineten == "1"){
					 $("<td>单周无课</td>").appendTo($("#free910"));
				 }else if(item.nineten == "2"){
					 $("<td>双周无课</td>").appendTo($("#free910"));
				 }else if(item.nineten == "3"){
					 $("<td>无课</td>").appendTo($("#free910"));
				 }else {
					 $("<td></td>").appendTo($("#free910"));
				 }
			 });
		 }		
	 );
	 setTimeout(function(){
		 $("#recommendedPlan").css("display","block");
		 $("#close-button").css("display","block");
	 }, 200);
 };
 
 /**
  * 显示总无课表
  */
 var scheduleSum = function(freeTableID){
	 if ($("#free12").children().length > 1) {
		 $("#free12 td").remove();
		 $("<td>1&nbsp;&nbsp;2</td>").appendTo($("#free12"));
		 $("#free345 td").remove();
		 $("<td>3&nbsp;&nbsp;4&nbsp;&nbsp;5</td>").appendTo($("#free345"));
		 $("#free6789 td").remove();
		 $("<td>6&nbsp;&nbsp;7&nbsp;&nbsp;8&nbsp;&nbsp;9</td>").appendTo($("#free6789"));
	 }
	 
	 $.post("ScheduleServlet?action=scheduleSum",{freeTableID:freeTableID},
		 function(result){
			 var result = eval("("+result+")");
			 $.each(result, function(i, item){
				 addFree(item, "mon12", "mon345", "mon6789");  // 星期一
				 addFree(item, "tues12", "tues345", "tues6789");  // 星期二 
				 addFree(item, "wed12", "wed345", "wed6789");  // 星期三
				 addFree(item, "thurs12", "thurs345", "thurs6789");  // 星期四
				 addFree(item, "fri12", "fri345", "fri6789");  // 星期五
			 });
		 }		
	 );
	 
	 setTimeout(function(){
		 $("#recommendedPlan").css("display","block");
		 $("#close-button").css("display","block");
	 }, 1500);  // TODO 待完善:后台循环判断次数多，速度慢
 };
 
 var addFree = function(item, free12, free345, free6789){
	 if (item.name == free12) {
		 $("<td>"+item.value+"<input type='hidden' name="+item.name+" value="+item.value+"></td>").appendTo($("#free12"));
	 }else if (item.name == free345) {
		 $("<td>"+item.value+"<input type='hidden' name="+item.name+" value="+item.value+"></td>").appendTo($("#free345"));
	 }else if (item.name == free6789) {
		 $("<td>"+item.value+"<input type='hidden' name="+item.name+" value="+item.value+"></td>").appendTo($("#free6789"));
	 }
 };