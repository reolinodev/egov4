import {setCodeSelBox, setCommSelBox} from "../../module/component";
import Page, { setPagination } from "../../module/pagination"
import { serializeFormJson } from "../../module/json";
import {
    setCheckBoxGrid,
    getCheckedRows,
    setCheckBoxGridId,
} from "../../module/grid";
import { Alert } from "../../module/alert";

let page = new Page(1, false, 10, 0);
let grid;
let grid2;
let pagination;
let selectedData = [];

$(document).ready(function() {
    setCodeSelBox('authRole','AUTH_ROLE','SEL','' );

    setCommSelBox('authId','','','SEL', '', '', '');

    setCodeSelBox('pagePer','PAGE_PER','','10' );

    //그리드 세팅
    grid = setGridLayout();
    grid2 = setGridLayout2();

    //페이징 세팅
    pagination = setPagination(page, pagingCallback);

    //권한 구분 변경시 권한 변경
    $("#authRole").change(function(){

        const authRole =  $("#authRole").val();

        if(authRole === ''){
            setCommSelBox('authId','','','SEL', '', '', '');
        }else{
            let params= {
                auth_role : authRole
            }
            let option = {
                oTxt: 'auth_nm',
                oVal: 'auth_id'
            }
            setCommSelBox('authId','/api/auth/role','POST', 'SEL', '', params, option);
        }
    });

    //권한 선택시 검색
    $("#authId").change(function(){
        pageInit();
        search();
    });

    //검색버튼 클릭시 검색
    $("#searchIcon").click(function(){
        pageInit();
        search();
    });

    //추가 버튼 클릭 이벤트
    $("#addBtn").click(function(){
        setAuthUser();
    });

    //페이지 개수 변경시 검색
    $("#pagePer").change(function(){
        pageInit();
        pagination = setPagination(page, pagingCallback);
        search();
    });

    //삭제 버튼 클릭 이벤트
    $("#delBtn").click(function(){
        deleteAuthUser();
    });


    //저장 버튼 클릭 이벤트
    $("#saveBtn").click(function(){
        insertProc();
    });

    //뒤로가기 버튼 클릭 이벤트
    $("#backBtn").click(function(){
        location.href = '/user/authUserMng';
    });

});

//페이징 초기화
const pageInit = () => {
    page = new Page(1, false, Number($("#pagePer").val()),  0);
}

/**
 * search : 조회
 */
const search = () => {

    let params = serializeFormJson('authUserMngWriteFrm');
    params.current_page = page.currentPage;
    params.page_per = page.pagePer;

    if(params.auth_id === ''){
        Alert('Please Choose auth');
        return;
    }

    $.ajax({
        url : '/api/userAuth/user',
        type: 'POST',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
        success : function (result){
            const gridData = result.data;
            page.totalCount = result.total;
            grid.resetData(gridData);

            if(page.pageInit === false){
                pagination.reset(result.total);
                page.pageInit = true;
            }
        },
        error : function (request, status, error){
            console.log('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}

/**
 * setGridLayout : Choose User 그리드 구성
 */
const setGridLayout = () => {
    const columns = [
        {header: 'SEQ', name: 'user_id', align : 'center', hidden : true},
        {header: 'ID', name: 'login_id', align : 'center'},
        {header: 'Name', name: 'user_nm', align : 'center'},
        {header: 'Email', name: 'email', align : 'center'},
    ];
    const gridData = [];

    return setCheckBoxGrid(columns,gridData);
}

/**
 * setGridLayout2 : Selected User 그리드 구성
 */
const setGridLayout2 = () => {
    const columns = [
        {header: 'SEQ', name: 'user_id', align : 'center', hidden : true},
        {header: 'ID', name: 'login_id', align : 'center'},
        {header: 'Name', name: 'user_nm', align : 'center'},
        {header: 'Email', name: 'email', align : 'center'},
    ];
    const gridData = [];
    return setCheckBoxGridId(columns,gridData, 'grid2');
}

/**
 * pagingCallback : 페이징 콜백
 */
const pagingCallback = (returnPage) => {
    page.currentPage = returnPage;
    search();
}

/**
 * setAuthUser : 사용자 선택
 */
const setAuthUser = () => {
    if($("#authId").val() === ''){
        Alert('Please Choose auth');
        return;
    }

    const checkedRows =  getCheckedRows(grid);
    if(checkedRows.length === 0 ){
        Alert('Please Check Row');
        return;
    }

    setSelectedUser(checkedRows);
}

/**
 * setSelectedUser : Selected User 그리드에 데이터 매핑핑
 */
const setSelectedUser = (list) => {

    for (const obj of list) {
        selectedData.push(obj);
    }

    selectedData = removeDuplicateItem(selectedData);

    grid2.resetData(selectedData);
}
/**
 * removeDuplicateItem : 사용자 아이디 중복 항목 제거
 */
const removeDuplicateItem = (data) => {
    let uniqueData;
    uniqueData = data.filter((character, idx, arr) => {
        return arr.findIndex((item) => item.user_id === character.user_id) === idx
    });

    return uniqueData;
}

/**
 * deleteAuthUser : 사용자 삭제
 */
const deleteAuthUser = () => {
    grid2.removeCheckedRows();
    selectedData = grid2.getData();
}

/**
 *  insertProc : 권한 등록
 */
const insertProc = () => {

    if($("#authId").val() === ''){
        Alert('Please choose auth');
        return;
    }

    if(selectedData.length === 0 ){
        Alert('Pleas selected user');
        return;
    }

    let userArr = [];

    for (const obj of selectedData) {
        userArr.push(obj.user_id);
    }

    const params = {
        auth_id: $("#authId").val(),
        user_arr:  userArr,
    };

    $.ajax({
        url: "/api/userAuth/",
        type: 'PUT',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            Alert(data.header.message);
            refreshSearch();
        }
    }, (request, status, error) => {
        if(request.status === 500){
            console.log(
                `code:${request.status}\n` +
                `message:${request.responseText}\n` +
                `error:${error}`
            );
        }else if(request.status === 400){
            const errorList = request.responseJSON.errorList;
            if(errorList !== undefined){
                if(errorList.lengh !==0){
                    const message = errorList[0].message;
                    Alert(message);
                }
            }else {
                const data = request.responseJSON.header;
                Alert(data.message);
            }
        }
    });
};

/**
 *  refreshSearch :  재검색하기
 */

const refreshSearch = () => {
    pageInit();
    $("#searchStr").val("");
    selectedData = [];
    grid2.resetData(selectedData);
    search();
}
