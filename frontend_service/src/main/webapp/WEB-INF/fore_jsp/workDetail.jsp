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
  <div class="wrapper margin">您的目前页面：<a>作业管理</a> > <a>作业列表</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="foreContentLeft"></div>
  

   <!-- 正文右侧 -->
  	<div class="tablelist margin">
		<div style="background-color:#ccc;width:30px;margin-left:200px;border:1px solid #0c635a;">
			<a href="/Team3_ZXJY/jspf/workList.jsp" class="tablelink">返回</a>
		</div>
	    <table width="70%" border="0" cellspacing="0" cellpadding="0">
	    	<thead></thead>
	    	<tbody>
	    	 
	    	<tr>
	            <td>标题</td>
	            <td align="center">${h.workTitle }</td>
	        </tr>
	        <tr>
	            <td>类别</td>
	             <td align="center">${h.workType }</td>
	         </tr>
	        <tr>
	            <td>发布人</td>
	            <td align="center">${h.teaId }</td>
	         </tr>
	        <tr>
	            <td>发布时间</td>
	            <td align="center">${h.publishTime }</td>
	         </tr>
	        <tr>
	            <td>内容</td>
	            <td align="center">${h.workDescript }</td>
	        </tr>
	      </tbody>
	    </table>
  	</div>
  
  
  
  
 </div>

 <!-- 底部 -->
 <div id="footer" class="gray tc f12 mt20">
  © 2014  © 2015 无锡市安艾艾迪服务外包培训学校 版权所有 All rights reserved.<br />


 </div>
 
  <!-- 代码 开始 -->

<!-- 代码 结束 -->
</body>
</html>








