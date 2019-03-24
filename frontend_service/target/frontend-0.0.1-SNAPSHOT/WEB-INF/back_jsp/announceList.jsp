<%@page import="com.initcat.view.old.entity.Announce"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
	
	function checkAll(checkbox) {
		if (checkbox.checked) {
			$('input[type=checkbox]').attr('checked', true);
		} else {
			$('input[type=checkbox]').attr('checked', false);
		}
	}
	function delAnn() {
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
			$("#listTable").load("delAnnounce?"+params);
			// location.href = url;
		}
	}
	function addAnn() {
		location.href = "/Team3_ZXJY/jspb/addAnnounce.jsp";
	}
	function queryList() {
		var nName = $("#nickName").val();
		var url = "/Team3_ZXJY/queryAnnounceList?nickName=" + nName;
		location.href = url;
	}
	function doSub(pageNum) {
		//alert(pageNum);
		//同一个URL不会重新加载
		$("#listTable").load("announceList?o=" + new Date().getTime(), {
			nickName : $("#nickName").val(),
			pageNum : pageNum
		});
	}
	
	window.onload = function() {
		addTop();
		addContentLeft();
		doSub(1);
	}
</script>
<body>
	<!-- / 顶部 / -->
	<div id="backTop"></div>
	
	<!-- 容器 -->
	<div id="incontainer" class="clear mb01">
	
		<!-- 左侧列表 -->
		<div id="contentLeft"></div>
		
		<!-- 内容 -->
		<div id="mainContent">
			<!-- 正文内容 -->
			<div id="content">
				<!-- / 当前位置 / -->
				<div class="location clear f12">
					您的目前页面：<a >后台管理</a>> 公告列表
				</div>
				<div class="yjb mt ">
					<div class="conSearch ">
						<div class="iptSearch background mb f12">
							标题：<input type="text" class="select" id="nickName" />
								<input type="button" value="搜索" class="btn" style="background: #ff7700;" onclick="doSub()" /> 
						</div>
						<div class="btnSearch ">
							<input type="button" value="增加" class="btn" onclick="addAnn()" />
							<input type="button" value="删除" class="btn" onclick="delAnn()" />
						</div>
					</div>
					<!---表格--->
					<div id="listTable"></div>
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
