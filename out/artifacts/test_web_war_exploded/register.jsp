<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    <table border="1">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" value="${uf.username}">
                <font color="red">${uf.err['username'] }</font></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <input type="password" name="password" value="${uf.password}">
                <font color="red">${uf.err['password'] }</font>
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="repassword" value="${uf.repassword}">
                <font color="red">${uf.err['repassword'] }</font>
            </td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" name="email" value="${uf.email}">
                <font color="red">${uf.err['email'] }</font>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday" value="${uf.birthday}">
                <font color="red">${uf.err['birthday'] }</font>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册 ">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
