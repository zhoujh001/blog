<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/9
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="row">
  <h1><strong><em>My-Blog</em></strong></h1>
</div>
<div id="topbar" class="row">
  <nav class="navbar navbar-inverse">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath}/">首页</a></li>
        <li><a href="#">发表博客<span class="sr-only">(current)</span></a></li>
        <li><a href="#">留言</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">个人中心
            <span class="caret"></span><!-- 下拉列表的倒三角 -->
          </a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">空间</a></li>
            <li><a href="#">我的博客</a></li>
            <li><a href="#">设置</a></li>
          </ul>
        </li>
      </ul>

      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="热门话题...">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>

      <ul class="nav navbar-nav navbar-right">
        <c:if test="${login_user.username != null}">
          <li><span class="navbar-text">欢迎您：${login_user.username}</span></li>
          <li>
            <a href="${contextPath}/admin/loginOut">退出</a>
          </li>
        </c:if>
        <c:if test="${login_user.username == null}">
          <li><a href="${contextPath}/admin">登录</a></li>
        </c:if>
      </ul>
    </div>
  </nav>
</div>
</body>
</html>
