package egovframework.admin.board.service;

import egovframework.admin.board.service.domain.BoardEntity;
import java.util.List;

public interface BoardAdminService {
    List<BoardEntity> getBoardList(BoardEntity boardEntity);

    int getBoardCount(BoardEntity boardEntity);

    int inputBoard(BoardEntity boardEntity) throws Exception;

    BoardEntity getBoardInfo(int boardId);

    int updateBoard(BoardEntity boardEntity) throws Exception;

    List<BoardEntity> getAvailableBoardList(BoardEntity boardEntity);

    List<BoardEntity> getAvailableFaqList(BoardEntity boardEntity);

    List<BoardEntity> getAvailableQnaList(BoardEntity boardEntity);
}
