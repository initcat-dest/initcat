<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

  <!-- 头部 -->
<div id="head">

  <div class="wrapper clear margin height">
   <div class="logo left">
    <a>
     <img src="images/logo.png" />
     <span>尚学在线教学系统</span>
     <p>Online Teaching System</p>
    </a>
   </div>
   <div class="headR tr mt right">
    <div class="headRset f14 clear">
     <a href="#" title="修改密码" class="h_r03">&nbsp;</a><a href="#" title="信息" class="h_r02">&nbsp;</a>
     <a href="#">退出</a>
     
     	<span class="right">${loginUser.name }，欢迎您！</span>
     
    </div>
    <div class="headRfast f12 clear">
     <a href="javascript:(0)" title="建言献策" class="h_f03">建言献策</a>
     <a href="javascript:(0)" title="网站公告" class="h_f01">网站公告</a>
    </div>
   </div>
  </div>

 </div>

</body>
</html>