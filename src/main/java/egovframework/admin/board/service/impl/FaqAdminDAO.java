package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.domain.FaqEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("FaqAdminDAO")
public class FaqAdminDAO extends EgovAbstractMapper {

    public List<FaqEntity> findAll(FaqEntity faqEntity) {
        return (List<FaqEntity>) list("FaqAdminDAO.findAll", faqEntity);
    }

    public int countAll(FaqEntity faqEntity) {
        return selectOne("FaqAdminDAO.countAll", faqEntity);
    }

    public int save(FaqEntity faqEntity) throws Exception {
        return insert("FaqAdminDAO.save", faqEntity);
    }

    public FaqEntity findByFaqId(int faqId) {
        return selectOne("FaqAdminDAO.findByFaqId", faqId);
    }

    public int updateFaq(FaqEntity faqEntity) throws Exception {
        return update("FaqAdminDAO.updateFaq", faqEntity);
    }
}
