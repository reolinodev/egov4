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
@ApiModel(description = "사용자 권한")
public class UserAuth extends Param {

    @ApiModelProperty(example = "사용자 아이디")
    public int user_id;

    @ApiModelProperty(example = "권한 아이디")
    public int auth_id;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "수정자")
    public int updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;
}
