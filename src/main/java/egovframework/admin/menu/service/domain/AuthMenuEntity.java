package egovframework.admin.menu.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "권한별 메뉴 엔티티")
public class AuthMenuEntity extends AuthMenu {

    @ApiModelProperty(example = "권한 명")
    public String auth_nm;

    @ApiModelProperty(example = "권한 구분")
    public String auth_role;

    @ApiModelProperty(example = "수정자 명")
    public String updated_nm;

    @ApiModelProperty(example = "수정된 코드 Row")
    public AuthMenu[] updated_rows;
}