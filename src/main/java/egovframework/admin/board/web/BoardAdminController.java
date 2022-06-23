package egovframework.admin.board.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/board")
public class BoardAdminController {

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
     * FAQ 관리 화면
     */
    @GetMapping(value = "/faq")
    public ModelAndView faqView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/board/faqView");
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


}