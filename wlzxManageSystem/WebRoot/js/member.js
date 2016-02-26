if(window.onload != null){
	eval("theOldFun="+window.onload.toString());
	window.onload = function(){
		theOldFun();
		infoShowHide('member_department', 'member_content', 671);  // 部门成员信息的显示和隐藏
		memberTipShowHide();  // 成员信息提示框的显示和隐藏
	};
}

/**
 * 成员信息提示框的显示和隐藏
 */
function memberTipShowHide(){
	var memberTipBoxClass = "memberTip-box";  // 提示框样式
	var isIE = navigator.userAgent.indexOf("MSIE") > -1;  // 判断是否是IE浏览器
	var getEl = function(id){ 
		return document.getElementById(id);
	};

	var oUl = getEl("oUl");

	/**
	 * obj:memberTip 超链接元素
	 * id:memberTip提示框id
	 * html:memberTip提示框HTML
	 * width:memberTip提示框宽度（可选）
	 * height:memberTip提示框高度（可选）
	 */
	function showMemberTip(obj, id, html, width, height){
		if(getEl(id)==null){ 
			// 创建 <div class="tooltip-box" id="xx">xxxxxx</div>
			var memberTipBox;
			memberTipBox = document.createElement("div");
			memberTipBox.className = memberTipBoxClass;
			memberTipBox.id = id;
			memberTipBox.innerHTML = html;
			obj.appendChild(memberTipBox);
			
			memberTipBox.style.width = width? width+"px":"auto";
			memberTipBox.style.height = height? height+"px":"auto";		
			if(!width && isIE){ 
				memberTipBox.style.width = memberTipBox.offsetWidth;
			}
	
			var left = obj.offsetLeft + 123;
			var top = obj.offsetTop - 17;	
			memberTipBox.style.left = left + "px";
			memberTipBox.style.top = top + "px";
			
			obj.onmouseleave = function(){
				// 提示框300毫秒后再消失
				setTimeout(function(){
					getEl(id).style.display = "none";
				}, 300);
			};
		}
		else{ 
			// 显示
			getEl(id).style.display = "block";
		}	
	}
	
	
	oUl.onmouseover = function(e){
        var event = e || window.event;
        var target = event.target || event.srcElement;

        if(target.className == "memberTip"){  // 事件冒泡得到className等于memberTip的节点
            var _html;
            var _id;
            var _width = 165;

            switch (target.id) {
                case "member1":
                    _id = "m1";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member2":
                    _id = "m2";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member3":
                    _id = "m3";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member4":
                    _id = "m4";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member5":
                    _id = "m5";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member6":
                    _id = "m6";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member7":
                    _id = "m7";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member8":
                    _id = "m8";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member9":
                    _id = "m9";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member10":
                    _id = "m10";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member11":
                    _id = "m11";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member12":
                    _id = "m12";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member13":
                    _id = "m13";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member14":
                    _id = "m14";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member15":
                    _id = "m15";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member16":
                    _id = "m16";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member17":
                    _id = "m17";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member18":
                    _id = "m18";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member19":
                    _id = "m19";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member20":
                    _id = "m20";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member21":
                    _id = "m21";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member22":
                    _id = "m22";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member23":
                    _id = "m23";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member24":
                    _id = "m24";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member25":
                    _id = "m25";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member26":
                    _id = "m26";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member27":
                    _id = "m27";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member28":
                    _id = "m28";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member29":
                    _id = "m29";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member30":
                    _id = "m30";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member31":
                    _id = "m31";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member32":
                    _id = "m32";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member33":
                    _id = "m33";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member34":
                    _id = "m34";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member35":
                    _id = "m35";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                case "member36":
                    _id = "m36";
                    _html = "<p>121544202&nbsp;陈靖妍<br/>住址 : 18#B303<br/>负责楼栋 : 20#B<br/>13631440610(660610)</p>";
                    break;
                default:
                    return false;
            }

            showMemberTip(target, _id, _html, _width);
        }
	};

    /*
        显示(隐藏)成员个人信息、各部门总体情况、网络中心学生技术团队总体情况
    */
    var memberNo=document.getElementById('member1');
    var general=document.getElementById('memberManagement-generalSituation');
    var person=document.getElementById('memberManagement-personSituation');
    var technologyDepartment=document.getElementById('technology');
    var threedepartmentSituation=document.getElementById('departmentSituation');
    var memberManagementNav=document.getElementById('memberManagementNav');
    memberManagementNav.onclick=function(){
        general.style.display='block';
        person.style.display='none';
        threedepartmentSituation.style.display='none';
    };
    memberNo.onclick=function(){
        general.style.display='none';
        threedepartmentSituation.style.display='none';
        person.style.display='block';
    };
    technologyDepartment.onclick=function(){
        general.style.display='none';
        person.style.display='none';
        threedepartmentSituation.style.display='block';
    };
}
