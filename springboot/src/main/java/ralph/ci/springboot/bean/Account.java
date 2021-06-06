package ralph.ci.springboot.bean;

import lombok.Data;

/**
 * @author ralph
 * @create 2021-06-06 18:37
 */

@Data
public class Account {
    private Long id;
    private String userId;
    private Integer money;
}
