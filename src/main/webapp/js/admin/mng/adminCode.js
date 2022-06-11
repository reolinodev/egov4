import {setCodeSelBox} from "../module/component";
import Page, { setPagination } from "../module/pagination"
import { serializeFormJson } from "../module/json";
import {
    setBasicGrid,
    setCheckBoxGridId, setGridClickEvent,
} from "../module/grid";
import { Alert } from "../module/alert";
import { checkDuplicateList, checkNullList } from "../module/validation";

let page = new Page(1, false, 10, 0);
let grid;
let grid2;
let pagination;
let selectedCodeGrpId = 0;

// 페이징 초기화
const pageInit = () => {
    page = new Page(1, false, Number($("#pagePer").val()),  0);
}

/**
 * search : 조회
 */
const searchGrp = () => {

    const params = serializeFormJson('codeGrpFrm');
    params.current_page = page.currentPage;
    params.page_per = page.pagePer;

    $.ajax({
        url : '/api/admin/mng/codeGrp/',
        type: 'POST',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
        success (result){
            const gridData = result.data;
            page.totalCount = result.total;
            grid.resetData(gridData);

            if(page.pageInit === false){
                pagination.reset(result.total);
                page.pageInit = true;
            }

            // eslint-disable-next-line no-use-before-define
            setGridClickEvent(grid, "code_grp_nm", "code_grp_id", search);
            // eslint-disable-next-line no-use-before-define
            setGridClickEvent(grid, "code_grp_val", "code_grp_id", codeMngEdit);
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

/**
 * setGridLayout : Choose User 그리드 구성
 */
const setGridLayout = () => {
    const columns = [
        {header: 'SEQ', name: 'code_grp_id', align : 'center', hidden : true},
        {header: 'Name', name: 'code_grp_nm', align : 'center'},
        {header: 'Code', name: 'code_grp_val', align : 'center'},
    ];
    const gridData = [];

    return setBasicGrid(columns,gridData);
}

/**
 * setGridLayout2 : Selected User 그리드 구성
 */
const setGridLayout2 = () => {
    const columns = [
        {header: 'Code Id', name: 'code_id', align : 'center', hidden : true},
        {header: 'Code Grp Id', name: 'code_grp_id', align : 'center', hidden : true},
        {header: 'Name', name: 'code_nm', align : 'left', editor: 'text', validation: { required: true }},
        {header: 'Value', name: 'code_val', align : 'left', editor: 'text', validation: { required: true }},
        {header: 'Ord', name: 'ord', align : 'center', width: 50, editor: 'text'},
        {header: 'Bigo', name: 'bigo', align : 'left', editor: 'text'},
        {header: 'Use', name: 'use_yn', align : 'center', formatter: 'listItemText',
            editor: {
                type: 'select',
                options: {
                    listItems: [
                        { text: '사용', value: 'Y' },
                        { text: '미사용', value: 'N' },
                    ]
                }
            },
        }
    ];
    const gridData = [];
    return setCheckBoxGridId(columns,gridData, 'grid2');
}

/**
 * pagingCallback : 페이징 콜백
 */
const pagingCallback = (returnPage) => {
    page.currentPage = returnPage;
    searchGrp();
}

const $writeCodeGrpNm = $("#writeCodeGrpNm");
const $writeCodeGrpVal = $("#writeCodeGrpVal");

/**
 *  insertGrpProc : 코드 그룹 등록
 */
const insertGrpProc = () => {

    let msg = '';

    if ($writeCodeGrpNm.val() === '') {
        msg = 'Please enter name.';
        $('#writeMsg').html(msg);
        $writeCodeGrpNm.focus();
        return;
    }
    if ($writeCodeGrpVal.val() === '') {
        msg = 'Please enter code';
        $('#writeMsg').html(msg);
        $writeCodeGrpVal.focus();
        return;
    }

    const params = {
        code_grp_nm: $("#writeCodeGrpNm").val(),
        code_grp_val:  $("#writeCodeGrpVal").val(),
    };

    $.ajax({
        url: "/api/admin/mng/codeGrp/",
        type: 'PUT',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            Alert(data.header.message);
            pageInit();
            searchGrp();
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
 *  codeMngEdit : 코드 그룹 수정 호출
 */
const codeMngEdit = (codeGrpId) => {

    // editUseYn
    $.ajax({
        url: `/api/admin/mng/codeGrp/info/${codeGrpId}`,
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

const $editCodeGrpNm = $("#editCodeGrpNm");
const $editCodeGrpId = $("#editCodeGrpId");
const $editCodeGrpVal = $("#editCodeGrpVal");

/**
 *  setEditData : 데이터 매핑 및 모달 오픈
 */
const setEditData = (data) => {
    setCodeSelBox('editUseYn','USE_YN','',data.use_yn);

    $editCodeGrpId.val(data.code_grp_id);
    $editCodeGrpNm.val(data.code_grp_nm);
    $editCodeGrpVal.val(data.code_grp_val);

    window.$('#codeGrpEdit').modal('show');
}

/**
 *  editGrpProc : 코드 그룹 수정
 */
const editGrpProc = () => {

    let msg = '';

    if ($editCodeGrpNm.val() === '') {
        msg = 'Please enter name.';
        $('#editMsg').html(msg);
        $editCodeGrpNm.focus();
        return;
    }

    const params = {
        code_grp_id: $editCodeGrpId.val(),
        code_grp_nm: $editCodeGrpNm.val(),
        code_grp_val:  $editCodeGrpVal.val(),
        use_yn:  $("#editUseYn").val(),
    };

    $.ajax({
        url: `/api/admin/mng/codeGrp/info/${$editCodeGrpId.val()}`,
        type: 'PUT',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            Alert(data.header.message);
            pageInit();
            searchGrp();
            window.$('#codeGrpEdit').modal('hide');
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
 * search : 조회
 */
const search = (codeGrpId) => {

    selectedCodeGrpId = codeGrpId;

    $.ajax({
        url: `/api/admin/mng/code/${codeGrpId}`,
        type: 'GET',
        headers: {'Content-Type': 'application/json'},
        success (result){
            const gridData = result.data;
            grid2.resetData(gridData);
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

$(document).ready(() => {
    setCodeSelBox('useYn','USE_YN','','Y' );

    setCodeSelBox('pagePer','PAGE_PER','','10' );

    // 그리드 세팅
    grid = setGridLayout();
    grid2 = setGridLayout2();

    // 페이징 세팅
    pagination = setPagination(page, pagingCallback);

    // 검색버튼 클릭시 검색
    $("#searchGrpBtn").click(()=> {
        pageInit();
        searchGrp();
    });

    // 페이지 개수 변경시 검색
    $("#pagePer").change(()=> {
        pageInit();
        pagination = setPagination(page, pagingCallback);
        searchGrp();
    });


    // 코드 그룹추가 버튼 클릭 이벤트(입력화면 호출)
    $("#codeGrpAddBtn").click(()=> {
        $("#writeCodeGrpNm").val('');
        $("#writeCodeGrpVal").val('');
        window.$('#codeGrpWrite').modal('show');
    });

    // 코드 그룹 입력화면 버튼 클릭 이벤트
    $("#writeCodeGrpBtn").click(()=> {
        insertGrpProc();
    });

    // 코드 그룹 수정화면 버튼 클릭 이벤트
    $("#editCodeGrpBtn").click(()=> {
        editGrpProc();
    });

    // 사용여부 변경시 검색
    $("#useYn").change(()=> {
        pageInit();
        searchGrp();
    });


    // 추가 버튼 클릭 이벤트
    $("#addBtn").click(()=> {

        if(selectedCodeGrpId === 0){
            Alert('Please choose a code group.');
            return;
        }

        const row = {code_id : '', code_grp_id : selectedCodeGrpId, code_nm: '', code_val: '', ord : '', bigo : '', use_yn: 'Y' };
        grid2.appendRow(row);
    });

    // 삭제 버튼 클릭 이벤트
    $("#delBtn").click(()=> {
        const checkedRows = grid2.getCheckedRows();
        if(checkedRows.length === 0){
            Alert('The checked value does not exist.');
            return;
        }
        grid2.removeCheckedRows();
    });

    // 저장 버튼 클릭 이벤트
    $("#saveBtn").click(()=> {
        const rows = grid2.getModifiedRows();
        const data = grid2.getData();

        const {createdRows} = rows;
        const {updatedRows} = rows;
        const {deletedRows} = rows;

        if(createdRows.length===0 && updatedRows.length === 0 && deletedRows.length ===0){
            Alert('No changes have been made.');
            return;
        }

        if(!checkNullList(data, 'code_nm')){
            Alert('Code name is null.');
            return;
        }

        if(!checkNullList(data, 'code_val')){
            Alert('Code value is null.');
            return;
        }

        if(!checkDuplicateList(data, 'code_val')){
            Alert('Duplicate code values exist..');
            return;
        }

        const params =  {
            code_grp_id : selectedCodeGrpId,
            created_rows : createdRows,
            updated_rows : updatedRows,
            deleted_rows : deletedRows,
        }

        $.ajax({
            url: `/api/admin/mng/code/${selectedCodeGrpId}`,
            type: 'POST',
            data: JSON.stringify(params),
            headers: {'Content-Type': 'application/json'},
            success (result){
                if (result.header.resultCode === 'ok') {
                    Alert(result.header.message);
                }
            },
            error (request, status, error){
                if (request.status === 500) {
                    console.log(
                        `code:${request.status}\n` +
                        `message:${request.responseText}\n` +
                        `error:${error}`
                    );
                } else if (request.status === 400) {
                    const {errorList} = request.responseJSON;
                    if (errorList !== undefined) {
                        if (errorList.lengh !== 0) {
                            const {message} = errorList[0];
                            Alert(message);
                        }
                    } else {
                        // eslint-disable-next-line no-shadow
                        const data = request.responseJSON.header;
                        Alert(data.message);
                    }
                }
            }
        });
    });
});
