package egovframework.admin.board.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "FAQ 엔티티")
public class FaqEntity extends Faq {

    @ApiModelProperty(example = "순서")
    public int rnum;

    @ApiModelProperty(example = "게시판 명")
    public String board_title;

    @ApiModelProperty(example = "수정자")
    public String updated_nm;

    @ApiModelProperty(example = "사용여부")
    public String use_yn_nm;
}