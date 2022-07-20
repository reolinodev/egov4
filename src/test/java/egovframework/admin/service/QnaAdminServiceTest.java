package egovframework.admin.service;

import egovframework.admin.board.service.domain.QnaEntity;
import egovframework.admin.board.service.impl.QnaAdminDAO;
import egovframework.common.support.CryptUtils;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaAdminServiceTest {
    @Autowired
    private QnaAdminDAO qnaAdminDAO;

    @Test
    void getQnaList() {
        //when
        QnaEntity qnaEntity = new QnaEntity();
        qnaEntity.start_idx = 0;
        qnaEntity.page_per = 10;
        qnaEntity.response_yn = "N";
        qnaEntity.board_id = 4;
        qnaEntity.search_str ="비밀";
        qnaEntity.use_yn = "Y";
        qnaEntity.qna_type ="MEMBER";
        //given
        List<QnaEntity> result = qnaAdminDAO.findAll(qnaEntity);
        //then
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void getQnaCount() {
        //when
        QnaEntity qnaEntity = new QnaEntity();
        qnaEntity.response_yn = "N";
        qnaEntity.board_id = 4;
//        qnaEntity.search_str ="비밀";
        qnaEntity.use_yn = "Y";
        qnaEntity.qna_type ="MEMBER";
        //given
        int result = qnaAdminDAO.countAll(qnaEntity);
        //then
        Assertions.assertEquals(2, result);
    }


    @Test
    void inputQna() throws Exception {
        //when
        QnaEntity qnaEntity = new QnaEntity();
        qnaEntity.board_id = 4;
        qnaEntity.title = "회원가입시 비밀글 테스트입니다.2";
        qnaEntity.questions = "비밀글 테스트 해볼께요2";
        qnaEntity.hidden_yn = "Y";
        qnaEntity.qna_pw = "1111";
        qnaEntity.qna_type = "MEMBER";
        qnaEntity.created_id = 3;

        String hiddenYn = qnaEntity.hidden_yn;
        String qnaPw = qnaEntity.qna_pw;

        if("Y".equals(hiddenYn)&&!"".equals(qnaPw)){
            qnaEntity.setQna_pw(CryptUtils.encrypt(qnaPw));
        }

        //given
        int result = qnaAdminDAO.save(qnaEntity);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getQnaInfo() {
        //when
        int qnaId = 4;
        //given
        QnaEntity result = qnaAdminDAO.findByQnaId(qnaId);
        //then
        Assertions.assertEquals("회원가입시 비밀글 테스트입니다.2", result.title);
    }

    @Test
    void updateQna() throws Exception {
        //when
        QnaEntity qnaEntity = new QnaEntity();
        qnaEntity.qna_id = 4;
        qnaEntity.title = "비밀글 업데이트 테스트";
        qnaEntity.main_text = "답변이에요";
        qnaEntity.updated_id = 2;
        qnaEntity.hidden_yn = "N";
        qnaEntity.qna_pw = "2222";
        qnaEntity.use_yn = "Y";

        String hiddenYn = qnaEntity.hidden_yn;
        String qnaPw = qnaEntity.qna_pw;
        String mainText = qnaEntity.main_text;

        if("Y".equals(hiddenYn)&&!"".equals(qnaPw)){
            qnaEntity.setQna_pw(CryptUtils.encrypt(qnaPw));
        }

        if(!"".equals(mainText)){
            qnaEntity.response_yn ="Y";
        }

        //given
        int  result = qnaAdminDAO.updateQna(qnaEntity);
        //then
        Assertions.assertEquals(1, result);
    }

}