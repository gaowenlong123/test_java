<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/14 0014
  Time: 下午 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script>
        function register() {

            //表单提交
            var url = '${pageContext.request.contextPath}/json/save.do';

            //自己定义json格式
            var username = $('#name').val();
            var sex = $('#sex').val();
            var jsonObj = {username:username,sex:sex};

            var paramters = JSON.stringify(jsonObj);

            console.log(jsonObj);
            console.log(paramters);

            $.ajax({
                type:'post',
                url:url,
                contentType:'application/json;charset=utf-8',
                data:paramters,
                success:function (respData) {
                    console.log('resp'+respData);
                }
            })
        }
    </script>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/json/save2.do" method="post">
    用户名:<input id="name" type="text" name="username"><br>
    性别:<input id="sex" type="text" name="sex"><br>
    <input type="button" value="提交json" onclick="register()">
    <input type="submit" value="表格提交">
</form>
</body>
</html>
