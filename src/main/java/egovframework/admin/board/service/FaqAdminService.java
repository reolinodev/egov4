package egovframework.admin.board.service;

import egovframework.admin.board.service.domain.FaqEntity;
import java.util.List;

public interface FaqAdminService {

    List<FaqEntity> getFaqList(FaqEntity faqEntity);

    int getFaqCount(FaqEntity faqEntity);

    int inputFaq(FaqEntity faqEntity) throws Exception;

    FaqEntity getFaqInfo(int faqId);

    int updateFaq(FaqEntity faqEntity) throws Exception;

}
