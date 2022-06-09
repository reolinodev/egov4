package egovframework.common.support;

import egovframework.admin.menu.service.domain.MenuEntity;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ModelAndView;

public class JsonUtils {


    public static ModelAndView getJsonMenu() throws IOException, ParseException {
        ModelAndView mav = new ModelAndView();
        List<MenuEntity> menuLv1List = new ArrayList<>();
        List<MenuEntity> menuLv2List = new ArrayList<>();
        MenuEntity firstUrl = new MenuEntity();

        JSONObject json = convertJsonFile("json/menu.json");
        JSONObject defaultFirstUrl = (JSONObject) json.get("defaultFirstUrl");
        ArrayList defaultMenu1List = (ArrayList) json.get("defaultMenu1List");
        ArrayList defaultMenu2List = (ArrayList) json.get("defaultMenu2List");

        for (Object o1 : defaultMenu1List) {
            JSONObject obj = (JSONObject) o1;
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setMenu_id(Integer.parseInt(obj.get("menu_id").toString()));
            menuEntity.setMenu_nm(obj.get("menu_nm").toString());
            menuEntity.setMenu_lv(Integer.parseInt(obj.get("menu_lv").toString()));
            menuEntity.setParent_id(Integer.parseInt(obj.get("parent_id").toString()));
            menuEntity.setMenu_url(obj.get("menu_url").toString());
            menuEntity.setParent_nm(obj.get("parent_nm").toString());

            menuLv1List.add(menuEntity);
        }

        for (Object o2 : defaultMenu2List) {
            JSONObject obj = (JSONObject) o2;
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setMenu_id(Integer.parseInt(obj.get("menu_id").toString()));
            menuEntity.setMenu_nm(obj.get("menu_nm").toString());
            menuEntity.setMenu_lv(Integer.parseInt(obj.get("menu_lv").toString()));
            menuEntity.setParent_id(Integer.parseInt(obj.get("parent_id").toString()));
            menuEntity.setMenu_url(obj.get("menu_url").toString());
            menuEntity.setParent_nm(obj.get("parent_nm").toString());

            menuLv2List.add(menuEntity);
        }

        firstUrl.setMenu_id(Integer.parseInt(defaultFirstUrl.get("menu_id").toString()));
        firstUrl.setMenu_nm((defaultFirstUrl.get("menu_nm").toString()));
        firstUrl.setMenu_lv(Integer.parseInt(defaultFirstUrl.get("menu_lv").toString()));
        firstUrl.setParent_id(Integer.parseInt(defaultFirstUrl.get("parent_id").toString()));
        firstUrl.setMenu_url(defaultFirstUrl.get("menu_url").toString());
        firstUrl.setParent_nm( defaultFirstUrl.get("parent_nm").toString());

        mav.addObject("menuLv1List",menuLv1List);
        mav.addObject("menuLv2List",menuLv2List);
        mav.addObject("firstUrl",firstUrl);

        return mav;
    }

    private static JSONObject convertJsonFile(String url) throws IOException, ParseException {
        ClassPathResource resource = new ClassPathResource(url);
        JSONObject json = (JSONObject) new JSONParser().parse(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        return json;
    }
}
