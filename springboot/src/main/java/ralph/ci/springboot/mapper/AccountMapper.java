package ralph.ci.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import ralph.ci.springboot.bean.Account;

/**
 * @author ralph
 * @create 2021-06-06 18:37
 */
@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
