package egovframework.admin.login.service.impl;

import egovframework.admin.login.service.LoginVO;
import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("LoginDAO")
public class LoginDAO extends EgovAbstractMapper {

    @SuppressWarnings("unchecked")
    public int countByLoginId(LoginVO loginVO) throws Exception {
	    return (Integer)selectOne("LoginDAO.countByLoginId", loginVO);
    }
//
//    /**
//     * 동호회에 사용되는 게시판 사용정보 목록을 조회한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public List<BoardUseInf> selectBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
//	return (List<BoardUseInf>) list("BBSUseInfoManageDAO.selectBBSUseInfByClub", bdUseVO);
//    }
//
//    /**
//     * 커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
//	update("BBSUseInfoManageDAO.deleteAllBBSUseInfByCmmnty", bdUseVO);
//    }
//
//    /**
//     * 동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
//	update("BBSUseInfoManageDAO.deleteAllBBSUseInfByClub", bdUseVO);
//    }
//
//    /**
//     * 게시판 사용정보를 등록한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception {
//	insert("BBSUseInfoManageDAO.insertBBSUseInf", bdUseInf);
//    }
//
//    /**
//     * 게시판 사용정보 목록을 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public List<BoardUseInfVO> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception {
//	return (List<BoardUseInfVO>) list("BBSUseInfoManageDAO.selectBBSUseInfs", bdUseVO);
//    }
//
//    /**
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    public int selectBBSUseInfsCnt(BoardUseInfVO bdUseVO) throws Exception {
//	return (Integer)selectOne("BBSUseInfoManageDAO.selectBBSUseInfsCnt", bdUseVO);
//    }
//
//    /**
//     * 게시판 사용정보에 대한 상세정보를 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception {
//	return (BoardUseInfVO)selectOne("BBSUseInfoManageDAO.selectBBSUseInf", bdUseVO);
//    }
//
//    /**
//     * 게시판 사용정보를 수정한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception {
//	update("BBSUseInfoManageDAO.updateBBSUseInf", bdUseInf);
//    }
//
//    /**
//     * 게시판에 대한 사용정보를 삭제한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception {
//	update("BBSUseInfoManageDAO.deleteBBSUseInfByBoardId", bdUseInf);
//    }
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public List<BoardUseInfVO> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception {
//	return (List<BoardUseInfVO>) list("BBSUseInfoManageDAO.selectBBSUseInfsByTrget", bdUseVO);
//    }
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 전체 건수를 조회한다.
//     *
//     * @param bdUseVO
//     * @return
//     * @throws Exception
//     */
//    public int selectBBSUseInfsCntByTrget(BoardUseInfVO bdUseVO) throws Exception {
//	return (Integer)selectOne("BBSUseInfoManageDAO.selectBBSUseInfsCntByTrget", bdUseVO);
//    }
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
//     *
//     * @param bdUseInf
//     * @throws Exception
//     */
//    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception {
//	update("BBSUseInfoManageDAO.updateBBSUseInfByTrget", bdUseInf);
//    }
}
