import tuiEditor from '@toast-ui/editor';
import '@toast-ui/editor/dist/toastui-editor.css';

/**
 * setBasicEditor : 기본 에디터 생성
 * data : 트리 데이터, 콜백함수
 */
// eslint-disable-next-line import/prefer-default-export
export function setBasicEditor (id) {

  // eslint-disable-next-line new-cap
  return new tuiEditor({
    el: document.querySelector(`#${id}`),
    previewStyle: 'tab',
    height: '500px',
  });

  // const result = editor.getHTML();
  // console.log('result', result);

}

export function setBasicViewer (id) {

  const content = 'aaaaaa';

  const viewer = new tuiEditor({
    el: document.querySelector(`#${id}`),
    initialValue: content
  });

}

