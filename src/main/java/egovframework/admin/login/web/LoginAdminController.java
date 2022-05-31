package egovframework.admin.login.web;

import egovframework.let.sym.cal.service.Restde;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.map.ListOrderedMap;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAdminController {

	@RequestMapping(value = "/admin/login")
	public String loginView() throws Exception {
		return "/admin/loginView";
	}
}