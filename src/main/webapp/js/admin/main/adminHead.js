import {setCommSelBox} from "../module/component";

/**
 *  logout : 로그아웃
 */
const logout = () => {
    sessionStorage.clear() // 전체삭제
    // eslint-disable-next-line no-restricted-globals
    location.href = "/admin/logout";
}

$(document).ready(() => {

    const userId = $("#userId").val();

    const params= {
        user_id : userId,
        auth_role : 'ADMIN'
    }
    const option = {
        oTxt: 'auth_nm',
        oVal: 'auth_id'
    }
    
    setCommSelBox('authId','/api/admin/auth/mine','POST', '', $("#authIdSet").val(), params, option);

    if($("#menuType").val() === "json"){
        $('#authId').prop('disabled', true);
    }

    // 권한 변경시
    $("#authId").change(()=> {
        sessionStorage.removeItem('url');
        sessionStorage.removeItem('parentMenuName');
        sessionStorage.removeItem('childMenuName');
        // eslint-disable-next-line no-restricted-globals
        location.href = `/admin/main/${ $("#authId").val()}`;
    });

    $("#logout").click(() => {
        logout();
    });
});






