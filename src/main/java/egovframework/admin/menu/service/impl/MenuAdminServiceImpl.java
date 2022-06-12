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

    public List<MenuEntity> getMenuList(MenuEntity menuEntity) {
        return menuAdminDAO.findAllMenu(menuEntity);
    }

    public MenuEntity getMenuInfo(int menuId) {
        return menuAdminDAO.findByMenuId(menuId);
    }

    public int inputMenu(MenuEntity menuEntity) throws Exception {
        return  menuAdminDAO.save(menuEntity);
    }
}
