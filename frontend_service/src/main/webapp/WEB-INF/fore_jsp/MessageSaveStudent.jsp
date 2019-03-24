<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeStudentContent.jsp");
}
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
  <div class="wrapper margin">您的目前页面：<a href="jspf/">首页</a> > <a href="#">添加消息</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="foreContentLeft" class="sidew">
   
  </div>
   <!-- 正文右侧 -->
  <div class="right conright">
     
     <form action="/Team3_ZXJY/MessageSaveServlet" method="get" >
     <div class="mt">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        <tr>
          <td width="142" align="right" valign="middle">消息标题</td>
          <td width="1210"><input class="text01" type="text" name="mssTitle" id="textfield" />&nbsp;&nbsp;<span class="red">标题不能超过30个字符</span></td>
        </tr>
         <tr>
          <td width="142" align="right" valign="middle">消息发布人</td>
          <td><input class="text01" type="text" name="mssPeople" id="textfield" />&nbsp;&nbsp;<span class="red">不能超过30个字符</span></td>
        </tr>
         
        <tr>
          <td align="right" valign="top">内容</td>
          <td>
          	<textarea class="textarea" name="mssContent" id="textarea" cols="45" rows="5" placeholder="全文不超过500字符"></textarea>	
          	<script type="text/javascript">CKEDITOR.replace('newsContent',{ height: '180px', width: '800px' });</script>
          </td>
        </tr>
       
      </table>
      <div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="确 定" />&nbsp;&nbsp;&nbsp;
           <a href="jspf/MessageList.jsp"> <input class="cancle" id="input" name="input" value="取 消" type="button" /></a>
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
