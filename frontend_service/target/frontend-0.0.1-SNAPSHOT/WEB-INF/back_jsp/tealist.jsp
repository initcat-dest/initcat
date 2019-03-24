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
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="bootstrap/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bjs/jquery.js"></script>
<script type="text/javascript" src="bjs/left.js"></script>

</head>
<body>

 <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="tablelist f14" style="width:100%;">
                                  <thead>
                                  <tr>
                                  	<th width="149"><input class='d2' id="teCheck" name="" type="checkbox" value="teCheck" onclick="checkAll(this)" /></th>
                                    <th width="149">姓名</th>
                                    <th width="101">工号</th>
                                    <th width="119">性别</th>
                                    <th width="136">部门</th>
                                    <th width="107">专业领域1</th>
                                    <th width="103">专业领域2</th>
                                    <th width="83">职称</th>
                                 <c:forEach items="${pager.data}" var="te">
                                  <tbody>
                                  <tr>                        
                                    <td><input name="teaId" type="checkbox" value="${te.teaId}" /></td>
                                       <td>${te.teaName}--${te.teaId}</td> 
                                    <td>${te.teaNo}</td> 
                                    <td>${te.teaSex==1?'男':'女' }</td>
                                    <td>${te.teaGroup}</td>
                                    <td>java</td>
                                    <td>IOS</td> 
                                    <td>教师</td> 
                                    </tr>
                                 </c:forEach>
                       
                                    
                                  </tbody>
                                </table> 
                                <!---分页----->
                                    <script type="text/javascript">
                                    function  ffff1(){
                                    	alert(1);
                                    	
                                    }
                    
                    </script>  
                                     <div class="paginationBox clear  mt20"  >
                                     <c:if test="${pager.pageNum==1}">
                                     <span><input disabled="disabled" type="button" id="lastpage" onclick="doSub(${pager.pageNum-1 })" title="上一页" value="上一页"></span>
                                        </c:if>
                                         <c:if test="${pager.pageNum!=1}">
                                     <span><input  type="button" id="lastpage" onclick="doSub(${pager.pageNum-1 })" title="上一页" value="上一页"></span>
                                        </c:if>
                                      <span ><a href="javascript:doSub(1)" title="1"  id="fenye" >1</a></span>
                                      <span ><a href="javascript:doSub(2)" title="2" id="fenye">2</a></span>
                                      <span ><a href="javascript:doSub(3)" title="3" id="fenye">3</a></span>
                                      <span ><a href="javascript:doSub(4)" title="4" id="fenye">4</a></span>
                                        <c:if test="${pager.pageNum>=pager.maxPageNum}">
                                     <span><input disabled="disabled" type="button" id="lastpage" onclick="doSub(${pager.pageNum+1 })" title="下一页" value="下一页"></span>
                                        </c:if>
                                         <c:if test="${pager.pageNum<pager.maxPageNum}">
                                     <span><input  type="button" id="lastpage" onclick="doSub(${pager.pageNum+1 })" title="下一页" value="下一页"></span>
                                        </c:if>&nbsp;
                                      <span ><input id="skip1" type="button" value="跳转至"  style="height:25px; " onclick="javascript:doSub1(${pager.maxPageNum})"/><input type="text" name="skip" id="skip"style="width: 30px;border: 1px solid #489EFF;"/></span>
                                      <span>当前页面:第{${pager.pageNum}}页</span>
                                     </div>
                               
</body>
</html>