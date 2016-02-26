/**
 * 控制运动
 * obj:要控制运动的元素
 * json:运动形式; 例{height:100}表示高度变到100px
 * fnEnd:运动结束时调用的函数
 */
function startMove(obj, json, fnEnd){
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
		// 假设所有运动都到了指定的目标点
        var bStop = true;  
        for (var attr in json) {
            var cur = 0;
            // 透明度
            if (attr == 'opacity') {
                cur = Math.round(parseFloat(getStyle(obj, attr)) * 100);
            }
            else {
                cur = parseInt(getStyle(obj, attr));
            }
            // 设置缓存速度; json[attr]相当于当前那个运动的的目标点
            var speed = (json[attr] - cur) / 6; 
            // 缓存速度取整
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
			// 若有还没运动完的就把bStop设为false
            if (cur != json[attr])  
            {
                bStop = false;
            }
            if (attr == 'opacity') {
				// IE
                obj.style.filter = 'alpha(opacity:' + (cur + speed) + ')';
				// Fx等
                obj.style.opacity = (cur + speed) / 100;			
            }
            else {
                obj.style[attr] = cur + speed + 'px';
            }
        }     
        if (bStop)
        {
            clearInterval(obj.timer);
            if (fnEnd) {fnEnd();}
        }
    }, 10);
}

/**
 * 控制页面滚动
 * target:要滚动到的目标点
 * speed:速度
 */
function startRoll(target, speed){
    if(target != null){
        // 使目标点距离顶部30px
        var top = getElementTop(target) - 30;
    }else{
        // 回到顶部
        top = 0;
    }
    timer = setInterval(function(){
        // 获得页面可视区距离网页顶部的距离
        // IE,Fx: document.documentElement.scrollTop; Chrome: document.body.scrollTop
        var scrollTop = document.documentElement.scrollTop||document.body.scrollTop;
        if(scrollTop == 0){
            scrollTop = 1;
        }
        // 速度取整
        var ispeed = Math.ceil((top - scrollTop) / speed);
        document.documentElement.scrollTop = document.body.scrollTop = scrollTop + ispeed;
        // 往下滚动
        if(top != 0){
            // 滚动到目标点就清除定时器timer，停止滚动
            if (document.documentElement.scrollTop >= top || document.body.scrollTop >= top){
                document.documentElement.scrollTop = document.body.scrollTop = top;
                clearInterval(timer);
            }
            // 当滚动到网页最底部，但还没到达目标点时，清除定时器timer，停止滚动
            if(document.body.offsetHeight - document.documentElement.scrollTop + 30 <= document.documentElement.clientHeight || document.body.offsetHeight - document.body.scrollTop + 30 == document.documentElement.clientHeight){
                clearInterval(timer);
            }
        }
        // 回到顶部（当距离顶部足够小，就置顶）
        else{
            if (scrollTop - 5 <= 0){
                document.documentElement.scrollTop = document.body.scrollTop = 0;
                clearInterval(timer);
            }
        }
    },12);
}

/**
 * 获得对象的属性
 * obj:对象名
 * name:属性名
 */
function getStyle(obj, name) {
    if (obj.currentStyle) {
        return obj.currentStyle[name];
    }
    else {
        return getComputedStyle(obj, false)[name];
    }
}

/**
 * 获得某元素到网页顶部的距离
 */
function getElementTop(element){
    var actualTop = element.offsetTop;  // 相对父级的Top
    var current = element.offsetParent;
    while(current !== null){
        actualTop += current.offsetTop;
        current = current.offsetParent;
    }
    return actualTop;
}