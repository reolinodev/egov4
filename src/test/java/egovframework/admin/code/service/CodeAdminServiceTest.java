package egovframework.admin.code.service;

import egovframework.admin.code.service.domain.Code;
import egovframework.admin.code.service.domain.CodeEntity;
import egovframework.admin.code.service.impl.CodeAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeAdminServiceTest {

    @Autowired
    private CodeAdminDAO codeAdminDAO;

    @Test
    void getCodeList() {
        //given
        int codeGrpId = 1;

        //when
        List<CodeEntity> result = codeAdminDAO.findByCodeGrpId(codeGrpId);
        //then
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void getCodeItemList() {
        //given
        String codeGrpVal = "USE_YN";

        //when
        List<CodeEntity> result = codeAdminDAO.findByCodeGrpVal(codeGrpVal);
        //then
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void inputCode() throws Exception {
        //given
        Code code = new Code();
        code.code_grp_id = 1;
        code.code_nm = "사용";
        code.code_val = "Y";
        code.ord = "1";

        //when
        int result = codeAdminDAO.save(code);

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void updateCode() throws Exception {
        //given
        Code code = new Code();
        code.code_id = 5;
        code.code_nm = "test3";
        code.code_val = "test3";
        code.ord = "3";
        code.bigo = "bigo3";

        //when
        int result = codeAdminDAO.update(code);

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void deleteCode() throws Exception {
        //given
        int codeId = 6;

        //when
        int result = codeAdminDAO.deleteById(codeId);

        //then
        Assertions.assertEquals(1, result);
    }

}