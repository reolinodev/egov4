package egovframework.admin.board.service;

import egovframework.admin.board.service.domain.QnaEntity;
import java.util.List;

public interface QnaAdminService {

    List<QnaEntity> getQnaList(QnaEntity qnaEntity);

    int getQnaCount(QnaEntity qnaEntity);

    int inputQna(QnaEntity qnaEntity) throws Exception;

    QnaEntity getQnaInfo(int qnaId);

    int updateQna(QnaEntity qnaEntity) throws Exception;
}
