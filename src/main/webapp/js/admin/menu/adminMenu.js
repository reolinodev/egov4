import {setCodeSelBoxCall} from "../module/component";
import {setBasicTree} from "../module/tree";

// import Page, { setPagination } from "../../module/pagination"
// import { serializeFormJson } from "../../module/json";
// import {
//     setBasicGrid,
//     getCheckedRows,
//     setCheckBoxGridId, setGridClickEvent,
// } from "../../module/grid";
// import { Alert } from "../../module/alert";
// import { checkDuplicateList, checkNullList } from "../../module/validation";

// eslint-disable-next-line no-unused-vars
let tree;

/**
 * search : 조회
 */
const search = () => {

    $.ajax({
        url : '/api/admin/menu/'+$("#authRole").val(),
        type: 'GET',
        headers: {'Content-Type': 'application/json'},
        success : function (result){
           setMenuList(result.data);
        },
        error : function (request, status, error){
            console.log('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}

/**
 * setMenuList : 메뉴 리스트 트리화 하기
 */
const setMenuList = (list) => {

    const menu = [];

    for (const data of list) {

        if(data.menu_lv === 1){
            let obj1 ={};
            let children = [];

            obj1.text = data.menu_nm;
            obj1.id = data.menu_id;
            for (const data2 of list) {
                if(data.menu_id === data2.parent_id){
                    let obj2 ={};
                    obj2.text = data2.menu_nm;
                    obj2.id = data2.menu_id;
                    children.push(obj2);
                }
            }
            obj1.children = children;
            menu.push(obj1);
        }
    }

    tree = setBasicTree(menu);
}




$(document).ready(() => {
    setCodeSelBoxCall('authRole','AUTH_ROLE','','ADMIN', search);

    // 권한 구분 변경시 검색
    $("#authRole").change(function(){
        search();
    });

    // 그리드 세팅
    // grid = setGridLayout();
    // grid2 = setGridLayout2();
    //
    // //페이징 세팅
    // pagination = setPagination(page, pagingCallback);
    //
    // //검색버튼 클릭시 검색
    // $("#searchGrpBtn").click(function(){
    //     pageInit();
    //     search_grp();
    // });
    //

    //
    //
    // //코드 그룹추가 버튼 클릭 이벤트(입력화면 호출)
    // $("#codeGrpAddBtn").click(function(){
    //     $("#writeCodeGrpNm").val('');
    //     $("#writeCodeGrpVal").val('');
    //     window.$('#codeGrpWrite').modal('show');
    // });
    //
    // //코드 그룹 입력화면 버튼 클릭 이벤트
    // $("#writeCodeGrpBtn").click(function(){
    //     insertGrpProc();
    // });
    //
    // //코드 그룹 수정화면 버튼 클릭 이벤트
    // $("#editCodeGrpBtn").click(function(){
    //     editGrpProc();
    // });
    //
    // //사용여부 변경시 검색
    // $("#useYn").change(function(){
    //     pageInit();
    //     search_grp();
    // });
    //
    //
    // //추가 버튼 클릭 이벤트
    // $("#addBtn").click(function(){
    //
    //     if(selectedCodeGrpId === 0){
    //         Alert('Please choose a code group.');
    //         return;
    //     }
    //
    //     const row = {code_id : '', code_grp_id : selectedCodeGrpId, code_nm: '', code_val: '', ord : '', bigo : '', use_yn: 'Y' };
    //     grid2.appendRow(row);
    // });
    //
    // //삭제 버튼 클릭 이벤트
    // $("#delBtn").click(function(){
    //     const checkedRows = grid2.getCheckedRows();
    //     if(checkedRows.length === 0){
    //         Alert('The checked value does not exist.');
    //         return;
    //     }
    //     grid2.removeCheckedRows();
    // });
    //
    // //저장 버튼 클릭 이벤트
    // $("#saveBtn").click(function(){
    //     const rows = grid2.getModifiedRows();
    //     const data = grid2.getData();
    //
    //     const createdRows = rows.createdRows;
    //     const updatedRows = rows.updatedRows;
    //     const deletedRows = rows.deletedRows;
    //
    //     if(createdRows.length===0 && updatedRows.length === 0 && deletedRows.length ===0){
    //         Alert('No changes have been made.');
    //         return;
    //     }
    //
    //     if(!checkNullList(data, 'code_nm')){
    //         Alert('Code name is null.');
    //         return;
    //     }
    //
    //     if(!checkNullList(data, 'code_val')){
    //         Alert('Code value is null.');
    //         return;
    //     }
    //
    //     if(!checkDuplicateList(data, 'code_val')){
    //         Alert('Duplicate code values exist..');
    //         return;
    //     }
    //
    //     const params =  {
    //         code_grp_id : selectedCodeGrpId,
    //         created_rows : createdRows,
    //         updated_rows : updatedRows,
    //         deleted_rows : deletedRows,
    //     }
    //
    //     $.ajax({
    //         url: '/api/code/'+selectedCodeGrpId,
    //         type: 'POST',
    //         data: JSON.stringify(params),
    //         headers: {'Content-Type': 'application/json'},
    //         success : function (result){
    //             if (result.header.resultCode === 'ok') {
    //                 Alert(result.header.message);
    //             }
    //         },
    //         error : function (request, status, error){
    //             if (request.status === 500) {
    //                 console.log(
    //                     `code:${request.status}\n` +
    //                     `message:${request.responseText}\n` +
    //                     `error:${error}`
    //                 );
    //             } else if (request.status === 400) {
    //                 const errorList = request.responseJSON.errorList;
    //                 if (errorList !== undefined) {
    //                     if (errorList.lengh !== 0) {
    //                         const message = errorList[0].message;
    //                         Alert(message);
    //                     }
    //                 } else {
    //                     const data = request.responseJSON.header;
    //                     Alert(data.message);
    //                 }
    //             }
    //         }
    //     });
    // });
});

// //페이징 초기화
// const pageInit = () => {
//     page = new Page(1, false, Number($("#pagePer").val()),  0);
// }
//
// /**
//  * search : 조회
//  */
// const search_grp = () => {
//
//     let params = serializeFormJson('codeGrpFrm');
//     params.current_page = page.currentPage;
//     params.page_per = page.pagePer;
//
//     $.ajax({
//         url : '/api/codeGrp/',
//         type: 'POST',
//         data: JSON.stringify(params),
//         headers: {'Content-Type': 'application/json'},
//         success : function (result){
//             const gridData = result.data;
//             page.totalCount = result.total;
//             grid.resetData(gridData);
//
//             if(page.pageInit === false){
//                 pagination.reset(result.total);
//                 page.pageInit = true;
//             }
//
//             setGridClickEvent(grid, "code_grp_nm", "code_grp_id", search);
//             setGridClickEvent(grid, "code_grp_val", "code_grp_id", codeMngEdit);
//         },
//         error : function (request, status, error){
//             console.log('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//         }
//     });
// }
//
// /**
//  * setGridLayout : Choose User 그리드 구성
//  */
// const setGridLayout = () => {
//     const columns = [
//         {header: 'SEQ', name: 'code_grp_id', align : 'center', hidden : true},
//         {header: 'Name', name: 'code_grp_nm', align : 'center'},
//         {header: 'Code', name: 'code_grp_val', align : 'center'},
//     ];
//     const gridData = [];
//
//     return setBasicGrid(columns,gridData);
// }
//
// /**
//  * setGridLayout2 : Selected User 그리드 구성
//  */
// const setGridLayout2 = () => {
//     const columns = [
//         {header: 'Code Id', name: 'code_id', align : 'center', hidden : true},
//         {header: 'Code Grp Id', name: 'code_grp_id', align : 'center', hidden : true},
//         {header: 'Name', name: 'code_nm', align : 'left', editor: 'text', validation: { required: true }},
//         {header: 'Value', name: 'code_val', align : 'left', editor: 'text', validation: { required: true }},
//         {header: 'Ord', name: 'ord', align : 'center', width: 50, editor: 'text'},
//         {header: 'Bigo', name: 'bigo', align : 'left', editor: 'text'},
//         {header: 'Use', name: 'use_yn', align : 'center', formatter: 'listItemText',
//             editor: {
//                 type: 'select',
//                 options: {
//                     listItems: [
//                         { text: '사용', value: 'Y' },
//                         { text: '미사용', value: 'N' },
//                     ]
//                 }
//             },
//         }
//     ];
//     const gridData = [];
//     return setCheckBoxGridId(columns,gridData, 'grid2');
// }
//
// /**
//  * pagingCallback : 페이징 콜백
//  */
// const pagingCallback = (returnPage) => {
//     page.currentPage = returnPage;
//     search_grp();
// }
//
// const $writeCodeGrpNm = $("#writeCodeGrpNm");
// const $writeCodeGrpVal = $("#writeCodeGrpVal");
//
// /**
//  *  insertGrpProc : 코드 그룹 등록
//  */
// const insertGrpProc = () => {
//
//     let msg = '';
//
//     if ($writeCodeGrpNm.val() === '') {
//         msg = 'Please enter name.';
//         $('#writeMsg').html(msg);
//         $writeCodeGrpNm.focus();
//         return;
//     }
//     if ($writeCodeGrpVal.val() === '') {
//         msg = 'Please enter code';
//         $('#writeMsg').html(msg);
//         $writeCodeGrpVal.focus();
//         return;
//     }
//
//     const params = {
//         code_grp_nm: $("#writeCodeGrpNm").val(),
//         code_grp_val:  $("#writeCodeGrpVal").val(),
//     };
//
//     $.ajax({
//         url: "/api/codeGrp/",
//         type: 'PUT',
//         data: JSON.stringify(params),
//         headers: {'Content-Type': 'application/json'},
//     }).then((data) => {
//         if (data.header.resultCode === 'ok') {
//             Alert(data.header.message);
//             pageInit();
//             search_grp();
//         }
//     }, (request, status, error) => {
//         if(request.status === 500){
//             console.log(
//                 `code:${request.status}\n` +
//                 `message:${request.responseText}\n` +
//                 `error:${error}`
//             );
//         }else if(request.status === 400){
//             const errorList = request.responseJSON.errorList;
//             if(errorList !== undefined){
//                 if(errorList.lengh !==0){
//                     const message = errorList[0].message;
//                     $('#writeMsg').html(message);
//                 }
//             }else {
//                 const data = request.responseJSON.header;
//                 $('#writeMsg').html(data.message);
//             }
//         }
//     });
// };
//
// /**
//  *  codeMngEdit : 코드 그룹 수정 호출
//  */
// const codeMngEdit = (code_grp_id) => {
//
//     // editUseYn
//     $.ajax({
//         url: '/api/codeGrp/info/'+code_grp_id,
//         type: 'GET',
//         headers: {'Content-Type': 'application/json'},
//         success : function (result){
//             setEditData(result.data)
//         },
//         error : function (request, status, error){
//             console.log('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//         }
//     });
// }
//
// const $editCodeGrpNm = $("#editCodeGrpNm");
// const $editCodeGrpId = $("#editCodeGrpId");
// const $editCodeGrpVal = $("#editCodeGrpVal");
//
// /**
//  *  setEditData : 데이터 매핑 및 모달 오픈
//  */
// const setEditData = (data) => {
//     setCodeSelBox('editUseYn','USE_YN','',data.use_yn);
//
//     $editCodeGrpId.val(data.code_grp_id);
//     $editCodeGrpNm.val(data.code_grp_nm);
//     $editCodeGrpVal.val(data.code_grp_val);
//
//     window.$('#codeGrpEdit').modal('show');
// }
//
// /**
//  *  editGrpProc : 코드 그룹 수정
//  */
// const editGrpProc = () => {
//
//     let msg = '';
//
//     if ($editCodeGrpNm.val() === '') {
//         msg = 'Please enter name.';
//         $('#editMsg').html(msg);
//         $editCodeGrpNm.focus();
//         return;
//     }
//
//     const params = {
//         code_grp_id: $editCodeGrpId.val(),
//         code_grp_nm: $editCodeGrpNm.val(),
//         code_grp_val:  $editCodeGrpVal.val(),
//         use_yn:  $("#editUseYn").val(),
//     };
//
//     $.ajax({
//         url: "/api/codeGrp/info/"+$editCodeGrpId.val(),
//         type: 'PUT',
//         data: JSON.stringify(params),
//         headers: {'Content-Type': 'application/json'},
//     }).then((data) => {
//         if (data.header.resultCode === 'ok') {
//             Alert(data.header.message);
//             pageInit();
//             search_grp();
//             window.$('#codeGrpEdit').modal('hide');
//         }
//     }, (request, status, error) => {
//         if(request.status === 500){
//             console.log(
//                 `code:${request.status}\n` +
//                 `message:${request.responseText}\n` +
//                 `error:${error}`
//             );
//         }else if(request.status === 400){
//             const errorList = request.responseJSON.errorList;
//             if(errorList !== undefined){
//                 if(errorList.lengh !==0){
//                     const message = errorList[0].message;
//                     $('#editMsg').html(message);
//                 }
//             }else {
//                 const data = request.responseJSON.header;
//                 $('#editMsg').html(data.message);
//             }
//         }
//     });
// };
//
// /**
//  * search : 조회
//  */
// const search = (code_grp_id) => {
//
//     selectedCodeGrpId = code_grp_id;
//
//     $.ajax({
//         url: "/api/code/"+code_grp_id,
//         type: 'GET',
//         headers: {'Content-Type': 'application/json'},
//         success : function (result){
//             const gridData = result.data;
//             grid2.resetData(gridData);
//         },
//         error : function (request, status, error){
//             console.log('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//         }
//     });
// }
