package egovframework.admin.board.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "게시글 엔티티")
public class PostEntity extends Post {

    @ApiModelProperty(example = "순서")
    public int rnum;

    @ApiModelProperty(example = "수정자")
    public String updated_nm;

    @ApiModelProperty(example = "게시판 유형")
    public String board_type_nm;

    @ApiModelProperty(example = "게시판 명")
    public String board_title;

    @ApiModelProperty(example = "사용여부")
    public String use_yn_nm;
}