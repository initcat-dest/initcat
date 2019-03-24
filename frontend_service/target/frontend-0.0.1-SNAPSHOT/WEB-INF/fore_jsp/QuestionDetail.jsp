<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
	
	//f1();
}
</script>
</head>

<body>

 <div id="head">
  <!-- 头部 -->
 </div>
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：首页   > <a >网站公告</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="contentLeft"></div>
   <!-- 正文右侧 -->
  <div id="tableList">
    <div class="right conright">
 <div class="search">
      
      <table border="0" cellpadding="0" cellspacing="0" class="table01">
        <tr>
          <td align="right">学生姓名：</td>
          <td width="190" align="left"><input name="title" type="text" class="text02" id="title" value="标题" /></td>
          <td width="80" align="right"><input class="button" type="submit" name="button" id="button" value="查&nbsp;询" /></td>
        </tr>
      </table>
    </div>
     <div class="applybutton mt clear">
      <a href="javascript:/Team3_ZXJY/jspf/AddQuestion.jsp">添 加</a>
      <a href="javascript:deleteQue()">删 除</a>
     </div>
  <!-- 列表 -->
  <div id="listTable">
  <div><table>
  <tr>
  <td>问题标题:</td>
  <td>${que.queTitle}</td>
  </tr>
  <tr>
  <td>问题内容:</td>
  <td>${que.queContent}</td>
  </tr>
  <tr>
  <td>问题时间:</td>
  <td>${que.queTime}</td>
  </tr>
  <tr>
  <td>问题类型:</td>
  <td>${que.queType}</td>
  </tr>
  <tr>
  <td>老师名字:</td>
  <td>${que.queTeaName}</td>
  </tr>
  </table> </div>
  </div>
  </div>
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
