<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page errorPage="/err/err.jsp" %>  <%-- 如果报错就跳转到错误页面--%>
<%--
page指令的用法
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //写java代码
    Date date = new Date();
    List<String> list = new ArrayList<String>();

    int i = 10 / 0;

%>
</body>
</html>
