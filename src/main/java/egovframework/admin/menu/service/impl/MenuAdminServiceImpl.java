package egovframework.admin.menu.service.impl;

import egovframework.admin.menu.service.MenuAdminService;
import egovframework.admin.menu.service.domain.MenuEntity;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("MenuAdminService")
public class MenuAdminServiceImpl extends EgovAbstractServiceImpl implements MenuAdminService {
	
    @Resource(name = "MenuAdminDAO")
    private MenuAdminDAO menuAdminDAO;

    public List<MenuEntity> getMenuList(String authRole) {
        return menuAdminDAO.findAllMenu(authRole);
    }

    public List<MenuEntity> getParentMenu(MenuEntity menuEntity) {
        return menuAdminDAO.findByAuthRoleAndMenuLv1(menuEntity);
    }

    public int inputMenu(MenuEntity menuEntity) throws Exception {
        if("Y".equals(menuEntity.main_yn)){
            menuAdminDAO.updateMainYnAllN(menuEntity);
        }

        return  menuAdminDAO.save(menuEntity);
    }

    public MenuEntity getMenuInfo(int menuId) {
        return menuAdminDAO.findByMenuId(menuId);
    }


    public int updateMenu(MenuEntity menuEntity) throws Exception {
        if("Y".equals(menuEntity.main_yn)){
            menuAdminDAO.updateMainYnAllN(menuEntity);
        }

        return  menuAdminDAO.updateMenu(menuEntity);
    }

    public int deleteMenu(MenuEntity menuEntity) throws Exception {
        int menuId = menuEntity.menu_id;

        if(menuEntity.menu_lv == 1){
           int count = menuAdminDAO.countByChild(menuId);
           if(count > 0) {
               return -1;
           }
        }

        return  menuAdminDAO.deleteByMenuId(menuId);
    }

    public List<MenuEntity> getMenuListLv(MenuEntity menuEntity) {
        return menuAdminDAO.findByMenuLvAndAuthId(menuEntity);
    }

    public MenuEntity getMainUrl(MenuEntity menuEntity) {
        return menuAdminDAO.findByMainUrl(menuEntity);
    }
}
