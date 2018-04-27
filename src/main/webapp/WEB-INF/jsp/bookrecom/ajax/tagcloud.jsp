<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 18/4/20
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="<c:url value="/resources/js/tagcloud/css/zzsc.css"/>"  media="all">
</head>
<body>

<div id="tagscloud">

</div>

<script src="<c:url value="/resources/js/tagcloud/js/zzsc.js"/>" > </script>
<script src="<c:url value="/resources/js/tagcloud/tags/tags.js"/>" > </script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script>
    <%--学院名称列表--%>
    var fragment = document.createDocumentFragment();
    var color = [1,2,5]
    var indexs = []
    for(j = 0; j < 50; j++) {
        var a = document.createElement('a');
        var index = Math.floor(Math.random()*1000);
        a.innerText = tags[index];
        indexs.push(index);
        a.setAttribute('id',index);
        a.setAttribute('class','tagc'+color[Math.floor(Math.random()*3)]);
        fragment.appendChild(a);
    }

    $('#tagscloud').append(fragment);

    for(j = 0; j < 50; j++) {
        $("#" + indexs[j]).click(function () {
            console.log(tags[Number($(this).attr('id'))]);

        });
    }
</script>
<script>


</script>
</body>
</html>
