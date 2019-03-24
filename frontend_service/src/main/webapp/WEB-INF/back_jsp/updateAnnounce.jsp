<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getServletContext().getContextPath() + "/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="bcss/base.css">
<link rel=stylesheet type=text/css href="bcss/layout.css">
<link rel=stylesheet type=text/css href="bcss/module.css">
<link rel=stylesheet type=text/css href="bcss/content.css">
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>
<script type="text/javascript" src="bckeditor/ckeditor.js"></script>

</head>
<script type="text/javascript">
	function addContentLeft() {
		$("#contentLeft").load("addContentLeft?o=" + new Date().getTime());
	}

	function addTop() {
		$("#backTop").load("/Team3_ZXJY/jspb/BackTop.jsp");
	}
	window.onload = function() {
		addTop();
		addContentLeft();
	}
	function ba() {
		location.href = "/Team3_ZXJY/announceList";
	}
</script>
<body>

	<!-- / 顶部 / -->
	<div id="backTop"></div>


	<!-- 容器 -->
	<div id="incontainer" class="clear mb01">

		<!-- 左侧列表 -->
		<div id="contentLeft"></div>




		<!-- 内容 -->
		<div id="mainContent">
			<!-- 正文内容 -->
			<div id="content">
				<!-- / 当前位置 / -->
				<div class="location clear f12">
					您的目前页面：<a href="#">后台管理首页</a> > <a href="#">修改</a>公告
				</div>
				<!-- 单位管理-部门管理 -->
				<div class="informationcx f14">
					<div class="title f16">
						<div class="titletext">修改公告</div>
					</div>
					<form action="/Team3_ZXJY/updateAnnToList?annId=${an.annId }"
						method="post">
						<div class="mt">
							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								class="table">
								<tr>
									<td width="142" align="right" valign="middle">公告标题</td>
									<td width="1210"><input class="text01" type="text"
										name="annTitle" id="textfield" value="${an.annTitle}" />&nbsp;&nbsp;<span
										class="red">标题不能超过30个字符</span></td>
								</tr>
								<tr>
									<td width="142" align="right" valign="middle">公告发布人</td>
									<td><input class="text01" type="text" name="annPeople"
										id="textfield" value="${an.annPeople}" />&nbsp;&nbsp;<span
										class="red">不能超过30个字符</span></td>
								</tr>
								<tr>
									<td width="142" align="right" valign="middle">发布时间</td>
									<td><input class="text02" type="text" name="annTime"
										id="textfield" value="${an.annTime}" />&nbsp;&nbsp;<span
										class="red">标题不能超过30个字符</span></td>
								</tr>
								<tr>
									<td align="right" valign="top">内容</td>
									<td><textarea class="textarea" name="annContent"
											id="textarea" cols="45" rows="5" placeholder="全文不超过500字符">${an.annContent}</textarea>
										<script type="text/javascript">
											CKEDITOR.replace('newsContent', {
												height : '180px',
												width : '800px'
											});
										</script>
									</td>
								</tr>

							</table>
							<div class="button_box">
								<input class="submit" type="submit" name="button" id="button"
									value="确 定" />&nbsp;&nbsp;&nbsp; <input class="cancle"
									id="input" name="input" value="取 消" type="button"
									onclick="ba()" />
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="foot">
		主办单位：江苏省教育评估院 地址：江苏省南京市北京西路15号 邮政编码：210024 电话：025-83335264
		传真：025-83335267<br /> 总访问量：218026 技术支持：常州大学
	</div>
</body>
</html>