<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/5
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查验证码</title>
    <script src="/js/jquery.min.js"></script>
    <script>
        /**
         * 改变验证码图片
         */
        function changeCodes() {
            $('#codesImg').attr('src', '/get_codes?rd=' + Math.random())
        }

        /**
         * 检查验证码
         */
        function checkCodes() {
            let codes = $('#codesInput').val();
            if ('' == codes) {
                alert('请输入验证码');
                return;
            }
            if (6 != codes.length) {
                alert('验证码位数错误,请输入6位验证码');
                return;
            }
            //发送ajax请求
            $.ajax(
                {
                    url: 'check_codes',   //请求url
                    type: 'POST',           //请求方式
                    cache: false,           //设置不使用ajax页面缓存
                    data: {codes:codes},    //向服务器发送的数据(json格式键值对,键可加''可不加)
                    dataType:'text',        //预期服务器返回的数据类型格式
                    success: function (data) {  //请求成功运行对应匿名函数
                        //changeCodes();  //验证码使用后,重新生成验证码
                        console.info(data); //data,自定义变量名,存放请求成功后,服务器返回的数据
                        if (1==data)
                        {
                            $('#messageSpan').text('验证码正确');
                            $('#messageSpan').css({color:'blue'});
                            changeCodes();
                        }else if (0==data){
                            $('#messageSpan').text('验证码错误');
                            $('#messageSpan').css({color:'red'});
                            changeCodes();
                        }else if (-1==data)
                        {
                            $('#messageSpan').text('缺少验证码参数');
                            $('#messageSpan').css({color:'red'});
                            changeCodes();
                        }else if (-2==data){
                            $('#messageSpan').text('验证码已过期');
                            $('#messageSpan').css({color:'red'});
                            changeCodes();
                        }else{
                            $('#messageSpan').text('检查验证码时,服务器返回未知参数');
                            $('#messageSpan').css({color:'gold'});
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) { //请求失败,运行匿名函数
                        changeCodes();//验证码使用后,重新生成验证码
                        alert('检查验证码请求失败['+textStatus||errorThrown+']');
                    },

                });
        }
    </script>
</head>
<body>
<div>
    <div>
        <img id="codesImg" src="/get_codes"><a href="#" onclick="changeCodes()">看不清,换一换</a>
    </div>
    <div>
        <span>请输入验证码:</span>
        <input id="codesInput" type="text" name="codes" placeholder="请输入验证码" onchange="checkCodes()">
    </div>
    <span id="messageSpan"></span>
</div>

</body>
</html>
