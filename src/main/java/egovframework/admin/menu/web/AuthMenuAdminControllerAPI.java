package egovframework.admin.menu.web;

import egovframework.admin.menu.service.AuthMenuAdminService;
import egovframework.admin.menu.service.domain.AuthMenuEntity;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/authMenu")
@RequiredArgsConstructor
public class AuthMenuAdminControllerAPI {

    private final AuthMenuAdminService authMenuAdminService;

    @ApiOperation(value = "권한별 메뉴의 리스트를 조회한다.")
    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> getAuthMenuList(@RequestBody AuthMenuEntity authMenuEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<AuthMenuEntity> list = authMenuAdminService.getAuthMenuList(authMenuEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap,  HttpStatus.OK);
    }

    @ApiOperation(value = "메뉴별 권한을 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputMenu(
        @ApiParam(
            value = "menu_id : 메뉴 아이디, 필수값 \n"
                +"updated_rows : 업데이트 된 로우데이터  \n"
        )
        @RequestBody AuthMenuEntity authMenuEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        int result = authMenuAdminService.inputAuthMenu(authMenuEntity);

        String message = "Permissions have been fixed.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        if(result < 1){
            message ="Edit failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

}