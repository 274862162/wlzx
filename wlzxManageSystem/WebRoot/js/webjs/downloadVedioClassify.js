//Written by hsg
window.onload = function(){	
	dLvDShowHide();  // download/vedioClassify右部下载区/视频区的显示隐藏
};

/**
 * 控制下载区/视频区的显示隐藏
 */
function dLvDShowHide(){
	var list = document.getElementById("list");
	var classify = list.getElementsByTagName("li");  // 分类检索下的选项
	for(var i = 0; i < classify.length; i++){
		classify[i].onmouseenter = function(){         
            var num = this.id.substring(4,5);  // 当前选中的分类的编号
			
			for(var j = 1; j <= classify.length; j++){
				if(j == num){
					document.getElementById("area"+j).style.display="block";  // 显示选中的分类对应的内容
				}else{
					document.getElementById("area"+j).style.display="none";  // 其他的不显示
				}
            }
		};
	}
}