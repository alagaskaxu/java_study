<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/6
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中国行政地区</title>
    <style>
        select {
            width: 280px;
            height: 35px;
            border-radius: 5px;
        }
    </style>
    <script src="/js/jquery.min.js"></script>
    <script>
        //网页加载完后再加载 $(function(){  })
        $(function () {
            //加载省份数据
            $.ajax({
                url: '/zone/data/province',
                type: 'get',
                cache: false,
                dataType: 'json',
                success: function (jsonData) {
                    if (0 != jsonData.status) {
                        alert(jsonData.message);
                        return;
                    }
                    let provinceList = jsonData.data;
                    // if (0 == provinceList.length){},List为空
                    if ($.isEmptyObject(provinceList)) {
                        alert('未加载到省份数据');
                        return;
                    }
                    provinceList.forEach(function (p) {
                        let name = p.name;
                        let provId = p.proId;
                        $('#provinceSelect').append('<option value="' + provId + '">' + name + '</option>');
                    });
                    loadCityData();
                },
                error: function () {
                    alert('加载省份数据失败');
                }
            });
            $('#provinceSelect').change(function () {
                loadCityData();
            });
            $('#citySelect').change(function () {
                loadCountyData();
            })
        });

        /**
         * 根据省份Id加载地级市数据
         * @param provId
         */
        function loadCityData() {
            //清空列表
            $('#citySelect').empty();
            let provId = $('#provinceSelect').val();
            $.ajax({
                url: '/zone/data/city',
                type: 'get',
                cache: false,
                data: {provId: provId},
                dataType: 'json',
                success: function (jsonData) {
                    if (0 != jsonData.status) {
                        alert(jsonData.message);
                        return;
                    }
                    let cityList = jsonData.data;
                    if ($.isEmptyObject(cityList)) {
                        alert('未加载到地级市数据');
                        return;
                    }
                    cityList.forEach(function (c) {
                        let name = c.name;
                        let cityId = c.cityId;
                        $('#citySelect').append('<option value="' + cityId + '">' + name + '</option>');
                    });
                    loadCountyData();
                },
                error: function () {
                    alert('加载地级市数据失败');
                }
            });

        }

        /**
         * 根据地级市ID加载县级市数据
         */
        function loadCountyData() {
            //清空列表
            $('#countySelect').empty();
            let cityId = $('#citySelect').val();
            $.ajax({
                url: '/zone/data/county',
                type: 'get',
                cache: false,
                data: {cityId: cityId},
                dataType: 'json',
                success: function (jsonData) {
                    if (0 != jsonData.status) {
                        alert(jsonData.message);
                        return;
                    }
                    let countyList = jsonData.data;
                    if ($.isEmptyObject(countyList)) {
                        alert('未加载到县级市数据');
                        return;
                    }
                    countyList.forEach(function (c) {
                        let name = c.name;
                        let countyId = c.countyId;
                        $('#countySelect').append('<option value="' + countyId + '">' + name + '</option>');
                    });
                },
                error: function () {
                    alert('加载县级市数据失败');
                }
            });
        }
    </script>
</head>
<body>
<div>
    <div><span>省份:</span><select id="provinceSelect"></select></div>
    <div><span>地级市:</span><select id="citySelect"></select></div>
    <div><span>区级市:</span><select id="countySelect"></select></div>
</div>
<script></script>
</body>
</html>
