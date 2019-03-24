<%@page import="com.initcat.view.old.entity.Resource"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
<body>
<script type="text/javascript">
function addContentLeft(){
	$("#contentLeft").load("addContentLeft?o="+new Date().getTime());
}

function addTop(){
	$("#backTop").load("/Team3_ZXJY/jspb/BackTop.jsp");
}

function doSub(pageNum) {
	$("#listTable").load("/Team3_ZXJY/studentList?o="+new Date().getTime(), 
			{
		stuname : $("#cstuname").val(),
		stuno : $("#cstuno").val(),
		pageNum:pageNum
	},function(){
		f1();}
	);
}
function f1(){
	var a=$('[yangshi]');
	for(var s=0;s<a.length;s++){
		if($(a[s]).attr("title") != null&&$(a[s]).attr("title")==$("#pageNum").val()){
			$(a[s]).addClass("active");
		}
	};
}
window.onload=function(){
	doSub(1);
	addTop();
	addContentLeft();
}


</script>
 <!-- / 顶部 / -->
 <div id="backTop" class="clear"></div>
  
 
 <!-- 容器 -->
 <div id="incontainer" class="clear mb01">
 
  <!-- 左侧列表 -->
  <div id="contentLeft" class="sidew"></div>
  
  <!-- 内容 -->
  <div id="mainContent">
   <!-- 正文内容 -->
   <div id="content">
      <!-- / 当前位置 / -->
 <div class="location clear f12">您的目前页面：<a >学生管理</a>  学生列表</div>
   <div class="yjb mt ">
     	<div class="conSearch ">
        <div class="iptSearch background mb f12">
        <input type="text" id="cstuname" name="cstuname" value="姓名" />
        <input id="cstuno" name="cstuno" type="text" value="学号" />
        <input type="button" onclick="doSub()" value="搜索" class="btn" style="background:#ff7700;"/>
      </div>
         </div>
        
        <div id="listTable"></div>                          
         
      </div>
    
   </div>
  </div>
 </div>
 
 <!-- 底部 -->
 <div id="foot">主办单位：江苏省教育评估院  地址：江苏省南京市北京西路15号  邮政编码：210024  电话：025-83335264  传真：025-83335267<br />
总访问量：218026  技术支持：常州大学</div>
</body>
</html>




