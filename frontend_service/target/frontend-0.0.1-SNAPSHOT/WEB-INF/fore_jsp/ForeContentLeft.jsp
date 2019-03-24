<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>

</head>
<body>

<div id="sidebar" class="sidew">
   <ul class="accordion">
    <li><i></i><a href="#">学校公告</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspf/fAnnounceList.jsp">所有公告></a></li>
      <li><a href="/Team3_ZXJY/jspf/fAddAnnounce.jsp">发公告></a></li>
     </ul>
    </li>
     <li><a href="#">消息管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspf/MessageSave.jsp">发消息></a></li>
      <li><a href="/Team3_ZXJY/jspf/MessageList.jsp">消息列表></a></li>
     </ul>
    </li>
    <li><a href="#">课件管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspf/addResource.jsp">发课件></a></li>
      <li><a href="/Team3_ZXJY/jspf/resList.jsp">课件列表></a></li>
     </ul>	
    </li>
 	<li><a href="#">作业管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspf/addHomework.jsp">发作业></a></li>
      <li><a href="/Team3_ZXJY/jspf/workList.jsp">作业列表></a></li>
     </ul>
    </li>
    <li><a href="#">问卷调查</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspf/ReleaseNaire.jsp">发问卷调查></a></li>
      <li><a href="/Team3_ZXJY/jspf/releaseList.jsp">问卷调查列表></a></li>
     </ul>
    </li>
     <li><a href="#">学生管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/jspf/tea_studentList.jsp">学生列表></a></li>
      <li><a href="/Team3_ZXJY/jspf/Tea_AddStudent.jsp">添加新学生></a></li>
      
     </ul>
    </li>
     <li><a href="#">系统管理</a>
     <ul class="sub-menu">
      <li><a href="/Team3_ZXJY/equalpwd">修改密码></a></li>
      <li><a href="/Team3_ZXJY/teacherChange">修改个人信息></a></li>
     </ul>
    </li>
   </ul>
  
</div>

</body>
</html>