window.onload = function(){
	document.getElementById('project').onclick = function(){
		showProgram();
	};
};

/**
 * 显示推荐的解决方案
 */
function showProgram(){
	// 获取页面的宽度
	var sWidth = document.body.scrollWidth;
	// 获取页面的可视区域高度
	var wHeight = document.documentElement.clientHeight;
		
	// 创建一个div显示推荐方案
	var program = document.createElement("div");
	program.id = "program";
	program.innerHTML = "<div class='handle'>方案1：重装网卡驱动<br/>方案2：更换网线<br/>方案3：重装系统<br/></div><div id='confirm'>确定</div>";
	document.body.appendChild(program);
	
	// 获取div的宽和高
	var dHeight = program.offsetHeight;
	var dWidth = program.offsetWidth;
	// 设置div的left和top
	program.style.left = sWidth/2 - dWidth/2 + "px";
	program.style.top = wHeight/2 - dHeight/2 + "px";
	
	// 点击确定按钮关闭div
	document.getElementById("confirm").onclick = function(){
		document.body.removeChild(program);
	};
}