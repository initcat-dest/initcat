<%@page import="com.initcat.view.old.entity.Announce"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletContext().getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
</head>
<!---表格--->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th><input name="" type="checkbox" value=""  onclick='checkAll(this)'/></th>
			<th>标题</th>
			<th>发布人</th>
			<th>发布时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ans.data }" var="an">
			<tr>
				<td align="center"><input name="annId" type="checkbox" value="${an.annId}" /></td>
				<td align="center">${an.annTitle}</td>
				<td align="center">${an.annPeople}</td>
			    <td align="center">${an.annTime}</td> 
				<td align="center">
					<a href="/Team3_ZXJY/fAnnounceText?annId=${an.annId}" class="tablelink">查看详情</a> 
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!---分页----->
	<div class="paginationBox clear  mt20">
		<c:if test="${ans.pageNum==1}">
			<span><a title="上一页">上一页</a></span>
		 </c:if>
		<c:if test="${ans.pageNum>1}">
			<span><a href="javascript:doSub(${ans.pageNum-1 })" title="上一页">上一页</a></span>
		 </c:if> 
		 <c:if test="${ans.pageNum<ans.maxPageNum}">
		<span><a href="javascript:doSub(${ans.pageNum+1 })" title="下一页">下一页</a></span>
		 </c:if>&nbsp;
		 <c:if test="${ans.pageNum==ans.maxPageNum}">
		<span><a title="下一页">下一页</a></span>
		 </c:if>&nbsp;
  	</div>
</body>
</html>
