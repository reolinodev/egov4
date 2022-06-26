import {
    setCodeSelBox,
    setCodeSelBoxCall,
    setCommSelBox,
} from "../module/component";
import {setBasicTree} from "../module/tree";
import {checkKr} from "../module/validation";
import {Alert, Confirm} from "../module/alert";

// eslint-disable-next-line no-unused-vars
let tree;

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
    tree = setBasicTree(menu,searchMenuInfo);
}

/**
 * searchMenuInfo : 메뉴 상세 정보 조회하기
 */
const searchMenuInfo = (menuId) => {
    $.ajax({
        url: `/api/admin/menu/info/${menuId}`,
        type: 'GET',
        headers: {'Content-Type': 'application/json'},
        success (result){
            // eslint-disable-next-line no-use-before-define
            setMenuData(result.data)
        },
        error (request, status, error){
            // eslint-disable-next-line no-useless-concat
            console.log(`code:${request.status}\n`+`message:${request.responseText}\n`+`error:${error}`);
        }
    });
}

/**
 * setMenuData : 조회된 메뉴 데이터 화면에 매핑
 */
const setMenuData = (data) => {
    $("#menuId").val(data.menu_id);
    $("#menuLv").val(data.menu_lv);
    $("#menuNm").val(data.menu_nm);
    $("#menuUrl").val(data.menu_url);
    $("#useYn").val(data.use_yn);
    $("#ord").val(data.ord);

    if(data.menu_type==='url'){
        $('#menuType1').prop('checked', true);
    }else{
        $('#menuType2').prop('checked', true);
    }

    if(data.main_yn==='Y'){
        $('#mainYn').prop('checked', true);
    }else{
        $('#mainYn').prop('checked', false);
    }

    if(data.menu_lv===1){
        const str = '<option value="0">-- None --</option>';
        $('#parentId').html(str);
    }else{
        const authRole = $("#authRole").val();
        const params= {
            auth_role : authRole,
            parent_id : data.parent_id,
        }
        const option = {
            oTxt: 'menu_nm',
            oVal: 'menu_id'
        }
        setCommSelBox('parentId','/api/admin/menu/parent','POST', '', '', params, option);
    }

    $('#menuLv').attr('disabled', true);
    $('#parentId').attr('disabled', true);
}


/**
 * initMenuAdd : 메뉴 등록 초기화 하기
 */
const initMenuAdd = () => {
    $("#menuId").val('');
    $("#menuLv").val(1);

    const str = '<option value="0">-- None --</option>';
    $('#parentId').html(str);

    $('#menuType1').prop('checked', true);
    $("#menuNm").val('');
    $("#menuUrl").val('');
    $("#useYn").val('Y');
    $("#ord").val('');
    $('#mainYn').prop('checked', false);

    $('#menuLv').attr('disabled', false);
    $('#parentId').attr('disabled', false);
}

/**
 * delMenuProc : 메뉴 삭제
 */
const delMenuProc = () => {

    const param = {
        menu_id: $("#menuId").val(),
        menu_lv: $("#menuLv").val(),
    };

    $.ajax({
        url: '/api/admin/menu/',
        type: 'DELETE',
        data: JSON.stringify(param),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        Alert(data.header.message);
        if (data.header.resultCode === 'ok') {
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
    setCodeSelBoxCall('authRole','AUTH_ROLE','','ADMIN', search);

    setCodeSelBox('useYn','USE_YN','','Y' );

    // 권한 구분 변경시 검색
    $("#authRole").change(()=> {
        search();
        initMenuAdd();
    });

    // 메뉴 레벨 변경시 상위 메뉴 검색
    $("#menuLv").change(() => {
        if($("#menuLv").val() === "2"){
            const authRole = $("#authRole").val();
            const params= {
                auth_role : authRole
            }
            const option = {
                oTxt: 'menu_nm',
                oVal: 'menu_id'
            }
            setCommSelBox('parentId','/api/admin/menu/parent','POST', 'SEL', '', params, option);
        }else{
            const str = '<option value="0">-- None --</option>';
            $('#parentId').html(str);
        }
    });

    // 저장 버튼 클릭 이벤트
    $("#saveBtn").click(() => {
        let msg = '';

        if ($("#menuLv").val() === '2' && $("#parentId").val() === '') {
            msg = 'Please select Parent Menu';
            Alert(msg);
            $("#parentId").focus();
            return;
        }
        if ($("#menuNm").val() === '') {
            msg = 'Please input Menu Name';
            Alert(msg);
            $("#menuUrl").focus();
            return;
        }
        if (checkKr($("#menuUrl").val())) {
            msg = 'You cannot enter Korean characters in the Url';
            Alert(msg);
            $("#menuUrl").focus();
            return;
        }

        let mainYn ='N' ;
        if($('input[name="main_yn"]').is(":checked")){
            mainYn = 'Y';
        }

        const param = {
            auth_role: $("#authRole").val(),
            menu_lv: $("#menuLv").val(),
            parent_id: $("#parentId").val(),
            menu_nm: $("#menuNm").val(),
            menu_type: $("input[name='menu_type']:checked").val(),
            menu_url: $("#menuUrl").val(),
            use_yn: $("#useYn").val(),
            ord: $("#ord").val(),
            main_yn: mainYn,
        };

        let url = '/api/admin/menu/';

        if($("#menuId").val() !== ''){
            url = '/api/admin/menu/update';
            param.menu_id = $("#menuId").val();
        }

        $.ajax({
            url: url,
            type: 'PUT',
            data: JSON.stringify(param),
            headers: {'Content-Type': 'application/json'},
        }).then((data) => {
            Alert(data.header.message);
            if (data.header.resultCode === 'ok') {
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
    });

    // 추가 버튼 클릭 이벤트
    $("#addBtn").click(() => {
        initMenuAdd();
    });

    // 삭제 버튼 클릭 이벤트
    $("#delBtn").click(() => {
        if($("#menuId").val() ===''){
            Alert("No menu selected");
            return;
        }
        Confirm("Are you sure you want to delete the selected menu", delMenuProc);
    });

});


