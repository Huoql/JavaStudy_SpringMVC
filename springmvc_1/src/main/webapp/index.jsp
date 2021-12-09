<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/30
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>

    <a href="user/hello">入门程序</a>
    <br><br>

    <a href="user/testRequestMapping?username=heihei">RequestMapping注解</a>
    <br><br>

    <%--请求参数绑定--%>
    <a href="param/testParam?username=hql&password=123">请求参数绑定</a>
    <br><br>

    <%--请求参数绑定实体类型，把数据封装到Account类中--%>
    <%--<form action="param/saveAccount" method="POST">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>
        用户姓名：<input type="text" name="user.uname"><br>
        用户年龄：<input type="text" name="user.age"><br>
        <input type="submit" value="提交"/>
    </form>
    <br><br>--%>

    <%--把数据封装到Account类中，类中存在List和Map集合--%>
    <form action="param/saveAccount" method="POST">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>

        用户姓名：<input type="text" name="list[0].uname"><br>
        用户年龄：<input type="text" name="list[0].age"><br>

        用户姓名：<input type="text" name="map['one'].uname"><br>
        用户年龄：<input type="text" name="map['one'].age"><br>

        <input type="submit" value="提交"/>
    </form>
    <br><br>

    <form action="param/saveUser" method="POST">

        用户姓名：<input type="text" name="uname"><br>
        用户年龄：<input type="text" name="age"><br>
        用户生日：<input type="text" name="date"><br>

        <input type="submit" value="提交"/>
    </form>
    <br><br>

    <a href="param/testServletAPI">ServletAPI</a>
    <br><br>

    <h3>常用注解</h3>

    <a href="anno/testRequestParam?uname=哈哈">RequestParam注解</a>
    <br><br>

    <form action="anno/testRequestBody" method="post">
        用户名称：<input type="text" name="username"><br/>
        用户年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
    <br><br>

    <a href="anno/testPathVariable/10">PathVariable注解</a>
    <br><br>

    <a href="anno/testRequestHeader">RequestHeader注解</a>
    <br><br>

    <a href="anno/testCookieValue">CookieValue注解</a>
    <br><br>

    <form action="anno/testModelAttribute" method="post">
        用户名称：<input type="text" name="uname"><br/>
        用户年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
    <br><br>

    <a href="anno/testSessionAttributes">SessionAttributes注解</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>
    <br><br>
</body>
</html>
