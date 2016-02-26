var examTime = 60*60,  // 考试总时间(修改前面的数字，60即60分钟)
	remainTime = examTime;  // 考试剩余时间
	
var showCount = function(){
	remainTime -= 1;
	var hourR = Math.floor(remainTime / 3600),
		minuteR = Math.floor((remainTime - hourR * 3600) / 60),
		secondR = Math.floor(remainTime - hourR * 3600 - minuteR * 60);
	document.getElementById("remainTime").innerHTML = format(hourR)+":"+format(minuteR)+":"+format(secondR);

	if (remainTime == 600) {
		alert("考试时间还有十分钟！");
	}	
	// 当剩余时间为0时，自动提交
	if(remainTime == 0){
		document.getElementById("paperForm").submit();
		alert("考试时间已到，试卷自动提交！");
	}
}; 

var format = function(timeNumber){
	if(timeNumber < 10){
		return "0" + timeNumber;
	}else{
		return timeNumber;
	}
};

var submitPaper = function () {
	if (confirm("交卷后将不得修改，确定要提交试卷吗？")) {
		document.getElementById("paperForm").submit();
	}
	alert("试卷已成功提交！");
	window.opener = null;
	window.close();
};

window.setInterval("showCount()", 1000);