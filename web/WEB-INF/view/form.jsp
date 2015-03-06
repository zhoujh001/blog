<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/4
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加blog</title>
</head>
<body>
<form action="/save" method="post">
  <input type="hidden" name="blog.id" value="${blog.id}"/>
  标题：<input type="text" name="blog.title" value="${blog.title}"><br>
  内容：<textarea cols="80" rows="10" name="blog.content">${blog.content}</textarea><br>
  <input type="submit" value="保存"/>
</form>
</body>
</html>
