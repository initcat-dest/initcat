<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.initcat.view.old.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>综合管理与服务平台</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
</head>
<body>
<div class="tablelist margin">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
    	<tr>
            <th><input name="" type="checkbox" value=""  onclick="checkAll(this)" /></th>
            <th>标题</th>
            <th>提问时间</th>
            <th>问题类型</th>
            <th>提问老师</th>
            <th>操作</th>
        </tr>
        </thead>
     <tbody>
     <c:forEach items="${pager.data}" var="s">
     <tr>
     <td><input name="queId" type="checkbox" value="${s.queId }" /></td> 
     <td align="center">${s.queTitle}</td>
     <td align="center">${s.queTime} </td>
     <td align="center">${s.queType }</td>
     <td align="center">${s.queTeaName }</td>
        <td>
        <a href="questionDetail?queId=${s.queId}" class="tablelink">查看</a>
        <a href="javascript:deleteQue()" class="tablelink">删除</a>
        <a href="/Team3_ZXJY/questionUpdate?queId=${s.queId}" class="tablelink"></a>
        
        </td>
      </tr>
      </c:forEach>
    </tbody>
    </table>
     <!-----------分页----------->
            	<div id="page" class="paginationBox clear margin mt20" >
                                       <c:if test="${pager.pageNum==1}">
                                      <span ><input disabled="disabled" type="button" id='aa2'  onclick="doSub(${pager.pageNum-1})" title="上一页" value="上一页" /></span>
                                      </c:if>
                                       <c:if test="${pager.pageNum!=1}">
                                      <span ><input  type="button" id='aa2'  onclick="doSub(${pager.pageNum-1})" title="上一页" value="上一页" /></span>
                                      </c:if>
                                      <c:forEach  var="item" varStatus="status" begin="1" end="${pager.maxPageNum}">
 										<span ><a yangshi="1" href="javascript:doSub(1)" title="${status.index }" >${status.index }</a></span>
 										</c:forEach>
                                       <c:if test="${pager.pageNum>=pager.maxPageNum}">
                                      <span ><input disabled="disabled" type="button" id='aa2'  onclick="doSub(${pager.pageNum+1})" title="下一页" value="下一页" />当前页面： 第<a>${pager.pageNum}   </a></span>
                                      </c:if>
                                       <c:if test="${pager.pageNum<pager.maxPageNum}">
                                      <span ><input  type="button" id='aa2'  onclick="doSub(${pager.pageNum+1})" title="下一页" value="下一页" />当前页面： 第<a>${pager.pageNum}</a></span>
                                      </c:if>
                                      <input id="pageNum" type="hidden" value="${ pager.pageNum}"/>
                                     </div>
  </div>
</body>
</html>