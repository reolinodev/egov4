import {setCommSelBox} from "../module/component";
import {setPagination} from "../module/pagination";

/**
 *  logout : 로그아웃
 */
const logout = () => {
    sessionStorage.clear() // 전체삭제
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
        location.href = '/admin/main/'+ $("#authId").val();
    });

    $("#logout").click(function() {
        logout();
    });
});






