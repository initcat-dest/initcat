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
	window.onload=function(){
		addForeTop();
	}
</script>
</head>

<body>

 <!-- / 顶部 / -->
 <div id="foreTop"></div>
 
  <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a >首页</a> > <a href="/Team3_ZXJY/jspf/fAnnounceList.jsp">网站公告</a> > 公告详情</div>
 </div>
 <div class="wrapper margin clear" style="margin-top:20px;">
 
  <!-- 通知公告 -->
  <div class="yulan border">
    <div class="yulanTitle">
     <h1>${an.annTitle }</h1>
     <p>部门：教务处 | 发布时间：${an.annTime }  | 发布人员：${an.annPeople } | 浏览人数: 386 |  【<a href="/Team3_ZXJY/jspf/fAnnounceList.jsp">关闭</a>】</p>
    </div>
    <div class="yulanText">
     <p>${an.annContent }</p>
    </div>
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
