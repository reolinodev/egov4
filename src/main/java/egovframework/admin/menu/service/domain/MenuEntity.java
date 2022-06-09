package egovframework.admin.menu.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "메뉴 엔티티")
public class MenuEntity extends Menu {

    @ApiModelProperty(example = "부모 메뉴명")
    public String parent_nm;

}