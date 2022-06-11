<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminUserAuth.js"></script>
</head>

<div id="container">
    <form name="authUserMngViewFrm">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-4">
                        <label for="viewAuthRole">Auth Role</label>
                        <select class="custom-select rounded-0" id="viewAuthRole" name="auth_role"></select>
                    </div>
                    <div class="col-4">
                        <label for="viewAuthId">Auth Name</label>
                        <select class="custom-select rounded-0" id="viewAuthId" name="auth_id"></select>
                    </div>
                    <div class="col-4">
                        <label for="searchStr">Id/Email/Name</label>
                        <input type="text" class="form-control" id="searchStr" name="search_str">
                    </div>
                </div>
            </div>
            <div class="card-footer ">
                <div class="row justify-content-end">
                    <div class="col-2">
                        <button type="button" class="btn btn-block btn-danger btn-sm" id="deleteBtn" style="display: none">DEL</button>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-block btn-success btn-sm" id="writeBtn">ADD</button>
                    </div>
                    <div class="col-2 ">
                        <button type="button" class="btn btn-block btn-primary btn-sm" id="searchBtn">SEARCH</button>
                    </div>
                </div>
            </div>
            <div class="row justify-content-end" style="padding: 10px 20px; color: red">
                * To delete permission, select the select box and search.
            </div>
        </div>
    </form>
</div>
<%@include file ="../include/grid.jsp" %>
</html>
