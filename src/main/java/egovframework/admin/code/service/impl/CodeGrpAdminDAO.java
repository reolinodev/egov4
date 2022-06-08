package egovframework.admin.code.service.impl;

import egovframework.admin.code.service.domain.CodeGrp;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("CodeGrpAdminDAO")
public class CodeGrpAdminDAO extends EgovAbstractMapper {

    public List<CodeGrp> findAll(CodeGrp codeGrp) {
        return (List<CodeGrp>) list("CodeGrpAdminDAO.findAll", codeGrp);
    }

    public int countAll(CodeGrp codeGrp) {
        return selectOne("CodeGrpAdminDAO.countAll", codeGrp);
    }

    public int countByCodeGrpVal(CodeGrp codeGrp) {
        return selectOne("CodeGrpAdminDAO.countByCodeGrpVal", codeGrp);
    }

    public int save(CodeGrp codeGrp) throws Exception {
        return insert("CodeGrpAdminDAO.save", codeGrp);
    }

    public CodeGrp findByCodeGrpId(int codeGrpId) {
        return selectOne("CodeGrpAdminDAO.findByCodeGrpId", codeGrpId);
    }

    public int update(CodeGrp codeGrp) throws Exception {
        return update("CodeGrpAdminDAO.update", codeGrp);
    }
}
