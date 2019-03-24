<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.initcat.view.old.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回密码</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">

<style>
.input {
	border: 2px #0C635A solid;
	width: 210px;
	hight: 40px
}

.hehe {
	border: 2px #0C635A solid;
	width: 80px;
	background-color: #0C635A;
	font-size: 16px;
	color: #eee
}
</style>
</head>

<body>

	<div id="head">

		<!-- 头部 -->
		<div class="wrapper clear margin height">
			<div class="logo left">
				
				<a href="#"> <img src="images/logo.png" /> <span>发现密码</span>
					<p>NIIT Online Teaching BBS</p>
				</a>
			</div>
		</div>
	</div><%
	
	User u = (User)request.getAttribute("users");
				%>
	<div style="margin-left: 300px;">
		<table style="border: 2px solid #0C635A; width: 362px">
			<tr>
				<td>密码在这里:<%=u.getPassword()%></td>
				<td><a href="/Team3_ZXJY/jspf/UserLogin.jsp">回主页</a> </td>
			</tr>




		</table>
	</div>

</body>
</html>
