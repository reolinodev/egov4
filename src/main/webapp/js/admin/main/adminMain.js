/**
 *  calcHeight : iframe 크기 조절 ( 브라우저 크기에 따라 적용)
 */
const calcHeight = () => {
    const defaultHeight = 800; // 테스트 필요(브라우저 크기에 따라서)
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

    sessionStorage.setItem('url', url);
    sessionStorage.setItem('parentMenuName', parentMenuName);
    sessionStorage.setItem('childMenuName', childMenuName);

}
/**
 *  mainPageLoad : 메인 페이지 로드
 */
const mainPageLoad = () => {
    let url = $("#mainUrl").val();
    let menuNm = $("#mainMenuNm").val();
    let parentNm = $("#mainParentNm").val();

    const sUrl = sessionStorage.getItem('url');
    if(sUrl !== null) url = sUrl;

    const sChildMenuName = sessionStorage.getItem('childMenuName');
    if(sChildMenuName !== null) menuNm = sChildMenuName;

    const sParentMenuName= sessionStorage.getItem('parentMenuName');
    if(sParentMenuName !== null) parentNm = sParentMenuName;

    pageRouter(url, parentNm, menuNm);
}

$(document).ready(() => {

    calcHeight();

    mainPageLoad();

    // eslint-disable-next-line func-names
    $("li[id^='menu_']").click(function() {
        const url = this.getAttribute("data-url");
        const menuNm = this.getAttribute("data-menunm");
        const parentNm = this.getAttribute("data-parentnm");

        pageRouter(url, parentNm, menuNm);
    });

    // eslint-disable-next-line func-names
    $("a[id='menuUrl']").click(function() {

        const url = this.getAttribute("data-url");
        const menuNm = this.getAttribute("data-menunm");
        const parentNm = this.getAttribute("data-parentnm");

        pageRouter(url, parentNm, menuNm);
    });
});






