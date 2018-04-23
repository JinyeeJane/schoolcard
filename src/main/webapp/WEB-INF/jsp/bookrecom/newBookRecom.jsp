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
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/js/layui/css/layui.css"/>"  media="all">
    <link rel="stylesheet" href="<c:url value="/resources/js/tagcloud/css/zzsc.css"/>"  media="all">
    <%--<link rel="stylesheet" href="<c:url value="/resources/css/loading/css/style.css"/>"  media="all">--%>

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="layui-container">
    <blockquote class="layui-elem-quote"><h1 size="12px">推荐系统</h1> </blockquote>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>书籍查询</legend>
    </fieldset>
    <div class="layui-row">
        <form class="layui-form layui-form-pane" action="<%=basePath%>bookrecom/search2" method="post">
            <div class="layui-form-item layui-col-xs12 layui-col-md8">
                <label class="layui-form-label"><i class="layui-icon">&#xe68e;</i> </label>
                <div class="layui-input-block">
                    <input type="text" name="query" autocomplete="off" placeholder="请输入书名或作者名" class="layui-input">
                </div>
            </div>
            <div class=" layui-col-xs2 layui-col-md2">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo2">搜索</button>
            </div>
        </form>
    </div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>功能区</legend>
</fieldset>

<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">个性化推荐</li>
        <li class="hotbooktab">热门书籍查询</li>
        <li class="borrowhistorytab">历史借阅记录</li>
        <li>个人标签</li>
        <li class="colletiontab">个人收藏</li>
    </ul>
    <div class="layui-tab-content">
        <%--个性化推荐--%>
        <div class="layui-tab-item layui-show">
            1. 利用热传导算法和基于人口统计学推荐算法。
            <br>2. 推荐效果不错。
            <table  id="recom" lay-filter="recom"></table>
            <script type="text/html" id="checkboxrecom" >
                <input type="checkbox" name="colleciton" value="{{d.bookid}}" title="收藏" lay-filter="checkboxrecom" {{ jQuery.inArray(d.bookid, collectionbooklist) ==-1 ? '' : 'checked' }}>
            </script>
        </div>
        <%--热门书籍查询--%>
        <div class="layui-tab-item">
            <div class="layui-form-item layui-col-xs12 layui-col-md4 ">
                <div class="loader_showHotBook loader--style6" title="5">
                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                         width="24px" height="30px" viewBox="0 0 24 30" style="enable-background:new 0 0 50 50;" xml:space="preserve">
                <rect x="0" y="13" width="4" height="5" fill="#333">
                    <animate attributeName="height" attributeType="XML" values="5;21;5" begin="0s" dur="0.6s" repeatCount="indefinite" />
                    <animate attributeName="y" attributeType="XML" values="13; 5; 13" begin="0s" dur="0.6s" repeatCount="indefinite" />
                </rect>
                        <rect x="10" y="13" width="4" height="5" fill="#333">
                            <animate attributeName="height" attributeType="XML" values="5;21;5" begin="0.15s" dur="0.6s" repeatCount="indefinite" />
                            <animate attributeName="y" attributeType="XML" values="13; 5; 13" begin="0.15s" dur="0.6s" repeatCount="indefinite" />
                        </rect>
                        <rect x="20" y="13" width="4" height="5" fill="#333">
                            <animate attributeName="height" attributeType="XML" values="5;21;5" begin="0.3s" dur="0.6s" repeatCount="indefinite" />
                            <animate attributeName="y" attributeType="XML" values="13; 5; 13" begin="0.3s" dur="0.6s" repeatCount="indefinite" />
                        </rect>
                </svg>
                </div>
                <div id="showHotBook" style="width: 400px;height:300px;">

                </div>

            </div>
            <div class="layui-form-item layui-col-xs12 layui-col-md6">
                <div class="layui-form-item ">
                    <div class="layui-inline">
                        <label class="layui-form-label">时间范围</label>
                        <div class="layui-input-inline" style="width: 150px;">
                            <input type="text" name="begintime" placeholder="20080000" autocomplete="off" class="begintime layui-input">
                        </div>
                        <div class="layui-form-mid">-</div>
                        <div class="layui-input-inline" style="width: 150px;">
                            <input type="text" name="endtime" placeholder="20120000" autocomplete="off" class="endtime layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">学院</label>
                        <div class="layui-input-inline" style="width: 200px;">
                            <select lay-verify="" class="faculty layui-input" name="faculty" >

                            </select>
                        </div>
                    </div>
                    <button class="layui-btn hotbookbutton" lay-submit="">提交</button>
                </div>
            </div>
        </div>
        <div class="layui-tab-item ">
            <div class="loader_borrowhistory loader--style6" title="5">
                <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                     width="24px" height="30px" viewBox="0 0 24 30" style="enable-background:new 0 0 50 50;" xml:space="preserve">
                <rect x="0" y="13" width="4" height="5" fill="#333">
                <animate attributeName="height" attributeType="XML" values="5;21;5" begin="0s" dur="0.6s" repeatCount="indefinite" />
                <animate attributeName="y" attributeType="XML" values="13; 5; 13" begin="0s" dur="0.6s" repeatCount="indefinite" />
                 </rect>
                    <rect x="10" y="13" width="4" height="5" fill="#333">
                        <animate attributeName="height" attributeType="XML" values="5;21;5" begin="0.15s" dur="0.6s" repeatCount="indefinite" />
                        <animate attributeName="y" attributeType="XML" values="13; 5; 13" begin="0.15s" dur="0.6s" repeatCount="indefinite" />
                    </rect>
                    <rect x="20" y="13" width="4" height="5" fill="#333">
                        <animate attributeName="height" attributeType="XML" values="5;21;5" begin="0.3s" dur="0.6s" repeatCount="indefinite" />
                        <animate attributeName="y" attributeType="XML" values="13; 5; 13" begin="0.3s" dur="0.6s" repeatCount="indefinite" />
                    </rect>
                </svg>
            </div>
            <table  id="borrowhistory" lay-filter="borrowhistory"></table>
            <script type="text/html" class="borrowhistory" >
                <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="detail">收藏</a>
            </script>
        </div>
            <%--个人标签--%>
        <div class="layui-tab-item">
            <div class="layui-form-item layui-col-xs12 layui-col-md6">
                <button class="layui-btn" lay-submit="">刷新</button>
                <div class="layui-form-item layui-col-xs12 layui-col-md5" id="tagscloud">

                </div>
            </div>
            <div class="layui-form-item layui-col-xs12 layui-col-md6">
            </div>
        </div>
        <div class="layui-tab-item">
            <table  id="colletion" lay-filter="colletion"></table>
            <script type="text/html" id="checkboxcolletion" class="colletion">
                <a class="layui-btn layui-btn-danger layui-btn-xs"  lay-event="del">删除</a>
            </script>
        </div>
    </div>
</div>
</div>
<script src="<c:url value="/resources/js/layui/layui.js"/>" charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/echarts.js"/>"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>



    function collection(bookid,addordel) {
        $.post('<%=basePath%>bookrecom/collection',{"bookid":bookid,"addordel":addordel}).done(function (data) {
        });
    }
    layui.use('element', function(){
        var $ = layui.jquery
                ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        //触发事件
        var active = {
            tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };
    });
</script>

<script>
    <%--日历插件实现--%>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '.begintime'
            ,format: 'yyyyMMdd'
            ,
        });
        laydate.render({
            elem: '.endtime'
            ,format: 'yyyyMMdd'
        });

    });
</script>

<script class="recom">
    <%--var listOfRecBooks = ${listOfRecBooks};--%>
    <%--alert(listOfRecBooks);--%>
    <%--if ( listOfRecBooks == "null"){--%>

    <%--}--%>
    <%--else{--%>

    <%--}--%>
    var collectionbooklist = ${collectionBookidList};
    layui.use('table', function(){
        var table = layui.table
                ,form = layui.form;
        table.render({
            elem: '#recom'
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
            ,cols: [[
                {type:'numbers'}
                ,{field:'bookid', width:80, title: 'ID'}
                ,{field:'title', width:200, title: '书名'}
                ,{field:'author', width:100, title: '作者'}
                ,{field:'cbs', width:150, title: '出版社'}
                ,{field:'cbrq', width:120, title: '出版日期', sort: true}
                ,{field:'ztc', width:120, title: '主题词'}
                ,{field:'jj', width:200, title: '简介', minWidth: 150}
                ,{field:'lock', title:'收藏', width:110, templet: '#checkboxrecom', unresize: true}
            ]]
            ,data:${listOfRecBooks}
            ,page: true
        });
        form.on('checkbox(checkboxrecom)', function(obj){
            var flag = obj.elem.checked == true ? "加入收藏" :"取消收藏";
            layer.tips(this.value +' '+ flag ,obj.othis);
            collection(this.value, obj.elem.checked);
            console.log(this.value);

        });
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
    var times_hotbook = 0;
    $(".hotbooktab").click(function() {
        if(times_hotbook ==0){
            times_hotbook = times_hotbook+1;
            $.post('<%=basePath%>bookrecom/hotbook'
            ).done(function (data) {
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
                $(".loader_showHotBook").remove();
            })
        }
    });

    $(".hotbookbutton").click(function() {
        if(Number($(".endtime").val()) > Number($(".endtime").val())){
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

                setTimeout(myChart.setOption({
                    yAxis: {
                        data: keyarr
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '直接访问',
                        data: valarr
                    }]
                }),500);
            });
        }
        else{
            alert("输入的时间范围有误");
            }

    });
</script>

<script class="borrowhistory">
    var times_borrowhistory = 0;
    $(".borrowhistorytab").click(function() {
        if(times_borrowhistory ==0) {
            times_borrowhistory = times_borrowhistory + 1;
            $.post('<%=basePath%>bookrecom/history').done(function (data) {
                layui.use('table', function () {
                    var table = layui.table;
                    console.log(data)
                    table.render({
                        elem: '#borrowhistory'
                        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                            //,curr: 5 //设定初始在第 5 页
                            , groups: 1 //只显示 1 个连续页码
                            , first: false //不显示首页
                            , last: false //不显示尾页
                        }
                        , cols: [[
                            {field: 'bookid', width: 80, title: 'ID'}
                            , {field: 'title', width: 200, title: '书名'}
                            , {field: 'author', width: 100, title: '作者'}
                            , {field: 'cbs', width: 150, title: '出版社'}
                            , {field: 'cbrq', width: 120, title: '出版日期', sort: true}
                            , {field: 'ztc', width: 120, title: '主题词'}
                            , {field: 'jj', width: 200, title: '简介', minWidth: 150}
                            , {fixed: 'right', width: 50, align: 'center', toolbar: '#barDemo'}
                        ]]
                        , data: data
                        , page: true
                    });
                    table.on('tool(borrowhistory)', function (obj) {
                        var data = obj.data;
                        if (obj.event === 'detail') {
                            layer.msg('ID：' + data.bookid + ' 已加入收藏');

                        }
                    });
                    $(".loader_borrowhistory").remove();
                });
            })
        }
    });
</script>
<script src="<c:url value="/resources/js/tagcloud/js/zzsc.js"/>" > </script>
<script src="<c:url value="/resources/js/tagcloud/tags/tags.js"/>" > </script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script>
    <%--学院名称列表--%>
    var fragment = document.createDocumentFragment();
    var color = [1,2,5]
    var indexs = []
    for(j = 0; j < 40; j++) {
        var a = document.createElement('a');
        var index = Math.floor(Math.random()*1000)
        a.innerText = tags[index];
        indexs.push(index)
        a.setAttribute('id',index);
        a.setAttribute('class','tagc'+color[Math.floor(Math.random()*3)]);
        fragment.appendChild(a);
    }

    $('#tagscloud').append(fragment);

    for(j = 0; j < 40; j++) {
        $("#" + indexs[j]).click(function () {
            console.log(tags[Number($(this).attr('id'))]);

        });
    };

</script>
<script>
    $(".colletiontab").click(function() {
        $.post('<%=basePath%>bookrecom/showcollection').done(function (data) {
                layui.use('table', function () {
                    var table_collection = layui.table;
                    console.log(data)
                    table_collection.render({
                        elem: '#colletion'
                        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                            //,curr: 5 //设定初始在第 5 页
                            , groups: 1 //只显示 1 个连续页码
                            , first: false //不显示首页
                            , last: false //不显示尾页
                        }
                        , cols: [[
                            {field: 'bookid', width: 100, title: 'ID'}
                            , {field: 'title', width: 200, title: '书名'}
                            , {field: 'author', width: 100, title: '作者'}
                            , {field: 'cbs', width: 150, title: '出版社'}
                            , {field: 'cbrq', width: 120, title: '出版日期', sort: true}
                            , {field: 'ztc', width: 120, title: '主题词'}
                            , {field: 'jj', width: 200, title: '简介', minWidth: 150}
                            , {fixed: 'right', width: 50, align: 'center', toolbar: '#checkboxcolletion'}
                        ]]
                        , data: data
                        , page: true
                    });
                    table_collection.on('tool(colletion)', function(obj){
                        var data = obj.data;
                        console.log('nodel')
                        if(obj.event === 'del'){
                            console.log('del')
                            layer.confirm('真的删除么', function(index){
                                obj.del();
                                layer.close(index);
                                collection(data.bookid, "false");
                            });
                        }
                    });
                });
        })
    });
</script>
</body>
</html>