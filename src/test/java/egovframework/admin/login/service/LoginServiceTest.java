package egovframework.admin.login.service;

import egovframework.admin.login.service.impl.LoginDAO;
import javax.annotation.Resource;
import lombok.var;
import org.checkerframework.checker.units.qual.A;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginDAO loginDAO;

    @Test
    void checkLoginId() throws Exception {
        //when
        LoginVO loginVO = new LoginVO();
        loginVO.login_id = "kychoi83";
        //given
        var result = loginDAO.countByLoginId(loginVO);
        System.out.println("<<"+ result);

        //then
        Assertions.assertEquals(1, result);
    }

}