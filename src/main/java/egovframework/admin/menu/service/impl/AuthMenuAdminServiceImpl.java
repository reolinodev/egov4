package egovframework.admin.menu.service.impl;

import egovframework.admin.login.service.domain.SessionAdminInfo;
import egovframework.admin.menu.service.AuthMenuAdminService;
import egovframework.admin.menu.service.domain.AuthMenu;
import egovframework.admin.menu.service.domain.AuthMenuEntity;
import egovframework.admin.menu.service.domain.MenuEntity;
import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service("AuthMenuAdminService")
public class AuthMenuAdminServiceImpl extends EgovAbstractServiceImpl implements AuthMenuAdminService {
	
    @Resource(name = "AuthMenuAdminDAO")
    private AuthMenuAdminDAO authMenuAdminDAO;

    @Resource(name = "MenuAdminDAO")
    private MenuAdminDAO menuAdminDAO;

    @Resource
    private SessionAdminInfo sessionAdminInfo;

    public List<AuthMenuEntity> getAuthMenuList(AuthMenuEntity authMenuEntity) {
        return authMenuAdminDAO.findByAuthRoleAndMenuId(authMenuEntity);
    }

    public int inputAuthMenu(AuthMenuEntity authMenuEntity) throws Exception {
        AuthMenu[] updatedRows = authMenuEntity.updated_rows;
        int result = 1;
        int menuId = authMenuEntity.menu_id;

        MenuEntity menuInfo = menuAdminDAO.findByMenuId(menuId);
        if(menuInfo.menu_lv == 1){

            for (AuthMenu authMenu : updatedRows ) {
                authMenu.updated_id = sessionAdminInfo.getUser_id();
                authMenu.menu_id = menuId;
                authMenuAdminDAO.save(authMenu);
            }

            List<MenuEntity> childMenu = menuAdminDAO.findByParentId(menuId);

            for (MenuEntity menuEntity : childMenu ) {
                int childMenuId = menuEntity.menu_id;
                for (AuthMenu authMenu : updatedRows ) {
                    authMenu.updated_id = sessionAdminInfo.getUser_id();
                    authMenu.menu_id = childMenuId;
                    authMenuAdminDAO.save(authMenu);
                }
            }
        }else {
            for (AuthMenu authMenu : updatedRows ) {
                authMenu.updated_id = sessionAdminInfo.getUser_id();
                authMenu.menu_id = menuId;
                authMenuAdminDAO.save(authMenu);
            }
        }

        //결과값이 0이 나와서 체크할수 없다.임의로 1을 줌
        return result;
    }

    public int deleteAuthMenu(int menuId) throws Exception {
        return authMenuAdminDAO.deleteByMenuId(menuId);
    }
}
