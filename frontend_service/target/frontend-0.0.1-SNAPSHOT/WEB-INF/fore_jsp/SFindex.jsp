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
<script type="text/javascript" src="js/cyfw.js"></script>

</head>

<body>

 <div id="head">
 
  <!-- 头部 -->
  <div class="wrapper clear margin height">
   <div class="logo left">
    <a>
     <img src="images/logo.png" />
     <span>在线教学系统</span>
     <p>NIIT Online Teaching System</p>
    </a>
   </div>
   <div class="headR tr mt right">
  <!-- <div class="headRset f14 clear ">
     <a href="#" title="修改密码" class="h_r03">&nbsp;</a><a href="#" title="信息" class="h_r02">&nbsp;</a>
     <a href="#">退出</a><span class="right">张晓明，欢迎您！</span>
    </div>-->
    <script>
    	function dengLu(){
    		location.href= "jspf/UserLogin.jsp";
    	}
    </script>
   <div class="headRset f14 clear dis">
     <div class="loginipt left">&nbsp;&nbsp;<input type="button" class="button" value="登录" style="margin-left:360px;" onclick="dengLu()"/></div>
     <a href="#" title="修改密码" class="h_r03">&nbsp;</a><a href="#" title="信息" class="h_r02">&nbsp;</a>
    </div>
    <div class="headRfast f12 clear">
     <a href="jspf/fAnnounceListStudent.jsp" title="建言献策" class="h_f03">建言献策</a>
     <a href="jspf/fAnnounceListStudent.jsp" title="网站公告" class="h_f01">网站公告</a>
    </div>
   </div>
  </div>
  
  <!-- 导航 -->
  <!--<div id="navmenu" class="wrapper clear margin01">
   <a class="n_m01" href="#">首页</a>
   <a href="#">通知公告</a>
   <a href="#">办事大厅</a>
   <a href="#">应用系统</a>
   <a href="#">常用服务</a>
   <a href="#">师生心声</a>
   <a href="#">管理模块</a>
  </div>-->
 </div>
 <div class="clearfix"></div>
 <!-- 管理中心 -->
 <div id="management">
  <div class="wrapper margin clear">
  
   <!-- 头像 -->
   <div class="tearch left clear">
    <div class="user left">
     <div class="zhehead"><img src="images/zhehead.png" /></div>
     <div class="userhead"><img src="images/touxiang.png" /></div>
    </div>
    <div class="userInfor left f14">
     <strong>学号：</strong>${loginUser.stuno}<br />
     <strong>姓名：</strong>${loginUser.stuName}<br />
     <strong>班级：</strong>${loginUser.classname}
    </div>
   </div>
   
   <!-- 消息 -->
   <div class="message right f14 clear fbold">
    <a class="mess_09" href="jspf/MessageListStudent.jsp" title="">我的消息(<span class="orange">0</span>)</a>
    <a class="mess_01" href="jspf/MessageListStudent.jsp" title="">发送消息(<span class="orange">10</span>)</a>
    <a class="mess_02" href="jspf/resListStudent.jsp" title="">我的课件(<span class="orange">3</span>)</a>
    <a class="mess_04" href="jspf/workListStudent.jsp" title="">我的作业(<span class="orange">8</span>)</a>
    <a class="mess_03" href="/Team3_ZXJY/classChose" title="">查询已选课程(<span class="orange">8</span>)</a>
   
   </div>
  </div>
 </div>
 
 <div class="wrapper margin clear">
 
  <!-- 通知公告 -->
  <div class="module wmodule left">
   <div class="moduleT clear"><span class="left">通知公告</span><a class="right" href="#">> 更多</a></div>
   <ul class="notic f12">
    <li><a href="#">关于2014年全国教育系统先进集体等推荐结果公示</a><span>2014-10-31</span></li>
    <li><a href="#">关于2014年学院微课教学比赛选拔结果的公示</a><span>2014-10-31</span></li>
    <li><a href="#">关于办公室暑期值班安排的通知</a><span>2014-10-31</span></li>
    <li><a href="#">关于转发市经信委市科教城关于选拔、资助优秀创新人才攻读工程...</a><span>2014-10-31</span></li>
    <li><a href="#">暑期“师生心声”栏目处理须知</a><span>2014-10-31</span></li>
    <li><a href="#">教学名师奖评审推荐结果公示</a><span>2014-10-31</span></li>
   </ul>
  </div>
  
  <!-- 常用服务 -->
  <div class="module wmodule right" style="height:182px;">
   <div class="moduleT clear"><span class="left">常用服务</span><a class="right" href="javascript:void(0);" data-reveal-id="myModal">> 更多</a>
   
   </div>
   <div class="servicebox">
	<div class="serviceboxbleft">
	 <div class="serviceboxbcon">
	  <ul class="serviceboxlist1">
	   <li><a href="jspf/MessageListStudent.jsp"><img src="images/through_05.png" />消息管理</a></li>
	   <li><a href="jspf/resListStudent.jsp"><img src="images/ky_04.png" />课件管理</a></li>
	   <li><a href="jspf/workListStudent.jsp"><img src="images/xz_07.png" />作业管理</a></li>
	   <li><a href="/Team3_ZXJY/classChose"><img src="images/menage_11.png" />我的课程</a></li>
	  <!--  <li><a href="#"><img src="images/through_07.png" />提出问题</a></li>--> 
	  </ul>
	  <ul class="serviceboxlist1">
	   <li><a href="/Team3_ZXJY/jspf/releaseList.jsp"><img src="images/zk_03.png" />问卷调查</a></li>
	  </ul>
	 </div>
     <div id="serviceboxlist_mark1" class="serviceboxbconspan"><em></em><em></em></div>
	</div>
   </div>
  </div>
 </div>
 
 <div class="clearfix" ></div>
 
<!-- 最新消息 -->
<div class="wrapper margin01 clear">
 
  <div class="module">
   <div class="moduleT clear"><span class="left">最新消息</span><a class="right" href="#">> 更多</a></div>
  
    <div class="satList">
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="satTable">
      <tr>
    <th width="40%">消息内容</th>
    <th width="15%">发送者</th>
    <th width="16%">2015-09-08</th>
    <th width="16%">消息状态</th>
    <th width="14%" style="border:none;">操作</th>
  </tr>
  <tr>
    <td width="40%">你好，我是某某，有个问题请教您！</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="16%" class="red">未读</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
  <tr>
    <td width="40%">你好，我是某某，有个问题请教您！</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="16%" class="red">未读</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="16%">已读</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">你好，我是某某，有个问题请教您！</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="16%">已读</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="16%" >已读</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
  
</table>

   </div>
  </div>
  
</div>
 <!-- 最新上传课件 -->

<div class="wrapper margin01 clear">
 
  <div class="module">
   <div class="moduleT clear"><span class="left">新上传课件</span><a class="right" href="#">> 更多</a></div>
  
    <div class="satList">
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="satTable">
   <tr>
    <th width="40%">课件名称</th>
    <th width="15%">上传教师</th>
    <th width="16%">上传时间</th>
    <th width="16%">下载数量</th>
    <th width="14%" style="border:none;">操作</th>
  </tr>
  <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="15%">8</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="15%">8</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="15%">8</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="15%">8</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
   <tr>
    <td width="40%">java第一阶段教学视频</td>
    <td width="15%">张三三</td>
    <td width="16%">2015-09-08</td>
    <td width="15%">8</td>
    <td width="14%"><a href="#">查看详情</a></td>
  </tr>
</table>

   </div>
  </div>
  
</div>

 <!-- 底部 -->
 <div id="footer" class="gray tc f12 mt20">
  © 2015 无锡市安艾艾迪服务外包培训学校 版权所有 All rights reserved.
<br />

 </div>
 
  <!-- 代码 开始 -->

<!-- 代码 结束 -->
</body>
</html>
