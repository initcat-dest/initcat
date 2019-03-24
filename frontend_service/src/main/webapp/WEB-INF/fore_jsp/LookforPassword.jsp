<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回密码</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">

<style>
.input{border:2px #0C635A solid;width:210px;hight:40px}
.hehe{border:2px #0C635A solid;width:80px;background-color:#0C635A;font-size:16px;color:#eee  }
</style>
</head>

<body>
<form action="/Team3_ZXJY/LookforPasswordServlet" method="get">
 <div id="head">
 
  <!-- 头部 -->
  <div class="wrapper clear margin height">
   <div class="logo left">
    <a href="#">
     <img src="images/logo.png" />
     <span>用户找回密码</span>
     <p>NIIT Online Teaching BBS</p>
    </a>
   </div>
  </div>
 </div>
 
<div style="margin-left:300px;"><table style="border:2px solid #0C635A; width:332px" >
<tr><td>用户提示问题</td><td><input type="text" name="UserQuestion" class="input"></td></tr>
<tr><td>请输入用户编码</td><td><input type="text" name="UserNumber" class="input"></td></tr>

<tr style="display:none"><td>找回的密码</td><td><input type="text" name="UserPassword" class="input" value="password"></td></tr>
<tr><td colspan="2" style="text-align:center;background-color:#0C635A "><input type="submit" value="找回" class="hehe"><input type="reset" value="重置" class="hehe"></td></tr>
</table></div>

</form></body></html> 
