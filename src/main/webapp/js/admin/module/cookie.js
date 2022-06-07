export function setCookie(cookie_name, value, days) {
    const exDate = new Date();
    exDate.setDate(exDate.getDate() + days);
    const cookie_value = escape(value) + ((days == null) ? '' : '; expires=' + exDate.toUTCString());
    document.cookie = cookie_name + '=' + cookie_value;
}

export function getCookie(cookie_name) {
    const cookieVal = document.cookie.split(';');

    for (let i = 0; i < cookieVal.length; i++) {
        let x = cookieVal[i].substr(0, cookieVal[i].indexOf('='));
        const y = cookieVal[i].substr(cookieVal[i].indexOf('=') + 1);
        x = x.replace(/^\s+|\s+$/g, '');
        if (x === cookie_name) {
            return unescape(y);
        }
    }
}


export function deleteCookie(cookie_name) {
    document.cookie = cookie_name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

