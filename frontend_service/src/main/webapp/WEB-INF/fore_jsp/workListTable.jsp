<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合管理与服务平台</title>

</head>

<body>

	<div class="tablelist margin">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
    	<tr>
            <th><input name="" type="checkbox" value="" /></th>
            <th>标题</th>
            <th>分类</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
     </thead>
     <tbody>
     <c:forEach items="${list.data }" var="h">
	     <tr>
		     <td><input name="workId" type="checkbox" value="${h.workId }" /></td> 
		     <td align="center">${h.workTitle }</td>
		     <td align="center">${h.workType }</td>
		     <td align="center">${h.publishTime }</td>
		     <td>
		        <a href="homeworkDetail?workId=${h.workId }" class="tablelink">查看</a>
		        <a href="downloadHomework?workId=${h.workId }" class="tablelink">下载</a>
		     </td>
	      </tr>
      </c:forEach>
      
    </tbody>
    </table>
     <!-----------分页----------->
            	<div class="paginationBox clear margin mt20" >
                                      <span><a href="javascript:doSub(${list.pageNum-1 })" title="上一页" >上一页</a></span>
                                      <span ><a href="javascript:doSub(${list.pageNum+1 })" title="下一页">下一页</a></span>
                                     </div>
  	</div>
 
</body>
</html>


