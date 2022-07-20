package egovframework.admin.board.web;

import egovframework.admin.board.service.BoardAdminService;
import egovframework.admin.board.service.domain.BoardEntity;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/board")
@RequiredArgsConstructor
public class BoardAdminControllerAPI {

    private final BoardAdminService boardAdminService;

    @ApiOperation(value = "게시판을 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputBoard(
        @ApiParam(
            value = "title : 제목, 필수 \n"
                    +"bigo : 메모, 15자  \n"
                    +"board_type : 게시판 유형, 필수\n"
        )
        @RequestBody BoardEntity boardEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        int result = boardAdminService.inputBoard(boardEntity);

        String message = "Board has been created.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        if(result < 1){
            message ="Board creation failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "게시판을 전체 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getBoardList(
        @ApiParam(
            value = "search_str : 이름 / 이메일/ 아이디 \n"
                    +"page_per : 페이지당 항목 수, 필수 \n"
                    +"current_page : 현재 페이지, 필수 \n"
                    +"board_type : 게시판 유형 \n"
                    +"use_yn : 사용 여부 \n"
        )
        @RequestBody BoardEntity boardEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<BoardEntity> list = boardAdminService.getBoardList(boardEntity);
        int listCount = boardAdminService.getBoardCount(boardEntity);

        String message = listCount+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);
        responseMap.put("total", listCount);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }


    @ApiOperation(value = "게시판을 상세 조회한다.")
    @GetMapping("/info/{board_id}")
    public ResponseEntity <Map<String,Object>> getBoardInfo(@PathVariable Integer board_id, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();
        BoardEntity data = boardAdminService.getBoardInfo(board_id);
        int count = 0;
        if (!"".equals(data.title)) count= 1;

        String message = count+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", data);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판을 수정한다.")
    @PutMapping("/{board_id}")
    public ResponseEntity<Map<String,Object>> updateBoard(@PathVariable Integer board_id, @RequestBody BoardEntity boardEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();
        boardEntity.board_id = board_id;
        int result = boardAdminService.updateBoard(boardEntity);

        String message = "Board has been updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="Board update failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "사용가능한 게시판 목록을 조회한다. FAQ, QNA 제외")
    @PostMapping("/select/list")
    public ResponseEntity<Map<String,Object>> getAvailableBoardList(@RequestBody BoardEntity boardEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<BoardEntity> list = boardAdminService.getAvailableBoardList(boardEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap,  HttpStatus.OK);
    }

    @ApiOperation(value = "사용가능한 FAQ 목록을 조회한다")
    @PostMapping("/select/faq")
    public ResponseEntity<Map<String,Object>> getAvailableFaqList(@RequestBody BoardEntity boardEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<BoardEntity> list = boardAdminService.getAvailableFaqList(boardEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap,  HttpStatus.OK);
    }

    @ApiOperation(value = "사용가능한 QNA 목록을 조회한다.")
    @PostMapping("/select/qna")
    public ResponseEntity<Map<String,Object>> getAvailableQnaList(@RequestBody BoardEntity boardEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<BoardEntity> list = boardAdminService.getAvailableQnaList(boardEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap,  HttpStatus.OK);
    }
}