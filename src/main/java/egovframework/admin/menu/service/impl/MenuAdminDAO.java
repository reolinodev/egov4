package egovframework.admin.menu.service.impl;

import egovframework.admin.menu.service.domain.MenuEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("MenuAdminDAO")
public class MenuAdminDAO extends EgovAbstractMapper {

    public List<MenuEntity> findAllMenu(String authRole) {
        return (List<MenuEntity>) list("MenuAdminDAO.findAllMenu", authRole);
    }

    public List<MenuEntity> findByAuthRoleAndMenuLv1(MenuEntity menuEntity) {
        return (List<MenuEntity>) list("MenuAdminDAO.findByAuthRoleAndMenuLv1", menuEntity);
    }

    public int updateMainYnAllN(MenuEntity menuEntity) throws Exception {
        return update("MenuAdminDAO.updateMainYnAllN", menuEntity);
    }

    public int save(MenuEntity menuEntity) throws Exception {
        return insert("MenuAdminDAO.save", menuEntity);
    }


    public MenuEntity findByMenuId(int menuId) {
        return selectOne("MenuAdminDAO.findByMenuId", menuId);
    }

    public int updateMenu(MenuEntity menuEntity) throws Exception {
        return update("MenuAdminDAO.updateMenu", menuEntity);
    }

    public int countByChild(int menuId) {
        return selectOne("MenuAdminDAO.countByChild", menuId);
    }

    public int deleteByMenuId(int menuId) throws Exception {
        return delete("MenuAdminDAO.deleteByMenuId", menuId);
    }

    public List<MenuEntity> findByParentId(int menuId) {
        return (List<MenuEntity>) list("MenuAdminDAO.findByParentId", menuId);
    }

}
