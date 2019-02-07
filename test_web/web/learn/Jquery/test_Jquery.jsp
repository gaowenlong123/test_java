<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">

        //onload文档加载完毕再调用js函数
        /* window.onload = function () {
         var divTag = document.getElementById('div1');
         divTag.innerHTML = "你好。很高兴认你！";
         } */
        //常用的是下面一种
        /*   $(document).ready(function () {
         var divTag = document.getElementById('div1');
         divTag.innerHTML = "你好。很高兴认你！";
         });*/


        //jquery文档就绪函数 $(function(){});
         $(function() {
         var divTag = document.getElementById('div1');
         divTag.innerHTML = "你好。很高兴认你1！";
         });



        //onload文档加载完毕再调用js函数
        //掌握:   $(selector).action
        //1.jquery的id选择器
        //2.通过id选择器找到元素，可以绑定事件/动作
        //3.通过id选择器找到元素,可以改变样式
        $(function () {
            //1.给按钮添加点击事件
            $('#btn').click(function() {
                    //
            });
        });
    </script>


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

    <script type="text/javascript">
        //onload文档加载完毕再调用js函数

        $(function () {
            //1.给按钮添加点击事件
            $('#btn').click(function() {
                //alert("xx");
                //元素选择器
                //$('div').width(200);
                //$('div').height(200);

                //类选择器
                $('.mydiv1').width(200);
                $('.mydiv1').height(200);
            });
        });

        $(function () {
            //1.给按钮添加点击事件
            $('#dbbtn').dblclick(function() {
                //jquery控制css
                //设置div的样式
                /* $('#div1').width(200);
                 $('#div1').height(200); */
                /* $('#div1').css('width',200);
                 $('#div1').css('height',200);
                 $('#div1').css('background-color','red'); */

                //另一种简便写法
                $('#div3').css({'width':200,'height':200,'background-color':'red'});
            });
        });

    </script>
</head>
<body>
<div id="div1" class="mydiv1"></div>
<div id="div2"></div>
<button id="btn">点击</button>

<div id="div3"></div>
<button id="dbbtn">双点击</button>
</body>
</html>
