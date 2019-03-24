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
		$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeContentLeft.jsp");
	}
	
	window.onload=function(){
		addForeTop();
		addForeContentLeft();
	}
</script>
</head>

<body>

	<!-- 头部 -->
	<div id="foreTop"></div>
	
		
	<!-- 当前位置 -->
	<div id="location">
		<div class="wrapper margin">
			您的目前页面：<a href="#">首页</a> > <a href="#">网站公告</a>
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
						<td width="190" align="left"><input name="textfield2"
							type="text" class="text02" id="textfield2" value="新闻 资讯 活动 大赛" /></td>
						<td align="right">发布时间：</td>
						<td width="170" align="left"><input name="textfield2"
							type="text" class="text02" id="textfield2" value="新闻 资讯 活动 大赛" /></td>
						<td width="80" align="right"><input class="button"
							type="submit" name="button" id="button" value="查&nbsp;询" /></td>
					</tr>
				</table>
			</div>

			<div class="applybutton mt clear">
				<a href="合作企业添加.html">添 加</a> <a href="合作企业添加.html">修 改</a> <a
					href="#">删 除</a>
			</div>
			<!-- 通知公告 -->
			<div class="tablelist margin">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th><input name="" type="checkbox" value=""
								checked="checked" /></th>
							<th>标题</th>
							<th>发布人</th>
							<th>发布时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td align="center">题标题标题标题</td>
							<td align="center">admin</td>
							<td align="center">2014-04-24 12:00:00</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>
						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td align="center">题标题标题标题</td>
							<td align="center">admin</td>
							<td align="center">2014-04-24 12:00:00</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>
						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td align="center">题标题标题标题</td>
							<td align="center">admin</td>
							<td align="center">2014-04-24 12:00:00</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>
						<tr>
							<td><input name="" type="checkbox" value="" /></td>
							<td align="center">题标题标题标题</td>
							<td align="center">admin</td>
							<td align="center">2014-04-24 12:00:00</td>
							<td><a href="#" class="tablelink">查看</a> <a href="#"
								class="tablelink">删除</a></td>
						</tr>
					</tbody>
				</table>
				<!-----------分页----------->
				<div class="paginationBox clear margin mt20">
					<span><a href="#" title="上一页">上一页</a></span> <span><a
						href="#" title="1" class="active">1</a></span> <span><a href="#"
						title="2">2</a></span> <span><a href="#" title="3">3</a></span> <span><a
						href="#" title="4">4</a></span> <span><a href="#" title="5">5</a></span>
					<span><a href="#" title="6">6</a></span> <span><a href="#"
						title="7">7</a></span> <span><a href="#" title="8">8</a></span> <span><a
						href="#" title="下一页">下一页</a></span>
				</div>
			</div>
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
