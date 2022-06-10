package egovframework.admin.setting.service;

import egovframework.admin.setting.service.domain.CodeEntity;
import java.util.List;

public interface CodeAdminService {

    List<CodeEntity> getCodeList(int codeGrpId);

    List<CodeEntity> getCodeItemList(String codeGrpVal);

    int inputCode(CodeEntity codeEntity) throws Exception;

    int updateCode(CodeEntity codeEntity) throws Exception;

    int deleteCode(CodeEntity codeEntity) throws Exception;
}
