package egovframework.admin.code.service;

import egovframework.admin.code.service.domain.Code;
import egovframework.admin.code.service.domain.CodeEntity;
import egovframework.admin.code.service.domain.CodeGrp;
import java.util.List;

public interface CodeAdminService {

    List<CodeEntity> getCodeList(int codeGrpId);

    List<CodeEntity> getCodeItemList(String codeGrpVal);

    int inputCode(CodeEntity codeEntity) throws Exception;

    int updateCode(CodeEntity codeEntity) throws Exception;

    int deleteCode(CodeEntity codeEntity) throws Exception;
}
