package egovframework.admin.user.service.domain;

import egovframework.common.domain.Param;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "권한")
public class Auth extends Param {

    @ApiModelProperty(example = "권한 아이디")
    public int auth_id;

    @ApiModelProperty(example = "권한 명")
//    @NotEmpty(groups = { AuthGroup1.class, AuthGroup2.class}, message = "Please enter Auth Name.")
//    @Size(groups = { AuthGroup1.class, AuthGroup2.class }, max=16, message = "Please enter up to 16 characters.")
    public String auth_nm;

    @ApiModelProperty(example = "권한 값")
//    @NotEmpty(groups = { AuthGroup1.class}, message = "Please enter Auth Value.")
//    @Size(groups = { AuthGroup1.class }, max=20, message = "Please enter up to 20 characters.")
    public String auth_val;

    @ApiModelProperty(example = "권한 구분")
//    @NotEmpty(groups = { AuthGroup1.class}, message = "Please enter Auth Role.")
    public String auth_role;

    @ApiModelProperty(example = "순서")
    public String ord;

    @ApiModelProperty(example = "비고")
    public String bigo;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "수정자")
    public String updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;
}
