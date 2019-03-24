<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员注册</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">

<style>
.input{border:2px #0C635A solid;width:194px;hight:40px}
.hehe{border:2px #0C635A solid;width:80px;background-color:#0C635A;font-size:16px;color:#eee  }
</style>
</head>

<body>
 <div id="head">
 
  <!-- 头部 -->
  <div class="wrapper clear margin height">
   <div class="logo left">
    <a href="#">
     <img src="images/logo.png" />
     <span>注册管理员信息</span>
     <p>NIIT Online Teaching BBS</p>
    </a>
   </div>
  </div>
 </div>
 <form action="/Team3_ZXJY/AdminSaveServlet" method="get">
<div style="margin-left:380px;width:580px;"><table style="border:2px solid #0C635A; width:282px" >

<tr><td>管理员姓名</td><td><input type="text" name="UserName" class="input"></td></tr>
<tr><td>管理员密码</td><td><input type="password" name="UserPassword" class="input"></td></tr>
<tr><td>管理员类别</td><td><input type="text" name="UserType" class="input"></td></tr>


<tr><td colspan="2" style="text-align:center;background-color:#0C635A "><input type="submit" value="注册" class="hehe"><input type="reset" value="重置" class="hehe"></td></tr>
</table></div>

</form></body></html>
