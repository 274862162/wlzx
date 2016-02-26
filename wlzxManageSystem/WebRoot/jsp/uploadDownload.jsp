<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="head" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="nav" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="notice" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="foot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;">
<head>
    <!-- The site is designed by 网络中心.Written by tmn-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="网络中心学生技术团队">
    <meta name="description" content="xxxxxxxxxxxxxxxxxxx">
    <title>网络中心学生技术团队_资源共享</title>
    <%   
		String path = request.getContextPath();   
		String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
	%>   
	<base href= "<%=basePath%>">  
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/uploadDownload.css" />
	<link rel="stylesheet" type="text/css" href="css/personInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/dutyRegister.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/notice.js"></script>
	<script type="text/javascript" src="js/b_utils.js"></script>
	
	<script type="text/javascript">
  		var page = 1;
		var displayRecord = 5;
		var totalPage = 1;
		var type = 0;
		var section = "";
		$(function(){	
			if(request("section")!=null && request("section")!=""){
				section = request("section");
			}else{
				section = "技术部";
			}
			getFile();
			$("input[name='section']").val(section);
			$("#up").click(function(){
				upPage();
			});
			$("#down").click(function(){
				downPage();
			});
		});
		function upPage(){
			if(page>1){
				page = page-1;
				getFile();
			}
		}
		function downPage(){
			if(page+1<=totalPage){
				page = page + 1;
				getFile();
			}
		}
		function changeType(t){
			$(".uploadDownload_type li a span img").attr("style","");
			$(".uploadDownload_type li a span img").eq(t).attr("style","background:#F5F5F5");
			type = t;
			getFile();
		}
		function changeSection(s){
			$(".uploadDownload_department li a").attr("style","");
			$.each($(".uploadDownload_department li a"),function(){
				if($(this).html()==s){
				$(this).attr("style","color:#0066ff");
				}
			});
			section = s;
			$("input[name='section']").val(s);
			getFile();
		}
		//取URL参数
		function request(paras){   
	        var url = location.href;   
	        var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");   
	        var paraObj = {}; 
	        for (var i=0; j=paraString[i]; i++){   
	            paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);   
	        }   
	        var returnValue = paraObj[paras.toLowerCase()];   
	        if(typeof(returnValue)=="undefined"){   
	            return "";   
	        }else{   
	            return decodeURI(returnValue);   
	        }   
		}
  		function getFile(){
  			var param = {};
			param.page = page;
			param.displayRecord = displayRecord;
			param.section = section;
			param.type = type;
			$.ajax({
		 	   url  : "CommonServlet_ajax?action=showUpDownload",  
		 	   data : param,
		 	   type : "post",                  
		 	   cache: false,
		 	   dataType:"json", 
		 	   error : function(x, er){
		 		    //请求失败时调用	
		 		    alert("请求失败"); 
		 	   },
		 	   success :function(result){  //请求成功时调用。 
		 		   	$("#tb_resource").children($("<tr>")).remove();
		 	   		$.each(result,function(){
					    $.each(this.list,function(){
			 			   	$("#tb_resource").append('\
			 			   		<tr>\
                        		<td>\
                        		<div><img src="images/uploadDownload/uploadDownload2_2'+this.type+'.png" /><span>'+this.fileName+'</span></div>\
                       	 		</td>\
                        		<td>'+this.uploadTime+'</td>\
                        		<td><a href="DownloadServlet?fileID='+this.materialID+'"><span><img src="images/uploadDownload/uploadDownload2_11.png"/></span></a></td>\
                   			 	</tr>');
			 		    });
			 			//page = this.page;
			 			totalPage = this.totalPage;
			 			$("#page").val(page);
			 			$("#totalPage").html(totalPage);
			 		});			 			 
		 		 }
	 		});
  		}
  	</script>
</head>


<body style="height:100%;">
<!--整体包围-->
<div class="wrapper margin0_auto" style="height:100%;">
	<head:header></head:header>
    <nav:nav></nav:nav>
	
	<!--中部内容区begin-->
	<div class="content" style="height:100%;">
    	<!--左部菜单begin-->
        <div class="menu" style="height:100%;float:left">
            <ul class="none_list_style_type" style="height:100%;">
                <li><a href="jsp/dutyRegister.jsp"><img alt="" src="images/basicInfo/ico01.png"/><p>值班记事</p></a></li>
                <li><a href="jsp/searchSwitch.jsp"><img alt="" src="images/basicInfo/ico02.png"/><p>交换机信息</p></a></li>
                <li><a href="jsp/uploadDownload.jsp" class="active"><img alt="" src="images/basicInfo/ico03.png"/><p>资料共享</p></a></li>
                <li><a href="jsp/indexSystemLogManagement.jsp"><img alt="" src="images/basicInfo/ico05.png"/><p>日志管理</p></a></li>
                
            </ul>
        </div>
    	<!--左部菜单end-->
    
    	<!--资源上传下载begin-->
        <div class="personInfo">
			<div class="personInfo_nav f14">首页&nbsp;&nbsp;>>&nbsp;&nbsp;资源上传下载</div>
            <ul class="uploadDownload_department none_list_style_type">
            	<li class="f14 float_l"><a href="javascript:changeSection('技术部')" style="color:#0066ff">技术部</a></li>
                <li class="f14 float_l"><a href="javascript:changeSection('资源部')">资源部</a></li>
                <li class="f14 float_l"><a href="javascript:changeSection('综合部')">综合部</a></li>
            </ul>   
            <hr/>
            
            <ul class="uploadDownload_type none_list_style_type">
            	<li class="float_l"><a href="javascript:changeType(0);"><span><img style="background:#F5F5F5"src="images/uploadDownload/uploadDownload2_00.png"/></span></a></li>
                <li class="float_l"><a href="javascript:changeType(1);"><span><img src="images/uploadDownload/uploadDownload2_01.png"/></span></a></li>
                <li class="float_l"><a href="javascript:changeType(2);"><span><img src="images/uploadDownload/uploadDownload2_02.png"/></span></a></li>
                <li class="float_l"><a href="javascript:changeType(3);"><span><img src="images/uploadDownload/uploadDownload2_03.png"/></span></a></li>
                <li class="float_l"><a href="javascript:changeType(4);"><span><img src="images/uploadDownload/uploadDownload2_04.png"/></span></a></li>
                <li class="float_l"><a href="javascript:changeType(5);"><span><img src="images/uploadDownload/uploadDownload2_05.png"/></span></a></li>
            </ul>
         	
         	<!-- 浏览上传文件按钮begin -->
            <div class="uploadDownload_upload">
                <div class="file-box"> 
                    <form method="post" action="UploadServlet" enctype="multipart/form-data"> 
                        <input type="text" name="textfield" id="textfield" class="txt" /> 
                        <input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" /> 
                        <input type="button" class="btn" value="浏览..." /> 
                        <input type="hidden" name="section"/>
                        <input type="submit" name="submit" class="btn" value="上传" /> 
                    </form> 
                </div>
            </div>
            <!-- 浏览上传文件按钮end -->
            
            <div class="uploadDownload_item">
            	<table frame="hsides" rules="rows" id="tb_resource">
            	  <%-- <c:forEach var="ul" items="${upDownloadList}" varStatus="status">
                    <tr>
                        <td>
                        	<div><img src="images/uploadDownload/uploadDownload2_2${ul.type }.png" /><span>${ul.fileName }</span></div>
                        </td>
                        <td><fmt:formatDate value="${ul.uploadTime}" type="date"/></td>
                        <td><a href="DownloadServlet?fileID=${ul.materialID }"><span><img src="images/uploadDownload/uploadDownload2_22.png"/></span></a></td>
                    </tr>
                  </c:forEach> --%>
                </table>
            </div>   
            
            <div class="uploadDownload_page">
            	<a class="pageUp" href="javascript:;" id="up">&lt;&lt;上一页</a>
                <a class="pageDown" href="javascript:;" id="down">下一页&gt;&gt;</a>
            </div>   
        </div>	
    	<!--资源上传下载end-->
    
    	<!-- 右侧公告 -->
        <notice:notice></notice:notice>
    </div>
	<!--中部内容区end-->


	<!-- 脚部 -->
    <foot:footer></foot:footer>
</div>
<!--中部包围结束-->

</body>
</html>