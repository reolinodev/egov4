package egovframework.admin.main.web;

import egovframework.admin.login.service.domain.SessionAdminInfo;
import egovframework.admin.menu.service.MenuAdminService;
import egovframework.admin.menu.service.domain.MenuEntity;
import egovframework.common.support.JsonUtils;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MainAdminController {

    @Resource
    private SessionAdminInfo sessionAdminInfo;

    @Value("${menu.type}")
    private String menuType;

    private final MenuAdminService menuAdminService;

    /**
     * 메인 화면
     */
    @GetMapping(value = "/admin/main")
    public ModelAndView mainView(HttpServletRequest request) throws IOException, ParseException {
        ModelAndView mav = new ModelAndView();

        int userId = sessionAdminInfo.getUser_id();
        int authId = sessionAdminInfo.getAuth_id();

        if(userId == 0){
            mav.setViewName("redirect:/admin/logout");
        }
        else {
            if("json".equals(menuType)){
                mav = JsonUtils.getJsonMenu();
            }else {
                MenuEntity menuEntity = new MenuEntity();
                menuEntity.auth_id = authId;

                MenuEntity firstUrl = menuAdminService.getMainUrl(menuEntity);
                menuEntity.menu_lv = 1;
                List<MenuEntity> menuLv1List = menuAdminService.getMenuListLv(menuEntity);
                menuEntity.menu_lv = 2;
                List<MenuEntity> menuLv2List = menuAdminService.getMenuListLv(menuEntity);

                mav.addObject("menuLv1List",menuLv1List);
                mav.addObject("menuLv2List",menuLv2List);
                mav.addObject("firstUrl",firstUrl);
            }

            mav.addObject("menuType",menuType);
            mav.addObject("userNm",sessionAdminInfo.getUser_nm());
            mav.addObject("loginId",sessionAdminInfo.getLogin_id());
            mav.addObject("authId",authId);
            mav.addObject("userId",userId);

            mav.setViewName("/admin/main/mainView");
        }

        return mav;
    }

    /**
     * 메인 화면
     */
    @GetMapping(value = "/admin/main/{auth_id}")
    public ModelAndView mainView(@PathVariable Integer auth_id) throws IOException, ParseException {
        ModelAndView mav = new ModelAndView();

        int userId = sessionAdminInfo.getUser_id();

        if(userId == 0){
            mav.setViewName("redirect:/admin/logout");
        }
        else {
            if("json".equals(menuType)){
                mav = JsonUtils.getJsonMenu();
            }else {
                MenuEntity menuEntity = new MenuEntity();
                menuEntity.auth_id = auth_id;

                MenuEntity firstUrl = menuAdminService.getMainUrl(menuEntity);
                menuEntity.menu_lv = 1;
                List<MenuEntity> menuLv1List = menuAdminService.getMenuListLv(menuEntity);
                menuEntity.menu_lv = 2;
                List<MenuEntity> menuLv2List = menuAdminService.getMenuListLv(menuEntity);

                mav.addObject("menuLv1List",menuLv1List);
                mav.addObject("menuLv2List",menuLv2List);
                mav.addObject("firstUrl",firstUrl);
            }

            mav.addObject("menuType",menuType);
            mav.addObject("userNm",sessionAdminInfo.getUser_nm());
            mav.addObject("loginId",sessionAdminInfo.getLogin_id());
            mav.addObject("authId",auth_id);
            mav.addObject("userId",userId);

            mav.setViewName("/admin/main/mainView");
        }

        return mav;
    }

    @GetMapping(value = "/admin/api")
    public String index() {
        String url = "/swagger-ui.html";
        return "redirect:" + url;
    }
}