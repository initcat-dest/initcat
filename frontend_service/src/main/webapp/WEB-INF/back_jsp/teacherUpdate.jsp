<%@page import="com.initcat.view.old.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getServletContext().getContextPath() + "/"%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
<script type="text/javascript">
	function addContentLeft() {
		$("#contentLeft").load("addContentLeft?o=" + new Date().getTime());
	}

	function addTop() {
		$("#backTop").load("/Team3_ZXJY/jspb/BackTop.jsp");
	}
	window.onload = function() {
		addTop();
		addContentLeft();
	}
</script>
<body>

	<!-- / 顶部 / -->
	<div id="backTop" class="clear"></div>

	<!-- 容器 -->
	<div id="container" class="clear mb01"></div>

	<!-- 左侧列表 -->
	<div id="contentLeft" class="sidew"></div>

	<%
		//验证是否传递了用户信息过来
		Object editorObj = request.getAttribute("upteacher");
		if (editorObj == null) {
			response.sendRedirect("jspb/teacherlist.jsp");
			return;
		}
		//如果传递了编辑的用户
		Teacher tea = (Teacher) editorObj;//取出要编辑的用户对象
		//从request中取出错误信息
		Object error = request.getAttribute("error");
		if (error != null) {
	%>
	<span style='color: red'><%=error%></span>
	<%
		}
	%>
	<!-- 内容 -->
	<div id="mainContent">
		<!-- 正文内容 -->
		<div id="content">
			<!-- / 当前位置 / -->
			<div class="location clear f12">
				您的目前页面：<a href="/Team3_ZXJY/jspb/index.jsp">后台管理首页</a> > 修改教师信息
			</div>
			<!-- 单位管理-部门管理 -->
			<div class="informationcx f14">
				<div class="title f16">
					<div class="titletext">修改教师信息</div>
				</div>
				<div class="mt">
					<form action="/Team3_ZXJY/editTeacher">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="table">
							<tr>
								<td width="130" align="right" valign="middle">教师姓名：</td>
								<td><input class="text01" type="text" name="teaName"
									id="teaName" value="<%=tea.getTeaName()%>" /></td>
							</tr>
							<tr>
								<td align="right" valign="middle">教师工号：</td>
								<td><input name="teaNo" type="text" class="text01"
									id="teaNo" value="<%=tea.getTeaNo()%>" /></td>
							</tr>
							<tr>

								<td><input name="teaId" type="hidden" class="text01"
									id="teaId" value="<%=tea.getTeaId()%>" /></td>
							</tr>
							<tr>
								<td align="right" valign="middle">所属部门：</td>
								<td><select class="select" name="teaGroup" id="teaGroup">
										<option>教学部</option>
										<option>就业部</option>
										<option>市场部</option>
								</select></td>
							</tr>
							<tr>
								<td align="right" valign="middle">性别：</td>
								<td><input class="radio" type="radio" name="teaSex"
									id="teaSex" value="1" /> 男&nbsp;&nbsp;&nbsp;&nbsp;<input
									type="radio" name="teaSex" id="radio" value="2" /> 女</td>
							</tr>
							<tr>
								<td align="right" valign="middle">头像：</td>
								<td valign="middle"><input class="text01 left mr mt02"
									type="file" name="teaHead" id="teaHead" />
								<div class="left mr mt02">
										<input class="button" type="submit" name="button" id="button"
											value="上传图片" />
									</div>
									<div class="left addimg border">
										<img src="bimages/txpic.png" width="100" height="100" /><a
											href="#">删除</a>
									</div></td>
							</tr>
							<tr>

								<td><input name="teaPwd" type="hidden" class="text01"
									id="teaPwd" value="<%=tea.getTeaPwd()%>" /></td>
							</tr>
							<tr>
								<td><div class="button_box">

										<input class="submit" type="submit" name="button" id="button"
											value="提 交" />&nbsp;&nbsp;&nbsp;</td>
								<td><input class="cancle" id="input" name="input"
									value="重 置" type="reset" />
								</div></td>
							</tr>
						</table>
					</form>

				</div>
			</div>

		</div>
	</div>
	</div>

	<!-- 底部 -->
	<div id="foot">
		主办单位：江苏省教育评估院 地址：江苏省南京市北京西路15号 邮政编码：210024 电话：025-83335264
		传真：025-83335267<br /> 总访问量：218026 技术支持：常州大学
	</div>
</body>
</html>