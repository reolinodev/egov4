/**
 *  logout : 로그아웃
 */
const logout = () => {
    sessionStorage.clear() // 전체삭제
    location.href = "/admin/logout";
}

$(document).ready(() => {

    $("#logout").click(function() {
        logout();
    });
});






