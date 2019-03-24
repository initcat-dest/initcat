<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<link rel=stylesheet type=text/css href="css/content.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
</head>
<body>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
    	<tr>
            <th><input name="" type="checkbox" value="" onclick="checkAll(this)"/></th>
            <th>消息标题</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        </thead>
        
     <tbody>
  <c:forEach items="${list.data }" var="r">
 
     <tr>
     <td><input name="" type="checkbox" value=${r.mesId} /></td> 
     <td align="center">${r.mesTitle }</td>
     <td align="center">${r.userId }</td>
        <td align="center">${r.mesTime }</td>
    
        <td>
        <a href="MessageLookServlet?Id=${r.mesId}" class="tablelink">查看</a>
        <a href="MessageDeleteServlet?Id=${r.mesId}" class="tablelink">删除</a>
       <a href="MessageUpdateServlet?Id=${r.mesId}" class="tablelink"> 修改</a>
        </td>
      </tr>
     
      
       </c:forEach>
    </tbody>
    </table>
     <!-----------分页----------->
 
            	<div class="paginationBox clear margin mt20" >
                                      <span><a href="javascript:d()" title="上一页" >上一页</a></span>
                                    <span ><a href="javascript:doSub(pageNum)" title="1" class="active">${list.pageNum}</a></span>
                                    <span ><a href="javascript:doSub1(pageNum)" title="2">${list.pageNum+1}</a></span>
                                    <span ><a href="javascript:doSub2(pageNum)" title="3">${list.pageNum+2}</a></span>
                                    <span ><a href="javascript:doSub3(pageNum)" title="4" >${list.pageNum+3}</a></span>
                                    <span ><a href="javascript:doSub4(pageNum)" title="5" >${list.pageNum+4}</a></span>
                                    
                                      <span ><a href="javascript:add()" title="下一页">下一页</a></span>
                                     </div>
  
  

</body>
</html>