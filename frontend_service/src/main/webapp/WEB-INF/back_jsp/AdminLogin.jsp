<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登陆</title>
<style>#ts{display:none}</style>

<script type="text/javascript" src="js/jquery.js"></script>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/login.css">
</head>
  
<body>
<form action="/Team3_ZXJY/AdminServlet" method="post">
 <table style="height:100%;width:100%;margin-top:130px;">
<tbody><tr><td>
<div class="login_page" style="position: relative;">
 
 <!-- banner -->
 <div id="content" class="wrapperlogin margin relative">
  <div class="logincontent">
   <div class="relative loginconbg">
    <div class="logo clear">
     <img class="left" src="bimages/logo.png" width="350" height="58" />
    </div>
    <div class="loginbox">
     <div class="ltitle tc"><span class="title">管理员登录</span><span class="titleEng">UserLogin</span></div>
     
     
     <div class="orange01 f12 tc lh23" id="ts" style="display:<%=request.getAttribute("error") %>">
     	<c:choose>
	     	<c:when test="${TiShi== null }">
	     		用户名或者密码错误
	     	</c:when>
	     	<c:otherwise>
	     		${TiShi }
	     	</c:otherwise>
     	</c:choose>
     </div>
     <div class="ltext tc">
      <div class="Linput"><input type="text" name="loginName" class="input name" placeholder="请输入用户名" /></div>
      <div class="Linput"><input type="password" name="loginPass" class="input password" placeholder="请输入密码" /></div>
      <div class="Linput clear"><input type="text" id='code' name="code" class="input yzm left mr" style="width:120px; margin-left:40px"  placeholder="请输入验证码"/>
      <script type="text/javascript">
							//通过jquery的AJAX验证验证是否正确
							$("#code").blur(function(){
								$.post("checkCode",{code:$("#code").val()},function(result){
									if(result==0){
										alert("验证码输入错误");
									}
								});
							});

						//刷新验证码
						function flushCode(){
							$("#codei").attr('src','code?f='+new Date().getTime());
						}
					</script>
      
      <img id='codei' src='code'  onclick="flushCode()"/>
      	 </div>
      <div class="Linput"><input class="button white f22" name="" type="submit" value="登 录" style="height:40px;width:230px"/><a href="/Team3_ZXJY/jspb/AdminSave.jsp">注册</a></div>
     </div>
    </div>
   </div>
  </div>
  <!-- 底部 -->
  <div id="infoot" class="tc">主办单位:无锡NIIT软件外包培训学校  地址：江苏省无锡市国家软件园巨蟹座  <br />Copyright © NIIT.com All Right Reserved 2015</div>
 </div>
 
</div>
</td></tr></tbody></table></form>
</body>
</html>
