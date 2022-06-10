import { AlertMove } from '../module/alert';

const $loginId = $('#loginId');
const $userPw = $('#userPw');
const $userPwRe = $('#userPwRe');

/**
 *  pwChangeProc : 회원가입 실행
 */
const pwChangeProc = () => {
    let msg ="";

    if($loginId.val() === ''){
        msg = "Please enter ID.";
        $("#msg").html(msg);
        $("#loginId").focus();
        return;
    }else if($userPw.val() === ''){
        msg = "Please enter a password.";
        $("#msg").html(msg);
        $("#userPw").focus();
        return;
    }else if($userPwRe.val() === ''){
        msg = "Please re-enter your password.";
        $("#msg").html(msg);
        $("#userPwRe").focus();
        return;
    }else if($userPw.val() !== $userPwRe.val()){
        msg = "Passwords do not match.";
        $("#msg").html(msg);
        $("#userPwRe").focus();
        return;
    }

    const param  = {
        login_id : $loginId.val(),
        user_pw : $userPw.val()
    }

    $.ajax({
        url: "/api/admin/user/userPw",
        type: 'PUT',
        data: JSON.stringify(param),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            AlertMove(data.header.message, '/admin/login');
        } else {
            $('#msg').html(data.header.message);
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
                    $('#msg').html(message);
                }
            }else {
                const data = request.responseJSON.header;
                $('#msg').html(data.message);
            }
        }
    });
}

/**
 *  login : 로그인 화면 이동
 */
const login = () => {
    // eslint-disable-next-line no-restricted-globals
    location.href = '/admin/login';
}

$(document).ready(() => {

    // 패스워드 변경 이벤트
    $('#pwChangeBtn').click(() => {
        pwChangeProc();
    });

    // 돌아가기 이벤트
    $('#returnBtn').click(() => {
        login();
    });
});