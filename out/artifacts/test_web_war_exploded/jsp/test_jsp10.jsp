<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%--
  Created by IntelliJ IDEA.
  account: Administrator
  Date: 2019/2/6 0006
  Time: 下午 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>一个小案例</title>


    <style type="text/css">
        /* 奇数行 */
        .odd{
            background-color: yellow;
        }

        /* 偶数行 */
        .even{
            background-color: gray;
        }
    </style>
</head>
<body>
<!-- foreach表格案例
	1.存数据到request作用域中
	2.整个表格
 -->
<%
    //集合数据
    List<String> list = new ArrayList<String>();
    list.add("马云");
    list.add("马化腾");
    list.add("有效期");
    list.add("佣兵");
    list.add("男人");
    request.setAttribute("list", list);

	/* for(String name : list){

	} */
%>
<table border="1">
    <tr>
        <td>数据</td>
        <td>索引</td>
        <td>最否第一个</td>
        <td>是否最后一个</td>
        <td>计数</td>
    </tr>
    <!--
        items:写el表达式,一般写作用域数据中的key
        var:放变量名
        varStatus:变量状态
            getIndex 索引，从0 开始
            getCount 计数,从1开始
            isFirst 是否是第一个元素
            isLast  是否是最后个元素
    -->
    <c:forEach items="${list }" var="name" varStatus="vs">
        <tr class="${vs.count % 2 == 0 ? 'even' : 'odd' }">
            <td>${name}</td>
            <td>${vs.index}</td>
            <td>${vs.first}</td>
            <td>${vs.last}</td>
            <td>${vs.count}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
