<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 18/4/16
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/js/layui/css/layui.css"/>"  media="all">

    <link rel="stylesheet" href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>

</head>
<body>
<h2>查询结果</h2>
<table  id="test" lay-filter="demo"></table>

<script type="text/html" id="checkboxrecom" >
    <input type="checkbox" name="colleciton" value="{{d.bookid}}" title="收藏" lay-filter="checkboxrecom" {{ jQuery.inArray(d.bookid, collectionbooklist) ==-1 ? '' : 'checked' }}>
</script>
<script src="<c:url value="/resources/js/layui/layui.js"/>" charset="utf-8"></script>
<script>

    var collectionListGson = ${collectionListGson};
    collectionbooklist = [];
    console.log()
    for(j = 0,len=collectionListGson.length; j < len; j++) {
        var option = document.createElement('option');
        collectionbooklist.push(collectionListGson[j].bookid);
    }

    function collection(bookid,addordel) {
        $.post('<%=basePath%>bookrecom/collection',{"bookid":bookid,"addordel":addordel}).done(function (data) {
        });
    }

    layui.use('table', function(){
        var table = layui.table,
                form = layui.form;
        table.render({
            elem: '#test'
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
            ,cols: [[
                {field:'bookid', width:80, title: 'ID'}
                ,{field:'title', width:200, title: '书名'}
                ,{field:'author', width:100, title: '作者'}
                ,{field:'cbs', width:150, title: '出版社'}
                ,{field:'cbrq', width:120, title: '出版日期', sort: true}
                ,{field:'ztc', width:120, title: '主题词'}
                ,{field:'jj', width:200, title: '简介', minWidth: 150}
                ,{field:'lock', title:'收藏', width:110, templet: '#checkboxrecom', unresize: true}

            ]]
            ,data:${result4queryGson}
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
</body>
</html>