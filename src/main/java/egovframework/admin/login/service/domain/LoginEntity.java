package egovframework.admin.login.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "로그인")
public class LoginEntity {

    @ApiModelProperty(example = "사용자 아이디")
    public int user_id;

    @ApiModelProperty(example = "권한 아이디")
    public int auth_id;

    @ApiModelProperty(example = "권한 명")
    public String auth_nm;

    @ApiModelProperty(example = "로그인 아이디")
    public String login_id;

    @ApiModelProperty(example = "이메일")
    public String email;

    @ApiModelProperty(example = "사용자 명")
    public String user_nm;

    @ApiModelProperty(example = "사용자 패스워드")
    public String user_pw;

    @ApiModelProperty(example = "로그인 디바이스")
    public String login_device;

    @ApiModelProperty(example = "디바이스 브라우자")
    public String device_browser;

    @ApiModelProperty(example = "마지막 로그인 시간")
    public String last_login_at;

}
