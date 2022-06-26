import { Editor } from '@toast-ui/editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';

/**
 * setBasicEditor : 기본 에디터 생성
 * data : 아이디, 콘텐츠
 */
// eslint-disable-next-line import/prefer-default-export
export function setBasicEditor (id, content) {

  // eslint-disable-next-line new-cap
  return new Editor({
    el: document.querySelector(`#${id}`),
    previewStyle: 'tab',
    height: '500px',
    initialValue: content,
    initialEditType: 'wysiwyg',
  });
}

/**
 * setBasicViewer : 기본 뷰어 생성
 * data : 아이디, 콘텐츠
 */
export function setBasicViewer (id, content) {

  // eslint-disable-next-line new-cap
  return new Editor.factory({
    el: document.querySelector(`#${id}`),
    viewer: true,
    height: '500px',
    initialValue: content,
  });
}

