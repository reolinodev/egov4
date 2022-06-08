package egovframework.admin.login.service.impl;

import egovframework.admin.login.service.domain.LoginEntity;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("LoginAdminDAO")
public class LoginAdminDAO extends EgovAbstractMapper {

    public int countByLoginId(LoginEntity loginEntity) {
	    return selectOne("LoginAdminDAO.countByLoginId", loginEntity);
    }

    public int countByLoginIdAndUserPw(LoginEntity loginEntity) {
        return selectOne("LoginAdminDAO.countByLoginIdAndUserPw", loginEntity);
    }

    public LoginEntity findByLoginId(LoginEntity loginEntity) {
        return selectOne("LoginAdminDAO.findByLoginId", loginEntity);
    }

    public int saveLoginHistory(LoginEntity loginEntity) throws Exception {
        return insert("LoginAdminDAO.saveLoginHistory", loginEntity);
    }

    public int saveLastLoginAt(LoginEntity loginEntity) throws Exception {
        return update("LoginAdminDAO.saveLastLoginAt", loginEntity);
    }
}
