export function serializeFormJson(name) {
    const formArray = $(`form[name=${name}]`).serializeArray() ;
    const jsonObject = {};

    for (let arr of formArray) {
        jsonObject[arr.name] = arr.value;
    }

    return jsonObject;
}