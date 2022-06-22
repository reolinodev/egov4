package egovframework.admin.pilot.web;

import egovframework.common.support.JsonUtils;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/pilot")
public class PilotAdminControllerAPI {

    @ApiOperation(value = "서울 행정구역 구 형태로 json 반환")
    @GetMapping("/json/seoul")
    public JSONObject getSeoulLv1Json() throws IOException, ParseException {
        return JsonUtils.getJsonSeoulLv1();
    }

    @ApiOperation(value = "서울 행정구역 동 형태로 json 반환")
    @GetMapping("/json/seoul/{map_key}")
    public JSONObject getSeoulLv2Json(@PathVariable Integer map_key) throws IOException, ParseException {
        return JsonUtils.getJsonSeoulLv2(map_key);
    }

    @ApiOperation(value = "서울 행정구역 구 형태로 주택통계 json 반환")
    @GetMapping("/json/house")
    public JSONObject getHouseLv1Json() throws IOException, ParseException {
        return JsonUtils.getJsonHouseLv1();
    }

    @ApiOperation(value = "서울 행정구역 동 형태로 주택통계 json 반환")
    @GetMapping("/json/house/{map_key}")
    public JSONObject getHouseLv2Json(@PathVariable Integer map_key) throws IOException, ParseException {
        return JsonUtils.getJsonHouseLv2(map_key);
    }
}