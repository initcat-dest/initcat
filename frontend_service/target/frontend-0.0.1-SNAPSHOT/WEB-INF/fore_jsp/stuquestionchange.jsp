<%@page import="com.initcat.view.old.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>

</head>
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
<body>

<%
		//验证是否传递了用户信息过来
		Object editorObj = request.getAttribute("que");
		if (editorObj == null) {
			response.sendRedirect("/Team3_ZXJY/jspf/studentSystemIndex.jsp");
			return;
		}
		//如果传递了编辑的用户
		Question que = (Question) editorObj;//取出要编辑的用户对象
		//从request中取出错误信息
		Object error = request.getAttribute("error");
		if (error != null) {
	%>
	<span style='color: red'><%=error%></span>
	<%
		}
	%>
 <div id="head">
  <!-- 头部 -->
 </div>
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a>首页</a> > <a>网站公告</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 学生菜单 -->
  <div id="contentLeft"></div>
   <!-- 正文右侧 -->
  <div class="right conright">
  <form action="changeQuestion" method="get">
 		<div class=" border">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        <tr>
          <td width="70" align="right" valign="middle">问题标题</td>
          <td><input class="text01" name="title" type="text" value="<%=que.getQueTitle()%>"/></td>
        </tr>
         <tr>
          <td align="right" valign="middle">问题分类</td>
          <td><select class="select" name="Quetype" id="select">
            <option>JAVA</option>
            <option>ANDROID</option>
            <option>IOS</option>
          </select></td>
        </tr>
        
         <tr>
          <td align="right" valign="middle">上传附件</td>
          <td valign="middle"><div class="left mr mt02"><input class="button" type="file"  value="上传图片" /></div>
        </tr>
        <tr>
       <td>请选择教师：</td>
       <td>
       <select class="select" name="teacherName" id="select">
       <c:forEach items="${teaList}" var="tea">
      	 <option value="${tea.teaId}">${tea.teaName}</option>
      	 </c:forEach>
       </select>
       </td>
       </tr>
        <tr>
          <td align="right" valign="top">问题描述</td>
          <td><textarea  class="textarea" name="detail" id="textarea" cols="45" rows="5"  ><%=que.getQueContent() %></textarea></td>
        </tr>
       
      </table>
      <div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="确 定" />&nbsp;&nbsp;&nbsp;
            <input class="cancle" id="input" name="input" value="取 消" type="submit" />
           </div>
   </div>
  </form>
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
