<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminCode.js"></script>
</head>

<div id="container">
    <form name="codeGrpFrm">
        <div class="row">
            <div class="col-md-5">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Code Group</h3>
                        <div class="row justify-content-end">
                            <div class="col-4">
                                <button type="button" class="btn btn-block btn-success btn-sm" id="codeGrpAddBtn">ADD</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-header">
                        <div class="row justify-content-end">
                            <div class="col-5">
                                <div class="input-group input-group-sm">
                                    <input type="text" class="form-control" id="searchStr" name="search_str" placeholder="Code Name/Code">
                                </div>
                            </div>
                            <div class="col-4">
                                <select class="custom-select rounded-0" id="useYn" name="use_yn"></select>
                            </div>
                            <div class="col-3">
                                <button type="button" class="btn btn-block btn-primary btn-sm" id="searchGrpBtn">Search</button>
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

            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Code</h3>
                        <div class="row justify-content-end">
                            <div class="col-3">
                                <button type="button" class="btn btn-block btn-warning btn-sm" id="addBtn">ADD</button>
                            </div>
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

    <!-- 입력화면 (modal) -->
    <form name="codeGrpWriteFrm">
        <div class="modal fade" id="codeGrpWrite">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Add Code Group</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-6">
                                <input type="text" class="form-control" id="writeCodeGrpNm" name="code_grp_nm" placeholder="Please enter name">
                            </div>
                            <div class="col-6">
                                <input type="text" class="form-control" id="writeCodeGrpVal" name="code_grp_val" placeholder="Please enter value">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="writeMsg"></div>
                        </div>
                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="writeCodeGrpBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- 수정화면 (modal) -->
    <form name="codeGrpEditFrm">
        <div class="modal fade" id="codeGrpEdit">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Code Group</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-4">
                                <input type="text" class="form-control" id="editCodeGrpNm" name="code_grp_nm" placeholder="Please enter name">
                                <input type="hidden" class="form-control" id="editCodeGrpId" name="code_grp_id">
                            </div>
                            <div class="col-4">
                                <input type="text" class="form-control" id="editCodeGrpVal" name="code_grp_val" readonly>
                            </div>
                            <div class="col-4">
                                <select class="custom-select rounded-0" id="editUseYn" name="use_yn"></select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="editMsg"></div>
                        </div>
                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="editCodeGrpBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</html>
