package egovframework.admin.menu.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "메뉴")
public class Menu {

    @ApiModelProperty(example = "메뉴 아이디")
    public int menu_id;

    @ApiModelProperty(example = "메뉴 명")
    public String menu_nm;

    @ApiModelProperty(example = "메뉴 레벨")
    public int menu_lv;

    @ApiModelProperty(example = "부모 아이디")
    public int parent_id;

    @ApiModelProperty(example = "url")
    public String menu_url;

    @ApiModelProperty(example = "메뉴 타입")
    public String menu_type;

    @ApiModelProperty(example = "순서")
    public int ord;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "수정자")
    public String updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;

    @ApiModelProperty(example = "권한구분")
    public String auth_role;

    @ApiModelProperty(example = "메인화면 여부")
    public String main_yn;
}
