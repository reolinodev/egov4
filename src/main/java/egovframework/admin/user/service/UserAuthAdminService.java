package egovframework.admin.user.service;

import egovframework.admin.user.service.domain.UserAuthEntity;
import java.util.List;

public interface UserAuthAdminService {
    List<UserAuthEntity> getInputAuthUserList(UserAuthEntity userAuthEntity);

    int getInputAuthUserCount(UserAuthEntity userAuthEntity);

    int inputUserAuth(UserAuthEntity userAuthEntity) throws Exception;

    List<UserAuthEntity> getAuthUserList(UserAuthEntity userAuthEntity);

    int getAuthUserCount(UserAuthEntity userAuthEntity);

    int deleteUserAuth(UserAuthEntity userAuthEntity) throws Exception;
}
