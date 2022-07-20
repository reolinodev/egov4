package egovframework.admin.menu.service.impl;

import egovframework.admin.menu.service.domain.AuthMenu;
import egovframework.admin.menu.service.domain.AuthMenuEntity;
import java.util.List;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("AuthMenuAdminDAO")
public class AuthMenuAdminDAO extends EgovAbstractMapper {

    public List<AuthMenuEntity> findByAuthRoleAndMenuId(AuthMenuEntity authMenuEntity) {
        return (List<AuthMenuEntity>) list("AuthMenuAdminDAO.findByAuthRoleAndMenuId", authMenuEntity);
    }

    public int save(AuthMenu authMenu) throws Exception {
        return update("AuthMenuAdminDAO.save", authMenu);
    }

    public int deleteByMenuId(int menuId) throws Exception {
        return delete("AuthMenuAdminDAO.deleteByMenuId", menuId);
    }

}
