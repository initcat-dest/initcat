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


</head>
<script>

	function addForeTop(){
		$("#foreTop").load("/Team3_ZXJY/jspf/ForeTop.jsp");
	}

	function addForeContentLeft(){
		$("#foreContentLeft").load("/Team3_ZXJY/jspf/ForeStudentContent.jsp");
	}
	
	window.onload=function(){
		doSub(1);
		addForeTop();
		addForeContentLeft();
	}
</script>

<body>

 
 
  <!-- 头部 -->
  <div  id="foreTop"></div>
   
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：首页> 网站公告 </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="foreContentLeft" class="sidew">
   
  </div>
   <!-- 正文右侧 -->
  <div class="right conright">
 <div class="search">
      
      <table border="0" cellpadding="0" cellspacing="0" >
        <tr>
          <td align="right">标题：</td>
          <td width="190" align="left"><input name="inputsel" type="text" class="text02" id="inputsel" value="" /></td>
          <td width="80" align="right"><input class="button" type="submit" name="button" id="button" value="查&nbsp;询" /></td>
        </tr>
      </table>
    </div>
    <script type="text/javascript">
    //全选
	function checkAll(checkbox) {
		if (checkbox.checked) {
			$('input[type=checkbox]').attr(
					'checked', true);
		} else {
			$('input[type=checkbox]').attr(
					'checked', false);

		}
	}
								//教师列表分页	

								function doSub(pageNum) {
									//同一个URL不会重新加载
									$("#listTable")
											.load(
													"/Team3_ZXJY/releaList?o="
															+ new Date()
																	.getTime(),
													{
														select : $("#select")
																.val(),
														inputsel : $(
																"#inputsel")
																.val(),

														pageNum : pageNum
													});
								}
								function doSub1(maxPageNum) {
									
									//同一个URL不会重新加载
									var pageNum = document
											.getElementById("resskip").value;
									alert(maxPageNum);
									if (pageNum >maxPageNum) {
										alert(pageNum >maxPageNum);
										return;
									}
									
									$("#listTable").load(
											"/Team3_ZXJY/releaList?o="
													+ new Date().getTime(), {
														isWho : "stu",
												pageNum : pageNum
												

											});
								}
								
								//

								function toAddrelease() {
									location.href = "/Team3_ZXJY/jspf/ReleaseNaire.jsp";
								}
								function updateSea() {
									var cks = $(":checked");
									alert(cks.length);
									var params = "o=x";
									if (cks.length !=1) {
										alert("请选择问卷（只能选择一个）");
										return;
									}
									for (var i = 0; i < cks.length; i++) {
										if ($(cks[i]).attr("type") == 'checkbox'
												&& $(cks[i]).attr("name") == 'seaId') {
											params += "&seaId="
													+ $(cks[i]).val();
										}
										;
									}
									var url = "/Team3_ZXJY/updateRelease?"
											+ params;

									location.href = url;

								}
							</script>
							<script type="text/javascript">
								//左侧
						
							

								function deleteRel() {
							
									//获取选中学生的编号
									var cks = $(":checked");
									if (cks.length == 0) {
										return;
									}
									
									var params = "o=x";
									for (var i = 0; i < cks.length; i++) {
										if ($(cks[i]).attr("type") == 'checkbox'
												&& $(cks[i]).attr("name") == 'seaId') {
											alert($(cks[i]).val());
											params += "&seaId="
													+ $(cks[i]).val();
										}
									}
									;

									var url = "/Team3_ZXJY/deleteRelease?"
											+ params;
									alert(url);
									if (confirm("您确定删除吗?")) {
										location.href = url;
									}
									//跳转
									//location.href=url;
									//String [] stuIds = request.getParameterValues("stuId");
								}
								
							</script>
    
     <div class="applybutton mt clear">
     </div>
     <div id="listTable" ></div>
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
