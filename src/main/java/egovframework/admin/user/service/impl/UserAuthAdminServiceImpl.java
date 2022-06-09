package egovframework.admin.user.service.impl;

import egovframework.admin.user.service.UserAuthAdminService;
import egovframework.admin.user.service.domain.UserAuthEntity;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("UserAuthAdminService")
public class UserAuthAdminServiceImpl extends EgovAbstractServiceImpl implements
    UserAuthAdminService {
	
    @Resource(name = "UserAuthAdminDAO")
    private UserAuthAdminDAO userAuthAdminDAO;

    public List<UserAuthEntity> getInputAuthUserList(UserAuthEntity userAuthEntity) {
        userAuthEntity.setStart_idx(userAuthEntity.getPage_per(), userAuthEntity.getCurrent_page());
        return userAuthAdminDAO.findByAuthIdNotAndUseYn(userAuthEntity);
    }

    public int getInputAuthUserCount(UserAuthEntity userAuthEntity) {
        return userAuthAdminDAO.countByAuthIdNotAndUseYn(userAuthEntity);
    }

    public int inputUserAuth(UserAuthEntity userAuthEntity) throws Exception {
        int result = 0;
        int[] arr = userAuthEntity.user_arr;
        for (int j : arr) {
            userAuthEntity.user_id = j;
            result = userAuthAdminDAO.save(userAuthEntity);
        }

        return result;
    }

    public List<UserAuthEntity> getAuthUserList(UserAuthEntity userAuthEntity) {
        userAuthEntity.setStart_idx(userAuthEntity.getPage_per(), userAuthEntity.getCurrent_page());
        return userAuthAdminDAO.findAll(userAuthEntity);
    }

    public int getAuthUserCount(UserAuthEntity userAuthEntity) {
        return userAuthAdminDAO.countAll(userAuthEntity);
    }

    public int deleteUserAuth(UserAuthEntity userAuthEntity) throws Exception {
        return userAuthAdminDAO.deleteUserAuth(userAuthEntity);
    }
}
