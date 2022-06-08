package egovframework.admin.login.service;

import egovframework.admin.login.service.impl.LoginAdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginAdminDAO loginAdminDAO;

}