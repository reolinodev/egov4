package egovframework.admin.board.service;

import egovframework.admin.board.service.domain.PostEntity;
import java.util.List;

public interface PostAdminService {
    List<PostEntity> getPostList(PostEntity postEntity);

    int getPostCount(PostEntity postEntity);

    int inputPost(PostEntity postEntity) throws Exception;

    PostEntity getPostInfo(int postId);

    int updatePost(PostEntity postEntity) throws Exception;

    int updatePostCnt(int postId) throws Exception;

}
