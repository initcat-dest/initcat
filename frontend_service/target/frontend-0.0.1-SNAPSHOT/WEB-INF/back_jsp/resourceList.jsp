<%@page import="com.initcat.view.old.entity.Resource"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
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
</head>
<script type="text/javascript">
	
	function addContentLeft(){
		$("#contentLeft").load("addContentLeft?o="+new Date().getTime());
	}
	
	function addTop(){
		$("#backTop").load("/Team3_ZXJY/jspb/BackTop.jsp");
	}
	
	function doSub(pageNum) {
		//alert(pageNum);
		//同一个URL不会重新加载
		$("#listTable").load("resList?o="+new Date().getTime(), {
			selectType : $("#selectType").val(),
			selectId : $("#selectId").val(),
			pageNum:pageNum
		});
	}
	window.onload=function(){
		doSub(1);
		addTop();
		addContentLeft();
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
 <div class="location clear f12">您的目前页面：<a href="#">课件资源管理</a> >课件列表 </div>
   <div class="yjb mt ">
     	<div class="conSearch ">
        <div class="iptSearch background mb f12">请选择类型：<select id="selectType" name=""  class="select">
        				<option value=""></option>
        				<option value="Java">Java</option>
           				<option value="Android">Android</option>
           				<option value="IOS">IOS</option>
        				</select>
        				上传资源的老师的ID:
        <input id="selectId" name="selectId" type="text"  /><input type="button" onclick="doSub()"  value="搜索" class="btn" style="background:#ff7700;"/>

                               </div>
          <div class="btnSearch ">
          <script type="text/javascript">
          	function toAddRes(){
          		location.href = "/Team3_ZXJY/jspb/addResource.jsp";
          	}
          </script>
           <input onclick="toAddRes()" type="button" value="增加" class="btn" />
           <script type="text/javascript">
            function checkAll(checkbox){
            	if(checkbox.checked){
            		$('input[type=checkbox]').attr('checked', true);
            	}else{
            		$('input[type=checkbox]').attr('checked', false);

            	}
            	}
            
            	function deleteRes(){
            		//获取选中学生的编号
            		var cks = $(":checked");
            		if(cks.length == 1){
            			return;
            		}
            		var params= "o=x";
            		for(var i = 0;i<cks.length;i++){
            			if($(cks[i]).attr("type")=='checkbox' && $(cks[i]).attr("name")=='resId'){
            				//alert($(cks[i]).val());
            				params+="&resId="+$(cks[i]).val();
            			}
            		};
            		
            		var url = "/Team3_ZXJY/deleteRes?"+params;
            		if(confirm("您确定删除吗?")){
            			location.href = url;
            		}
            		//跳转
            		//location.href=url;
            		//String [] stuIds = request.getParameterValues("stuId");
            	}
            </script>
           <input type="button" onclick="deleteRes()" value="删除" class="btn" />
          </div>
         </div>
         <!---表格--->
        <div id="listTable"></div>                          
         
      </div>
    
   </div>
  </div>
 </div>
 
 <!-- 底部 -->
 <div id="foot">主办单位：江苏省教育评估院  地址：江苏省南京市北京西路15号  邮政编码：210024  电话：025-83335264  传真：025-83335267<br />
总访问量：218026  技术支持：常州大学</div>
</body>
</html>




