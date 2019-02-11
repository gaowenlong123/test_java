<%@ page import="com.cxf.model.Book" %>
<%--
  Created by IntelliJ IDEA.
  account: Administrator
  Date: 2019/2/6 0006
  Time: 下午 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<%--转发 --%>
<%--<jsp:forward page="test_jsp.jsp">
    <jsp:param value="gao" name="username"/><!-- jsp:parma 传参数 -->
	<jsp:param value="123" name="password"/>
</jsp:forward>--%>





<%--<jsp:useBean> 创建一个对象
<jsp:setProperty> 给指定的对象属性赋值
<jsp:getProperty> 取出指定对象的属性值 --%>
<%
    Book book1 = new Book();
    book1.setName("JSP入门");
    out.write(book1.getName());
%>
<%--创建一个对象--%>
<jsp:useBean id="book123" class="com.cxf.model.Book"></jsp:useBean>
<%--给对象赋值--%>
<jsp:setProperty property="name" name="book123" value="JSP入门1"/>
<jsp:getProperty property="name" name="book123"/>

</body>
</html>
