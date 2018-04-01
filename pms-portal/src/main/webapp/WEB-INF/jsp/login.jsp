<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研究生登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="/css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
    <!-- //Custom Theme files -->
    <!-- web font -->
    <!--<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">-->

    <!-- //web font -->
</head>
<body>
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>

<div class="top-buttons-agileinfo">
    <!--<a href="index.html"  class="active">登录</a><a href="register.jsp">注册</a>-->
</div>
<h1>研究生计划管理系统
</h1>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">登录</h2>
        <form id="formlogin" action="/user/login" target="_self" method="post" onsubmit="return false;">
            <input type="text" id="loginname" name="username" placeholder="用户名" required="" />
            <script type="text/javascript">
                setTimeout(function () {
                    if (!$("#loginname").val()) {
                        $("#loginname").get(0).focus();
                    }
                }, 0);
            </script>
            <input type="password" id="nloginpwd" name="password" placeholder="密码" required="" />
            <input type="hidden" id="loginidentity" name="identity" value="${identity}"/>
            <!--					<a href="#" class="forgot-w3layouts">忘记密码 ?</a>-->
            <div class="submit-w3l">
                <input type="button" id="loginsubmit" value="登录"/>
            </div>
        </form>
    </div>
</div>
<!--//form-ends-here-->
<!-- copyright -->
<div class="copyright w3-agile">
</div>

<script type="text/javascript">
    var LOGIN = {
        checkInput:function() {
            if ($("#loginname").val() == "") {
                alert("用户名不能为空");
                $("#loginname").focus();
                return false;
            }
            if ($("#nloginpwd").val() == "") {
                alert("密码不能为空");
                $("#nloginpwd").focus();
                return false;
            }
            return true;
        },
        doLogin:function() {
            $.post("/user/login", $("#formlogin").serialize(),function(data){
                if (data.status == 200) {
                    alert("登录成功！");
                    //如果没有指定的页面，返回首页
                    if ($("#loginidentity").val()==2)
                        location.href = "/user/postGraduate";
                    else if($("#loginidentity").val()==1)
                        location.href="/user/supervisor";
                } else {
                    alert("登录失败，原因是：" + data.msg);
                    $("#loginname").select();
                }
            });
        },
        login:function() {
            if (this.checkInput()) {
                this.doLogin();
            }
        }

    };
    $(function(){
        $("#loginsubmit").click(function(){
            LOGIN.login();
        });
    });
</script>
</body>
</html>