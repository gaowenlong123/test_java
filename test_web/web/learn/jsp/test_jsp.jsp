<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.获取请求参数
    String  username = request.getParameter("username");
    String  password = request.getParameter("password");

    //2.打印数据
    out.write(username + ": " + password);
%>

<%-- jsp 脚本 --%>
<%!
    String s1 ="hhh";
    //表示在类中定义全局变量 ，和静态块
%>

<%
    out.print(s1);//java代码
%>

<%--等价于 out.print(2+3)--%>
<%=2+3 %>

</body>
</html>
