<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/6
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查用户是否被占用</title>
    <script src="/js/jquery.min.js"></script>
</head>
<body>
<div>
    <form action="#" method="post">
        <span>请输入用户名:</span>
        <input id="usernameText" type="text" name="username" placeholder="请输入用户名" onchange="checkUsername()">
        <span id="messageSpan"></span>
    </form>
</div>
<script>
    /**
     * 检查用户名是否存在
     */
    function checkUsername() {
        let username = $('#usernameText').val();
        if ('' == username) {
            alert('请填写用户名');
            return;
        }
        $.ajax({
            url: 'check_username',
            type: 'post',
            data: {username: username},
            cache: false,
            dataType: 'json',
            success: function (jsonData) {
                console.info(jsonData);
                if (0!=jsonData.status){
                    alert('检查用户名失败:['+jsonData.message+']')
                    return;
                }
                let count = jsonData.data;
                if (0==count){
                    $('#messageSpan').text('用户名可以使用');
                    $('#messageSpan').css({color:'green'});
                }else if (1 == count)
                {
                    $('#messageSpan').text('用户名已被注册');
                    $('#messageSpan').css({color:'red'});
                }
                else {
                    $('#messageSpan').text('返回服务器数据,产生未知状态');
                    $('#messageSpan').css({color:'red'});
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert('检查用户名是否存在失败,原因:[' + (textStatus || errorThrown) + ']')
            }

        });
    }
</script>
</body>
</html>
