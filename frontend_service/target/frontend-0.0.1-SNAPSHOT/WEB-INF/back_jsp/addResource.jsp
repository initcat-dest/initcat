<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
 <div id="container" class="clear mb01">
 
  <!-- 左侧列表 -->
  <div id="contentLeft"></div>
  
  <!-- 内容 -->
  <div id="mainContent">
   <!-- 正文内容 -->
   <div id="content">
    <!-- / 当前位置 / -->
 <div class="location clear f12">您的目前页面：<a>课件资源管理</a> > <a>添加</a>课件</div>
    <!-- 单位管理-部门管理 -->
    <div class="informationcx f14">
     <div class="title f16">
      <div class="titletext">添加课件</div>
     </div>
     <div class="mt">
       <form action="/Team3_ZXJY/addResource" method="post" enctype="multipart/form-data">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        <tr>
          <td width="130" align="right" valign="middle">资源名：</td>
          <td><input class="text01" type="text" name="textfield" id="textfield" />&nbsp;&nbsp;<span class="red">不能超过30个字符</span></td>
        </tr>
        
        <tr>
          <td width="130" align="right" valign="middle">资源是否可见：</td>
          <td>
          	<input type="radio" name="radio" value="1" />  可见&nbsp;
          	<input type="radio" name="radio" value="0" />  不可见
          </td>
        </tr>
        
        <tr>
          <td align="right" valign="middle">资源分类：</td>
          <td><select class="select" name="select" id="select" style="font-size: 18px;font-family: '黑体';">
            <option value="Java">Java</option>
            <option value="Android">Android</option>
            <option value="IOS">IOS</option>
          </select></td>
        </tr>

        <tr>
          <td align="right" valign="top">添加课件：</td>
          <td valign="top">
          <div class="clear">
              <input class="text01 left mr" type="file" name="fileField" id="fileField" />
              <div class="left"><input class="button" type="submit" name="button" id="button" value="上传附件" /></div>
          </div>
          </td>
        </tr>
      </table>
      
      <div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="添加" />&nbsp;&nbsp;&nbsp;
            <input class="cancle" id="input" name="input" value="取 消" type="submit" />
       </div>
       </form>
   </div>
    </div>
    
   </div>
  </div>
 </div>
 
 <!-- 底部 -->
 <div id="foot">主办单位：江苏省教育评估院  地址：江苏省南京市北京西路15号  邮政编码：210024  电话：025-83335264  传真：025-83335267<br />
总访问量：218026  技术支持：常州大学</div>
</body>
</html>