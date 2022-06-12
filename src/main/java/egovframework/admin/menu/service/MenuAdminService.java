package egovframework.admin.menu.service;

import egovframework.admin.menu.service.domain.MenuEntity;
import java.util.List;

public interface MenuAdminService {

    List<MenuEntity> getMenuList(MenuEntity menuEntity);

    MenuEntity getMenuInfo(int menuId);

    int inputMenu(MenuEntity menuEntity) throws Exception;


}
