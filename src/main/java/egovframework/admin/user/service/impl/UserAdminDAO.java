package egovframework.admin.user.service.impl;

import egovframework.admin.user.service.domain.User;
import egovframework.admin.user.service.domain.UserEntity;
import egovframework.let.cop.com.service.BoardUseInfVO;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("UserAdminDAO")
public class UserAdminDAO extends EgovAbstractMapper {

    public int countByLoginId(String login_id) {
	    return selectOne("UserAdminDAO.countByLoginId", login_id);
    }

    public UserEntity findByLoginId(UserEntity userEntity) {
        return selectOne("UserAdminDAO.findByLoginId", userEntity);
    }

    public int save(UserEntity userEntity) throws Exception {
        return insert("UserAdminDAO.save", userEntity);
    }

    public int updateUserPw(UserEntity userEntity) {
        return update("UserAdminDAO.updateUserPw", userEntity);
    }

    public List<UserEntity> findAll(UserEntity userEntity) {
	    return (List<UserEntity>) list("UserAdminDAO.findAll", userEntity);
    }

    public int countByAll(UserEntity userEntity) {
        return selectOne("UserAdminDAO.countByAll", userEntity);
    }

    public UserEntity findByUserId(int userId) {
        return selectOne("UserAdminDAO.findByUserId", userId);
    }

    public int updateUser(UserEntity userEntity) {
        return update("UserAdminDAO.updateUser", userEntity);
    }
}
