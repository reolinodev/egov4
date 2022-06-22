package egovframework.admin.user.service.impl;

import egovframework.admin.user.service.AuthAdminService;
import egovframework.admin.user.service.domain.AuthEntity;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("AuthAdminService")
public class AuthAdminServiceImpl extends EgovAbstractServiceImpl implements AuthAdminService {
	
    @Resource(name = "AuthAdminDAO")
    private AuthAdminDAO authAdminDAO;

    public List<AuthEntity> getAuthList(AuthEntity authEntity) {
        authEntity.setStart_idx(authEntity.getPage_per(), authEntity.getCurrent_page());
        return authAdminDAO.findAll(authEntity);
    }

    public int getAuthCount(AuthEntity authEntity) {
        return authAdminDAO.countAll(authEntity);
    }

    public int checkAuthVal(AuthEntity authEntity) {
        return authAdminDAO.countByAuthVal(authEntity);
    }

    public int inputAuth(AuthEntity authEntity) throws Exception {
        return authAdminDAO.save(authEntity);
    }

    public AuthEntity getAuthInfo(int authId) {
        return authAdminDAO.findByAuthId(authId);
    }

    public int updateAuth(AuthEntity authEntity) throws Exception {
        return authAdminDAO.updateAuth(authEntity);
    }

    public List<AuthEntity> getAuthRoleList(AuthEntity authEntity) {
        return authAdminDAO.findByAuthRoleAndUseYn(authEntity);
    }

    public List<AuthEntity> getMyAuthList(AuthEntity authEntity) {
        return authAdminDAO.findByAuthRoleAndUserId(authEntity);
    }

}
