<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/3/17
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="/css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
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
        <!--			<h2 class="sub-agileits-w3layouts">登录</h2>-->
            <!--
                                <input type="email" name="Eamil" placeholder="用户" required="" />
                                <input type="password" name="Password" placeholder="密码" required="" />
            -->
            <!--					<a href="#" class="forgot-w3layouts">忘记密码 ?</a>-->

            <div class="submit-w3l">
                <form action="/page/login" target="_self" method="post">
                    <input type="hidden" name="identity" value="2"/>
                    <input type="submit" value="研究生登录入口"></form>
            </div>
            <div class="submit-w3l">
                <form action="/page/login" target="_self" method="post">
                    <input type="hidden" name="identity" value="1"/>
                    <input type="submit" value="导师登录入口"></form>
            </div>
            <div class="submit-w3l">
                <form action="/page/register" target="_self">
                    <input type="submit" value="注册"></form>
            </div>

    </div>
</div>
<!--//form-ends-here-->
<!-- copyright -->
<div class="copyright w3-agile">
</div>
<!-- //copyright -->
<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>

</body>
</html>
