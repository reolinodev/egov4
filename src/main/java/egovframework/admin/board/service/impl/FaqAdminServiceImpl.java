package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.FaqAdminService;
import egovframework.admin.board.service.domain.FaqEntity;
import egovframework.admin.login.service.domain.SessionAdminInfo;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("FaqAdminService")
public class FaqAdminServiceImpl extends EgovAbstractServiceImpl implements FaqAdminService {
	
    @Resource(name = "FaqAdminDAO")
    private FaqAdminDAO faqAdminDAO;

    @Resource
    private SessionAdminInfo sessionAdminInfo;

    public List<FaqEntity> getFaqList(FaqEntity faqEntity) {
        faqEntity.setStart_idx(faqEntity.getPage_per(), faqEntity.getCurrent_page());
        return faqAdminDAO.findAll(faqEntity);
    }

    public int getFaqCount(FaqEntity faqEntity) {
        return faqAdminDAO.countAll(faqEntity);
    }

    public int inputFaq(FaqEntity faqEntity) throws Exception {
        faqEntity.updated_id = sessionAdminInfo.getUser_id();
        return faqAdminDAO.save(faqEntity);
    }

    public FaqEntity getFaqInfo(int faqId) {
        return faqAdminDAO.findByFaqId(faqId);
    }

    public int updateFaq(FaqEntity faqEntity) throws Exception {
        faqEntity.updated_id = sessionAdminInfo.getUser_id();
        return faqAdminDAO.updateFaq(faqEntity);
    }
}
