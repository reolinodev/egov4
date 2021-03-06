import { setCodeSelBox, setCommSelBox } from "../module/component";
import Page, {setPagination} from "../module/pagination";
import {setCheckBoxGrid} from "../module/grid";
import {serializeFormJson} from "../module/json";
import {Alert, Confirm} from "../module/alert";

let page = new Page(1, false, 10, 0);
let grid;
let pagination;

/**
 * setGridLayout : 그리드 구성
 */
const setGridLayout = () => {
    // 헤더 생성
    const columns = [
        {header: 'No', name: 'rnum', width :100, align : 'center'},
        {header: 'Auth Id', name: 'auth_id', align : 'center', hidden : true},
        {header: 'User Id', name: 'user_id', align : 'center', hidden : true},
        {header: 'Auth Role', name: 'auth_role_nm', align : 'center'},
        {header: 'Auth Name', name: 'auth_nm', align : 'center'},
        {header: 'Id', name: 'login_id', align : 'center'},
        {header: 'Email', name: 'email', align : 'center'},
        {header: 'Name', name: 'user_nm', align : 'center'}
    ];
    // 데이터
    const gridData = [];

    return setCheckBoxGrid(columns,gridData);
}

/**
 * pagingCallback : 페이징 콜백
 */
const pagingCallback = (returnPage) => {
    page.currentPage = returnPage;
    // eslint-disable-next-line no-use-before-define
    search();
}


/**
 * search : 조회
 */
const search = () => {

    const params = serializeFormJson('authUserMngViewFrm');
    params.current_page = page.currentPage;
    params.page_per = page.pagePer;

    $.ajax({
        url : '/api/admin/userAuth/',
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

            if($("#viewAuthId").val() !== ''){
                $("#deleteBtn").show();
            }else{
                $("#deleteBtn").hide();
            }
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

const pageInit = () => {
    page = new Page(1, false, Number($("#pagePer").val()),  0);
}

const delProc = () => {
    const checkedRows = grid.getCheckedRows();
    if(checkedRows.length === 0){
        Alert('There are no items selected');
        return;
    }

    const userArr = [];

    // eslint-disable-next-line no-restricted-syntax
    for (const obj of checkedRows) {
        userArr.push(obj.user_id);
    }

    const params = {
        auth_id: $("#viewAuthId").val(),
        user_arr:  userArr,
    };

    $.ajax({
        url: "/api/admin/userAuth/",
        type: 'DELETE',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            Alert(data.header.message);
            pageInit();
            search();
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
                    Alert(message);
                }
            }else {
                const data = request.responseJSON.header;
                Alert(data.message);
            }
        }
    });
}

$(document).ready(() => {

    // 셀렉트 박스(공통코드) : 권한구분 => page
    setCodeSelBox('viewAuthRole','AUTH_ROLE','ALL','' );

    // 셀렉트 박스(일반) : 권한명(권한 아이디로 조회) => page
    setCommSelBox('viewAuthId','','','ALL', '', '', '');

    /**
     * 권한구분 변경시 권한명 셀렉트 박스의 옵션을 갱신한다
     */
    $("#viewAuthRole").change(()=> {
        const authRole =  $("#viewAuthRole").val();

        if(authRole === ''){
            setCommSelBox('viewAuthId','','','ALL', '', '', '');
        }else{
            const params= {
                auth_role : authRole
            }
            const option = {
                oTxt: 'auth_nm',
                oVal: 'auth_id'
            }
            setCommSelBox('viewAuthId','/api/admin/auth/role','POST', 'ALL', '', params, option);
        }
    });

    /**
     * 권한 아이디 변경시 검색
     */
    $("#viewAuthId").change(()=> {
        pageInit();
        search();
    });

    /**
     * 사용자 권한 등록
     */
    $("#writeBtn").click(()=> {
        // eslint-disable-next-line no-restricted-globals
        location.href = '/admin/user/userAuth/write';
    });

    // 검색버튼
    $("#searchBtn").click(()=> {
        pageInit();
        search();
    });

    // 사용여부, 페이지 개수 변경시 검색
    $("#pagePer").change(()=> {
        pageInit();
        pagination = setPagination(page, pagingCallback);
        search();
    });

    // 사용여부, 페이지 개수 변경시 검색
    $("#deleteBtn").click(()=> {
        Confirm('Are you sure you want to delete the authority?', delProc);
    });

    // 그리드 세팅
    grid = setGridLayout();

    // 페이징 세팅
    pagination = setPagination(page, pagingCallback);

    // 검색
    search();
});
