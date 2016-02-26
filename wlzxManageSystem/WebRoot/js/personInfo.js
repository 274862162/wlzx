/**
 * personInfo.js判断填入的信息是否正确
 * @authors Your Name (you@example.org)
 * @date    2015-03-21 20:52:23
 * @version $Id$
 */

window.onload=function(){
	//用户名检验
	var userNoPattern=/^[a-zA-Z]{2,5}$/;
	var userNo=document.getElementById('userNo').value;
	var errorUserNo=document.getElementById('errorUserNo');
	if(userNoPattern.test(userNo)==false){
		errorUserNo.style.display='inline';
	}

	//长号检验
	var longPhonePattern=/^[0-9]{11}$/
	var longPhone=document.getElementById('longPhone').value;
	var errorLongPhone=document.getElementById('errorLongPhone');
	if(longPhonePattern.test(longPhone)==false){
		errorLongPhone.style.display='inline';
	}

	//短号检验
	var shortPhonePattern=/^[0-9]{4,6}$/
	var shortPhone=document.getElementById('shortPhone').value;
	var errorShortPhone=document.getElementById('errorShortPhone');
	if(shortPhonePattern.test(shortPhone)==false){
		errorShortPhone.style.display='inline';
	}
};
