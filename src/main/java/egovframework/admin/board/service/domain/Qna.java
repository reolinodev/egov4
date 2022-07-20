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
@ApiModel(description = "QNA")
public class Qna extends Param {

    @ApiModelProperty(example = "QNA 아이디")
    public int qna_id;

    @ApiModelProperty(example = "게시판 아이디")
    public int board_id;

    @ApiModelProperty(example = "제목")
    public String title;

    @ApiModelProperty(example = "본문")
    public String main_text;

    @ApiModelProperty(example = "질의")
    public String questions;

    @ApiModelProperty(example = "문의유형")
    public String qna_type;

    @ApiModelProperty(example = "비밀글 여부")
    public String hidden_yn;

    @ApiModelProperty(example = "문의 비밀번호")
    public String qna_pw;

    @ApiModelProperty(example = "응답 여부")
    public String response_yn;

    @ApiModelProperty(example = "생성시간")
    public String created_at;

    @ApiModelProperty(example = "수정시간")
    public String updated_at;

    @ApiModelProperty(example = "생성자")
    public int created_id;

    @ApiModelProperty(example = "수정자")
    public int updated_id;

    @ApiModelProperty(example = "사용여부")
    public String use_yn;
}

