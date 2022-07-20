package egovframework.admin.service;

import egovframework.admin.board.service.domain.PostEntity;
import egovframework.admin.board.service.impl.PostAdminDAO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostAdminServiceTest {

    @Autowired
    private PostAdminDAO postAdminDAO;

    @Test
    void getPostList() {
        //when
        PostEntity postEntity = new PostEntity();
        postEntity.use_yn = "Y";
        postEntity.board_id = 1;
        postEntity.search_str = "최규연";
        postEntity.start_date = "20220401";
        postEntity.end_date = "20220430";
        postEntity.start_idx = 0;
        postEntity.page_per = 10;
        //given
        List<PostEntity> result = postAdminDAO.findAll(postEntity);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void getPostCount() {
        //when
        PostEntity postEntity = new PostEntity();
        postEntity.use_yn = "Y";
        postEntity.board_id = 1;
        postEntity.search_str = "최규연";
        postEntity.start_date = "20220401";
        postEntity.end_date = "20220430";

        //given
        int result = postAdminDAO.countAll(postEntity);
        System.out.println("<<<" + result);
        //then
        Assertions.assertEquals(0, result);
    }
}
