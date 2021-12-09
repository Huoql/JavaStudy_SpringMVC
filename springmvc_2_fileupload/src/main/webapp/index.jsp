<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/31
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>传统方式文件上传</h3>

    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br><br>

    <h3>基于SpringMVC实现文件上传</h3>

    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br><br>

    <h3>基于SpringMVC跨服务器文件上传</h3>

    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br><br>

</body>
</html>
