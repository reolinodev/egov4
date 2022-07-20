package egovframework.admin.board.service.domain;

import egovframework.common.domain.Param;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "게시글")
public class Post extends Param {

    @ApiModelProperty(example = "게시글 아이디")
    public int post_id;

    @ApiModelProperty(example = "게시판 아이디")
    public int board_id;

    @ApiModelProperty(example = "제목")
    public String title;

    @ApiModelProperty(example = "본문")
    public String main_text;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "수정자")
    public int updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;

    @ApiModelProperty(example = "조회수")
    public int post_cnt;

    @ApiModelProperty(example = "첨부파일 그룹 아이디")
    public int attach_grp_id;
}

