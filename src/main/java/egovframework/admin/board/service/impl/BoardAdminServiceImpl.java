package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.BoardAdminService;
import egovframework.admin.board.service.domain.BoardEntity;
import egovframework.admin.login.service.domain.SessionAdminInfo;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("BoardAdminService")
public class BoardAdminServiceImpl extends EgovAbstractServiceImpl implements BoardAdminService {
	
    @Resource(name = "BoardAdminDAO")
    private BoardAdminDAO boardAdminDAO;

    @Resource
    private SessionAdminInfo sessionAdminInfo;

    public List<BoardEntity> getBoardList(BoardEntity boardEntity) {
        boardEntity.setStart_idx(boardEntity.getPage_per(), boardEntity.getCurrent_page());
        return boardAdminDAO.findAll(boardEntity);
    }

    public int getBoardCount(BoardEntity boardEntity) {
        return boardAdminDAO.countAll(boardEntity);
    }

    public int inputBoard(BoardEntity boardEntity) throws Exception {
        boardEntity.updated_id = sessionAdminInfo.getUser_id();
        return boardAdminDAO.save(boardEntity);
    }

    public BoardEntity getBoardInfo(int boardId) {
        return boardAdminDAO.findByBoardId(boardId);
    }

    public int updateBoard(BoardEntity boardEntity) throws Exception {
        boardEntity.updated_id = sessionAdminInfo.getUser_id();
        return boardAdminDAO.updateBoard(boardEntity);
    }

    public List<BoardEntity> getAvailableBoardList(BoardEntity boardEntity) {
        return boardAdminDAO.findByUseYnYAndBoardTypeNotIn(boardEntity);
    }

    public List<BoardEntity> getAvailableFaqList(BoardEntity boardEntity) {
        return boardAdminDAO.findByUseYnYAndBoardTypeEqulsFAQ(boardEntity);
    }

    public List<BoardEntity> getAvailableQnaList(BoardEntity boardEntity) {
        return boardAdminDAO.findByUseYnYAndBoardTypeEqulsQNA(boardEntity);
    }
}
