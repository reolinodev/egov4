import { setCodeSelBox } from "../module/component";
import Page, { setPagination } from "../module/pagination"
import { serializeFormJson } from "../module/json";
import { setBasicGrid, setGridClickEvent } from "../module/grid";
import { checkKr } from "../module/validation";
import { Alert } from "../module/alert";

let page = new Page(1, false, 10, 0);
let grid;
let pagination;

const pageInit = () => {
    page = new Page(1, false, Number($("#pagePer").val()),  0);
}

/**
 * search : 조회
 */
const search = () => {

    const params = serializeFormJson('userMngViewFrm');
    params.current_page = page.currentPage;
    params.page_per = page.pagePer;

    $.ajax({
        url : '/api/user/',
        type: 'POST',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
        success (result){
            const gridData = result.data;
            page.totalCount = result.total;
            grid.resetData(gridData);

            // eslint-disable-next-line no-use-before-define
            setGridClickEvent(grid, "login_id", "user_id", userMngEdit);
            // eslint-disable-next-line no-use-before-define
            setGridClickEvent(grid, "user_nm", "user_id", userMngEdit);

            if(page.pageInit === false){
                pagination.reset(result.total);
                page.pageInit = true;
            }
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

/**
 * setGridLayout : 그리드 구성
 */
const setGridLayout = () => {
    // 헤더 생성
    const columns = [
        {header: 'No', name: 'rnum', width :100, align : 'center'},
        {header: 'SEQ', name: 'user_id', width :100, align : 'center', hidden : true},
        {header: 'Login Id', name: 'login_id', align : 'center'},
        {header: 'Name', name: 'user_nm', align : 'center'},
        {header: 'Email', name: 'email'},
        {header: 'Use', name: 'use_yn_nm', width :150, align : 'center'}
    ];
    // 데이터
    const gridData = [];

    return setBasicGrid(columns,gridData);
}

/**
 * pagingCallback : 페이징 콜백
 */
const pagingCallback = (returnPage) => {
    page.currentPage = returnPage;
    search();
}

const $writeLoginId = $('#writeLoginId');
const $writeUserNm = $('#writeUserNm');
const $writeEmail = $('#writeEmail');
const $writeUserPw = $('#writeUserPw');
const $writeUserPwRe = $('#writeUserPwRe');
const $writeCellPhone = $('#writeCellPhone');

/**
 * signUpCheck : 아이디 체크
 */
const signUpCheck = () => {
    if ($writeLoginId.val() === '') {
        $('#writeMsg').html('Please enter ID');
        return;
    }

    $.ajax({
        url: `/api/user/${$writeLoginId.val()}`,
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            $('#signUpChk').val('Y');
            $('#writeMsg').html(data.header.message);
        }
    }, (request, status, error) => {
        if (request.responseJSON.header.resultCode === 'fail') {
            $('#signUpChk').val('N');
            $('#writeMsg').html(request.responseJSON.header.message);
        }
        console.log(
            `code:${request.status}\n` +
            `message:${request.responseText}\n` +
            `error:${error}`
        );
    });
}

/**
 * initUserMngWrite : 등록화면의 값 초기화
 */
const initUserMngWrite = () => {
    $writeLoginId.val('');
    $writeUserNm.val('');
    $writeEmail.val('');
    $writeCellPhone.val('');
    $writeUserPw.val('');
    $writeUserPwRe.val('');
    $("#writeMsg").html('');
}

/**
 *  signUpProc : 사용자 등록
 */
const signUpProc = () => {
    let msg = '';

    if ($writeLoginId.val() === '') {
        msg = 'Please enter ID';
        $('#writeMsg').html(msg);
        $writeLoginId.focus();
        return;
    }
    if (checkKr($writeLoginId.val())) {
        msg = 'You cannot enter Korean characters in the ID';
        $('#writeMsg').html(msg);
        $writeLoginId.focus();
        return;
    }
    if ($('#signUpChk').val() === 'N') {
        msg = 'Please check the ID';
        $('#writeMsg').html(msg);
        $writeLoginId.focus();
        return;
    }
    if ($writeUserNm.val() === '') {
        msg = 'Please enter name.';
        $('#writeMsg').html(msg);
        $writeUserNm.focus();
        return;
    }
    if ($writeEmail.val() === '') {
        msg = 'Please enter e-mail';
        $('#writeMsg').html(msg);
        $writeEmail.focus();
        return;
    }
    if ($writeCellPhone.val() === '') {
        msg = 'Please enter phone number';
        $('#writeMsg').html(msg);
        $writeCellPhone.focus();
        return;
    }
    if ($writeUserPw.val() === '') {
        msg = 'Please enter a password';
        $('#writeMsg').html(msg);
        $writeUserPw.focus();
        return;
    }
    if ($writeUserPwRe.val() === '') {
        msg = 'Please re-enter your password';
        $('#writeMsg').html(msg);
        $writeUserPwRe.focus();
        return;
    }
    if ($writeUserPw.val() !== $writeUserPwRe.val()) {
        msg = 'Passwords do not match';
        $('#writeMsg').html(msg);
        $writeUserPw.focus();
        return;
    }

    const param = {
        login_id: $writeLoginId.val(),
        user_nm: $writeUserNm.val(),
        email: $writeEmail.val(),
        cell_phone: $writeCellPhone.val(),
        user_pw: $writeUserPw.val(),
    };

    $.ajax({
        url: "/api/user/",
        type: 'PUT',
        data: JSON.stringify(param),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            Alert(data.header.message);
            search();
            // eslint-disable-next-line no-use-before-define
            closeModal();
        } else {
            $('#writeMsg').html(data.header.message);
        }
    }, (request, status, error) => {
        if(request.status === 500){
            console.log(
                `code:${request.status}\n` +
                `message:${request.responseText}\n` +
                `error:${error}`
            );
        }else if(request.status === 400){
            const {errorList} = request.responseJSON;
            if(errorList !== undefined){
                if(errorList.lengh !==0){
                    const {message} = errorList[0];
                    $('#writeMsg').html(message);
                }
            }else {
                const data = request.responseJSON.header;
                $('#writeMsg').html(data.message);
            }
        }
    });
};

const $editLoginId = $('#editLoginId');
const $editUserId = $('#editUserid');
const $editUserNm = $('#editUserNm');
const $editEmail = $('#editEmail');
const $editUserPw = $('#editUserPw');
const $editUserPwRe = $('#editUserPwRe');
const $editCellPhone = $('#editCellPhone');
const $editUseYn = $('#editUseYn');

/**
 * userMngEdit : 사용자 수정 화면 호출
 */
const userMngEdit = (userId) =>  {
    $.ajax({
        url: `/api/user/info/${userId}`,
        type: 'GET',
        headers: {'Content-Type': 'application/json'},
        success (result){
            // eslint-disable-next-line no-use-before-define
            setEditData(result.data)
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

/**
 * setEditData : 에디트 데이터 셋
 */
const setEditData = (data) => {

    setCodeSelBox('editUseYn','USE_YN','',data.use_yn);

    $editLoginId.val(data.login_id);
    $editUserId.val(data.user_id);
    $editUserNm.val(data.user_nm);
    $editEmail.val(data.email);
    $editCellPhone.val(data.cell_phone);
    $editUserPw.val('');
    $editUserPwRe.val('');

    window.$('#userMngEdit').modal('show');
}

/**
 *  editProc : 사용자 수정
 */
const editProc = () => {
    let msg = '';

    if ($editUserNm.val() === '') {
        msg = 'Please enter name.';
        $('#editMsg').html(msg);
        $editUserNm.focus();
        return;
    }
    if ($editEmail.val() === '') {
        msg = 'Please enter e-mail';
        $('#editMsg').html(msg);
        $editEmail.focus();
        return;
    }
    if ($editCellPhone.val() === '') {
        msg = 'Please enter phone number';
        $('#editMsg').html(msg);
        $editCellPhone.focus();
        return;
    }
    if ($editUserPw.val() === '') {
        msg = 'Please enter a password';
        $('#editMsg').html(msg);
        $writeUserPw.focus();
        return;
    }
    if ($editUserPwRe.val() === '') {
        msg = 'Please re-enter your password';
        $('#editMsg').html(msg);
        $writeUserPwRe.focus();
        return;
    }
    if ($editUserPw.val() !== $editUserPwRe.val()) {
        msg = 'Passwords do not match';
        $('#editMsg').html(msg);
        $editUserPw.focus();
        return;
    }

    const param = {
        user_id: $editUserId.val(),
        user_nm: $editUserNm.val(),
        email: $editEmail.val(),
        cell_phone: $editCellPhone.val(),
        user_pw: $editUserPw.val(),
        use_yn: $editUseYn.val()
    };

    $.ajax({
        url: `/api/user/info/${$editUserId.val()}`,
        type: 'PUT',
        data: JSON.stringify(param),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            Alert(data.header.message);
            search();
            // eslint-disable-next-line no-use-before-define
            closeModal();
        } else {
            $('#editMsg').html(data.header.message);
        }
    }, (request, status, error) => {
        if(request.status === 500){
            console.log(
                `code:${request.status}\n` +
                `message:${request.responseText}\n` +
                `error:${error}`
            );
        }else if(request.status === 400){
            const {errorList} = request.responseJSON;
            if(errorList !== undefined){
                if(errorList.lengh !==0){
                    const {message} = errorList[0];
                    $('#editMsg').html(message);
                }
            }else {
                const data = request.responseJSON.header;
                $('#editMsg').html(data.message);
            }
        }
    });
};

/**
 * closeModal : 모달 닫기
 */
const closeModal = () => {
    window.$('#userMngWrite').modal('hide');
    window.$('#userMngEdit').modal('hide');
}

$(document).ready(() => {
    // 셀렉트 박스(공통코드) : 사용구분 => page
    setCodeSelBox('viewUseYn','USE_YN','ALL','' );

    // 그리드 세팅
    grid = setGridLayout();

    // 페이징 세팅
    pagination = setPagination(page, pagingCallback);

    // 검색버튼
    $("#searchBtn").click(()=> {
        pageInit();
        search();
    });

    // 사용여부, 페이지 개수 변경시 검색
    $("#viewUseYn").change(()=> {
        pageInit();
        search();
    });

    // 사용여부, 페이지 개수 변경시 검색
    $("#pagePer").change(()=> {
        pageInit();
        pagination = setPagination(page, pagingCallback);
        search();
    });

    // 등록버튼 클릭시 모달을 초기화한다.
    $("#writeBtn").click(()=> {
        initUserMngWrite();
    });

    // 아이디 체크
    $("#signUpCheckBtn").click(()=> {
        signUpCheck();
    });

    // 사용자를 등록한다.
    $("#submitBtn").click(()=> {
        signUpProc();
    });

    // 사용자를 수정한다.
    $("#editBtn").click(()=> {
        editProc();
    });

    search();
});




