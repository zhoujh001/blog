<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/4
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>博客系统</title>
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${contextPath}/css/bootstrap-theme.css"/>
</head>
<body>
<div class="container-fluid">
    <%@include file="head.jsp"%>
    <div class="row">
        <div class="col-md-2 text-center">
            <div style="height: 100px;background-color: green ">
                <div class="row">
                    <div class="col-md-6">
                        <a href="#" class="thumbnail">
                            <img src="${contextPath}/img/headimg.png" alt=""/>
                        </a>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            修改资料
                        </div>
                        <div class="row">
                            跟换头像
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">.col-md-4</div>
        <div class="col-md-2">.col-md-4</div>
    </div>
</div>
<script src="${contextPath}/js/jquery-2.1.1.js"></script>
<script src="${contextPath}/js/bootstrap.js"></script>
<script>

</script>
</body>
</html>
