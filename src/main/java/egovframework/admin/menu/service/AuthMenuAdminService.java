package egovframework.admin.menu.service;

import egovframework.admin.menu.service.domain.AuthMenuEntity;
import java.util.List;

public interface AuthMenuAdminService {

    List<AuthMenuEntity> getAuthMenuList(AuthMenuEntity authMenuEntity);

    int inputAuthMenu(AuthMenuEntity authMenuEntity) throws Exception;

    int deleteAuthMenu(int menuId) throws Exception;
}
