<%@ page import="java.util.Date" %><%--
直接引入java的包
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--在这里可以允许java--%>
<%
    //输出当前日期
    Date date = new Date();
    out.write(date.toString());
    out.write("<br>");
    out.write(this.getServletContext().getRealPath(""));//获取当前项目的路径
%>
</body>
</html>
