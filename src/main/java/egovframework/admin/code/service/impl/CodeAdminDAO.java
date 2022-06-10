package egovframework.admin.code.service.impl;

import egovframework.admin.code.service.domain.Code;
import egovframework.admin.code.service.domain.CodeEntity;
import egovframework.admin.code.service.domain.CodeGrp;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("CodeAdminDAO")
public class CodeAdminDAO extends EgovAbstractMapper {

    public List<CodeEntity> findByCodeGrpId(int codeId) {
        return (List<CodeEntity>) list("CodeAdminDAO.findByCodeGrpId", codeId);
    }

    public List<CodeEntity> findByCodeGrpVal(String codeGrpVal) {
        return (List<CodeEntity>) list("CodeAdminDAO.findByCodeGrpVal", codeGrpVal);
    }

    public int save(Code code) throws Exception {
        return insert("CodeAdminDAO.save", code);
    }

    public int update(Code code) throws Exception {
        return update("CodeAdminDAO.update", code);
    }

    public int deleteById(int codeId) throws Exception {
        return delete("CodeAdminDAO.deleteById", codeId);
    }
}
