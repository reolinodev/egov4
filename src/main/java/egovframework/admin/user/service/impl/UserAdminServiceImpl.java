package egovframework.admin.user.service.impl;

import egovframework.admin.user.service.UserAdminService;
import egovframework.admin.user.service.domain.UserEntity;
import egovframework.let.utl.sim.service.EgovFileScrty;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("UserAdminService")
public class UserAdminServiceImpl extends EgovAbstractServiceImpl implements UserAdminService {
	
    @Resource(name = "UserAdminDAO")
    private UserAdminDAO userAdminDAO;

    @Resource(name = "UserAuthAdminDAO")
    private UserAuthAdminDAO userAuthAdminDAO;

    /**
     * 아이디 중복 체크
     */
    public int checkLoginId(String loginId) {
	    return userAdminDAO.countByLoginId(loginId);
    }

    /**
     * 사용자 등록
     */
    public int inputUser(UserEntity userEntity) throws Exception {
        userEntity.setUser_pw(EgovFileScrty.encryptPassword(userEntity.user_pw));
        return userAdminDAO.save(userEntity);
    }

    /**
     * 사용자 비밀번호 변경
     */
    public int updateUserPw(UserEntity userEntity) throws Exception {
        userEntity.user_pw = EgovFileScrty.encryptPassword(userEntity.user_pw);
        return userAdminDAO.updateUserPw(userEntity);
    }


    /**
     * 사용자를 전체조회(검색 및 페이징 처리).
     */
    public List<UserEntity> getUserList(UserEntity userEntity) {
        userEntity.setStart_idx(userEntity.getPage_per(), userEntity.getCurrent_page());
        return userAdminDAO.findAll(userEntity);
    }

    /**
     * 사용자를 전체조회의 토탈 카운트 조회
     */
    public int getUserCount(UserEntity userEntity) {
        return userAdminDAO.countByAll(userEntity);
    }

    /**
     * 사용자를 상세조회
     */
    public UserEntity getUserInfo(int userId) {
        return userAdminDAO.findByUserId(userId);
    }

    /**
     * 사용자 정보 변경
     */
    public int updateUser(UserEntity userEntity) throws Exception {
        userEntity.setUser_pw(EgovFileScrty.encryptPassword(userEntity.user_pw));
        return userAdminDAO.updateUser(userEntity);
    }
}
