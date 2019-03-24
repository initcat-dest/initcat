<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择课程</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>
</head>
<body>
  <div class="right conright">
  <form action="/Team3_ZXJY/updateXuanke" method="post">
 		<div class=" border">
       <table  border="0" cellspacing="0" cellpadding="0" class="table">
         
         <tr>
          <td align="right" valign="middle">选择课程</td>
          <td><select class="select" name="classname" id="select">
            <option value="JAVA">JAVA</option>
            <option value="ANDROID">ANDROID</option>
            <option value="IOS">IOS</option>
          </select></td>
        </tr>
       <tr>
       <td>请选择教师：</td>
       <td>
       <select class="select" name="teacherName" id="select">
       <c:forEach items="${list}" var="tea">
      	 <option value="${tea.teaId}">${tea.teaName}</option>
      	 </c:forEach>
       </select>
       </td>
       </tr>
        <tr>
          <td align="right" valign="top">课程描述</td>
          <td><textarea class="textarea" name="classdetail" id="textarea" cols="45" rows="5" placeholder="全文不超过500字符"></textarea></td>
			</tr>
				</table>
      <div class="button_box">
	        <input class="submit" type="submit" name="button" id="button" value="确 定" />&nbsp;&nbsp;&nbsp;
            <input class="cancle" id="input" name="input" value="取 消" type="reset" />
           </div>
   </div>
  </form>
  </div>
</body>
</html>