<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
<body>

<div id="top" class="clear">
  <div class="logo left"><img src="bimages/logo.png" title="系统后台管理" /></div>
  <div class="width500 right mr01 lh35 mt01">
   <div class="clear f12 white">
    <div class="right">
    <span id=localtime></span>
    <script type="text/javascript">
    function showLocale(objD)
    {
	var str,colorhead,colorfoot;
	var yy = objD.getYear();
	if(yy<1900) yy = yy+1900;
	var MM = objD.getMonth()+1;
	if(MM<10) MM = '0' + MM;
	var dd = objD.getDate();
	if(dd<10) dd = '0' + dd;
	var hh = objD.getHours();
	if(hh<10) hh = '0' + hh;
	var mm = objD.getMinutes();
	if(mm<10) mm = '0' + mm;
	var ss = objD.getSeconds();
	if(ss<10) ss = '0' + ss;
	var ww = objD.getDay();
	if  ( ww==0 )  colorhead="<font color=\"#FFFFFF\">";
	if  ( ww > 0 && ww < 6 )  colorhead="<font color=\"#FFFFFF\">";
	if  ( ww==6 )  colorhead="<font color=\"#FFFFFF\">";
	if  (ww==0)  ww="星期日";
	if  (ww==1)  ww="星期一";
	if  (ww==2)  ww="星期二";
	if  (ww==3)  ww="星期三";
	if  (ww==4)  ww="星期四";
	if  (ww==5)  ww="星期五";
	if  (ww==6)  ww="星期六";
	colorfoot="</font>"
	str = "<div style='font-size:12px;'>"+colorhead + yy + "年" + MM + "月" + dd + "日&nbsp;&nbsp;&nbsp;" + ww + colorfoot+"</div>";
	return(str);
    }
    function tick()
    {
	var today;
	today = new Date();
	document.getElementById("localtime").innerHTML = showLocale(today);
	window.setTimeout("tick()", 1000);
    }
    tick();
    </script>
    </div>
    <span class="welcome right">欢迎您：${loginAdmin.adminName }[ ID:${loginAdmin.adminId } ]&nbsp;&nbsp;今天是：</span>
   </div>
   <script> 
		function reloadOnce(){ 
			location.reload(true); 
		} 
	</script> 
   <div class="topAd clear">
    <a class="t_03" href="#">注销</a><a class="t_02" href="javascript:reloadOnce()">刷新</a><a class="t_01" href="/Team3_ZXJY/jspb/index.jsp">首页</a>
   </div>
  </div>
 </div>


</body>
</html>