<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <link rel="stylesheet" href="/lib/tuiComp/tui-grid.css">
    <link rel="stylesheet" href="/lib/tuiComp/tui-pagination.css">
    <script type="module" src="/dist/adminUserAuthWrite.js"></script>
</head>
<div id="container">
    <form name="authUserMngWriteFrm">
        <div class="row justify-content-end" style="margin-bottom: 10px;">
            <div class="col-2 ">
                <button type="button" class="btn btn-block btn-primary btn-sm" id="backBtn">BACK</button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Choose User</h3>
                    </div>
                    <div class="card-header">
                        <div class="row">
                            <div class="col-6">
                                <select class="custom-select rounded-0" id="authRole" name="auth_role"></select>
                            </div>
                            <div class="col-6">
                                <select class="custom-select rounded-0" id="authId" name="auth_id"></select>
                            </div>
                        </div>
                    </div>
                    <div class="card-header">
                        <div class="row justify-content-end">
                            <div class="col-9">
                                <div class="input-group input-group-sm">
                                    <input type="text" class="form-control" id="searchStr" name="search_str" placeholder="Id/Email/Name">
                                    <div class="input-group-append" id="searchIcon">
                                        <div class="btn btn-primary">
                                            <i class="fas fa-search"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-3">
                                <button type="button" class="btn btn-block btn-success btn-sm" id="addBtn">ADD</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row justify-content-end">
                            <div class="col-3 ">
                                <select class="custom-select rounded-0" id="pagePer" name="page_per" style="margin-bottom: 10px"></select>
                            </div>
                        </div>
                        <!-- 그리드 영역-->
                        <div id="grid"></div>

                        <!-- 페이징 영역 -->
                        <div id="pagination" class="tui-pagination"></div>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Selected User</h3>
                        <div class="row justify-content-end">
                            <div class="col-3">
                                <button type="button" class="btn btn-block btn-danger btn-sm" id="delBtn">DEL</button>
                            </div>
                            <div class="col-3">
                                <button type="button" class="btn btn-block btn-success btn-sm" id="saveBtn">SAVE</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <!-- 그리드 영역-->
                        <div id="grid2"></div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</html>
