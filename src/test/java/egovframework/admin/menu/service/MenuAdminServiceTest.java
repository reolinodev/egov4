package egovframework.admin.menu.service;

import egovframework.admin.menu.service.domain.MenuEntity;
import egovframework.admin.menu.service.impl.MenuAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuAdminServiceTest {


    @Autowired
    private MenuAdminDAO menuAdminDAO;

    @Test
    void inputMenu() throws Exception {
        //given
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.menu_nm ="권한별 메뉴 관리";
        menuEntity.menu_lv = 2;
        menuEntity.menu_url = "/admin/menu/authMenu";
        menuEntity.parent_id = 3;
        menuEntity.ord = 2;
        menuEntity.menu_type ="URL";
        menuEntity.use_yn = "Y";

        //when
        int result = menuAdminDAO.save(menuEntity);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getMenuList() throws Exception {
        //given
        String auth_role ="ADMIN";

        //when
        List<MenuEntity> result = menuAdminDAO.findAllMenu(auth_role);
        //then
        Assertions.assertEquals(7, result.size());
    }

    @Test
    void getMenuInfo() throws Exception {
        //given
        int menuId = 2;

        //when
        MenuEntity result = menuAdminDAO.findByMenuId(menuId);
        //then
        Assertions.assertEquals("사용자 설정", result.menu_nm);
    }

}