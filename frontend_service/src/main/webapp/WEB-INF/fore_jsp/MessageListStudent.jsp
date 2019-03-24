<%@page import="com.initcat.view.old.entity.Message"%>
<%@page import="com.initcat.view.old.entity.Pager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消息列表</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
<script type="text/javascript">
function addForeTop(){
	$("#foreTop").load("/Team3_ZXJY/jspf/ForeTop.jsp");
}

function addForeContentLeft(){
	$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeStudentContent.jsp");
}

var pageNum=1;

function doSub(pageNum) {
	
	$("#listTable").load("MessageListServlet?o="+new Date().getTime(), {
		selectTitle : $("#messageTitle").val(),
		selectTime : $("#messageTime").val(),
		pageNum:pageNum
	});
}
function doSub1(pageNum) {
add();
	
}
function doSub2(pageNum) {
	
	add();add();
	
}
function doSub3(pageNum) {
	add();add();add();
}
function doSub4(pageNum) {
	
	add();add();add();add();
}
window.onload=function(){
	doSub(1);
	addForeTop();
	addForeContentLeft();
	var pageNum=1;
	
	//addTop();
//addContentLeft();
}

function checkAll(checkbox){
	if(checkbox.checked){$("input[type=checkbox]").attr('checked',true)}
	else{$("input[type=checkbox]").attr('checked',false)}
}

function add(){pageNum=pageNum+1;
doSub(pageNum);
}
function d(){
	if(pageNum>=2){pageNum=pageNum-1;
	doSub(pageNum);}
	else{alert("这已经是第一页了！！");}
	}
function deleteMess(){
	//获取选消息 的编号
	var cks = $("input[type=checkbox]");
	//if(cks.length == 1){
	//	return;
	//}
	
	var params;
	for(var i = 0;i<cks.length;i++){
		if($(cks[i]).attr("checked")){
			params+="&Id="+$(cks[i]).val();
		}
	};
	
	var url = "MessageDeleteServlet?"+params;
	
	if(confirm("您确定删除吗?")){
		location.href = url;
	}
	
	
}

</script>
</head>

<body>

  
  <!-- 头部 -->
  <div  id="foreTop"></div>
   
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a href="#">首页</a> > <a href="#">消息列表</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="foreContentLeft" class="sidew">
   
  </div>
   <!-- 正文右侧 -->
  <div class="right conright">
 <div class="search">
      
      <table border="0" cellpadding="0" cellspacing="0" class="table01">
        <tr>
          <td align="right">标题：</td>
          <td width="190" align="left"><input name="" type="text" class="text02" id="messageTitle" value="" /></td>
          <td align="right">发布时间：</td>
          <td width="170" align="left"><input name="" type="text" class="text02" id="messageTime" value="" /></td>
          <td width="80" align="right"><input class="button" type="button" onclick="doSub(1)" id="button" value="查&nbsp;询" /></td>
        </tr>
      </table>
    </div>
    
     <div class="applybutton mt clear">
      <a href="/Team3_ZXJY/jspf/MessageSave.jsp">添 加</a>
      
      <a href="javascript:deleteMess()">删 除</a>
     </div>
      <!-- 列表 -->
      <div id='listTable' class="tablelist margin"></div>
     
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