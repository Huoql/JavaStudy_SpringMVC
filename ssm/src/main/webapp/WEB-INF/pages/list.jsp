<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/16
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>查询所有的账户信息</h3>

    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>money</td>
        </tr>
    <c:forEach items="${list}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.name}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>
