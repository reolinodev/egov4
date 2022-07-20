package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.domain.BoardEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("BoardAdminDAO")
public class BoardAdminDAO extends EgovAbstractMapper {

    public List<BoardEntity> findAll(BoardEntity boardEntity) {
        return (List<BoardEntity>) list("BoardAdminDAO.findAll", boardEntity);
    }

    public int countAll(BoardEntity boardEntity) {
        return selectOne("BoardAdminDAO.countAll", boardEntity);
    }

    public int save(BoardEntity boardEntity) throws Exception {
        return insert("BoardAdminDAO.save", boardEntity);
    }

    public BoardEntity findByBoardId(int boardId) {
        return selectOne("BoardAdminDAO.findByBoardId", boardId);
    }

    public int updateBoard(BoardEntity boardEntity) {
        return update("BoardAdminDAO.updateBoard", boardEntity);
    }

    public List<BoardEntity> findByUseYnYAndBoardTypeNotIn(BoardEntity boardEntity) {
        return (List<BoardEntity>) list("BoardAdminDAO.findByUseYnYAndBoardTypeNotIn", boardEntity);
    }

    public List<BoardEntity> findByUseYnYAndBoardTypeEqulsFAQ(BoardEntity boardEntity) {
        return (List<BoardEntity>) list("BoardAdminDAO.findByUseYnYAndBoardTypeEqulsFAQ", boardEntity);
    }

    public List<BoardEntity> findByUseYnYAndBoardTypeEqulsQNA(BoardEntity boardEntity) {
        return (List<BoardEntity>) list("BoardAdminDAO.findByUseYnYAndBoardTypeEqulsQNA", boardEntity);
    }
}
