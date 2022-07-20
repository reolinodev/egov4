package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.domain.QnaEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("QnaAdminDAO")
public class QnaAdminDAO extends EgovAbstractMapper {

    public List<QnaEntity> findAll(QnaEntity qnaEntity) {
        return (List<QnaEntity>) list("QnaAdminDAO.findAll", qnaEntity);
    }

    public int countAll(QnaEntity qnaEntity) {
        return selectOne("QnaAdminDAO.countAll", qnaEntity);
    }

    public int save(QnaEntity qnaEntity) throws Exception {
        return insert("QnaAdminDAO.save", qnaEntity);
    }

    public QnaEntity findByQnaId(int qnaId) {
        return selectOne("QnaAdminDAO.findByQnaId", qnaId);
    }

    public int updateQna(QnaEntity qnaEntity) throws Exception {
        return update("QnaAdminDAO.updateQna", qnaEntity);
    }

}
