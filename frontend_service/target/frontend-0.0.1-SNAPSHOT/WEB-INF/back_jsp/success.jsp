<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">

<meta http-equiv="Content-Type" content="btext/html; charset=utf-8" />
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
<script type="text/javascript">
	
	function addContentLeft(){
		$("#contentLeft").load("addContentLeft?o="+new Date().getTime());
	}
	
	function addTop(){
		$("#backTop").load("/Team3_ZXJY/jspb/BackTop.jsp");
	}
	
	window.onload=function(){
		addTop();
		addContentLeft();
	}
</script>
<body>

 <!-- / 顶部 / -->
 <div id="backTop" ></div>
 
 <!-- 容器 -->
 <div id="incontainer" class="clear mb01">
 
  <!-- 左侧列表 -->
  <div id="contentLeft" ></div>
   
  <!-- 内容 -->
  <div id="mainContent">
   <!-- 正文内容 -->
   <div id="content">
      <!-- / 当前位置 / -->
 <div class="location clear f12">您的目前页面：<a >后台管理首页</a> </div>
    <!-- 欢迎 -->
    <div class="inwelcome"  style='height:100%;width:100%; background-image:url(images/welcome.png) '>
     欢迎使用！<br/>
    <c:if test="${s==1}">
    添加成功<br/>
    点击跳转<a href='/Team3_ZXJY/jspb/studentList.jsp'>学生列表</a>
    </c:if>
     <c:if test="${s!=1}">
    添加失败<br/>
    点击返回<a href='/Team3_ZXJY/jspb/addStudent.jsp'>添加学生</a>
    </c:if>
    </div>
       
   </div>
  </div>
 </div>
 
 <!-- 底部 -->
 <div id="foot">主办单位：江苏省教育评估院  地址：江苏省南京市北京西路15号  邮政编码：210024  电话：025-83335264  传真：025-83335267<br />
总访问量：218026  技术支持：常州大学</div>
</body>
</html>
