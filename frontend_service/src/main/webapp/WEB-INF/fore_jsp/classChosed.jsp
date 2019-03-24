<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>已选课程</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
<script type="text/javascript">
function addContentLeft() {
	$("#contentLeft").load("/Team3_ZXJY/jspf/ForeStudentContent.jsp");
}

function addTop() {
	$("#head").load("/Team3_ZXJY/jspf/ForeTop.jsp");
}
window.onload = function() {
	addTop();
	addContentLeft();
}
</script>
</head>

<body>

 <body>

 <div id="head">


 

 </div>
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：已选课程<a href="#">首页</a>  <a href="#">网站公告</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 学生菜单 -->
  <div id="contentLeft" style="float: left;">
 
 </div>  <!-- 正文右侧 -->
 
	<div id="list" style="width: 800px;float: left;"">
	 <table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<tr>
            <th>姓名</th>
            <th>已选课程</th>
            <th>任课老师</th>
            <th>开课时间</th>
            <th>操作</th>
            
        </tr>
       <tr >
     <td align="center">${stu.stuName}</td>
     
    <c:if test="${xk.subId==1}">
    <td align="center">JAVA</td></c:if> 
    <c:if test="${xk.subId==2}">
    <td align="center">ANDROID</td></c:if> 
    <c:if test="${xk.subId==3}">
    <td align="center">IOS</td></c:if> 
     <td align="center">${tea.teaName}</td>
     <td align="center">${sub.date}</td>
      <td align="center">
        <a href="/Team3_ZXJY/jspf/studentChoseClass.jsp" class="">重新选课</a>
      </td>
      </tr>
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
