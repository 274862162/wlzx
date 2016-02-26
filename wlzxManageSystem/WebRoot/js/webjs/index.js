//Written by hsg
window.onload = function(){
	pictureRoll();  // 图片滚动
};

/**
 * 控制图片滚动
 */
function pictureRoll(){
	var picture_roll = getByClass(document, 'picture_roll')[0];  // 图片滚动区
	var list = getByClass(picture_roll, 'list')[0];  // 滚动的图片列表
	var buttons = getByClass(picture_roll, 'buttons')[0].getElementsByTagName('span');  // 控制图片滚动的小圆圈
	var index = 1;  // 当前滚动的图片
	var animated = false;  // animated为false时，表示滚动完成
	var timer;  // 图片滚动的定时器

	// 滚动图片
	function animate(offset){
		animated = true;  // animated为true时，表示在滚动
		var newLeft = parseInt(list.style.left) + offset;
		var time = 350;  // 滚动总用时
		var interval = 10;  // 滚动间隔时间
		var speed = offset/(time/interval);  // 速度
		
		function go(){
			if((speed < 0 && parseInt(list.style.left) > newLeft) || (speed > 0 && parseInt(list.style.left) < newLeft)){
				list.style.left = parseInt(list.style.left) + speed + 'px';
				setTimeout(go, interval);  
			}else{
				animated = false;  // 此时animated为false时，表示已经滚动完
				list.style.left = newLeft + 'px';
				if(newLeft > -630){  // 当滚动到第一张图片时，再往前滚动就滚动到最后一张图片
					list.style.left = -5040 + 'px';
				}
				if(newLeft < -5040){  // 当滚动到最后一张图片时，再往后滚动就滚动到第一张图片
					list.style.left = -630 + 'px';
				}
			}
		}
		go();  // 滚动
	}
	
	// 开始图片滚动
	function play(){
		timer = setInterval(function(){
			if(index == 8){
				index = 1;  // 当小圆圈滚动到最后一个时，下一次滚动到第一个
			}else{
				index += 1;  // 小圆圈滚动到下一个
			}
			showButton();
			if(!animated){
				animate(-630);
			}
		}, 3000);
	}

	// 停止图片滚动
	function stop(){
		clearInterval(timer);
	}

	// 点击小圆圈滚动图片
	for(var i = 0; i < buttons.length; i++){
		buttons[i].onclick = function(){
			if(!animated){  // 当一次滚动完成后，再点小圆圈时才能再滚动
				if(this.className == 'on'){
				return;  // 如果点击当前处于显示状态的，就跳出函数
				}
				var myIndex = parseInt(this.getAttribute('index'));
				var offset = -630 * (myIndex - index);
				index = myIndex;
				showButton();
				animate(offset);
			}		
		};
	}

	// 小圆圈变化
	function showButton(){
		// 去掉之前的小圆圈的样式
		for(var i = 0; i < buttons.length; i++){
			if(buttons[i].className == 'on'){
				buttons[i].className = '';
				break;
			}
		}
		// 给当前的小圆圈加样式
		buttons[index - 1].className = 'on';
	}

	picture_roll.onmouseover = stop;
	picture_roll.onmouseout = play;
	play();  // 默认自动滚动
}

/**
 * 获取parent下className为指定class的元素
 */
function getByClass(parent, cls){
    var oResult = [];
    var oEle = parent.getElementsByTagName('*');
    for (var i = 0; i < oEle.length; i++) {
        if (oEle[i].className == cls) {
            oResult.push(oEle[i]);
        }
    }
    return oResult;
}