<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

AAAAAAAAAAAAa LESSON15
<!-- 把其它页面的内容导入  1：在翻译时就把两个文件合并
                           2 ： 不会合并文件 ，当代码执行到include ，才会包含另一个文件的内容 -->

<!--1.静态导入(包含)  -->
<%-- <%@ include file="login.jsp"%> --%>

<!-- 2.动态导入 -->
<jsp:include page="login.jsp"></jsp:include>

</body>
</body>
</html>
