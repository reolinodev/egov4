import {setBasicEditor} from "../module/editor";
import {setCodeSelBox} from "../module/component";
import {Alert, AlertMove} from "../module/alert";
import {serializeFormJson} from "../module/json";

let editor;
let content ='';


/**
 *  saveProc : 게시글 수정
 */
const saveProc = () => {
    let msg = '';

    if ($("#title").val() === '') {
        msg = 'Please enter title.';
        Alert(msg);
        $("#title").focus();
        return;
    }

    content =  editor.getMarkdown();

    $("#mainText").val(content);

    const params = serializeFormJson('postEditFrm');

    $.ajax({
        url: "/api/admin/post/"+$("#postId").val(),
        type: 'PUT',
        data: JSON.stringify(params),
        headers: {'Content-Type': 'application/json'},
    }).then((data) => {
        if (data.header.resultCode === 'ok') {
            AlertMove(data.header.message, '/admin/board/post');
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

    content = $("#mainText").val();
    editor = setBasicEditor('editor', content, 500);

    setCodeSelBox('useYn','USE_YN','',$("#use").val());

    $("#backBtn").click(()=> {
        location.href = '/admin/board/post';
    });

    $("#saveBtn").click(()=> {
        saveProc();
    });
});
