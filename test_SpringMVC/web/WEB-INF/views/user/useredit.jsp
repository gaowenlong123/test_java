<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/14 0014
  Time: 下午 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update.do" method="post">
    用户名:<input type="text" name="username" value="${user.username}"><br>
    年龄:<input type="text" name="password" value="${user.age}"><br>
    性别:<input type="text" name="gender" value="${user.gender}"><br>
    生日:<input type="text" name="birthday" value="${user.birthday}"><br>
    <input type="submit">
</form>
</body>
</html>
