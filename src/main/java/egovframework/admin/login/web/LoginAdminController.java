package egovframework.admin.login.web;

import egovframework.admin.login.service.LoginAdminService;
import egovframework.admin.login.service.domain.LoginEntity;
import egovframework.admin.login.service.domain.SessionInfo;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class LoginAdminController {

	@Resource
	private SessionInfo sessionInfo;

	private final LoginAdminService loginAdminService;

	@GetMapping(value = "/admin/login")
	public String loginView() {
		return "/admin/login/loginView";
	}

	@PostMapping(value = "/admin/login")
	public ModelAndView login(LoginEntity loginEntity) throws Exception {
		ModelAndView mav = new ModelAndView();

		String msg = "";

		//아이디 체크
		int countLoginId = loginAdminService.checkLoginId(loginEntity);
		if(countLoginId == 0){
			msg = "ID does not exist.";
			mav.addObject("msg", msg);
			mav.setViewName("/admin/login/loginView");
			return mav;
		}

		//패스워드 체크
		int countUserPw = loginAdminService.checkUserPw(loginEntity);
		if(countUserPw == 0){
			msg = "Passwords do not match.";
			mav.addObject("msg", msg);
			mav.setViewName("/admin/login/loginView");
			return mav;
		}

		//세션저장
		LoginEntity loginInfo = loginAdminService.getLoginId(loginEntity);

		if(loginInfo == null){
			msg = "Permission does not exist.";
			mav.addObject("msg", msg);
			mav.setViewName("/admin/login/loginView");
			return mav;
		}

		setSessionInfo(loginInfo);

		//로그인 내역 기록
		loginEntity.user_id = loginInfo.user_id;
		loginAdminService.inputLoginHistory(loginEntity);
		loginAdminService.updateLastLoginAt(loginEntity);

		mav.setViewName("redirect:/admin/main");
		return mav;
	}

	/**
	 * 로그 아웃
	 * : 세션을 초기화 후 로그인 화면으로 이동한다.
	 */
	@GetMapping(value = "/admin/logout")
	public ModelAndView logout(HttpServletRequest request)  {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();

		mav.setViewName("redirect:/admin/login");
		return mav;
	}

	/**
	 * 로그인 정보 세션에 입력
	 */
	private void setSessionInfo(LoginEntity loginEntity) {

		sessionInfo.setLogin_id(loginEntity.getLogin_id());
		sessionInfo.setAuth_id(loginEntity.getAuth_id());
		sessionInfo.setAuth_nm(loginEntity.getAuth_nm());
		sessionInfo.setUser_id(loginEntity.getUser_id());
		sessionInfo.setUser_nm(loginEntity.getUser_nm());
	}

}