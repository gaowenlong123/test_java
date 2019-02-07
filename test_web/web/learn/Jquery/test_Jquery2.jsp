<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- css的样式表 -->
    <style type="text/css">
        /* css的id选择器,选择器的作用找到相应的标签 */
        #div1{
            width: 100px;
            height: 100px;
            background-color: red;
        }
        #div2{
            width: 100px;
            height: 100px;
            background-color: blue;
        }
    </style>
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>

    <script type="text/javascript">
        //onload文档加载完毕再调用js函数
        $(function () {

            //1.给按钮添加点击事件
            $('#btn').click(function() {
                //组合选择器
                //元素+id选择器
                //这个是连在一起的
                $('span#s1').css('background-color','red');

                //元素+类选择器
                $('span.s2').css('background-color','blue');

                $('div #p1').css('background-color','gray');

                $('div p.p2').css('background-color','yellow');

                //属性选择器
                //$('img').css('border-style','solid');
                //所有的有src属性的标签
                //$('[src]').css('border-style','solid');
                //指定src属性值标签
                //$('[src="./image/002.jpg"]').css('border-style','solid');

                //指定结尾
                //$('[src$=".png"]').css('border-style','solid');
                $("[src$='.png']").css('border-style','solid');
            });
        });



    </script>
</head>
<body>
<div src="xx">
    <span id="s1" >span1</span>
    <span class="s2">span2</span>
</div>

<div>
    <p id="p1">段落1</p>
    <p class="p2">段落2</p>
</div>
<img alt="" src="../../image/001.jpg" width="100px" height="100px">
<img alt="" src="../../image/002.jpg" width="100px" height="100px">
<img alt="" src="../../image/003.png" width="100px" height="100px">
<button id="btn">点击</button>
</body>
</html>
