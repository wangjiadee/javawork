package ralph.ci.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ralph
 * @create 2021-06-05 14:00
 */


@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
}
