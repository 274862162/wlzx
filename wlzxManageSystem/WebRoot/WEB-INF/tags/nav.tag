<%@ tag pageEncoding="utf-8" %>
	<!--导航begin-->
	<div class="nav">
		<ul class="margin0_auto" id="nav_li">
			<li><a href="jsp/dutyRegister.jsp">首页</a></li>
			<li><a href="jsp/search.jsp">成员管理</a></li>
			<li><a href="jsp/superManagement1.jsp">超级管理</a></li>
			<!-- 跳转到 DisplayQusnnServlet查询后台数据-->
			<li><a href="SurveySystem/SurveySystemQusnServlet?action=queryQuestionnaire" data-type="submit">调查系统</a></li>
			<li><a href="TestPaperServlet?action=testPaperShow">考核系统</a></li>
			<li><a href="ScheduleServlet?action=scheduleList">无课表系统</a></li>
			<li><a href="PayRollSystem/PayRollServlet?action=payRollSetShowAction&option=view">工资系统</a></li>
			<li><a href="onlineRepairSystem/OnlineRepairServlet?action=repairPersonManage">报修系统</a></li>
		</ul>
	</div>
	<!--导航end-->