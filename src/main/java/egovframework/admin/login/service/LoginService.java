package egovframework.admin.login.service;

import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;
import java.util.Map;

public interface LoginService {


    public int checkLoginId(LoginVO loginVO) throws Exception;


//    /**
//     * 커뮤니티에 사용되는 게시판 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 동호회에 사용되는 게시판 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 게시판 사용정보를 등록한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception;
//
//    /**
//     * 게시판 사용정보 목록을 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    public Map<String, Object> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 게시판 사용정보를 수정한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception;
//
//    /**
//     * 게시판 사용정보에 대한 상세정보를 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 게시판에 대한 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception;
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    public Map<String, Object> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception;
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception;

}
