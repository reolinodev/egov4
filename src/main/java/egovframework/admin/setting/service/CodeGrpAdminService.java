package egovframework.admin.setting.service;

import egovframework.admin.setting.service.domain.CodeGrp;
import java.util.List;

public interface CodeGrpAdminService {

    List<CodeGrp> getCodeGrpList(CodeGrp codeGrp);

    int getCodeGrpCount(CodeGrp codeGrp);

    int checkCodeGrpVal(CodeGrp codeGrp);

    int inputCodeGrp(CodeGrp codeGrp) throws Exception;

    CodeGrp getCodeGrpInfo(int codeGrpId);

    int updateCodeGrp(CodeGrp codeGrp) throws Exception;
}