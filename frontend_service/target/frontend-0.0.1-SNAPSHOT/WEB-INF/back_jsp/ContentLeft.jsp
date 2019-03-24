<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
<body>

<div id="sidebar" class="sidew">
   <ul class="accordion">
   <!--
    <li><i></i><a href="#">权限管理</a>
     <ul class="sub-menu">
      <li><a href="#">增加权限></a></li>
      <li><a href="#">限制权限></a></li>
     </ul>
    </li>
    -->
     <li><a href="#">公告管理</a>
     <ul class="sub-menu">
     	<li><a href="/Team3_ZXJY/jspb/addAnnounce.jsp">发布公告></a></li>
      	<li><a href="/Team3_ZXJY/jspb/announceList.jsp">公告管理></a></li>
     </ul>
    </li>
    <li><a href="#">教师信息管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspb/addTeacher.jsp">添加教师></a></li>
      <li><a href="/Team3_ZXJY/jspb/teacherlist.jsp">教师管理></a></li>
     </ul>
    </li>
 	<li><a href="#">学生信息管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspb/addStudent.jsp">添加学生></a></li>
      <li><a href="/Team3_ZXJY/jspb/studentList.jsp">学生管理></a></li>
     </ul>
    </li>
     <li><a href="#">课件资源管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspb/addResource.jsp">添加课件></a></li>
      <li><a href="/Team3_ZXJY/jspb/resourceList.jsp">删除课件></a></li>
     </ul>
    </li>
    <!-- 
     <li><a href="#">论坛管理</a>
     <ul class="sub-menu">
      <li><a href="#">主题管理></a></li>
      <li><a href="#">会员管理></a></li>
      <li><a href="#">论坛分类管理></a></li>
     </ul>
    </li>
     -->
   </ul>
  </div>

</body>
</html>





