<%@page import="com.initcat.view.old.entity.Announce"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	}
	function checkAll(checkbox){
    	if(checkbox.checked){
    		$('input[type=checkbox]').attr('checked', true);
    	}else{
    		$('input[type=checkbox]').attr('checked', false);
    	}
    }
    
    function delAnn(){
    	//获取选中学生的编号
		var cks = $(":checked");
    	if(cks.length == 0){
    		return;
    	}
		var params= "o=x";
		for(var i = 0;i<cks.length;i++){
			if($(cks[i]).attr("type")=='checkbox' && $(cks[i]).attr("name")=='annId'){
				params+="&annIds="+$(cks[i]).val();
			}
		};
		var url = "/Team3_ZXJY/delAnnounce?"+params;
    	if(confirm("您确定删除所选公告吗?")){
			location.href = url;
		}
    }
    function aBack(){
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
 <div class="location clear f12">您的目前页面：<a href="#">后台管理首页</a> </div>
   <div class="yjb mt ">
     	<div class="conSearch ">
        
          <div class="btnSearch ">
           <input type="button" value="返回" class="btn" onclick="aBack()"/>
           <input type="button" value="删除" class="btn" onclick="delAnn()"/>
          </div>
         </div>
         <!---表格--->
                                  <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="tablelist f14" style="width:100%;">
                                  <thead>
                                  <tr>
                                  	<th width="149"><input name="" type="checkbox" value="" onclick="checkAll(this)"/></th>
                                    <th width="149">标题</th>
                                    <th width="101">发布人</th>
                                    <th width="119">发布时间</th>
                                    <th width="136">操作</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <c:forEach items="${ans}" var="an">
                                  <tr>                        
                                    <td><input name="annId" type="checkbox" value="${an.annId}" /></td>
                                    <td>${an.annTitle} </td> 
                                    <td>${an.annPeople}</td>
                                    <td>${an.annTime}</td>
                                    <td>
                                    	<a href="/Team3_ZXJY/announceDetail?annId=${an.annId}" class="tablelink">查看</a>
                                    	<a href="/Team3_ZXJY/updateAnnounce?annId=${an.annId}" class="tablelink">编辑</a>
                                    </td>
                                  </tr>
                               	</c:forEach>
                                  </tbody>
                                </table>
                                  <!---分页----->
                                    <div class="paginationBox clear  mt20" >
                                      <span><a href="#" title="上一页" >上一页</a></span>
                                      <span ><a href="#" title="1" class="active">1</a></span>
                                      <span ><a href="#" title="2">2</a></span>
                                      <span ><a href="#" title="3">3</a></span>
                                      <span ><a href="#" title="4">4</a></span>
                                      <span ><a href="#" title="5">5</a></span>
                                      <span ><a href="#" title="6">6</a></span>
                                      <span ><a href="#" title="7">7</a></span>
                                      <span ><a href="#" title="8">8</a></span>
                                      <span ><a href="#" title="下一页">下一页</a></span>
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
