<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/3 0003
  Time: 下午 15:18
  To change this template use File | Settings | File Templates.
--%>
<%--   %@ = jsp的标识  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
index.jsp<br>
<!-- <a href="login.jsp">登录</a>
<a href="register.jsp">注册</a> -->
<!-- 一般情况都会有超连接前面加个项目名称 -->
<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
<a href="${pageContext.request.contextPath}/register.jsp">注册</a>
  </body>
</html>
