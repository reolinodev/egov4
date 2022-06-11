<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="module" src="/dist/adminMain.js"></script>
</head>
<body>
<div class="content-wrapper">
    <input id="mainId" type="hidden" value="${firstUrl.menu_id}"/>
    <input id="mainUrl" type="hidden" value="${firstUrl.menu_url}"/>
    <input id="mainMenuNm" type="hidden" value="${firstUrl.menu_nm}"/>
    <input id="mainParentNm" type="hidden" value="${firstUrl.parent_nm}"/>

    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0" id="menuNm">${firstUrl.menu_nm}</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item" id="parentMenuNm">${firstUrl.menu_nm}</li>
                        <li class="breadcrumb-item active" id="childMenuNm">${firstUrl.menu_nm}</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>

    <div class="content">
        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <iframe id="contentFrame" style="width: 100%;overflow-x:hidden;overflow-y:hidden;border: 0;"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>