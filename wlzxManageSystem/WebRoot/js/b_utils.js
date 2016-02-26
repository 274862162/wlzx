/**
 * 获取parent下className为指定class的元素
 */
function getByClass(parent, cls){
    var oResult = [];
    var oEle = parent.getElementsByTagName('*');
    for (var i = 0; i < oEle.length; i++) {
        if (oEle[i].className == cls) {
            // 这里不能直接return oEle[i]，否则每次就只得到一个className == class的oEle
            oResult.push(oEle[i]);
        }
    }
    return oResult;
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
 * 控制运动
 * obj:要控制运动的元素
 * json:运动形式; 例{height:100}表示高度变到100px
 * fnEnd:运动结束时调用的函数
 */
function startMove(obj, json, fnEnd)
{
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