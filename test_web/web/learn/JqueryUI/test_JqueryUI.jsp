<%--
一定要自己多去学习其他一些控件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../js/jqueryui/jquery-ui.css">
    <script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../../js/jqueryui/jquery-ui.js"></script>
    <script type="text/javascript">
        /* jquery的使用步骤：
         1.导入jquery.js文件
         2.导入jqueryui的样式.css
         2.导入jquery-ui.js
         */

        //日期控件
        $(function () {

            /*
             1.年份就是两个yy,不需要4个yy
             2.月：MM是英文,mm是数字
             */

            //给birthday绑定日期控件
            $("#birthday").datepicker({dateFormat:'yy-mm-dd'});
        });

        //弹出提示框
        $(function() {
            //一开始不要显示div

            //添加按钮参数  。定义一个参数 ，该参数是一个按钮数组。
            var params1 = {buttons:[{text:'第一个按钮'},{text:'第二个按钮'}]};
            //在这些按钮上，添加事件监听
            var params1 = {buttons:[{text:'第一个按钮',click:{}},{text:'第二个按钮',click:{}}]};
            //在这些事件监听上 ，加上响应方法
            var params = {buttons:[

                {text:'确定',click:function(){
                    console.log('确定');
                    $("#dialog").dialog('close');
                    //提交到servlet中
                    location.href = '${pageContext.request.contextPath}/DeleteBookById?id=';

                }},

                {text:'取消',click:function(){
                    console.log('取消');
                    $("#dialog").dialog('close');
                }}
            ]};

            //1.给div绑定对话框。绑定确认和取消按钮的参数
            $("#dialog").dialog(params);
            //2.先让提示框默认关闭
            $("#dialog").dialog('close');

            //给按钮绑定事件
            $("#delete").click(function() {
                //再次调用对话框 ， 就会显示出来
                $("#dialog").dialog();
            });

        });

    </script>
</head>
<body>
生日（时期控件）:<input type="text" id="birthday" name="birthday">

<br>-----------------------------------------------------<br>

<div id="dialog" title="删除提示">
    <p>确定要删除 【三国】 这本书?</p>
</div>
<button id="delete">删除</button>

<br>-----------------------------------------------------<br>

</body>
</html>
