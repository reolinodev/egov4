package egovframework.admin.board.web;

import egovframework.admin.board.service.QnaAdminService;
import egovframework.admin.board.service.domain.QnaEntity;
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
@RequestMapping("/api/admin/qna")
@RequiredArgsConstructor
public class QnaAdminControllerAPI {

    private final QnaAdminService qnaAdminService;
    
    @ApiOperation(value = "Q&A를 전체 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getQnaList(
        @ApiParam(
            value = "search_str : 제목, 작성자 \n"
                    +"page_per : 페이지당 항목 수, 필수 \n"
                    +"current_page : 현재 페이지, 필수 \n"
                    +"board_id : 게시판 아이디 \n"
                    +"start_date : 시작일 \n"
                    +"end_date : 종료일 \n"
                    +"qna_type : 문의유형 \n"
                    +"response_yn : 응답유형 \n"
                    +"use_yn : 사용 여부 \n"
        )
        @RequestBody QnaEntity qnaEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<QnaEntity> list = qnaAdminService.getQnaList(qnaEntity);
        int listCount = qnaAdminService.getQnaCount(qnaEntity);

        String message = listCount+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);
        responseMap.put("total", listCount);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글을 수정한다.")
    @PutMapping("/{qna_id}")
    public ResponseEntity<Map<String,Object>> updatePost(@PathVariable Integer qna_id, @RequestBody QnaEntity qnaEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();
        qnaEntity.qna_id = qna_id;
        int result = qnaAdminService.updateQna(qnaEntity);

        String message = "Qna has been updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="Qna update failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

}