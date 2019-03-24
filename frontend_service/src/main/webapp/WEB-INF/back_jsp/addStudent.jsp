<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
</head>
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
}</script>
<body>

 <!-- / 顶部 / -->
 <div id="backTop" class="clear"></div>
  
 <!-- 容器 -->
 <div id="container" class="clear mb01">
 
  <!-- 左侧列表 -->
  <div id="contentLeft" class="sidew"></div>
   
  <!-- 内容 -->
  <div id="mainContent">
   <!-- 正文内容 -->
   <div id="content">
    <!-- / 当前位置 / -->
 <div class="location clear f12">您的目前页面：<a >后台管理首页</a> > <a href="#">添加</a>学生</div>
    <!-- 单位管理-部门管理 -->
    <div class="informationcx f14">
     <div class="title f16">
      <div class="titletext">添加学生</div>
     </div>
      <form action="/Team3_ZXJY/saveStudent" method="post" >
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
  </div>
 </div>
 
 <!-- 底部 -->
 <div id="foot">主办单位：江苏省教育评估院  地址：江苏省南京市北京西路15号  邮政编码：210024  电话：025-83335264  传真：025-83335267<br />
总访问量：218026  技术支持：常州大学</div>
</body>
</html>
