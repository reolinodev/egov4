package egovframework.admin.login.service;

import egovframework.admin.login.service.domain.LoginEntity;

public interface LoginAdminService {

     int checkLoginId(LoginEntity loginEntity);

     int checkUserPw(LoginEntity loginEntity) throws Exception;

     LoginEntity getLoginId(LoginEntity loginEntity);

     int inputLoginHistory(LoginEntity loginEntity) throws Exception ;

    int updateLastLoginAt(LoginEntity loginEntity) throws Exception ;

}
