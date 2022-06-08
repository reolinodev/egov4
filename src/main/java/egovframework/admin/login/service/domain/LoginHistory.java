package egovframework.admin.login.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "로그인 이력")
public class LoginHistory {

    @ApiModelProperty(example = "사용자 아이디")
    public int user_id;

    @ApiModelProperty(example = "로그인 기기")
    public String login_device;

    @ApiModelProperty(example = "기기 브라우져")
    public String device_browser;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

}
