import {setCommSelBox, setCodeSelBox} from "../module/component";
import Page, {setPagination} from "../module/pagination";
import {setBasicGrid, setGridClickEvent} from "../module/grid";
import {serializeFormJson} from "../module/json";

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
        {header: 'SEQ', name: 'post_id', width :100, align : 'center', hidden : true},
        {header: 'Board', name: 'board_title', width :200, align : 'center'},
        {header: 'Title', name: 'title', align : 'left'},
        {header: 'Name', name: 'updated_nm', width :200, align : 'center'},
        {header: 'Use', name: 'use_yn_nm', width :150, align : 'center'}
    ];
    // 데이터
    const gridData = [];

    return setBasicGrid(columns,gridData);
}

/** 
 * faqView : faq 수정
 */
const faqView = (faqId) =>  {
    location.href = '/admin/board/faq/edit/'+faqId;
}

/**
 * search : 조회
 */
const search = () => {

    const params = serializeFormJson('faqViewFrm');
    params.current_page = page.currentPage;
    params.page_per = page.pagePer;

    $.ajax({
        url : '/api/admin/faq/',
        type: 'POST',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
        success (result){
            const gridData = result.data;
            page.totalCount = result.total;
            grid.resetData(gridData);

            // eslint-disable-next-line no-use-before-define
            setGridClickEvent(grid, "title", "faq_id", faqView);

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
 * pagingCallback : 페이징 콜백
 */
const pagingCallback = (returnPage) => {
    page.currentPage = returnPage;
    search();
}


$(document).ready(() => {

    const option = {
        oTxt: 'title',
        oVal: 'board_id'
    }

    const params = {};

    setCommSelBox('boardId','/api/admin/board/select/faq','POST', 'ALL', '', params, option);

    setCodeSelBox('useYn','USE_YN','ALL','' );

    grid = setGridLayout();

    pagination = setPagination(page, pagingCallback);

    $("#searchBtn").click(()=> {
        pageInit();
        search();
    });

    $("#addBtn").click(()=> {
        location.href = '/admin/board/faq/write';
    });

    $("#pagePer").change(()=> {
        pageInit();
        pagination = setPagination(page, pagingCallback);
        search();
    });

    $("#boardId").change(()=> {
        pageInit();
        search();
    });

    $("#useYn").change(()=> {
        pageInit();
        search();
    });

    search();
});
