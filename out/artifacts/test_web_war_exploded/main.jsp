<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
欢迎 ${user.username}  进入后台页面 <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
</body>
</html>
