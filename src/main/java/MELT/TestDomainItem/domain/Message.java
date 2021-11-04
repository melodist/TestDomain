package MELT.TestDomainItem.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-10-20 020
 * Time: 오후 9:09
 */
@Data
@AllArgsConstructor
public class Message {

    @ApiModelProperty(example = "상태코드")
    private String status;

    @ApiModelProperty(example = "메시지")
    private String message;

    @ApiModelProperty(example = "데이터")
    private Object data;
}
