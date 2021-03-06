<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</head>
<body>

	<div class="tablelist margin">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<thead>
			<tr>
				<th>资源名</th>
				<th>资源分类</th>
				<th>发布时间</th>
				<th>上传教师</th>
			</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${list.data }" var="r">
				<tr>
					<th align="center">${r.resTitle }</th>
					<th align="center">${r.resType }</th>
					<th align="center">${r.resTime }</th>
					<th align="center">${r.teaName }</th>
				</tr>
			</c:forEach>
				
				
			</tbody>
		</table>
		<!-----------分页----------->
	
	</div>

</body>
</html>