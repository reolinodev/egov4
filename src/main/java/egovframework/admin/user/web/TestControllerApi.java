package egovframework.admin.user.web;

import egovframework.admin.user.service.domain.UserEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestControllerApi {

    //Test라는 이름으로 실제 코드를 작성해보세요.

    //1. 아이디가 존재하는 지 체크를 하는 api를 만드세요.
    @GetMapping("/test/{login_id}")
    public Map<String,Object> checkLoginId(@PathVariable String login_id) {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "아이디가 사용가능합니다.";

        responseMap.put("data", message);

        return responseMap;
    }

    //2. 실제 사용자를 넣어 보세요.
    @PostMapping("/test/input")
    public Map<String,Object> inputUser (@RequestBody UserEntity userEntity) {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "아이디가 존재합니다." ;

        responseMap.put("data", message);

        return responseMap;
    }

    //3. 실제 사용자를 검색어를 넣어서 조회해 보세요.
    @PostMapping("/test/list")
    public Map<String,Object> listUser (@RequestBody UserEntity userEntity) {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "아이디가 존재합니다." ;
        List<UserEntity> list = new ArrayList<>();

        responseMap.put("data", message);
        responseMap.put("list", list);

        return responseMap;
    }

    //3. 사용자의 정보를 수정해보세요.
    @PostMapping("/test/update")
    public Map<String,Object> updateUser (@RequestBody UserEntity userEntity) {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "아이디가 수정되었습니다.." ;

        responseMap.put("data", message);

        return responseMap;
    }

    //4. 아이디를 삭제하세요
    @GetMapping("/test/delete/{user_id}")
    public Map<String,Object> deleteUser(@PathVariable int user_id) {
        Map <String,Object> responseMap = new HashMap<>();

        String message = "아이디가 삭제되었습니다";

        responseMap.put("data", message);

        return responseMap;
    }


}
