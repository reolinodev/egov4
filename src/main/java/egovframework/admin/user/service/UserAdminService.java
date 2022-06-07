package egovframework.admin.user.service;

import egovframework.admin.user.service.domain.UserEntity;
import java.util.List;

public interface UserAdminService {

    int checkLoginId(String loginId);

    int inputUser(UserEntity userEntity) throws Exception;

    int updateUserPw(UserEntity userEntity) throws Exception;

    List<UserEntity> getUserList(UserEntity userEntity);

    int getUserCount(UserEntity userEntity);

    UserEntity getUserInfo(int userId);

    int updateUser(UserEntity userEntity) throws Exception;
}
