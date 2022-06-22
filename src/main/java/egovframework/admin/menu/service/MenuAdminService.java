package egovframework.admin.menu.service;

import egovframework.admin.menu.service.domain.MenuEntity;
import java.util.List;

public interface MenuAdminService {

    List<MenuEntity> getMenuList(String authRole);

    List<MenuEntity> getParentMenu(MenuEntity menuEntity);

    MenuEntity getMenuInfo(int menuId);

    int inputMenu(MenuEntity menuEntity) throws Exception;

    int updateMenu(MenuEntity menuEntity) throws Exception;

    int deleteMenu(MenuEntity menuEntity) throws Exception;

    List<MenuEntity> getMenuListLv(MenuEntity menuEntity);

    MenuEntity getMainUrl(MenuEntity menuEntity);
}
