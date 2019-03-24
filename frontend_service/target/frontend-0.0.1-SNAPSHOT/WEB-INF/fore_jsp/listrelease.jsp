<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统后台管理</title>
<link rel=stylesheet type=text/css href="css/base.css">
<link rel=stylesheet type=text/css href="css/module.css">
<link rel=stylesheet type=text/css href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/left.js"></script>

</head>
<body>

  <!-- 列表 -->

    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: center">
    <thead>
    	<tr>
            <th><input id="teCheck" name="" type="checkbox" value="teCheck" onclick="checkAll(this)"/></th>
            <th>标题</th>
            <th>分类</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach items="${pager.data}" var="se">
     <tbody>
<tr>                        
                                    <td><input name="seaId" type="checkbox" value="${se.seaId}" /></td>
                                       <td>${se.seaName}</td> 
                                    <td>${se.seaType}</td> 
                                    <td>${se.stuId}</td>
                                    <td>${se.publishTime}</td>
                                  <td>
				 	<a href="/Team3_ZXJY/releaseDetail?seaId=${se.seaId}" class="tablelink">查看</a>  
					<a href="/Team3_ZXJY/deleteRelease?seaId=${se.seaId}" class="tablelink">删除</a>
										<a href="/Team3_ZXJY/downloadsearch?seaId=${se.seaId}" class="tablelink">下载附件</a>
					
				</td>
                                    </tr>
                                 </c:forEach>
    </tbody>
    </table>
      <!-----------分页----------->
            	<div class="paginationBox clear  mt20"  >
                                     <c:if test="${pager.pageNum==1}">
                                     <span><input disabled="disabled" type="button" id="lastpage" onclick="doSub(${pager.pageNum-1 })" title="上一页" value="上一页"></span>
                                        </c:if>
                                         <c:if test="${pager.pageNum!=1}">
                                     <span><input  type="button" id="lastpage" onclick="doSub(${pager.pageNum-1 })" title="上一页" value="上一页"></span>
                                        </c:if>
                                      <span ><a href="javascript:doSub(1)" title="1" class="active">1</a></span>
                                      <span ><a href="javascript:doSub(2)" title="2">2</a></span>
                                      <span ><a href="javascript:doSub(3)" title="3">3</a></span>
                                      <span ><a href="javascript:doSub(4)" title="4">4</a></span>
                                        <c:if test="${pager.pageNum>=pager.maxPageNum}">
                                     <span><input disabled="disabled" type="button" id="lastpage" onclick="doSub(${pager.pageNum+1 })" title="下一页" value="下一页"></span>
                                        </c:if>
                                         <c:if test="${pager.pageNum<pager.maxPageNum}">
                                     <span><input  type="button" id="lastpage" onclick="doSub(${pager.pageNum+1 })" title="下一页" value="下一页"></span>
                                        </c:if>&nbsp;
                                      <span ><input id="skip1" type="button" value="跳转至"  style="height:25px; " onclick="javascript:doSub1(${pager.maxPageNum})"/><input type="text" name="resskip" id="resskip"style="width: 30px;border: 1px solid #489EFF;"/></span>
                                      <span>当前页面:第{${pager.pageNum}}页</span>
                                     </div>

</body>
</html>