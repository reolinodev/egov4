<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminAuth.js"></script>
</head>

<div id="container">
    <form name="authMngViewFrm">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-4">
                        <label for="viewAuthRole">Auth Role</label>
                        <select class="custom-select rounded-0" id="viewAuthRole" name="auth_role"></select>
                    </div>
                    <div class="col-4">
                        <label for="viewUseYn">Use</label>
                        <select class="custom-select rounded-0" id="viewUseYn" name="use_yn"></select>
                    </div>
                </div>
            </div>
            <div class="card-footer ">
                <div class="row justify-content-end">
                    <div class="col-2">
                        <button type="button" class="btn btn-block btn-success btn-sm" id="writeBtn" data-toggle="modal">Add</button>
                    </div>
                    <div class="col-2 ">
                        <button type="button" class="btn btn-block btn-primary btn-sm" id="searchBtn">Search</button>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- 입력화면 (modal) -->
    <form id="authMngWriteFrm">
        <div class="modal fade" id="authMngWrite">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title"></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="writeAuthNm">Auth Name</label>
                                <input type="text" class="form-control" id="writeAuthNm" name="auth_nm" placeholder="Please enter Auth Name">
                            </div>
                            <div class="col-6">
                                <label for="writeAuthVal">Auth Value</label>
                                <input type="text" class="form-control" id="writeAuthVal" name="auth_val" placeholder="Please enter Auth Value">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="writeAuthRole">Auth Role</label>
                                <select class="custom-select rounded-0" id="writeAuthRole" name="auth_role"></select>
                            </div>
                            <div class="col-6">
                                <label for="writeOrd">Auth Ord</label>
                                <input type="text" class="form-control" id="writeOrd" name="ord" placeholder="Please enter Auth Ord">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="writeBigo">Bigo</label>
                                <input type="text" class="form-control" id="writeBigo" name="bigo" placeholder="Please enter Bigo.">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="writeMsg"></div>
                        </div>
                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="insertBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>


    <!-- 수정화면 (modal) -->
    <form id="authMngEditFrm">
        <div class="modal fade" id="authMngEdit">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title"></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="editAuthNm">Auth Name</label>
                                <input type="text" class="form-control" id="editAuthNm" name="auth_nm" placeholder="Please enter Auth Name">
                                <input type="hidden" class="form-control" id="editAuthId" name="auth_id">
                            </div>
                            <div class="col-6">
                                <label for="writeAuthVal">Auth Value</label>
                                <input type="text" class="form-control" id="editAuthVal" name="auth_val" readonly>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="writeAuthRole">Auth Role</label>
                                <select class="custom-select rounded-0" id="editAuthRole" name="auth_role"></select>
                            </div>
                            <div class="col-6">
                                <label for="writeOrd">Auth Ord</label>
                                <input type="text" class="form-control" id="editOrd" name="ord" placeholder="Please enter Auth Ord">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-8">
                                <label for="writeBigo">Bigo</label>
                                <input type="text" class="form-control" id="editBigo" name="bigo" placeholder="Please enter Bigo.">
                            </div>
                            <div class="col-4">
                                <label for="editUseYn">UseYn</label>
                                <select class="custom-select rounded-0" id="editUseYn" name="use_yn"></select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="editMsg"></div>
                        </div>
                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="editBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file ="../include/grid.jsp" %>

</html>
