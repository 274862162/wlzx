window.onload = function(){
    beginNextTop();  // 点击'开始','Next','Top'按钮滚动
    msgShowHide();  // 点击toggle图标显示隐藏部门信息
};

/**
 * 控制部门信息的显示隐藏
 */
function msgShowHide(){
    var tG = new Array(6);  // 部门介绍信息的开关
    var mSg = new Array(6);  // 部门介绍信息的会话框
    for(var i=0; i<tG.length; i++){
        tG[i] = document.getElementById("tg"+i);
        mSg[i] = document.getElementById("msg"+i);
    }

    var num = null;
    var mSgHeight = null;
    // 点击toggle图标显示隐藏信息
    for(var i in tG){
        tG[i].flag = 1;  // 部门介绍信息是否显示的标志
        tG[i].onclick = function(){
            num = this.id.substring(2,3);
            mSgHeight = mSg[num].children[0].offsetHeight;  // 获得要显示信息的高度
            if(tG[num].flag){
                tG[num].style.webkitTransform="rotateZ(225deg)";  // toggle图标绕Z轴旋转 Chrome
                tG[num].style.transform="rotateZ(225deg)";  //Fx, IE11, IE10
                startMove(mSg[num], {height:mSgHeight, opacity:100});  // 信息显示
                mSg[num].className = "department_msg triangle";
                tG[num].flag = 0;
            }else{
                tG[num].style.webkitTransform="rotateZ(0deg)";  // toggle图标绕Z轴转回原点 Chrome
                tG[num].style.transform="rotateZ(0deg)";  //Fx, IE11, IE10
                startMove(mSg[num], {height:0, opacity:0});  // 信息隐藏
                mSg[num].className = "department_msg";
                tG[num].flag = 1;
            }
        };
    }
}

/**
 * 控制'开始','Next','Top'按钮
 */
function beginNextTop(){
    // '开始'和'Next'按钮
    var begin = document.getElementById("begin");
    var next1 = document.getElementById("next1");
    var next2 = document.getElementById("next2");
    var top = document.getElementById("top");

    begin.onclick = function(){
        startRoll(document.getElementById("icon_technology"), 18);  // 滚动到技术部
    };
    next1.onclick = function(){
        startRoll(document.getElementById("icon_resource"), 18);  // 滚动到资源部
    };
    next2.onclick = function(){
        startRoll(document.getElementById("icon_comprehensive"), 18);  // 滚动到综合部
    };
    top.onclick = function(){
        startRoll(null, 6);  // 滚动到顶部
    };
}