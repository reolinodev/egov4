<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminBoard.js"></script>
</head>

<div id="container">
    <!-- 조회 화면 -->
    <form id="boardViewFrm" name="boardViewFrm">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-4">
                        <label for="searchStr">Title / Name</label>
                        <input type="text" class="form-control" id="searchStr" name="search_str">
                    </div>
                    <div class="col-4">
                        <label for="viewBoardType">Type</label>
                        <select class="custom-select rounded-0" id="viewBoardType" name="board_type"></select>
                    </div>
                    <div class="col-4">
                        <label for="viewUseYn">UseYn</label>
                        <select class="custom-select rounded-0" id="viewUseYn" name="use_yn"></select>
                    </div>
                </div>
            </div>
            <div class="card-footer ">
                <div class="row justify-content-end">
                    <div class="col-2">
                        <button type="button" class="btn btn-block btn-success btn-sm" id="writeBtn" data-toggle="modal" data-target="#boardWrite">Add</button>
                    </div>
                    <div class="col-2 ">
                        <button type="button" class="btn btn-block btn-primary btn-sm" id="searchBtn">Search</button>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- 입력화면 (modal) -->
    <form id="boardWriteFrm">
        <div class="modal fade" id="boardWrite">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">ADD Board</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-8">
                                <label for="writeTitle">Title</label>
                                <input type="text" class="form-control" id="writeTitle" name="Title" placeholder="Please enter Title">
                            </div>
                            <div class="col-4">
                                <label for="writeBoardType">Type</label>
                                <select class="custom-select rounded-0" id="writeBoardType" name="board_type"></select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="writeBigo">Memo</label>
                                <input type="text" class="form-control" id="writeBigo" name="bigo" placeholder="Please enter your memo">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="writeMsg"></div>
                        </div>

                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="writeSaveBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- 수정화면 (modal) -->
    <form id="boardEditFrm">
        <div class="modal fade" id="boardEdit">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Edit Board</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-8">
                                <label for="editTitle">Title</label>
                                <input type="text" class="form-control" id="editTitle" name="title" placeholder="Please enter Title">
                                <input type="hidden" id="editBoardId" name="board_id">
                            </div>
                            <div class="col-4">
                                <label for="editBoardType">Type</label>
                                <select class="custom-select rounded-0" id="editBoardType" name="board_type"></select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-8">
                                <label for="editBigo">Memo</label>
                                <input type="text" class="form-control" id="editBigo" name="bigo" placeholder="Please enter your memo">
                            </div>
                            <div class="col-4">
                                <label for="editUseYn">Use</label>
                                <select class="custom-select rounded-0" id="editUseYn" name="use_yn"></select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="editMsg"></div>
                        </div>

                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="editSaveBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file ="../include/grid.jsp" %>

</html>
