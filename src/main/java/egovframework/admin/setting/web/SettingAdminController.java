package egovframework.admin.setting.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingAdminController {

    /**
     * 코드 관리
     */
    @GetMapping(value = "/admin/setting/code")
    public ModelAndView userView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/user/userView");
        return mav;
    }

}