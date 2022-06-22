package egovframework.admin.user.web;

import egovframework.admin.user.service.AuthAdminService;
import egovframework.admin.user.service.domain.AuthEntity;
import egovframework.common.domain.Header;
import egovframework.common.support.ResponseUtils;
import io.swagger.annotations.Api;
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
@Api(value = "auth controller Api")
@RequestMapping("/api/admin/auth")
@RequiredArgsConstructor
public class AuthAdminControllerAPI {
    private final AuthAdminService authAdminService;

    @ApiOperation(value = "권한을 전체 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getAuthList(
        @ApiParam(
            value = "auth_role : 권한구분 , 널허용 \n"
                +   "use_yn : 사용여부 ,널허용")
        @RequestBody AuthEntity authEntity, HttpServletRequest httpServletRequest){
        Map <String,Object> responseMap = new HashMap<>();

        List<AuthEntity> list = authAdminService.getAuthList(authEntity);
        int listCount = authAdminService.getAuthCount(authEntity);

        String message = listCount+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);
        responseMap.put("total", listCount);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "권한을 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputAuth(
        @ApiParam(
            value = "auth_nm : 아이디, 필수값, 16자 \n"
                +"auth_val : 권한 값, 필수값, 20자 (영문만)  \n"
                +"auth_role : 권한 구분, 필수값 \n"
                +"ord : 권한 순서\n"
                +"bigo : 비고 \n"
        )
//        @Validated(ValidationGroups.AuthGroup1.class)
        @RequestBody AuthEntity authEntity, HttpServletRequest httpServletRequest)
        throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "Auth has been created.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        int count = authAdminService.checkAuthVal(authEntity);

        if(count > 0){
            message ="Duplicate Auth value.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }else {
            int result = authAdminService.inputAuth(authEntity);

            if(result < 1){
                message ="Auth creation failed.";
                code = "fail";
                status = HttpStatus.BAD_REQUEST;
            }
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "권한 정보를 상세 조회한다.")
    @GetMapping("/info/{auth_id}")
    public ResponseEntity <Map<String,Object>> getAuthInfo(@PathVariable Integer auth_id, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();
        AuthEntity data = authAdminService.getAuthInfo(auth_id);
        int count = 0;
        if (!"".equals(data.auth_id)) count= 1;

        String message = count+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", data);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "권한정보를 수정한다.")
    @PutMapping("/info/{auth_id}")
    public ResponseEntity<Map<String,Object>> updateAuth(
//        @Validated(ValidationGroups.AuthGroup2.class)
        @RequestBody AuthEntity authEntity,
        HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();
        int result = authAdminService.updateAuth(authEntity);

        String message = "Auth has been updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="Auth update failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "권한 구분에 해당되는 권한의 리스트를 조회한다.")
    @PostMapping("/role")
    public ResponseEntity <Map<String,Object>> getAuthRoleList(@RequestBody AuthEntity authEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();
        List<AuthEntity> list = authAdminService.getAuthRoleList(authEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

    @ApiOperation(value = "내가 가진 권한을 가져온다.")
    @PostMapping("/mine")
    public ResponseEntity <Map<String,Object>> getMyAuthList(@RequestBody AuthEntity authEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();
        List<AuthEntity> list = authAdminService.getMyAuthList(authEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }

}
