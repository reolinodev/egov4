package egovframework.admin.user.service.impl;

import egovframework.admin.user.service.domain.AuthEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("AuthAdminDAO")
public class AuthAdminDAO extends EgovAbstractMapper {

    public List<AuthEntity> findAll(AuthEntity authEntity) {
        return (List<AuthEntity>) list("AuthAdminDAO.findAll", authEntity);
    }

    public int countAll(AuthEntity authEntity) {
        return selectOne("AuthAdminDAO.countAll", authEntity);
    }

    public int save(AuthEntity authEntity) throws Exception {
        return insert("AuthAdminDAO.save", authEntity);
    }

    public List<AuthEntity> findByUseYn(AuthEntity authEntity) {
        return (List<AuthEntity>) list("AuthAdminDAO.findByUseYn", authEntity);
    }

    public int updateAuth(AuthEntity authEntity) throws Exception {
        return update("AuthAdminDAO.updateAuth", authEntity);
    }

    public AuthEntity findByAuthId(int authId) {
        return selectOne("AuthAdminDAO.findByAuthId", authId);
    }

    public int countByAuthVal(AuthEntity authEntity) {
        return selectOne("AuthAdminDAO.countByAuthVal", authEntity);
    }

    public List<AuthEntity> findByAuthRoleAndUseYn(AuthEntity authEntity) {
        return (List<AuthEntity>) list("AuthAdminDAO.findByAuthRoleAndUseYn", authEntity);
    }

    public List<AuthEntity> findByAuthRoleAndUserId(AuthEntity authEntity) {
        return (List<AuthEntity>) list("AuthAdminDAO.findByAuthRoleAndUserId", authEntity);
    }
}
