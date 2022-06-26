import {setBasicEditor} from "../module/editor";

let editor;

$(document).ready(() => {
  editor = setBasicEditor('editor' );

  $("#editorBtn").click(()=> {
    console.log('editor', editor.getHTML());
  });
});
