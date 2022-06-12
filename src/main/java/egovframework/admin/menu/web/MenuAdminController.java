package egovframework.admin.menu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuAdminController {

    /**
     * 메뉴 관리
     */
    @GetMapping(value = "/admin/menu/menu")
    public ModelAndView userView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/menu/menuView");
        return mav;
    }

}