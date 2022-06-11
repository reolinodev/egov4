package egovframework.admin.mng.service.impl;

import egovframework.admin.mng.service.CodeGrpAdminService;
import egovframework.admin.mng.service.domain.CodeGrp;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("CodeGrpAdminService")
public class CodeGrpAdminServiceImpl extends EgovAbstractServiceImpl implements
    CodeGrpAdminService {
	
    @Resource(name = "CodeGrpAdminDAO")
    private CodeGrpAdminDAO codeGrpAdminDAO;

    public List<CodeGrp> getCodeGrpList(CodeGrp codeGrp) {
        return codeGrpAdminDAO.findAll(codeGrp);
    }

    public int getCodeGrpCount(CodeGrp codeGrp) {
        return codeGrpAdminDAO.countAll(codeGrp);
    }

    public int checkCodeGrpVal(CodeGrp codeGrp) {
        return codeGrpAdminDAO.countByCodeGrpVal(codeGrp);
    }

    public int inputCodeGrp(CodeGrp codeGrp) throws Exception {
        return codeGrpAdminDAO.save(codeGrp);
    }

    public CodeGrp getCodeGrpInfo(int codeGrpId) {
        return codeGrpAdminDAO.findByCodeGrpId(codeGrpId);
    }

    public int updateCodeGrp(CodeGrp codeGrp) throws Exception {
        return codeGrpAdminDAO.update(codeGrp);
    }
}
