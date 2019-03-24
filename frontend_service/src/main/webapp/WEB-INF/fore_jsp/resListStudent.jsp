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
		$("#foreTop").load("jspf/ForeTop.jsp");
	}

	function addForeContentLeft(){
		$("#foreContentLeft").load("jspf/ForeStudentContent.jsp");
	}
	
	function doSub(pageNum) {
		//alert(pageNum);
		//同一个URL不会重新加载
		$("#listTable").load("foreResList?o="+new Date().getTime(), {
			selectType : $("#selectType").val(),
			startdate  : $("#startdate").val(),
			selectDate : $("#user_date").val(),
			isWho : "stu",
			pageNum:pageNum
		});
	}
	
	window.onload=function(){
		addForeTop();
		addForeContentLeft();
		doSub(1);
	}
</script>
</head>

<body>

	<!-- 头部 -->
	<div id="foreTop"></div>
	
		
	<!-- 当前位置 -->
	<div id="location">
		<div class="wrapper margin">
			您的目前页面：<a>课件管理</a> > <a>课件列表</a>
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
						<td align="right">资源类别：</td>
						<td width="190" align="left">
						<select id="selectType" name=""  class="select">
	        				<option value=""></option>
	        				<option value="Java">Java</option>
	           				<option value="Android">Android</option>
	           				<option value="IOS">IOS</option>
        				</select></td>
						<td align="right">区间：</td>
						<td width="170" align="left"><input name="startdate" 
							type="date" class="text02" id="startdate" /></td>
						<td align="right">到：</td>
						<td width="170" align="left"><input name="user_date" 
							type="date" class="text02" id="user_date"  /></td>
							
						<td width="80" align="right"><input class="button"
							type="button" onclick="doSub()" name="button" id="button" value="查&nbsp;询" /></td>
						 	
					</tr>
				</table>
			</div>

			<script type="text/javascript">
            function checkAll(checkbox){
            	if(checkbox.checked){
            		$('input[type=checkbox]').attr('checked', true);
            	}else{
            		$('input[type=checkbox]').attr('checked', false);

            	}
            }
            
            </script>
			
			
			<!-- 列表 -->
			<div id="listTable"></div>
			
			
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
