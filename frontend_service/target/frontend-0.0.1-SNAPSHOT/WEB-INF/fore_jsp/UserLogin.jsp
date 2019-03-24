<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getServletContext().getContextPath()+"/" %>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登陆界面 </title>
    <style>#ts, #yz {
        display: none
    }</style>
    <link rel=stylesheet type=text/css href="css/base.css">
    <link rel=stylesheet type=text/css href="css/login.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/serialize.js"></script>
</head>

<body>
<form>
    <table style="height:100%;width:100%;margin-top: 110px;">
        <tbody>
        <tr>
            <td>
                <div class="login_page" style="position: relative;">

                    <!-- banner -->
                    <div id="content" class="wrapperlogin margin relative">
                        <div class="logincontent" style="height:390px">
                            <div class="relative loginconbg">
                                <div class="logo clear">
                                    <div class="left logotext">
                                        <span>尚学在线教学系统</span>
                                        <p> Online Teaching System</p>
                                    </div>
                                </div>
                                <div class="loginbox" style="height:340px">
                                    <div class="ltitle tc"><span class="title">用户登录</span><span class="titleEng">UserLogin</span>
                                    </div>
                                    <div class="orange f12 tc lh26 mb"
                                         style="display:<%=request.getAttribute("error") %>" id="ts">
                                        <c:choose>
                                            <c:when test="${TiShi== null }">
                                                用户名或者密碼错误
                                            </c:when>
                                            <c:otherwise>
                                                ${TiShi }
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="orange f12 tc lh26 mb" style="display:<%="" %>" id="yz">验证码错误</div>
                                    <div class="ltext tc">
                                        <div class="Linput">
                                            <input type="text" name="userNumber" class="input name"/>
                                        </div>
                                        <div class="Linput">
                                            <input type="password" name="passward" class="input password"/>
                                        </div>

                                        <div class="Linput">
                                            <span style="color:white;">验证码：</span><input type='text' name='code'
                                                                                         id='code'
                                                                                         style="background-color:white;width:100px;"/>
                                            <script type="text/javascript">
                                                //通过jquery的AJAX验证验证是否正确
                                                $("#code").blur(function () {
                                                    $.post("checkCode", {code: $("#code").val()}, function (result) {
                                                        if (result == 0) {
                                                            alert("验证码出错");
                                                        }
                                                    });
                                                });

                                                //刷新验证码
                                                function flushCode() {
                                                    //alert($("#codei").attr('src'));
                                                    $("#codei").attr('src', 'code?f=' + new Date().getTime());
                                                }
                                            </script>
                                            <img id='codei' src='code' onclick="flushCode()"/><a
                                                href="javascript:flushCode()" style="color:white;">点击刷新</a>

                                        </div>
                                        <div>用户角色
                                            <input type="radio" name="userType" value="1">老师
                                            <input type="radio" name="userType" value="0">学生
                                        </div>
                                        <div class="Linput"><input class="button white f22" name="in" id="doLogin" type="button"
                                                                   style="height:50px" value="登 录"/></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 底部 -->
                        <div id="infoot" class="tc">© 2014 迈尔斯通综合管理与服务平台 版权所有 All rights reserved. 严禁抄袭 违者必究<br/>
                            Designed by Wuxi Milestone Software Development Co.,Ltd.
                        </div>
                    </div>

                </div>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<script type="application/javascript">
    // 发送表单ajax请求
    $('#doLogin').on('click', function () {
        console.log("star");

        $.ajax({
            url: "login/doLogin",
            type: "POST",
            async: false,
            data: JSON.stringify($('form').serializeObject()),
            // 缺失会出现URL编码，无法转成json对象
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                console.log("end");
                console.log(data);
                console.log(data.msg);
                if (data.loginStatus) {
                    alert("登录成功");
                    // TODO 此处跳转到登陆后页面
                } else {
                    alert("登录失败，" + data.msg);
                }
            }
        });
    });
</script>
</body>
</html>