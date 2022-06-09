/**
 *  calcHeight : iframe 크기 조절 ( 브라우저 크기에 따라 적용)
 */
const calcHeight = () => {
    const defaultHeight = 800; //테스트 필요(브라우저 크기에 따라서)
    const contentHeight = document.getElementById('contentFrame').contentWindow.document.body.scrollHeight;
    document.getElementById('contentFrame').height = defaultHeight >= contentHeight ? defaultHeight : contentHeight;
    document.getElementById('contentFrame').style.overflow = "hidden";
}

/**
 *  pageRouter : iframe내 페이지 이동 및 상단 네비게이션 적용
 */
const pageRouter = (url, parentMenuName, childMenuName) => {
    $('#menuNm').html(childMenuName);
    $('#parentMenuNm').html(parentMenuName);
    $('#childMenuNm').html(childMenuName);
    $('#contentFrame').attr('src', url);
}

/**
 *  mainPageLoad : 메인 페이지 로드
 */
const mainPageLoad = () => {
    const url = $("#mainUrl").val();
    const menuNm = $("#mainMenuNm").val();
    const parentNm = $("#mainParentNm").val();
    pageRouter(url, parentNm, menuNm);
}

$(document).ready(() => {

    calcHeight();

    mainPageLoad();

    $("li[id^='menu_']").click(function() {
        const url = this.getAttribute("data-url");
        const menuNm = this.getAttribute("data-menunm");
        const parentNm = this.getAttribute("data-parentnm");

        pageRouter(url, parentNm, menuNm);
    });

    $("a[id='menuUrl']").click(function() {

        const url = this.getAttribute("data-url");
        const menuNm = this.getAttribute("data-menunm");
        const parentNm = this.getAttribute("data-parentnm");

        pageRouter(url, parentNm, menuNm);
    });
});






