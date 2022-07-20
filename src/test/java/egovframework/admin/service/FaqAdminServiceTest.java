package egovframework.admin.service;

import egovframework.admin.board.service.domain.FaqEntity;
import egovframework.admin.board.service.impl.FaqAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FaqAdminServiceTest {

    @Autowired
    private FaqAdminDAO faqAdminDAO;

    @Test
    void inputFaq() throws Exception {
        //when
        FaqEntity faqEntity = new FaqEntity();
        faqEntity.use_yn = "Y";
        faqEntity.board_id = 3;
        faqEntity.title = "로그인 아이디를 잃어버리면 어떻게 하나요?";
        faqEntity.main_text = "관리자에게 문의 하세요.";
        faqEntity.updated_id = 3;
        //given
        int result = faqAdminDAO.save(faqEntity);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getFaqList() {
        //when
        FaqEntity faqEntity = new FaqEntity();
        faqEntity.use_yn = "Y";
        faqEntity.board_id = 3;
        faqEntity.search_str = "로그인";
        faqEntity.start_idx = 0;
        faqEntity.page_per = 10;
        //given
        List<FaqEntity> result = faqAdminDAO.findAll(faqEntity);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void getFaqCount() {
        //when
        FaqEntity faqEntity = new FaqEntity();
        faqEntity.use_yn = "Y";
        faqEntity.board_id = 3;
        faqEntity.search_str = "로그인";

        //given
        int result = faqAdminDAO.countAll(faqEntity);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals(1, result);
    }


    @Test
    void getFaqInfo() {
        //when
        int faqId = 1;

        //given
        FaqEntity result = faqAdminDAO.findByFaqId(faqId);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals("관리자에게 문의 하세요.", result.main_text);
    }

    @Test
    void updateFaq() throws Exception {
        //when
        FaqEntity faqEntity = new FaqEntity();
        faqEntity.use_yn = "Y";
        faqEntity.title = "로그인 아이디를 잃어버리면 어떻게 하나요?!";
        faqEntity.main_text = "관리자에게 문의 하세요.!";
        faqEntity.updated_id = 3;
        faqEntity.faq_id = 1;
        //given
        int result = faqAdminDAO.updateFaq(faqEntity);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals(1, result);
    }


}