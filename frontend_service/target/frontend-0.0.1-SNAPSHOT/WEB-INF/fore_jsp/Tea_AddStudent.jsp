<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
<script type="text/javascript">
function addContentLeft() {
	$("#contentLeft").load("/Team3_ZXJY/jspf/ForeContentLeft.jsp");
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

 <div id="head">
  <!-- 头部 -->
 </div>
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a href="#">首页</a> > <a href="#">网站公告</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="contentLeft" style="float: left" ></div>
 
   <!-- 正文右侧 -->
   <div style="float: left;">
   <form action="/Team3_ZXJY/tea_AddStudent" method="post" >
     <div class="mt">
    
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        <tr>
          <td width="130" align="right" valign="middle">学生姓名：</td>
          <td><input class="text01" type="text" name="stuName" id="textfield" />&nbsp;</td>
        </tr>
        <tr>
          <td width="130" align="right" valign="middle">学生学号：</td>
          <td><input class="text01" type="text" name="stuNo" id="textfield" />&nbsp;</td>
        </tr>
      <tr>
          <td align="right" valign="middle">选择课程</td>
          <td><select class="select" name="className" id="select">
            <option>JAVA</option>
            <option>ANDROID</option>
            <option>IOS</option>
          </select></td>
        </tr>
        <tr>
           <td width="130" align="right" valign="middle">学生描述：</td>
       <td> <textarea class='text01' name="detail" width="130" align="right" cols="40" rows="5" style='height: 50px'></textarea></td>
        </tr>
      </table>
      <div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="发 布" />&nbsp;&nbsp;&nbsp;
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
