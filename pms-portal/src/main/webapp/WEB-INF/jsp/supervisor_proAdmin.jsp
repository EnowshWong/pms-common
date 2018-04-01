<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目管理</title>
    <link href="/css/style1.css" type="text/css" rel="stylesheet" />
    <script src="/js/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script src="/js/Index.js" type="text/javascript"></script>
    
    <link href="/css/style_proAdmin.css" rel="stylesheet">
    
</head>
<body>
    <div class="headCenter" id="headCenter">
        <div class="headMenu" id="headMenu">
        </div>
        <div class="index_top_out">
            <div class="index_top">
                <div class="index_nav">
                    <ul>
                        <li><a href="supervisor.html">首页</a> </li>
                        <li class="cur"><a href="supervisor_proAdmin.jsp">项目管理</a> </li>
                        <li><a href="supervisor_planAdmin.html">计划管理</a> </li>
                        <li><a href="supervisor_judgeInfo.html">总评信息</a> </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
      
<div class="xt-center">
<div id="xt-left">
    <div class="xt-logo"></div>
    <div class="xt-menu">
        <ul>
            <li><a href="supervisor_proAdmin.jsp" class="hover"><em class="one"></em>基础信息</a></li>
        </ul>
        <div class="xt-menu-list"></div>
        <ul>
            <li><a href="supervisor_proAdmin_publishPro.html"><em class="three"></em>创建项目</a></li>
        </ul>
    </div>
</div>
<!-- right -->
<div id="xt-right">
    <div class="xt-bt">导师页面 > 项目管理 > 基础信息 </div>
       <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
            <th width="23%">项目名称</th>
            <th width="23%">项目描述</th>
            <th width="23%">起始时间</th>
            <th width="23%">截止时间</th>
            </tr>
            <c:forEach items="${page.lists}" var="project">
                <tr class="xt-bg">
                    <td>${project.projectName}</td>
                    <td>${project.projectDesc}</td>
                    <td>${project.created.toLocaleString()}</td>
                    <td>${project.expired.toLocaleString()}</td>
			    </tr>
            </c:forEach>
        </table>
    </div>
    <div class="xt-fenye">
        <div class="xt-fenye-left">当前第 ${page.currPage} / ${page.totalPage} 页,每页${page.pageSize}条，共 ${page.totalCount}条</div>
        <div class="xt-fenye-right">
            <c:if test="${page.currPage!=1}">
            <a href="${pageContext.request.contextPath}/project/show?currPage=1">首页</a>
            <a href="${pageContext.request.contextPath}/project/show?currPage=${page.currPage-1}">上一页</a>
            </c:if>
            <c:if test="${page.currPage!=page.totalPage}">
            <a href="${pageContext.request.contextPath}/project/show?currPage=${page.currPage+1}">下一页</a>
            <a href="${pageContext.request.contextPath}/project/show?currPage=${page.totalPage}">尾页</a>
            </c:if>
        </div>
    </div>
</div>
</div>

       </body>
</html>
