$(function(){
	infoShowHide('notice_department', 'notice_content', 200);  // 公告栏信息的显示和隐藏
});

/**
 * 信息的显示和隐藏
 */
function infoShowHide(className1, className2, _height){
	var department = getByClass(document, className1);
	var content = getByClass(document, className2);
	var curIndex;  // 当前显示的索引
	
	
	
	for(var i in department){
		(function(i){
			department[i].onclick = function(){
				if(content[i].offsetHeight == 0){
					if(curIndex == undefined){  // 第一次点击
						getContent(i);
					}else if(i != curIndex){
						getContent(i);
						hideContent(curIndex);																		
					}else{
						getContent(i);
					}				
					curIndex = i;				
				}else{
					hideContent(curIndex);
				}
			};
 		})(i);	
		
		// 显示
		function showContent(n,text){
			startMove(content[n], {height: _height});
			content[n].innerHTML = "<p>&nbsp;&nbsp;&nbsp;"+text+"</p>";
			department[n].getElementsByTagName('img')[0].src = 'images/search/search_03.png';
		}
		
		// 隐藏
		function hideContent(n){
			startMove(content[n], {height: 0});
			department[n].getElementsByTagName('img')[0].src = 'images/search/search_04.png';
		}
		
		//取公告内容
		function getContent(n){
			var text = "暂无公告";
			var department = "";
			if(n==0){
				department = "资源部";
			}else if(n == 1){
				department = "技术部";
			}else{
				department = "综合部";
			}
			var param={};
			param.department = department;
			$.ajax({
		 		   url  : "GetNotice",  
		 		   data : param,
		 		   type : "post",                  
		 		   cache: false,
		 		   dataType:"json", 
		 		   error : function(x, er){
		 			    //请求失败时调用	
		 			    alert("请求失败"); 
		 		   },
		 		   success :function(result){  //请求成功时调用。 
		 			  text = result.content;
		 			  showContent(n,text);
		 		   }
			});
		}
	}
}