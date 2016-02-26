<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webHead" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webNav" %>
<%@ taglib tagdir="/WEB-INF/tags/webtag" prefix="webFoot" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!---The site is designed by 网络中心-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="网络中心学生技术团队">
<meta name="description" content="xxxxxxxxxxxxxxxxxxx">
<title>solveProblem</title>
<%   
	String path = request.getContextPath();   
	String basePath = request.getScheme()+ "://" +request.getServerName()+ ":" +request.getServerPort()+path+ "/" ;   
%>   
<base href= "<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/webcss/base.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/common.css" />
<link rel="stylesheet" type="text/css" href="css/webcss/solveProblem.css" />
</head>

<body>
<div class="wrapper margin0_auto"><!--整体包围-->
	<!--头部-->
	<webHead:webHead></webHead:webHead>
	<!--头部结束-->
	
	<!--导航-->
	<webNav:webNav></webNav:webNav>
	<!--导航结束-->

	<div class="margin0_auto"><!--子导航-->
	<ul class="none_list_style_type">
		<form class="subnav_form float_r" action="" method="post">
		<input class="text" type="text" name="search" value="搜索文档" onfocus="if (value =='搜索文档'){value =''}" onblur="if (value ==''){value='搜索文档'}"/>
		</form>
	</ul>
	</div>

	<div class='index_image'>
		<!--图片-->
	</div>

	<!--中下部-->
	<div class="inner">
		<!--中下部导航-->
		<div class="frame1 margin0_auto">
		<ul class="text_align_c">
			<li  class="nav2" style="background:#F6C043"><a class="none_text_decoration f_white f17 display_i_b" href="#">联通宽带</a></li>
			<li  class="nav2" style="background:#45B56F"><a class="none_text_decoration f_white f17 display_i_b" href="#">电信宽带</a></li>
			<li  class="nav2" style="background:#478FFA"><a class="none_text_decoration f_white f17 display_i_b" href="#">锐捷连接</a></li>
		</ul>
		</div><!--中下部导航结束-->

		<!--中部二级导航-->
		<div  class="frame2 margin0_auto">
		<ul>
			<li class="display_i arc"><a class="none_text_decoration display_i_b arc_now" href="#">错误代码</a></li>
			<li class="display_i arc"><a class="none_text_decoration display_i_b" href="#">其他</a></li>
		</ul>
		</div><!--中部二级导航结束-->

		<!--水平线-->
		<hr class="hr_type"/>
		<!--文本区1-->
		<div class="text_type"> 
			<ul class="text_title">
				<li class="display_i title_icon">1</li>
				<li class="display_i">691</li>
			</ul>
			<p>处理方法:</p>
			<p>1.重新输入正确的账号和密码，如果密码忘记了，则让同学自己拨打10010的人工服务，提供开户人的身份证号码就可更
				改密码。（密码不能查询，只能修改）</p>
			<p>2.如果用户账号密码填写无误，则进入下一步继续处理；建议重新建立宽带连接，如果重装拨号后故障依旧， 则让同学登
				陆网上自助网址：http://service.gduf.edu.cn.8080/selfservice/打开网页后用自己的用户名登陆），按照规定方式填写
				报修资料。</p>
			<p>3.宽带到期欠费造成的。让同学到联通摊位续费。</p>
			<p>4.用完后没断开，至少服务器那边还是没断开，导致非正常下线，所以错误691。建议该同学每次关机的时候在宽带连接
				上右键，点断开。</p>
		</div>
		<!--文本区2-->
		<div  class="text_type">
			<ul class="text_title">
				<li class="display_i title_icon">2</li>
				<li class="display_i">宽带连接错误734(PPP 链接控制协议被终止)/错误735(请求的地址被服务器拒绝)</li>
			</ul>
			<p>处理方法：</p>
			<p>1.建议重新启动电脑。</p>
			<p>2.拨号软件出错，建议重装拨号软件，常见于ＸＰ系统的自带拨号。</p>
			<p>3.以上处理均无效或用户无法做简单的配合操作，请拨打客服电话10010人工服务进行障碍申告。</p>
			<p>4.查看“宽带连接”属性-网络-IPV4,查看有没有填写IP，改为自动获取</p>
		</div>
		<!--文本区3-->
		<div class="text_type">
			<ul class="text_title">
				<li class="display_i title_icon">3</li>
				<li class="display_i">宽带连接错误734(PPP 链接控制协议被终止)/错误735(请求的地址被服务器拒绝)</li>
			</ul>
			<p>处理方法：</p>
			<p>1.建议重新启动电脑。</p>
			<p>2.拨号软件出错，建议重装拨号软件，常见于ＸＰ系统的自带拨号。</p>
			<p>3.以上处理均无效或用户无法做简单的配合操作，请拨打客服电话10010人工服务进行障碍申告。</p>
			<p>4.查看“宽带连接”属性-网络-IPV4,查看有没有填写IP，改为自动获取</p>
		</div>
		<!--文本区4-->
		<div class="text_type" style="margin-bottom:300px">
			<ul class="text_title">
				<li class="display_i title_icon">4</li>
				<li class="display_i">宽带连接错误734(PPP 链接控制协议被终止)/错误735(请求的地址被服务器拒绝)</li>
			</ul>
			<p>处理方法：</p>
			<p>1.建议重新启动电脑。</p>
			<p>2.拨号软件出错，建议重装拨号软件，常见于ＸＰ系统的自带拨号。</p>
			<p>3.以上处理均无效或用户无法做简单的配合操作，请拨打客服电话10010人工服务进行障碍申告。</p>
			<p>4.查看“宽带连接”属性-网络-IPV4,查看有没有填写IP，改为自动获取</p>
		</div>
	</div><!--中下部结束-->
	
	<!--脚部-->
	<webFoot:webFooter></webFoot:webFooter>
	<!--脚部结束-->

</div>
<!-- 整体包围结束 -->
</body>
</html>