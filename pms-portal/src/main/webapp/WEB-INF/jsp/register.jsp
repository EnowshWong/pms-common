<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<!--<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>-->
<!-- Custom Theme files -->
<link href="/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="/css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<script src="/js/jquery-1.8.2.min.js"></script>

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
<!--<a href="index.html">登录</a><a href="register.jsp" class="active">注册</a>-->
</div>
<h1>研究生计划管理系统</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<h2 class="sub-agileits-w3layouts">注册</h2>
			<form id="personRegForm" target="_self" method="post" onsubmit="return false;">
					<input type="text" name="username" id="regName" placeholder="用户名" required="" />
					<input type="password" name="password" id="pwd" placeholder="密码" required="" />
					<input type="password" name="repassword" id="pwdRepeat" placeholder="确认密码" required="" />
					<input type="text" name="phone" id="phone" placeholder="手机号" required="" />
					<input type="text" name="email" placeholder="邮箱" />
				<%--这里做个单选按钮，附加个参数identity:1、导师 2、研究生 3、管理员--%>
					<input type="text" name="identity" placeholder="您的身份（研究生，导师，管理员）" required="" />
				<div class="submit-w3l" >
					<input type="button" id="registsubmit" value="注册" onclick="REGISTER.reg();"/>
				</div>
			</form>
		</div>
		</div>

<script type="text/javascript">
    var REGISTER={ //相当于一个类
        param:{
            //单点登录系统的url,当前系统的根路径
            surl:""
        },
        inputcheck:function(){
            //不能为空检查
            if ($("#regName").val() == "") {
                alert("用户名不能为空");
                $("#regName").focus();
                return false;
            }
            if ($("#pwd").val() == "") {
                alert("密码不能为空");
                $("#pwd").focus();
                return false;
            }
            if ($("#phone").val() == "") {
                alert("手机号不能为空");
                $("#phone").focus();
                return false;
            }
            //密码检查
            if ($("#pwd").val() != $("#pwdRepeat").val()) {
                alert("确认密码和密码不一致，请重新输入！");
                $("#pwdRepeat").select();
                $("#pwdRepeat").focus();
                return false;
            }
            return true;
        },
        beforeSubmit:function() {
            //检查用户是否已经被占用
            $.ajax({
                //这里的url后面加入一个随机参数是为了防止浏览器get缓存
                url : REGISTER.param.surl + "/user/check/"+escape($("#regName").val())+"/1?r=" + Math.random(),
                success : function(data) {
                    if (data.data) {
                        //检查手机号是否存在
                        $.ajax({
                            url : REGISTER.param.surl + "/user/check/"+$("#phone").val()+"/2?r=" + Math.random(),
                            success : function(data) {
                                if (data.data) {
                                    REGISTER.doSubmit();
                                } else {
                                    alert("此手机号已经被注册！");
                                    $("#phone").select();
                                }
                            }
                        });
                    } else {
                        alert("此用户名已经被占用，请选择其他用户名");
                        $("#regName").select();
                    }
                }
            });

        },
        doSubmit:function() {
            //表单序列化传给后台
            $.post("/user/register",$("#personRegForm").serialize(), function(data){
                if(data.status == 200){
                    alert('用户注册成功，请登录！');
                    REGISTER.login();
                } else {
                    alert("注册失败！");
                }
            });
        },
        login:function() {
            location.href = "/";
            return false;
        },
        reg:function() {
            if (this.inputcheck()) {
                this.beforeSubmit();
            }
        }
    };
</script>
</body>
</html>