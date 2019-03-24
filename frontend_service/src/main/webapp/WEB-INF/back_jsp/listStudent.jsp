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
<script type="text/javascript">
function updateStu(){
	var cks = $(":checked");
		var params= "o=x";
		if($(cks[0]).val()==undefined||$(cks[i]).length>=1){alert("请选择学生（只能选择一个）");return;}
		for(var i = 0;i<cks.length;i++){
			if($(cks[i]).attr("type")=='checkbox' && $(cks[i]).attr("name")=='stuId'){
				
				params+="&stuId="+$(cks[i]).val();
				
		};
	
}
		var url = "/Team3_ZXJY/updateStudent?"+params;
		
		location.href=url;
		//location.href="/Team3_ZXJY/jspb/update.jsp?stuNo="+stuNo;
}

$(document).ready(function(){
	alert($(pager.pageNum));
}) 

</script>
</head>
<body>
 <div class="btnSearch ">
           <input type="button" onclick="javascript:window.location.href='/Team3_ZXJY/jspb/addStudent.jsp'" value="增加" class="btn" />
           <input type="button" onclick="updateStu()" value="编辑" class="btn" />
           <!-- 
           <input type="button" onclick="javascript:window.location.href='/Team3_ZXJY/update.jsp?stuid="+${stu.stuId}  value="删除" class="btn" />
            -->
            <script type="text/javascript">
            function checkAll(checkbox){
            	if(checkbox.checked){
            		$('input[type=checkbox]').attr('checked', true);
            	}else{
            		$('input[type=checkbox]').attr('checked', false);
            	}
            	}
            
            	function deleteStu(){
            		//获取选中学生的编号
            		var cks = $(":checked");
            		if(cks.length==0){
            			return;
            		}
            		var params= "o=x";
            		for(var i = 0;i<cks.length;i++){
            			if($(cks[i]).attr("type")=='checkbox' && $(cks[i]).attr("name")=='stuId'){
            				//alert($(cks[i]).val());
            				params+="&stuId="+$(cks[i]).val();
            			}
            		};
            		
            		var url = "/Team3_ZXJY/deleteStudent?"+params;
            		if(confirm("您确定删除吗?")){
            			location.href=url;
            		}
            		//跳转
            		//location.href=url;
            				//String [] stuIds = request.getParameterValues("stuId");
            	}
            </script>
            <input type="button" onclick="deleteStu()" value="删除" class="btn" />
          </div>

<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="tablelist f14" style="width:100%;">
                                  <thead>
                                  <tr>
                                  	<th width="149"><input class='d2' id="stu" name="" type="checkbox" value="stu" onclick="checkAll(this)" /></th>
                                    <th width="149">姓名</th>
                                    <th width="101">工号</th>
                                    <th width="136">班级</th>
                                    <th width="107">工作单位</th>
                                    <th width="103">专业领域2</th>
                                    <th width="83">专业技术职称</th>
                                    </tr>
                                  </thead>
             			<c:forEach items="${pager.data}" var="stu">
                                  <tbody>
                                  <tr>                        
                                    <td><input name="stuId" type="checkbox" value="${stu.stuId}" /></td>
                                    <td>${stu.stuName}</td> 
                                    <td>${stu.stuno}</td>
                                    <td>${stu.classname}</td>
                                    <td>NIIT</td>
                                    <td></td> 
                                    <td></td> 
                                    </tr>
                                 </c:forEach>
                                  
                                  </tbody>
                                </table>
                                <!---分页----->
                                     <div class="paginationBox clear  mt20" >
                                      <c:if test="${pager.pageNum==1}">
                                      <span ><input disabled="disabled" type="button" id='aa2' class="active" onclick="doSub(${pager.pageNum-1})" title="上一页" value="上一页" /></span>
                                      </c:if>
                                       <c:if test="${pager.pageNum!=1}">
                                      <span ><input  type="button" id='aa2' class="active" onclick="doSub(${pager.pageNum-1})" title="上一页" value="上一页" /></span>
                                      </c:if>
                                      <c:forEach  var="item" varStatus="status" begin="1" end="${pager.maxPageNum}">
 										<span ><a yangshi="1" href="javascript:doSub(${status.index })" title="${status.index+1}" >${status.index }</a></span>
 										</c:forEach>
                                      <c:if test="${pager.pageNum>=pager.maxPageNum}">
                                      <span ><input disabled="disabled" type="button" id='aa2' class="active" onclick="doSub(${pager.pageNum+1})" title="下一页" value="下一页" />当前页面： 第<a>${pager.pageNum}</a></span>
                                      </c:if>
                                       <c:if test="${pager.pageNum<pager.maxPageNum}">
                                      <span ><input  type="button" id='aa2' class="active" onclick="doSub(${pager.pageNum+1})" title="下一页" value="下一页" /></span>
                                      </c:if>
                                     </div>
</body>
</html>