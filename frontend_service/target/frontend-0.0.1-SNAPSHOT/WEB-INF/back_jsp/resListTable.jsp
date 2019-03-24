<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tablelist f14" style="width: 100%;">
		<thead>
			<tr>
				<th width="149"><input onclick="checkAll(this)" name=""
					type="checkbox" value="" /></th>
				<th width="149">资源名</th>
				<th width="101">资源分类</th>
				<th width="119">发布时间</th>
				<th width="136">上传教师</th>
				<th>下载</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list.data }" var="r">
				<tr>
					<th width="149"><input name="resId" type="checkbox"
						value="${r.resId }" /></th>
					<th width="149">${r.resTitle }</th>
					<th width="101">${r.resType }</th>
					<th width="119">${r.resTime }</th>
					<th width="136">${r.resTeaId }</th>
					<th><a href="downloadRes?resId=${r.resId }">下载</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!---分页----->
	<div class="paginationBox clear  mt20">
		<span><a href="javascript:doSub(${list.pageNum-1 })" title="上一页">上一页</a></span> <span><a
			href="javascript:doSub(${list.pageNum+1 })" title="下一页">下一页</a></span>
	</div>
</body>
</html>