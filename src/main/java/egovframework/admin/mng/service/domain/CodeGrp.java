package egovframework.admin.mng.service.domain;

import egovframework.common.domain.Param;
import egovframework.common.domain.ValidationGroups.CodeGrpCreateGroup;
import egovframework.common.domain.ValidationGroups.CodeGrpUpdateGroup;
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
@ApiModel(description = "코드 그룹")
public class CodeGrp extends Param {

    @ApiModelProperty(example = "코드 그룹 아이디")
    @NotEmpty(groups = { CodeGrpUpdateGroup.class }, message = "Please enter your code group ID.")
    public int code_grp_id;

    @ApiModelProperty(example = "코드 그룹 명")
    @NotEmpty(groups = { CodeGrpCreateGroup.class, CodeGrpUpdateGroup.class }, message = "Please enter the code group name.")
    @Size(groups = { CodeGrpCreateGroup.class, CodeGrpUpdateGroup.class },max=15, message = "Please enter up to 15 characters.")
    public String code_grp_nm;

    @NotEmpty(groups = { CodeGrpCreateGroup.class }, message = "Please enter the code group value.")
    @Size(groups = { CodeGrpCreateGroup.class }, max=10, message = "Please enter up to 10 characters.")
    @ApiModelProperty(example = "코드 그룹 값")
    public String code_grp_val;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "수정자")
    public int updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;
}
