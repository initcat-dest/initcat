<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeContentLeft.jsp");
	}
	window.onload=function(){
		addForeTop();
		addForeContentLeft();
	}
</script>
</head>

<body>

 
  <!-- 头部 -->
  <div id="foreTop"></div>
  
  
  
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a href="javascript:(0)">作业管理</a> > <a>发作业</a> </div>
 </div>
 
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="foreContentLeft"></div>
  
  
  
   <!-- 正文右侧 -->
  <div class="right conright">
 		<div class=" border">
 		<form action="/Team3_ZXJY/addHomework" method="post" enctype="multipart/form-data">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        
        <tr>
          <td width="70" align="right" valign="middle">作业名称</td>
          <td><input class="text01" type="text" name="workTitle"/>&nbsp;&nbsp;<span class="red">标题不能超过30个字符</span></td>
        </tr>
         
        <tr>
          <td align="right" valign="middle">作业分类</td>
          <td><select class="select" name="workType" id="select">
            <option value="Java">JAVA</option>
            <option value="Android">Android</option>
            <option value="IOS">IOS</option>
          </select></td>
        </tr>
        
         <tr>
          <td align="right" valign="middle">上传附件</td>
          <td valign="middle"><div class="left mr mt02"><input class="text01 left mr" type="file"  name="fileField" id="fileField" /></div>
        </tr>
       
        <tr>
          <td align="right" valign="top">作业描述</td>
          <td><textarea class="textarea" name="textarea" id="textarea" cols="45" rows="5" placeholder="全文不超过500字符"></textarea></td>
        </tr>
       
      </table>
      
      <div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="确 定" />&nbsp;&nbsp;&nbsp;
            <input class="cancle" id="input" name="input" value="取 消" type="submit" />
           </div>
     </form>
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

