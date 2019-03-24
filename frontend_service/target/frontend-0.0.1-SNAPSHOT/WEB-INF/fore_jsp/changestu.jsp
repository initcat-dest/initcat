<%@page import="com.initcat.view.old.entity.Student"%>
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
		$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeStudentContent.jsp");
	}
	
	window.onload=function(){
		addForeTop();
		addForeContentLeft();
	}
</script>
</head>

<body>
	<%
		//验证是否传递了用户信息过来
		Object editorObj = request.getAttribute("upstudent");
		if (editorObj == null) {
			response.sendRedirect("/Team3_ZXJY/jspf/studentSystemIndex.jsp");
			return;
		}
		//如果传递了编辑的用户
		Student stu = (Student) editorObj;//取出要编辑的用户对象
		//从request中取出错误信息
		Object error = request.getAttribute("error");
		if (error != null) {
	%>
	<span style='color: red'><%=error%></span>
	<%
		}
	%>
	<!-- 头部 -->
	<div id="foreTop"></div>
	
		
	<!-- 当前位置 -->
	<div id="location">
		<div class="wrapper margin">
			您的目前页面：首页> 修改信息
		</div>
	</div>

	<div class="wrapper margin clear" style="margin-top: 20px;">
		<!-- 正文左侧 -->
		<div id="foreContentLeft"></div>
		
		
		<!-- 正文右侧 -->
		<div class="right conright">
			

			
			<!-- 通知公告 -->
			<div class="tablelist margin">
	      <form action="/Team3_ZXJY/changeStudent" method="post" >
 
    
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
        <tr>
          <td width="130" align="right" valign="middle">学生姓名：</td>
          <td><input class="text01" type="text" name="stuName" id="stuName" value="<%=stu.getStuName() %>"  />&nbsp;</td>
        </tr>
        <tr>
          <td width="130" align="right"  valign="middle">学生学号：</td>
          <td><input class="text01" disabled="disabled" type="text" name="stuNo" id="stuNo" value="<%=stu.getStuno()%>" />&nbsp;</td>
        </tr>
           <tr>
         
          <td><input class="text01" type="hidden" name="stupwd" id="stupwd" value="<%=stu.getStupassword()%>" />&nbsp;</td>
        </tr>
     	  <tr>
          <td align="right" valign="middle">选择课程</td>
          <td><select class="select" name="className" id="className">
            <option>JAVA</option>
            <option>ANDROID</option>
            <option>IOS</option>
          </select></td>
        </tr>
        <tr>
           <td width="130" align="right" valign="middle">学生描述：</td>
       <td> <textarea value="<%=stu.getDetail() %>" class='text01' id="detail" name="detail" width="130" align="right" cols="40" rows="5" style='height: 50px' >
   
        </textarea></td>
        </tr>
      </table>
								
									<div class="button_box">
											<input class="submit" type="submit" name="button" id="button"
												value="提 交" />&nbsp;&nbsp;&nbsp;
									<input class="cancle" id="input" name="input"
										value="重 置" type="reset" />
										</div>
								
							
						</form>
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer" class="gray tc f12 mt20">
		© 2014 © 2015 无锡市安艾艾迪服务外包培训学校 版权所有 All rights reserved.<br />


	</div>

	<!-- 代码 开始 -->

	<!-- 代码 结束 -->
</body>
</html>
