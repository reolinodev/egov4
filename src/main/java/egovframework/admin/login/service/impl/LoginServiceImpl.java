package egovframework.admin.login.service.impl;

import egovframework.admin.login.service.LoginService;
import egovframework.admin.login.service.LoginVO;
import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;
import egovframework.let.cop.com.service.EgovBBSUseInfoManageService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService {
	
    @Resource(name = "LoginDAO")
    private LoginDAO loginDAO;

    public int checkLoginId(LoginVO loginVO) throws Exception {
	    return loginDAO.countByLoginId(loginVO);
    }

//    /**
//     * 게시판 사용 정보를 삭제한다.
//     *
//     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#deleteBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInf)
//     */
//    public void deleteBBSUseInf(BoardUseInf bdUseInf) throws Exception {
//	bbsUseDAO.deleteBBSUseInf(bdUseInf);
//    }
//
//    /**
//     * 게시판 사용정보를 등록한다.
//     *
//     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#insertBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInf)
//     */
//    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception {
//	bbsUseDAO.insertBBSUseInf(bdUseInf);
//    }
//
//    /**
//     * 게시판 사용정보 목록을 조회한다.
//     *
//     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#selectBBSUseInfs(egovframework.let.cop.bbs.com.service.BoardUseInfVO)
//     */
//    public Map<String, Object> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception {
//
//	List<BoardUseInfVO> result = bbsUseDAO.selectBBSUseInfs(bdUseVO);
//	int cnt = bbsUseDAO.selectBBSUseInfsCnt(bdUseVO);
//
//	Map<String, Object> map = new HashMap<String, Object>();
//
//	map.put("resultList", result);
//	map.put("resultCnt", Integer.toString(cnt));
//
//	return map;
//    }
//
//    /**
//     * 게시판 사용정보를 수정한다.
//     *
//     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#updateBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInf)
//     */
//    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception {
//	bbsUseDAO.updateBBSUseInf(bdUseInf);
//    }
//
//    /**
//     * 게시판 사용정보에 대한 상세정보를 조회한다.
//     *
//     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#selectBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInfVO)
//     */
//    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception {
//	return bbsUseDAO.selectBBSUseInf(bdUseVO);
//    }
//
//    /**
//     * 동호회에 사용되는 게시판 사용정보를 삭제한다.
//     *
//     * @see EgovBBSUseInfoManageService#deleteBBSUseInfByClub(BoardUseInf)
//     */
//    public void deleteBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
//	List<BoardUseInf> result = bbsUseDAO.selectBBSUseInfByClub(bdUseVO);
//
//	BoardUseInf bdUseInf = null;
//	Iterator<BoardUseInf> iter = result.iterator();
//	while (iter.hasNext()) {
//	    bdUseInf = (BoardUseInf)iter.next();
//
//	    bdUseInf.setLastUpdusrId(bdUseVO.getLastUpdusrId());
//	    //bdUseInf.setTrgetId(bdUseVO.getClbId());	// 사용자 ID를 넘겨야 함..
//	    bdUseInf.setTrgetId(bdUseVO.getTrgetId());
//
//	    bbsUseDAO.deleteBBSUseInf(bdUseInf);
//	}
//    }
//
//    /**
//     * 커뮤니티에 사용되는 게시판 사용정보를 삭제한다.
//     *
//     * @see EgovBBSUseInfoManageService#deleteBBSUseInfByCmmnty(BoardUseInf)
//     */
//    public void deleteBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
//	List<BoardUseInf> result = bbsUseDAO.selectBBSUseInfByCmmnty(bdUseVO);
//
//	BoardUseInf bdUseInf = null;
//	Iterator<BoardUseInf> iter = result.iterator();
//
//	while (iter.hasNext()) {
//	    bdUseInf = (BoardUseInf)iter.next();
//
//	    bdUseInf.setLastUpdusrId(bdUseVO.getLastUpdusrId());
//	    //bdUseInf.setTrgetId(bdUseVO.getCmmntyId());	// 사용자 ID를 넘겨야 함..
//	    bdUseInf.setTrgetId(bdUseVO.getTrgetId());
//
//	    bbsUseDAO.deleteBBSUseInf(bdUseInf);
//	}
//    }
//
//    /**
//     * 동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
//     *
//     * @see EgovBBSUseInfoManageService#deleteAllBBSUseInfByClub(BoardUseInfVO)
//     */
//    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
//	bbsUseDAO.deleteAllBBSUseInfByClub(bdUseVO);
//    }
//
//    /**
//     * 커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
//     *
//     * @see EgovBBSUseInfoManageService#deleteAllBBSUseInfByCmmnty(BoardUseInfVO)
//     */
//    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
//	bbsUseDAO.deleteAllBBSUseInfByCmmnty(bdUseVO);
//    }
//
//    /**
//     * 게시판에 대한 사용정보를 삭제한다.
//     *
//     * @see EgovBBSUseInfoManageService#deleteBBSUseInfByBoardId(BoardUseInf)
//     */
//    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception {
//	bbsUseDAO.deleteBBSUseInfByBoardId(bdUseInf);
//    }
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
//     *
//     * @see EgovBBSUseInfoManageService#selectBBSUseInfsByTrget(BoardUseInfVO)
//     */
//    public Map<String, Object> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception {
//	List<BoardUseInfVO> result = bbsUseDAO.selectBBSUseInfsByTrget(bdUseVO);
//	int cnt = bbsUseDAO.selectBBSUseInfsCntByTrget(bdUseVO);
//
//	Map<String, Object> map = new HashMap<String, Object>();
//
//	map.put("resultList", result);
//	map.put("resultCnt", Integer.toString(cnt));
//
//	return map;
//    }
//
//    /**
//     * 커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
//     */
//    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception {
//	bbsUseDAO.updateBBSUseInfByTrget(bdUseInf);
//    }
}
