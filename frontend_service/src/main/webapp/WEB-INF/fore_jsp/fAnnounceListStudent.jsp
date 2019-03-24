<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>

<script>
	function addForeTop(){
		$("#foreTop").load("/Team3_ZXJY/jspf/ForeTop.jsp");
	}

	function addForeContentLeft(){
		$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeStudentContent.jsp");
	}
	function doSub(pageNum) {
		//alert(pageNum);
		//同一个URL不会重新加载
		$("#listTable").load("fAnnounceList?o=" + new Date().getTime(), {
			nickName : $("#nickName").val(),
			pageNum : pageNum
		});
	}
	
	window.onload=function(){
		addForeTop();
	 	addForeContentLeft();
	 	doSub(1);
	}
	function checkAll(checkbox){
		if(checkbox.checked){
			$('input[type=checkbox]').attr('checked',true);
		}else{
			$('input[type=checkbox]').attr('checked',false);
		}
	}
	function del(){
		//获取选中公告的编号
		var cks = $(":checked");
		if (cks.length == 0) {
			return;
		}
		var params = "o=x";
		for (var i = 0; i < cks.length; i++) {
			if ($(cks[i]).attr("type") == 'checkbox' && $(cks[i]).attr("name") == 'annId') {
				params += "&annIds=" + $(cks[i]).val();
			}
		};
		//var url = "/Team3_ZXJY/delAnnounce?" + params;
		if (confirm("您确定删除所选公告吗?")) {
			$("#listTable").load("fDelAnnounce?"+params);
			// location.href = url;
		}
	}
</script>
</head>

<body>

	<!-- 头部 -->
	<div id="foreTop"></div>
		
	<!-- 当前位置 -->
	<div id="location">
		<div class="wrapper margin">
			您的目前页面：<a >首页</a> > <a href="/Team3_ZXJY/jspf/fAnnounceList.jsp">网站公告</a>
		</div>
	</div>

	<div class="wrapper margin clear" style="margin-top: 20px;">

		<!-- 正文左侧 -->
		<div id="foreContentLeft"></div>
		
		 <!-- 正文右侧 -->
		<div class="right conright">
		<div class="search">
			<table border="0" cellpadding="0" cellspacing="0" class="table01">
				<tr>
					<td align="right">标题：</td>
					<td width="190" align="left">
						<input name="nickName" type="text" class="text02" id="nickName"  />
					</td>
					<td width="80" align="right">
						<input class="button" type="button" name="button" id="button" value="查&nbsp;询" onclick="doSub()"/>
					</td>
				</tr>
			</table>
		</div>

		
		<div id="listTable" class="tablelist margin"></div>
	</div>
	</div>

	<!-- 底部 -->
	<div id="footer" class="gray tc f12 mt20">
		© 2014 © 2015 无锡市安艾艾迪服务外包培训学校 版权所有 All rights reserved.<br />
	</div>

	<!-- 代码 开始 -->

	<!-- 代码 结束 -->
</body>
</html>
