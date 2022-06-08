package egovframework.admin.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginAdminController {

	@GetMapping(value = "/admin/login")
	public String loginView() throws Exception {
		return "/admin/login/loginView";
	}
}