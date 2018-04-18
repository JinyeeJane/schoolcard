<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 18/4/12
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Foundation 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>
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
</head>
<body>

<div class="row">
    <h1>书籍推荐系统模块</h1>
    <div class="large-12 columns" style="background-color:white;">
        <h2>书名查询</h2>
        <form action="<%=basePath%>bookrecom/search" class="search" name="search" method="post" onkeydown="if(event.keyCode==13)return false;">
            <div class="row">
                <div class="large-12 columns">
                    <div class="row collapse">
                        <div class="small-10 columns">
                            <input  id="query" type="text" placeholder="输入书名或者作者" name="query">

                        </div>
                        <div class="small-2 columns">
                            <%--<a href="#" class="button postfix">提交</a>--%>
                            <button type="button" class="button postfix search" onclick="allhtml()" data-reveal-id="showSearchResult">提交</button>

                            <div id="showSearchResult" class="reveal-modal" data-reveal>

                                <a class="close-reveal-modal">&times;</a>
                            </div>
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
            <img src="http://www.runoob.com/wp-content/uploads/2015/11/20121204024112919.jpg" alt="Cinque Terre" width="200" height="150">
            <div class="container">
                <form>
                    <label>时间段
                        <input type="text" placeholder="开始时间" class="begin">
                        <input type="text" placeholder="结束时间" class="end">
                    </label>

                    <label>学院
                        <select id="num">
                            <option>软件学院</option>
                            <option>信息科学与工程学院</option>
                            <option>外语学院</option>
                            <option>化学院</option>
                        </select>
                    </label>
                    <label>
                        <input type="submit" placeholder="Name">
                    </label>
                </form>
            </div>
        </div>

    </div>
    <div class="large-6 columns" style="background-color:white;">
        <h2>选择感兴趣的标签</h2>
        <span class="label round">长篇小说</span>
        <span class="label round">短篇小说</span>
        <span class="label round">散文</span>
        <span class="label success round">3</span>
    </div>

    <div class="large-6 columns" style="background-color:white;">
        <h2>个性化推荐</h2>

        <ul class="accordion" data-accordion>
        <c:forEach items="${listOfRecBooks}" var="item" >

            <li class="accordion-navigation">
                <a href="#demo">${item.title}</a>
                <%--<div  class="content active">--%>
                        <%--${item.title}--%>
                <%--</div>--%>
            </li>
        </c:forEach>
            </ul>

    </div>

</div>

<!-- 初始化 Foundation JS -->
<script type="text/javascript">
    $(document).ready(function() {


        $(document).foundation();

    });

    function allhtml() {
        document.getElementById("showSearchResult").innerHTML ="";
            $.ajax({
                type: "POST",
                url: "<%=basePath%>bookrecom/search",
//                data: $("#query").val(),
                data: { query : $("#query").val()},
                dataType:'html',

                success:function(response){

                    document.getElementById("showSearchResult").innerHTML = response;

                    console.log("Details saved successfully!!!");
                },

                error: function () {

                    console.log("Details saved default!!!");
                }
            });
    }


</script>


</body>
</html>


