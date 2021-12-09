<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/30
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定点击事件
        $(function(){
            $("#btn").click(function(){
                //alert("json");
                //发送ajax请求
                $.ajax({
                   //编写json格式，设置属性和值
                   url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hql","password":"123456","age":23}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data 服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br><br>

    <a href="user/testVoid">testVoid</a>
    <br><br>

    <a href="user/testModelAndView">testModelAndView</a>
    <br><br>

    <a href="user/testMap">testMap</a>
    <br><br>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br><br>

    <button id="btn">发送ajax请求</button>

</body>
</html>
