<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 17/9/28
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<c:url value="/resources/js/echarts.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1/jquery-3.2.1.js"/>"></script>
</head>
<body>

<div id="hotbook" style="width:800px;height: 400px;"> </div>

<script type="text/javascript">

    var data = ${hotbook.data};
    var keyarr = [];
    var valarr = [];
    for (var item in data) {
        keyarr.push(item);
        valarr.push(data[item]);

    }
    console.log(data);
    var myChart = echarts.init(document.getElementById('hotbook'));
    var option = {
        title: {
            text: '借阅Top15',
            subtext: '图书馆借阅次数top15的书籍'
        },
        color: ['#008080'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'value'
            }


        ],
        yAxis: [
            {
                type: 'category',
                data: keyarr,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        series: [
            {
                name: '直接访问',
                type: 'bar',
                barWidth: '60%',
                data: valarr
            }
        ]
    };

    myChart.setOption(option);
</script>
</body>

</html>
