<%@page import="com.initcat.view.old.entity.Teacher"%>
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
	$(".foreTop").load("/Team3_ZXJY/jspf/ForeTop.jsp");
}

function addForeContentLeft(){
	$(".foreContentLeft").load("/Team3_ZXJY/jspf/ForeContentLeft.jsp");
}

window.onload=function(){
	addForeTop();
	addForeContentLeft();
}
function my$(id) {
	return document.getElementById(id);
}
	
	/*修改指定id元素的边框颜色*/
	function checkBorder(id, color) {
		my$(id).style.borderColor=color;
	}
	function changeErroralt(id, isok) {
		my$(id).className = isok ? 'erroralt' : 'erroralt1';
	}
	function checkoldPass(pass) {

		checkBorder('upass', '#f00');
		changeErroralt('upassing', false);
		var pass1 = my$('upass').value;
		var passold = pass;
		if (passold != pass1) {

			my$('upassing1').innerHTML = "<span style='color:#f00;'>密码输入错误</span>";
			return false;
		}
		checkBorder('upass', '#0f0');
		changeErroralt('upassing', true);
		my$('upassing1').innerHTML = "密码输入正确！";
		return true;
	}
	function checkPass() {
		//将用密码的边框修改为红色
		checkBorder('upass1', '#f00');
		changeErroralt('newpassing', false);
		//验证密码
		var pass1 =my$('upass1').value;
		if (pass1.length<4 || pass1.length>16) {
			my$('newpassing1').innerHTML = "<span style='color:#f00;'>密码长度错误请输入4至16位的字母和数字</span>";
			return false;
		}
		var passp = /^[a-zA-Z0-9]{6,16}$/;

		if (!passp.test(pass1)) {
			my$('newpassing1').innerHTML = "<span style='color:#f00;'>密码输入错误</span>";
			return false;
		}
		//将用密码的边框修改为红色
		checkBorder('upass1', '#0f0');
		changeErroralt('newpassing', true);
		my$('newpassing1').innerHTML = "密码格式正确!";
		return true;
	}

	function checkRPass() {
		checkBorder('upass2', '#f00');
		changeErroralt('rnewpassing', false);
		//确认密码验证
		var pass1 = my$('upass1').value;
		var pass2 = my$('upass2').value;
		if (pass2 != pass1) {
			my$('rnewpassing1').innerHTML = "<span style='color:#f00;'>两次输入的密码不相同！</span>";
			return false;
		}
		checkBorder('upass2', '#0f0');
		changeErroralt('rnewpassing', true);
		my$('rnewpassing1').innerHTML = "两次输入相同，输入正确！";
		return true;
	}

	function checkForm() {

		if ( checkPass() && checkRPass() && checkoldPass()
				) {
			return true;
		}
		return false;
	}
	
</script>
</head>

<body>

	<!-- 头部 -->
	<div id="" class="foreTop"></div>
	
		
	<!-- 当前位置 -->
	<div id="location">
		<div class="wrapper margin">
			您的目前页面：首页> 网站公告
		</div>
	</div>

	<div class="wrapper margin clear" style="margin-top:20px;">
		<!-- 正文左侧 -->
		<div id="" class="foreContentLeft"></div>
		
		
		<!-- 正文右侧 -->
		<div class="right conright">
			<div class="search">

				
			</div>

			
			<!-- 通知公告 -->
			<div class="tablelist margin">
			<form action="changeteapwd">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="table">
					<tr>
						<td width="115" align="right" valign="middle">请输入密码</td>
						<td><input onblur="checkoldPass(${teacher.teaPwd})" id='upass' class="text01"
							type='password' name='upass' /></td>
						<td class='altTd'>
							<div id='upassing' class='erroralt2'></div>
							<div id='upassing1'>*请输入当前登陆用户密码</div>
						</td>
					</tr>
					<tr>
						<td align="right" valign="middle">请输入新密码</td>
						<td><input onblur="checkPass()" id='upass1' class="text01"
							type="password" name='upass1' /></td>
						<td class='altTd'>
							<div id='newpassing' class='erroralt2'></div>
							<div id='newpassing1'></div>
						</td>
					</tr>
<tr>

								<td><input name="teaId" type="hidden" class="text01"
									id="teaId" value="${teacher.teaId}" /></td>
							</tr>

					<tr>
						<td align="right" valign="middle">请再次输入新密码</td>
						<td><input onblur="checkRPass()" id='upass2' name='newpass1'
							class="text01" type="password" /></td>
						<td class='altTd'>
							<div id='rnewpassing' class='erroralt2'></div>
							<div id='rnewpassing1'></div>
						</td>
					</tr>
				

				</table>
		<div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="确 定" />&nbsp;&nbsp;&nbsp;
            <input class="cancle" id="input" name="input" value="重 置" type="reset" />
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
