package egovframework.admin.board.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "QNA 엔티티")
public class QnaEntity extends Qna {

    @ApiModelProperty(example = "순서")
    public int rnum;

    @ApiModelProperty(example = "작성자")
    public String created_nm;

    @ApiModelProperty(example = "답변자")
    public String updated_nm;

    @ApiModelProperty(example = "게시판 명")
    public String board_title;

    @ApiModelProperty(example = "문의 유형")
    public String qna_type_nm;

    @ApiModelProperty(example = "응답여부")
    public String response_yn_nm;

    @ApiModelProperty(example = "사용여부")
    public String use_yn_nm;
}