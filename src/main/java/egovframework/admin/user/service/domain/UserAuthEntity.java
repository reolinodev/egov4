package egovframework.admin.user.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "사용자 권한")
public class UserAuthEntity extends UserAuth {

    @ApiModelProperty(example = "순서")
    public int rnum;

    @ApiModelProperty(example = "로그인 아이디")
    public String login_id;

    @ApiModelProperty(example = "이메일")
    public String email;

    @ApiModelProperty(example = "이름")
    public String user_nm;

    @ApiModelProperty(example = "권한 구분")
    public String auth_role;

    @ApiModelProperty(example = "권한 구분명")
    public String auth_role_nm;

    @ApiModelProperty(example = "권한명")
    public String auth_nm;

    @ApiModelProperty(example = "이름 항목")
    public int[] user_arr;
}
