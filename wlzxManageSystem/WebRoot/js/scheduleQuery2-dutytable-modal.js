/**
 * 弹出模态框+遮罩+拖拽
 * @authors tmn
 * @date    2015-02-06 16:29:26
 */
 $(document).ready(function(){
 	//锁屏效果
	//使锁屏画布布满整个浏览器窗口
	var modalCanvasDuty=document.getElementById('modal-canvas-duty');
 	modalCanvasDuty.style.width=document.body.scrollWidth+'px';
 	modalCanvasDuty.style.height=window.screen.height+'px';
 	
 	var modalButtonDuty=document.getElementById('recommendedPlan-Button-duty');	//触发显示、隐藏模态框的按钮
 	var modalDuty=document.getElementById('recommendedPlan-duty');	//模态框实体
 	var closeDuty=document.getElementById('close-button-duty');	//模态框右上角的关闭按钮

 	//显示模态框，遮罩生效
 	modalButtonDuty.onclick=function(){
 		modalDuty.style.display='block';
 		modalCanvasDuty.style.display='block';
 	};
 	//点击模态框的右上角关闭弹框,遮罩失效
 	closeDuty.onclick=function(){
 		modalDuty.style.display='none';
 		modalCanvasDuty.style.display='none';
 	};

 	// 使模态框居中
 	var top=(document.body.scrollHeight-443)/2;
	var left=(document.body.scrollWidth-962)/2;
	document.getElementById('recommendedPlan-duty').style.top=top+'px';
	document.getElementById('recommendedPlan-duty').style.left=left+'px';
 	
 	// 当浏览器窗口大小改变时仍然居中显示
 	window.onresize=function(){
	 	var top=(document.body.scrollHeight-443)/2;
	 	var left=(document.documentElement.clientWidth-962)/2;
	 	document.getElementById('recommendedPlan-duty').style.top=top+'px';
	 	document.getElementById('recommendedPlan-duty').style.left=left+'px';

	 	//修复Firefox当浏览器分辨率变大时遮罩画布右边出现白边
	 	modalCanvasDuty.style.width=document.body.scrollWidth+'px';
 		modalCanvasDuty.style.height=window.screen.height+'px';
 	};



 	//拖拽功能(主要是触发三个事件：onmousedown\onmousemove\onmouseup)
	var dragDuty = document.getElementById('recommendedPlan-duty');

	//点击某物体时，用drag对象即可，move和up是全局区域，也就是整个文档通用，应该使用document对象而不是drag对象(否则，采用drag对象时物体只能往右方或下方移动)
	dragDuty.onmousedown = function(e) {
		var e = e || window.event; //兼容ie浏览器
		var diffX = e.clientX - dragDuty.offsetLeft; //鼠标点击物体那一刻相对于物体左侧边框的距离=点击时的位置相对于浏览器最左边的距离-物体左边框相对于浏览器最左边的距离
		var diffY = e.clientY - dragDuty.offsetTop;

			/*低版本ie bug:物体被拖出浏览器可是窗口外部时，还会出现滚动条，
			解决方法是采用ie浏览器独有的2个方法setCapture()\releaseCapture(),这两个方法，
			可以让鼠标滑动到浏览器外部也可以捕获到事件，而我们的bug就是当鼠标移出浏览器的时候，
			限制超过的功能就失效了。用这个方法，即可解决这个问题。注：这两个方法用于onmousedown和onmouseup中*/
			if(typeof dragDuty.setCapture!='undefined'){
				dragDuty.setCapture();
			}

		document.onmousemove = function(e) {
			var e = e || window.event; //兼容ie浏览器
			var left=e.clientX-diffX;
			var top=e.clientY-diffY;

			//控制拖拽物体的范围只能在浏览器视窗内，不允许出现滚动条
			if(left<0){
				left=0;
			}else if(left >window.innerWidth-dragDuty.offsetWidth){
				left = window.innerWidth-dragDuty.offsetWidth;
			}
			if(top<0){
				top=0;
			}else if(top >window.innerHeight-dragDuty.offsetHeight){
				top = window.innerHeight-dragDuty.offsetHeight;
			}

			//移动时重新得到物体的距离，解决拖动时出现晃动的现象
			dragDuty.style.left = left+ 'px';
			dragDuty.style.top = top + 'px';
		};
		document.onmouseup = function(e) { //当鼠标弹起来的时候不再移动
			this.onmousemove = null;
			this.onmouseup = null; //预防鼠标弹起来后还会循环（即预防鼠标放上去的时候还会移动）

			//修复低版本ie bug
			if(typeof dragDuty.releaseCapture!='undefined'){
				dragDuty.releaseCapture();
			}
		};
	};
 });
 
 
 /**
  * 
  */
 var scheduleDuty = function(freeTableID){
	 if ($("#duty12").children().length > 1) {
		 $("#duty12 td").remove();
		 $("<td>1&nbsp;&nbsp;2</td>").appendTo($("#duty12"));
		 $("#duty345 td").remove();
		 $("<td>3&nbsp;&nbsp;4&nbsp;&nbsp;5</td>").appendTo($("#duty345"));
		 $("#duty6789 td").remove();
		 $("<td>6&nbsp;&nbsp;7&nbsp;&nbsp;8&nbsp;&nbsp;9</td>").appendTo($("#duty6789"));
	 }
	 
	 $.post("ScheduleServlet?action=scheduleDuty",{freeTableID:freeTableID},
		 function(result){
			 var result = eval("("+result+")");
			 $.each(result, function(i, item){
				 addDuty(item, "mon12", "mon345", "mon6789");  // 星期一
				 addDuty(item, "tues12", "tues345", "tues6789");  // 星期二 
				 addDuty(item, "wed12", "wed345", "wed6789");  // 星期三
				 addDuty(item, "thurs12", "thurs345", "thurs6789");  // 星期四
				 addDuty(item, "fri12", "fri345", "fri6789");  // 星期五
			 });
		 }
	 );
	 
	 setTimeout(function(){
		 $("#recommendedPlan-duty").css("display","block");
		 $("#close-button-duty").css("display","block");
	 }, 1000);  // TODO 待完善:后台循环判断次数多，速度慢
 };
 
 var addDuty = function(item, duty12, duty345, duty6789){
	 var dutyUser = "";
	 var exportDutyUser = "";
	 for(var i = 0; i < item.dutyUsers.length; i++){
		 dutyUser = dutyUser + item.dutyUsers[i].name + "\n";
		 exportDutyUser = exportDutyUser + item.dutyUsers[i].name + "，";
	 }
	 if (item.time == duty12) {
		 $("<td>"+dutyUser+"<input type='hidden' name="+item.time+" value="+exportDutyUser+"></td>").appendTo($("#duty12"));
	 }else if (item.time == duty345) {
		 $("<td>"+dutyUser+"<input type='hidden' name="+item.time+" value="+exportDutyUser+"></td>").appendTo($("#duty345"));
	 }else if (item.time == duty6789) {
		 $("<td>"+dutyUser+"<input type='hidden' name="+item.time+" value="+exportDutyUser+"></td>").appendTo($("#duty6789"));
	 }
 };