package egovframework.admin.mng.service;

import egovframework.admin.mng.service.domain.CodeGrp;
import egovframework.admin.mng.service.impl.CodeGrpAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeGrpAdminServiceTest {

    @Autowired
    private CodeGrpAdminDAO codeGrpAdminDAO;

    @Test
    void getCodeGrpList() {
        //given
        CodeGrp codeGrp = new CodeGrp();
        codeGrp.use_yn = "Y";
        codeGrp.start_idx = 0;
        codeGrp.page_per = 10;
        codeGrp.search_str = "메뉴 레벨";

        //when
        List<CodeGrp> result = codeGrpAdminDAO.findAll(codeGrp);
        //then
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void getCodeGrpCount() {
        //given
        CodeGrp codeGrp = new CodeGrp();
        codeGrp.use_yn = "Y";
        codeGrp.search_str = "메뉴 레벨";

        //when
        int result = codeGrpAdminDAO.countAll(codeGrp);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void checkCodeGrpVal() {
        //given
        CodeGrp codeGrp = new CodeGrp();
        codeGrp.code_grp_val = "MENU_LV";

        //when
        int result = codeGrpAdminDAO.countByCodeGrpVal(codeGrp);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void inputCodeGrp() throws Exception {
        //given
        CodeGrp codeGrp = new CodeGrp();
        codeGrp.code_grp_val = "AUTH_ROLE";
        codeGrp.code_grp_nm = "권한구분";

        //when
        int result = codeGrpAdminDAO.save(codeGrp);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getCodeGrpInfo() {
        //given
        int codeGrpId = 16;

        //when
        CodeGrp result = codeGrpAdminDAO.findByCodeGrpId(codeGrpId);

        //then
        Assertions.assertEquals("TEST111", result.code_grp_val);
    }

    @Test
    void updateCodeGrp() throws Exception {
        //given
        CodeGrp codeGrp = new CodeGrp();
        codeGrp.code_grp_nm = "TEST333";
        codeGrp.use_yn = "Y";
        codeGrp.updated_id = 1;
        codeGrp.code_grp_id = 16;

        //when
        int result = codeGrpAdminDAO.update(codeGrp);
        //then
        Assertions.assertEquals(1, result);
    }
}