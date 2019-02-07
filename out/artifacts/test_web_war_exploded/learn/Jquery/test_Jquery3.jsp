<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>

    <script type="text/javascript">
        //onload文档加载完毕再调用js函数

        $(function () {
            //1.给按钮添加点击事件
            $('#btn').click(function() {
                /* 			普通筛选
                 :first 第1个
                 :last 最后1个
                 :eq(index) 指定索引
                 :even 偶数
                 :odd 奇数
                 :lt(index)小于
                 :gt(index)大于
                 :not(selector) 排除 */

//                $('li').css('background-color','yellow');
                $('li:first').css('background-color','yellow');
                $('li:last').css('background-color','yellow');
//                $('li:eq(1)').css('background-color','yellow');
//                $('li:even').css('background-color','yellow');
//                $('li:odd').css('background-color','yellow');
//                $('li:gt(2)').css('background-color','yellow');
//                $('li:not(".show")').css('background-color','yellow');

                //查找筛选:方法
                //parent([expr]) 父标签
                //siblings([expr]) 排除同一级当前标签
                //$('.show').parent().css('background-color','yellow');
                //$('li:eq(3)').siblings().css('background-color','yellow');
            });
        });



    </script>
</head>
<body>
day16 - 12<br>
<ul>
    <li >Java基础从入门到精通</li>
    <li>JavaWeb从入门到精通</li>
    <li class='show'>J2EE框架从入门到精通</li>
    <li>MySql数据库从入门到精通</li>
</ul>
<button id="btn">点击</button>
</body>
</html>
