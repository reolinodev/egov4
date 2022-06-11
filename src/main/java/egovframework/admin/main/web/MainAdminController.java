package egovframework.admin.main.web;

import egovframework.admin.login.service.domain.SessionInfo;
import egovframework.common.support.JsonUtils;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainAdminController {

    @Resource
    private SessionInfo sessionInfo;

    /**
     * 메인 화면
     */
    @GetMapping(value = "/admin/main")
    public ModelAndView mainView(HttpServletRequest request) throws IOException, ParseException {
        //todo 사용자의 세션 정보를 이용해서 화면을 배치 한다. 사용자의 이름과 최상위 권한을 셀렉트 박스로 유지한다.
        //todo 슈퍼 유저는 세팅의 관련된 화면을 보여주며 그 외의 권한은 권한에 관련된 메뉴를 조회해서 navigation을 구성한다.
        //todo 각 권한별로 가장 먼저 호출할 도메인을 설정한다.
        //todo 프로퍼티에서 db, json 타입 선택해서 메뉴 처리하기

        ModelAndView mav = new ModelAndView();

        int auth_id = sessionInfo.getAuth_id();
        //todo auth_id가 0일경우 세션이 없기 때문에 로그인 화면으로 이동 처리. 아래 조건절도 수정 필요
        if(auth_id == 0 || auth_id == 1){
            mav = JsonUtils.getJsonMenu();
        }else {
            //todo db에서 각 권한에 맞는 메뉴를 조회함
        }

        mav.addObject("userNm",sessionInfo.getUser_nm());
        mav.addObject("loginId",sessionInfo.getLogin_id());
        mav.addObject("authId",sessionInfo.getAuth_id());

        mav.setViewName("/admin/main/mainView");
        return mav;
    }

    @GetMapping(value = "/admin/api")
    public String index() {
        String url = "/swagger-ui.html";
        return "redirect:" + url;
    }
}