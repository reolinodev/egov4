package egovframework.admin.code.service;

import egovframework.admin.code.service.domain.Code;
import egovframework.admin.code.service.domain.CodeEntity;
import egovframework.admin.code.service.impl.CodeAdminDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeAdminServiceTest {

    @Autowired
    private CodeAdminDAO codeAdminDAO;




//    public List<CodeEntity> getCodeList(int codeGrpId) {
//        return codeAdminDAO.findByCodeGrpId(codeGrpId);
//    }
//
//    public List<CodeEntity> getCodeItemList(String codeGrpVal) {
//        return codeAdminDAO.findByCodeGrpVal(codeGrpVal);
//    }
//
//    public int inputCode(CodeEntity codeEntity) throws Exception {
//        Code[] createdRows = codeEntity.created_rows;
//        int result = 1;
//
//        for (Code code : createdRows ) {
//            int result2 = codeAdminDAO.save(code);
//            if(result2 <= 0) result = 0;
//        }
//        return result;
//    }
//
//    public int updateCode(CodeEntity codeEntity) throws Exception {
//        Code[] updatedRows = codeEntity.updated_rows;
//        int result = 1;
//
//        for (Code code : updatedRows ) {
//            int result2 = codeAdminDAO.update(code);
//            if(result2 <= 0) result = 0;
//        }
//
//        return result;
//    }
//
//    public int deleteCode(CodeEntity codeEntity) throws Exception {
//        Code[] deletedRows = codeEntity.deleted_rows;
//        int result = 1;
//
//        for (Code code : deletedRows ) {
//            int codeId = code.code_id;
//            int result2 = codeAdminDAO.deleteById(codeId);
//            if(result2 <= 0) result = 0;
//        }
//        return result;
//    }

}