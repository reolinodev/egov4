package egovframework.admin.setting.web;

import egovframework.admin.setting.service.CodeGrpAdminService;
import egovframework.admin.setting.service.domain.CodeGrp;
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
@RequestMapping("/api/admin/codeGrp")
@RequiredArgsConstructor
public class CodeGrpAdminControllerAPI {

    private final CodeGrpAdminService codeGrpAdminService;

    @ApiOperation(value = "사용가능한 코드 그룹 리스트를 전체 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getCodeGrpList(
        @ApiParam(
            value = "search_str : 검색어 ,널허용\n"
                +   "use_yn : 사용여부 ,필수\n"
                +   "page_per : 페이지당 항목수 ,필수\n"
                +   "current_page : 현재 페이지, 필수\n"
        )
        @RequestBody CodeGrp codeGrp, HttpServletRequest httpServletRequest){
        Map <String,Object> responseMap = new HashMap<>();

        List<CodeGrp> list = codeGrpAdminService.getCodeGrpList(codeGrp);
        int listCount = codeGrpAdminService.getCodeGrpCount(codeGrp);

        String message = listCount+"건이 조회되었습니다.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);
        responseMap.put("total", listCount);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "코드 그룹을 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputCodeGrp(
        @ApiParam(
            value = "code_grp_nm : 코드 그룹 명, 필수값, 15자 \n"
                + "code_grp_val : 코드 그룹 값, 필수값, 10자 \n"
        )
//        @Validated(ValidationGroups.CodeGrpGroup1.class)
        @RequestBody CodeGrp codeGrp, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "Code group created.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        int count = codeGrpAdminService.checkCodeGrpVal(codeGrp);

        if(count > 0){
            message ="Duplicate Code value.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }else {
            int result = codeGrpAdminService.inputCodeGrp(codeGrp);

            if(result < 1){
                message ="Code group creation failed.";
                code = "fail";
                status = HttpStatus.BAD_REQUEST;
            }
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "코드 그룹을 상세 조회한다.")
    @GetMapping("/info/{code_grp_id}")
    public ResponseEntity <Map<String,Object>> getUserInfo(@PathVariable Integer code_grp_id, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();
        CodeGrp data = codeGrpAdminService.getCodeGrpInfo(code_grp_id);

        String message = "1건이 조회되었습니다.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", data);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "코드 그룹 데이터를 수정한다.")
    @PutMapping("/info/{code_grp_id}")
    public ResponseEntity<Map<String,Object>> updateCodeGrp(
        @ApiParam(
            value = "code_grp_id : 아이디 \n"
                + "code_grp_nm : 그룹 코드 명, 필수값, 15자\n"
                + "use_yn : 사용여부, 필수값\n"
        )
        @RequestBody CodeGrp codeGrp, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        int result = codeGrpAdminService.updateCodeGrp(codeGrp);

        String message = "Code group updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="Failed to modify code group.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }
}