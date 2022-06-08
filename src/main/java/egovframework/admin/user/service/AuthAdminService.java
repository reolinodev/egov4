package egovframework.admin.user.service;

import egovframework.admin.user.service.domain.AuthEntity;
import java.util.List;

public interface AuthAdminService {

    List<AuthEntity> getAuthList(AuthEntity authEntity);

    int getAuthCount(AuthEntity authEntity);

    int checkAuthVal(AuthEntity authEntity);

    int inputAuth(AuthEntity authEntity) throws Exception;

    AuthEntity getAuthInfo(int auth_id);

    int updateAuth(AuthEntity authEntity) throws Exception;

    List<AuthEntity> getAuthRoleList(AuthEntity authEntity);
}
