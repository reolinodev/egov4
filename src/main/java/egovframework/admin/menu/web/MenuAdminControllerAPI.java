package egovframework.admin.menu.web;

import egovframework.admin.menu.service.AuthMenuAdminService;
import egovframework.admin.menu.service.MenuAdminService;
import egovframework.admin.menu.service.domain.MenuEntity;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/menu")
@RequiredArgsConstructor
public class MenuAdminControllerAPI {

    private final MenuAdminService menuAdminService;
    private final AuthMenuAdminService authMenuAdminService;

    @ApiOperation(value = "트리 구조로 메뉴리스트를 가져온다.")
    @GetMapping("/{auth_role}")
    public ResponseEntity<Map<String,Object>> getMenuList(@PathVariable String auth_role, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<MenuEntity> list = menuAdminService.getMenuList(auth_role);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap,  HttpStatus.OK);
    }

    @ApiOperation(value = "상위의 메뉴들을 조회한다.")
    @PostMapping("/parent")
    public ResponseEntity<Map<String,Object>> getParentMenu(@RequestBody MenuEntity menuEntity, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();

        List<MenuEntity> list = menuAdminService.getParentMenu(menuEntity);

        String message = list.size()+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", list);

        return new ResponseEntity<> (responseMap,  HttpStatus.OK);
    }

    @ApiOperation(value = "메뉴를 입력한다.")
    @PutMapping("/")
    public ResponseEntity<Map<String,Object>> inputMenu(
        @ApiParam(
            value = "menu_nm : 메뉴명, 필수값, 30자 \n"
                +"menu_lv : 레벨, 필수값  \n"
                +"parent_id : 상위메뉴, 필수값, ROOT일 경우는 0 \n"
                +"menu_url : 메뉴 도메인, 200자,영문만 \n"
                +"ord : 숞서, 숫자만\n"
                +"menu_type : 메뉴의 유형, 10자이내 영문만 \n"
                +"use_yn : 사용여부, 필수값, (Y or N) \n"
                +"auth_role : 권한여부, 필수값\n"
                +"main_yn : 메인여부, 필수값, (Y or N) \n"
        )
//        @Validated(ValidationGroups.UserCreateGroup.class)
        @RequestBody MenuEntity menuEntity, HttpServletRequest httpServletRequest) throws Exception {
        Map <String,Object> responseMap = new HashMap<>();

        int result = menuAdminService.inputMenu(menuEntity);

        String message = "Menu has been created.";
        String code = "ok";
        HttpStatus status = HttpStatus.CREATED;

        if(result < 1){
            message ="Menu creation failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "메뉴를 상세 조회한다.")
    @GetMapping("/info/{menu_id}")
    public ResponseEntity <Map<String,Object>> getMenuInfo(@PathVariable Integer menu_id, HttpServletRequest httpServletRequest) {
        Map <String,Object> responseMap = new HashMap<>();
        MenuEntity data = menuAdminService.getMenuInfo(menu_id);
        int count = 0;
        if (!"".equals(data.menu_nm)) count= 1;

        String message = count+" item has been viewed.";
        String code = "ok";
        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);

        responseMap.put("header", header);
        responseMap.put("data", data);

        return new ResponseEntity<> (responseMap, HttpStatus.OK);
    }


    @ApiOperation(value = "메뉴 정보를 수정한다.")
    @PutMapping("/update")
    public ResponseEntity<Map<String,Object>> updateMenu(
        @ApiParam(
            value = "menu_nm : 메뉴명, 필수값, 30자 \n"
                +"menu_url : url, 필수값, 한글 제외 \n"
                +"ord : 순서, 숫자\n"
                +"menu_type : 메뉴의 타입, url or board) \n"
                +"use_yn : 사용 여부, 필수값, Y OR N \n"
                +"main_yn : 메인 여부, 필수값, Y OR N \n"
                +"menu_id : 메뉴 아이디, 필수값 \n"
        )
//        @Validated(ValidationGroups.UserUpdateGroup.class)
        @RequestBody MenuEntity menuEntity, HttpServletRequest httpServletRequest) throws Exception {

        Map <String,Object> responseMap = new HashMap<>();
        int result = menuAdminService.updateMenu(menuEntity);

        String message = "Menu has been updated.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result < 1){
            message ="User update failed.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }

    @ApiOperation(value = "메뉴를 삭제한다.")
    @DeleteMapping("/")
    public ResponseEntity<Map<String,Object>> deleteMenu(
        @ApiParam(
            value = "menu_id : 메뉴 아이디, 필수값 \n"
                +"menu_lv : 메뉴 레벨, 필수값 \n"
        )
        @RequestBody MenuEntity menuEntity, HttpServletRequest httpServletRequest) throws Exception {

        Map <String,Object> responseMap = new HashMap<>();
        authMenuAdminService.deleteAuthMenu(menuEntity.menu_id);
        int result = menuAdminService.deleteMenu(menuEntity);

        String message = "Menu has been deleted.";
        String code = "ok";
        HttpStatus status = HttpStatus.OK;

        if(result == 0){
            message ="Failed to delete menu.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }else if(result == -1){
            message ="A sub-menu exists.";
            code = "fail";
            status = HttpStatus.BAD_REQUEST;
        }

        Header header = ResponseUtils.setHeader(message, code, httpServletRequest);
        responseMap.put("header", header);

        return new ResponseEntity<>(responseMap, status);
    }
}