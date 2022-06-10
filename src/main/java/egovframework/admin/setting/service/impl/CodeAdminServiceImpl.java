package egovframework.admin.setting.service.impl;

import egovframework.admin.setting.service.CodeAdminService;
import egovframework.admin.setting.service.domain.Code;
import egovframework.admin.setting.service.domain.CodeEntity;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("CodeAdminService")
public class CodeAdminServiceImpl extends EgovAbstractServiceImpl implements CodeAdminService {
	
    @Resource(name = "CodeAdminDAO")
    private CodeAdminDAO codeAdminDAO;

    public List<CodeEntity> getCodeList(int codeGrpId) {
        return codeAdminDAO.findByCodeGrpId(codeGrpId);
    }

    public List<CodeEntity> getCodeItemList(String codeGrpVal) {
        return codeAdminDAO.findByCodeGrpVal(codeGrpVal);
    }

    public int inputCode(CodeEntity codeEntity) throws Exception {
        Code[] createdRows = codeEntity.created_rows;
        int result = 1;

        for (Code code : createdRows ) {
            int result2 = codeAdminDAO.save(code);
            if(result2 <= 0) result = 0;
        }
        return result;
    }

    public int updateCode(CodeEntity codeEntity) throws Exception {
        Code[] updatedRows = codeEntity.updated_rows;
        int result = 1;

        for (Code code : updatedRows ) {
            int result2 = codeAdminDAO.update(code);
            if(result2 <= 0) result = 0;
        }

        return result;
    }

    public int deleteCode(CodeEntity codeEntity) throws Exception {
        Code[] deletedRows = codeEntity.deleted_rows;
        int result = 1;

        for (Code code : deletedRows ) {
            int codeId = code.code_id;
            int result2 = codeAdminDAO.deleteById(codeId);
            if(result2 <= 0) result = 0;
        }
        return result;
    }
}
