<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getServletContext().getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/cyfw.js"></script>
<script>
	var pageNum = 1;
	function doSub(pageNum) {

		$("#reslistTable").load(
				"foreResList?isForeIndex='ture'&o=" + new Date().getTime(), {
					pageNum : pageNum
				});
	}
	function mdoSub(pageNum) {
		$("#mlistTable").load(
				"MessageListServlet?isForeIndex='ture'&o="
						+ new Date().getTime(), {
					pageNum : pageNum
				});
	}
	//通知列表 
	function tdoSub(pageNum) {
		$("#annListTable").load(
				"fAnnounceList?isForeIndex='ture'&o=" + new Date().getTime(), {
					pageNum : pageNum
				});
	}

	window.onload = function() {
		doSub(1);
		mdoSub(1);
		tdoSub(1);
	}
</script>
</head>

<body>

	<div id="head">

		<!-- 头部 -->
		<div class="wrapper clear margin height">
			<div class="logo left">
				<a> <img src="images/logo.png" /> <span>尚学在线教学系统</span>
					<p>Online Teaching System</p>
				</a>
			</div>
			<div class="headR tr mt right">
				<!-- <div class="headRset f14 clear ">
     <a href="#" title="修改密码" class="h_r03">&nbsp;</a><a href="#" title="信息" class="h_r02">&nbsp;</a>
     <a href="#">退出</a><span class="right">张晓明，欢迎您！</span>
    </div>-->
				<div class="headRset f14 clear dis">
					<div class="loginipt left">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					<a href="jspf/UserLogin.jsp"> <input type="button"
						class="button" value="重新登录" /></a><a href="javascript:void(0);"
						title="修改密码" class="h_r03">&nbsp;</a><a href="javascript:void(0);"
						title="信息" class="h_r02">&nbsp;</a>
				</div>
				<div class="headRfast f12 clear">
					<a href="jspf/fAnnounceList.jsp" title="建言献策" class="h_f03">建言献策</a>
					<a href="jspf/fAnnounceList.jsp" title="网站公告" class="h_f01">网站公告</a>
				</div>
			</div>
		</div>

		<!-- 导航 -->
		<!--<div id="navmenu" class="wrapper clear margin01">
   <a class="n_m01" href="#">首页</a>
   <a href="#">通知公告</a>
   <a href="#">办事大厅</a>
   <a href="#">应用系统</a>
   <a href="#">常用服务</a>
   <a href="#">师生心声</a>
   <a href="#">管理模块</a>
  </div>-->
	</div>
	<div class="clearfix"></div>
	<!-- 管理中心 -->
	<div id="management">
		<div class="wrapper margin clear">

			<!-- 头像 -->
			<div class="tearch left clear">
				<div class="user left">
					<div class="zhehead">
						<img src="images/zhehead.png" />
					</div>
					<div class="userhead">
						<img src="${loginUser.teaHead }" />
					</div>
				</div>
					<div class="userInfor left f14">
					<strong>工号：</strong>${loginUser.teaNo }<br /> <strong>姓名：</strong>${loginUser.teaName }<br />
					<strong>部门：</strong>${loginUser.teaGroup }
				</div>
			</div>

			<!-- 消息 -->
			<div class="message right f14 clear fbold">
				<a class="mess_09" href="jspf/MessageList.jsp" title="">我的消息(<span
					class="orange">0</span>)
				</a> <a class="mess_01" href="jspf/MessageSave.jsp" title="">发送消息(<span
					class="orange">10</span>)
				</a> <a class="mess_02" href="jspf/resList.jsp" title="">我的课件(<span
					class="orange">3</span>)
				</a> <a class="mess_04" href="jspf/workList.jsp" title="">已发布作业(<span class="orange">8</span>)
				</a> <a class="mess_03" href="jspf/tea_studentList.jsp" title="">查询选课学生(<span
					class="orange">8</span>)
				</a> 
		<!--  	<a class="mess_06" href="javascript:(0)" title="">进入论坛</a>      -->	
				<a class="mess_08" href="jspf/releaseList.jsp" title="">问卷调查(<span
					class="orange">0</span>)
				</a>

			</div>
		</div>
	</div>

	<div class="wrapper margin clear">

		<!-- 通知公告 -->
		<div class="module wmodule left">
			<div class="moduleT clear">
				<span class="left">通知</span><a class="right"
					href="jspf/fAnnounceList.jsp" data-reveal-id="myModal">> 更多</a>

			</div>
			<div id="annListTable" class="tablelist margin"></div>
		</div>

		<!-- 常用服务 -->
		<div class="module wmodule right" style="height: 182px;">
			<div class="moduleT clear">
				<span class="left">常用服务</span>
		<!--		<a class="right"
					href="javascript:void(0);" data-reveal-id="myModal">> 更多</a>
				-->
			</div>
			<div class="servicebox">
				<div class="serviceboxbleft">
					<div class="serviceboxbcon">
						<ul class="serviceboxlist1">
							<li><a href="jspf/MessageList.jsp"><img src="images/through_05.png" />消息管理</a></li>
							<li><a href="/Team3_ZXJY/jspf/resList.jsp"><img
									src="images/ky_04.png" />课件管理</a></li>
							<li><a href="/Team3_ZXJY/jspf/workList.jsp"><img
									src="images/xz_07.png" />作业管理</a></li>
							<!-- <li><a href="#"><img src="images/menage_11.png" />我的课程</a></li> -->
							<li><a href="#"><img src="images/through_07.png" />学生答疑</a></li>
						</ul>
						<ul class="serviceboxlist1">
							<li><a href="/Team3_ZXJY/jspf/releaseList.jsp"><img
									src="images/zk_03.png" />问卷调查</a></li>
							<li><a href="/Team3_ZXJY/jspf/Tea_AddStudent.jsp"><img
									src="images/service_05.png" />添加学生</a></li>
						</ul>
					</div>
					<div id="serviceboxlist_mark1" class="serviceboxbconspan">
						<em></em><em></em>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

	<!-- 最新消息 -->
	<div class="wrapper margin01 clear">
		<div class="moduleT clear">
			<span class="left">消息</span><a class="right"
				href="jspf/MessageList.jsp" data-reveal-id="myModal">> 更多</a>

		</div>
		<div id='mlistTable' class="tablelist margin"></div>

	</div>
	<!-- 最新上传课件 -->

	<div class="wrapper margin01 clear">

		<div class="module">
			<div class="moduleT clear">
				<span class="left">新上传课件</span><a class="right"
					href="jspf/resList.jsp">> 更多</a>
			</div>

			<div id="reslistTable"></div>


		</div>

	</div>

	<!-- 底部 -->
	<div id="footer" class="gray tc f12 mt20">
		© 2015 无锡市安艾艾迪服务外包培训学校 版权所有 All rights reserved. <br />

	</div>

	<!-- 代码 开始 -->

	<!-- 代码 结束 -->
</body>
</html>
