import { setCookie, getCookie, deleteCookie } from '../module/cookie'
import { getDeviceInfo } from '../module/device'

const $frm = $('#frm');
const $loginId = $('#loginId');
const $userPw = $('#userPw');

/**
 *  login : 로그인 실행
 */
const loginProc = () => {
    if ($loginId.val() === '') {
        $("#msg").html('Please input the ID');
        $loginId.focus();
        return;
    }

    if ($userPw.val() === '') {
        $("#msg").html('Please input the password');
        $userPw.focus();
        return;
    }

    const idSaveCheck = document.getElementById('idSaveCheck').checked;
    if(idSaveCheck){
        setCookie("loginId", $loginId.val(), 30);
        setCookie("idSaveCheck", 'Y', 30);
    }else{
        deleteCookie("loginId");
        setCookie("idSaveCheck", 'N', 30);
    }

    $frm.attr('action', '/admin/login');
    $frm.attr('method', 'post');
    $frm.submit();
};

/**
 *  signUp : 회원가입 화면 이동
 */
const signUp = () => {
    // eslint-disable-next-line no-restricted-globals
    location.href = '/admin/signUp';
};

/**
 *  pwChange : 비밀번호 변경 화면 이동
 */
const pwChange = () => {
    // eslint-disable-next-line no-restricted-globals
    location.href = '/admin/pwChange';
};


$(document).ready(() => {
    // 엔터 입력시 로그인 처리
    $(window).on('keydown', (e) => {
        if (e.keyCode === 13) {
            loginProc();
        }
    });

    // 로그인 이벤트
    $('#loginBtn').click(() => {
        loginProc();
    });

    // 패스워드 변경 화면 이동
    $('#pwChangeBtn').click(() => {
        pwChange();
    });

    // 사용자 등록 화면 이동
    $('#signUpBtn').click(() => {
        signUp();
    });

    // 디바이스 정보 세팅
    const deviceInfo = getDeviceInfo();
    $('#loginDevice').val(deviceInfo.device);
    $('#deviceBrowser').val(deviceInfo.browser);

    // 아이디 기억하기(쿠키 불러오기)
    const idSaveCheck = document.getElementById('idSaveCheck');

    if (getCookie("idSaveCheck") === 'Y'){
        idSaveCheck.checked = true;
        $loginId.val(getCookie("loginId"));
    }else{
        idSaveCheck.checked = false;
    }

    sessionStorage.clear()
});
