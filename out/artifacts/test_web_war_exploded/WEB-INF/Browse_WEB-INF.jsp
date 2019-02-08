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


    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryui/jquery-ui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jqueryui/jquery-ui.js"></script>


</head>
<body>
怎么样访问 WEB-INF里面的静态资源


<br>答 ： 可以通过转发来访问<br>

如果这样操作，跳转后的页面中，想要根据路径访问一些静态资源的写法就要更改一下
<br>${pageContext.request.contextPath}/js/jquery-3.3.1.js

</body>
</html>
