import {setBasicEditor, setBasicViewer} from "../module/editor";

let editor;
let content ='| 11 | 22 |\n'
    + '| --- | --- |\n'
    + '|  a| b |';

$(document).ready(() => {
  editor = setBasicEditor('editor', content);
  setBasicViewer('viewer', content);

  $("#editorBtn").click(()=> {
    content =  editor.getMarkdown();
    setBasicViewer('viewer', content);
  });
});
