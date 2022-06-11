<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminGridContent.js"></script>

    <link rel="stylesheet" href="/lib/tuiComp/tui-grid.css">
    <link rel="stylesheet" href="/lib/tuiComp/tui-pagination.css">
</head>
<body>
    <div class="row justify-content-end">
        <div class="col-3 ">
            <select class="custom-select rounded-0" id="pagePer" name="page_per" style="margin-bottom: 10px"></select>
        </div>
    </div>
    <!-- 그리드 영역-->
    <div id="grid"></div>

    <!-- 페이징 영역 -->
    <div id="pagination" class="tui-pagination"></div>
</body>
</html>
