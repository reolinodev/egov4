<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EX-EM</title>
    <%@include file ="../include/config.jsp" %>
    <script type="module" src="/dist/adminUser.js"></script>
</head>

<body>
<div id="container">
    <!-- 조회 화면 -->
    <form id="userMngViewFrm" name="userMngViewFrm">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-4">
                        <label for="searchStr">Login ID/ Email/ Name</label>
                        <input type="text" class="form-control" id="searchStr" name="search_str">
                    </div>
                    <div class="col-4">
                        <label for="viewUseYn">UseYn</label>
                        <select class="custom-select rounded-0" id="viewUseYn" name="use_yn"></select>
                    </div>
                </div>
            </div>
            <div class="card-footer ">
                <div class="row justify-content-end">
                    <!--                    <div class="col-2">-->
                    <!--                        <button type="button" class="btn btn-block btn-secondary btn-sm" id="uploadBtn">Excel Upload</button>-->
                    <!--                    </div>-->
                    <div class="col-2">
                        <button type="button" class="btn btn-block btn-success btn-sm" id="writeBtn" data-toggle="modal" data-target="#userMngWrite">Add</button>
                    </div>
                    <div class="col-2 ">
                        <button type="button" class="btn btn-block btn-primary btn-sm" id="searchBtn">Search</button>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- 입력화면 (modal) -->
    <form id="userMngWriteFrm">
        <div class="modal fade" id="userMngWrite">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">ADD USER</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-8">
                                <input type="text" class="form-control" id="writeLoginId" name="login_id" placeholder="Please enter your ID">
                                <input type="hidden" id="signUpChk" value ="N"  />
                            </div>
                            <div class="col-4 ">
                                <button type="button" class="btn btn-success btn-block" id="signUpCheckBtn">Check ID</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-4">
                                <label for="writeUserNm">Name</label>
                                <input type="text" class="form-control" id="writeUserNm" name="user_nm" placeholder="Please enter your Name">
                            </div>
                            <div class="col-4">
                                <label for="writeEmail">Email</label>
                                <input type="text" class="form-control" id="writeEmail" name="email" placeholder="Please enter your Email">
                            </div>
                            <div class="col-4">
                                <label for="writeCellPhone">Cell Phone</label>
                                <input type="number" class="form-control" id="writeCellPhone" name="cell_phone" placeholder="Please enter your Cell Phone">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="writeUserPw">Password</label>
                                <input type="password" class="form-control" id="writeUserPw" name="user_pw" placeholder="Please enter your password">
                            </div>
                            <div class="col-6">
                                <label for="writeUserPwRe">Password Confirm</label>
                                <input type="password" class="form-control" id="writeUserPwRe" placeholder="Please enter your password">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 text-lg-center" id="writeMsg"></div>
                        </div>
                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="submitBtn">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <!-- 수정화면 (modal) -->
    <form id="userMngEditFrm">
        <div class="modal fade" id="userMngEdit">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">EDIT USER</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <div class="col-8">
                                <label for="editLoginId">Login ID</label>
                                <input type="text" class="form-control" id="editLoginId" name="login_id" readonly>
                                <input type="hidden" class="form-control" id="editUserid" name="user_id" readonly>
                            </div>
                            <div class="col-4 ">
                                <label for="editUseYn">UseYn</label>
                                <select class="custom-select rounded-0" id="editUseYn" name="use_yn"></select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-4">
                                <label for="editUserNm">Name</label>
                                <input type="text" class="form-control" id="editUserNm" name="user_nm" placeholder="Please enter your Name">
                            </div>
                            <div class="col-4">
                                <label for="editEmail">Email</label>
                                <input type="text" class="form-control" id="editEmail" name="email" placeholder="Please enter your Email">
                            </div>
                            <div class="col-4">
                                <label for="editCellPhone">Cell Phone</label>
                                <input type="number" class="form-control" id="editCellPhone" name="cell_phone" placeholder="Please enter your Cell Phone">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="editUserPw">Password</label>
                                <input type="password" class="form-control" id="editUserPw" name="user_pw" placeholder="Please enter your password">
                            </div>
                            <div class="col-6">
                                <label for="editUserPwRe">Password Confirm</label>
                                <input type="password" class="form-control" id="editUserPwRe" placeholder="Please enter your password">
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
</body>
</html>
