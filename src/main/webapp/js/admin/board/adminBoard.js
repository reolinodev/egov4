import {setCodeSelBox} from "../module/component";
import Page, {setPagination} from "../module/pagination";
import {setBasicGrid, setGridClickEvent} from "../module/grid";
import {serializeFormJson} from "../module/json";
import {Alert} from "../module/alert";

let page = new Page(1, false, 10, 0);
let grid;
let pagination;

const pageInit = () => {
    page = new Page(1, false, Number($("#pagePer").val()),  0);
}

/**
 * setGridLayout : 그리드 구성
 */
const setGridLayout = () => {
    // 헤더 생성
    const columns = [
        {header: 'No', name: 'rnum', width :100, align : 'center'},
        {header: 'SEQ', name: 'board_id', width :100, align : 'center', hidden : true},
        {header: 'Title', name: 'title', align : 'center'},
        {header: 'Type', name: 'board_type_nm', width :200, align : 'center'},
        {header: 'Name', name: 'updated_nm', width :200, align : 'center'},
        {header: 'Updated Date', name: 'updated_at', width :200, align : 'center'},
        {header: 'Use', name: 'use_yn_nm', width :150, align : 'center'}
    ];
    // 데이터
    const gridData = [];

    return setBasicGrid(columns,gridData);
}

/**
 * boardEdit : 게시판 수정 화면 호출
 */
const boardEdit = (boardId) =>  {
    $.ajax({
        url: `/api/admin/board/info/${boardId}`,
        type: 'GET',
        headers: {'Content-Type': 'application/json'},
        success (result){
            // eslint-disable-next-line no-use-before-define
            setBoardEditData(result.data)
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

/**
 * setBoardEditData : 수정화면
 */
const setBoardEditData = (data) => {

    setCodeSelBox('editUseYn','USE_YN','',data.use_yn);
    setCodeSelBox('editBoardType','BOARD_TYPE','',data.board_type);
    $("#editTitle").val(data.title);
    $("#editBigo").val(data.bigo);
    $("#editBoardId").val(data.board_id);

    $("#editBoardType").attr("disabled",true);

    window.$('#boardEdit').modal('show');
}


/**
 * search : 조회
 */
const search = () => {

    const params = serializeFormJson('boardViewFrm');
    params.current_page = page.currentPage;
    params.page_per = page.pagePer;

    $.ajax({
        url : '/api/admin/board/',
        type: 'POST',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
        success (result){
            const gridData = result.data;
            page.totalCount = result.total;
            grid.resetData(gridData);

            // eslint-disable-next-line no-use-before-define
            setGridClickEvent(grid, "title", "board_id", boardEdit);

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
 * initUserMngWrite : 등록화면의 값 초기화
 */
const initBoardWrite = () => {
    setCodeSelBox('writeBoardType','BOARD_TYPE','','' );
    $("#writeTitle").val('');
    $("#writeBigo").val('');
}

/**
 *  saveProc : 게시판 등록
 */
const saveProc = () => {
    let msg = '';

    if ($("#writeTitle").val() === '') {
        msg = 'Please enter Title';
        $('#writeMsg').html(msg);
        $("#writeTitle").focus();
        return;
    }

    const param = {
        title: $("#writeTitle").val(),
        bigo: $("#writeBigo").val(),
        board_type: $("#writeBoardType").val(),
    };

    $.ajax({
        url: "/api/admin/board/",
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

/**
 *  editProc : 사용자 수정
 */
const editProc = () => {
    let msg = '';

    if ($("#editTitle").val() === '') {
        msg = 'Please enter Title';
        $('#editMsg').html(msg);
        $("#editTitle").focus();
        return;
    }

    const param = {
        title: $("#editTitle").val(),
        bigo: $("#editBigo").val(),
        use_yn: $("#editUseYn").val(),
    };

    $.ajax({
        url: '/api/admin/board/'+$("#editBoardId").val(),
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
 * pagingCallback : 페이징 콜백
 */
const pagingCallback = (returnPage) => {
    page.currentPage = returnPage;
    search();
}

/**
 * closeModal : 모달 닫기
 */
const closeModal = () => {
    window.$('#boardWrite').modal('hide');
    window.$('#boardEdit').modal('hide');
}

$(document).ready(() => {
    setCodeSelBox('viewBoardType','BOARD_TYPE','ALL','' );

    setCodeSelBox('viewUseYn','USE_YN','ALL','' );

    grid = setGridLayout();

    pagination = setPagination(page, pagingCallback);

    $("#searchBtn").click(()=> {
        pageInit();
        search();
    });

    $("#writeBtn").click(()=> {
        initBoardWrite();
    });

    $("#writeSaveBtn").click(()=> {
        saveProc();
    });

    $("#pagePer").change(()=> {
        pageInit();
        pagination = setPagination(page, pagingCallback);
        search();
    });

    $("#viewUseYn").change(()=> {
        pageInit();
        search();
    });

    $("#viewBoardType").change(()=> {
        pageInit();
        search();
    });

    $("#editSaveBtn").click(()=> {
        editProc();
    });

    search();
});
