package MELT.TestDomain.domain;

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

    private String status;
    private String message;
    private Object data;
}
