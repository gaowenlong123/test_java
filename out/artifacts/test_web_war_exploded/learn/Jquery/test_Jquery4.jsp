<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>

    <script type="text/javascript">
        //onload文档加载完毕再调用js函数
        $(function() {
            //console.log('文档加载完毕...');
            //1.给按钮添加事件
            $('#btn').click(function() {
                /* 一、	添加标签
                 append() - 在被选元素的结尾插入内容
                 prepend() - 在被选元素的开头插入内容
                 after() - 在被选元素之后插入内容
                 before() - 在被选元素之前插入内容

                 删除标签
                 remove() - 删除被选元素（及其子元素）
                 empty() - 从被选元素中删除子元素 */

                //$('ul').append('<li>习进平</li>');
                $('ul').prepend('<li>习进平</li>');
                $('li:eq(2)').after('<li>习进平</li>');
                //$('li:eq(2)').before('<li>习进平</li>');
                //$('li:eq(2)').remove();
                //$('ul').empty();

                /* 	二、	设置或获取html标签的内容
                 text() - 设置或返回所选元素的文本内容,获取的是尖括号的内容
                 html() - 设置或返回所选元素的内容（包括 HTML 标记）
                 val() - 设置或返回表单字段的值 */

                //设置内容
                $('span').text('jquery好强大');

                //获取内容
                //var txt = $('span').text();
                //console.log(txt);

                //获取html的内容
                //console.log($('span').html());

                //获取表单内容
                //var un = $('#username').val();
                //console.log('用户名:' + un);

                //设置表单的内容
                //$('#username').val('guoyongfeng');
                //document.getElementById('username').value = 'xxxx';


                /* 	三、添加属性与获取属性值
                 attr("placeholder","请输入用户名");
                 attr("placeholder"); */

                $('#username').attr('placeholder','请输入用户名');
                console.log($('#username').attr('placeholder'));

                /* 			四、移除属性
                 removeAttr() */
                //$('#username').removeAttr('placeholder');
                //$('#username').val('');
            });
        });

    </script>
</head>
<body>
day16 - 14<br>
<ul>
    <li>林心如</li>
    <li>林志颖</li>
    <li>郭富城</li>
    <li>礼加城</li>
</ul>
<input type="text" name="username" id="username" placeholder="请输入用户名"/>
<span>jquery的使用</span>
<button id="btn">点击</button>
</body>
</html>
