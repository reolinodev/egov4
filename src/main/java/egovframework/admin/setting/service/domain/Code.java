package egovframework.admin.setting.service.domain;


import egovframework.common.domain.Param;
import egovframework.common.domain.ValidationGroups.CodeCreateGroup;
import egovframework.common.domain.ValidationGroups.CodeUpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "코드")
public class Code extends Param {

    @ApiModelProperty(example = "코드 아이디")
    public int code_id;

    @ApiModelProperty(example = "코드 그룹 아이디")
    public int code_grp_id;

    @NotEmpty(groups = { CodeCreateGroup.class, CodeUpdateGroup.class }, message = "Please enter code name.")
    @Size(groups = { CodeCreateGroup.class, CodeUpdateGroup.class }, max=15, message = "Please enter up to 15 characters.")
    @ApiModelProperty(example = "코드 명")
    public String code_nm;

    @NotEmpty(groups = { CodeCreateGroup.class }, message = "Please enter code value.")
    @Size(groups = { CodeCreateGroup.class },max=10, message = "Please enter up to 10 characters.")
    @ApiModelProperty(example = "코드 값")
    public String code_val;

    @Size(groups = { CodeCreateGroup.class, CodeUpdateGroup.class }, max=165, message = "Please enter up to 165 characters.")
    @ApiModelProperty(example = "비고")
    public String bigo;

    @Size(groups = { CodeCreateGroup.class, CodeUpdateGroup.class }, max=10, message = "Please enter up to 10 characters.")
    @ApiModelProperty(example = "순서")
    public String ord;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "수정자")
    public int updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;
}
