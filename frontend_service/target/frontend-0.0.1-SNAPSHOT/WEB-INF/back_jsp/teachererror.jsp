<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="btext/html; charset=utf-8" />
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
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

</head>

<body>

 <!-- / 顶部 / -->
 <div id="backTop"></div>
  
 


 <!-- 容器 -->
 <div id="incontainer" class="clear mb01" style="background:#eee;">
  <div id="mainContent01">
  
   <div style=" padding-left:153px;">
    <div style="color:#d39c1f; font-size:45px; line-height:38px;"></div>
    <div style=" font-size:21px; line-height:38px;">非常遗憾，你访问的页面不存在！</div>
    <div style=" font-size:12px; line-height:16px; color:#666; padding-bottom:10px;">看到这个提示，就自认倒霉吧！</div>
    <div class="backhome"><a href="/Team3_ZXJY/jspb/index.jsp">返回首页</a></div>
   </div>
   
  </div>
 </div>
 
<!-- 底部 -->
 <div id="foot">主办单位：江苏省教育评估院  地址：江苏省南京市北京西路15号  邮政编码：210024  电话：025-83335264  传真：025-83335267<br />
总访问量：218026  技术支持：常州大学</div>
</body>
</html>
