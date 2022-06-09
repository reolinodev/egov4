package egovframework.admin.user.service.impl;

import egovframework.admin.user.service.domain.UserAuthEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("UserAuthAdminDAO")
public class UserAuthAdminDAO extends EgovAbstractMapper {

    public List<UserAuthEntity> findByAuthIdNotAndUseYn(UserAuthEntity userAuthEntity) {
        return (List<UserAuthEntity>) list("UserAuthAdminDAO.findByAuthIdNotAndUseYn", userAuthEntity);
    }

    public int countByAuthIdNotAndUseYn(UserAuthEntity userAuthEntity) {
        return selectOne("UserAuthAdminDAO.countByAuthIdNotAndUseYn", userAuthEntity);
    }

    public int save(UserAuthEntity userAuthEntity) throws Exception {
        return insert("UserAuthAdminDAO.save", userAuthEntity);
    }

    public List<UserAuthEntity> findAll(UserAuthEntity userAuthEntity) {
        return (List<UserAuthEntity>) list("UserAuthAdminDAO.findAll", userAuthEntity);
    }

    public int countAll(UserAuthEntity userAuthEntity) {
        return selectOne("UserAuthAdminDAO.countAll", userAuthEntity);
    }

    public int deleteUserAuth(UserAuthEntity userAuthEntity) throws Exception {
        return update("UserAuthAdminDAO.deleteUserAuth", userAuthEntity);
    }
}
