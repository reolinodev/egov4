package egovframework.admin.board.web;

import egovframework.admin.board.service.FaqAdminService;
import egovframework.admin.board.service.PostAdminService;
import egovframework.admin.board.service.QnaAdminService;
import egovframework.admin.board.service.domain.FaqEntity;
import egovframework.admin.board.service.domain.PostEntity;
import egovframework.admin.board.service.domain.QnaEntity;
import egovframework.common.support.CryptUtils;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/board")
public class BoardAdminController {

    private final PostAdminService postAdminService;

    private final FaqAdminService faqAdminService;

    private final QnaAdminService qnaAdminService;

    /**
     * 게시판 관리 화면
     */
    @GetMapping(value = "/board")
    public ModelAndView boardView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/boardView");
        return mav;
    }

    /**
     * 게시글 관리 화면
     */
    @GetMapping(value = "/post")
    public ModelAndView postView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/postView");
        return mav;
    }

    /**
     * 게시글 관리 화면
     */
    @GetMapping(value = "/post/write")
    public ModelAndView postWriteView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/postWrite");
        return mav;
    }

    /**
     * 게시글 상세 뷰 화면
     */
    @GetMapping(value = "/post/view/{post_id}")
    public ModelAndView postEditView(@PathVariable Integer post_id) throws Exception {
        ModelAndView mav = new ModelAndView();

        PostEntity data = postAdminService.getPostInfo(post_id);
        postAdminService.updatePostCnt(post_id);

        mav.addObject("data", data);
        mav.setViewName("/admin/board/postEditView");
        return mav;
    }

    /**
     * 게시글 수정 화면
     */
    @GetMapping(value = "/post/edit/{post_id}")
    public ModelAndView postEditorView(@PathVariable Integer post_id) {
        ModelAndView mav = new ModelAndView();

        PostEntity data = postAdminService.getPostInfo(post_id);
        mav.addObject("data", data);
        mav.setViewName("/admin/board/postEdit");
        return mav;
    }

    /**
     * FAQ 관리 화면
     */
    @GetMapping(value = "/faq")
    public ModelAndView faqView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/faqView");
        return mav;
    }

    /**
     * 게시글 수정 화면
     */
    @GetMapping(value = "/faq/edit/{faq_id}")
    public ModelAndView faqEditorView(@PathVariable Integer faq_id) {
        ModelAndView mav = new ModelAndView();

        FaqEntity data = faqAdminService.getFaqInfo(faq_id);
        mav.addObject("data", data);
        mav.setViewName("/admin/board/faqEdit");
        return mav;
    }

    /**
     *  FAQ 등록 화면
     */
    @GetMapping(value = "/faq/write")
    public ModelAndView qnaWriteView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/faqWrite");
        return mav;
    }

    /**
     * QNA 관리 화면
     */
    @GetMapping(value = "/qna")
    public ModelAndView qnaView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/qnaView");
        return mav;
    }

    /**
     * QNA 수정 화면
     */
    @GetMapping(value = "/qna/edit/{qna_id}")
    public ModelAndView qnaEditorView(@PathVariable Integer qna_id) throws IOException {
        ModelAndView mav = new ModelAndView();

        QnaEntity data = qnaAdminService.getQnaInfo(qna_id);
        if(!"".equals(data.qna_pw)){
            data.qna_pw = CryptUtils.decrypt(data.qna_pw);
        }

        mav.addObject("data", data);
        mav.setViewName("/admin/board/qnaEdit");
        return mav;
    }


}