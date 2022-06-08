import { AlertMove } from '../module/alert';
import { checkKr} from '../module/validation';

const $loginId = $('#loginId');
const $userNm = $('#userNm');
const $email = $('#email');
const $cellPhone = $('#cellPhone');
const $userPw = $('#userPw');
const $userPwRe = $('#userPwRe');

/**
 *  signUpCheck : 회원 가입시 중복 아이디 체크
 */
const signUpCheck = () => {
    if ($loginId.val() === '') {
        $('#msg').html('Please enter your ID');
        return;
    }

    $.ajax({
        url: '/api/user/'+$loginId.val(),
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            $('#signUpChk').val('Y');
            $('#msg').html(data.header.message);
        }
    }, (request, status, error) => {
        if (request.responseJSON.header.resultCode === 'fail') {
            $('#signUpChk').val('N');
            $('#msg').html(request.responseJSON.header.message);
        }
        console.log(
            `code:${request.status}\n` +
            `message:${request.responseText}\n` +
            `error:${error}`
        );
    });
};

/**
 *  signUpProc : 회원가입 실행
 */
const signUpProc = () => {
    let msg = '';

    if ($loginId.val() === '') {
        msg = 'Please enter ID';
        $('#msg').html(msg);
        $('#loginId').focus();
        return;
    }
    if (checkKr($loginId.val())) {
        msg = 'You cannot enter Korean characters in the ID';
        $('#msg').html(msg);
        $('#loginId').focus();
        return;
    }
    if ($('#signUpChk').val() === 'N') {
        msg = 'Please check the ID';
        $('#msg').html(msg);
        $('#loginId').focus();
        return;
    }
    if ($userNm.val() === '') {
        msg = 'Please enter name.';
        $('#msg').html(msg);
        $('#userNm').focus();
        return;
    }
    if ($email.val() === '') {
        msg = 'Please enter e-mail';
        $('#msg').html(msg);
        $('#email').focus();
        return;
    }
    if ($cellPhone.val() === '') {
        msg = 'Please enter phone number';
        $('#msg').html(msg);
        $('#cellPhone').focus();
        return;
    }
    if ($userPw.val() === '') {
        msg = 'Please enter a password';
        $('#msg').html(msg);
        $userPw.focus();
        return;
    }
    if ($userPwRe.val() === '') {
        msg = 'Please re-enter your password';
        $('#msg').html(msg);
        $('#userPwRe').focus();
        return;
    }
    if ($userPw.val() !== $userPwRe.val()) {
        msg = 'Passwords do not match';
        $('#msg').html(msg);
        $('#userPwRe').focus();
        return;
    }

    const param = {
        login_id: $loginId.val(),
        user_nm: $userNm.val(),
        email: $email.val(),
        cell_phone: $cellPhone.val(),
        user_pw: $userPw.val(),
    };

    $.ajax({
        url: "/api/user/",
        type: 'PUT',
        data: JSON.stringify(param),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            AlertMove(data.header.message, '/login');
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
            const errorList = request.responseJSON.errorList;
            if(errorList !== undefined){
                if(errorList.lengh !==0){
                    const message = errorList[0].message;
                    $('#msg').html(message);
                }
            }else {
                const data = request.responseJSON.header;
                $('#msg').html(data.message);
            }
        }
    });
};

/**
 *  login : 로그인 화면 이동
 */
const login = () => {
    location.href = '/login';
};

$(document).ready(() => {
    $('#loginId').change(() => {
        $('#signUpChk').val('N');
    });

    // 사용자 아이디 체크 이벤트
    $('#signUpCheckBtn').click(() => {
        signUpCheck();
    });

    // 사용자 등록 이벤트
    $('#signUpBtn').click(() => {
        signUpProc();
    });

    // 돌아가기 이벤트
    $('#returnBtn').click(() => {
        login();
    });
});
