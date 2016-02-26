$(function(){
	$("#check").click(function(){
		$.ajax({
			   url  : "SignServlet",  
			   data : null,
			   type : "post",                  
			   cache: false,               
			   dataType:"text",          
			   error : function(x, er) {
				    //请求失败时调用	
				    alert("请求失败");
			   },
			   success :function(result){  //请求成功时调用。
				   alert(result);
			   }
		});
	});	
});
