<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getServletContext().getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>


<style>
.input {
	border: 2px #0C635A solid;
	width: 260px;
	hight: 90px
}

.hehe {
	border: 2px #0C635A solid;
	width: 80px;
	height: 45px;
	background-color: #0C635A;
	font-size: 26px;
	color: #eee;
	background-color: blue
}

.top {
	border-top: 4px solid #0C635A;
}
</style>
<script type="text/javascript">
	function h(id) {
		return document.getElementById(id);
	}
	function reseatUnameInput() {

		var uname = h('yh').value;
		if (uname !='') {
			$("#ncw").css("display","none");
			$("#ngs").css("display", "block");
			
		}
		 if (uname.length > 3 && uname.length < 16) {
			$("#ncw").css("display","none");
			$("#ngs").css("display", "block");return;
		}
		
		$("#ncw").css("display","block");
		$("#ngs").css("display", "none"); 
		}
	

	function checkPass() {

		var pass1 = h('mm').value;
		var passp = /^[a-zA-Z0-9]{6,16}$/;
		
		if (!passp.test(pass1)) {
			 $("#mts").css("display", "block");
			 $("#mgs").css("display", "none");
			 
		}
		else{$("#mts").css("display", "none");
		 $("#mgs").css("display", "block");
		 }
	}

	function checkPasss() {
		var pass1 = h('mm').value;
		var pass2 = h('qmm').value;
		var passp = /^[a-zA-Z0-9]{6,16}$/;
		if (passp.test(pass2)) {
			alert("hehe");
			 $("#mtss").css("display", "none");
			 $("#mgss").css("display", "block"); 
		}
		 if (pass1 == pass2) {
			 $("#mtss").css("display", "none");
			 $("#mgss").css("display", "block");
			 return;
			}
		
			 $("#mtss").css("display", "block");
			 $("#mgss").css("display", "none");
			 return;
		}
	

</script>
</head>

<body>
	<div>
		<div id="head">

			<!-- 头部 -->
			<div class="wrapper clear margin height">
				<div class="logo left">
					<a href="#"> <img src="images/logo.png" /> <span>注册用户信息</span>
						<p>NIIT Online Teaching BBS</p>
					</a>
				</div>
			</div>

			<form action="/Team3_ZXJY/UserSaveServlet" method="get">
				<div style="margin-left: 240px; width: 900px; height: 600px">
					<div style="margin-top: 50px; margin-left: 50px">
						<table
							style="border: 4px solid #0C635A; width: 800px; height: 500px">

							<tr>
								<td style="font-size: 26px; align: right">&nbsp;&nbsp;&nbsp;用户编号:</td>
								<td><input type="text" name="UserNumber" class="input"
									id="yh" onblur="reseatUnameInput()"></td>
								<td><div style="display: none; color: red" id="ncw">*用户编号格式错误*</div>
									<div style="font-size: 12px;" id="ngs">*用户编号格式：数字或字母3~16位</div>
									<div style="display: none">你的用户名已存在</div></td>
							</tr>
							<tr>
								<td style="font-size: 26px; align: center">&nbsp;&nbsp;&nbsp;用户密码:</td>
								<td><input type="password" name="UserPassword"
									onblur="checkPass()" class="input" id="mm"></td>
								<td><div style="display: none; color: red" id="mts">*用户密码格式错误*</div>
									<div style="font-size: 12px;" id="mgs">*用户密码格式：数字6~16位</div></td>
							</tr>
							<tr>
								<td style="font-size: 26px; align: center">&nbsp;&nbsp;&nbsp;确认密码:</td>
								<td><input type="password" name="UserPasswords"
									onblur="checkPasss()" class="input" id="qmm"></td>
								<td><div style="display: none; color: red" id="mtss">*您的密码与上输入不同*</div>
									<div style="font-size: 12px;" id="mgss">*用户密码格式：要一致哦！</div></td>
							</tr>
							<tr>
								<td style="font-size: 26px; align: center">&nbsp;&nbsp;&nbsp;用户类别:</td>
								<td><select name="UserType" class="input"
									style="width: 272px; height: 35px"><option
											id="student">学生</option>
										<option id="teacher">老师</option></select></td>
								<td style="font-size: 12px;">*俺们会审核的哦！</td>
							</tr>
							<!--<tr><td>用户问题:</td><td><input type="text" name="UserQuestion" class="input"></td><td style="font-size:12px" >*方便找回密码</td></tr>-->

							<tr>
								<td colspan="3"
									style="text-align: center; background-color: #0C635A; width: 324px; height: 100px"><input
									type="submit" value="注册" class="hehe"><input
									type="reset" value="重置" class="hehe"></td>
							</tr>
						</table>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
