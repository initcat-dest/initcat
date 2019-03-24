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
function doSub(pageNum){
		//alert(pageNum);
		//同一个URL不会重新加载
		$("#listTable").load("/Team3_ZXJY/tea_StudentServlet?o="+new Date().getTime(), {
			stuname : $("#stuName").val(),
			pageNum:pageNum
		},function(){
			f1();
		});
}
function f1(){
	var a=$('[yangshi]');
	for(var s=0;s<a.length;s++){
		if($(a[s]).attr("title") != null&&$(a[s]).attr("title")==$("#pageNum").val()){
			$(a[s]).addClass("active");
		}
	};
}
window.onload = function() {
	addTop();
	addContentLeft();
	doSub(1);
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
  <div class="wrapper margin">您的目前页面：首页   > <a href="#">网站公告</a> </div>
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
          <td width="190" align="left"><input name="stuName" type="text" class="text02" id="stuName" value="姓名" /></td>
          <td width="80" align="right"><input onclick="doSub()" class="button" type="submit" name="button" id="button" value="查&nbsp;询" /></td>
        </tr>
      </table>
    </div>
    <script type="text/javascript">
    function checkAll(checkbox){
    	if(checkbox.checked){
    		$('input[type=checkbox]').attr('checked', true);
    	}else{
    		$('input[type=checkbox]').attr('checked', false);
    	}
    	}
    
    	function deleteStu(){
    		//获取选中学生的编号
    		var cks = $(":checked");
    		if(cks.length==0){
    			return;
    		}
    		var params= "o=x";
    		for(var i = 0;i<cks.length;i++){
    			if($(cks[i]).attr("type")=='checkbox' && $(cks[i]).attr("name")=='stuId'){
    				//alert($(cks[i]).val());
    				params+="&stuId="+$(cks[i]).val();
    			}
    		};
    		
    		var url = "/Team3_ZXJY/tea_StudentDelete?"+params;
    		if(confirm("您确定删除吗?")){
    			location.href=url;
    		}
    		//跳转
    		//location.href=url;
    				//String [] stuIds = request.getParameterValues("stuId");
    	}
    
    </script>
    
    
     <div class="applybutton mt clear">
      
      <a href="javascript:deleteStu()">删 除</a>
     </div>
  <!-- 列表 -->
  <div id="listTable"></div>
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
