<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>EX-EM</title>
    <script type="module" src="/dist/adminHead.js"></script>
</head>

<header class="header">
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <select class="custom-select rounded-0" id="authId" name="auth_id"></select>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <span><span style="font-weight: bold">${userNm}</span>님, 안녕하세요.</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="logout"  href="#" role="button">
                    <span class="logout">LOGOUT</span>
                </a>
            </li>
        </ul>
        <input type="hidden" id="userId" value="${userId}">
        <input type="hidden" id="menuType" value="${menuType}">
        <input type="hidden" id="authIdSet" value="${authId}">
    </nav>
</header>
</html>
