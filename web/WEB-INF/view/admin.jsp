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
    <div class="row">
        <h1><strong><em>My-Blog</em></strong></h1>
    </div>
    <div class="row">
        <nav class="navbar navbar-inverse">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">发表博客<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">留言</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">个人中心
                            <span class="caret"></span></a>
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
                    <li>
                        <a data-toggle="modal" href="#register" role="button">注册</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <span class="text-danger">${loginInfo}</span>

            <form action="${contextPath}/admin/login" method="post">
                <div class="form-group">
                    <label for="username">用户名:</label>
                    <input type="text" id="username" name="user.username" class="form-control" required="required"
                           placeholder="邮箱/账号"/>
                </div>
                <div class="form-group">
                    <label for="password">密码:</label>

                    <div class="input-group">
                        <input type="text" id="password" name="user.password" required="required" class="form-control"
                               placeholder="请输入密码"/>
                        <a href="#" class="input-group-addon">忘记密码?</a>
                    </div>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remind">记住登录信息<span class="text-danger">（请勿在公用电脑或者网吧内使用此项）</span>
                    </label>
                </div>
                <button type="submit" class="btn btn-info btn-block">登录</button>
            </form>
        </div>
    </div>


<%-- 注册页面 --%>
    <form action="${contextPath}/admin/register" method="post">
        <div class="modal fade" id="register">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title text-info"><b>用户注册</b></h4>
                    </div>
                    <div class="modal-body form-group">

                        <div class="row">
                            <div class="col-lg-6">
                                <label for="register_username">用户名</label>
                                <input type="text" class="form-control" id="register_username" name="reg.username"
                                       required="required" onblur="checkUserName();" autofocus="true"/>
                                <span class="text-danger" id="register_info"></span>
                            </div>
                            <div class="col-lg-6">
                                <label for="register_password">密码</label>
                                <input type="text" class="form-control" id="register_password" name="reg.password"
                                       required="required"/>
                            </div>
                        </div>
                        <div class="row">&nbsp;</div>
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="register_sex">性别</label>
                                <select name="reg.sex" id="register_sex" class="form-control">
                                    <option value="0" selected>男</option>
                                    <option value="1">女</option>
                                </select>
                            </div>
                            <div class="col-lg-6">
                                <label for="register_email">E-mail</label>
                                <input type="email" id="register_email" class="form-control" name="reg.email"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>


<script src="${contextPath}/js/jquery-2.1.1.js"></script>
<script src="${contextPath}/js/bootstrap.js"></script>
<script>
    function checkUserName() {
        if($("#register_username").val() == '' || $("#register_username").val() == null){
            return;
        }
        $("#register_info").text("");
        $.ajax({
                    url:'${contextPath}/admin/checkUserName?username=' + $("#register_username").val(),
                    async:true,
                    success:function(data){
                        $("#register_info").text(data.checkInfo);

                    },
                    error: function (xhr) {
                        alert(xhr.responseText);
                    }
                }
        );
    }
</script>
</body>
</html>
