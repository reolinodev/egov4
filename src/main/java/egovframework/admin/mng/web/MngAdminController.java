package egovframework.admin.mng.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MngAdminController {

    /**
     * 코드 관리
     */
    @GetMapping(value = "/admin/mng/code")
    public ModelAndView userView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/mng/codeView");
        return mav;
    }

}