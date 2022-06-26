import {setCodeSelBoxCall} from "../module/component";
import {setBasicTree} from "../module/tree";
import {Alert} from "../module/alert";
import {setBasicGrid} from "../module/grid";

// eslint-disable-next-line no-unused-vars
let tree;
let grid;

/**
 * search : 메뉴트리 조회
 */
const search = () => {

    $.ajax({
        url : `/api/admin/menu/${$("#authRole").val()}`,
        type: 'GET',
        headers: {'Content-Type': 'application/json'},
        success (result){
            // eslint-disable-next-line no-use-before-define
           setMenuList(result.data);
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

/**
 * setMenuList : 조회된 데이터 트리 데이터로 정제 후 트리컴퍼넌트 호출
 */
const setMenuList = (list) => {

    const menu = [];

    // eslint-disable-next-line no-restricted-syntax
    for (const data of list) {

        if(data.menu_lv === 1){
            const obj1 ={};
            const children = [];

            obj1.text = data.menu_nm;
            obj1.target = data.menu_id;
            // eslint-disable-next-line no-restricted-syntax
            for (const data2 of list) {
                if(data.menu_id === data2.parent_id){
                    const obj2 ={};
                    obj2.text = data2.menu_nm;
                    obj2.target = data2.menu_id;
                    children.push(obj2);
                }
            }
            obj1.children = children;
            menu.push(obj1);
        }
    }

    // eslint-disable-next-line no-use-before-define
    tree = setBasicTree(menu,setMenuId);
}

/**
 * setGridLayout : 권한 그리드 구성
 */
const setGridLayout = () => {
    const columns = [
        {header: 'Auth Id', name: 'auth_id', align : 'center', hidden : true},
        {header: 'Auth Name', name: 'auth_nm', align : 'left'},
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
        },
        {header: 'Updated Date', name: 'updated_at', align : 'left'},
        {header: 'Modifier', name: 'updated_nm', align : 'center'},
    ];
    const gridData = [];
    return setBasicGrid(columns,gridData);
}
const setMenuId = (menuId) => {
    $("#menuId").val(menuId);

    // eslint-disable-next-line no-use-before-define
    searchAuthMenu();
}


/**
 * searchMenuInfo : 메뉴 상세 정보 조회하기
 */
const searchAuthMenu = () => {

    const params =  {
        auth_role : $("#authRole").val(),
        menu_id :  $("#menuId").val(),
    }

    $.ajax({
        url: '/api/admin/authMenu/',
        type: 'POST',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
        success (result){
            const gridData = result.data;
            grid.resetData(gridData);
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

const saveProc = (updatedRows) => {

    const param =  {
        menu_id: $("#menuId").val(),
        updated_rows : updatedRows,
    }

    $.ajax({
        url: '/api/admin/authMenu/',
        type: 'PUT',
        data: JSON.stringify(param),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        searchAuthMenu();
        Alert(data.header.message);
    }, (request, status, error) => {
        console.log(
            // eslint-disable-next-line no-useless-concat
            `code:${request.status}\n` + `message:${request.responseText}\n` + `error:${error}`
        );

    });
}

const initAuth = () => {
    $("#menuId").val('');
    const gridData = [];
    grid.resetData(gridData);
}


$(document).ready(() => {
    setCodeSelBoxCall('authRole','AUTH_ROLE','','ADMIN', search);

    // 권한 구분 변경시 검색
    $("#authRole").change(()=> {
        initAuth();
        search();
    });

    grid = setGridLayout();

    // 저장 버튼 클릭 이벤트
    $("#saveBtn").click(() => {
        const rows = grid.getModifiedRows();
        const {updatedRows} = rows;

        if($("#menuId").val() === ''){
            Alert('The selected menu does not exist.');
            return;
        }

        if(updatedRows.length === 0){
            Alert('No changes have been made.');
            return;
        }

        saveProc(updatedRows);
    });
});


