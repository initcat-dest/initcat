<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.initcat.view.old.entity.Message"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<script>
function addForeTop(){
	$("#foreTop").load("/Team3_ZXJY/jspf/ForeTop.jsp");
}

function addForeContentLeft(){
	$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeContentLeft.jsp");}
	window.onload=function(){
		addForeTop();
		addForeContentLeft();
	}
</script>
</head>

<body>

 
 
  <!-- 头部 -->
  <div  id="foreTop"></div>
   
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a href="#">首页</a> > <a href="#">消息更改</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="foreContentLeft" class="sidew">
   
  </div>
   <!-- 正文右侧 -->
  <div class="right conright">
 		
    <!-- / 当前位置 / -->
 
   <% Message ms=(Message)request.getAttribute("mes");%>
      <div class="titletext">添加消息</div>
  
   <form action="/Team3_ZXJY/MessageChangeServlet"  method="get">
     <input type="hidden" name="hehe" value="<%=ms.getMesId() %>">
     <div class="mt">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        <tr>
          <td width="142" align="right" valign="middle">消息标题</td>
          <td width="1210"><input class="text01" type="text" name="mssTitle" id="textfield" value="<%=ms.getMesTitle() %>"/></td>
        </tr>
         <tr>
          <td width="142" align="right" valign="middle">消息发布人</td>
          <td><input class="text01" type="text" name="mssPeople" id="textfield" value="<%=ms.getUserId() %>"/></td>
        </tr>
         
        <tr>
          <td align="right" valign="top">内容</td>
          <td>
          	<textarea class="textarea" name="mssContent" id="textarea" cols="45" rows="5" placeholder="全文不超过500字符" ><%=ms.getMesContent() %></textarea>	
          	<script type="text/javascript">CKEDITOR.replace('newsContent',{ height: '180px', width: '800px' });</script>
          </td>
          
        </tr>
       
      </table>
      <div class="button_box">
	        <a href="/Team3_ZXJY/jspf/MessageList.jsp"><input class="submit" type="button" name="button" id="button" value="返回列表" /></a>&nbsp;&nbsp;&nbsp; <input class="submit" type="submit" name="button" id="button" value="确定修改" />
           
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