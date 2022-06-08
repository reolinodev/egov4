package egovframework.admin.user.service;

import egovframework.admin.user.service.domain.AuthEntity;
import egovframework.admin.user.service.impl.AuthAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthAdminServiceTest {

    @Autowired
    private AuthAdminDAO authAdminDAO;

    @Test
    void getAuthList() {
        //when
        AuthEntity authEntity = new AuthEntity();
        authEntity.use_yn = "Y";
        authEntity.start_idx = 0;
        authEntity.page_per = 10;
        authEntity.auth_role = "ADMIN";

        //given
        List<AuthEntity> result = authAdminDAO.findAll(authEntity);
        //then
        Assertions.assertEquals(10, result.size());
    }

    @Test
    void getAuthCount() {
        //when
        AuthEntity authEntity = new AuthEntity();
//        authEntity.use_yn = "N";
        authEntity.auth_role = "USER";

        //given
        int result = authAdminDAO.countAll(authEntity);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void checkAuthVal() {
        //when
        AuthEntity authEntity = new AuthEntity();
        authEntity.auth_val = "S_ADMIN";

        //given
        int result = authAdminDAO.countByAuthVal(authEntity);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void inputAuth() throws Exception {
        //when
        AuthEntity authEntity = new AuthEntity();
        authEntity.auth_nm = "TEST1";
        authEntity.auth_val = "S_TEST1";
        authEntity.auth_role = "USER";
        authEntity.ord = "3";
        authEntity.bigo = "TEST1비고";

        //given
        int result = authAdminDAO.save(authEntity);

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getAuthInfo() {
        //when
        int authId = 12;

        //given
        AuthEntity result = authAdminDAO.findByAuthId(authId);

        //then
        Assertions.assertEquals("S_TEST1", result.auth_val);
    }

    @Test
    void updateAuth() throws Exception {
        //when
        AuthEntity authEntity = new AuthEntity();
        authEntity.auth_nm = "TEST2";
        authEntity.auth_role = "ADMIN";
        authEntity.ord = "4";
        authEntity.bigo = "TEST2비고";
        authEntity.use_yn = "N";
        authEntity.auth_id = 12;

        //given
        int result = authAdminDAO.updateAuth(authEntity);

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getAuthRoleList() {
        //when
        AuthEntity authEntity = new AuthEntity();
        authEntity.auth_role = "ADMIN";

        //given
        List<AuthEntity> result = authAdminDAO.findByAuthRoleAndUseYn(authEntity);

        //then
        Assertions.assertEquals(10, result.size());
    }
}