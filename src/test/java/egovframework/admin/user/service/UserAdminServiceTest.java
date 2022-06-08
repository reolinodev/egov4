package egovframework.admin.user.service;

import egovframework.admin.user.service.domain.UserEntity;
import egovframework.admin.user.service.impl.UserAdminDAO;
import egovframework.let.utl.sim.service.EgovFileScrty;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAdminServiceTest {

    @Autowired
    private UserAdminDAO userAdminDAO;

    @Test
    void checkLoginId() {
        //when
        String login_id="kychoi83";
        //given
        int result = userAdminDAO.countByLoginId(login_id);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void findByLoginId() {
        //when
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin_id("kychoi83");

        UserEntity result = userAdminDAO.findByLoginId(userEntity);

        //then
        Assertions.assertEquals("kychoi83", result.login_id);
    }

    @Test
    void save() throws Exception {
        //when
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin_id("kychoi8312312312321");
        userEntity.setUser_nm("최규연");
        userEntity.setUser_pw("1111");
        userEntity.setEmail("reolino@gmail.com");
        userEntity.setCell_phone("01011112222");

        String login_id="kychoi83123";

        //given
        userAdminDAO.save(userEntity);
        int result = userAdminDAO.countByLoginId(login_id);


        //then
        Assertions.assertEquals(1, result);
    }


    @Test
    void updateUserPw() throws Exception {
        //when
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin_id("kychoi83123");
        userEntity.setUser_pw("1111");
        userEntity.setUser_pw(EgovFileScrty.encryptPassword(userEntity.user_pw));

        //given
        int result = userAdminDAO.updateUserPw(userEntity);

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void findAll() {
        //when
        UserEntity userEntity = new UserEntity();
        userEntity.setCurrent_page(1);
        userEntity.setPage_per(10);
        userEntity.setSearch_str("kychoi83");

        //given
        List<UserEntity> result = userAdminDAO.findAll(userEntity);
        System.out.println("<<"+ result);

        //then
        Assertions.assertEquals("kychoi83123", result.get(0).login_id);
    }

    @Test
    void getUserCount() {
        //when
        UserEntity userEntity = new UserEntity();
        userEntity.setSearch_str("kychoi83");

        //given
        int result = userAdminDAO.countByAll(userEntity);
        System.out.println("<<"+ result);

        //then
        Assertions.assertEquals(4, result);
    }

    @Test
    void getUserInfo() {
        //when
        int userId = 3;

        //given
        UserEntity result =  userAdminDAO.findByUserId(userId);

        //then
        Assertions.assertEquals("kychoi83", result.login_id);
    }

    @Test
    void updateUser() throws Exception {
        //when
        UserEntity userEntity = new UserEntity();
        userEntity.user_id = 17;
        userEntity.user_pw = "2222";
        userEntity.setUser_pw(EgovFileScrty.encryptPassword(userEntity.user_pw));

        int result = userAdminDAO.updateUser(userEntity);

        //then
        Assertions.assertEquals(1, result);
    }
}