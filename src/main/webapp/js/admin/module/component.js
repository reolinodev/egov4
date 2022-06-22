/**
 * setCommonSelectBox : 공통코드를 사용한 셀렉트 박스 생성
 * 생성할 아이디, 코드, 타입(전체, 선택, ''), 선택된 값('')
 */
export function setCodeSelBox(id,codeGrp,type,selectedValue ){

   let str = '';

   if(type==='ALL') str += `<option value="">-- All --</option>`;
   else if(type==='SEL') str += `<option value="">-- Sel --</option>`;

   $.ajax({
      url : `/api/admin/mng/code/item/${codeGrp}`,
      type: 'GET',
      headers: {'Content-Type': 'application/json'},
   }).then((result) => {
      const dataList = result.data;

      // eslint-disable-next-line no-plusplus
      for (let i=0; i < dataList.length;i++) {
         if(selectedValue !=='' && selectedValue === dataList[i].code_val){
            str += `<option value="${dataList[i].code_val}" selected> ${dataList[i].code_nm}</option>`;}
         else{
            str += `<option value="${dataList[i].code_val}"> ${dataList[i].code_nm}</option>`;
         }
      }

      $(`#${id}`).html(str);
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
 * setCommonSelectBox : 공통코드를 사용한 셀렉트 박스 생성
 * 생성할 아이디, 코드, 타입(전체, 선택, ''), 선택된 값('')
 */
export function setCodeSelBoxCall(id,codeGrp,type,selectedValue, callBack){

   let str = '';

   if(type==='ALL') str += `<option value="">-- All --</option>`;
   else if(type==='SEL') str += `<option value="">-- Sel --</option>`;

   $.ajax({
      url : `/api/admin/mng/code/item/${codeGrp}`,
      type: 'GET',
      headers: {'Content-Type': 'application/json'},
   }).then((result) => {
      const dataList = result.data;

      // eslint-disable-next-line no-plusplus
      for (let i=0; i < dataList.length;i++) {
         if(selectedValue !=='' && selectedValue === dataList[i].code_val){
            str += `<option value="${dataList[i].code_val}" selected> ${dataList[i].code_nm}</option>`;}
         else{
            str += `<option value="${dataList[i].code_val}"> ${dataList[i].code_nm}</option>`;
         }
      }

      $(`#${id}`).html(str);

      callBack();
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
 * setCommSelBox : 공통코드를 사용하지 않는 경우 셀렉트 박스 생성
 * 생성할 아이디, url, url_type(url 전송 타입) ,타입(전체, 선택, ''), 선택된 값(''), 파라미터(''), option(옵션안에 넣을 텍스트와 value의 값을 추출)
 */
// eslint-disable-next-line camelcase
export function setCommSelBox(id,url,url_type,type,selected_value, params, option ){
   let str = '';

   if(type==='ALL') str += `<option value="">-- All --</option>`;
   else if(type==='SEL') str += `<option value="">-- Sel --</option>`;

   if(params === ''){
      // eslint-disable-next-line no-param-reassign
      params = {}
   }

   if(url === ''){
      str += '</select>';
      $(`#${id}`).html(str);
   }else {
      $.ajax({
         url,
         type: url_type,
         data: JSON.stringify(params),
         headers: {'Content-Type': 'application/json'},
         success (result){
            const list = result.data;

            if(list.length === 0 && type!=='ALL'){
               str += `<option value="">-- None --</option>`;
            }

            // eslint-disable-next-line no-plusplus
            for (let i=0; i < list.length;i++) {
               if(option !== ''){
                  const {oTxt} = option;
                  const {oVal} = option;

                  // eslint-disable-next-line camelcase
                  if(selected_value !==''){
                     if(list[i][oVal].toString() === selected_value.toString()){
                        str += `<option value="${list[i][oVal]}" selected> ${list[i][oTxt]}</option>`;
                     }else {
                        str += `<option value="${list[i][oVal]}"> ${list[i][oTxt]}</option>`;
                     }
                  }else {
                     str += `<option value="${list[i][oVal]}"> ${list[i][oTxt]}</option>`;
                  }
               }
            }

            $(`#${id}`).html(str);
         },
         error (request, status, error){
            console.log(`code:${request.status}\nmessage:${request.responseText}\nerror:${error}`);
         }
      });
   }
}
//
// const setAutoData = (url, params) => {
//    let data = [ "c++", "java", "php", "coldfusion", "javascript", "asp", "ruby" ];
//
//
//    return data;
// }
//
// const setAutoComplete = (id, url, params, callBackFunc) => {
//    //조회하기
//    let data = setAutoData(url, params);
//
//    $( "#autocomplete" ).autocomplete({
//       source: function( request, response ) {
//          let matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( request.term ), "i" );
//          response( $.grep( data, function( item ){
//             return matcher.test( item );
//          }) );
//       },
//       change: function( event, ui ) {
//          console.log('1',ui);
//       }
//    });
// }


