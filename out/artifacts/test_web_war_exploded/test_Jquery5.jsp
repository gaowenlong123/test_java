<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function() {

            //1.按钮绑定事件
            $(function() {
                //1.按钮绑定事件
                $('#loginBtn').click(function() {
                    //$("form").serialize();生成一个字符串,各参数用&符号拼接
                    var v = $('form').serialize();
                    console.log(v);

                    //$("form").serializeArray();将参数生成一个数组对象
                    var v = $("form").serializeArray();
                    console.log(v);
                });
            });
        });
    </script>
</head>
<body>
<span style="color: red" id="tip"></span>
<form>
    用户名: <input type="text" name="username" id="username"><br>
    密码:<input type="password" name="password" id="password"><br>
    <input type="button" value="登录" id='loginBtn'>
</form>
</body>
</html>
