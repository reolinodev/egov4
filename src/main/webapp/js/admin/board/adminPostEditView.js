import {setBasicViewer} from "../module/editor";
import {setCodeSelBox} from "../module/component";

let content ='';

$(document).ready(() => {

    content = $("#mainText").val();

    setBasicViewer('viewer', content);

    setCodeSelBox('useYn','USE_YN','',$("#use").val());

    $("#backBtn").click(()=> {
        location.href = '/admin/board/post';
    });

    $("#editBtn").click(()=> {
        location.href = '/admin/board/post/edit/'+$("#postId").val();
    });
});
