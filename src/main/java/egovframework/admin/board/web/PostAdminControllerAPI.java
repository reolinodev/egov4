package egovframework.admin.board.web;

import egovframework.admin.board.service.PostAdminService;
import egovframework.admin.board.service.domain.PostEntity;
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
@RequestMapping("/api/admin/post")
@RequiredArgsConstructor
public class PostAdminControllerAPI {

    private final PostAdminService postAdminService;

    @ApiOperation(value = "게시글을 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputPost(
        @ApiParam(
            value = "title : 제목, 필수 \n"
                    +"board_id : 게시판 아이디, 필수  \n"
                    +"main_text : 본문\n"
        )
        @RequestBody PostEntity postEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        int result = postAdminService.inputPost(postEntity);

        String message = "Post has been created.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        if(result < 1){
            message ="Post creation failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "게시글을 전체 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getPostList(
        @ApiParam(
            value = "search_str : 제목 \n"
                    +"page_per : 페이지당 항목 수, 필수 \n"
                    +"current_page : 현재 페이지, 필수 \n"
                    +"board_id : 게시판 아이디 \n"
                    +"use_yn : 사용 여부 \n"
        )
        @RequestBody PostEntity postEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<PostEntity> list = postAdminService.getPostList(postEntity);
        int listCount = postAdminService.getPostCount(postEntity);

        String message = listCount+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);
        responseMap.put("total", listCount);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글을 수정한다.")
    @PutMapping("/{post_id}")
    public ResponseEntity<Map<String,Object>> updatePost(@PathVariable Integer post_id, @RequestBody PostEntity postEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();
        postEntity.post_id = post_id;
        int result = postAdminService.updatePost(postEntity);

        String message = "Post has been updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="Post update failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }


}