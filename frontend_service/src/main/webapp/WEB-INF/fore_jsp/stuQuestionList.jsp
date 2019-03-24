<%@page import="com.initcat.view.old.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
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

<body>

 <div id="head"></div>
 
  <!-- 头部 -->
  <div class="wrapper clear margin height">
   

 </div>
 <!-- 当前位置 -->
 <div id="location">
  <div class="wrapper margin">您的目前页面：<a href="#">首页</a> > <a href="#">网站公告</a> </div>
 </div>
 
 <div class="wrapper margin clear" style="margin-top:20px;">
  <!-- 正文左侧 -->
  <div id="sidebar" class="sidew">
   
  
  </div>
   <!-- 正文右侧 -->
  <div class="right conright">
  <div class="pb">
   <div class="applybutton mt clear">
      <a href="合作企业添加.html">添 加</a>
      <a href="合作企业添加.html">修 改</a>
      <a href="#">删 除</a>
     </div>
  <!-- 列表 -->
  <div class="tablelist margin">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <thead>
    	<tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>学生姓名</th>
            <th>问题内容</th>
            <th>提问时间</th>
            <th>操作</th>
        </tr>
        </thead>
     <tbody>
     <tr>
     <td><input name="" type="checkbox" value="" /></td> 
     <td align="center">张三</td>
     <td align="center">JAVA好学么？</td>
     <td align="center">2014-04-24 12:00:00</td>
        <td>
        <a href="#" class="tablelink">回答</a>
        <a href="#" class="tablelink">查看</a>
        <a href="#" class="tablelink">删除</a>
        </td>
      </tr>

    </tbody>
    </table>
     <!-----------分页----------->
            	<div class="paginationBox clear margin mt20" >
                                 <c:if test="${pager.pageNum==1}">
                                     <span><input disabled="disabled" type="button" id="lastpage" onclick="doSub(${pager.pageNum-1 })" title="上一页" value="上一页"></span>
                                        </c:if>
                                         <c:if test="${pager.pageNum!=1}">
                                     <span><input  type="button" id="lastpage" onclick="doSub(${pager.pageNum-1 })" title="上一页" value="上一页"></span>
                                        </c:if>
                                        <c:if test="${pager.pageNum>=pager.maxPageNum}">
                                     <span><input disabled="disabled" type="button" id="lastpage" onclick="doSub(${pager.pageNum+1 })" title="下一页" value="下一页"></span>
                                        </c:if>
                                         <c:if test="${pager.pageNum<pager.maxPageNum}">
                                     <span><input  type="button" id="lastpage" onclick="doSub(${pager.pageNum+1 })" title="下一页" value="下一页"></span>
                                        </c:if>&nbsp;
                                      <span ><input id="skip1" type="button" value="跳转至"  style="height:25px; " onclick="javascript:doSub1(${pager.maxPageNum})"/><input type="text" name="resskip" id="resskip"style="width: 30px;border: 1px solid #489EFF;"/></span>
                                      <span>当前页面:第{${pager.pageNum}}页</span>
                                     </div>
  </div>
  
  </div>
  		<div class="mt">
        <div class="borderbottom pb01 mb f14">
         <div class="background01 lh20 f16  pad10">NIIT 如何让技术跟得上时代的步伐？</div>
        <p><b class="pad10">回答：</b>NIIT在软件上的优势也为培训带来了利益：对于NIIT， 软件开发和培训是互相促进的。利用在开发软件项目上赢得的经验（流行的技术和实际生活的个案）来武装学生，让他们也成为IT专家。 与技术发明者的关系：不管是 Microsoft、 Oracle还是 Computer Associates， NIIT 是首先接受、消化和使用其产品，然后通过学生和专业渠道向外传播。</p> 
        </div>
        <div class="borderbottom pb01 mb f14">
         <div class="background01 lh20 f16  pad10">NIIT的教学方法有什么特点？</div>
        <p><b class="pad10">回答：</b>NIIT在软件上的优势也为培训带来了利益：对于NIIT， 软件开发和培训是互相促进的。利用在开发软件项目上赢得的经验（流行的技术和实际生活的个案）来武装学生，让他们也成为IT专家。 与技术发明者的关系：不管是 Microsoft、 Oracle还是 Computer Associates， NIIT 是首先接受、消化和使用其产品，然后通过学生和专业渠道向外传播。</p> 
        </div>
        <div class="borderbottom pb01 mb f14">
         <div class="background01 lh20 f16  pad10">选择.net还是java?</div>
        <p><b class="pad10">回答：</b>NIIT在软件上的优势也为培训带来了利益：对于NIIT， 软件开发和培训是互相促进的。利用在开发软件项目上赢得的经验（流行的技术和实际生活的个案）来武装学生，让他们也成为IT专家。 与技术发明者的关系：不管是 Microsoft、 Oracle还是 Computer Associates， NIIT 是首先接受、消化和使用其产品，然后通过学生和专业渠道向外传播。</p> 
        </div>
       </div>
       
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
