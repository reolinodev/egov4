package egovframework.admin.service;

import egovframework.admin.board.service.domain.BoardEntity;
import egovframework.admin.board.service.impl.BoardAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardAdminServiceTest {

    @Autowired
    private BoardAdminDAO boardAdminDAO;

    @Test
    void inputBoard() throws Exception {
        //when
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.title = "공지사항";
        boardEntity.bigo = "공지사항 게시판";
        boardEntity.board_type = "LIST";
        boardEntity.updated_id = 2;

        //given
        int result = boardAdminDAO.save(boardEntity);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getBoardList() {
        //when
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.start_idx = 0;
        boardEntity.page_per = 10;
        boardEntity.use_yn = "Y";
        boardEntity.search_str = "공지사항";
        boardEntity.board_type = "LIST";

        //given
        List<BoardEntity> result = boardAdminDAO.findAll(boardEntity);
        System.out.println("<<<"+ result);
        //then
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void getBoardCount() {
        //when
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.use_yn = "Y";
        boardEntity.search_str = "공지사항";
        boardEntity.board_type = "LIST";

        //given
        int result = boardAdminDAO.countAll(boardEntity);
        System.out.println("<<<"+ result);
        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    void getAvailableBoardList() {
        //when
        BoardEntity boardEntity = new BoardEntity();

        //given
        List<BoardEntity> result = boardAdminDAO.findByUseYnYAndBoardTypeNotIn(boardEntity);
        System.out.println("<<<"+ result);
        //then
        Assertions.assertEquals(2, result.size());
    }

}