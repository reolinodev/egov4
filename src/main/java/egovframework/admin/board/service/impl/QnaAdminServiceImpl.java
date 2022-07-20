package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.QnaAdminService;
import egovframework.admin.board.service.domain.QnaEntity;
import egovframework.admin.login.service.domain.SessionAdminInfo;
import egovframework.common.support.CryptUtils;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("QnaAdminService")
public class QnaAdminServiceImpl extends EgovAbstractServiceImpl implements QnaAdminService {
	
    @Resource(name = "QnaAdminDAO")
    private QnaAdminDAO qnaAdminDAO;

    @Resource
    private SessionAdminInfo sessionAdminInfo;

    public List<QnaEntity> getQnaList(QnaEntity qnaEntity) {
        qnaEntity.setStart_idx(qnaEntity.getPage_per(), qnaEntity.getCurrent_page());
        return qnaAdminDAO.findAll(qnaEntity);
    }

    public int getQnaCount(QnaEntity qnaEntity) {
        return qnaAdminDAO.countAll(qnaEntity);
    }

    public int inputQna(QnaEntity qnaEntity) throws Exception {
        String hiddenYn = qnaEntity.hidden_yn;
        String qnaPw = qnaEntity.qna_pw;

        if("Y".equals(hiddenYn)&&!"".equals(qnaPw)){
            qnaEntity.setQna_pw(CryptUtils.encrypt(qnaPw));
        }
        return qnaAdminDAO.save(qnaEntity);
    }

    public QnaEntity getQnaInfo(int qnaId) {
        return qnaAdminDAO.findByQnaId(qnaId);
    }

    public int updateQna(QnaEntity qnaEntity) throws Exception {
        String hiddenYn = qnaEntity.hidden_yn;
        String qnaPw = qnaEntity.qna_pw;
        String mainText = qnaEntity.main_text;

        qnaEntity.updated_id = sessionAdminInfo.getUser_id();

        if("Y".equals(hiddenYn)&&!"".equals(qnaPw)){
            qnaEntity.setQna_pw(CryptUtils.encrypt(qnaPw));
        }

        if(!"".equals(mainText)){
            qnaEntity.response_yn ="Y";
        }

        return qnaAdminDAO.updateQna(qnaEntity);
    }
}
