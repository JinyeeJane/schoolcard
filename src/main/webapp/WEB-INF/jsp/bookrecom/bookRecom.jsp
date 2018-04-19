<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

%>
<!DOCTYPE html>

<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
    <title>Foundation 实例</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/js/layui/css/layui.css"/>"  media="all">
    <style>
        body {
            padding: 20px;
        }
        .panel {
            padding: 0;
            border: none;
            width: 100%;
        }
        div.container {
            text-align: center;
            padding: 15px;
            margin-top: 20px;

        }
        img {
            width: 100%;
        }

    </style>
    <style>
        .cui_db a{margin-left:0px !important;}
        .lcui_head a{margin-left:0px !important;}
        .lcui_today a{margin-left:0px !important;}
        .lcui_empty a{margin-left:0px !important;}
    </style>

</head>
<body>
    <div class="row">
        <h1>书籍推荐系统模块</h1>
        <div class="large-12 columns" style="background-color:white;">
            <h2>书名查询</h2>
            <form action="<%=basePath%>bookrecom/search2" class="search" name="search" method="post">
                <div class="row">
                    <div class="large-12 columns">
                        <div class="row collapse">
                            <div class="small-10 columns">
                                <input  id="query" type="text" placeholder="输入书名或者作者" name="query">
                            </div>
                            <div class="small-2 columns">
                                <%--<input type="submit" class="button search">--%>
                                <button type="submit" class="layui-btn">搜索</button>
                            </div>
                            </div>
                        </div>
                    </div>

            </form>
        </div>
        <div class="large-12 columns" style="background-color:white;">
            <h2>历史借阅记录</h2>
        </div>
        <div class="large-6 columns" style="background-color:white;">
            <h2>热门书籍查询</h2>
            <div class="panel">
                <div  id="showHotBook" alt="Cinque Terre" style="width: 400px;height:400px;"> </div>
                <div class="container">
                    <form >
                        <label>时间段
                            <input type="text" placeholder="开始时间" class="begintime" name="begintime">
                        </label>
                        <label>
                            <input type="text" placeholder="结束时间" class="endtime" name="endtime">
                        </label>

                        <label>学院
                            <select id="num" class="faculty" name="faculty">

                            </select>
                        </label>
                        <label>
                            <button  type="button" placeholder="Name" class="hotbookbutton"> 提交</button>
                        </label>
                    </form>
                </div>
            </div>

        </div>
        <div class="large-6 columns" style="background-color:white;">
            <h2>选择感兴趣的标签</h2>
            <button class="layui-btn layui-btn-primary layui-btn-radius">原始按钮</button>
            <button class="layui-btn layui-btn-radius">默认按钮</button>
            <button class="layui-btn layui-btn-normal layui-btn-radius">百搭按钮</button>
            <button class="layui-btn layui-btn-warm layui-btn-radius">暖色按钮</button>
            <button class="layui-btn layui-btn-danger layui-btn-radius">警告按钮</button>
        </div>

        <div class="large-6 columns" style="background-color:white;">
            <h2>个性化推荐</h2>
            <ul class="accordion" data-accordion>
            <c:forEach items="${listOfRecBooks}" var="item" >
                <li class="accordion-navigation">
                    <a href="#demo">${item.title}</a>
                </li>
            </c:forEach>
                </ul>

        </div>

    </div>

    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/echarts.js"/>"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/laydate/laydate.js"/>"></script>
    <script src="<c:url value="/resources/js/layui/layui.js"/>" charset="utf-8"></script>
    <script type="text/javascript">
        <%--初始化 Foundation JS--%>
        $(document).ready(function() {
            $(document).foundation();
        });

        <%--function allhtml() {--%>
            <%--&lt;%&ndash;异步弹窗书籍搜索&ndash;%&gt;--%>
            <%--document.getElementById("showSearchResult").innerHTML ="";--%>
                <%--$.ajax({--%>
                    <%--type: "POST",--%>
                    <%--url: "<%=basePath%>bookrecom/search2",--%>
                    <%--data: { query : $("#query").val()},--%>
                    <%--dataType:'html',--%>
                    <%--success:function(response){--%>
                        <%--document.getElementById("showSearchResult").innerHTML = response;--%>
                        <%--console.log("showSearchResult  successfully!!!");--%>
                    <%--},--%>
                    <%--error: function () {--%>
                        <%--console.log("showSearchResult failure!!!");--%>
                    <%--}--%>
                <%--});--%>
        <%--}--%>


    </script>

    <script>
        <%--日历插件实现--%>
        laydate.render({
            elem: '.begintime'
            ,format: 'yyyyMMdd'
            ,
        });

        laydate.render({
            elem: '.endtime'
            ,format: 'yyyyMMdd'
        });
    </script>

    <script type="text/javascript" src="<c:url value="/resources/js/faculty.js"/>"></script>
    <script>
        <%--学院名称列表--%>
        var fragment = document.createDocumentFragment();
        for(j = 0,len=facultys.length; j < len; j++) {
            var option = document.createElement('option');
            option.innerText = facultys[j];
            fragment.appendChild(option);
        }
        $('.faculty').append(fragment);
    </script>
    <script>
        <%--异步热门书籍查询--%>
        var myChart = echarts.init(document.getElementById('showHotBook'));
        data = ${hotbook};
        var keyarr = [];
        var valarr = [];
        for (var item in data) {
            keyarr.push(data[item].title);
            valarr.push(data[item].borrowtimes);
        }
        myChart.setOption(
                {
                    title: {
                        text: '借阅Top20',
                        subtext: '图书馆借阅次数top20的书籍'
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
                }
        )
        $(".hotbookbutton").click(function() {
            $.post('<%=basePath%>bookrecom/hotbook',{ 'begintime' : $(".begintime").val(),
                'faculty' : $(".faculty").val(),
                'endtime' : $(".endtime").val(),
            }).done(function (data) {
                // 填入数据
                console.log(data)
                var keyarr = [];
                var valarr = [];
                for (var item in data) {
                    keyarr.push(data[item].title);
                    valarr.push(data[item].borrowtimes);
                }
                console.log(keyarr)
                myChart.setOption({
                    yAxis: {
                        data: keyarr
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '直接访问',
                        data: valarr
                    }]
                });
            });
        });
    </script>
</body>
</html>


