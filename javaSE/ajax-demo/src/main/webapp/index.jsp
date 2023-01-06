<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>AJAX简单案例</title>
</head>
<body>
<div>
  <form action="#">
    <span>请输入名字:</span>
    <input type="text" name="name" onchange="sendName(this.value)"/>
    <button type="button" onclick="sendName(document.getElementsByName('name')[0].value)">提交</button>
  </form>
  <form action="/ajax/test" method="get">
    <span>请输入名字:</span>
    <input type="text" name="name"/>
    <button>提交</button>
  </form>
  <script>
    function sendName(name){
      console.info(name);
      let xmlHttpRequest = new XMLHttpRequest();
      console.info("----open前---")
      console.info(xmlHttpRequest.readyState);
      //打开资源,定位服务器资源路径,还没向服务器发送请求
      xmlHttpRequest.open('GET','/ajax/test?name='+name);
      console.info("----open后---")
      console.info(xmlHttpRequest.readyState);
      //onreadystatechange 写在send发送前,防止send发送完后readyState=4后不变了,导致无法触发该函数方法
      xmlHttpRequest.onreadystatechange=function () {
        if (4 == xmlHttpRequest.readyState && 200 == xmlHttpRequest.status)
        {
          //获取服务器返回的数据
          console.info('====服务器响应的数据====');
          console.info('-------html格式------');
          let text = xmlHttpRequest.responseText; //获取html文本格式的数据
          console.info(text);

          console.info('-------xml格式------');
          let xml = xmlHttpRequest.responseXML; //获取xml格式的数据
          console.info(xml);
          console.info('========');
        }
      };
      //向服务器发送请求,请求返回对应资源
      xmlHttpRequest.send(null);
      console.info("----send---")
      console.info(xmlHttpRequest.readyState);

    }
  </script>
</div>
</body>
</html>