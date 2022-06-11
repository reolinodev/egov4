package egovframework.admin.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAdminController {

    /**
     * 사용자 관리
     */
    @GetMapping(value = "/admin/user/user")
    public ModelAndView userView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/user/userView");
        return mav;
    }

    /**
     * 권한 관리
     */
    @GetMapping(value = "/admin/user/auth")
    public ModelAndView authView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/user/authView");
        return mav;
    }

    /**
     * 사용자 권한 관리
     */
    @GetMapping(value = "/admin/user/userAuth")
    public ModelAndView userAuthView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/user/userAuthView");
        return mav;
    }

    /**
     * 사용자 권한 관리 등록
     */
    @GetMapping(value = "/admin/user/userAuth/write")
    public ModelAndView userAuthWrite() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/user/userAuthWrite");
        return mav;
    }

}