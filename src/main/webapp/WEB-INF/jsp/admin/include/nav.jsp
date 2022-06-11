<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>EX-EM</title>
</head>
<body>
<nav>
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="#" class="brand-link" style="text-align: center;"
           id="menuUrl"
           data-id="${firstUrl.menu_id}"
           data-url="${firstUrl.menu_url}"
           data-menunm="${firstUrl.menu_nm}"
           data-parentnm="${firstUrl.parent_nm}"
        >
            Admin Page
        </a>

        <div class="sidebar">
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false" id="navUl">
                    <c:forEach var="menuLv1" items="${menuLv1List}">
                        <li class="nav-item">
                            <a href="#" class="nav-link">
                                <i class="nav-icon fas fa-hockey-puck"></i>
                                <p>
                                    <span>${menuLv1.menu_nm}</span>
                                    <i class="fas fa-angle-left right"></i>
                                </p>
                            </a>
                            <ul class="nav nav-treeview">
                                <c:forEach var="menuLv2" items="${menuLv2List}">
                                    <c:if test="${menuLv1.menu_id eq menuLv2.parent_id}">
                                        <li class="nav-item"
                                            id="menu_${menuLv2.menu_id}"
                                            data-id="${menuLv2.menu_id}"
                                            data-url="${menuLv2.menu_url}"
                                            data-menunm="${menuLv2.menu_nm}"
                                            data-parentnm="${menuLv2.parent_nm}"
                                        >
                                            <a href="#" class="nav-link">
                                                <i class="far fa-circle nav-icon"></i>
                                                <p>${menuLv2.menu_nm}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </aside>
</nav>
</body>
</html>
