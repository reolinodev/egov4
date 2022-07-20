package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.domain.PostEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("PostAdminDAO")
public class PostAdminDAO extends EgovAbstractMapper {

    public List<PostEntity> findAll(PostEntity postEntity) {
        return (List<PostEntity>) list("PostAdminDAO.findAll", postEntity);
    }

    public int countAll(PostEntity postEntity) {
        return selectOne("PostAdminDAO.countAll", postEntity);
    }

    public int save(PostEntity postEntity) throws Exception {
        return insert("PostAdminDAO.save", postEntity);
    }

    public PostEntity findByPostId(int postId) {
        return selectOne("PostAdminDAO.findByPostId", postId);
    }

    public int updatePost(PostEntity postEntity) throws Exception {
        return update("PostAdminDAO.updatePost", postEntity);
    }

    public int updatePostCnt(int postId) throws Exception {
        return update("PostAdminDAO.updatePostCnt", postId);
    }

}
