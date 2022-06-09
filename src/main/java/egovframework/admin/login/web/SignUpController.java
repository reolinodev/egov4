package egovframework.admin.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping(value = "/admin/signUp")
    public String signUpView() {
        return "/admin/login/signUpView";
    }

    @GetMapping(value = "/admin/pwChange")
    public String pwChangeView() {
        return "/admin/login/pwChangeView";
    }

}
