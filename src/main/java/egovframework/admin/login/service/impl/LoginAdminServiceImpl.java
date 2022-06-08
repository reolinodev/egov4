package egovframework.admin.login.service.impl;

import egovframework.admin.login.service.LoginAdminService;
import egovframework.admin.login.service.domain.LoginEntity;
import egovframework.let.utl.sim.service.EgovFileScrty;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("LoginAdminService")
public class LoginAdminServiceImpl extends EgovAbstractServiceImpl implements LoginAdminService {
	
    @Resource(name = "LoginAdminDAO")
    private LoginAdminDAO loginAdminDAO;

    public int checkLoginId(LoginEntity loginEntity) {
        return loginAdminDAO.countByLoginId(loginEntity);
    }

    public int checkUserPw(LoginEntity loginEntity) throws Exception {
        loginEntity.user_pw = EgovFileScrty.encryptPassword(loginEntity.user_pw);
        return loginAdminDAO.countByLoginIdAndUserPw(loginEntity);
    }

    public LoginEntity getLoginId(LoginEntity loginEntity) {
        return loginAdminDAO.findByLoginId(loginEntity);
    }

    public int inputLoginHistory(LoginEntity loginEntity) throws Exception {
        return loginAdminDAO.saveLoginHistory(loginEntity);
    }

    public int updateLastLoginAt(LoginEntity loginEntity) throws Exception {
        return  loginAdminDAO.saveLastLoginAt(loginEntity);
    }
}
