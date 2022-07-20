package egovframework.admin.board.web;

import egovframework.admin.board.service.FaqAdminService;
import egovframework.admin.board.service.domain.FaqEntity;
import egovframework.common.domain.Header;
import egovframework.common.support.ResponseUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/faq")
@RequiredArgsConstructor
public class FaqAdminControllerAPI {

    private final FaqAdminService faqAdminService;

    @ApiOperation(value = "FAQ를 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputFaq(
        @ApiParam(
            value = "title : 제목, 필수 \n"
                    +"board_id : 게시판 아이디, 필수  \n"
                    +"main_text : 본문\n"
        )
        @RequestBody FaqEntity faqEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        int result = faqAdminService.inputFaq(faqEntity);

        String message = "Faq has been created.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        if(result < 1){
            message ="Faq creation failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "FAQ를 전체 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getFaqList(
        @ApiParam(
            value = "search_str : 제목 \n"
                    +"page_per : 페이지당 항목 수, 필수 \n"
                    +"current_page : 현재 페이지, 필수 \n"
                    +"board_id : 게시판 아이디 \n"
                    +"use_yn : 사용 여부 \n"
        )
        @RequestBody FaqEntity faqEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<FaqEntity> list = faqAdminService.getFaqList(faqEntity);
        int listCount = faqAdminService.getFaqCount(faqEntity);

        String message = listCount+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);
        responseMap.put("total", listCount);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "FAQ를 수정한다.")
    @PutMapping("/{faq_id}")
    public ResponseEntity<Map<String,Object>> updateFaq(@PathVariable Integer faq_id,
        @ApiParam(
            value = "title : 제목, 필수 \n"
                +"board_id : 게시판 아이디, 필수  \n"
                +"main_text : 본문\n"
        )
        @RequestBody FaqEntity faqEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();
        faqEntity.faq_id = faq_id;
        int result = faqAdminService.updateFaq(faqEntity);

        String message = "Faq has been updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="Faq update failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }


}