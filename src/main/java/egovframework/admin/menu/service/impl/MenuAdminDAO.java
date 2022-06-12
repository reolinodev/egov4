package egovframework.admin.menu.service.impl;

import egovframework.admin.menu.service.domain.MenuEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("MenuAdminDAO")
public class MenuAdminDAO extends EgovAbstractMapper {

    public int save(MenuEntity menuEntity) throws Exception {
        return insert("MenuAdminDAO.save", menuEntity);
    }

    public List<MenuEntity> findAllMenu(MenuEntity menuEntity) {
        return (List<MenuEntity>) list("MenuAdminDAO.findAllMenu", menuEntity);
    }

    public MenuEntity findByMenuId(int menuId) {
        return selectOne("MenuAdminDAO.findByMenuId", menuId);
    }
}
