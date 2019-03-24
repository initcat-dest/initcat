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
            <th>消息标题</th>
            <th>发布人</th>
            <th>发布时间</th>
        </tr>
        </thead>
        
     <tbody>
  <c:forEach items="${list.data }" var="r">
 
     <tr>
     <td align="center">${r.mesTitle }</td>
     <td align="center">${r.userId }</td>
        <td align="center">${r.mesTime }</td>
      </tr>
     
      
       </c:forEach>
    </tbody>
    </table>
     <!-----------分页----------->
 
  
  

</body>
</html>