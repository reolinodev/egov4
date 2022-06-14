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

    public MenuEntity getMenuInfo(int menuId) {
        return menuAdminDAO.findByMenuId(menuId);
    }

    public int inputMenu(MenuEntity menuEntity) throws Exception {
        //todo 메인여부 로직 넣기, 업데이트 역시 동일한 로직
        return  menuAdminDAO.save(menuEntity);
    }

    public int updateMenu(MenuEntity menuEntity) throws Exception {
        //todo 메인여부 로직 넣기, 업데이트 역시 동일한 로직
        return  menuAdminDAO.updateMenu(menuEntity);
    }
}
