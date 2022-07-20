package egovframework.admin.board.service.impl;

import egovframework.admin.board.service.PostAdminService;
import egovframework.admin.board.service.domain.PostEntity;
import egovframework.admin.login.service.domain.SessionAdminInfo;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("PostAdminService")
public class PostAdminServiceImpl extends EgovAbstractServiceImpl implements PostAdminService {
	
    @Resource(name = "PostAdminDAO")
    private PostAdminDAO postAdminDAO;

    @Resource
    private SessionAdminInfo sessionAdminInfo;

    public List<PostEntity> getPostList(PostEntity postEntity) {
        postEntity.setStart_idx(postEntity.getPage_per(), postEntity.getCurrent_page());
        return postAdminDAO.findAll(postEntity);
    }

    public int getPostCount(PostEntity postEntity) {
        return postAdminDAO.countAll(postEntity);
    }

    public int inputPost(PostEntity postEntity) throws Exception {
        postEntity.updated_id = sessionAdminInfo.getUser_id();
        return postAdminDAO.save(postEntity);
    }

    public PostEntity getPostInfo(int postId) {
        return postAdminDAO.findByPostId(postId);
    }

    public int updatePost(PostEntity postEntity) throws Exception {
        postEntity.updated_id = sessionAdminInfo.getUser_id();
        return postAdminDAO.updatePost(postEntity);
    }

    public int updatePostCnt(int postId) throws Exception {
        return postAdminDAO.updatePostCnt(postId);
    }

}
