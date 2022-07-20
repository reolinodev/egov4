import {setBasicEditor} from "../module/editor";
import {setCommSelBox} from "../module/component";
import {Alert, AlertMove} from "../module/alert";
import {serializeFormJson} from "../module/json";

let editor;
let content ='';

/**
 *  saveProc : 게시글 등록
 */
const saveProc = () => {
    let msg = '';

    if ($("#boardId").val() === '') {
        msg = 'Select the board';
        Alert(msg);
        $("#boardId").focus();
        return;
    }
    if ($("#title").val() === '') {
        msg = 'Please enter title.';
        Alert(msg);
        $("#title").focus();
        return;
    }

    content =  editor.getMarkdown();

    $("#mainText").val(content);

    const params = serializeFormJson('faqWriteFrm');

    $.ajax({
        url: "/api/admin/faq/",
        type: 'PUT',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            AlertMove(data.header.message, '/admin/board/faq');
        } else {
            Alert(data.header.message);
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
};

$(document).ready(() => {
    const option = {
        oTxt: 'title',
        oVal: 'board_id'
    }

    const params = {};

    setCommSelBox('boardId','/api/admin/board/select/faq','POST', 'SEL', '', params, option);

    editor = setBasicEditor('editor', content, 500);

    $("#backBtn").click(()=> {
        location.href = '/admin/board/faq';
    });

    $("#saveBtn").click(()=> {
        saveProc();
    });

});
